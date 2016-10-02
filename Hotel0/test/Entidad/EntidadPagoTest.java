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
public class EntidadPagoTest {
    
    public EntidadPagoTest() {
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
     * Test of getDniCliente method, of class EntidadPago.
     */
    @Test
    public void testGetDniCliente() {
        System.out.println("getDniCliente");
        EntidadPago instance = new EntidadPago();
        String expResult = "";
        String result = instance.getDniCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDniCliente method, of class EntidadPago.
     */
    @Test
    public void testSetDniCliente() {
        System.out.println("setDniCliente");
        String dniCliente = "";
        EntidadPago instance = new EntidadPago();
        instance.setDniCliente(dniCliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaPago method, of class EntidadPago.
     */
    @Test
    public void testGetFechaPago() {
        System.out.println("getFechaPago");
        EntidadPago instance = new EntidadPago();
        String expResult = "";
        String result = instance.getFechaPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaPago method, of class EntidadPago.
     */
    @Test
    public void testSetFechaPago() {
        System.out.println("setFechaPago");
        String fechaPago = "";
        EntidadPago instance = new EntidadPago();
        instance.setFechaPago(fechaPago);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMetodoPago method, of class EntidadPago.
     */
    @Test
    public void testGetMetodoPago() {
        System.out.println("getMetodoPago");
        EntidadPago instance = new EntidadPago();
        String expResult = "";
        String result = instance.getMetodoPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMetodoPago method, of class EntidadPago.
     */
    @Test
    public void testSetMetodoPago() {
        System.out.println("setMetodoPago");
        String metodoPago = "";
        EntidadPago instance = new EntidadPago();
        instance.setMetodoPago(metodoPago);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIdReserva method, of class EntidadPago.
     */
    @Test
    public void testGetIdReserva() {
        System.out.println("getIdReserva");
        EntidadPago instance = new EntidadPago();
        int expResult = 0;
        int result = instance.getIdReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdReserva method, of class EntidadPago.
     */
    @Test
    public void testSetIdReserva() {
        System.out.println("setIdReserva");
        int idReserva = 0;
        EntidadPago instance = new EntidadPago();
        instance.setIdReserva(idReserva);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioTotal method, of class EntidadPago.
     */
    @Test
    public void testGetPrecioTotal() {
        System.out.println("getPrecioTotal");
        EntidadPago instance = new EntidadPago();
        long expResult = 0L;
        long result = instance.getPrecioTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioTotal method, of class EntidadPago.
     */
    @Test
    public void testSetPrecioTotal() {
        System.out.println("setPrecioTotal");
        long precioTotal = 0L;
        EntidadPago instance = new EntidadPago();
        instance.setPrecioTotal(precioTotal);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}