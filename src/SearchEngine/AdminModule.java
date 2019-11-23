package SearchEngine;

import Constant.StringVar;
import DataClass.Admin;
import DataClass.Student;
import DataClass.StudentRegistration;
import DataStructureClass.MyArrayList;
import DataStructureClass.MyList;
import java.util.Date;
import java.util.Scanner;

public class AdminModule {
    public static Scanner scan = new Scanner(System.in);
    private int index;
    private String input;

    public AdminModule() {
    }

    public AdminModule(int index) {

        this.index = index;

        Navigation();
    }

    public void Menu() {
        //Main.clearScreen();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("------** Admin Page **-------");
        System.out.println("Welcome, " + Main.db.adminList.get(index).getGender() + " " + Main.db.adminList.get(index).getName() + " ~");
        System.out.println("1. Search Student Detail");
        System.out.println("2. Register Student");
        System.out.println("3. Return");
        System.out.print("Your Selection ---> ");
    }

    public void Navigation() {

        while (true) {
            while (true) {
                Menu();
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(3, input)) {
                    break;
                }
            }

            if (input.equals("3")) {
                Main.clearScreen();
                break;
            }

            switch (input) {
                case "1":
                    searchStudentDetailUI();
                    break;

                case "2":
                    //RegisterStudent();
                    break;

            }

        }
    }

    public void ShowSearchDetail() {
        System.out.println("Please enter the student ID:");
        String ID = Main.scan.nextLine();

        for (int index = 0; index < Main.db.studentList.size(); index++) {
            if (ID.equals(Main.db.studentList.get(index).getStudentID())) {
                System.out.println("-----------------------------------------------------");
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_DETAIL));
                System.out.println("-----------------------------------------------------");
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_ID + Main.db.studentList.get(index).getStudentID()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_STATUS + Main.db.studentList.get(index).getStudyStatus()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_CGPA + Main.db.studentList.get(index).getCgpa()));
                System.out.println("----------------------------------------------------");
                System.out.println("Press Enter To Continue!");
                Main.scan.nextLine();
                System.out.println("");
                System.out.println("");
                break;
            } else {
                if (index == Main.db.studentList.size() - 1) {
                    System.out.println("Student ID doesn't exist!");
                    System.out.println("Please press again.");
                    break;
                }

            }
        }
    }

    public boolean validateEmptyInput(String input) {
        if (input.isEmpty()){
            System.out.println("Cannot be empty field!");
            return false;
        }
        else 
            return true;
        
    }
    
    public boolean integerVaidation(String input) {
        if (input.isEmpty()){
            System.out.println("Cannot be empty field!");
            return false;
        }
        try {
                int x = Integer.parseInt(input); 
                return true;
            }
            catch(NumberFormatException e) {
                System.out.println("Input is invalid!"); 
                return false;
            }
    }
    
    
    public void RegisterStudent(){
        
        //boolean result = true;
        String firstName;
        String lastName; 
        String ic;
        String education;
        Main.banner();
        
        while (true){
            System.out.print("First Name: ");
            firstName = scan.nextLine();
            
            if (validateEmptyInput(firstName)){
                break;
            }
        }    
        while (true){
            System.out.print("Last Name: ");
            lastName = scan.nextLine();
            
            if (validateEmptyInput(lastName)){
                break;
            }
        }
        while (true){
            System.out.print("Number of Identity Card (Number only): ");
            ic = scan.nextLine();
            if (integerVaidation(ic)){
                break;
            }             
        }
        
        while (true){
            System.out.print("Highest level of education: ");
            education = scan.nextLine();
            
            if (validateEmptyInput(education)){
                break;
            }
        }
        
        System.out.println("1. Confirm Register     " + "     2. Cancel Register");
        System.out.print("Your choice --> ");
        String confirmation = scan.nextLine();
        Main.checkInputMenu(2, confirmation);
       
        
        switch (confirmation) {
            case "1":

                Student newStudent = new Student(firstName, lastName, ic, education);
                Main.db.studentList.add(newStudent);
                StudentRegistration newRegistration = new StudentRegistration(new Date(), "approved", newStudent, Main.db.registerList.getLast());
                Main.db.registerList.add(newRegistration);
                
                System.out.println("");
                System.out.println("");
                System.out.println("** You are succeful registered **");
                System.out.println("You Student ID is "+newStudent.getStudentID());
                System.out.println("Default password is "+newStudent.getPassword());
                
                System.out.println("Press enter go back to menu...");
                String enter = scan.nextLine();
                break;
            
            case "2":
                System.out.println("Already cancel registration.");
                Navigation();
                
        }
 
//        System.out.println(Student.getCount());
//        System.out.println(StudentRegistration.getCount());
        

    }
    
    /**
     * ***********************************************************************
     */
    private void searchStudentDetailUI() {
        String input;
        while (true) {
            while (true) {
                Main.clearScreen();
                System.out.println("Seach Student Details : ");
                System.out.println("Please select your Criteria : ");
                System.out.println("1. Search By student ID");
                System.out.println("2. Search By Registration Status");
                System.out.println("3. Return");
                System.out.println("");
                System.out.print("Your Selection ---> ");
                input = Main.scan.nextLine();
                if (Main.checkInputMenu(3, input)) {
                    break;
                }

            }

            if (input.equals("3")) {
                break;
            }

            switch (input) {
                case "1":
                    ShowSearchDetail();
                    break;
                case "2":
                    searchByRegistrationStatus();
                    break;
            }

        }

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
                    //searchByApproved();
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
        MyList<StudentRegistration> registrationList = Main.db.registerList;
        int length = registrationList.size();
        int studentIndex = 1;
        String str = "";
        str += String.format("%-10s %-30s %-15s\n", "No.", "Registration ID", "Status");
        
        for (int i = 0; i < length; i++) {
            if (registrationList.get(i).getStatus() == "pending") {
                str += String.format("%-10s %-30s %-15s\n", studentIndex, registrationList.get(i).getRegistrationID() 
                        , registrationList.get(i).getStatus());
                studentIndex++;
            }
        }
        System.out.println(str);
        System.out.println("");
        System.out.println("");
        if (studentIndex == 1) {
            System.out.println("Currently No Pending Student Registration!");
        }
        System.out.println("Press Enter To Continue...");
        Main.scan.nextLine();

    }

}
