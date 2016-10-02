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
public class EntidadEmpleadoTest {
    
    public EntidadEmpleadoTest() {
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
     * Test of getId method, of class EntidadEmpleado.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        EntidadEmpleado instance = new EntidadEmpleado();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class EntidadEmpleado.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class EntidadEmpleado.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProvincia method, of class EntidadEmpleado.
     */
    @Test
    public void testGetProvincia() {
        System.out.println("getProvincia");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getProvincia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProvincia method, of class EntidadEmpleado.
     */
    @Test
    public void testSetProvincia() {
        System.out.println("setProvincia");
        String provincia = "";
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setProvincia(provincia);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalidad method, of class EntidadEmpleado.
     */
    @Test
    public void testGetLocalidad() {
        System.out.println("getLocalidad");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getLocalidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLocalidad method, of class EntidadEmpleado.
     */
    @Test
    public void testSetLocalidad() {
        System.out.println("setLocalidad");
        String localidad = "";
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setLocalidad(localidad);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPais method, of class EntidadEmpleado.
     */
    @Test
    public void testGetPais() {
        System.out.println("getPais");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getPais();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPais method, of class EntidadEmpleado.
     */
    @Test
    public void testSetPais() {
        System.out.println("setPais");
        String pais = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setPais(pais);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCp method, of class EntidadEmpleado.
     */
    @Test
    public void testGetCp() {
        System.out.println("getCp");
        EntidadEmpleado instance = new EntidadEmpleado();
        int expResult = 0;
        int result = instance.getCp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCp method, of class EntidadEmpleado.
     */
    @Test
    public void testSetCp() {
        System.out.println("setCp");
        int cp = 0;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setCp(cp);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class EntidadEmpleado.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class EntidadEmpleado.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class EntidadEmpleado.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class EntidadEmpleado.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class EntidadEmpleado.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class EntidadEmpleado.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidos method, of class EntidadEmpleado.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setApellidos(apellidos);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class EntidadEmpleado.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class EntidadEmpleado.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class EntidadEmpleado.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class EntidadEmpleado.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getClave method, of class EntidadEmpleado.
     */
    @Test
    public void testGetClave() {
        System.out.println("getClave");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setClave method, of class EntidadEmpleado.
     */
    @Test
    public void testSetClave() {
        System.out.println("setClave");
        String clave = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setClave(clave);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class EntidadEmpleado.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        EntidadEmpleado instance = new EntidadEmpleado();
        int expResult = 0;
        int result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class EntidadEmpleado.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        int telefono = 0;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRol method, of class EntidadEmpleado.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        EntidadEmpleado instance = new EntidadEmpleado();
        String expResult = "";
        String result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class EntidadEmpleado.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        String rol = null;
        EntidadEmpleado instance = new EntidadEmpleado();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to //fail.
        //fail("The test case is a prototype.");
    }
}