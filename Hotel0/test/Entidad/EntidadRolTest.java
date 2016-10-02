/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silvia
 */
public class EntidadRolTest {
    
    public EntidadRolTest() {
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
     * Test of getRol method, of class EntidadRol.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        EntidadRol instance = new EntidadRol();
        String expResult = "";
        String result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class EntidadRol.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        String rol = "";
        EntidadRol instance = new EntidadRol();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}