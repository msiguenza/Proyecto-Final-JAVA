/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.EntidadCapacidad;
import Entidad.EntidadCliente;
import Entidad.EntidadEmpleado;
import Entidad.EntidadHabitación;
import Entidad.EntidadHotel;
import Entidad.EntidadPension;
import Entidad.EntidadPlanta;
import Entidad.EntidadRol;
import Entidad.EntidadTipos;
import Entidad.EntidadVistas;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
public class ControladorAdministradorTest {
    
    public ControladorAdministradorTest() {
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
     * Test of getEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetEmpleado() throws Exception {
        System.out.println("getEmpleado");
        
        String dniempleado = "30241073y";
        
        EntidadEmpleado empleado = new EntidadEmpleado(dniempleado);
        
        assertEquals(dniempleado, empleado.getDni());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHotel method, of class ControladorAdministrador.
     */
    @Test
    public void testGetHotel() throws Exception {
        System.out.println("getHotel");
        
        int plantas =4;
        EntidadHotel hotel = new EntidadHotel(plantas);
        assertEquals(plantas, hotel.getPlantas());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRoles method, of class ControladorAdministrador.
     */
    @Test
    public void testGetRoles() throws Exception {
        System.out.println("getRoles");
        String rol ="Administrador";
        EntidadRol entRol = new EntidadRol(rol);
        assertEquals(rol, entRol.getRol());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVistas method, of class ControladorAdministrador.
     */
    @Test
    public void testGetVistas_0args() throws Exception {
        System.out.println("getVistas");
        String vista ="Al campo";
        EntidadVistas vistas = new EntidadVistas(vista);
        
        assertEquals(vista, vistas.getVista());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTipos method, of class ControladorAdministrador.
     */
    @Test
    public void testGetTipos() throws Exception {
        System.out.println("getTipos");
        String tipo="Doble";
        EntidadTipos tipos = new EntidadTipos(tipo);
        assertEquals(tipo, tipos.getTipo());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testGetCapacidad_0args() throws Exception {
        System.out.println("getCapacidad");
        int capacidad = 1;
        EntidadCapacidad cap = new EntidadCapacidad(capacidad);
        assertEquals(capacidad, cap.getCapacidad());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetDniEmpleado() throws Exception {
        System.out.println("getDniEmpleado");
        EntidadEmpleado filtrarEmpleadoDni = null;
        List expResult = null;
        List result = ControladorAdministrador.getDniEmpleado(filtrarEmpleadoDni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNombreEmpleado() throws Exception {
        System.out.println("getNombreEmpleado");
        EntidadEmpleado filtrarEmpleadoNombre = null;
        List expResult = null;
        List result = ControladorAdministrador.getNombreEmpleado(filtrarEmpleadoNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidosEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetApellidosEmpleado() throws Exception {
        System.out.println("getApellidosEmpleado");
        EntidadEmpleado filtrarEmpleadoApellidos = null;
        List expResult = null;
        List result = ControladorAdministrador.getApellidosEmpleado(filtrarEmpleadoApellidos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRolEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetRolEmpleado() throws Exception {
        System.out.println("getRolEmpleado");
        EntidadEmpleado filtrarEmpleadoRol = null;
        List expResult = null;
        List result = ControladorAdministrador.getRolEmpleado(filtrarEmpleadoRol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetDniCliente() throws Exception {
        System.out.println("getDniCliente");
        EntidadCliente filtrarClienteDni = null;
        List expResult = null;
        List result = ControladorAdministrador.getDniCliente(filtrarClienteDni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNombreCliente() throws Exception {
        System.out.println("getNombreCliente");
        EntidadCliente filtrarClienteNombre = null;
        List expResult = null;
        List result = ControladorAdministrador.getNombreCliente(filtrarClienteNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidosCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetApellidosCliente() throws Exception {
        System.out.println("getApellidosCliente");
        EntidadCliente filtrarClienteApellidos = null;
        List expResult = null;
        List result = ControladorAdministrador.getApellidosCliente(filtrarClienteApellidos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaNacimientoCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetFechaNacimientoCliente() throws Exception {
        System.out.println("getFechaNacimientoCliente");
        EntidadCliente filtrarClienteFechaNacimiento = null;
        List expResult = null;
        List result = ControladorAdministrador.getFechaNacimientoCliente(filtrarClienteFechaNacimiento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPaisCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetPaisCliente() throws Exception {
        System.out.println("getPaisCliente");
        EntidadCliente filtrarClientePais = null;
        List expResult = null;
        List result = ControladorAdministrador.getPaisCliente(filtrarClientePais);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalidadCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetLocalidadCliente() throws Exception {
        System.out.println("getLocalidadCliente");
        EntidadCliente filtrarClienteLocalidad = null;
        List expResult = null;
        List result = ControladorAdministrador.getLocalidadCliente(filtrarClienteLocalidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProvinciaCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetProvinciaCliente() throws Exception {
        System.out.println("getProvinciaCliente");
        EntidadCliente filtrarClienteProvincia = null;
        List expResult = null;
        List result = ControladorAdministrador.getProvinciaCliente(filtrarClienteProvincia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNHabitacion method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNHabitacion() throws Exception {
        System.out.println("getNHabitacion");
        EntidadHabitación filtrarNHabitacion = null;
        List expResult = null;
        List result = ControladorAdministrador.getNHabitacion(filtrarNHabitacion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNPlanta method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNPlanta() throws Exception {
        System.out.println("getNPlanta");
        EntidadHabitación filtrarNPlanta = null;
        List expResult = null;
        List result = ControladorAdministrador.getNPlanta(filtrarNPlanta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVistas method, of class ControladorAdministrador.
     */
    @Test
    public void testGetVistas_EntidadHabitación() throws Exception {
        System.out.println("getVistas");
        EntidadHabitación filtrarVistas = null;
        List expResult = null;
        List result = ControladorAdministrador.getVistas(filtrarVistas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class ControladorAdministrador.
     */
    @Test
    public void testGetTipo() throws Exception {
        System.out.println("getTipo");
        EntidadHabitación filtrarTipo = null;
        List expResult = null;
        List result = ControladorAdministrador.getTipo(filtrarTipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testGetCapacidad_EntidadHabitación() throws Exception {
        System.out.println("getCapacidad");
        EntidadHabitación filtrarCapacidad = null;
        List expResult = null;
        List result = ControladorAdministrador.getCapacidad(filtrarCapacidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPension method, of class ControladorAdministrador.
     */
    @Test
    public void testGetPension() throws Exception {
        System.out.println("getPension");
        String pension ="Pensión completa";
        int precio = 40;
        EntidadPension pensiones = new EntidadPension(pension, precio);
        assertEquals(pension, pensiones.getPension());
        assertEquals(precio, pensiones.getPrecio());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class ControladorAdministrador.
     */
    @Test
    public void testGetEstado() throws Exception {
        System.out.println("getEstado");
        EntidadHabitación filtrarEstado = null;
        List expResult = null;
        List result = ControladorAdministrador.getEstado(filtrarEstado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDniLimpiadora method, of class ControladorAdministrador.
     */
    @Test
    public void testGetDniLimpiadora() throws Exception {
        System.out.println("getDniLimpiadora");
        EntidadHabitación filtrarDniLimpiadora = null;
        List expResult = null;
        List result = ControladorAdministrador.getDniLimpiadora(filtrarDniLimpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreLimpiadora method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNombreLimpiadora() throws Exception {
        System.out.println("getNombreLimpiadora");
        EntidadEmpleado filtrarNombreLimpiadora = null;
        List expResult = null;
        List result = ControladorAdministrador.getNombreLimpiadora(filtrarNombreLimpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarHotel method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarHotel() throws Exception {
        System.out.println("insertarHotel");
        EntidadHotel nuevoHotel = null;
        ControladorAdministrador.insertarHotel(nuevoHotel);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarRoles method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarRoles() throws Exception {
        System.out.println("insertarRoles");
        EntidadRol nuevoRol = null;
        ControladorAdministrador.insertarRoles(nuevoRol);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarPlanta method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarPlanta() throws Exception {
        System.out.println("insertarPlanta");
        EntidadPlanta nuevaPlanta = null;
        ControladorAdministrador.insertarPlanta(nuevaPlanta);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarVistas method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarVistas() throws Exception {
        System.out.println("insertarVistas");
        EntidadVistas nuevaVista = null;
        ControladorAdministrador.insertarVistas(nuevaVista);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarTipo method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarTipo() throws Exception {
        System.out.println("insertarTipo");
        EntidadTipos nuevoTipo = null;
        ControladorAdministrador.insertarTipo(nuevoTipo);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarCapacidad() throws Exception {
        System.out.println("insertarCapacidad");
        EntidadCapacidad nuevaCapacidad = null;
        ControladorAdministrador.insertarCapacidad(nuevaCapacidad);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarPensiones method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarPensiones() throws Exception {
        System.out.println("insertarPensiones");
        EntidadPension nuevaPension = null;
        ControladorAdministrador.insertarPensiones(nuevaPension);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testInsertarEmpleado() throws Exception {
        System.out.println("insertarEmpleado");
        EntidadEmpleado nuevoEmpleado = null;
        ControladorAdministrador.insertarEmpleado(nuevoEmpleado);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarHotel method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarHotel() throws Exception {
        System.out.println("modificarHotel");
        EntidadHotel modificarHotel = null;
        ControladorAdministrador.modificarHotel(modificarHotel);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarCapacidad() throws Exception {
        System.out.println("eliminarCapacidad");
        EntidadCapacidad eliminarCapacidad = null;
        ControladorAdministrador.eliminarCapacidad(eliminarCapacidad);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarRol method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarRol() throws Exception {
        System.out.println("eliminarRol");
        EntidadRol eliminarRol = null;
        ControladorAdministrador.eliminarRol(eliminarRol);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipo method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarTipo() throws Exception {
        System.out.println("eliminarTipo");
        EntidadTipos eliminarTipo = null;
        ControladorAdministrador.eliminarTipo(eliminarTipo);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVistas method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarVistas() throws Exception {
        System.out.println("eliminarVistas");
        EntidadVistas eliminarVista = null;
        ControladorAdministrador.eliminarVistas(eliminarVista);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPension method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarPension() throws Exception {
        System.out.println("eliminarPension");
        EntidadPension eliminarPension = null;
        ControladorAdministrador.eliminarPension(eliminarPension);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarEmpleados method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarEmpleados() throws Exception {
        System.out.println("eliminarEmpleados");
        EntidadEmpleado eliminarEmpleados = null;
        ControladorAdministrador.eliminarEmpleados(eliminarEmpleados);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleados method, of class ControladorAdministrador.
     */
    @Test
    public void testGetEmpleados() throws Exception {
        System.out.println("getEmpleados");
        String dni = "30241073y";
        EntidadEmpleado empleado = new EntidadEmpleado(dni);
        assertEquals(dni, empleado.getDni());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testGetCliente() throws Exception {
        System.out.println("getCliente");
        int id =1;
        String dni = "30241073y";
        String nombre ="Silvia";
        String apellidos="Pérez Gómez";
        String direccion ="C/ Ojiva";
        int telefono = 666666666;
        String email ="silv@hotmail.com";
        String fecha ="02/09/1986";
        int cp = 41008;
        String localidad ="españa";
        String provincia ="sevilla";
        String pais ="sevilla";
        
        
        EntidadCliente cli = new EntidadCliente(id, dni, nombre, apellidos, direccion, telefono, email, fecha, cp, localidad, provincia, pais);
        assertEquals(id, cli.getId());
        assertEquals(dni, cli.getDni());
        assertEquals(nombre, cli.getNombre());
        assertEquals(apellidos, cli.getApellidos());
        assertEquals(direccion, cli.getDireccion());
        assertEquals(telefono, cli.getTelefono());
        assertEquals(email, cli.getEmail());
        assertEquals(fecha, cli.getFechaNacimiento());
        assertEquals(cp, cli.getCp());
        assertEquals(localidad, cli.getLocalidad());
        assertEquals(provincia, cli.getProvincia());
        assertEquals(pais, cli.getPais());
        
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHabitaciones method, of class ControladorAdministrador.
     */
    @Test
    public void testGetHabitaciones() throws Exception {
        System.out.println("getHabitaciones");
        int nHab = 101;
        int numplanta = 1;
        String vistas = "A la piscina";
        String tipo = "Simple";
        String estado ="Preparada";
        String dniLimpiadora = "30241169X";
        int capacidad = 1;
        String descripcion ="Habitación simple";
        int precio = 40;
        
        EntidadHabitación habitaciones = new EntidadHabitación(nHab, numplanta, vistas, tipo, estado, dniLimpiadora, capacidad, descripcion, precio);
        assertEquals(nHab, habitaciones.getNHabitacion());
        assertEquals(numplanta, habitaciones.getNPlanta());
        assertEquals(vistas, habitaciones.getVistas());
        assertEquals(tipo, habitaciones.getTipo());
        assertEquals(estado, habitaciones.getEstado());
        assertEquals(dniLimpiadora, habitaciones.getDniLimpiadora());
        assertEquals(capacidad, habitaciones.getCapacidad());
        assertEquals(descripcion, habitaciones.getDescripcion());
        assertEquals(precio, habitaciones.getPrecio());
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarCliente method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarCliente() throws Exception {
        System.out.println("modificarCliente");
        EntidadCliente modificarCliente = null;
        ControladorAdministrador.modificarCliente(modificarCliente);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarEmpleado method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarEmpleado() throws Exception {
        System.out.println("modificarEmpleado");
        EntidadEmpleado modificarEmpleado = null;
        ControladorAdministrador.modificarEmpleado(modificarEmpleado);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modificarHabitacion method, of class ControladorAdministrador.
     */
    @Test
    public void testModificarHabitacion() throws Exception {
        System.out.println("modificarHabitacion");
        EntidadHabitación modificarHabitacion = null;
        ControladorAdministrador.modificarHabitacion(modificarHabitacion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNplanta method, of class ControladorAdministrador.
     */
    @Test
    public void testGetNplanta() throws Exception {
        System.out.println("getNplanta");
        int expResult = 4;
        int result = ControladorAdministrador.getNplanta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registrarHabitaciones method, of class ControladorAdministrador.
     */
    @Test
    public void testRegistrarHabitaciones() throws Exception {
        System.out.println("registrarHabitaciones");
        EntidadHabitación nuevaHabitacion = null;
        ControladorAdministrador.registrarHabitaciones(nuevaHabitacion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarHabitacion method, of class ControladorAdministrador.
     */
    @Test
    public void testEliminarHabitacion() throws Exception {
        System.out.println("eliminarHabitacion");
        EntidadHabitación eliminarHabitacion = null;
        ControladorAdministrador.eliminarHabitacion(eliminarHabitacion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of asignarHabitacion method, of class ControladorAdministrador.
     */
    @Test
    public void testAsignarHabitacion() throws Exception {
        System.out.println("asignarHabitacion");
        EntidadHabitación habitacion = null;
        ControladorAdministrador.asignarHabitacion(habitacion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHabitaciones1 method, of class ControladorAdministrador.
     */
    @Test
    public void testGetHabitaciones1() throws Exception {
        System.out.println("getHabitaciones1");
        int nHab = 101;
        int numplanta = 1;
        String vistas = "A la piscina";
        String tipo = "Simple";
        String estado ="Preparada";
        String dniLimpiadora = "30241169X";
        int capacidad = 1;
        String descripcion ="Habitación simple";
        int precio = 40;
        
        EntidadHabitación habitaciones = new EntidadHabitación(nHab, numplanta, vistas, tipo, estado, dniLimpiadora, capacidad, descripcion, precio);
        assertEquals(nHab, habitaciones.getNHabitacion());
        assertEquals(numplanta, habitaciones.getNPlanta());
        assertEquals(vistas, habitaciones.getVistas());
        assertEquals(tipo, habitaciones.getTipo());
        assertEquals(estado, habitaciones.getEstado());
        assertEquals(dniLimpiadora, habitaciones.getDniLimpiadora());
        assertEquals(capacidad, habitaciones.getCapacidad());
        assertEquals(descripcion, habitaciones.getDescripcion());
        assertEquals(precio, habitaciones.getPrecio());
        
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLimpiadoras method, of class ControladorAdministrador.
     */
    @Test
    public void testGetLimpiadoras() throws Exception {
        System.out.println("getLimpiadoras");
        EntidadEmpleado limpiadora = null;
        List expResult = null;
        List result = ControladorAdministrador.getLimpiadoras(limpiadora);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of iniciar method, of class ControladorAdministrador.
     */
    @Test
    public void testIniciar() throws Exception {
        System.out.println("iniciar");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.iniciar();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class ControladorAdministrador.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarRoles method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarRoles() throws Exception {
        System.out.println("mostrarRoles");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarRoles();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarVistas method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarVistas() throws Exception {
        System.out.println("mostrarVistas");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarVistas();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarTipos method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarTipos() throws Exception {
        System.out.println("mostrarTipos");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarTipos();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarCapacidad() throws Exception {
        System.out.println("mostrarCapacidad");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarCapacidad();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPension method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarPension() throws Exception {
        System.out.println("mostrarPension");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarPension();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarClientes method, of class ControladorAdministrador.
     */
    @Test
    public void testMostrarClientes() {
        System.out.println("mostrarClientes");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.mostrarClientes();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboRoles method, of class ControladorAdministrador.
     */
    @Test
    public void testRellenarComboRoles() throws Exception {
        System.out.println("rellenarComboRoles");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.rellenarComboRoles();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboRoles1 method, of class ControladorAdministrador.
     */
    @Test
    public void testRellenarComboRoles1() throws Exception {
        System.out.println("rellenarComboRoles1");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.rellenarComboRoles1();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboCapacidad method, of class ControladorAdministrador.
     */
    @Test
    public void testRellenarComboCapacidad() throws Exception {
        System.out.println("rellenarComboCapacidad");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.rellenarComboCapacidad();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboVista method, of class ControladorAdministrador.
     */
    @Test
    public void testRellenarComboVista() throws Exception {
        System.out.println("rellenarComboVista");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.rellenarComboVista();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rellenarComboTipo method, of class ControladorAdministrador.
     */
    @Test
    public void testRellenarComboTipo() throws Exception {
        System.out.println("rellenarComboTipo");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.rellenarComboTipo();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of detener method, of class ControladorAdministrador.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.detener();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destruir method, of class ControladorAdministrador.
     */
    @Test
    public void testDestruir() {
        System.out.println("destruir");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.destruir();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dibujarGIU method, of class ControladorAdministrador.
     */
    @Test
    public void testDibujarGIU() {
        System.out.println("dibujarGIU");
        ControladorAdministrador instance = new ControladorAdministrador();
        instance.dibujarGIU();
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}