/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import DataClass.Student;
import DataClass.StudentRegistration;
import DataStructureClass.MyArrayList;

/**
 *
 * @author user
 */
public class SeachEduBackground {

    Student student;
    String eduBack;

    public SeachEduBackground() {
        start();
    }

    public void start() {
        String x;
        //call ui here
        SearchEduUI();

    }

    public void SearchEduUI() {
        String input;
        while (true) {
            while (true) { //inner while loop for checking
                System.out.println("What type of educational background you want to search? ");
                System.out.println("1. Foundation");
                System.out.println("2. Diploma");
                System.out.println("3. Form 6");
                System.out.println("4. A-Level");
                System.out.println("5. Return");
                input = Main.scan.nextLine();
                if (Main.checkInputMenu(5, input)) {
                    break;
                }
            }

            if (input.equals("5")) {
                break;
            }
            switch (input) {
                case "1":
                    retrieve_studentInfo("Foundation");
                    break;
                case "2":
                    retrieve_studentInfo("Diploma");
                    break;
                case "3":
                    retrieve_studentInfo("Form 6");
                    break;
                case "4":
                    retrieve_studentInfo("A-Level");
                    break;
            }
        }
    }

    public void retrieve_studentInfo(String eduBackground) {
        //declare student registration list
        //cpy database list to registration list that matched eduBackground
        //show the respective student info and that is approved
        //loop and continue until list it end of line
        StudentRegistration s = new StudentRegistration();
        MyArrayList<StudentRegistration> a = new MyArrayList<>();
        boolean nullList = true;
        for (int i = 0; i < Main.db.registerList.size(); i++) {
            s = Main.db.registerList.get(i);
            if (checkStatus(s, eduBackground) == true) {
                a.add(s);
                nullList = false;
            }
        }
        printStudentInfo(a, eduBackground, nullList);
        System.out.println("Press anything to continue... ");
        Main.scan.nextLine();
        Main.clearScreen();
    }

    public boolean checkStatus(StudentRegistration s, String edu) {
        boolean result = false;
        if ((s.getStatus().equals("approved") || s.getStatus().equals("Approved")) && (s.getStudent().getEduBackground().equals(edu))) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void printStudentInfo(MyArrayList a, String eduBackground, boolean x) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println("(-------------------------------------------------------------------）");
            System.out.println(a.get(i));
            System.out.println("(-------------------------------------------------------------------）");
            System.out.println();
        }
        if (x == true) {
            Main.clearScreen();
            System.out.println(ConsoleColors.BLUE_BOLD + "Oops! Seems like there are no approved students that come from " + eduBackground + "." + ConsoleColors.RESET);
        }
        System.out.println();
    }

}
