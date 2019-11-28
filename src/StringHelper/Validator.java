package StringHelper;

import Constant.ConsoleColors;

public class Validator {

    public static boolean StringValidation(String text, TypeOfValidation type) {
        switch (type) {
            case name:
                if (text.isEmpty()) {
                    DisplayError("CANNOT BE EMPTY FIELD!");
                    return false;
                } else if (!text.matches("[A-Za-z\\s]*$")) {
                    DisplayError("INVALID INPUT! Only Accepted Character.");
                    return false;
                } else if (!text.matches("^(?=.*[A-Z])(?=.{2,}).+$")) {
                    DisplayError("INVALID INPUT! Please enter at least one upcase character.");
                    return false;
                } else {
                    return true;
                }

            case ic:
                if (text.isEmpty()) {
                    DisplayError("Cannot be empty field!");
                    return false;
                } else if (text.matches("^(?=.*\\d)")) {
                    DisplayError("INVALID INPUT! Please key in number.");
                    return false;
                } else if (text.length() != 12) {
                    DisplayError("Please enter completed value!");
                    return false;
                } else {
                    return true;
                }
                
            case empty:
                if (text.isEmpty()) {
                    DisplayError("Cannot be empty field!");
                    return false;
                } else {
                    return true;
                }

            default:
                break;
        }

        return false;
    }

    public static void DisplayError(String text) {
        System.out.println(ConsoleColors.BLUE_BOLD + text + ConsoleColors.RESET);
    }

    public static enum TypeOfValidation {
        name,
        ic,
        empty
    }
}