/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import static Constant.ConsoleColors.*;
import DataClass.Student;
import DataStructureClass.MyArrayList;
import java.util.Collections;

/**
 *
 * @author User
 */
public class SeachByStudyStatus {

    Student student;
    int index;

    public SeachByStudyStatus() {
    }

    public void start() {
        String choice;

        while (true) {
            while (true) {
                Main.clearScreen();
                menuUI();
                choice = Main.scan.nextLine();

                if (validateMenuInput(choice)) {
                    break;
                }
            } // end looping menu selection

            if (choice.equals("0")) {
                break;
            }

            choice = choice.toLowerCase();
            MyArrayList<Student> searchedList = new MyArrayList<>();
            setStatus();

            String status = "";

            switch (choice) {
                case "g":
                    status = "good";
                    break;
                case "p":
                    status = "probation";
                    break;
                case "w":
                    status = "warning";
                    break;
                case "f":
                    status = "final warning";
                    break;
            }

            searchStudent(searchedList, status);
            displaySearchResult(searchedList, status);
        }// end looping module

    }

    private void menuUI() {
        System.out.println("****************** Search By Study Status *******************");
        System.out.println("");
        System.out.println("");
        System.out.println(ConsoleColors.GREEN_BOLD + "/* " + "Good - 'g', Probation - 'p', Warning - 'w', Final Warning - 'f' " + " */" + ConsoleColors.RESET);
        System.out.println("");
        System.out.println("Please type in which status that you want to search : ");
        System.out.println("Press 0 to back to previous page.");
        System.out.println("");
        System.out.print("Your Choice --> ");
    }

    private boolean validateMenuInput(String s) {
        if (s.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "No Empty input!" + ConsoleColors.RESET);
            System.out.println("Press enter to continue");
            Main.scan.nextLine();
            return false;
        } else if (!s.equals("g") && !s.equals("p") && !s.equals("w") && !s.equals("f") && !s.equals("0")) {
            System.out.println(ConsoleColors.RED_BOLD + "Please type with the character of 'g', 'p', 'w' or 0 to back to menu." + ConsoleColors.RESET);
            System.out.println("Press enter to continue");
            Main.scan.nextLine();
            return false;
        }

        return true;
    }

    private void searchStudent(MyArrayList<Student> searchedList, String status) {
        int length = Main.db.studentList.size();
        //System.out.println(Main.db.studentList);

        for (int i = 0; i < length; i++) {
            //System.out.println(Main.db.studentList.get(i));
            if (Main.db.studentList.get(i).getStudyStatus().equals(status)) {
                searchedList.add(Main.db.studentList.get(i));
            }
        }
    }

    private void setStatus() {

        for (int i = 0; i < Main.db.studentList.size(); i++) {

            if (Main.db.studentList.get(i).getCgpa() >= 2.0) {
                Main.db.studentList.get(i).setStudyStatus("good");
            } else if (Main.db.studentList.get(i).getCgpa() < 2.0 && Main.db.studentList.get(i).getCgpa() >= 1.0) {
                Main.db.studentList.get(i).setStudyStatus("probation");
            } else {
                Main.db.studentList.get(i).setStudyStatus("warning");
            }
        }
    }

    public void displaySearchResult(MyArrayList<Student> searchedList, String status) {
        Main.clearScreen();

        String formating = "%1$-24s";
        String formatingB = "%1$-11s";
        System.out.println("********************* Searched Result *************************");

        System.out.format(formatingB, "ID");
        System.out.format(formating, "Name");
        System.out.format(formatingB, "CGPA");
        System.out.format(formatingB, "Status");
        System.out.println("\n_________________________________________________________");

        if (searchedList.isEmpty()) {

            System.out.println("        " + ANSI_YELLOW_BACKGROUND + ANSI_RED+ "  Currently No Student Under  "
                    + status + ANSI_RESET);
            System.out.println("");
            System.out.println("_________________________________________________________");
        } else {

            for (int i = 0; i < searchedList.size(); i++) {
                System.out.println(searchedList.get(i).toStringbySearch());
                System.out.println("_________________________________________________________");

            }
        }
        System.out.println(ANSI_CYAN_BACKGROUND + ANSI_PURPLE
                + "                                    * Total Result : " + searchedList.size() + " *"
                + ANSI_RESET);
        System.out.println("");
        System.out.println("");

        while (true) {

            System.out.println("Enter the student ID to search for the details.");
            System.out.println("Press 0 to go back to the menu~");
            System.out.print("Your Choice ->");
            String choice = Main.scan.nextLine();
            if (choice.equals("0")) {
                break;
            }
            if (!validate(choice, searchedList)) {

                System.out.println("");

                System.out.println("Press Enter to be continous.");
                Main.scan.nextLine();

                Main.clearScreen();
                displaySearchResult(searchedList, status);
                break;
            }
        }

    }

    private boolean validate(String id, MyArrayList<Student> searchedList) {

        if (id.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            return false;
        } else if (!isNumeric(id)) {
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in with integer." + ConsoleColors.RESET);
            return false;
        } else if (validID(id, searchedList)) {

            return false;
        } else {
            validID(id, searchedList);
        }
        return true;
    }

    private boolean validID(String id, MyArrayList<Student> searchedList) {
        for (int i = 0; i < searchedList.size(); i++) {
            if (searchedList.get(i).getStudentID().equals(id)) {

                index = i;
                student = searchedList.get(i);
                Main.clearScreen();
                System.out.println("------Students Information------");
                System.out.println(searchedList.get(i).toString());
                return true;
                // break;
            }
        }

        System.out.println(ConsoleColors.BLUE_BOLD + "Invalid ID! Please press again with the correct ID~" + ConsoleColors.RESET);
        // break;
        return true;
    }

    private boolean isNumeric(String input) {
        try {
            long d = Long.parseLong(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

//    private void printPage(MyArrayList<Student> searchedList) {
//
//        //int countPage = 1;
//        int i;
//
//        for (i = 0; i < searchedList.size(); i++) {
//
//            for (int j = i; j < 8; j++) {
//
//                System.out.println(searchedList.get(j).toStringbySearch());
//                System.out.println("_________________________________________________________");
//
//            }
//
//            //System.out.println("                                                page: " + countPage);
//            //countPage++;
//
////            System.out.println("press enter to next page.");
////            Main.scan.nextLine();
//
//        }
//
//    }

