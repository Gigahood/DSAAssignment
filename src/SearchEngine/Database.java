package SearchEngine;

import DataClass.*;
import DataStructureClass.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Database {

    public MyList<StudentRegistration> registerList = new MyArrayList<>();
    public MyList<Student> studentList = new MyArrayList<>();
    public MyList<Admin> adminList = new MyArrayList<>();

    public Database() {
        addStudentData();
        addAdminData();
    }

    private void addStudentData() {
        Calendar date = Calendar.getInstance();
        Student s1 = new Student("Kuek", "Yong Boon", "940526105481", "Foundation", "0124542725", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r1 = new StudentRegistration(date.getTime(), "approved", s1);
        registerList.add(r1);
        studentList.add(s1);
        date.set(2019, 10, 10);
        Student s2 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r2 = new StudentRegistration(date.getTime(), "pending", s2);
        registerList.add(r2);
        date.set(2019, 9, 10);
        Student s3 = new Student("Ong", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r3 = new StudentRegistration(date.getTime(), "rejected", s3);
        registerList.add(r3);
        date.set(2019, 9, 10);
        Student s4 = new Student("Chia", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r4 = new StudentRegistration(date.getTime(), "pending", s4);
        registerList.add(r4);
        date.set(2019, 8, 10);
        Student s5 = new Student("Wong", "Chia Zhen", "961226025845", "Foundation", "0124542725", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r5 = new StudentRegistration(date.getTime(), "approved", s5);
        registerList.add(r5);
        studentList.add(s5);
        
        date.set(2019, 8, 12);
        Student s6 = new Student("Wong", "Ching Ling", "961226032846", "A-Level", "0124542723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r6 = new StudentRegistration(date.getTime(), "approved", s6);
        registerList.add(r6);
        studentList.add(s6);
        
        date.set(2019, 8, 20);
        Student s7 = new Student("Tan", "Zhia Yi", "961224032846", "A-Level", "0124543723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r7 = new StudentRegistration(date.getTime(), "approved", s7);
        registerList.add(r7);
        studentList.add(s7);
        
        date.set(2019, 8, 12);
        Student s8 = new Student("Yeoh", "Ming Lin", "961326032846", "Diploma", "0134542723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r8 = new StudentRegistration(date.getTime(), "approved", s8);
        registerList.add(r8);
        studentList.add(s8);
        
        date.set(2019, 8, 1);
        Student s9= new Student("Tan", "Zhia Yi", "961224032846", "Diploma", "0114543723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r9= new StudentRegistration(date.getTime(), "approved", s9);
        registerList.add(r9);
        studentList.add(s9);
        
        date.set(2019, 8, 12);
        Student s10 = new Student("Tan", "Min Jie", "931326032846", "Form 6", "0164542723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r10 = new StudentRegistration(date.getTime(), "approved", s10);
        registerList.add(r10);
        studentList.add(s10);
        
        date.set(2019, 8, 1);
        Student s11= new Student("Wong", "Kar Hor", "921224032846", "Form 6", "0194543723", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r11= new StudentRegistration(date.getTime(), "approved", s11);
        registerList.add(r11);
        studentList.add(s11);
        
        
        for (int i = 6 ; i < 20; i++) {
            date.set(2019, 9, i);
            String firstName = randomFirstName();
            String randomIC = randomIC();
            Student s = new Student(firstName, "Yong Tat", randomIC, "Foundation");
            StudentRegistration r = new StudentRegistration(date.getTime(), "pending", s);
            registerList.add(r);
        }
    }

    private void addAdminData() {
        Admin a1 = new Admin("Ms", "LIM YI EN", "admin", "admin");
        Admin a2 = new Admin("Mr", "SEE E JET", "admin01", "admin01");
        adminList.add(a1);
        adminList.add(a2);
    }
    
    private String randomFirstName() {
        String str = "";
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            str += (char) (rnd.nextInt(26) + 'a');
        }
        
        return str;
    }
    
    private String randomIC() {
        String ic = "94052610";
        
        for (int i = 0; i < 4; i++) {
            ic += new Random().nextInt(10);
        }
        
        return ic;
    }
}
