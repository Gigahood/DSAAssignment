package SearchEngine;

import Constant.ConsoleColors;
import Constant.StringVar;
import DataClass.Student;
import DataClass.StudentRegistration;
import DataStructureClass.MyList;
import java.text.SimpleDateFormat;
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
                    RegisterStudent();
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
            System.out.println(ConsoleColors.RED_BOLD + "CANNOT BE EMPTY FIELD!" + ConsoleColors.RESET);
            return false;
        }
        else if(!input.matches("[A-Za-z\\s]*$")){
            System.out.println(ConsoleColors.PURPLE_BOLD + "INVALID INPUT! Only Accepted Character." + ConsoleColors.RESET);
            return false;
        }
        else if(!input.matches("^(?=.*[A-Z])(?=.{2,}).+$")){    
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please enter at least one upcase character." + ConsoleColors.RESET);
            return false;
        }
        
        else 
            return true;
        
    }
    
    public boolean integerVaidation(String input) {
        if (input.isEmpty()){
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            return false;
        }
        else if (input.matches("^(?=.*\\d)")){
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET); 
                return false;
        }
        else if (input.length()!=12){
                System.out.println(ConsoleColors.BLUE_BOLD + "Please enter completed value!" + ConsoleColors.RESET);
                return false;
        }
        else 
            return true;
    }
    
    public static String centerString (int width, String s) {
        
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
    
    public void RegisterStudent(){
        
        //boolean result = true;
        String firstName;
        String lastName; 
        String ic;
        String education;
        Main.banner();
        String formating = "%1$-20s:";
        while (true){
            System.out.format(formating,"First Name");
            firstName = scan.nextLine();
            
            if (validateEmptyInput(firstName)){
                break;
            }
        }    
        while (true){
            System.out.format(formating,"Last Name");
            lastName = scan.nextLine();
            
            if (validateEmptyInput(lastName)){
                break;
            }
               
        }
        while (true){
            System.out.format(formating,"NIC (Number only)");
            ic = scan.nextLine();
            if (integerVaidation(ic)){
                break;
            }   
            
        }
        
        while (true){
            System.out.format(formating,"Education Background");
            education = scan.nextLine();
            
            if (validateEmptyInput(education)){
                break;
            }
        }
        
        System.out.println(ConsoleColors.GREEN_BOLD + "1. Confirm Register     "+ConsoleColors.RESET + ConsoleColors.PURPLE +"     2. Cancel Register"+ConsoleColors.RESET);
        System.out.print("Your choice --> ");
        String confirmation = scan.nextLine();
        Main.checkInputMenu(2, confirmation);
       
        
        switch (confirmation) {
            case "1":

                Student newStudent = new Student(firstName, lastName, ic, education);
                Main.db.studentList.add(newStudent);
                StudentRegistration newRegistration = new StudentRegistration(new Date(), "approved", newStudent);
                Main.db.registerList.add(newRegistration);
                
                System.out.println("");
                System.out.println("");
                
                
                String format = "*%1$-50s*\n";
                String title = centerString(42,"*** You are succeful registered ***");
                System.out.println(ConsoleColors.CYAN + title + ConsoleColors.RESET);
                System.out.format(format, "Your student ID is " + ConsoleColors.CYAN +newStudent.getStudentID() + ConsoleColors.RESET );
                System.out.format(format, "Password (Your IC No.) is " + ConsoleColors.CYAN + newStudent.getPassword() + ConsoleColors.RESET );
                
                 
                
                System.out.println("");
                System.out.println("Press enter go back to menu...");
                String enter = scan.nextLine();
                break;
            
            case "2":
                System.out.println(ConsoleColors.PURPLE_BOLD + "~~ Already cancel registration. ~~" + ConsoleColors.RESET);
                Navigation();
                
        }
 
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
                System.out.println("Currently No Pending Student Registration!");
                System.out.println("Press Enter To Continue...");
                Main.scan.nextLine();
            }

            System.out.println("");

            System.out.println("Please enter registration ID to view Student Details");
            System.out.println("Enter back to return");
            System.out.println("");
            System.out.print("Your selection ---> ");
            String selection = Main.scan.nextLine();

            if (selection.equals("back")) {
                break;
            }

            StudentRegistration student = validateRegistrationID(selection);

            if (student != null) {
                approveStudent(student);
            } else {
                System.out.println("Wrong input ");
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
