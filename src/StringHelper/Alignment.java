package StringHelper;

import Constant.StringVar;
import SearchEngine.Main;

public class Alignment {

    public static String Display(Integer width, String text, Type type) {
        switch (type) {
            case centerOnly:
                return Center(text, width);
            case centerWithAsterisk:
                return Center(text, width).replace(" ", "*");
            case withBorderOnly:
                return String.format("|%-" + width + "s|", text);
        }
        return null;
    }

    private static String Center(String text, int length) {
        String out = String.format("%" + length + "s%s%" + length + "s", "", text, "");

        float middle = (out.length() / 2);
        float start = middle - (length / 2);
        float end = start + length;

        return out.substring((int) start, (int) end);
    }

    public enum Type {
        centerWithAsterisk,
        withBorderOnly,
        centerOnly,
    }
}
