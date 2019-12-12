package SearchEngine;

import DataClass.Student;
import DataClass.StudentRegistration;
import DataStructureClass.MyArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author User
 */
public class SearchRegistrationStatusTest {
    private SearchRegistrationStatus s1 = new SearchRegistrationStatus();
    
    public SearchRegistrationStatusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //db = new Database();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class SearchRegistrationStatus.
     */
    
    /*
    Test getPageSize method
    */
    @Test
    public void testGetPageSize0() {
        System.out.println("testGetPageSize0");
        assertEquals(0, s1.getPageSize(0));
        assertEquals(3, s1.getPageSize(15));
        assertEquals(4, s1.getPageSize(16));
        assertNotEquals(0,s1.getPageSize(13));
    }
    /*
    Test testSearchPendingList method
    */
    
    @Test
    public void testSearchPendingListTrue() {
        System.out.println("testSearchPendingListTrue");
        
        MyArrayList<StudentRegistration> a = new MyArrayList<>();

        Calendar date = Calendar.getInstance();
        
        date.set(2019, 9, 10);
        Student s4 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r4 = new StudentRegistration(date.getTime(), "pending", s4);
        
        Main.db.registerList.add(r4);
        s1.searchPendingList(a);
        
        assertTrue(a.contains(r4));
    }
    
    @Test
    public void testSearchPendingListFalse() {
        System.out.println("testSearchPendingListTrue");
        
        MyArrayList<StudentRegistration> a = new MyArrayList<>();

        Calendar date = Calendar.getInstance();
        
        date.set(2019, 9, 10);
        Student s4 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
        StudentRegistration r4 = new StudentRegistration(date.getTime(), "approved", s4);
        
        Main.db.registerList.add(r4);
        s1.searchPendingList(a);
        
        assertFalse(a.contains(r4));
    }
    
    @Test
    public void testMin() {
        assertEquals(0, s1.getMin(1));
        assertEquals(5, s1.getMin(2));
        
        assertNotEquals(2,s1.getMin(2));
    }
    
    @Test
    public void testMax() {
        assertEquals(5, s1.getMax(1, s1.getPageSize(10), 10));
        assertEquals(10, s1.getMax(2, s1.getPageSize(10), 10));
        
        assertNotEquals(10, s1.getMax(1, s1.getPageSize(10), 10));
    }
    
    @Test 
    public void testGetStudentIndex() {
        assertEquals(1, s1.getStudentIndex(s1.getMin(1)));
        assertEquals(6, s1.getStudentIndex(s1.getMin(2)));
        
        assertNotEquals(5, s1.getStudentIndex(s1.getMin(2)));
    }
    
    
}
