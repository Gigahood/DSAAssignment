package SearchEngine;

import DataClass.*;
import DataStructureClass.*;
import java.util.Date;

public class Database {
    
    public MyList<StudentRegistration> registerList = new MyArrayList<>();
    public MyList<Student> studentList = new MyArrayList<>();
    public MyList<Admin> adminList = new MyArrayList<>();
    
    public Database() {
        addStudentData();
        addAdminData();
    }
    
    private void addStudentData() {
        Student s1 = new Student("Kuek", "Yong Boon", "940526105481", "Foundation");
        StudentRegistration r1 = new StudentRegistration(new Date(), "approved", s1, null);
        registerList.add(r1);
        studentList.add(s1);
        Student s2 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r2 = new StudentRegistration(new Date(), "pending", s2, registerList.getLast());
        registerList.add(r2);
        Student s3 = new Student("Ong", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r3 = new StudentRegistration(new Date(), "rejected", s3, registerList.getLast());
        registerList.add(r3);
        Student s4 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r4 = new StudentRegistration(new Date(), "pending", s4, registerList.getLast());
        registerList.add(r4);
    }
    
    private void addAdminData() {
        Admin a1 = new Admin("Ms","LIM YI EN","admin", "admin");
        Admin a2 = new Admin("Mr","SEE E JET","admin01", "admin01");
        adminList.add(a1);
        adminList.add(a2);
    }
    
}
