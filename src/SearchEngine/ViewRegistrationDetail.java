/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import static Constant.StringVar.*;
import DataClass.StudentRegistration;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ViewRegistrationDetail {

    //        System.out.println("This is ViewRegistrationDetail");
    Scanner s = new Scanner(System.in);
    String num;
    String ic;
    int counter = 0;
    boolean result = true;

    public ViewRegistrationDetail() {
        // provide back button
        inputScreen();

    }

    private void inputScreen() {
        System.out.println("Please enter your Registration Number");
        num = s.nextLine();
        System.out.println("Please enter your password: ");
        ic = s.nextLine();
        counter = 0;
        while (counter < 4) {
            if (validateField(num, ic) == true) {
                if (matchRegistrationID() == true) {
                    break;
                }
            } else {
                System.out.println("Please enter your Registration Number");
                num = s.nextLine();
                System.out.println("Please enter your password: ");
                ic = s.nextLine();
            }

        }
        if (counter > 5) {
            System.out.println("Exceed amount of tries");
            Main.mainMenu();
        }

    }

    private boolean validateField(String num, String ic) {
        //validation
        if (num.isEmpty() == true || ic.isEmpty() == true) {
            System.out.println(ConsoleColors.RED_BOLD + MSG_EMPTY + ConsoleColors.RESET);
            result = false;
        } else if (!num.matches("[0-9]+")) {
            System.out.println(ConsoleColors.RED_BOLD + "Registration ID can only have digit ." + ConsoleColors.RESET);
            result = false;
        } else if (num.length() != 9) {
            System.out.println(ConsoleColors.RED_BOLD + "Incorrect length for registration ID ." + ConsoleColors.RESET);
            result = false;
        } else {
            result = true;
        }
        //trace counter
        if (result == false) {
            counter++;
        }
        return result;
    }

    private boolean matchRegistrationID() {
        boolean flag2 = false;
        boolean flag3 = false;
        //2 = ID is incorrect
        //3 = ID is not exist and/or incorrect password
        for (int i = 0; i < Main.db.registerList.size(); i++) {
            flag2 = false;
            flag3 = false;
            StudentRegistration student = Main.db.registerList.get(i);
            if (num.equals(student.getRegistrationID()) && ic.equals(student.getPassword())) {
                if (student.getStatus().equals("approved")) {
                    System.out.println("Your registration status has been approved. ");

//                    System.out.println("Your Student ID is " + student.getStudent().getStudentID());
                } else if (student.getStatus().equals("rejected")) {
                    System.out.println("Your registration has been rejected. ");
                } else {
                    System.out.println("Your current registration status is : " + student.getStatus());
                }
                break;
            } else if (num.equals(student.getRegistrationID()) && !(ic.equals(student.getPassword()))) {

                flag2 = true;
            } else if (!num.equals(student.getRegistrationID()) && !(ic.equals(student.getPassword()))) {
                flag3 = true;
            }

        }
        // show error message after loop
        if (flag2 == true) {
            System.out.println(ConsoleColors.RED_BOLD + "The Registration ID is incorrect. " + ConsoleColors.RESET);
        }
        if (flag3 == true) {
            System.out.println(ConsoleColors.RED_BOLD + "Invalid Registration ID or password.  " + ConsoleColors.RESET);
        }
        //trace counter
        if (flag2 == true || flag3 == true) {
            counter++;
        }
        return !(flag2 || flag3);
    }

}
