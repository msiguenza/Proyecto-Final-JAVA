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
public class EntidadVistasTest {
    
    public EntidadVistasTest() {
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
     * Test of getVista method, of class EntidadVistas.
     */
    @Test
    public void testGetVista() {
        System.out.println("getVista");
        EntidadVistas instance = new EntidadVistas();
        String expResult = "";
        String result = instance.getVista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setVista method, of class EntidadVistas.
     */
    @Test
    public void testSetVista() {
        System.out.println("setVista");
        String vista = "";
        EntidadVistas instance = new EntidadVistas();
        instance.setVista(vista);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}