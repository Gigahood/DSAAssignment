/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

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
    public void testValidateEmptyInput() {
        System.out.println("validateEmptyInput");
        
        AdminModule instance = new AdminModule();
        
        assertTrue(instance.validateEmptyInput("asdsad"));
        
        
        assertFalse(instance.validateEmptyInput("a"));
        assertFalse(instance.validateEmptyInput("!@#!@#"));
        assertFalse(instance.validateEmptyInput("123"));
        assertFalse(instance.validateEmptyInput(""));

    }

    /**
     * Test of integerVaidation method, of class AdminModule.
     */
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

    /**
     * Test of centerString method, of class AdminModule.
     */
//    @Test
//    public void testCenterString() {
//        System.out.println("centerString");
//        int width = 0;
//        String s = "";
//        String expResult = "";
//        String result = AdminModule.centerString(width, s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of RegisterStudent method, of class AdminModule.
//     */
//    @Test
//    public void testRegisterStudent() {
//        System.out.println("RegisterStudent");
//        AdminModule instance = new AdminModule();
//        instance.RegisterStudent();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
