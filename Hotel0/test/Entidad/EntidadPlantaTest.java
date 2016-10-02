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
public class EntidadPlantaTest {
    
    public EntidadPlantaTest() {
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
     * Test of getnPlanta method, of class EntidadPlanta.
     */
    @Test
    public void testGetnPlanta() {
        System.out.println("getnPlanta");
        EntidadPlanta instance = new EntidadPlanta();
        int expResult = 0;
        int result = instance.getnPlanta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setnPlanta method, of class EntidadPlanta.
     */
    @Test
    public void testSetnPlanta() {
        System.out.println("setnPlanta");
        int nPlanta = 0;
        EntidadPlanta instance = new EntidadPlanta();
        instance.setnPlanta(nPlanta);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}