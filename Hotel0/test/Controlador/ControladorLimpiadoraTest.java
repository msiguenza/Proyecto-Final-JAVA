/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.EntidadHabitación;
import java.awt.event.ActionEvent;
import java.util.List;
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
public class ControladorLimpiadoraTest {
    
    public ControladorLimpiadoraTest() {
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
     * Test of getDniLimpiadora method, of class ControladorLimpiadora.
     */
    @Test
    public void testGetDniLimpiadora() throws Exception {
        System.out.println("getDniLimpiadora");
        EntidadHabitación filtrarDniLimpiadora = null;
        List expResult = null;
        List result = ControladorLimpiadora.getDniLimpiadora(filtrarDniLimpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarHabitacion method, of class ControladorLimpiadora.
     */
    @Test
    public void testModificarHabitacion() throws Exception {
        System.out.println("modificarHabitacion");
        EntidadHabitación modificarHabitacion = null;
        ControladorLimpiadora.modificarHabitacion(modificarHabitacion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iniciar method, of class ControladorLimpiadora.
     */
    @Test
    public void testIniciar() throws Exception {
        System.out.println("iniciar");
        ControladorLimpiadora instance = new ControladorLimpiadora();
        instance.iniciar();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class ControladorLimpiadora.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControladorLimpiadora instance = new ControladorLimpiadora();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}