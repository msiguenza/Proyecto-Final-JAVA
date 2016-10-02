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
public class EntidadCapacidadTest {
    
    public EntidadCapacidadTest() {
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
     * Test of getCapacidad method, of class EntidadCapacidad.
     */
    @Test
    public void testGetCapacidad() {
        System.out.println("getCapacidad");
        EntidadCapacidad instance = new EntidadCapacidad();
        int expResult = 0;
        int result = instance.getCapacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCapacidad method, of class EntidadCapacidad.
     */
    @Test
    public void testSetCapacidad() {
        System.out.println("setCapacidad");
        int capacidad = 0;
        EntidadCapacidad instance = new EntidadCapacidad();
        instance.setCapacidad(capacidad);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}