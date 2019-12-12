package SearchEngine;

import Constant.StringVar;
import DataClass.Student;
import StringHelper.Alignment;
import java.util.ArrayList;
import java.util.List;

public class SearchOperation {

    static ArrayList<Student> students = new ArrayList<>();
    Student student = new Student();

    public static ArrayList<Student> SearchByResult(Student student, SearchType searchType) {
        return SearchResult(student, searchType);
    }

    private static ArrayList<Student> SearchResult(Student student, SearchType searchType) {

        students = new ArrayList<>();

        for (int i = 0; i < Main.db.studentList.size(); i++) {
            try {
                switch (searchType) {
                    case firstName:
                        if (Main.db.studentList.get(i).getFirstName().toUpperCase().contains(student.getFirstName().toUpperCase())) {
                            students.add(Main.db.studentList.get(i));
                        }
                        break;
                    case lastName:
                        if (Main.db.studentList.get(i).getLastName().toUpperCase().contains(student.getLastName().toUpperCase())) {
                            students.add(Main.db.studentList.get(i));
                        }
                        break;
//                    case studentIC:
//                        if (Main.db.studentList.get(i).getIc().contains(student.getIc())) {
//                            students.add(Main.db.studentList.get(i));
//                        }
//                        break;
//                    case studentID:
//                        if (Main.db.studentList.get(i).getStudentID().contains(student.getStudentID())) {
//                            students.add(Main.db.studentList.get(i));
//                        }
//                        break;
                }
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
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
