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
    boolean flag2 = false;
    boolean flag3 = false;

    public ViewRegistrationDetail() {
        // provide back button
        
    }
    
    public void start() {
        counter = 0;
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
                } else {
                    System.out.println("Please enter your Registration Number");
                    num = s.nextLine();
                    System.out.println("Please enter your password: ");
                    ic = s.nextLine();
                }
            } else {
                System.out.println("Please enter your Registration Number");
                num = s.nextLine();
                System.out.println("Please enter your password: ");
                ic = s.nextLine();
            }

        }
        if (counter >= 4) {
            System.out.println("Exceed amount of tries");

            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
            System.out.println();
            System.out.println();
            System.out.println();
            Main.mainMenu();
        }

    }

    public boolean validateField(String num, String ic) {
        //validation
        if (num.isEmpty() == true || ic.isEmpty() == true) {
            System.out.println(ConsoleColors.RED_BOLD + MSG_EMPTY + ConsoleColors.RESET);
            Main.clearScreen();
            result = false;
        } else if (!num.matches("[0-9]+")) {
            Main.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "Registration ID can only have digit ." + ConsoleColors.RESET);
            result = false;
        } else if (num.length() != 9) {
            Main.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "Incorrect length for registration ID ." + ConsoleColors.RESET);
            result = false;
        } else {
            result = true;
        }
        //trace counter
        if (result == false) {
            System.out.println(ConsoleColors.RED_BOLD + "You have " + (4 - counter) + " trials left" + ConsoleColors.RESET);
            System.out.println();
            counter++;
        }
        return result;
    }

    public boolean matchRegistrationID() {

        //2 = ID is incorrect
        //3 = ID is not exist and/or incorrect password
        for (int i = 0; i < Main.db.registerList.size(); i++) {
            flag2 = false;
            flag3 = false;
            StudentRegistration student = Main.db.registerList.get(i);
            if (num.equals(student.getRegistrationID()) && ic.equals(student.getPassword())) {
                if (student.getStatus().equals("approved")) {
                    Main.clearScreen();
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println("Your registration status has been "
                            + ConsoleColors.GREEN_BOLD_BRIGHT + " approved" + ConsoleColors.RESET + ". ");
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println();
                    System.out.println();
                    System.out.println();

//                    System.out.println("Your Student ID is " + student.getStudent().getStudentID());
                } else if (student.getStatus().equals("rejected")) {
                    Main.clearScreen();
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println("Your registration has been "
                            + ConsoleColors.RED_BOLD_BRIGHT + " rejected" + ConsoleColors.RESET + ". ");
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                } else {
                    Main.clearScreen();
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println("Your current registration status is : "
                            + ConsoleColors.YELLOW_BOLD_BRIGHT+ student.getStatus() + ConsoleColors.RESET + ". ");
                    System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "*******************************************************************" + ConsoleColors.RESET);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
                break;
            } else if (num.equals(student.getRegistrationID()) && !(ic.equals(student.getPassword()))) {

                flag2 = true;
                break;
            } else if (!(num.equals(student.getRegistrationID())) && !(ic.equals(student.getPassword()))) {
                flag3 = true;
            }

        }

        // show error message after loop
        if (flag2 == true) {
            Main.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "The Password is incorrect. " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BOLD + "You have " + (4 - counter) + " trials left" + ConsoleColors.RESET);
            System.out.println();

        } else if (flag3 == true) {
            Main.clearScreen();
            System.out.println(ConsoleColors.RED_BOLD + "Invalid Registration ID or password.  " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED_BOLD + "You have " + (4 - counter) + " trials left" + ConsoleColors.RESET);
            System.out.println();
        }
        //trace counter
        if (flag2 == true || flag3 == true) {
            counter++;
        }
        return !(flag2 || flag3);
    }
    
    public void setVariable(String num, String ic) {
        this.num = num;
        this.ic = ic;
    }

}
