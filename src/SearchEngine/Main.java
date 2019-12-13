package SearchEngine;

import Constant.ConsoleColors;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static Database db = new Database();

    public static void main(String[] args) {
        mainMenu();
        //test();

    }

//    private static void test() {
//  
//    }
    private static void test() {
        String str = "";
        str += String.format("%-20s %-10s", "StudentID", "student Name\n");
        str += String.format("123", "213123213\n");
        str += String.format("%-20s %-10s", "123123231231231", "213123213");
        System.out.println(str);
    }

    public static void mainMenu() {
        String input;

        while (true) {
            // menu selection start
            while (true) {
                banner();
                mainMenuUI();
                input = scan.nextLine();

                if (checkInputMenu(4, input)) {
                    break;
                }
            } // menu selection end

            // if 4 end program else go into the category
            if (input.equals("4")) {
                break;
            }

            switch (input) {
                case "1":
                    new Login();
                    break;
                case "2":
                    ViewRegistrationDetail v1 = new ViewRegistrationDetail();
                    v1.start();
                    break;
                case "3":
                    new Registration();
                    break;
            }
        }
    }

    private static void mainMenuUI() {
        System.out.println("");
        System.out.println("Please enter your selection : ");
        System.out.println("1. Login");
        System.out.println("2. View Registration Status");
        System.out.println("3. Register");
        System.out.println("4. Exit");
        System.out.println("");
        System.out.print("Your Selection ---> ");
    }

    public static boolean checkInputMenu(int limit, String input) {
        if (input.isEmpty()) {
            System.out.println("");
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            Main.scan.nextLine();
            Main.clearScreen();
            return false;
        }

        try {
            int inputInt = Integer.parseInt(input);
            boolean valid = ((inputInt >= 1 && inputInt <= limit));

            if (!valid) {
                System.out.println("");
                System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number within range!!" + ConsoleColors.RESET);
                System.out.println("Press Enter To Continue");
                Main.scan.nextLine();
                Main.clearScreen();
            }

            return valid;
        } catch (Exception e) {
            System.out.println("");
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            Main.scan.nextLine();
            Main.clearScreen();
            return false;
        }
    }


    public static void banner() {
        System.out.println("-----------------------");
        System.out.println("   Welcome To TARUC    ");
        System.out.println("-----------------------");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
