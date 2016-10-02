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
public class EntidadCheckOutTest {
    
    public EntidadCheckOutTest() {
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
     * Test of getIdReserva method, of class EntidadCheckOut.
     */
    @Test
    public void testGetIdReserva() {
        System.out.println("getIdReserva");
        EntidadCheckOut instance = new EntidadCheckOut();
        int expResult = 0;
        int result = instance.getIdReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdReserva method, of class EntidadCheckOut.
     */
    @Test
    public void testSetIdReserva() {
        System.out.println("setIdReserva");
        int idReserva = 0;
        EntidadCheckOut instance = new EntidadCheckOut();
        instance.setIdReserva(idReserva);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumHab method, of class EntidadCheckOut.
     */
    @Test
    public void testGetNumHab() {
        System.out.println("getNumHab");
        EntidadCheckOut instance = new EntidadCheckOut();
        int expResult = 0;
        int result = instance.getNumHab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumHab method, of class EntidadCheckOut.
     */
    @Test
    public void testSetNumHab() {
        System.out.println("setNumHab");
        int numHab = 0;
        EntidadCheckOut instance = new EntidadCheckOut();
        instance.setNumHab(numHab);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaSalida method, of class EntidadCheckOut.
     */
    @Test
    public void testGetFechaSalida() {
        System.out.println("getFechaSalida");
        EntidadCheckOut instance = new EntidadCheckOut();
        String expResult = "";
        String result = instance.getFechaSalida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaSalida method, of class EntidadCheckOut.
     */
    @Test
    public void testSetFechaSalida() {
        System.out.println("setFechaSalida");
        String fechaSalida = "";
        EntidadCheckOut instance = new EntidadCheckOut();
        instance.setFechaSalida(fechaSalida);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioTotal method, of class EntidadCheckOut.
     */
    @Test
    public void testGetPrecioTotal() {
        System.out.println("getPrecioTotal");
        EntidadCheckOut instance = new EntidadCheckOut();
        long expResult = 0L;
        long result = instance.getPrecioTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioTotal method, of class EntidadCheckOut.
     */
    @Test
    public void testSetPrecioTotal() {
        System.out.println("setPrecioTotal");
        long precioTotal = 0L;
        EntidadCheckOut instance = new EntidadCheckOut();
        instance.setPrecioTotal(precioTotal);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniCliente method, of class EntidadCheckOut.
     */
    @Test
    public void testGetDniCliente() {
        System.out.println("getDniCliente");
        EntidadCheckOut instance = new EntidadCheckOut();
        String expResult = "";
        String result = instance.getDniCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDniCliente method, of class EntidadCheckOut.
     */
    @Test
    public void testSetDniCliente() {
        System.out.println("setDniCliente");
        String dniCliente = "";
        EntidadCheckOut instance = new EntidadCheckOut();
        instance.setDniCliente(dniCliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}