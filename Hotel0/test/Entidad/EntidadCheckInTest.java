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
public class EntidadCheckInTest {
    
    public EntidadCheckInTest() {
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
     * Test of getIdReserva method, of class EntidadCheckIn.
     */
    @Test
    public void testGetIdReserva() {
        System.out.println("getIdReserva");
        EntidadCheckIn instance = new EntidadCheckIn();
        int expResult = 0;
        int result = instance.getIdReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdReserva method, of class EntidadCheckIn.
     */
    @Test
    public void testSetIdReserva() {
        System.out.println("setIdReserva");
        int idReserva = 0;
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setIdReserva(idReserva);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumHab method, of class EntidadCheckIn.
     */
    @Test
    public void testGetNumHab() {
        System.out.println("getNumHab");
        EntidadCheckIn instance = new EntidadCheckIn();
        int expResult = 0;
        int result = instance.getNumHab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumHab method, of class EntidadCheckIn.
     */
    @Test
    public void testSetNumHab() {
        System.out.println("setNumHab");
        int numHab = 0;
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setNumHab(numHab);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEntrada method, of class EntidadCheckIn.
     */
    @Test
    public void testGetFechaEntrada() {
        System.out.println("getFechaEntrada");
        EntidadCheckIn instance = new EntidadCheckIn();
        String expResult = "";
        String result = instance.getFechaEntrada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaEntrada method, of class EntidadCheckIn.
     */
    @Test
    public void testSetFechaEntrada() {
        System.out.println("setFechaEntrada");
        String fechaEntrada = "";
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setFechaEntrada(fechaEntrada);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNumPersonas method, of class EntidadCheckIn.
     */
    @Test
    public void testGetNumPersonas() {
        System.out.println("getNumPersonas");
        EntidadCheckIn instance = new EntidadCheckIn();
        int expResult = 0;
        int result = instance.getNumPersonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumPersonas method, of class EntidadCheckIn.
     */
    @Test
    public void testSetNumPersonas() {
        System.out.println("setNumPersonas");
        int numPersonas = 0;
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setNumPersonas(numPersonas);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioTotal method, of class EntidadCheckIn.
     */
    @Test
    public void testGetPrecioTotal() {
        System.out.println("getPrecioTotal");
        EntidadCheckIn instance = new EntidadCheckIn();
        long expResult = 0L;
        long result = instance.getPrecioTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrecioTotal method, of class EntidadCheckIn.
     */
    @Test
    public void testSetPrecioTotal() {
        System.out.println("setPrecioTotal");
        long precioTotal = 0L;
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setPrecioTotal(precioTotal);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDnicliente method, of class EntidadCheckIn.
     */
    @Test
    public void testGetDnicliente() {
        System.out.println("getDnicliente");
        EntidadCheckIn instance = new EntidadCheckIn();
        String expResult = "";
        String result = instance.getDnicliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDnicliente method, of class EntidadCheckIn.
     */
    @Test
    public void testSetDnicliente() {
        System.out.println("setDnicliente");
        String dnicliente = "";
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setDnicliente(dnicliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCondicionAlojamiento method, of class EntidadCheckIn.
     */
    @Test
    public void testGetCondicionAlojamiento() {
        System.out.println("getCondicionAlojamiento");
        EntidadCheckIn instance = new EntidadCheckIn();
        String expResult = "";
        String result = instance.getCondicionAlojamiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCondicionAlojamiento method, of class EntidadCheckIn.
     */
    @Test
    public void testSetCondicionAlojamiento() {
        System.out.println("setCondicionAlojamiento");
        String condicionAlojamiento = "";
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setCondicionAlojamiento(condicionAlojamiento);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMetodoPago method, of class EntidadCheckIn.
     */
    @Test
    public void testGetMetodoPago() {
        System.out.println("getMetodoPago");
        EntidadCheckIn instance = new EntidadCheckIn();
        String expResult = "";
        String result = instance.getMetodoPago();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMetodoPago method, of class EntidadCheckIn.
     */
    @Test
    public void testSetMetodoPago() {
        System.out.println("setMetodoPago");
        String metodoPago = "";
        EntidadCheckIn instance = new EntidadCheckIn();
        instance.setMetodoPago(metodoPago);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}