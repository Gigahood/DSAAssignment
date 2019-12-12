///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package SearchEngine;
//
//import DataClass.Student;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author JDCZW
// */
//public class StudentModuleTest {
//
//    public StudentModuleTest() {
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
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of UpdatePassword method, of class StudentModule.
//     */
//    @Test
//    public void testUpdatePassword() {
//        System.out.println("UpdatePassword");
//        String currentPassword;
//        String newPassword;
//        String confirmNewPassword;
//        StudentModule instance = new StudentModule();
//        Boolean expResult;
//        Boolean result;
//
//        //1. -----all correct input
//        currentPassword = "940526105481";
//        newPassword = "999";
//        confirmNewPassword = "999";
//
//        expResult = true;
//        result = instance.UpdatePassword(currentPassword, newPassword, confirmNewPassword);
//        assertEquals(expResult, result);
//        //-----
//
//        //2. -----correct old password but new password not match with confirm password
//        currentPassword = "940526105481";
//        newPassword = "999";
//        confirmNewPassword = "111";
//
//        expResult = false;
//        result = instance.UpdatePassword(currentPassword, newPassword, confirmNewPassword);
//        assertEquals(expResult, result);
//        //-----
//
//        //3. -----correct old password but confirm password not match with new password
//        currentPassword = "940526105481";
//        newPassword = "111";
//        confirmNewPassword = "999";
//
//        expResult = false;
//        result = instance.UpdatePassword(currentPassword, newPassword, confirmNewPassword);
//        assertEquals(expResult, result);
//        //-----
//
//        //4. input wrong old password but new password and confirm password is match
//        currentPassword = "999";
//        newPassword = "999";
//        confirmNewPassword = "999";
//
//        expResult = false;
//        result = instance.UpdatePassword(currentPassword, newPassword, confirmNewPassword);
//        assertEquals(expResult, result);
//        //-----
//    }
//
//}
