/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import StringHelper.Alignment;
import StringHelper.Validator;
import java.util.List;

/**
 *
 * @author JDCZW
 */
public class StudentMaintenance {

    private Student student;
    private int index;
    private String input;

//    public StudentMaintenance(Student student, int index) {
//        this.student = student;
//        this.index = index;
//    }
    public StudentMaintenance() {
        Navigation();
    }

    public void Navigation() {

        Student selection = new Student();
        List<Student> list;

        while (true) {
            while (true) {
                Menu();
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
                    System.out.print(StringVar.LBL_FIRST_NAME);
                    selection.setFirstName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selection, SearchOperation.SearchType.firstName);
                    DisplaySearchResult(list);
                    break;

                case "2":
                    System.out.print(StringVar.LBL_LAST_NAME);
                    selection.setLastName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selection, SearchOperation.SearchType.lastName);
                    DisplaySearchResult(list);
                    break;

                case "3":
                    System.out.print(StringVar.LBL_IC_NUMBER);
                    selection.setFirstName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selection, SearchOperation.SearchType.studentIC);
                    DisplaySearchResult(list);
                    break;

                case "4":
                    System.out.print(StringVar.LBL_STUDENT_ID);
                    selection.setStudentID(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selection, SearchOperation.SearchType.studentID);
                    DisplaySearchResult(list);
                    break;
            }
        }
    }

    private void DisplaySearchResult(List<Student> list) {
        Integer count = 0;
        if (list != null && list.size() > 0) {
            System.out.println(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|",
                    Alignment.Display(20, "No.", Alignment.Type.centerOnly),
                    Alignment.Display(20, "Student ID", Alignment.Type.centerOnly),
                    Alignment.Display(20, "IC", Alignment.Type.centerOnly),
                    Alignment.Display(20, "First Name", Alignment.Type.centerOnly),
                    Alignment.Display(20, "Last Name", Alignment.Type.centerOnly)));

            for (Student student : list) {
                count++;
                System.out.println(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|",
                        Alignment.Display(20, list.toArray().toString(), Alignment.Type.centerOnly),
                        Alignment.Display(20, student.getStudentID(), Alignment.Type.centerOnly),
                        Alignment.Display(20, student.getIc(), Alignment.Type.centerOnly),
                        Alignment.Display(20, student.getFirstName(), Alignment.Type.centerOnly),
                        Alignment.Display(20, student.getLastName(), Alignment.Type.centerOnly)));
            }

            while (true) {
                System.out.print("Select Record to Update ---> ");
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(list.size(), input)) {
                    break;
                }
            }

            EditStudentDetail();
        }
    }

    public void EditStudentDetail() {

        String ic;
        String firsName;
        String lastName;

        System.out.println(Alignment.Display(50, StringVar.LBL_STUDENT_DETAIL, Alignment.Type.centerOnly));

        switch (input) {
            case "1":
                while (true) {
                    System.out.println(Alignment.Display(50,
                            StringVar.LBL_CURRENT + StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc(),
                            Alignment.Type.withBorderOnly));
                    System.out.print(StringVar.LBL_NEW + StringVar.LBL_IC_NUMBER);
                    ic = Main.scan.nextLine();
                    if (!Validator.StringValidation(ic, Validator.TypeOfValidation.empty)) {
                        break;
                    }
                    if (!ic.equals(Main.db.studentList.get(index).getIc())) {
                        Main.db.studentList.get(index).setIc(ic);
                        break;
                    }
                }
                break;
            case "2":
                while (true) {
                    System.out.println(Alignment.Display(50,
                            StringVar.LBL_CURRENT + StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName(),
                            Alignment.Type.withBorderOnly));
                    System.out.print(StringVar.LBL_NEW + StringVar.LBL_FIRST_NAME);
                    firsName = Main.scan.nextLine();
                    if (!Validator.StringValidation(firsName, Validator.TypeOfValidation.empty)) {
                        break;
                    }

                    if (!firsName.equals(Main.db.studentList.get(index).getFirstName())) {
                        Main.db.studentList.get(index).setFirstName(firsName);
                        break;
                    }
                }
                break;
            case "3":
                while (true) {
                    System.out.println(Alignment.Display(50,
                            StringVar.LBL_CURRENT + StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName(),
                            Alignment.Type.withBorderOnly));
                    System.out.print(StringVar.LBL_NEW + StringVar.LBL_LAST_NAME);
                    lastName = Main.scan.nextLine();
                    if (Validator.StringValidation(lastName, Validator.TypeOfValidation.empty)) {
                        break;
                    }
                    if (lastName.equals(Main.db.studentList.get(index).getLastName())) {
                        Main.db.studentList.get(index).setLastName(lastName);
                        break;
                    }
                }
                break;
        }

//        if (UpdateStudentInformation(ic, firsName, lastName)) {
//            Main.db.studentList.replace(index, student);
//        }
    }

//    private Boolean UpdateStudentInformation(String ic, String firstName, String lastName) {
//
//        if (!firstName.equals(Main.db.studentList.get(index).getFirstName())) {
//            student.setFirstName(firstName);
//        }
//
//        if (!lastName.equals(Main.db.studentList.get(index).getLastName())) {
//            student.setLastName(lastName);
//        }
//
//        if (!ic.equals(Main.db.studentList.get(index).getIc())) {
//            student.setIc(ic);
//        }
//
//        if (student != null) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public void Menu() {
        System.out.println("Search By");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Student IC");
        System.out.println("4. Student ID");
        System.out.println("5. Return");
        System.out.print("Your Selection ---> ");
    }
}
