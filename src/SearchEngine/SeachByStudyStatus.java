/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import DataClass.Student;
import DataStructureClass.MyArrayList;

/**
 *
 * @author User
 */
public class SeachByStudyStatus {

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

            }

            searchStudent(searchedList, status);
            displaySearchResult(searchedList, status);
        }// end looping module

    }

    private void menuUI() {
        System.out.println("*********Search By Study Status****************");
        System.out.println("");
        System.out.println("");
        System.out.println("Good - 'g', Probation - 'p', Warning - 'w' ");
        System.out.println("Please type in which status that you want to search : ");
        System.out.println("Press 0 to back to previous page.");
        System.out.println("");
        System.out.print("Your Choice --> ");
    }

    private boolean validateMenuInput(String s) {
        if (s.isEmpty()) {
            System.out.println("No Empty Space!");
            System.out.println("Press enter to continue");
            Main.scan.nextLine();
            return false;
        } else if (!s.equals("g") && !s.equals("p") && !s.equals("w") && !s.equals("f")&&!s.equals("0")) {
            System.out.println("Please type with the caracter of 'g', 'p', 'w' or 0 to back to menu.");
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

    private void displaySearchResult(MyArrayList<Student> searchedList, String status) {
        //Main.clearScreen();
        String formating = "%1$-20s";
        String formatingB = "%1$-10s";
        System.out.println("***************Searched Result*************************");
        System.out.println("");
        System.out.println("");
        System.out.format(formatingB,"ID");
                System.out.format(formating,"Name");
                System.out.format(formatingB,"CGPA");
                System.out.format(formating,"Status");
                System.out.println("\n_________________________________________________________");
                
                
        if (searchedList.isEmpty()) {
            System.out.println("Currently No Student Under " + status);
        } 
        else {
            for (int i = 0; i < searchedList.size(); i++) {
                
                System.out.println(searchedList.get(i).toStringbySearch());
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Search Result : " + searchedList.size());
        System.out.println("Press enter to continue");
        Main.scan.nextLine();
    }
}
