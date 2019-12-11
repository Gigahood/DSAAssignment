package SearchEngine;

import Constant.ConsoleColors;
import Constant.StringVar;
import DataClass.Student;
import DataClass.StudentRegistration;
import DataStructureClass.MyList;
import StringHelper.Alignment;
import StringHelper.Validator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        System.out.println("3. Update Student Detail");
        System.out.println("4. Return");
        System.out.print("Your Selection ---> ");
    }

    public void Navigation() {

        while (true) {
            while (true) {
                Menu();
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(4, input)) {
                    break;
                }
            }

            if (input.equals("4")) {
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

                case "3":
                    SubNavigation();
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
        if (input.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "CANNOT BE EMPTY FIELD!" + ConsoleColors.RESET);
            return false;
        } else if (!input.matches("[A-Za-z\\s]*$")) {
            System.out.println(ConsoleColors.PURPLE_BOLD + "INVALID INPUT! Only Accepted Character." + ConsoleColors.RESET);
            return false;
        } else if (!input.matches("^(?=.{2,}).+$")) {
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please enter at least two characters." + ConsoleColors.RESET);
            return false;
        } else {
            return true;
        }

    }

    public boolean integerVaidation(String input) {
        if (input.isEmpty()) {
            System.out.println(ConsoleColors.RED_BOLD + "Cannot be empty field!" + ConsoleColors.RESET);
            return false;
        } else if (!isNumeric(input)) {
            System.out.println(ConsoleColors.BLUE_BOLD + "INVALID INPUT! Please key in number." + ConsoleColors.RESET);
            return false;
        } else if (input.length() != 12) {
            System.out.println(ConsoleColors.BLUE_BOLD + "Please enter completed value (12 digit)!" + ConsoleColors.RESET);
            return false;
        } else {
            return true;
        }
    }

    public static String centerString(int width, String s) {

        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void RegisterStudent() {

        //boolean result = true;
        String firstName;
        String lastName;
        String ic;
        String education;
        Main.banner();
        String formating = "%1$-20s:";
        while (true) {
            System.out.format(formating, "First Name");
            firstName = scan.nextLine();

            if (validateEmptyInput(firstName)) {
                break;
            }
        }
        while (true) {
            System.out.format(formating, "Last Name");
            lastName = scan.nextLine();

            if (validateEmptyInput(lastName)) {
                break;
            }

        }
        while (true) {
            System.out.format(formating, "NIC (Number only)");
            ic = scan.nextLine();
            if (integerVaidation(ic)) {
                break;
            }

        }

        while (true) {
            System.out.format(formating, "Education Background");
            education = scan.nextLine();

            if (validateEmptyInput(education)) {
                break;
            }
        }

        System.out.println(ConsoleColors.GREEN_BOLD + "1. Confirm Register     " + ConsoleColors.RESET + ConsoleColors.PURPLE + "     2. Cancel Register" + ConsoleColors.RESET);
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
                String title = centerString(42, "*** You are succeful registered ***");
                System.out.println(ConsoleColors.CYAN + title + ConsoleColors.RESET);
                System.out.format(format, "Your student ID is " + ConsoleColors.CYAN + newStudent.getStudentID() + ConsoleColors.RESET);
                System.out.format(format, "Password (Your IC No.) is " + ConsoleColors.CYAN + newStudent.getPassword() + ConsoleColors.RESET);

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
                System.out.println("3. Search By Student Name");
                System.out.println("4. Return");
                System.out.println("");
                System.out.print("Your Selection ---> ");
                input = Main.scan.nextLine();
                if (Main.checkInputMenu(4, input)) {
                    break;
                }

            }

            if (input.equals("4")) {
                break;
            }

            switch (input) {
                case "1":
                    ShowSearchDetail();
                    break;
                case "2":
                    SearchRegistrationStatus s = new SearchRegistrationStatus();
                    s.start();
                    break;
                case "3":
                    SearchName sn = new SearchName();
            }

        }

    }

    private boolean isNumeric(String input) {
        try {
            long d = Long.parseLong(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void SubNavigation() {

        String input;
        Student selected = new Student();
        List<Student> list;

        while (true) {
            while (true) {
                SubMenu();
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
                    selected.setFirstName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selected, SearchOperation.SearchType.firstName);
                    DisplaySearchResult(list);
                    break;

                case "2":
                    System.out.print(StringVar.LBL_LAST_NAME);
                    selected.setLastName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selected, SearchOperation.SearchType.lastName);
                    DisplaySearchResult(list);
                    break;

                case "3":
                    System.out.print(StringVar.LBL_IC_NUMBER);
                    selected.setFirstName(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selected, SearchOperation.SearchType.studentIC);
                    DisplaySearchResult(list);
                    break;

                case "4":
                    System.out.print(StringVar.LBL_STUDENT_ID);
                    selected.setStudentID(Main.scan.nextLine());
                    list = SearchOperation.SearchByResult(selected, SearchOperation.SearchType.studentID);
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
                        Alignment.Display(20, count.toString(), Alignment.Type.centerOnly),
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

    private Student student;

    public void EditStudentDetail() {

        String ic;
        String firsName;
        String lastName;

        System.out.println(Alignment.Display(50, StringVar.LBL_STUDENT_DETAIL, Alignment.Type.centerOnly));

        while (true) {
            System.out.println(Alignment.Display(50,
                    StringVar.LBL_CURRENT + StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc(),
                    Alignment.Type.withBorderOnly));
            System.out.print(StringVar.LBL_NEW + StringVar.LBL_IC_NUMBER);
            ic = Main.scan.nextLine();
            if (Validator.StringValidation(ic, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(Alignment.Display(50,
                    StringVar.LBL_CURRENT + StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName(),
                    Alignment.Type.withBorderOnly));
            System.out.print(StringVar.LBL_NEW + StringVar.LBL_FIRST_NAME);
            firsName = Main.scan.nextLine();
            if (Validator.StringValidation(firsName, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(Alignment.Display(50,
                    StringVar.LBL_CURRENT + StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName(),
                    Alignment.Type.withBorderOnly));
            System.out.print(StringVar.LBL_NEW + StringVar.LBL_LAST_NAME);
            lastName = Main.scan.nextLine();
            if (Validator.StringValidation(lastName, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        if (UpdateStudentInformation(ic, firsName, lastName)) {
            Main.db.studentList.replace(index, student);
        }
    }

    private Boolean UpdateStudentInformation(String ic, String firstName, String lastName) {

        if (!firstName.equals(Main.db.studentList.get(index).getFirstName())) {
            student.setFirstName(firstName);
        }

        if (!lastName.equals(Main.db.studentList.get(index).getLastName())) {
            student.setLastName(lastName);
        }

        if (!ic.equals(Main.db.studentList.get(index).getIc())) {
            student.setIc(ic);
        }

        if (student != null) {
            return true;
        } else {
            return false;
        }
    }

    public void SubMenu() {
        System.out.println("Search By");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Student IC");
        System.out.println("4. Student ID");
        System.out.println("5. Return");
        System.out.print("Your Selection ---> ");
    }
}
