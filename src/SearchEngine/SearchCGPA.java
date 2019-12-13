/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.ConsoleColors;
import Constant.StringVar;
import DataClass.Student;
import DataStructureClass.MyArrayList;
import static SearchEngine.Main.scan;
import java.text.DecimalFormat;

/**
 *
 * @author User
 */
public class SearchCGPA {

    Student student;
    String cgpa;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void SearchCGPA() {

    }

    public void start() {
        SearchCGPAUI();
    }

    public void SearchCGPAUI() {
MyArrayList<Student> searchedList = new MyArrayList<>();
        
            while (true) {
                //System.out.println(Main.db.studentList.get(0).getCgpa());
                System.out.println("Please enter the CGPA");
                cgpa = scan.nextLine();
                
                if (isNumeric(cgpa)){
                    break;
                }
            }
            
            //Search(cgpa);
            
            searchCGPA(searchedList,cgpa);
            
            
            compare(searchedList, Double.parseDouble(cgpa));
        //

    }

    public boolean validate(String CGPA) {

        double dcgpa;
        boolean i;
        MyArrayList<Student> searchedList = new MyArrayList<>();
        try {
            dcgpa = Double.parseDouble(cgpa);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    
    public void searchCGPA(MyArrayList<Student> searchedList,String cgpa) {
        for(int i = 0; i < Main.db.studentList.size();i++){
            if(Main.db.studentList.get(i).getCgpa().equals(Double.parseDouble(cgpa))){
                searchedList.add(Main.db.studentList.get(i));
            }
        }
    }

    public void compare(MyArrayList<Student> searchedList, double cgpa) {
        Main.clearScreen();
        
        //System.out.println("123");

        String formating = "%1$-24s";
        String formatingB = "%1$-11s";
        System.out.println("********************* Searched Result *************************");

        System.out.format(formatingB, "ID");
        System.out.format(formating, "Name");
        System.out.format(formatingB, "CGPA");
        System.out.println("\n_________________________________________________________");

        if (searchedList.isEmpty()) {

            System.out.println("        " + "Currently No Student's CGPA is " + df2.format(cgpa));
            System.out.println("");
            System.out.println("_________________________________________________________");
        } else {

            for (int i = 0; i < searchedList.size(); i++) {
                System.out.println(searchedList.get(i).toStringbySearch());
                System.out.println("_________________________________________________________");

            }
        }
        System.out.println("                                    * Total Result : " + searchedList.size() + " *");
        System.out.println("");
        System.out.println("");

        confirm();

        System.out.println("Press 0 will be continue on searching, others will back to search menu-");
        System.out.print("Your Choice ->");
        String choice = Main.scan.nextLine();

        if (choice.equals(0)) {
            SearchCGPAUI();
        } else {
            AdminModule am = new AdminModule();
        }
    }

    public void confirm() {
        System.out.println("Please enter the students's id to view information, 0 to back to menu, 1 re-enter to search cgpa:");
        String id = scan.nextLine();

        if (id.equals("")) {
            if (id.equals("")) {
                System.out.println("It cannot leave blank!");
                System.out.println("Please enter the students's id to view information, 0 to back to menu, 1 re-enter to search cgpa:");
                id = scan.nextLine();
            }
        } else if (id.equals(0)) {
            AdminModule ad = new AdminModule();
        } else if (id.equals(1)) {
            SearchCGPA();
        }

        Search(id);

    }

    public void Search(String id) {
        boolean test = false;
        for (int i = 0; i < Main.db.studentList.size(); i++) {
            if (Main.db.studentList.get(i).getStudentID().equals(id)) {
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_DETAIL));
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_ID + Main.db.studentList.get(i).getStudentID()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_FIRST_NAME + Main.db.studentList.get(i).getFirstName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_LAST_NAME + Main.db.studentList.get(i).getLastName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_IC_NUMBER + Main.db.studentList.get(i).getIc()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_STATUS + Main.db.studentList.get(i).getStudyStatus()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_CGPA + Main.db.studentList.get(i).getCgpa()));
                test = true;
                break;
            }
            if (test = false) {
                System.out.println("The student's id doesn't exist!");
            }
        }
    }

    private boolean isNumeric(String input) {
        try {
            double d = Double.parseDouble(input);
            
            if (!(d >=0 && d <= 4.0)) {
                System.out.println("Number must be in range 0- 4.0");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
