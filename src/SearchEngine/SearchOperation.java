package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import java.util.ArrayList;
import java.util.List;

public class SearchOperation {

    static List<Student> students = new ArrayList<>();
    Student student = new Student();

    public static List<Student> SearchByFirstNameResult(Student student) {
        for (int i = 0; i < Main.db.studentList.size(); i++) {
            if (Main.db.studentList.get(i).getFirstName().contains(student.getFirstName())) {
                students.add(Main.db.studentList.get(i));
            } else {
                System.out.println(StringVar.MSG_NO_RECORD_FOUND);
            }
        }

        return students;
    }

    public List<Student> SearchByLastNameResult(Student student) {
        for (int i = 0; i < Main.db.studentList.size(); i++) {
            if (Main.db.studentList.get(i).getLastName().contains(student.getLastName())) {
                students.add(Main.db.studentList.get(i));
            } else {
                System.out.println(StringVar.MSG_NO_RECORD_FOUND);
            }
        }

        return students;
    }

    public List<Student> SearchByStudentIDResult(Student student) {
        for (int i = 0; i < Main.db.studentList.size(); i++) {
            if (Main.db.studentList.get(i).getStudentID().contains(student.getStudentID())) {
                students.add(Main.db.studentList.get(i));
            } else {
                System.out.println(StringVar.MSG_NO_RECORD_FOUND);
            }
        }

        return students;
    }

    public List<Student> SearchByStudentICResult(Student student) {
        for (int i = 0; i < Main.db.studentList.size(); i++) {
            if (Main.db.studentList.get(i).getIc().contains(student.getIc())) {
                students.add(Main.db.studentList.get(i));
            } else {
                System.out.println(StringVar.MSG_NO_RECORD_FOUND);
            }
        }

        return students;
    }
}
