/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import DataClass.StudentRegistration;
import DataStructureClass.MyList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class SearchRegistrationStatus {

    public void start() {
        searchByRegistrationStatus();
    }

    private void searchByRegistrationStatus() {
        String input;

        while (true) {
            //menu selection start
            while (true) {
                searchByRegistrationStatusUI();
                input = Main.scan.nextLine();

                // using check input method to validate only number will be entered
                if (Main.checkInputMenu(4, input)) {
                    break;
                }

            }// menu selection end

            if (input.equals("4")) {
                break;
            }

            switch (input) {
                case "1":
                    searchByPending();
                    break;
                case "2":
                    //searchByRejected();
                    break;
                case "3":
                    searchByApproved();
                    break;
            }
        }
    }

    private void searchByRegistrationStatusUI() {
        Main.clearScreen();
        System.out.println("Search Student Detail : ");
        System.out.println("");
        System.out.println("Please enter Registration Status that you want to search");
        System.out.println("1. Pending");
        System.out.println("2. Rejected");
        System.out.println("3. Approved");
        System.out.println("4. Return");
        System.out.println("");
        System.out.print("Your Selection ---> ");
    }

    private void searchByPending() {
        while (true) {
            Main.clearScreen();
            // format for displaying date
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
            String str = "";

            System.out.println("***Searched Result with Pending Status***");
            System.out.println("");
            System.out.println("Today Date : " + ft.format(new Date()));
            System.out.println("");
            MyList<StudentRegistration> registrationList = Main.db.registerList;
            int length = registrationList.size();
            int studentIndex = 1;

            // title of the search result
            str += String.format("%-10s %-30s %-30s %-20s %-15s\n",
                    "No.", "Registration ID", "Pending Time", "Register Date", "Status");

            for (int i = 0; i < length; i++) {
                if (registrationList.get(i).getStatus().equals("pending")) {
                    str += String.format("%-10s %-30s %-30s %-20s %-15s\n",
                            studentIndex,
                            registrationList.get(i).getRegistrationID(),
                            getDayDifference(registrationList.get(i).getRegistrationDate().getTime()) + " days ago",
                            ft.format(registrationList.get(i).getRegistrationDate()),
                            ConsoleColors.YELLOW + registrationList.get(i).getStatus() + ConsoleColors.RESET);
                    studentIndex++;
                }
            }
            System.out.println(str);
            System.out.println("");
            System.out.println("***Total " + (studentIndex - 1) + " Students***");
            System.out.println("");
            if (studentIndex == 1) {
                System.out.println(ConsoleColors.RED_BOLD + "Currently No Pending Student Registration!" + ConsoleColors.RESET);
                System.out.println("Press Enter To Continue...");
                Main.scan.nextLine();
            }

            System.out.println("");

            System.out.println("Please enter registration ID to view Student Details");
            System.out.println("");
            System.out.println("*** Enter back or 0 to return *** ");
            System.out.println("");
            System.out.print("Your selection ---> ");
            String selection = Main.scan.nextLine();

            if (selection.toUpperCase().equals("BACK") || selection.equals("0")) {
                break;
            }

            StudentRegistration student = validateRegistrationID(selection);

            if (student != null) {
                approveStudent(student);
            } else {
                System.out.println(ConsoleColors.RED_BOLD + "No Such Student" + ConsoleColors.RESET);
                System.out.println("Press enter to continue");
                Main.scan.nextLine();

            }
        }
    }

    private void searchByApproved() {
        Main.clearScreen();
        System.out.println("***Searched Result with Approved Status***");
        MyList<StudentRegistration> registrationList = Main.db.registerList;
        int length = registrationList.size();
        int studentIndex = 1;
        String str = "";
        str += String.format("%-10s %-30s %-15s\n", "No.", "Registration ID", "Status");

        for (int i = 0; i < length; i++) {
            if ("approved".equals(registrationList.get(i).getStatus())) {
                str += String.format("%-10s %-30s %-15s\n", studentIndex, registrationList.get(i).getRegistrationID(),
                        (ConsoleColors.CYAN + registrationList.get(i).getStatus() + ConsoleColors.RESET));
                studentIndex++;
            }
        }
        System.out.println(str);
        System.out.println("");
        System.out.println("");
        if (studentIndex == 1) {
            System.out.println("Currently No Approved Student Registration!");
        }
        System.out.println("Press Enter To Continue...");
        Main.scan.nextLine();
    }

    private StudentRegistration validateRegistrationID(String registrationID) {
        int length = Main.db.registerList.size();

        for (int i = 0; i < length; i++) {
            if (Main.db.registerList.get(i).getRegistrationID().equals(registrationID)) {
                return Main.db.registerList.get(i);
            }
        }

        return null;
    }

    private void approveStudent(StudentRegistration student) {
        String input2;
        while (true) {
            // menu selection start
            while (true) {
                Main.clearScreen();
                System.out.println(student);
                System.out.println("");
                System.out.println("");
                System.out.println("Please select an action : ");
                System.out.println("1. Approved");
                System.out.println("2. Reject");
                System.out.println("3. Return");
                System.out.println("");
                System.out.print("Your Selection ---> ");
                input2 = Main.scan.nextLine();

                if (Main.checkInputMenu(3, input2)) {
                    break;
                }
            } // menu selection end

            // if 4 end program else go into the category
            if (input2.equals("3")) {
                break;
            }

            switch (input2) {
                case "1":
                    student.setStatus("approved");
                    Main.db.studentList.add(student.getStudent());
                    break;
                case "2":
                    student.setStatus("rejected");
                    break;
            }
            break;
        }
    }

    private long getDayDifference(long time) {
        // something new here
        long days;
        long todayTime = new Date().getTime();

        days = (todayTime - time) / (1000 * 60 * 60 * 24);

        return days;
    }
}
