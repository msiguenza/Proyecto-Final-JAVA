/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.EntidadCheckIn;
import Entidad.EntidadCheckOut;
import Entidad.EntidadCliente;
import Entidad.EntidadEmpleado;
import Entidad.EntidadHabitación;
import Entidad.EntidadPago;
import Entidad.EntidadPension;
import Entidad.EntidadReserva;
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
public class ControladorRecepcionistaTest {
    
    public ControladorRecepcionistaTest() {
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
     * Test of registrarClientes method, of class ControladorRecepcionista.
     */
    @Test
    public void testRegistrarClientes() throws Exception {
        System.out.println("registrarClientes");
        EntidadCliente nuevoCliente = null;
        ControladorRecepcionista.registrarClientes(nuevoCliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarCheckIn method, of class ControladorRecepcionista.
     */
    @Test
    public void testInsertarCheckIn() throws Exception {
        System.out.println("insertarCheckIn");
        EntidadCheckIn nuevoCheckIn = null;
        ControladorRecepcionista.insertarCheckIn(nuevoCheckIn);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarCheckOut method, of class ControladorRecepcionista.
     */
    @Test
    public void testInsertarCheckOut() throws Exception {
        System.out.println("insertarCheckOut");
        EntidadCheckOut nuevoCheckOut = null;
        ControladorRecepcionista.insertarCheckOut(nuevoCheckOut);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarCobro method, of class ControladorRecepcionista.
     */
    @Test
    public void testInsertarCobro() throws Exception {
        System.out.println("insertarCobro");
        EntidadCheckIn nuevoCobro = null;
        ControladorRecepcionista.insertarCobro(nuevoCobro);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarHabitaciones method, of class ControladorRecepcionista.
     */
    @Test
    public void testRegistrarHabitaciones() throws Exception {
        System.out.println("registrarHabitaciones");
        EntidadHabitación nuevaHabitacion = null;
        ControladorRecepcionista.registrarHabitaciones(nuevaHabitacion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetCliente() throws Exception {
        System.out.println("getCliente");
        EntidadReserva reservaCliente = null;
        List expResult = null;
        List result = ControladorRecepcionista.getCliente(reservaCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getClientes method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetClientes() throws Exception {
        System.out.println("getClientes");
        List expResult = null;
        List result = ControladorRecepcionista.getClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniClienteReservaFechaEntrada method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetDniClienteReservaFechaEntrada() throws Exception {
        System.out.println("getDniClienteReservaFechaEntrada");
        EntidadReserva dniClienteFechaReserva = null;
        List expResult = null;
        List result = ControladorRecepcionista.getDniClienteReservaFechaEntrada(dniClienteFechaReserva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLimpiadoras method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetLimpiadoras() throws Exception {
        System.out.println("getLimpiadoras");
        EntidadEmpleado limpiadora = null;
        List expResult = null;
        List result = ControladorRecepcionista.getLimpiadoras(limpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHabitaciones method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetHabitaciones() throws Exception {
        System.out.println("getHabitaciones");
        List expResult = null;
        List result = ControladorRecepcionista.getHabitaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetDniCliente() throws Exception {
        System.out.println("getDniCliente");
        EntidadCliente filtrarClienteDni = null;
        List expResult = null;
        List result = ControladorRecepcionista.getDniCliente(filtrarClienteDni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNacimientoCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFechaNacimientoCliente() throws Exception {
        System.out.println("getFechaNacimientoCliente");
        EntidadCliente filtrarClienteFechaNacimiento = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFechaNacimientoCliente(filtrarClienteFechaNacimiento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPaisCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetPaisCliente() throws Exception {
        System.out.println("getPaisCliente");
        EntidadCliente filtrarClientePais = null;
        List expResult = null;
        List result = ControladorRecepcionista.getPaisCliente(filtrarClientePais);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalidadCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetLocalidadCliente() throws Exception {
        System.out.println("getLocalidadCliente");
        EntidadCliente filtrarClienteLocalidad = null;
        List expResult = null;
        List result = ControladorRecepcionista.getLocalidadCliente(filtrarClienteLocalidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProvinciaCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetProvinciaCliente() throws Exception {
        System.out.println("getProvinciaCliente");
        EntidadCliente filtrarClienteProvincia = null;
        List expResult = null;
        List result = ControladorRecepcionista.getProvinciaCliente(filtrarClienteProvincia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNombreCliente() throws Exception {
        System.out.println("getNombreCliente");
        EntidadCliente filtrarClienteNombre = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNombreCliente(filtrarClienteNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidosCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetApellidosCliente() throws Exception {
        System.out.println("getApellidosCliente");
        EntidadCliente filtrarClienteApellidos = null;
        List expResult = null;
        List result = ControladorRecepcionista.getApellidosCliente(filtrarClienteApellidos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNHabitacion method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNHabitacion() throws Exception {
        System.out.println("getNHabitacion");
        EntidadHabitación filtrarNHabitacion = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNHabitacion(filtrarNHabitacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNPlanta method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNPlanta() throws Exception {
        System.out.println("getNPlanta");
        EntidadHabitación filtrarNPlanta = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNPlanta(filtrarNPlanta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVistas method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetVistas() throws Exception {
        System.out.println("getVistas");
        EntidadHabitación filtrarVistas = null;
        List expResult = null;
        List result = ControladorRecepcionista.getVistas(filtrarVistas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetTipo() throws Exception {
        System.out.println("getTipo");
        EntidadHabitación filtrarTipo = null;
        List expResult = null;
        List result = ControladorRecepcionista.getTipo(filtrarTipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidad method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetCapacidad_EntidadHabitación() throws Exception {
        System.out.println("getCapacidad");
        EntidadHabitación filtrarCapacidad = null;
        List expResult = null;
        List result = ControladorRecepcionista.getCapacidad(filtrarCapacidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetEstado() throws Exception {
        System.out.println("getEstado");
        EntidadHabitación filtrarEstado = null;
        List expResult = null;
        List result = ControladorRecepcionista.getEstado(filtrarEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniLimpiadora method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetDniLimpiadora() throws Exception {
        System.out.println("getDniLimpiadora");
        EntidadHabitación filtrarDniLimpiadora = null;
        List expResult = null;
        List result = ControladorRecepcionista.getDniLimpiadora(filtrarDniLimpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBuscarPrecio method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetBuscarPrecio() throws Exception {
        System.out.println("getBuscarPrecio");
        EntidadHabitación filtrarPrecio = null;
        List expResult = null;
        List result = ControladorRecepcionista.getBuscarPrecio(filtrarPrecio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNHabitacionReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNHabitacionReserva() throws Exception {
        System.out.println("getNHabitacionReserva");
        EntidadReserva filtrarNHabitacion = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNHabitacionReserva(filtrarNHabitacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEntradaReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFechaEntradaReserva() throws Exception {
        System.out.println("getFechaEntradaReserva");
        EntidadReserva filtrarFechaEntrada = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFechaEntradaReserva(filtrarFechaEntrada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEntradaDniCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFechaEntradaDniCliente() throws Exception {
        System.out.println("getFechaEntradaDniCliente");
        EntidadReserva filtrarFechaEntradaDniCliente = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFechaEntradaDniCliente(filtrarFechaEntradaDniCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaSalidaReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFechaSalidaReserva() throws Exception {
        System.out.println("getFechaSalidaReserva");
        EntidadReserva filtrarFechaSalida = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFechaSalidaReserva(filtrarFechaSalida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniClienteReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetDniClienteReserva() throws Exception {
        System.out.println("getDniClienteReserva");
        EntidadReserva filtrarDniCliente = null;
        List expResult = null;
        List result = ControladorRecepcionista.getDniClienteReserva(filtrarDniCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNPersonasReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNPersonasReserva() throws Exception {
        System.out.println("getNPersonasReserva");
        EntidadReserva filtrarNPersonas = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNPersonasReserva(filtrarNPersonas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombrePension method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetNombrePension() throws Exception {
        System.out.println("getNombrePension");
        EntidadPension filtrarPension = null;
        List expResult = null;
        List result = ControladorRecepcionista.getNombrePension(filtrarPension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecioPension method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetPrecioPension() throws Exception {
        System.out.println("getPrecioPension");
        EntidadPension filtrarPrecio = null;
        List expResult = null;
        List result = ControladorRecepcionista.getPrecioPension(filtrarPrecio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaSalidaCheckOut method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFechaSalidaCheckOut() throws Exception {
        System.out.println("getFechaSalidaCheckOut");
        EntidadReserva filtrarFechaSalida = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFechaSalidaCheckOut(filtrarFechaSalida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPago method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetPago() throws Exception {
        System.out.println("getPago");
        EntidadPago filtrarPago = null;
        List expResult = null;
        List result = ControladorRecepcionista.getPago(filtrarPago);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testModificarCliente() throws Exception {
        System.out.println("modificarCliente");
        EntidadCliente modificarCliente = null;
        ControladorRecepcionista.modificarCliente(modificarCliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarCobro method, of class ControladorRecepcionista.
     */
    @Test
    public void testModificarCobro() throws Exception {
        System.out.println("modificarCobro");
        EntidadCheckIn modificarCobro = null;
        ControladorRecepcionista.modificarCobro(modificarCobro);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidad method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetCapacidad_0args() throws Exception {
        System.out.println("getCapacidad");
        List expResult = null;
        List result = ControladorRecepcionista.getCapacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetFecha() throws Exception {
        System.out.println("getFecha");
        EntidadReserva er = null;
        List expResult = null;
        List result = ControladorRecepcionista.getFecha(er);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPago method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarPago() throws Exception {
        System.out.println("mostrarPago");
        EntidadPago epa = null;
        List expResult = null;
        List result = ControladorRecepcionista.mostrarPago(epa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckIn method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetCheckIn() throws Exception {
        System.out.println("getCheckIn");
        EntidadCheckIn echi = null;
        List expResult = null;
        List result = ControladorRecepcionista.getCheckIn(echi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPension method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetPension() throws Exception {
        System.out.println("getPension");
        List expResult = null;
        List result = ControladorRecepcionista.getPension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testInsertarReserva() throws Exception {
        System.out.println("insertarReserva");
        EntidadReserva nuevaReserva = null;
        ControladorRecepcionista.insertarReserva(nuevaReserva);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getReservas method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetReservas() throws Exception {
        System.out.println("getReservas");
        List expResult = null;
        List result = ControladorRecepcionista.getReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrecio method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetPrecio() throws Exception {
        System.out.println("getPrecio");
        List expResult = null;
        List result = ControladorRecepcionista.getPrecio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getReservasClientes method, of class ControladorRecepcionista.
     */
    @Test
    public void testGetReservasClientes() throws Exception {
        System.out.println("getReservasClientes");
        EntidadReserva reservasClientes = null;
        List expResult = null;
        List result = ControladorRecepcionista.getReservasClientes(reservasClientes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testEliminarReserva() throws Exception {
        System.out.println("eliminarReserva");
        EntidadReserva eliminarReserva = null;
        ControladorRecepcionista.eliminarReserva(eliminarReserva);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iniciar method, of class ControladorRecepcionista.
     */
    @Test
    public void testIniciar() throws Exception {
        System.out.println("iniciar");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.iniciar();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class ControladorRecepcionista.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCapacidad method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarCapacidad() throws Exception {
        System.out.println("mostrarCapacidad");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarCapacidad();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarClientes method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarClientes() {
        System.out.println("mostrarClientes");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarClientes();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaReservaCliente method, of class ControladorRecepcionista.
     */
    @Test
    public void testConsultaReservaCliente() {
        System.out.println("consultaReservaCliente");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.consultaReservaCliente();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarHabitaciones method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarHabitaciones() {
        System.out.println("mostrarHabitaciones");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarHabitaciones();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboHabitaciones method, of class ControladorRecepcionista.
     */
    @Test
    public void testRellenarComboHabitaciones() {
        System.out.println("rellenarComboHabitaciones");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.rellenarComboHabitaciones();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboReservas method, of class ControladorRecepcionista.
     */
    @Test
    public void testRellenarComboReservas() {
        System.out.println("rellenarComboReservas");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.rellenarComboReservas();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboPension method, of class ControladorRecepcionista.
     */
    @Test
    public void testRellenarComboPension() {
        System.out.println("rellenarComboPension");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.rellenarComboPension();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboClientes method, of class ControladorRecepcionista.
     */
    @Test
    public void testRellenarComboClientes() {
        System.out.println("rellenarComboClientes");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.rellenarComboClientes();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboCapacidad method, of class ControladorRecepcionista.
     */
    @Test
    public void testRellenarComboCapacidad() throws Exception {
        System.out.println("rellenarComboCapacidad");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.rellenarComboCapacidad();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPensiones method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarPensiones() throws Exception {
        System.out.println("mostrarPensiones");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarPensiones();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verPagos method, of class ControladorRecepcionista.
     */
    @Test
    public void testVerPagos() throws Exception {
        System.out.println("verPagos");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.verPagos();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of entradasHoy method, of class ControladorRecepcionista.
     */
    @Test
    public void testEntradasHoy() {
        System.out.println("entradasHoy");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.entradasHoy();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of salidasHoy method, of class ControladorRecepcionista.
     */
    @Test
    public void testSalidasHoy() {
        System.out.println("salidasHoy");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.salidasHoy();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformeCheckIn method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarInformeCheckIn() {
        System.out.println("mostrarInformeCheckIn");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarInformeCheckIn();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformeCheckOut method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarInformeCheckOut() {
        System.out.println("mostrarInformeCheckOut");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarInformeCheckOut();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformePension method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarInformePension() {
        System.out.println("mostrarInformePension");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarInformePension();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformeCaja method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarInformeCaja() {
        System.out.println("mostrarInformeCaja");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarInformeCaja();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInformeReserva method, of class ControladorRecepcionista.
     */
    @Test
    public void testMostrarInformeReserva() {
        System.out.println("mostrarInformeReserva");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.mostrarInformeReserva();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of detener method, of class ControladorRecepcionista.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.detener();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destruir method, of class ControladorRecepcionista.
     */
    @Test
    public void testDestruir() {
        System.out.println("destruir");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.destruir();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarGIU method, of class ControladorRecepcionista.
     */
    @Test
    public void testDibujarGIU() {
        System.out.println("dibujarGIU");
        ControladorRecepcionista instance = new ControladorRecepcionista();
        instance.dibujarGIU();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}