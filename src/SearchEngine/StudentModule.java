package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import java.io.Console;
import java.io.IOException;

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
        System.out.println(String.format("%s", Center(StringVar.LBL_STUDENT_DETAIL, 50, false)));
        System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_ID + Main.db.studentList.get(index).getStudentID()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_STATUS + Main.db.studentList.get(index).getStudyStatus()));
        System.out.println(String.format("|%-50s|", StringVar.LBL_CGPA + Main.db.studentList.get(index).getCgpa()));
        System.out.println();
        System.out.println(String.format("%s", Center(StringVar.LBL_CONTACT_DETAIL, 50, false)));
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

        System.out.println(String.format("%s", Center(StringVar.LBL_STUDENT_DETAIL, 50, false)));

        System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_CONTACT_NUMBER + Main.db.studentList.get(index).getContactNumber()));
        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_CONTACT_NUMBER));
        input = Main.scan.nextLine();
        student.setContactNumber(input);

        System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_ADDRESS + Main.db.studentList.get(index).getAddress()));
        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_ADDRESS));
        input = Main.scan.nextLine();
        student.setAddress(input);

        System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_POSTCODE + Main.db.studentList.get(index).getPostcode()));
        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_POSTCODE));
        input = Main.scan.nextLine();
        student.setPostcode(input);

        System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_CITY + Main.db.studentList.get(index).getCity()));
        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_CITY));
        input = Main.scan.nextLine();
        student.setCity(input);

        System.out.println(String.format("|%-50s|", StringVar.LBL_CURRENT + StringVar.LBL_STATE + Main.db.studentList.get(index).getState()));
        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_STATE));
        input = Main.scan.nextLine();
        student.setState(input);

        Main.db.studentList.replace(index, student);

        ShowStudentDetail();
    }

    private void EditLoginCredential() {

        System.out.println(String.format("%s", Center(StringVar.LBL_LOGIN_CREDENTIAL, 50, false)));

        System.out.print(String.format("%s", StringVar.LBL_CURRENT + StringVar.LBL_PASSWORD));
        input = Main.scan.nextLine();
        String currentPassword = input;

        System.out.print(String.format("%s", StringVar.LBL_NEW + StringVar.LBL_PASSWORD));
        input = Main.scan.nextLine();
        String newPassword = input;

        System.out.print(String.format("%s", StringVar.LBL_REENTER_NEW_PASSWORD));
        input = Main.scan.nextLine();
        String confirmNewPassword = input;

        if ((currentPassword.equals(Main.db.studentList.get(index).getPassword()))) {
            if (newPassword.equals(confirmNewPassword)) {
                student.setPassword(newPassword);
                Main.db.studentList.replace(index, student);
                System.out.println(String.format("%s",
                        Center(StringVar.MSG_UPDATE_SUCCESS_PASSWORD, 50, true)));
            } else {
                System.out.println(String.format("%s",
                        Center(StringVar.MSG_MATCH_FAIL_PASSWORD, 50, true)));
            }
        } else {
            System.out.println(String.format("%s",
                    Center(StringVar.MSG_INVALID_PASSWORD, 50, true)));
        }
    }

    public String Center(String text, int length, Boolean withAsterisk) {
        String out;

        if (withAsterisk) {
            out = String.format("%" + length + "s%s%" + length + "s", "", text, "").replace(" ", "*");
        } else {
            out = String.format("%" + length + "s%s%" + length + "s", "", text, "");
        }

        float middle = (out.length() / 2);
        float start = middle - (length / 2);
        float end = start + length;
        return out.substring((int) start, (int) end);
    }
}
