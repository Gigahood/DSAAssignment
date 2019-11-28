package StringHelper;

public class Alignment {

    public static String Center(Integer width, String text, Boolean withAsterisk) {
        if (withAsterisk) {
            return String.format("%-" + width + "s", String.format("%" + (text.length() + (width - text.length()) / 2) + "s", text).replace(" ", "*"));
        } else {
            return String.format("%-" + width + "s", String.format("%" + (text.length() + (width - text.length()) / 2) + "s", text));
        }
    }
}