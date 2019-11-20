package DataClass;

import java.util.Calendar;
import java.util.Date;

public class StudentRegistration {

    // count is for the total number of student registered 
    private static long registrationCount = 0;
    private String registrationID;
    private Date registrationDate;
    private String registrationStatus;
    private Student student;
    private String password;

    public StudentRegistration() {
    }

    public StudentRegistration(Date registrationDate, String registrationStatus, Student student,
            StudentRegistration studentRegistration) {
        this.registrationDate = registrationDate;
        this.student = student;
        this.registrationStatus = registrationStatus;
        this.password = this.student.getIc();
        setRegistrationID(studentRegistration);
        checkRegistrationStatus();
    }

    public static long getRegistrationCount() {
        return registrationCount;
    }

    public static void setRegistrationCount(int count) {
        StudentRegistration.registrationCount = count;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return registrationStatus;
    }

    public void setStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ************************* Override*********************************************
     */
    @Override
    public String toString() {
        return "Student Registration ID : " + this.registrationID
                + "\nRegister Date : " + this.registrationDate
                + "\nRegister Status : " + this.registrationStatus
                + "\n"
                + this.student;
    }

    /**
     * ***************************************************************************
     */
    private void setRegistrationID(StudentRegistration studentRegistration) {
        // reset registrationCount if the semester is not the same
        calculateRegistrationCount(studentRegistration);
        registrationCount++;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String month = getSemester();
        String last2Digit = (Integer.toString(year)).substring(2);
        String formatedID = last2Digit + month + String.format("%05d", registrationCount);

        this.registrationID = formatedID;
    }

    private void checkRegistrationStatus() {
        if (this.registrationStatus.equals("approved")) {
            this.student.setStudentID();
        }
    }

    private String getSemester() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String monthStr = "";

        switch (month) {
            case 1:
            case 2:
            case 3:
            case 11:
            case 12:
                monthStr = "03";
                break;
            case 4:
            case 5:
                monthStr = "05";
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                monthStr = "10";
                break;
        }

        return monthStr;
    }

    private void calculateRegistrationCount(StudentRegistration studentRegistration) {
        if (studentRegistration != null) {
            String previousStudent = studentRegistration.getRegistrationID().substring(2, 4);
                    
            if (!previousStudent.equals(getSemester())) {
                registrationCount = 0;
            }
        }

    }

}
