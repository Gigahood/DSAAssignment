///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package SearchEngine;
//
//import DataClass.Student;
//import DataClass.StudentRegistration;
//import java.util.Calendar;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author User
// */
//public class ViewRegistrationDetailTest {
//
//    public ViewRegistrationDetailTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        System.out.println("1");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of validateField method, of class ViewRegistrationDetail.
//     */
//    @Test
//    public void testValidateField() {
//        ViewRegistrationDetail instance = new ViewRegistrationDetail();
//        //both correct
//        assertTrue(instance.validateField("190300001", "940526105481"));
//        //either ID or password is empty
//        assertFalse(instance.validateField("", ""));
//        assertFalse(instance.validateField("", "940526105481"));
//        assertFalse(instance.validateField("190300001", ""));
//        //incorrect ID and password
//        assertFalse(instance.validateField("123", "adsad"));
//        //invalid length for the id
//        assertFalse(instance.validateField("123", "940526105481"));
//        assertFalse(instance.validateField("1234", "123"));
//
//    }
//
//    @Test
//    public void testMatchRegistrationID() {
//        ViewRegistrationDetail instance = new ViewRegistrationDetail();
//
//        Calendar date = Calendar.getInstance();
//        date.set(2019, 10, 10);
//        Student s2 = new Student("Kuek", "Yong Tat", "940526105482", "Foundation");
//        StudentRegistration r2 = new StudentRegistration(date.getTime(), "pending", s2);
//        Main.db.registerList.add(r2);
//        String num = r2.getRegistrationID();
//        String ic = r2.getPassword();
//        instance.setVariable(num, ic);
//        assertTrue(instance.matchRegistrationID());
//
//        instance.setVariable("123", "123");
//        assertFalse(instance.matchRegistrationID());
//        
//    }
//
//}
