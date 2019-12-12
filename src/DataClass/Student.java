package DataClass;

import java.util.Calendar;

public class Student {

    // count represent total number of student in current semester
    private static int studentCount = 0;
    private String studentID;
    private String firstName;
    private String lastName;
    private String ic;
    private String eduBackground;
    private String password;
    private String studyStatus;
    private Double cgpa;
    //private StudentRegistration registration;
    private String contactNumber;
    private String address;
    private String postcode;
    private String city;
    private String state;

    public Student() {

    }

    public Student(String firstName, String lastName, String ic, String eduBackground) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
        this.password = ic;
        this.eduBackground = eduBackground;
        this.cgpa = 0.00;
        this.studyStatus = "good";
    }

    public Student(String firstName, String lastName, String ic, String eduBackground, String contactNumber, String address, String postcode, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ic = ic;
        this.password = ic;
        this.eduBackground = eduBackground;
        this.cgpa = 0.00;
        this.studyStatus = "good";
        this.contactNumber = contactNumber;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.state = state;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Student ID : " + this.studentID
                + "\nStudent Name : " + this.firstName + " " + this.lastName
                + "\nIC : " + this.ic
                + "\nContact Number : " + this.contactNumber
                + "\nAddress : " + this.address
                + "\nPostcode : " + this.postcode
                + "\nCity : " + this.city
                + "\nState : " +this.state;
    }

    public void setStudentID() {
        studentCount++;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String last2Digit = (Integer.toString(year)).substring(2);
        String formatedID = last2Digit + String.format("%05d", studentCount);

        this.studentID = formatedID;
    }
    
  
}
