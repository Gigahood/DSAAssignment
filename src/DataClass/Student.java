package DataClass;

import java.util.Calendar;

public class Student {
    // count represent total number of student in current semester
    private static int studentCount = 0;
    private static String year = "0";
    private String studentID;
    private String firstName;
    private String lastName;
    private String ic;
    private String eduBackground;
    private String password;
    private String studyStatus;
    private Double cgpa;
    //private StudentRegistration registration;

    public Student() {

    }
    
    public Student(String firstName, String lastName, String ic ,
            String eduBackground) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
        this.password = ic;
        this.eduBackground = eduBackground;
        this.cgpa = 0.00;
        this.studyStatus = "good";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getEduBackground() {
        return eduBackground;
    }

    public void setEduBackground(String eduBackground) {
        this.eduBackground = eduBackground;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(String studyStatus) {
        this.studyStatus = studyStatus;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    
/*************************** Override**********************************************/
    @Override
    public String toString() {
        return "Student ID : " + this.studentID
                + "\nStudent Name : " + this.firstName + " " + this.lastName
                + "\nIC : " + this.ic; 
    }
    
/******************************************************************************/
    public void setStudentID() {
        calculateStudentCount();
        studentCount++;
        //String year = getYearLastTwoDigit();
        String formatedID = this.year + String.format("%05d",studentCount);

        this.studentID = formatedID;
    }
    
    private void calculateStudentCount() {
        if (!Student.year.equals(getYearLastTwoDigit())) {
            studentCount = 0;
            Student.year = getYearLastTwoDigit();
        }
    }
    
    private String getYearLastTwoDigit() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String lastTwoYear = (Integer.toString(year)).substring(2);
        
        return lastTwoYear;
    }

}
