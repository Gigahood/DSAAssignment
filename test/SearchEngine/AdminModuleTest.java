/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

import DataClass.Student;
import DataClass.StudentRegistration;
import java.util.Date;
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
public class AdminModuleTest {

    public AdminModuleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
     * Test of validateEmptyInput method, of class AdminModule.
     */
    @Test
    public void testValidateStringInput() {
        System.out.println("validateEmptyInput");

        AdminModule instance = new AdminModule();

        assertTrue(instance.validateStringInput("asdsad"));

        assertFalse(instance.validateStringInput("a"));
        assertFalse(instance.validateStringInput("!@#!@#"));
        assertFalse(instance.validateStringInput("123"));
        assertFalse(instance.validateStringInput(""));

    }

    @Test
    public void testIntegerVaidation() {
        System.out.println("integerVaidation");

        AdminModule instance = new AdminModule();

        assertTrue(instance.integerVaidation("990603145782"));

        assertFalse(instance.integerVaidation(""));
        assertFalse(instance.integerVaidation("1"));
        assertFalse(instance.integerVaidation("1123123123123123123123123"));
        assertFalse(instance.integerVaidation("afsgf"));
        // TODO review the generated test code and remove the default call to fail.
    }

//    @Test
//    public void testRegisterStudent() {
//        System.out.println("RegisterStudent");
//        AdminModule instance = new AdminModule();
//
//        Student newStudent = new Student("Kuek", "Yong Yee", "123456789012", "Foundation");
//        StudentRegistration newRegistration = new StudentRegistration(new Date(), "approved", newStudent);
//
//        instance.addStudent(newStudent, newRegistration);
//
//        assertTrue(Main.db.registerList.contains(newRegistration));
//        assertTrue(Main.db.studentList.contains(newStudent));
//
//    }

}
