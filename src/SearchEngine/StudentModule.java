package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import StringHelper.Alignment;
import StringHelper.Validator;

public class StudentModule {

    private Student student;
    private int index;
    private String input;

    public StudentModule(Student student, int index) {
        this.student = student;
        this.index = index;

        Navigation();
    }

    public void ShowStudentDetail() {
        System.out.println(Alignment.Center(50, StringVar.LBL_STUDENT_DETAIL, false));
        System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_ID + Main.db.studentList.get(index).getStudentID()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_STATUS + Main.db.studentList.get(index).getStudyStatus()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_CGPA + Main.db.studentList.get(index).getCgpa()));
        System.out.println();
        System.out.println(Alignment.Center(50, StringVar.LBL_CONTACT_DETAIL, false));
        System.out.println(String.format("|%-50s|", StringVar.LBL_CONTACT_NUMBER + Main.db.studentList.get(index).getContactNumber()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_ADDRESS + Main.db.studentList.get(index).getAddress()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_POSTCODE + Main.db.studentList.get(index).getPostcode()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_CITY + Main.db.studentList.get(index).getCity()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_STATE + Main.db.studentList.get(index).getState()));
        System.out.println();
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
                break;
            }

            switch (input) {
                case "1":
                    ShowStudentDetail();
                    break;
                case "2":
                    EditStudentDetail();
                    break;
                case "3":
                    EditLoginCredential();
                    break;
            }
        }
    }

    public void Menu() {
        System.out.println("Student Module");
        System.out.println("1. View Student Detail");
        System.out.println("2. Edit Student Detail");
        System.out.println("3. Edit Login Credential");
        System.out.println("4. Return");
        System.out.print("Your Selection ---> ");
    }

    private void EditStudentDetail() {
        String contactNumber;
        String address;
        String postcode;
        String city;
        String state;

        System.out.println(Alignment.Center(50, StringVar.LBL_STUDENT_DETAIL, false));

        while (true) {
            System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_CONTACT_NUMBER + Main.db.studentList.get(index).getContactNumber()));
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_CONTACT_NUMBER));
            contactNumber = Main.scan.nextLine();
            if (Validator.StringValidation(contactNumber, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_ADDRESS + Main.db.studentList.get(index).getAddress()));
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_ADDRESS));
            address = Main.scan.nextLine();
            if (Validator.StringValidation(address, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_POSTCODE + Main.db.studentList.get(index).getPostcode()));
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_POSTCODE));
            postcode = Main.scan.nextLine();
            if (Validator.StringValidation(postcode, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_CITY + Main.db.studentList.get(index).getCity()));
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_CITY));
            city = Main.scan.nextLine();
            if (Validator.StringValidation(city, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_STATE + Main.db.studentList.get(index).getState()));
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_STATE));
            state = Main.scan.nextLine();
            if (Validator.StringValidation(state, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        student.setContactNumber(contactNumber);
        student.setAddress(address);
        student.setPostcode(postcode);
        student.setCity(city);
        student.setState(state);

        Main.db.studentList.replace(index, student);

        ShowStudentDetail();
    }

    private void EditLoginCredential() {
        String currentPassword;
        String newPassword;
        String confirmNewPassword;

        System.out.println(Alignment.Center(50, StringVar.LBL_LOGIN_CREDENTIAL, false));

        while (true) {
            System.out.print(String.format("%s", StringVar.LBL_CURRENT + StringVar.LBL_PASSWORD));
            currentPassword = Main.scan.nextLine();
            if (Validator.StringValidation(currentPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_PASSWORD));
            newPassword = Main.scan.nextLine();
            if (Validator.StringValidation(newPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.print(String.format("%s", StringVar.LBL_REENTER_NEW_PASSWORD));
            confirmNewPassword = Main.scan.nextLine();
            if (Validator.StringValidation(confirmNewPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        if ((currentPassword.equals(Main.db.studentList.get(index).getPassword()))) {
            if (newPassword.equals(confirmNewPassword)) {
                student.setPassword(newPassword);
                Main.db.studentList.replace(index, student);
                System.out.println(Alignment.Center(50, StringVar.MSG_UPDATE_SUCCESS_PASSWORD, true));
            } else {
                System.out.println(Alignment.Center(50, StringVar.MSG_MATCH_FAIL_PASSWORD, true));
            }
        } else {
            System.out.println(Alignment.Center(50, StringVar.MSG_INVALID_PASSWORD, true));
        }
    }
}