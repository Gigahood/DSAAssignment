package SearchEngine;

import Constant.StringVar;
import DataClass.Admin;
import DataClass.Student;
import DataClass.StudentRegistration;
import java.util.Date;

public class AdminModule {

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
        System.out.println("Welcome, "+Main.db.adminList.get(index).getGender()+" "+Main.db.adminList.get(index).getName()+" ~");
        System.out.println("1. Search Detail");
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
                    ShowSearchDetail();
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
    
//    public void RegisterStudent(){
//        Main.banner();
//        System.out.print("First Name: ");
//        String firstName=Main.scan.nextLine();
//        System.out.print("Last Name: ");
//        String lastName=Main.scan.nextLine();
//        
//        System.out.print("Number of Identity Card: ");
//        String ic=Main.scan.nextLine();
//        
//        System.out.print("Highest level of education: ");
//        String education=Main.scan.nextLine();
//        
//        System.out.println(Student.getCount());
//                System.out.println(StudentRegistration.getCount());
//        
//        Student newStudent = new Student(firstName, lastName, ic,education);
//        StudentRegistration newRegister = new StudentRegistration(new Date(), "approved", newStudent);
//        Main.db.registerList.add(newRegister);
//                
//        System.out.println(Student.getCount());
//                System.out.println(StudentRegistration.getCount());
//        
//        Main.db.studentList.add(newStudent);
//        
//        System.out.println(Student.getCount());
//                System.out.println(StudentRegistration.getCount());
//        
//        System.out.println("");
//        System.out.println("");
//        System.out.println(Main.db.studentList.size());
//        System.out.println(Main.db.studentList.get(1));
//        System.out.println(Student.getCount());
//        System.out.println(StudentRegistration.getCount());
//        
//        Main.scan.nextLine();
//        
//    }
    
}
