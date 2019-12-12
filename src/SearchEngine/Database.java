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
        
        date.set(2019, 8, 10);
        Student s99 = new Student("Pong", "Chia Zhen", "961226025845", "Foundation", "0124542725", "5, Taman Setali Jaya", "06660", "Bayang", "Johor");
        StudentRegistration r99 = new StudentRegistration(date.getTime(), "approved", s5);
        s99.setStudyStatus("Probation");
        registerList.add(r99);
        studentList.add(s99);
        
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