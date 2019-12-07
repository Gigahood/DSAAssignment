package SearchEngine;

import Constant.ConsoleColors;
import DataClass.StudentRegistration;

public class ApprovingStudentModule {

    public void start() {
        enterStudentIDUI();
    }

    private void enterStudentIDUI() {
        System.out.println("");
        System.out.println("Please enter Registration ID --> ");
        String id = Main.scan.nextLine();

        StudentRegistration student = validateRegistrationID(id);
        if (student != null) {
            approveStudent(student);
        }
    }

    private StudentRegistration validateRegistrationID(String registrationID) {
        int length = Main.db.registerList.size();

        if (registrationID.isEmpty() || registrationID == null) {
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            Main.scan.nextLine();
        } else if (!isNumeric(registrationID)) {
            System.out.println("");
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET);
            System.out.println("Press Enter To Continue");
            Main.scan.nextLine();
        } else {
            for (int i = 0; i < length; i++) {
                if (Main.db.registerList.get(i).getRegistrationID().equals(registrationID)) {
                    return Main.db.registerList.get(i);
                }
            }
            System.out.println(ConsoleColors.RED_BOLD + "No Such Registration ID" + ConsoleColors.RESET);
            System.out.println("Press enter to continue");
            Main.scan.nextLine();
        }
        return null;
    }

    private void approveStudent(StudentRegistration student) {
        String input2;
        boolean exit = false;
        while (true) {
            // menu selection start
            while (true) {
                Main.clearScreen();
                System.out.println("**************Approve Student*****************");
                System.out.println("");
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
                    if (confirmationApproved(student).equals("1")) {
                        student.setStatus("approved");
                        Main.db.studentList.add(student.getStudent());
                        System.out.println("");
                        System.out.println( "You Have Successfully Approve " +
                                ConsoleColors.YELLOW + student.getStudent().getFirstName()
                                + " " + student.getStudent().getLastName() + ConsoleColors.RESET
                                + " Registration!");
                        System.out.println("");
                        System.out.println("Press Enter To Continue");
                        Main.scan.nextLine();
                        exit = true;
                        break;
                    } 
                case "2":
                    student.setStatus("rejected");
                    break;
            }
            
            if (exit) {
                break;
            }
        }
    }

    private boolean isNumeric(String number) {
        try {
            double d = Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String confirmationApproved(StudentRegistration student) {
        String choice;
        while (true) {
            confirmUI(student);
            choice = Main.scan.nextLine();

            if (Main.checkInputMenu(2, choice)) {
                break;
            }
        }

        return choice;
    }

    private void confirmUI(StudentRegistration student) {
        Main.clearScreen();
        System.out.println("Are You Sure You Want To Approve " + ConsoleColors.YELLOW
                + student.getStudent().getFirstName()
                + " " + student.getStudent().getLastName() + ConsoleColors.RESET);

        System.out.println("");
        System.out.println("1. Yes");
        System.out.println("2. Cancel");
        System.out.println("");
        System.out.print("Your Selection --> ");
    }
}
