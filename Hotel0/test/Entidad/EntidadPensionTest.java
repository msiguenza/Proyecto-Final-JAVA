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
public class EntidadPensionTest {
    
    public EntidadPensionTest() {
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
     * Test of getPension method, of class EntidadPension.
     */
    @Test
    public void testGetPension() {
        System.out.println("getPension");
        EntidadPension instance = new EntidadPension();
        String expResult = "";
        String result = instance.getPension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPension method, of class EntidadPension.
     */
    @Test
    public void testSetPension() {
        System.out.println("setPension");
        String pension = "";
        EntidadPension instance = new EntidadPension();
        instance.setPension(pension);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class EntidadPension.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        EntidadPension instance = new EntidadPension();
        int expResult = 0;
        int result = instance.getPrecio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecio method, of class EntidadPension.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        int precio = 0;
        EntidadPension instance = new EntidadPension();
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}