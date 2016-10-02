/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexiones.Conexiones;
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
import Modelo.ModeloCliente;
import Modelo.ModeloEmpleados;
import Modelo.ModeloHabitacion;
import Modelo.ModeloHotel;
import Vistas.DialogMantenimiento;
import Vistas.VistaAdministrador;
import Singleton_State.VistaLoggin;
import Vistas.validaciones;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.icepdf.ri.common.MyAnnotationCallback;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author Silvia
 */
public class ControladorAdministrador implements ActionListener
{
    VistaLoggin loggeo = new VistaLoggin();
    validaciones val = new validaciones();
    VistaAdministrador vistaAdmin = new VistaAdministrador();
    DialogMantenimiento dialog = new DialogMantenimiento(vistaAdmin, true);
    
    EntidadHotel eh = new EntidadHotel();
    EntidadRol er = new EntidadRol();
    EntidadVistas ev = new EntidadVistas();
    EntidadTipos et = new EntidadTipos();
    EntidadCapacidad ec = new EntidadCapacidad();
    EntidadEmpleado ee = new EntidadEmpleado();
    EntidadHabitación eha = new EntidadHabitación();
    EntidadCliente ecl = new EntidadCliente();
    EntidadPlanta ep = new EntidadPlanta();
    EntidadPension epe = new EntidadPension();
    
     //reportes
    SwingController controlador = new SwingController();
    
    String usuarioSesion, respuesta, capacidad1, rol, tipo, vista, id1, nombre, apellidos, direccion, 
            dni, telefono1, usuario, clave, numhab1, numplanta1, vistas, estado, dnilimpiadora, disponible, pension;
    int filaSelec, filaSelec1, filaSelec2, filaSelec3, resp, resp1, resp2, resp3, capacidad, j, contador, id, telefono,
            numhab=0, numplanta=0, numPlanta2 = 0, filaSeleLimp=0, filaSelecHab =0;
    boolean encontrado = false, camposCorrectos = false, comprobarUsuario = false;
    ButtonGroup grupo = new ButtonGroup();
    
    InputMap map = new InputMap();
    TableColumn sportColumn, sportColumn1, sportColumn2, sportColumn3, sportColumn4;
    JComboBox comboBox, comboBox1, comboBox2, comboBox3;
    JButton boton;
    
    public ControladorAdministrador()
    {
        
    }
    
    public ControladorAdministrador(VistaLoggin loggeo, VistaAdministrador vistaAdmin)
    {
        this.loggeo= loggeo;
        this.vistaAdmin = vistaAdmin;
    }
    
    
    
    //COMPROBAR EMPLEADOS
	
    public static List<EntidadEmpleado> getEmpleado() throws SQLException, Exception 
    {
           return ModeloEmpleados.getEmpleado();
    }
    
    //COMPROBAR HOTEL
	
    public static List<EntidadHotel> getHotel() throws SQLException, Exception 
    {
           return ModeloHotel.getHotel();
    }
    
    public static List<EntidadRol> getRoles() throws SQLException, Exception 
    {
           return ModeloHotel.getRoles();
    }
    
    public static List<EntidadVistas> getVistas() throws SQLException, Exception 
    {
           return ModeloHotel.getVistas();
    }
    
    public static List<EntidadTipos> getTipos() throws SQLException, Exception 
    {
           return ModeloHotel.getTipos();
    }
    
    public static List<EntidadCapacidad> getCapacidad() throws SQLException, Exception 
    {
           return ModeloHotel.getCapacidad();
    }
    
    //FILTRAR BUSQUEDA EMPLEADOS
    
        //buscar por dni
		
	public static List<EntidadEmpleado> getDniEmpleado(EntidadEmpleado filtrarEmpleadoDni) throws SQLException, Exception 
	{
		return ModeloEmpleados.getDniEmpleado(filtrarEmpleadoDni);
	}
        
        //buscar por nombre
		
	public static List<EntidadEmpleado> getNombreEmpleado(EntidadEmpleado filtrarEmpleadoNombre) throws SQLException, Exception 
	{
		return ModeloEmpleados.getNombreEmpleado(filtrarEmpleadoNombre);
	}
        
        //buscar por apellidos
		
	public static List<EntidadEmpleado> getApellidosEmpleado(EntidadEmpleado filtrarEmpleadoApellidos) throws SQLException, Exception 
	{
		return ModeloEmpleados.getApellidosEmpleado(filtrarEmpleadoApellidos);
	}
        
        //buscar por rol
		
	public static List<EntidadEmpleado> getRolEmpleado(EntidadEmpleado filtrarEmpleadoRol) throws SQLException, Exception 
	{
		return ModeloEmpleados.getRolEmpleado(filtrarEmpleadoRol);
	}
    
        
        //FILTRAR BUSQUEDA CLIENTES
        
        //buscar por dni
		
	public static List<EntidadCliente> getDniCliente(EntidadCliente filtrarClienteDni) throws SQLException, Exception 
	{
		return ModeloCliente.getDniCliente(filtrarClienteDni);
	}
        
        //buscar por nombre
        
        public static List<EntidadCliente> getNombreCliente(EntidadCliente filtrarClienteNombre) throws SQLException, Exception 
	{
		return ModeloCliente.getNombreCliente(filtrarClienteNombre);
	}
        
        
        //buscar por apellidos
        
        public static List<EntidadCliente> getApellidosCliente(EntidadCliente filtrarClienteApellidos) throws SQLException, Exception 
	{
		return ModeloCliente.getApellidosCliente(filtrarClienteApellidos);
	}
        
        //buscar por fecha de nacimiento
		
	public static List<EntidadCliente> getFechaNacimientoCliente(EntidadCliente filtrarClienteFechaNacimiento) throws SQLException, Exception 
	{
		return ModeloCliente.getFechaNacimientoCliente(filtrarClienteFechaNacimiento);
	}
        
        //buscar por pais
        
	public static List<EntidadCliente> getPaisCliente(EntidadCliente filtrarClientePais) throws SQLException, Exception 
	{
		return ModeloCliente.getPaisCliente(filtrarClientePais);
	}
        
        //buscar por localidad
        
	public static List<EntidadCliente> getLocalidadCliente(EntidadCliente filtrarClienteLocalidad) throws SQLException, Exception 
	{
		return ModeloCliente.getLocalidadCliente(filtrarClienteLocalidad);
	}
        
        //buscar por provincia
        
	public static List<EntidadCliente> getProvinciaCliente(EntidadCliente filtrarClienteProvincia) throws SQLException, Exception 
	{
		return ModeloCliente.getProvinciaCliente(filtrarClienteProvincia);
	}
        
        //buscar por habitacion
        
	public static List<EntidadHabitación> getNHabitacion(EntidadHabitación filtrarNHabitacion) throws SQLException, Exception 
	{
		return ModeloHabitacion.getNHabitacion(filtrarNHabitacion);
	}
        
        //buscar por planta
        
	public static List<EntidadHabitación> getNPlanta(EntidadHabitación filtrarNPlanta) throws SQLException, Exception 
	{
		return ModeloHabitacion.getNPlanta(filtrarNPlanta);
	}
        
        //buscar por vistas
        
        public static List<EntidadHabitación> getVistas(EntidadHabitación filtrarVistas) throws SQLException, Exception 
	{
		return ModeloHabitacion.getVistas(filtrarVistas);
	}
        
        //buscar por tipo
        
        public static List<EntidadHabitación> getTipo(EntidadHabitación filtrarTipo) throws SQLException, Exception 
	{
		return ModeloHabitacion.getTipo(filtrarTipo);
	}
        
        //buscar por capacidad
        
        public static List<EntidadHabitación> getCapacidad(EntidadHabitación filtrarCapacidad) throws SQLException, Exception 
	{
		return ModeloHabitacion.getCapacidad(filtrarCapacidad);
	}
        
        //buscar por pension
        
        public static List<EntidadPension> getPension() throws SQLException, Exception 
	{
		return ModeloHotel.getPension();
	}
        
        //buscar por estado
        
        public static List<EntidadHabitación> getEstado(EntidadHabitación filtrarEstado) throws SQLException, Exception 
	{
		return ModeloHabitacion.getEstado(filtrarEstado);
	}
        
        //buscar por dni limpiadora
        
        public static List<EntidadHabitación> getDniLimpiadora(EntidadHabitación filtrarDniLimpiadora) throws SQLException, Exception 
	{
		return ModeloHabitacion.getDniLimpiadora(filtrarDniLimpiadora);
	}
        
        
        //buscar por nombre limpiadora
        
        public static List<EntidadEmpleado> getNombreLimpiadora(EntidadEmpleado filtrarNombreLimpiadora) throws SQLException, Exception 
	{
		return ModeloEmpleados.getNombreLimpiadora(filtrarNombreLimpiadora);
	}
        
        
        
    //REGISTRAR HOTEL
	
    public static void insertarHotel(EntidadHotel nuevoHotel) throws Exception 
    {
            ModeloHotel.insertarHotel(nuevoHotel);
    }
    
    public static void insertarRoles(EntidadRol nuevoRol) throws Exception 
    {
            ModeloHotel.insertarRoles(nuevoRol);
    }
    
    public static void insertarPlanta(EntidadPlanta nuevaPlanta) throws Exception 
    {
            ModeloHotel.insertarPlanta(nuevaPlanta);
    }
    
    public static void insertarVistas(EntidadVistas nuevaVista) throws Exception 
    {
            ModeloHotel.insertarVistas(nuevaVista);
    }
    
    public static void insertarTipo(EntidadTipos nuevoTipo) throws Exception 
    {
            ModeloHotel.insertarTipo(nuevoTipo);
    }
    
    public static void insertarCapacidad(EntidadCapacidad nuevaCapacidad) throws Exception 
    {
            ModeloHotel.insertarCapacidad(nuevaCapacidad);
    }
    
    public static void insertarPensiones(EntidadPension nuevaPension) throws Exception 
    {
            ModeloHotel.insertarPension(nuevaPension);
    }
    
    
    
    
    //REGISTRAR EMPLEADOS
	
    public static void insertarEmpleado(EntidadEmpleado nuevoEmpleado) throws Exception 
    {
            ModeloEmpleados.insertarEmpleado(nuevoEmpleado);
    }
    
    
    
    //MODIFICAR DESDE LA TABLA
    
    public static void modificarHotel(EntidadHotel modificarHotel) throws Exception 
    {
            ModeloHotel.modificarHotel(modificarHotel);
    }
    
    //ELIMINAR DESDE TABLA
	
    public static void eliminarCapacidad(EntidadCapacidad eliminarCapacidad) throws Exception 
    {
            ModeloHotel.eliminarCapacidad(eliminarCapacidad);
    }
    
    public static void eliminarRol(EntidadRol eliminarRol) throws Exception 
    {
            ModeloHotel.eliminarRol(eliminarRol);
    }
    
    public static void eliminarTipo(EntidadTipos eliminarTipo) throws Exception 
    {
            ModeloHotel.eliminarTipo(eliminarTipo);
    }
    
    public static void eliminarVistas(EntidadVistas eliminarVista) throws Exception 
    {
            ModeloHotel.eliminarVista(eliminarVista);
    }
    
    public static void eliminarPension(EntidadPension eliminarPension) throws Exception 
    {
            ModeloHotel.eliminarPension(eliminarPension);
    }
    
    
    
    
    public static void eliminarEmpleados(EntidadEmpleado eliminarEmpleados) throws Exception 
    {
	 ModeloEmpleados.eliminarEmpleados(eliminarEmpleados);
    }
    
    
    
    public static List<EntidadEmpleado> getEmpleados() throws SQLException, Exception 
    {
           return ModeloEmpleados.getEmpleados();
    }
    
    public static List<EntidadCliente> getCliente() throws SQLException, Exception 
    {
           return ModeloCliente.getClientes();
    }
    
    public static List<EntidadHabitación> getHabitaciones() throws SQLException, Exception 
    {
           return ModeloHabitacion.getHabitaciones();
    }
    
    public static void modificarCliente(EntidadCliente modificarCliente) throws Exception 
    {
            ModeloCliente.modificarCliente(modificarCliente);
    }
    
    
    public static void modificarEmpleado(EntidadEmpleado modificarEmpleado) throws Exception 
    {
            ModeloEmpleados.modificarEmpleado(modificarEmpleado);
    }
    
    public static void modificarHabitacion(EntidadHabitación modificarHabitacion) throws Exception 
    {
            ModeloHabitacion.modificarHabitacion(modificarHabitacion);
    }
    
    public static int getNplanta() throws SQLException, Exception 
    {
           return ModeloHotel.getNplanta();
    }
    
    
     //REGISTRO DE HABITACIONES
    
    public static void registrarHabitaciones(EntidadHabitación nuevaHabitacion) throws Exception 
    {
            ModeloHabitacion.insertarHabitacion(nuevaHabitacion);
    }
    
    //ELIMINAR DESDE TABLA
	
    public static void eliminarHabitacion(EntidadHabitación eliminarHabitacion) throws Exception 
    {
            ModeloHabitacion.eliminarHabitacion(eliminarHabitacion);
    }
    
    
   
    
   public static void asignarHabitacion(EntidadHabitación habitacion) throws Exception 
   {
            ModeloHabitacion.asignarHabitacion(habitacion);
   }
    
	
    public static List<EntidadHabitación> getHabitaciones1() throws SQLException, Exception 
    {
            return ModeloHabitacion.getHabitaciones1();
    }
    
    //MOSTRAR LIMPIADORAS
	
    public static List<EntidadEmpleado> getLimpiadoras(EntidadEmpleado limpiadora) throws SQLException, Exception 
    {
            return ModeloEmpleados.getLimpiadora(limpiadora);
    }
    
    
    public void iniciar() throws SQLException, Exception
    {
        loggeo.btnIngresar.setActionCommand("boton entrar");
        loggeo.btnIngresar.addActionListener(this);
        
        vistaAdmin.jButtonRegistrarHotel.setActionCommand("registrar hotel");
        vistaAdmin.jButtonRegistrarHotel.addActionListener(this);
        
        vistaAdmin.jButtonCancelarDatosHotel.setActionCommand("cancelar datos hotel");
        vistaAdmin.jButtonCancelarDatosHotel.addActionListener(this);
        
        vistaAdmin.jToggleRegistroHotel.setActionCommand("hotel");
        vistaAdmin.jToggleRegistroHotel.addActionListener(this);
        
        vistaAdmin.jButtonEditarHotel.setActionCommand("editar hotel");
        vistaAdmin.jButtonEditarHotel.addActionListener(this);
        
        vistaAdmin.jButtonModificarHotel.setActionCommand("modificar hotel");
        vistaAdmin.jButtonModificarHotel.addActionListener(this);
        
        vistaAdmin.jToggleMantenimientoHotel.setActionCommand("mantenimiento");
        vistaAdmin.jToggleMantenimientoHotel.addActionListener(this);
        
        dialog.jComboBoxMantenimiento.setActionCommand("combo mantenimiento");
        dialog.jComboBoxMantenimiento.addActionListener(this);
        
        dialog.jButtonIntroducir.setActionCommand("introducir mantenimiento");
        dialog.jButtonIntroducir.addActionListener(this);
        
        dialog.jButtonMostrarMantenimiento.setActionCommand("mostrar mantenimiento");
        dialog.jButtonMostrarMantenimiento.addActionListener(this);
        
        dialog.jButtonEliminarMantenimiento.setActionCommand("eliminar mantenimiento");
        dialog.jButtonEliminarMantenimiento.addActionListener(this);
        
        
        vistaAdmin.jToggleRegistroEmpleados.setActionCommand("registro empleado");
        vistaAdmin.jToggleRegistroEmpleados.addActionListener(this);
        
        vistaAdmin.jButtonRegistrarEmp.setActionCommand("registrar empleados");
        vistaAdmin.jButtonRegistrarEmp.addActionListener(this);
        
        vistaAdmin.jToggleConsultaEmpleados.setActionCommand("consulta empleados");
        vistaAdmin.jToggleConsultaEmpleados.addActionListener(this);
        
        vistaAdmin.jTextFieldDniEmpleado.setActionCommand("buscar empleado dni");
        vistaAdmin.jTextFieldDniEmpleado.addActionListener(this);
        
        vistaAdmin.jTextFieldNombreEmpleado.setActionCommand("buscar empleado nombre");
        vistaAdmin.jTextFieldNombreEmpleado.addActionListener(this);
        
        vistaAdmin.jTextFieldApellidosEmpleado.setActionCommand("buscar empleado apellidos");
        vistaAdmin.jTextFieldApellidosEmpleado.addActionListener(this);
        
        vistaAdmin.jTextFieldRolesEmpleado.setActionCommand("buscar empleado rol");
        vistaAdmin.jTextFieldRolesEmpleado.addActionListener(this);
        
        vistaAdmin.jToggleModificarEmpleado.setActionCommand("modificar empleados");
        vistaAdmin.jToggleModificarEmpleado.addActionListener(this);
        
        vistaAdmin.jToggleEliminarEmpleado.setActionCommand("eliminar empleado");
        vistaAdmin.jToggleEliminarEmpleado.addActionListener(this);
        
        vistaAdmin.jButtonSalirRegistroEmpleado.setActionCommand("salir registro empleado");
        vistaAdmin.jButtonSalirRegistroEmpleado.addActionListener(this);
        
        
        
        vistaAdmin.jToggleRegistroHabitaciones.setActionCommand("registro habitacion");
        vistaAdmin.jToggleRegistroHabitaciones.addActionListener(this);
        
        vistaAdmin.jButtonRegistrarHab.setActionCommand("registrar habitacion");
        vistaAdmin.jButtonRegistrarHab.addActionListener(this);
        
        vistaAdmin.jToggleConsultaHabitaciones.setActionCommand("consulta habitaciones");
        vistaAdmin.jToggleConsultaHabitaciones.addActionListener(this);
        
        
        vistaAdmin.jTextFieldNhabitacionBuscar.setActionCommand("buscar nº habitacion");
        vistaAdmin.jTextFieldNhabitacionBuscar.addActionListener(this);
        
        vistaAdmin.jTextFieldNplantaBuscar.setActionCommand("buscar nº planta");
        vistaAdmin.jTextFieldNplantaBuscar.addActionListener(this);
        
        vistaAdmin.jTextFieldVistasHab.setActionCommand("buscar vistas");
        vistaAdmin.jTextFieldVistasHab.addActionListener(this);
        
        vistaAdmin.jTextFieldTipoHab.setActionCommand("buscar tipo");
        vistaAdmin.jTextFieldTipoHab.addActionListener(this);
        
        vistaAdmin.jTextFieldCapacidadHab.setActionCommand("buscar capacidad");
        vistaAdmin.jTextFieldCapacidadHab.addActionListener(this);
        
        vistaAdmin.jTextFieldDniLimpiHab.setActionCommand("buscar dni limpiadora");
        vistaAdmin.jTextFieldDniLimpiHab.addActionListener(this);
        
        vistaAdmin.jToggleModificarHabitaciones.setActionCommand("modificar habitacion");
        vistaAdmin.jToggleModificarHabitaciones.addActionListener(this);
        
        vistaAdmin.jToggleEliminarHabitaciones.setActionCommand("eliminar habitacion");
        vistaAdmin.jToggleEliminarHabitaciones.addActionListener(this);
        
        vistaAdmin.jButtonSalirRegistroHabitacion1.setActionCommand("salir registro habitacion");
        vistaAdmin.jButtonSalirRegistroHabitacion1.addActionListener(this);
        
        
        vistaAdmin.jToggleRefrescar.setActionCommand("refrescar");
        vistaAdmin.jToggleRefrescar.addActionListener(this);
        
        vistaAdmin.jToggleAsignar.setActionCommand("asignar");
        vistaAdmin.jToggleAsignar.addActionListener(this);
        
        
        vistaAdmin.jToggleConsultaClientes.setActionCommand("consulta clientes");
        vistaAdmin.jToggleConsultaClientes.addActionListener(this);
        
        vistaAdmin.jTextFieldDniCliente.setActionCommand("consulta dni cliente");
        vistaAdmin.jTextFieldDniCliente.addActionListener(this);
        
        vistaAdmin.jTextFieldNombreCliente.setActionCommand("consulta nombre cliente");
        vistaAdmin.jTextFieldNombreCliente.addActionListener(this);
        
        vistaAdmin.jTextFieldApellidosCliente.setActionCommand("consulta apellidos cliente");
        vistaAdmin.jTextFieldApellidosCliente.addActionListener(this);
        
        vistaAdmin.jTextFieldFechaNacimientoCliente.setActionCommand("consulta fecha cliente");
        vistaAdmin.jTextFieldFechaNacimientoCliente.addActionListener(this);
        
        vistaAdmin.jTextFieldLocalidadCliente.setActionCommand("consulta localidad cliente");
        vistaAdmin.jTextFieldProvinciaCliente.addActionListener(this);
        
        vistaAdmin.jTextFieldPaisCliente.setActionCommand("consulta pais cliente");
        vistaAdmin.jTextFieldPaisCliente.addActionListener(this);
        
        
        
        vistaAdmin.jTextFieldNombreLimpiadora.setActionCommand("consulta nombre limpiadora");
        vistaAdmin.jTextFieldNombreLimpiadora.addActionListener(this);
        
        vistaAdmin.jTextFieldApellidosLimpiadora.setActionCommand("consulta apellidos limpiadora");
        vistaAdmin.jTextFieldApellidosLimpiadora.addActionListener(this);
        
        vistaAdmin.jTextFieldUsuarioLimpiadora.setActionCommand("consulta usuario limpiadora");
        vistaAdmin.jTextFieldUsuarioLimpiadora.addActionListener(this);
        
        
        vistaAdmin.jTextFieldNhabitacionBuscar1.setActionCommand("consulta nº habitacion asignar");
        vistaAdmin.jTextFieldNhabitacionBuscar1.addActionListener(this);
        
        vistaAdmin.jTextFieldNplantaBuscar1.setActionCommand("consulta nº planta asignar");
        vistaAdmin.jTextFieldNplantaBuscar1.addActionListener(this);
        
        
        vistaAdmin.jButtonInformeCLientes.setActionCommand("Informes Clientes");
        vistaAdmin.jButtonInformeCLientes.addActionListener(this);
        
        vistaAdmin.jButtonInformesEmpleados.setActionCommand("Informes Empleados");
        vistaAdmin.jButtonInformesEmpleados.addActionListener(this);
        
        vistaAdmin.jButtonInformesHabitaciones.setActionCommand("Informes Habitaciones");
        vistaAdmin.jButtonInformesHabitaciones.addActionListener(this);
        
        vistaAdmin.jButtonInformesReservas.setActionCommand("Informes Reservas");
        vistaAdmin.jButtonInformesReservas.addActionListener(this);
        
        val.pasarTextField(vistaAdmin.jTextFieldCifHotel);
        val.pasarTextField(vistaAdmin.jTextFieldCpHotel);
        val.pasarTextField(vistaAdmin.jTextFieldDireccionHotel);
        val.pasarTextField(vistaAdmin.jTextFieldEmailHotel);
        val.pasarTextField(vistaAdmin.jTextFieldLocalidadHotel);
        val.pasarTextField(vistaAdmin.jTextFieldNombreHotel);
        val.pasarTextField(vistaAdmin.jTextFieldPaisHotel);
        val.pasarTextField(vistaAdmin.jTextFieldPlantasHotel);
        val.pasarTextField(vistaAdmin.jTextFieldProvinciaHotel);
        val.pasarTextField(vistaAdmin.jTextFieldTelefonoHotel);
        
        val.pasarTextField(vistaAdmin.jTextFieldDni);
        val.pasarTextField(vistaAdmin.jTextFieldNombre);
        val.pasarTextField(vistaAdmin.jTextFieldApellidos);
        val.pasarTextField(vistaAdmin.jTextFieldDireccion);
        val.pasarTextField(vistaAdmin.jTextFieldTelefono);
        val.pasarTextField(vistaAdmin.jTextFieldCp);
        val.pasarTextField(vistaAdmin.jTextFieldEmail);
        val.pasarTextField(vistaAdmin.jTextFieldProvincia);
        val.pasarTextField(vistaAdmin.jTextFieldLocalidad);
        val.pasarTextField(vistaAdmin.jTextFieldPais);
        val.pasarTextField(vistaAdmin.jTextFieldUsuarioEmp);
        val.pasarTextField(vistaAdmin.jTextFieldClave);
        val.pasarTextField(vistaAdmin.jTextFieldRepetirClave);
        
        val.pasarTextField(vistaAdmin.jTextFieldNHabitacion);
        val.pasarTextField(vistaAdmin.jTextFieldNPlanta);
        
        val.longitudCampo(vistaAdmin.jTextFieldDni);
        val.Sletras(vistaAdmin.jTextFieldNombre);
        val.Sletras(vistaAdmin.jTextFieldApellidos);
        val.SNumeros(vistaAdmin.jTextFieldTelefono);
        val.longitudCampo1(vistaAdmin.jTextFieldTelefono);
        val.SNumeros(vistaAdmin.jTextFieldCp);
        val.longitudCampo2(vistaAdmin.jTextFieldCp);
        val.Sletras(vistaAdmin.jTextFieldLocalidad);
        val.Sletras(vistaAdmin.jTextFieldProvincia);
        val.Sletras(vistaAdmin.jTextFieldPais);
        
        val.longitudCampo(vistaAdmin.jTextFieldDniEmpleado);
        val.Sletras(vistaAdmin.jTextFieldNombreEmpleado);
        val.Sletras(vistaAdmin.jTextFieldApellidosEmpleado);
        
        val.SNumeros(vistaAdmin.jTextFieldNHabitacion);
        val.SNumeros(vistaAdmin.jTextFieldNPlanta);
        
        val.SNumeros(vistaAdmin.jTextFieldNhabitacionBuscar);
        val.SNumeros(vistaAdmin.jTextFieldNplantaBuscar);
        val.SNumeros(vistaAdmin.jTextFieldNhabitacionBuscar1);
        val.SNumeros(vistaAdmin.jTextFieldNplantaBuscar1);
        val.SNumeros(vistaAdmin.jTextFieldCapacidadHab);
        val.longitudCampo(vistaAdmin.jTextFieldDniLimpiHab);
        
        val.longitudCampo(vistaAdmin.jTextFieldDniCliente);
        val.Sletras(vistaAdmin.jTextFieldNombreCliente);
        val.Sletras(vistaAdmin.jTextFieldApellidosCliente);
        val.SNumeros(vistaAdmin.jTextFieldFechaNacimientoCliente);
        val.Sletras(vistaAdmin.jTextFieldLocalidadCliente);
        val.Sletras(vistaAdmin.jTextFieldProvinciaCliente);
        val.Sletras(vistaAdmin.jTextFieldPaisCliente);
        
        val.Sletras(vistaAdmin.jTextFieldNombreLimpiadora);
        val.Sletras(vistaAdmin.jTextFieldApellidosLimpiadora);
        
        
        //cuando un jbutton esta marcado podemos pulsar enter para que realice su funcion
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
        
        vistaAdmin.jButtonRegistrarHotel.setInputMap(0, map);
        vistaAdmin.jButtonRegistrarEmp.setInputMap(0, map);
        
        mostrarHabitaciones1();
        mostrarLimpiadoras();
        consultaNombreHotel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e!= null)
        {
        String s = e.getActionCommand();
        
        
        
        /**********************************************************************************************************
        *******************************************MANTENIMIENTO***************************************************
        *********************************************************************************************************** */
        
        if(s.equals("introducir mantenimiento"))
        {
            if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Elija una opción..."))
            {
                JOptionPane.showMessageDialog(null, "Elija una opción");
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Roles"))
            {
                er.setRol(dialog.jTextFieldInsertarMantenimiento.getText());
                encontrado = false;
                
                if(er.getRol().equals(""))
                {
                    encontrado = true;
                }
                
                if(!encontrado)
                {
                    try 
                    {
                        insertarRoles(er);
                        mostrarRoles();
                        //rellenarComboRoles();
                    } 

                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, "Ese rol ya está registrado");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
                
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Capacidad"))
            {
                capacidad1 = dialog.jTextFieldInsertarMantenimiento.getText();
                encontrado = false;
                
                if(dialog.jTextFieldInsertarMantenimiento.getText().equals(""))
                {
                    encontrado = true;
                }
                
                if(!encontrado)
                {
                    ec.setCapacidad(Integer.parseInt(capacidad1));
                    
                    try 
                    {
                        insertarCapacidad(ec);
                        mostrarCapacidad();
                    } 

                    catch (Exception ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Esa capacidad ya está registrada");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Tipo"))
            {
                encontrado = true;
                
                et.setTipo(dialog.jTextFieldInsertarMantenimiento.getText());
                
                if(et.getTipo().equals(""))
                {
                    encontrado = false;
                }
                
                if(encontrado)
                {
                    try 
                    {
                        insertarTipo(et);
                        mostrarTipos();
                    } 

                    catch (Exception ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Ese tipo de habitación ya está registrado");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Vistas"))
            {
                ev.setVista(dialog.jTextFieldInsertarMantenimiento.getText());
                encontrado = false;
                
                if(ev.getVista().equals(""))
                {
                    encontrado = true;
                }
                
                if(!encontrado)
                {
                    try 
                    {
                        insertarVistas(ev);
                        mostrarVistas();
                    } 

                    catch (Exception ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Esa vista ya está registrada");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
            }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Nº plantas"))
            {
                ep.setnPlanta(Integer.parseInt(dialog.jTextFieldInsertarMantenimiento.getText()));
                encontrado = false;
                
                if(ep.getnPlanta()==0)
                {
                    encontrado = true;
                }
                
                if(!encontrado)
                {
                    try 
                    {
                        insertarPlanta(ep);
                        //rellenarComboNplanta();
                    } 

                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, "Esa planta ya está registrada");
                        ex.getMessage();
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
                
            }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Pensión"))
            {
                pension = dialog.jTextFieldInsertarMantenimiento.getText();
                encontrado = false;
                
                if(dialog.jTextFieldInsertarMantenimiento.getText().equals(""))
                {
                    encontrado = true;
                }
                
                if(!encontrado)
                {
                    epe.setPension(pension);
                    
                    try 
                    {
                        int precioPension = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el precio de la pensión"));
                        epe.setPrecio(precioPension);
                        insertarPensiones(epe);
                        mostrarPension();
                    } 

                    catch (Exception ex) 
                    {
                        JOptionPane.showMessageDialog(null, "Esa pensión ya está registrada");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir el campo que desea registrar");
                }
            }
       }
        
        
        else if(s.equals("refrescar"))
        {
            mostrarHabitaciones1();
            mostrarLimpiadoras();
        }
        
        
        
        
        else if(s.equals("mostrar mantenimiento"))
        {
            if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Elija una opción..."))
            {
                JOptionPane.showMessageDialog(null, "Elija una opción para mostrar los resultados");
                DefaultTableModel tb=(DefaultTableModel) dialog.jTableMantenimiento.getModel();
		int filas=dialog.jTableMantenimiento.getRowCount();
		
		for(int i=1;i<=filas;i++)
		{
			tb.removeRow(0);
		}
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Roles"))
            {
                try 
                {
                    mostrarRoles();
                }
                
                catch (SQLException ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Capacidad"))
            {
                try 
                {
                    mostrarCapacidad();
                }
                
                catch (SQLException ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Tipo"))
            {
                try 
                {
                    mostrarTipos();
                }
                
                catch (SQLException ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Vistas"))
            {
                try 
                {
                    mostrarVistas();
                }
                
                catch (SQLException ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Pensión"))
            {
                try 
                {
                    mostrarPension();
                }
                
                catch (SQLException ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
        else if(s.equals("eliminar mantenimiento"))
        {
            if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Roles"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar el rol que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el rol seleccionado?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     rol = (String) dtm.getValueAt(filaSelec, 0);
                                     er.setRol(rol);
                                     
                                     eliminarRol(er);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Rol eliminado correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Capacidad"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar la capacidad que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la capacidad seleccionada?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     capacidad1 = (String)dtm.getValueAt(filaSelec, 0);
                                     capacidad =  Integer.parseInt(capacidad1);
                                     ec.setCapacidad(capacidad);
                                     
                                     eliminarCapacidad(ec);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Capacidad eliminada correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Vistas"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar la vista que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la vista seleccionada?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     vista = (String)dtm.getValueAt(filaSelec, 0);
                                     ev.setVista(vista);
                                     
                                     eliminarVistas(ev);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Vista eliminada correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Tipo"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el tipo seleccionado?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     tipo = (String)dtm.getValueAt(filaSelec, 0);
                                     et.setTipo(tipo);
                                     
                                     eliminarTipo(et);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Tipo eliminado correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
            
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Nº plantas"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar la planta que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la capacidad seleccionada?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     capacidad1 = (String)dtm.getValueAt(filaSelec, 0);
                                     capacidad =  Integer.parseInt(capacidad1);
                                     ec.setCapacidad(capacidad);
                                     
                                     eliminarCapacidad(ec);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Capacidad eliminada correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
            
            else if(dialog.jComboBoxMantenimiento.getSelectedItem().toString().equals("Pensión"))
            {
                try 
                {
                     filaSelec = dialog.jTableMantenimiento.getSelectedRow();

                     if (filaSelec == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar la pensión que desea eliminar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar la pensión seleccionada?",
                             "Eliminar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) dialog.jTableMantenimiento.getModel();

                                     pension = (String)dtm.getValueAt(filaSelec, 0);
                                     epe.setPension(pension);
                                     
                                     eliminarPension(epe);
                                     dtm.removeRow(filaSelec);
                                     JOptionPane.showMessageDialog(null, "Pensión eliminada correctamente");
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido eliminar correctamente");
             }
          }
        }
        
        
        else if(s.equals("mantenimiento"))
        {
            dialog.show();
        }
        
        
        
        
        
        
        /****************************************************************************************************************
         * ***********************************************HOTEL**********************************************************
         * *************************************************************************************************************/
        
        
        if(s.equals("hotel"))
        {
            try 
            {
                consultaHotel();
                mostrarCapacidad();
                mostrarRoles();
                mostrarTipos();
                mostrarVistas();
                vistaAdmin.jButtonEditarHotel.setEnabled(true);
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            catch (Exception ex) 
            {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(s.equals("editar hotel"))
        {
            vistaAdmin.jTextFieldCifHotel.setEnabled(true);
            vistaAdmin.jTextFieldCpHotel.setEnabled(true);
            vistaAdmin.jTextFieldDireccionHotel.setEnabled(true);
            vistaAdmin.jTextFieldEmailHotel.setEnabled(true);
            vistaAdmin.jTextFieldLocalidadHotel.setEnabled(true);
            vistaAdmin.jTextFieldNombreHotel.setEnabled(true);
            vistaAdmin.jTextFieldPaisHotel.setEnabled(true);
            vistaAdmin.jTextFieldPlantasHotel.setEnabled(true);
            vistaAdmin.jTextFieldProvinciaHotel.setEnabled(true);
            vistaAdmin.jTextFieldTelefonoHotel.setEnabled(true);
            
            vistaAdmin.jButtonModificarHotel.setEnabled(true);
            vistaAdmin.jButtonEditarHotel.setEnabled(false);
            
            vistaAdmin.jTableCapacidad.setEnabled(false);
            vistaAdmin.jTableRoles.setEnabled(false);
            vistaAdmin.jTableVistas.setEnabled(false);
            vistaAdmin.jTableTipos.setEnabled(false);
        }
        
        
        else if(s.equals("cancelar datos hotel"))
        {
            vistaAdmin.jPanelContenedor.setVisible(true);
            vistaAdmin.jPanelDatosHotel.setVisible(false);
            vistaAdmin.jButtonEditarHotel.setEnabled(false);
        }
        
        
        
        else if(s.equals("gestion datos"))
        {
            
        }
        
        
        else if(s.equals("salir consulta datos"))
        {
            vistaAdmin.jPanelContenedor.setVisible(true);
            vistaAdmin.jPanelDatosHotel.setVisible(false);
        }
        
        
        
        else if(s.equals("registrar hotel"))
        {
           vistaAdmin.jPanelDatosHotel.setVisible(true);
            
           try
           {
               camposCorrectos = true;
               
               eh.setNombreHotel(vistaAdmin.jTextFieldNombreHotel.getText());
               eh.setCif(vistaAdmin.jTextFieldCifHotel.getText());
               eh.setDireccion(vistaAdmin.jTextFieldDireccionHotel.getText());
               
               if(vistaAdmin.jTextFieldCpHotel.getText().equals(""))
               {
                   eh.setCp(0);
               }
               
               else
               {
                   eh.setTelefono(Integer.parseInt(vistaAdmin.jTextFieldCpHotel.getText()));
               }
               
               if(vistaAdmin.jTextFieldTelefonoHotel.getText().equals(""))
               {
                   eh.setTelefono(0);
               }
               
               else
               {
                   eh.setTelefono(Integer.parseInt(vistaAdmin.jTextFieldTelefonoHotel.getText()));
               }
               
               eh.setLocalidad(vistaAdmin.jTextFieldLocalidadHotel.getText());
               eh.setProvincia(vistaAdmin.jTextFieldProvinciaHotel.getText());
               eh.setPais(vistaAdmin.jTextFieldPaisHotel.getText());
               eh.setEmailHotel(vistaAdmin.jTextFieldEmailHotel.getText());
               
               if(vistaAdmin.jTextFieldPlantasHotel.getText().equals(""))
               {
                   eh.setPlantas(0);
               }
               
               else
               {
                   eh.setPlantas(Integer.parseInt(vistaAdmin.jTextFieldPlantasHotel.getText()));
               }
               
               if(vistaAdmin.jTextFieldTelefonoHotel.getText().length()!=9)
               {
                   JOptionPane.showMessageDialog(null, "El teléfono debe contener 9 dígitos");
                   camposCorrectos = false;
               }
               
               if(camposCorrectos)
               {
                   insertarHotel(eh);
               }
           }
           
           catch (Exception e1) 
           {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido registrar correctamente");
           }
        }
        
        
        
        else if(s.equals("modificar hotel"))
        {
            vistaAdmin.jTextFieldCifHotel.setEnabled(true);
            vistaAdmin.jTextFieldCpHotel.setEnabled(true);
            vistaAdmin.jTextFieldDireccionHotel.setEnabled(true);
            vistaAdmin.jTextFieldEmailHotel.setEnabled(true);
            vistaAdmin.jTextFieldLocalidadHotel.setEnabled(true);
            vistaAdmin.jTextFieldNombreHotel.setEnabled(true);
            vistaAdmin.jTextFieldPaisHotel.setEnabled(true);
            vistaAdmin.jTextFieldPlantasHotel.setEnabled(true);
            vistaAdmin.jTextFieldProvinciaHotel.setEnabled(true);
            vistaAdmin.jTextFieldTelefonoHotel.setEnabled(true);
            
                    
            try
            {
               camposCorrectos = true;
               
               eh.setNombreHotel(vistaAdmin.jTextFieldNombreHotel.getText());
               eh.setCif(vistaAdmin.jTextFieldCifHotel.getText());
               eh.setDireccion(vistaAdmin.jTextFieldDireccionHotel.getText());
               
               if(vistaAdmin.jTextFieldCpHotel.getText().equals(""))
               {
                   eh.setCp(0);
               }
               
               else
               {
                   eh.setTelefono(Integer.parseInt(vistaAdmin.jTextFieldCpHotel.getText()));
               }
               
               if(vistaAdmin.jTextFieldTelefonoHotel.getText().equals(""))
               {
                   eh.setTelefono(0);
               }
               
               else
               {
                   eh.setTelefono(Integer.parseInt(vistaAdmin.jTextFieldTelefonoHotel.getText()));
               }
               
               eh.setLocalidad(vistaAdmin.jTextFieldLocalidadHotel.getText());
               eh.setProvincia(vistaAdmin.jTextFieldProvinciaHotel.getText());
               eh.setPais(vistaAdmin.jTextFieldPaisHotel.getText());
               eh.setEmailHotel(vistaAdmin.jTextFieldEmailHotel.getText());
               
               if(vistaAdmin.jTextFieldPlantasHotel.getText().equals(""))
               {
                   eh.setPlantas(0);
               }
               
               else
               {
                   eh.setPlantas(Integer.parseInt(vistaAdmin.jTextFieldPlantasHotel.getText()));
               }
               
               if(vistaAdmin.jTextFieldTelefonoHotel.getText().length()!=9)
               {
                   JOptionPane.showMessageDialog(null, "El teléfono debe contener 9 dígitos");
                   camposCorrectos = false;
               }
               
               if(camposCorrectos)
               {
                   resp = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea modificar el hotel?",
		    "Modificar", JOptionPane.YES_NO_OPTION);
                    
                    if(resp == JOptionPane.YES_OPTION)
                    {
                        modificarHotel(eh);
                        
                        vistaAdmin.jTextFieldCifHotel.setEnabled(false);
                        vistaAdmin.jTextFieldCpHotel.setEnabled(false);
                        vistaAdmin.jTextFieldDireccionHotel.setEnabled(false);
                        vistaAdmin.jTextFieldEmailHotel.setEnabled(false);
                        vistaAdmin.jTextFieldLocalidadHotel.setEnabled(false);
                        vistaAdmin.jTextFieldNombreHotel.setEnabled(false);
                        vistaAdmin.jTextFieldPaisHotel.setEnabled(false);
                        vistaAdmin.jTextFieldPlantasHotel.setEnabled(false);
                        vistaAdmin.jTextFieldProvinciaHotel.setEnabled(false);
                        vistaAdmin.jTextFieldTelefonoHotel.setEnabled(false);
                        
                        vistaAdmin.jButtonModificarHotel.setEnabled(false);
                        vistaAdmin.jButtonEditarHotel.setEnabled(true);
                        
                        vistaAdmin.jTableCapacidad.setEnabled(true);
                        vistaAdmin.jTableRoles.setEnabled(true);
                        vistaAdmin.jTableTipos.setEnabled(true);
                        vistaAdmin.jTableVistas.setEnabled(true);
                        
                        consultaNombreHotel();
                    }
               }
           }
           
           catch (Exception e1) 
           {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido registrar correctamente");
           }
        }
        
        
        
        
        
        /****************************************************************************************************************
         * *********************************************EMPLEADOS********************************************************
         * *************************************************************************************************************/
        
        
        else if(s.equals("registro empleado"))
        {
            vistaAdmin.jPanelRegistrarEmpleados.setVisible(true);
            vistaAdmin.jPanelConsultaEmpleados.setVisible(false);
            try {
                rellenarComboRoles1();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        else if(s.equals("registrar empleados"))
        {
            try
             {
               camposCorrectos = true;
               ee.setDni(vistaAdmin.jTextFieldDni.getText());
               ee.setNombre(vistaAdmin.jTextFieldNombre.getText());
               ee.setApellidos(vistaAdmin.jTextFieldApellidos.getText());
               ee.setDireccion(vistaAdmin.jTextFieldDireccion.getText());
               
               if(vistaAdmin.jTextFieldCp.getText().equals(""))
               {
                   ee.setCp(0);
               }
               
               else
               {
               
                   ee.setCp(Integer.parseInt(vistaAdmin.jTextFieldCp.getText()));
               }
               
               ee.setEmail(vistaAdmin.jTextFieldEmail.getText());
               ee.setPais(vistaAdmin.jTextFieldPais.getText());
               ee.setProvincia(vistaAdmin.jTextFieldProvincia.getText());
               ee.setLocalidad(vistaAdmin.jTextFieldLocalidad.getText());
               
               if(vistaAdmin.jTextFieldTelefono.getText().equals(""))
               {
                   ee.setTelefono(0);
               }
               
               else
               {
                   ee.setTelefono(Integer.parseInt(vistaAdmin.jTextFieldTelefono.getText()));
               }
               
               ee.setRol(vistaAdmin.jComboBoxRol.getSelectedItem().toString());
               ee.setUsuario(vistaAdmin.jTextFieldUsuarioEmp.getText());
               ee.setClave(vistaAdmin.jTextFieldClave.getText());
               
               if(!val.NifValido(ee.getDni().trim()))
               {
                    //si el dni no es valido (llamamos al metodo que lo comprueba, instanciado en la clase validaciones)
                    camposCorrectos = false;
                    JOptionPane.showMessageDialog(null, "Introduzca un DNI valido");
               }
               
               else if(!val.isEmail(ee.getEmail().trim()))
               {
                   camposCorrectos = false;
                   JOptionPane.showMessageDialog(null, "Introduzca un email correcto");
               }
               
               else if(vistaAdmin.jTextFieldTelefono.getText().length()!=9)
               {
                   JOptionPane.showMessageDialog(null, "El teléfono debe contener 9 dígitos");
                   camposCorrectos = false;
               }
               
               else if(vistaAdmin.jComboBoxRol.getSelectedItem().equals("Elija una opción..."))
               {
                   JOptionPane.showMessageDialog(null, "Debe elegir el rol del empleado");
                   camposCorrectos = false;
               }
               
               else if(!vistaAdmin.jTextFieldClave.getText().equals(vistaAdmin.jTextFieldRepetirClave.getText()))
               {
                   JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                   camposCorrectos = false;
               }
               
               else if(vistaAdmin.jTextFieldDni.getText().equals("") || vistaAdmin.jTextFieldNombre.getText().equals("") || 
                       vistaAdmin.jTextFieldApellidos.getText().equals("") || vistaAdmin.jTextFieldDireccion.getText().equals("") || 
                       vistaAdmin.jTextFieldTelefono.getText().equals("") || vistaAdmin.jTextFieldClave.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                   camposCorrectos = false;
               }
               
               if(camposCorrectos)
               {
                   comprobarSiUsuarioExiste();
               }
            }
           
           catch (Exception e1) 
           {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: ya hay un empleado registrado con ese usuario");
           }
        }
        
        
        
        else if(s.equals("consulta empleados"))
        {
            mostrarEmpleados();
            vistaAdmin.jPanelRegistrarEmpleados.setVisible(false);
            vistaAdmin.jPanelConsultaEmpleados.setVisible(true);
            vistaAdmin.jToggleModificarEmpleado.setEnabled(true);
            vistaAdmin.jToggleEliminarEmpleado.setEnabled(true);
        }
        
         else if(s.equals("consulta habitaciones"))
        {
            mostrarHabitaciones();
            vistaAdmin.jPanelRegistrarHabitaciones.setVisible(false);
            vistaAdmin.jPanelConsultaHabitaciones.setVisible(true);
            vistaAdmin.jToggleModificarHabitaciones.setEnabled(true);
            vistaAdmin.jToggleEliminarHabitaciones.setEnabled(true);
            mostrarHabitaciones();
        }
        
        
        else if(s.equals("buscar empleado dni"))
        {
            ee.setDni(vistaAdmin.jTextFieldDniEmpleado.getText());
                        
                        contador = 0;
				
			try 
			{
                            
				String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
				List<EntidadEmpleado> list=ControladorAdministrador.getDniEmpleado(ee);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getRol();
                                        datos[i][7]=list.get(i).getUsuario();
                                        datos[i][8]=list.get(i).getClave();                                
				}
					
				vistaAdmin.jTableConsultaEmpleados.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este DNI");
                                }
                                
                                contador = datos.length;
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
        }
        
        
        
        else if(s.equals("buscar empleado nombre"))
        {
            ee.setNombre(vistaAdmin.jTextFieldNombreEmpleado.getText());
                        
                        contador = 0;
				
			try 
			{
                            
				String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
				List<EntidadEmpleado> list=ControladorAdministrador.getNombreEmpleado(ee);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getRol();
                                        datos[i][7]=list.get(i).getUsuario();
                                        datos[i][8]=list.get(i).getClave();                                
				}
					
				vistaAdmin.jTableConsultaEmpleados.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nombre");
                                }
                                
                                contador = datos.length;
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
        }
        
        
        else if(s.equals("buscar empleado apellidos"))
        {
            ee.setApellidos(vistaAdmin.jTextFieldApellidosEmpleado.getText());
                        
                        contador = 0;
				
			try 
			{
                            
				String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
				List<EntidadEmpleado> list=ControladorAdministrador.getApellidosEmpleado(ee);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getRol();
                                        datos[i][7]=list.get(i).getUsuario();
                                        datos[i][8]=list.get(i).getClave();                                
				}
					
				vistaAdmin.jTableConsultaEmpleados.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para estos apellidos");
                                }
                                
                                contador = datos.length;
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
        }
        
        else if(s.equals("buscar empleado rol"))
        {
            ee.setRol(vistaAdmin.jTextFieldRolesEmpleado.getText());
                        
                        contador = 0;
				
			try 
			{
                            
				String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
				List<EntidadEmpleado> list=ControladorAdministrador.getRolEmpleado(ee);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getRol();
                                        datos[i][7]=list.get(i).getUsuario();
                                        datos[i][8]=list.get(i).getClave();                                
				}
					
				vistaAdmin.jTableConsultaEmpleados.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este rol");
                                }
                                
                                contador = datos.length;
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
        }
        
        
        
        else if(s.equals("buscar nº habitacion"))
        {
            eha.setNHabitacion(Integer.parseInt(vistaAdmin.jTextFieldNhabitacionBuscar.getText()));
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getNHabitacion(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nº de habitación");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
        }
        
        
         else if(s.equals("buscar nº planta"))
         {
                 eha.setNPlanta(Integer.parseInt(vistaAdmin.jTextFieldNplantaBuscar.getText()));
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getNPlanta(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nº de planta");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
             }
         
         
         else if(s.equals("buscar vistas"))
         {
                 eha.setVistas(vistaAdmin.jTextFieldVistasHab.getText());
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getNHabitacion(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta vista");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
             }
         
         
         else if(s.equals("buscar tipo"))
         {
                 eha.setTipo(vistaAdmin.jTextFieldTipoHab.getText());
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getNHabitacion(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este tipo");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
             }
         
         else if(s.equals("buscar capacidad"))
         {
                 eha.setCapacidad(Integer.parseInt(vistaAdmin.jTextFieldCapacidadHab.getText()));
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getCapacidad(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta capacidad");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
             }
         
         else if(s.equals("buscar dni limpiadora"))
         {
                 eha.setDniLimpiadora(vistaAdmin.jTextFieldDniLimpiHab.getText());
                 
                 contador = 0;
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorAdministrador.getDniLimpiadora(eha);
					
				String[][] datos=new String[list.size()][9];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=list.get(i).getDniLimpiadora();
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                                        datos[i][7]=list.get(i).getDescripcion();
                                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta limpiadora");
                                }
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
             }
         
         
         else if(s.equals("consulta nombre limpiadora"))
         {
                try 
                {
                    ee.setRol("Limpiadora");
                    ee.setNombre(vistaAdmin.jTextFieldNombreLimpiadora.getText());

                    String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
                    List<EntidadEmpleado> list= ControladorAdministrador.getNombreLimpiadora(ee);

                    String[][] datos=new String[list.size()][9];
                    int i;
                    for (i = 0; i < list.size(); i++) 
                    {
                            datos[i][0]=Integer.toString(list.get(i).getId());
                            datos[i][1]=list.get(i).getDni();
                            datos[i][2]=list.get(i).getNombre();
                            datos[i][3]=list.get(i).getApellidos();
                            datos[i][4]=list.get(i).getDireccion();
                            datos[i][5]=Integer.toString(list.get(i).getTelefono());
                            datos[i][6]=list.get(i).getRol();
                            datos[i][7]=list.get(i).getUsuario();
                            datos[i][8]=list.get(i).getClave();
                    }

                    vistaAdmin.jTableLimpiadorasAsignar.setModel(new DefaultTableModel(datos, cabecera));
            } 
            catch (SQLException e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            } 

            catch (Exception e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            }
        }
         
         
         
         
         
        /***************************************************************************************************************
        * *****************************************MODIFICAR DESDE LAS TABLAS*******************************************
        * *************************************************************************************************************/
        
        else if(s.equals("modificar empleados"))
        {
            filaSelec = vistaAdmin.jTableConsultaEmpleados.getSelectedRow();
            
            
            if(filaSelec > -1)
            {
                try
                {
                    resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el empleado seleccionado?",
                    "Modificar", JOptionPane.YES_NO_OPTION);

                    if (resp == JOptionPane.YES_OPTION) 
                    {
                         resp = 1;      
                    }

                    else
                    {
                        resp = 0;
                    }

                    if(resp == 1)
                    {
                        DefaultTableModel dtm = (DefaultTableModel) vistaAdmin.jTableConsultaEmpleados.getModel();

                        id1 = (String) dtm.getValueAt(filaSelec, 0);
                        id = Integer.parseInt(id1);
                        ee.setId(id);

                        dni = (String) dtm.getValueAt(filaSelec, 1);
                        ee.setDni(dni);

                        nombre = (String) dtm.getValueAt(filaSelec, 2);
                        ee.setNombre(nombre);

                        apellidos = (String) dtm.getValueAt(filaSelec, 3);
                        ee.setApellidos(apellidos);

                        direccion=(String) dtm.getValueAt(filaSelec, 4);
                        ee.setDireccion(direccion);

                        telefono1 = (String) dtm.getValueAt(filaSelec, 5);
                        telefono = Integer.parseInt(telefono1);
                        ee.setTelefono(telefono);

                        rol = (String) dtm.getValueAt(filaSelec, 6);
                        ee.setRol(rol);

                        usuario = (String) dtm.getValueAt(filaSelec, 7);
                        ee.setUsuario(usuario);

                        clave = (String) dtm.getValueAt(filaSelec, 8);
                        ee.setClave(clave);

                        modificarEmpleado(ee);
                        JOptionPane.showMessageDialog(null, "Empleado modificado correctamente");
                    }
                }
                
                catch (Exception e1) 
                {
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido modificar correctamente");
                }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el empleado que desea modificar");
            }
        }
        
        
        
        else if(s.equals("eliminar empleado"))
	{
		filaSelec = 0;
                id = 0;
		resp = 0;

		try {
			filaSelec = vistaAdmin.jTableConsultaEmpleados.getSelectedRow();

			if (filaSelec == -1) 
                        {
				JOptionPane.showMessageDialog(null, "Debe seleccionar el empleado que desea eliminar");
			}

			else 
                        {
				resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el empleado seleccionado?",
				"Eliminar", JOptionPane.YES_NO_OPTION);

				if (resp == JOptionPane.YES_OPTION) 
				{
					DefaultTableModel dtm = (DefaultTableModel)vistaAdmin.jTableConsultaEmpleados.getModel();
						
					ee.setId(Integer.parseInt(dtm.getValueAt(filaSelec, 0).toString()));
                                        
                                        ee.setRol(dtm.getValueAt(filaSelec, 6).toString());
                                        
                                        List<EntidadEmpleado> list= ControladorAdministrador.getRolEmpleado(ee);
                                        
                                        if(ee.getRol().equals("Administrador") && list.size()==1)
                                        {
                                            JOptionPane.showMessageDialog(null, "No puede eliminar el único administrador de la aplicación");
                                        }
						
                                        else
                                        {
                                            eliminarEmpleados(ee);
                                            dtm.removeRow(filaSelec);
                                        }
				}
			}
		}

		catch (Exception e1) 
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error:No se ha podido eliminar correctamente");
		}
	}
        
        
        else if(s.equals("modificar habitacion"))
        {
            
            filaSelec = vistaAdmin.jTableConsultaHabitaciones.getSelectedRow();
            
            if(filaSelec1 > -1)
            {
                try
                {
                    resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar la habitación seleccionada?",
                    "Modificar", JOptionPane.YES_NO_OPTION);

                    if (resp1 == JOptionPane.YES_OPTION) 
                    {
                         resp1 = 1;
                    }

                    else
                    {
                        resp1 = 0;
                    }

                    if(resp1 == 1)
                    {
                        DefaultTableModel dtm = (DefaultTableModel) vistaAdmin.jTableConsultaHabitaciones.getModel();

                        
                        eha.setNHabitacion(Integer.parseInt(dtm.getValueAt(filaSelec, 0).toString()));

                        eha.setNPlanta(Integer.parseInt(dtm.getValueAt(filaSelec, 1).toString()));

                        eha.setVistas(dtm.getValueAt(filaSelec, 2).toString());

                        eha.setTipo(dtm.getValueAt(filaSelec, 3).toString());

                        eha.setEstado(dtm.getValueAt(filaSelec, 4).toString());

                        eha.setDniLimpiadora(dtm.getValueAt(filaSelec, 5).toString());
                                     
                        eha.setCapacidad(Integer.parseInt(dtm.getValueAt(filaSelec, 6).toString()));
                        
                        eha.setDescripcion(dtm.getValueAt(filaSelec, 7).toString());
                        
                        eha.setPrecio(Integer.parseInt(dtm.getValueAt(filaSelec, 8).toString()));

                        modificarHabitacion(eha);
                    }
                }
                
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido modificar correctamente");
                }
            }
        }
        
        
        else if(s.equals("salir registro empleado"))
        {
            vistaAdmin.jPanelRegistrarEmpleados.setVisible(false);
            vistaAdmin.jPanelContenedor.setVisible(true);
        }
        
        else if(s.equals("salir registro habitacion"))
        {
            vistaAdmin.jPanelRegistrarHabitaciones.setVisible(false);
            vistaAdmin.jPanelContenedor.setVisible(true);
        }
        
        
        else if(s.equals("registro habitacion"))
        {
            vistaAdmin.jPanelRegistrarHabitaciones.setVisible(true);
            vistaAdmin.jPanelConsultaHabitaciones.setVisible(false);
            vistaAdmin.jToggleModificarHabitaciones.setEnabled(false);
            vistaAdmin.jToggleEliminarHabitaciones.setEnabled(false);
            
            try {
                mostrarCapacidad();                
                mostrarVistas();
                mostrarTipos();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(s.equals("registrar habitacion"))
        {
            try
            {
               camposCorrectos = true;
               
               if(vistaAdmin.jTextFieldNHabitacion.getText().equals(""))
               {
                   eha.setNHabitacion(0);
               }
               
               else
               {
                    eha.setNHabitacion(Integer.parseInt(vistaAdmin.jTextFieldNHabitacion.getText()));
               }
               
              int listPlanta = ControladorAdministrador.getNplanta();
              Integer[][] datosPlanta=new Integer[listPlanta][1];
              for (j = 0; j < listPlanta; j++) 
              {
                    datosPlanta[j][0] = j;
                    numplanta = j;
              }
                      
              if(vistaAdmin.jTextFieldNPlanta.getText().equals(""))
              {
                  numPlanta2 = 0;
              }
              
              else
              {
                  eha.setNPlanta(Integer.parseInt(vistaAdmin.jTextFieldNPlanta.getText()));
                  numPlanta2 = Integer.parseInt(vistaAdmin.jTextFieldNPlanta.getText());
                  camposCorrectos = true;
              }
              
              if(numplanta < numPlanta2)
              {
                  JOptionPane.showMessageDialog(null, "La planta mas alta es la: "+numplanta+"ª");
                  camposCorrectos = false;
              }
              
              
              if(numPlanta2 == 0)
              {
                  JOptionPane.showMessageDialog(null, "Debe indicar una planta");
                  camposCorrectos = false;
              }
              
              else
              {
                  camposCorrectos = true;
              }
              
               
               eha.setVistas(vistaAdmin.jComboBoxVistas.getSelectedItem().toString());
               eha.setTipo(vistaAdmin.jComboBoxTipo.getSelectedItem().toString());
               
               eha.setCapacidad(Integer.parseInt(vistaAdmin.jComboBoxCapacidad.getSelectedItem().toString()));
               
               if(vistaAdmin.jTextFieldPrecio.getText().equals(""))
               {
                   eha.setPrecio(0);
               }
               
               else
               {
                    eha.setPrecio(Integer.parseInt(vistaAdmin.jTextFieldPrecio.getText()));
               }
               
               disponible = "Disponible";
               eha.setEstado(disponible);
               
               eha.setDescripcion(vistaAdmin.jTextAreaHabitacion.getText());
               
               
               if(vistaAdmin.jTextFieldNHabitacion.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Introduzca el nº de habitación");
                   camposCorrectos = false;
               }
               
               else if(vistaAdmin.jTextFieldPrecio.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Introduzca el precio de la habitación");
                   camposCorrectos = false;
               }
               
               else if(vistaAdmin.jTextAreaHabitacion.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Introduzca una descripción de la habitación");
                   camposCorrectos = false;
               }
               
               if(camposCorrectos)
               {
                   registrarHabitaciones(eha);
                   mostrarHabitaciones();
                   mostrarHabitaciones1();
               }
           }
           
           catch (Exception e1) 
           {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: ese número de habitación ya está registrado");
           }
        }
        
        else if(s.equals("eliminar habitacion"))
        {
            filaSelec = 0;
            resp = 0;
            
            try 
            {
		filaSelec = vistaAdmin.jTableConsultaHabitaciones.getSelectedRow();

		if (filaSelec == -1) 
                {
			JOptionPane.showMessageDialog(null, "Debe seleccionar la habitación que desea eliminar");
		}

		else 
                {
			resp = JOptionPane.showConfirmDialog(null,"¿Esta seguro que desea eliminar la habitación seleccionada?",
			"Eliminar", JOptionPane.YES_NO_OPTION);

					if (resp == JOptionPane.YES_OPTION) 
					{
						DefaultTableModel dtm = (DefaultTableModel)  vistaAdmin.jTableConsultaHabitaciones.getModel();
						
						eha.setNHabitacion(Integer.parseInt(dtm.getValueAt(filaSelec, 0).toString()));
						
						eliminarHabitacion(eha);
						dtm.removeRow(filaSelec);
						JOptionPane.showMessageDialog(null, "Habitación eliminada correctamente");
					}
				}
			}

			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: No puede eliminar un cliente que tenga ventas asociadas");
			}
        }
        
        
        
        
        else if(s.equals("asignar"))
       {
           camposCorrectos = true;
           
           filaSeleLimp = vistaAdmin.jTableLimpiadorasAsignar.getSelectedRow();
           filaSelecHab = vistaAdmin.jTableHabitacionesAsignar.getSelectedRow();
           
           if(filaSeleLimp == -1)
           {
               JOptionPane.showMessageDialog(null, "Debe seleccionar una limpiadora");
               camposCorrectos = false;
           }
           
           else if(filaSelecHab == -1)
           {
               JOptionPane.showMessageDialog(null, "Debe seleccionar una habitación");
               camposCorrectos = false;
           }
           
           else
           {
               DefaultTableModel dtm = (DefaultTableModel) vistaAdmin.jTableHabitacionesAsignar.getModel();
               DefaultTableModel dtm1 = (DefaultTableModel) vistaAdmin.jTableLimpiadorasAsignar.getModel();
               
               eha.setNHabitacion(Integer.parseInt(dtm.getValueAt(filaSelecHab, 0).toString()));
               
               eha.setNPlanta(Integer.parseInt(dtm.getValueAt(filaSelecHab, 1).toString()));
               
               eha.setVistas(dtm.getValueAt(filaSelecHab, 2).toString());
               eha.setTipo(dtm.getValueAt(filaSelecHab, 3).toString());
               eha.setEstado(dtm.getValueAt(filaSelecHab, 4).toString());
               
               eha.setDniLimpiadora(dtm1.getValueAt(filaSeleLimp, 1).toString());
               
               eha.setCapacidad(Integer.parseInt(dtm.getValueAt(filaSelecHab, 5).toString()));
               eha.setDescripcion(dtm.getValueAt(filaSelecHab, 7).toString());
               
               eha.setPrecio(Integer.parseInt(dtm.getValueAt(filaSelecHab, 8).toString()));
               
               try 
               {
                   asignarHabitacion(eha);
                   mostrarHabitaciones1();
               } 
               
               catch (Exception ex) 
               {
                   Logger.getLogger(ControladorAdministrador.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
        
        
        else if(s.equals("consulta clientes"))
        {
            vistaAdmin.jPanelConsultaClientes.setVisible(true);
            mostrarClientes();
        }
        
        else if(s.equals("consulta dni cliente"))
        {
			ecl.setDni(vistaAdmin.jTextFieldDniCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getDniCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este DNI");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        
        else if(s.equals("consulta nombre cliente"))
        {
			ecl.setNombre(vistaAdmin.jTextFieldNombreCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getNombreCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nombre");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        
        else if(s.equals("consulta apellidos cliente"))
        {
			ecl.setApellidos(vistaAdmin.jTextFieldApellidosCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getApellidosCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para estos apellidos");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        
        else if(s.equals("consulta fecha cliente"))
        {
			ecl.setFechaNacimiento(vistaAdmin.jTextFieldFechaNacimientoCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getFechaNacimientoCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta fecha de nacimiento");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        else if(s.equals("consulta localidad cliente"))
        {
			ecl.setLocalidad(vistaAdmin.jTextFieldLocalidadCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getLocalidadCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta localidad");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        
        else if(s.equals("consulta provincia cliente"))
        {
			ecl.setProvincia(vistaAdmin.jTextFieldProvinciaCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getProvinciaCliente(ecl);
					
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta provincia");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        
        
        else if(s.equals("consulta pais cliente"))
        {
			ecl.setPais(vistaAdmin.jTextFieldPaisCliente.getText());
                        contador = 0;
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorAdministrador.getPaisCliente(ecl);
                                
				String[][] datos=new String[list.size()][12];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getId());
					datos[i][1]=list.get(i).getDni();
					datos[i][2]=list.get(i).getNombre();
					datos[i][3]=list.get(i).getApellidos();
					datos[i][4]=list.get(i).getDireccion();
					datos[i][5]=Integer.toString(list.get(i).getTelefono());
                                        datos[i][6]=list.get(i).getEmail();
                                        datos[i][7]=list.get(i).getFechaNacimiento();
                                        datos[i][8]=Integer.toString(list.get(i).getCp());
                                        datos[i][9]=list.get(i).getPais();
                                        datos[i][10]=list.get(i).getLocalidad();
                                        datos[i][11]=list.get(i).getProvincia();
				}
					
				vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este país");
                                }
                                
			}
                        
			catch (SQLException e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			} 
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
		}
        else if(s.equals("Informes Clientes")){
            mostrarInformesClientes();
            
        }else if(s.equals("Informes Empleados")){
            mostrarInformesEmpleados();
            
        }else if (s.equals("Informes Habitaciones")){
            mostrarInformesHabitaciones();
            
        }else if (s.equals("Informes Reservas")){
            mostrarInformesReservas();
        }
    }
    }
    
    
    
    
    /***************************************************************************************************************
    * ***************************COMPROBACION DEL EMPLEADO PARA VER SI ES CORRECTO EL LOGGEO************************
    * *************************************************************************************************************/

    private void comprobarEmpleado() throws SQLException, Exception 
    {
        List<EntidadEmpleado> list = ControladorAdministrador.getEmpleado();
        
        String[][] datos=new String[list.size()][3];
	int i;
	encontrado = true;
        
        if(loggeo.usernameTxt.getText().equals("") || loggeo.passwordTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Introduzca un nombre de usuario y la contraseña");
            encontrado = false;
        }
        
        for (i = 0; i < list.size(); i++)
	{
		datos[i][0]=list.get(i).getUsuario();
		datos[i][1]=list.get(i).getClave();
                datos[i][2]=list.get(i).getRol();
	
                if(datos[i][0].equals(loggeo.usernameTxt.getText()) && datos[i][1].equals(loggeo.passwordTxt.getText()))
		{
                    String usuarioSesion = loggeo.usernameTxt.getText();
                    
                    encontrado = false;
                    
                    loggeo.usernameTxt.setText("");
                    loggeo.passwordTxt.setText("");
                    loggeo.dispose();
                    
                    if(datos[i][2].equals("Administrador"))
                    {
                        vistaAdmin.setVisible(true);
                    }
                    
                    else if(datos[i][2].equals("Recepcionista"))
                    {
                        JOptionPane.showMessageDialog(null, "Recepcionista");
                    }
                    
                    loggeo.usernameTxt.setText("");
                    loggeo.passwordTxt.setText("");
		}
	}
        
        if(encontrado)
        {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña no correcta");
        }
    }
    
    /****************************************************************************************************************
    * *********************************COMPROBACIÓN PARA VER SI EL HOTEL ESTÁ REGISTRADO*****************************
    * *************************************************************************************************************/
    
    private void consultaHotel() throws SQLException, Exception 
    {
        List<EntidadHotel> list = ControladorAdministrador.getHotel();
        
        String[][] datos=new String[list.size()][1];
	int i;
	encontrado = true;
        
        for (i = 0; i < list.size(); i++)
	{
		datos[i][0]=list.get(i).getNombreHotel();
	}
        
        if(datos.length == 0)
	{
              vistaAdmin.jPanelDatosHotel.setVisible(true);
              encontrado = false;
	}
        
        if(encontrado)
        {            
            vistaAdmin.jTextFieldCifHotel.setEnabled(false);
            vistaAdmin.jTextFieldCpHotel.setEnabled(false);
            vistaAdmin.jTextFieldDireccionHotel.setEnabled(false);
            vistaAdmin.jTextFieldEmailHotel.setEnabled(false);
            vistaAdmin.jTextFieldLocalidadHotel.setEnabled(false);
            vistaAdmin.jTextFieldNombreHotel.setEnabled(false);
            vistaAdmin.jTextFieldPaisHotel.setEnabled(false);
            vistaAdmin.jTextFieldPlantasHotel.setEnabled(false);
            vistaAdmin.jTextFieldProvinciaHotel.setEnabled(false);
            vistaAdmin.jTextFieldTelefonoHotel.setEnabled(false);
            
            vistaAdmin.jButtonRegistrarHotel.setEnabled(false);
            
            try 
            {
                    List<EntidadHotel> list1=ControladorAdministrador.getHotel();
                    
                    int j;
                    for (j = 0; j < list1.size(); j++) 
                    {
                            vistaAdmin.jTextFieldNombreHotel.setText(list1.get(j).getNombreHotel());
                            vistaAdmin.jTextFieldCifHotel.setText(list1.get(j).getCif());
                            vistaAdmin.jTextFieldDireccionHotel.setText(list1.get(j).getDireccion());
                            vistaAdmin.jTextFieldCpHotel.setText(String.valueOf(list1.get(j).getCp()));
                            vistaAdmin.jTextFieldTelefonoHotel.setText(String.valueOf(list1.get(j).getTelefono()));
                            vistaAdmin.jTextFieldLocalidadHotel.setText(list1.get(j).getLocalidad());
                            vistaAdmin.jTextFieldPaisHotel.setText(list1.get(j).getPais());
                            vistaAdmin.jTextFieldProvinciaHotel.setText(list1.get(j).getProvincia());
                            vistaAdmin.jTextFieldEmailHotel.setText(list1.get(j).getEmailHotel());
                            vistaAdmin.jTextFieldPlantasHotel.setText(String.valueOf(list1.get(j).getPlantas()));
                    }
                    
                    
            vistaAdmin.jPanelContenedor.setVisible(true);
            vistaAdmin.jPanelDatosHotel.setVisible(true);
            } 

            catch (SQLException e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            } 

            catch (Exception e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            }
        }
    }
    
    
    
    
    private void consultaNombreHotel() throws SQLException, Exception 
    {
        List<EntidadHotel> list = ControladorAdministrador.getHotel();
        
        String[][] datos=new String[list.size()][1];
	int i;
	encontrado = true;
        
        for (i = 0; i < list.size(); i++)
	{
		datos[i][0]=list.get(i).getNombreHotel();
	}
        
        if(datos.length == 0)
	{
              encontrado = false;
              vistaAdmin.jLabelBienvenidos.setText("Debe registrar el hotel");
              vistaAdmin.jLabelBienvenidos1.setText("Debe registrar el hotel");
              vistaAdmin.jLabelBienvenidos2.setText("Debe registrar el hotel");
              vistaAdmin.jLabelBienvenidos3.setText("Debe registrar el hotel");
              vistaAdmin.jLabelBienvenidos4.setText("Debe registrar el hotel");
	}
        
        if(encontrado)
        {
            try 
            {
                    List<EntidadHotel> list1=ControladorAdministrador.getHotel();
                    
                    int j;
                    for (j = 0; j < list1.size(); j++) 
                    {
                            vistaAdmin.jLabelBienvenidos.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                            vistaAdmin.jLabelBienvenidos1.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                            vistaAdmin.jLabelBienvenidos2.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                            vistaAdmin.jLabelBienvenidos3.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                            vistaAdmin.jLabelBienvenidos4.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                    }
            } 

            catch (SQLException e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            } 

            catch (Exception e1) 
            {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
            }
        }
    }
    
    /****************************************************************************************************************
    * **************************************MOSTRAR ROLES EN LA TABLA************************************************
    * *************************************************************************************************************/
    
    public void mostrarRoles() throws SQLException, Exception
    {
        String [] cabeceraRoles = {"ROLES DE EMPLEADOS"};
        int j = 0;
        
        List<EntidadRol> listRoles = ControladorAdministrador.getRoles();
        String[][] datosRoles=new String[listRoles.size()][1];
        
              for (j = 0; j < listRoles.size(); j++) 
              {
                    datosRoles[j][0] = listRoles.get(j).getRol();
              }

        vistaAdmin.jTableRoles.setModel(new DefaultTableModel(datosRoles, cabeceraRoles));
        dialog.jTableMantenimiento.setModel(new DefaultTableModel(datosRoles, cabeceraRoles));
    }
    
    
    

    /****************************************************************************************************************
    * **************************************MOSTRAR VISTAS EN LA TABLA***********************************************
    * *************************************************************************************************************/
    
    public void mostrarVistas() throws SQLException, Exception
    {
        String [] cabeceraVistas = {"VISTAS DE LAS HABITACIONES"};
        int j = 0;
        
        List<EntidadVistas> listVistas = ControladorAdministrador.getVistas();
        String[][] datosVistas=new String[listVistas.size()][1];
        vistaAdmin.jComboBoxVistas.removeAllItems();
        
              for (j = 0; j < listVistas.size(); j++) 
              {
                    datosVistas[j][0] = listVistas.get(j).getVista();
                    vistaAdmin.jComboBoxVistas.addItem(listVistas.get(j).getVista());
              }

        vistaAdmin.jTableVistas.setModel(new DefaultTableModel(datosVistas, cabeceraVistas));
        dialog.jTableMantenimiento.setModel(new DefaultTableModel(datosVistas, cabeceraVistas));
    }
    
    
    /****************************************************************************************************************
    * **************************************MOSTRAR TIPOS EN LA TABLA************************************************
    * *************************************************************************************************************/
    
    public void mostrarTipos() throws SQLException, Exception
    {
        String [] cabeceraTipos = {"TIPOS DE HABITACIONES"};
        j = 0;
        vistaAdmin.jComboBoxTipo.removeAllItems();
        
        List<EntidadTipos> listTipos = ControladorAdministrador.getTipos();
        String[][] datosTipos=new String[listTipos.size()][1];
        
              for (j = 0; j < listTipos.size(); j++) 
              {
                    datosTipos[j][0] = listTipos.get(j).getTipo();
                    vistaAdmin.jComboBoxTipo.addItem(listTipos.get(j).getTipo());
              }

        vistaAdmin.jTableTipos.setModel(new DefaultTableModel(datosTipos, cabeceraTipos));
        dialog.jTableMantenimiento.setModel(new DefaultTableModel(datosTipos, cabeceraTipos));
    }
    
    /****************************************************************************************************************
    * **************************************MOSTRAR CAPACIDAD EN LA TABLA********************************************
    * *************************************************************************************************************/
    
    public void mostrarCapacidad() throws SQLException, Exception
    {
        String [] cabeceraCapacidad = {"CAPACIDAD DE HABITACIONES"};
        j = 0;
        vistaAdmin.jComboBoxCapacidad.removeAllItems();
        
        List<EntidadCapacidad> listCapacidad = ControladorAdministrador.getCapacidad();
        String[][] datosCapacidad=new String[listCapacidad.size()][1];
        
              for (j = 0; j < listCapacidad.size(); j++) 
              {
                    datosCapacidad[j][0] = String.valueOf(listCapacidad.get(j).getCapacidad());
                    vistaAdmin.jComboBoxCapacidad.addItem(listCapacidad.get(j).getCapacidad());
              }

        vistaAdmin.jTableCapacidad.setModel(new DefaultTableModel(datosCapacidad, cabeceraCapacidad));
        dialog.jTableMantenimiento.setModel(new DefaultTableModel(datosCapacidad, cabeceraCapacidad));
    }
    
    
    
    public void mostrarPension() throws SQLException, Exception
    {
        String [] cabeceraVistas = {"Pensión", "Precio"};
        int j = 0;
        
        List<EntidadPension> listPension = ControladorAdministrador.getPension();
        String[][] datosPension=new String[listPension.size()][2];
        
              for (j = 0; j < listPension.size(); j++) 
              {
                    datosPension[j][0]=listPension.get(j).getPension();
                    datosPension[j][1]=Integer.toString(listPension.get(j).getPrecio());
              }

        dialog.jTableMantenimiento.setModel(new DefaultTableModel(datosPension, cabeceraVistas));
    }
    
    
    
    private void mostrarEmpleados() 
    {
        try 
	{       
                contador = 0;
                
		String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
		List<EntidadEmpleado> list=ControladorAdministrador.getEmpleados();
					
		String[][] datos=new String[list.size()][9];
		int i;
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getId());
			datos[i][1]=list.get(i).getDni();
			datos[i][2]=list.get(i).getNombre();
			datos[i][3]=list.get(i).getApellidos();
			datos[i][4]=list.get(i).getDireccion();
			datos[i][5]=Integer.toString(list.get(i).getTelefono());
			datos[i][6]=list.get(i).getRol();
                        datos[i][7]=list.get(i).getUsuario();
			datos[i][8]=list.get(i).getClave();
		}
					
		vistaAdmin.jTableConsultaEmpleados.setModel(new DefaultTableModel(datos, cabecera));
        
                sportColumn = vistaAdmin.jTableConsultaEmpleados.getColumnModel().getColumn(6);
                comboBox = new JComboBox();
                
                rellenarComboRoles();
	} 
        
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
    
    public void mostrarClientes()
    {
        try 
	{                
		String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento", "CP", "Pais", "Localidad", "Provincia"};
		List<EntidadCliente> list=ControladorAdministrador.getCliente();
					
		String[][] datos=new String[list.size()][12];
		int i;
                
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getId());
			datos[i][1]=list.get(i).getDni();
			datos[i][2]=list.get(i).getNombre();
			datos[i][3]=list.get(i).getApellidos();
			datos[i][4]=list.get(i).getDireccion();
			datos[i][5]=Integer.toString(list.get(i).getTelefono());
			datos[i][6]=list.get(i).getEmail();
                        datos[i][7]=list.get(i).getFechaNacimiento();
			datos[i][8]=Integer.toString(list.get(i).getCp());
			datos[i][9]=list.get(i).getPais();
                        datos[i][10]=list.get(i).getLocalidad();
			datos[i][11]=list.get(i).getProvincia();
		}
					
		vistaAdmin.jTableConsultaClientes.setModel(new DefaultTableModel(datos, cabecera));
	} 
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
    
    
    
    private void mostrarHabitaciones() 
    {
        try 
	{       
                contador = 0;
                
		String [] cabecera={"Nº habitación", "Nº planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
		List<EntidadHabitación> list= ControladorAdministrador.getHabitaciones();
					
		String[][] datos=new String[list.size()][9];
		int i;
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
			datos[i][1]=Integer.toString(list.get(i).getNPlanta());
			datos[i][2]=list.get(i).getVistas();
                        datos[i][3]=list.get(i).getTipo();
			datos[i][4]=list.get(i).getEstado();
			datos[i][5]=list.get(i).getDniLimpiadora();
			datos[i][6]=Integer.toString(list.get(i).getCapacidad());
                        datos[i][7]=list.get(i).getDescripcion();
                        datos[i][8]=Integer.toString(list.get(i).getPrecio());                        
		}
					
		vistaAdmin.jTableConsultaHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                
                sportColumn = vistaAdmin.jTableConsultaHabitaciones.getColumnModel().getColumn(1);
                sportColumn1 = vistaAdmin.jTableConsultaHabitaciones.getColumnModel().getColumn(2);
                sportColumn2 = vistaAdmin.jTableConsultaHabitaciones.getColumnModel().getColumn(3);
                sportColumn3 = vistaAdmin.jTableConsultaHabitaciones.getColumnModel().getColumn(6);
                
                comboBox = new JComboBox();
                comboBox1 = new JComboBox();
                comboBox2 = new JComboBox();
                comboBox3 = new JComboBox();
                
                rellenarComboCapacidad();
                rellenarComboVista();
                rellenarComboTipo();
	}
        
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
    
    
    public void rellenarComboRoles() throws SQLException, Exception
    {
        j = 0;
        vistaAdmin.jComboBoxRol.removeAllItems();
        
        List<EntidadRol> listRol = ControladorAdministrador.getRoles();
        
              for (j = 0; j < listRol.size(); j++) 
              {                  
                  comboBox.addItem(listRol.get(j).getRol());
                  vistaAdmin.jComboBoxRol.addItem(listRol.get(j).getRol());
              }
              
              sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }
    
    public void rellenarComboRoles1() throws SQLException, Exception
    {
        j = 0;
        vistaAdmin.jComboBoxRol.removeAllItems();
        
        List<EntidadRol> listRol = ControladorAdministrador.getRoles();
        
              for (j = 0; j < listRol.size(); j++) 
              {                  
                  vistaAdmin.jComboBoxRol.addItem(listRol.get(j).getRol());
              }
    }
    
    
    public void rellenarComboCapacidad() throws SQLException, Exception
    {
        j = 0;
        
        List<EntidadCapacidad> listCapacidad = ControladorAdministrador.getCapacidad();
        
        if(listCapacidad!=null)
        {
              for (j = 0; j < listCapacidad.size(); j++) 
              {                  
                  comboBox.addItem(listCapacidad.get(j).getCapacidad());
              }
              
              sportColumn3.setCellEditor(new DefaultCellEditor(comboBox));
        }
    }
    
    public void rellenarComboVista() throws SQLException, Exception
    {
        j = 0;
        
        List<EntidadVistas> listVistas = ControladorAdministrador.getVistas();
        
              for (j = 0; j < listVistas.size(); j++) 
              {                  
                  comboBox1.addItem(listVistas.get(j).getVista());
              }
              
              sportColumn1.setCellEditor(new DefaultCellEditor(comboBox1));
    }
    
    public void rellenarComboTipo() throws SQLException, Exception
    {
        j = 0;
        
        List<EntidadTipos> listTipos = ControladorAdministrador.getTipos();
        
              for (j = 0; j < listTipos.size(); j++) 
              {                  
                  comboBox2.addItem(listTipos.get(j).getTipo());
              }
              
              sportColumn2.setCellEditor(new DefaultCellEditor(comboBox2));
    }
    
    
    
    //COMPROBAR SI EL NOMBRE DE USUARIO SE REPITE

    private void comprobarSiUsuarioExiste() throws SQLException, Exception 
    {
        List<EntidadEmpleado> list = ControladorAdministrador.getEmpleado();
        
        String[][] datos=new String[list.size()][3];
	int i;
	encontrado=false;
        comprobarUsuario = true;
        
        for (i = 0; i < list.size(); i++) 
	{
		datos[i][0]=list.get(i).getUsuario();
	
                if(datos[i][0].equals(vistaAdmin.jTextFieldUsuarioEmp.getText()))
		{
                    comprobarUsuario = false;
		}
                
                else
                {
                    comprobarUsuario = true;
                }
	}
        
        if(comprobarUsuario)
        {
            insertarEmpleado(ee);
            JOptionPane.showMessageDialog(null, "El registro se ha realizado correctamente");
            limpiarCampos();
            mostrarEmpleados();
            mostrarLimpiadoras();
        }
        
        else
        {
            
            JOptionPane.showMessageDialog(null, "Ese nombre de usuario no está disponible");
        }
    }
    
    
    private void limpiarCampos() 
    {
        vistaAdmin.jTextFieldApellidos.setText("");
        vistaAdmin.jTextFieldClave.setText("");
        vistaAdmin.jTextFieldDireccion.setText("");
        vistaAdmin.jTextFieldDni.setText("");
        vistaAdmin.jTextFieldNombre.setText("");
        vistaAdmin.jTextFieldRepetirClave.setText("");
        vistaAdmin.jTextFieldTelefono.setText("");
        vistaAdmin.jTextFieldUsuarioEmp.setText("");
        vistaAdmin.jTextFieldProvincia.setText("");
        vistaAdmin.jTextFieldCp.setText("");
        vistaAdmin.jTextFieldLocalidad.setText("");
        vistaAdmin.jTextFieldPais.setText("");
        vistaAdmin.jTextFieldEmail.setText("");
    }
    
    
    
    
     private void mostrarHabitaciones1() 
    {
        try 
	{            
		String [] cabecera={"Nº habitación", "Nº planta", "Vistas", "Tipo", "Estado", "Capacidad", "DNI limpiadora", "Descripción", "Precio"};
		List<EntidadHabitación> list= ControladorAdministrador.getHabitaciones1();
					
		String[][] datos=new String[list.size()][9];
		int i;
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
			datos[i][1]=Integer.toString(list.get(i).getNPlanta());
			datos[i][2]=list.get(i).getVistas();
                        datos[i][3]=list.get(i).getTipo();
			datos[i][4]=list.get(i).getEstado();
			datos[i][5]=Integer.toString(list.get(i).getCapacidad());
			datos[i][6]=list.get(i).getDniLimpiadora();
                        datos[i][7]=list.get(i).getDescripcion();
                        datos[i][8]=Integer.toString(list.get(i).getPrecio());
		}
					
		vistaAdmin.jTableHabitacionesAsignar.setModel(new DefaultTableModel(datos, cabecera));
	} 
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }

    private void mostrarLimpiadoras() {
       try 
	{
                ee.setRol("Limpiadora");
            
		String [] cabecera={"ID empleado", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Rol empleado", "Usuario", "Clave"};
		List<EntidadEmpleado> list= ControladorAdministrador.getLimpiadoras(ee);
					
		String[][] datos=new String[list.size()][9];
		int i;
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getId());
			datos[i][1]=list.get(i).getDni();
			datos[i][2]=list.get(i).getNombre();
			datos[i][3]=list.get(i).getApellidos();
			datos[i][4]=list.get(i).getDireccion();
			datos[i][5]=Integer.toString(list.get(i).getTelefono());
			datos[i][6]=list.get(i).getRol();
                        datos[i][7]=list.get(i).getUsuario();
			datos[i][8]=list.get(i).getClave();
		}
					
		vistaAdmin.jTableLimpiadorasAsignar.setModel(new DefaultTableModel(datos, cabecera));
	} 
	catch (SQLException e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	} 
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
    
    
        /****************************************************************************************************************
         * ***************************************************INFORMES************************************************
        **************************************************************************************************************/
    
     private void mostrarInformesClientes(){
         
           try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("Clientes.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Clientes.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("Clientes.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        vistaAdmin.jPanelReportesGenerados.updateUI();
         
     }
     
     private void mostrarInformesEmpleados(){
         
              try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("Empleados.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Empleados.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("Empleados.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        vistaAdmin.jPanelReportesGenerados.updateUI();
         
     }
    
     private void mostrarInformesHabitaciones(){
         
            try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("habitaciones.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("habitaciones.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("habitaciones.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        vistaAdmin.jPanelReportesGenerados.updateUI();
         
     }
    
     private void mostrarInformesReservas(){
         
            
           try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("reservas.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("reservas.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("reservas.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        vistaAdmin.jPanelReportesGenerados.updateUI();
         
     }
     
       public void detener() {
        if (controlador != null) {
            controlador.closeDocument();
        }
    }

    public void destruir() {
        if (controlador != null) {
            controlador.dispose();
            controlador = null;
        }
        vistaAdmin.jPanelReportesGenerados.removeAll();
    }

    public void dibujarGIU() {
        controlador = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controlador);
        controlador.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controlador.getDocumentViewController()));

        MyAnnotationCallback myAnnotationCallback = new MyAnnotationCallback(
                controlador.getDocumentViewController());
        controlador.getDocumentViewController().setAnnotationCallback(myAnnotationCallback);

        vistaAdmin.jPanelReportesGenerados.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(factory.buildViewerPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        vistaAdmin.jPanelReportesGenerados.add(scroll,BorderLayout.CENTER);
    }
    
}