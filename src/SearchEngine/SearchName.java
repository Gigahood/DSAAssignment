

package SearchEngine;
import Constant.StringVar;
import DataClass.Student;
import static SearchEngine.Main.scan;
/**
 *
 * @author User
 */
public class SearchName {
    
    String FName;
    String LName;
    Student student;
    
    public SearchName()
    {
        String x;
        
        SearchNameUI();
        System.out.println("Do you want to continue to search? Press 1 to continue, press other to exit.");
        x = Main.scan.nextLine();
        if (x.equals("1"))
        {
            SearchNameUI();
        }
        else
        {
            AdminModule am = new AdminModule();
        }
    }
    
    public void SearchNameUI()
    {
        System.out.println("Please enter your Student First Name:");
        FName = Main.scan.nextLine();
        if(FName.equals(""))
        {
            System.out.println("Please do not leave blank!");
            SearchNameUI();
        }
        System.out.println("Please enter your Student Last Name:");
        LName = Main.scan.nextLine();
        if(LName.equals(""))
        {
            System.out.println("Please do not leave blank!");
            SearchNameUI();
        }
        Compare(FName,LName);
    }
    
    public void Compare(String fname, String lname)
    {
        
        for(int i = 0; i< Main.db.studentList.size();i++)
        {
            if(Main.db.studentList.get(i).getFirstName().equals(fname) && Main.db.studentList.get(i).getLastName().equals(lname))
            {
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_DETAIL));
                System.out.println(String.format("|%-50s|", StringVar.LBL_STUDENT_ID + Main.db.studentList.get(i).getStudentID()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_FIRST_NAME + Main.db.studentList.get(i).getFirstName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_LAST_NAME + Main.db.studentList.get(i).getLastName()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_IC_NUMBER + Main.db.studentList.get(i).getIc()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_STATUS + Main.db.studentList.get(i).getStudyStatus()));
                System.out.println(String.format("|%-50s|", StringVar.LBL_CGPA + Main.db.studentList.get(i).getCgpa()));
                break;
            }
            else
            {
                System.out.println("Student ID doesn't exist!");
                Main.scan.nextLine();
                Main.clearScreen();
                break;
            }
        }
    }

}
