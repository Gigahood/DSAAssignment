package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import StringHelper.Alignment;
import java.util.ArrayList;
import java.util.List;

public class SearchOperation {

    static List<Student> students = new ArrayList<>();
    Student student = new Student();

    public static List<Student> SearchByResult(Student student, SearchType searchType) {
        return SearchResult(student, searchType);
    }

    private static List<Student> SearchResult(Student student, SearchType searchType) {

        students = new ArrayList<>();

        for (int i = 0; i < Main.db.studentList.size(); i++) {
            switch (searchType) {
                case firstName:
                    if (Main.db.studentList.get(i).getFirstName().contains(student.getFirstName())) {
                        students.add(Main.db.studentList.get(i));
                    }
                    break;
                case lastName:
                    if (Main.db.studentList.get(i).getLastName().contains(student.getLastName())) {
                        students.add(Main.db.studentList.get(i));
                    }
                    break;
                case studentIC:
                    if (Main.db.studentList.get(i).getIc().contains(student.getIc())) {
                        students.add(Main.db.studentList.get(i));
                    }
                    break;
                case studentID:
                    if (Main.db.studentList.get(i).getStudentID().contains(student.getStudentID())) {
                        students.add(Main.db.studentList.get(i));
                    }
                    break;
            }
        }

        if (students != null && students.size() > 0) {
            System.out.println(students.size() + StringVar.LBL_RECORD_FOUND);
            return students;
        } else {
            System.out.println(Alignment.Display(50, StringVar.MSG_NO_RECORD_FOUND, Alignment.Type.centerWithAsterisk));
        }

        return null;
    }

    public static enum SearchType {
        firstName,
        lastName,
        studentIC,
        studentID
    }
}
