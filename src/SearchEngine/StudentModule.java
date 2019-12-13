package SearchEngine;

import Constant.StringVar;
import StringHelper.Alignment;
import StringHelper.Validator;

public class StudentModule {

    private int index;
    private String input;

    public StudentModule(int index) {
        this.index = index;
        Navigation();
    }

    public StudentModule() {
        
    }

    public void ShowStudentDetail() {
        System.out.println(Alignment.Display(50, StringVar.LBL_STUDENT_DETAIL, Alignment.Type.centerOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_STUDENT_ID + Main.db.studentList.get(index).getStudentID(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_FIRST_NAME + Main.db.studentList.get(index).getFirstName(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_LAST_NAME + Main.db.studentList.get(index).getLastName(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_IC_NUMBER + Main.db.studentList.get(index).getIc(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_STATUS + Main.db.studentList.get(index).getStudyStatus(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_CGPA + Main.db.studentList.get(index).getCgpa(),
                Alignment.Type.withBorderOnly));
        System.out.println();

        System.out.println(Alignment.Display(50, StringVar.LBL_CONTACT_DETAIL, Alignment.Type.centerOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_CONTACT_NUMBER + Main.db.studentList.get(index).getContactNumber(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_ADDRESS + Main.db.studentList.get(index).getAddress(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_POSTCODE + Main.db.studentList.get(index).getPostcode(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_CITY + Main.db.studentList.get(index).getCity(),
                Alignment.Type.withBorderOnly));
        System.out.println(Alignment.Display(50,
                StringVar.LBL_STATE + Main.db.studentList.get(index).getState(),
                Alignment.Type.withBorderOnly));
        System.out.println();
    }

    private void Navigation() {

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

    private void Menu() {
        System.out.println("Student Module");
        System.out.println("1. View Student Detail");
        System.out.println("2. Edit Student Detail");
        System.out.println("3. Edit Login Credential");
        System.out.println("4. Return");
        System.out.print("Your Selection ---> ");
    }

    private void SubMenu() {
        System.out.println("Edit Student Detail");
        System.out.println("1. Contact Number");
        System.out.println("2. Address");
        System.out.println("3. Postcode");
        System.out.println("4. City");
        System.out.println("5. State");
        System.out.println("6. Return");
        System.out.print("Your Selection ---> ");
    }

    public void EditStudentDetail() {

        String contactNumber;
        String address;
        String postcode;
        String city;
        String state;

        while (true) {
            while (true) {
                SubMenu();
                input = Main.scan.nextLine();

                if (Main.checkInputMenu(6, input)) {
                    break;
                }
            }

            if (input.equals("6")) {
                break;
            }

            System.out.println(Alignment.Display(50, StringVar.LBL_STUDENT_DETAIL, Alignment.Type.centerOnly));

            switch (input) {
                case "1":
                    while (true) {
                        System.out.println(Alignment.Display(50,
                                StringVar.LBL_CURRENT + StringVar.LBL_CONTACT_NUMBER + Main.db.studentList.get(index).getContactNumber(),
                                Alignment.Type.withBorderOnly));
                        System.out.print(StringVar.LBL_NEW + StringVar.LBL_CONTACT_NUMBER);
                        contactNumber = Main.scan.nextLine();
                        if (!Validator.StringValidation(contactNumber, Validator.TypeOfValidation.empty)) {
                            break;
                        }
                        if (!contactNumber.equals(Main.db.studentList.get(index).getContactNumber())) {
                            Main.db.studentList.get(index).setContactNumber(contactNumber);
                            break;
                        }
                        break;
                    }
                    break;
                case "2":
                    while (true) {
                        System.out.println(Alignment.Display(50,
                                StringVar.LBL_CURRENT + StringVar.LBL_ADDRESS + Main.db.studentList.get(index).getAddress(),
                                Alignment.Type.withBorderOnly));
                        System.out.print(StringVar.LBL_NEW + StringVar.LBL_ADDRESS);
                        address = Main.scan.nextLine();
                        if (!Validator.StringValidation(address, Validator.TypeOfValidation.empty)) {
                            break;
                        }
                        if (!address.equals(Main.db.studentList.get(index).getAddress())) {
                            Main.db.studentList.get(index).setAddress(address);
                            break;
                        }
                        break;
                    }
                    break;
                case "3":
                    while (true) {
                        System.out.println(Alignment.Display(50,
                                StringVar.LBL_CURRENT + StringVar.LBL_POSTCODE + Main.db.studentList.get(index).getPostcode(),
                                Alignment.Type.withBorderOnly));
                        System.out.print(StringVar.LBL_NEW + StringVar.LBL_POSTCODE);
                        postcode = Main.scan.nextLine();
                        if (!Validator.StringValidation(postcode, Validator.TypeOfValidation.empty)) {
                            break;
                        }
                        if (!postcode.equals(Main.db.studentList.get(index).getPostcode())) {
                            Main.db.studentList.get(index).setPostcode(postcode);
                            break;
                        }
                        break;
                    }
                    break;
                case "4":
                    while (true) {
                        System.out.println(Alignment.Display(50,
                                StringVar.LBL_CURRENT + StringVar.LBL_CITY + Main.db.studentList.get(index).getCity(),
                                Alignment.Type.withBorderOnly));
                        System.out.print(StringVar.LBL_NEW + StringVar.LBL_CITY);
                        city = Main.scan.nextLine();
                        if (!Validator.StringValidation(city, Validator.TypeOfValidation.empty)) {
                            break;
                        }
                        if (!city.equals(Main.db.studentList.get(index).getCity())) {
                            Main.db.studentList.get(index).setCity(city);
                            break;
                        }
                        break;
                    }
                    break;
                case "5":
                    while (true) {
                        System.out.println(Alignment.Display(50,
                                StringVar.LBL_CURRENT + StringVar.LBL_STATE + Main.db.studentList.get(index).getState(),
                                Alignment.Type.withBorderOnly));
                        System.out.print(StringVar.LBL_NEW + StringVar.LBL_STATE);
                        state = Main.scan.nextLine();
                        if (!Validator.StringValidation(state, Validator.TypeOfValidation.empty)) {
                            break;
                        }
                        if (!state.equals(Main.db.studentList.get(index).getState())) {
                            Main.db.studentList.get(index).setState(state);
                            break;
                        }
                        break;
                    }
                    break;

            }
        }
    }

    public void EditLoginCredential() {

        String currentPassword;
        String newPassword;
        String confirmNewPassword;

        System.out.println(Alignment.Display(50, StringVar.LBL_LOGIN_CREDENTIAL, Alignment.Type.centerOnly));

        while (true) {
            System.out.print(StringVar.LBL_CURRENT + StringVar.LBL_PASSWORD);
            currentPassword = Main.scan.nextLine();
            if (Validator.StringValidation(currentPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.print(StringVar.LBL_NEW + StringVar.LBL_PASSWORD);
            newPassword = Main.scan.nextLine();
            if (Validator.StringValidation(newPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        while (true) {
            System.out.print(StringVar.LBL_REENTER_NEW_PASSWORD);
            confirmNewPassword = Main.scan.nextLine();
            if (Validator.StringValidation(confirmNewPassword, Validator.TypeOfValidation.empty)) {
                break;
            }
        }

        if (UpdatePassword(currentPassword, newPassword, confirmNewPassword)) {
            Main.db.studentList.get(index).setPassword(newPassword);
        }
    }

    public Boolean UpdatePassword(String currentPassword, String newPassword, String confirmNewPassword) {

        if ((currentPassword.equals(Main.db.studentList.get(index).getPassword()))) {
            if (newPassword.equals(confirmNewPassword)) {
                System.out.println(Alignment.Display(50, StringVar.MSG_UPDATE_SUCCESS_PASSWORD, Alignment.Type.centerWithAsterisk));
                return true;
            } else {
                System.out.println(Alignment.Display(50, StringVar.MSG_MATCH_FAIL_PASSWORD, Alignment.Type.centerWithAsterisk));
                return false;
            }
        } else {
            System.out.println(Alignment.Display(50, StringVar.MSG_INVALID_PASSWORD, Alignment.Type.centerWithAsterisk));
            return false;
        }
    }
}
