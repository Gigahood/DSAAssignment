/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import DataClass.StudentRegistration;
import DataStructureClass.MyArrayList;
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
        Main.clearScreen();

        int length2;
        int page;
        int currentPage = 1;
        int min;
        int max;
        int studentIndex;

        while (true) {
            MyList<StudentRegistration> approvedList = new MyArrayList<>();
            searchPendingList(approvedList);

            if (approvedList.isEmpty()) {
                
                SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

                System.out.println("***Searched Result with Pending Status***");
                System.out.println("");
                System.out.println("Today Date : " + ft.format(new Date()));
                System.out.println("");
                
                System.out.println(ConsoleColors.RED_BOLD + "Currently No Pending Student" + ConsoleColors.RESET);
                
                System.out.println("Press Enter To back");
                Main.scan.nextLine();
                break;
                
            } else {
                length2 = approvedList.size();

                page = getPageSize(length2);
                min = getMin(currentPage);
                max = getMax(currentPage, page, length2);
                studentIndex = getStudentIndex(min);
                String code;
                String input;

                printApprovedList(approvedList, min, max, studentIndex);
                System.out.println("");
                System.out.println("Page : " + currentPage + " / " + page);
                System.out.println("Total Number of Students : " + length2);
                System.out.println("");
                String navigationCode = printNavigation(currentPage, page);

                //validateNavigationCode(navigationCode);
                System.out.println("");
                System.out.print("Your Choice --> ");
                input = Main.scan.nextLine();

                code = getCode(navigationCode, input);

                /*
                1. Next page
                2. Previous Page
                3. Approve Student
                4. Return
                5. Out of Range
                6. Empty
                7. Not number
                 */
                if (code.equals("4")) {
                    break;
                }

                switch (code) {
                    case "1":
                        currentPage++;
                        break;
                    case "2":
                        currentPage--;
                        break;
                    case "3":
                        ApprovingStudentModule asm = new ApprovingStudentModule();
                        asm.start();
                        
                        currentPage = 1;
                        break;
                    case "5":
                        System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number within range!!" + ConsoleColors.RESET);
                        Main.scan.nextLine();
                        break;
                    case "6":
                        System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
                        Main.scan.nextLine();
                        break;
                    case "7":
                        System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET);
                        Main.scan.nextLine();
                        break;
                }
                Main.clearScreen();

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


    private long getDayDifference(long time) {
        // something new here
        long days;
        long todayTime = new Date().getTime();

        days = (todayTime - time) / (1000 * 60 * 60 * 24);

        return days;
    }

    public int getPageSize(int length) {
        int page = length / 5;

        if (length % 5 != 0) {
            page++;
        }

        return page;
    }

    private void printApprovedList(MyList<StudentRegistration> approvedList, int min, int max, int index) {
        // title of the search result
        String str = "";
        int studentIndex = index;
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");

        System.out.println("***Searched Result with Pending Status***");
        System.out.println("");
        System.out.println("Today Date : " + ft.format(new Date()));
        System.out.println("");

        str += String.format("%-10s %-30s %-30s %-20s %-15s\n",
                "No.", "Registration ID", "Pending Time", "Register Date", "Status");
        for (int i = min; i < max; i++) {
            str += String.format("%-10s %-30s %-30s %-20s %-15s\n",
                    studentIndex,
                    approvedList.get(i).getRegistrationID(),
                    getDayDifference(approvedList.get(i).getRegistrationDate().getTime()) + " days ago",
                    ft.format(approvedList.get(i).getRegistrationDate()),
                    ConsoleColors.YELLOW + approvedList.get(i).getStatus() + ConsoleColors.RESET);
            studentIndex++;
        }

        System.out.println(str);
    }

    public int getMin(int currentPage) {
        return (currentPage - 1) * 5;
    }

    public int getMax(int currentPage, int maxPage, int length) {
        if (currentPage == maxPage) {
            return length;
        } else {
            return currentPage * 5;
        }
        //return currentPage * 5;
    }

    public int getStudentIndex(int min) {
        return min + 1;
    }

    private String printNavigation(int currentPage, int maxPage) {
        if (currentPage == maxPage && currentPage != 1) {
            System.out.println("1. Previous Page");
            System.out.println("2. Approve Student");
            System.out.println("3. Return");
            return "1";
        } else if (currentPage == 1 && currentPage != maxPage) {
            System.out.println("1. Next Page");
            System.out.println("2. Approve Student");
            System.out.println("3. Return");
            return "2";
        } else if (currentPage == maxPage && currentPage == 1) {
            System.out.println("1. Approve Student");
            System.out.println("2. Return");
            return "3";
        } else {
            System.out.println("1. Next Page");
            System.out.println("2. Previous Page");
            System.out.println("3. Approve Student");
            System.out.println("4. Return");
            return "4";
        }
    }

    /*
    1. Next page
    2. Previous Page
    3. Approve Student
    4. Return
     */
    private String getCode(String navigationCode, String input) {
        String code = "";
        switch (navigationCode) {
            case "1":
                switch (input) {
                    case "1":
                        code = "2";
                        break;
                    case "2":
                        code = "3";
                        break;
                    case "3":
                        code = "4";
                        break;
                    default:
                        code = "5";
                        break;
                }
                break;
            case "2":
                switch (input) {
                    case "1":
                        code = "1";
                        break;
                    case "2":
                        code = "3";
                        break;
                    case "3":
                        code = "4";
                        break;
                    default:
                        code = "5";
                        break;
                }
                break;
            case "3":
                switch (input) {
                    case "1":
                        code = "3";
                        break;
                    case "2":
                        code = "4";
                        break;
                    default:
                        code = "5";
                        break;
                }
                break;
            case "4":
                switch (input) {
                    case "1":
                        code = "1";
                        break;
                    case "2":
                        code = "2";
                        break;
                    case "3":
                        code = "3";
                        break;
                    case "4":
                        code = "4";
                        break;
                    default:
                        code = "5";
                        break;
                }
                break;
//            default:
//                code = "5";
//                break;
        }

        if (input.isEmpty()) {
            code = "6";
        } else {
            try {
                int inputInt = Integer.parseInt(input);
            } catch (Exception e) {
                code = "7";
            }
        }

        return code;
    }
    
    public void searchPendingList(MyList<StudentRegistration> approvedList) {
        MyList<StudentRegistration> registrationList = Main.db.registerList;
        
        int length = registrationList.size();
        
        for (int i = 0; i < length; i++) {
                if (registrationList.get(i).getStatus().equals("pending")) {
                    approvedList.add(registrationList.get(i));
                }
        }
    }
}
