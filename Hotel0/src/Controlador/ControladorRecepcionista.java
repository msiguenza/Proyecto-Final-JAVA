/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexiones.Conexiones;
import Entidad.EntidadCapacidad;
import Entidad.EntidadCheckIn;
import Entidad.EntidadCheckOut;
import Entidad.EntidadCliente;
import Entidad.EntidadEmpleado;
import Entidad.EntidadHabitación;
import Entidad.EntidadHotel;
import Entidad.EntidadPago;
import Entidad.EntidadPension;
import Entidad.EntidadReserva;
import Modelo.ModeloCliente;
import Modelo.ModeloEmpleados;
import Modelo.ModeloHabitacion;
import Modelo.ModeloHotel;
import Modelo.ModeloRecepcionista;
import Vistas.InformesRecepcionista;
import Vistas.VistaAdministrador;
import Vistas.VistaCheckIn;
import Vistas.VistaCobrarReserva;
import Vistas.VistaRecepcionista;
import Vistas.VistaReservas;
import Vistas.validaciones;
import Vistas.vistaFichaCliente;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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
public class ControladorRecepcionista implements ActionListener
{
    VistaRecepcionista vistaRec = new VistaRecepcionista();
    VistaReservas vistaRes = new VistaReservas();
    VistaCheckIn vistaCheckIn = new VistaCheckIn();
    validaciones val = new validaciones();
    VistaCobrarReserva cobrar = new VistaCobrarReserva();
    vistaFichaCliente ficha = new vistaFichaCliente();
    InformesRecepcionista inforecep = new InformesRecepcionista();
    
    //reportes
    SwingController controlador = new SwingController();
    
    String disponible, limpiadora, dni, efectivo, tarjeta;
    String fechaSalida2, fechaEntrada2, fechaEntradaDiaAnterior, fechaEntradaMesAnterior, fechaEntradaAnyoAnterior, 
    fechaSalidaDiaAnterior, fechaSalidaMesAnterior, fechaSalidaAnyoAnterior,
    fechaEntradaAnterior, fechaSalidaAnterior, resultado;
    String diaEntrada, mesEntrada, anyoEntrada,diaSalida, mesSalida, anyoSalida, nHabitacionCheckOut;

    int diaEntradaInt, diaSalidaInt, mesEntradaInt, mesSalidaInt, anyoEntradaInt, anyoSalidaInt,
    diaEntradaInt1, diaSalidaInt1, mesSalidaInt1, anyoSalidaInt1, mesEntradaInt1, anyoEntradaInt1, resp,
    pensiones, nPensiones = 0, total = 0, precio;
    
    String id1="", nombre="", apellidos="", direccion="", telefono1="", fechaNacimiento,  localidad="", provincia="", pais="", email="", cp1="";
    int id=0, telefono=0, cp=0;

    int diaActual, mesActual, anyoActual;

    boolean encontrado=false, actual=false, camposCorrectos = false;

    int diaEntrada1, mesEntrada1, anyoEntrada1, diaSalida1, mesSalida1, anyoSalida1;
    
    int filaSelecLim=0, filas=0, i=0, contador = 0, j = 0, nPersonas = 0;
    
    long totalHoras, comprobarEfectivo=0;
    InputMap map = new InputMap();
    
    EntidadCliente ec = new EntidadCliente();
    EntidadHabitación eh = new EntidadHabitación();
    EntidadReserva er = new EntidadReserva();
    EntidadPension ep = new EntidadPension();
    EntidadCheckIn ech = new EntidadCheckIn();
    EntidadCheckOut echo = new EntidadCheckOut();
    EntidadPago epa = new EntidadPago();
    
    TableColumn sportColumn, sportColumn1, sportColumn2, sportColumn3;
    JComboBox comboBox;
    DefaultTableModel tb;
    
    
    public ControladorRecepcionista()
    {
        
    }
    
    public ControladorRecepcionista(VistaRecepcionista vistaRec)
    {
        this.vistaRec = vistaRec;
    }
    
    //REGISTRO DE CLIENTE
	
    public static void registrarClientes(EntidadCliente nuevoCliente) throws Exception 
    {
            ModeloCliente.insertarCliente(nuevoCliente);
    }
    
    public static void insertarCheckIn(EntidadCheckIn nuevoCheckIn) throws Exception 
    {
            ModeloRecepcionista.insertarCheckIn(nuevoCheckIn);
    }
    
    public static void insertarCheckOut(EntidadCheckOut nuevoCheckOut) throws Exception 
    {
            ModeloRecepcionista.insertarCheckOut(nuevoCheckOut);
    }
    
    public static void insertarCobro(EntidadCheckIn nuevoCobro) throws Exception 
    {
            ModeloRecepcionista.insertarCobro(nuevoCobro);
    }
    
    //REGISTRO DE HABITACIONES
    
    public static void registrarHabitaciones(EntidadHabitación nuevaHabitacion) throws Exception 
    {
            ModeloHabitacion.insertarHabitacion(nuevaHabitacion);
    }
    
    //MOSTRAR DATOS DE CLIENTES
	
    public static List<EntidadReserva> getCliente(EntidadReserva reservaCliente) throws SQLException, Exception 
    {
            return ModeloCliente.getCliente(reservaCliente);
    }
    
    //MOSTRAR DATOS DE CLIENTES
	
    public static List<EntidadCliente> getClientes() throws SQLException, Exception 
    {
            return ModeloCliente.getClientes();
    }
    
    
    public static List<EntidadReserva> getDniClienteReservaFechaEntrada(EntidadReserva dniClienteFechaReserva) throws SQLException, Exception 
    {
            return ModeloRecepcionista.getDniClienteReservaFechaEntrada(dniClienteFechaReserva);
    }
    
    
    //MOSTRAR LIMPIADORAS
	
    public static List<EntidadEmpleado> getLimpiadoras(EntidadEmpleado limpiadora) throws SQLException, Exception 
    {
            return ModeloEmpleados.getLimpiadora(limpiadora);
    }
    
     //MOSTRAR HABITACIONES
	
    public static List<EntidadHabitación> getHabitaciones() throws SQLException, Exception 
    {
            return ModeloHabitacion.getHabitaciones();
    }
    
    
    
        //buscar por dni
		
	public static List<EntidadCliente> getDniCliente(EntidadCliente filtrarClienteDni) throws SQLException, Exception 
	{
		return ModeloCliente.getDniClienteReserva(filtrarClienteDni);
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
        
        //buscar por nombre
        
	public static List<EntidadCliente> getNombreCliente(EntidadCliente filtrarClienteNombre) throws SQLException, Exception 
	{
		return ModeloCliente.getNombreCliente(filtrarClienteNombre);
	}
        
        //buscar por apellido
        
	public static List<EntidadCliente> getApellidosCliente(EntidadCliente filtrarClienteApellidos) throws SQLException, Exception 
	{
		return ModeloCliente.getApellidosCliente(filtrarClienteApellidos);
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
        
        //buscar por precio
        
        public static List<EntidadHabitación> getBuscarPrecio(EntidadHabitación filtrarPrecio) throws SQLException, Exception 
	{
		return ModeloHabitacion.getPrecio(filtrarPrecio);
	}
        
        //buscar por nº habitación reservada
        
        public static List<EntidadReserva> getNHabitacionReserva(EntidadReserva filtrarNHabitacion) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getNHabitacion(filtrarNHabitacion);
	}
        
        //buscar por fecha entrada
        
        public static List<EntidadReserva> getFechaEntradaReserva(EntidadReserva filtrarFechaEntrada) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getFechaEntradaReserva(filtrarFechaEntrada);
	}
        
        
        public static List<EntidadReserva> getFechaEntradaDniCliente(EntidadReserva filtrarFechaEntradaDniCliente) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getFechaEntradaDniCliente(filtrarFechaEntradaDniCliente);
	}
        
        //buscar por fecha salida
        
        public static List<EntidadReserva> getFechaSalidaReserva(EntidadReserva filtrarFechaSalida) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getFechaSalidaReserva(filtrarFechaSalida);
	}
        
        //buscar por dni cliente
        
        public static List<EntidadReserva> getDniClienteReserva(EntidadReserva filtrarDniCliente) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getDniClienteReserva(filtrarDniCliente);
	}
        
        //buscar por nº personas
        
        public static List<EntidadReserva> getNPersonasReserva(EntidadReserva filtrarNPersonas) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getNPersonasReserva(filtrarNPersonas);
	}
        
         //buscar por pensión
        
        public static List<EntidadPension> getNombrePension(EntidadPension filtrarPension) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getNombrePension(filtrarPension);
	}
        
        //buscar por pensión
        
        public static List<EntidadPension> getPrecioPension(EntidadPension filtrarPrecio) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getPrecioPension(filtrarPrecio);
	}
        
        
        //buscar por fecha salida y nº de habitación
        
        public static List<EntidadReserva> getFechaSalidaCheckOut(EntidadReserva filtrarFechaSalida) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getFechaSalidaCheckOut(filtrarFechaSalida);
	}
        
        //buscar pago
        
        public static List<EntidadPago> getPago(EntidadPago filtrarPago) throws SQLException, Exception 
	{
		return ModeloRecepcionista.getPago(filtrarPago);
	}
    
    //MODIFICAR DATOS DESDE TABLA
		
    public static void modificarCliente(EntidadCliente modificarCliente) throws Exception 
    {
            ModeloCliente.modificarCliente(modificarCliente);
    }
    
    public static void modificarCobro(EntidadCheckIn modificarCobro) throws Exception 
    {
            ModeloRecepcionista.modificarCobro(modificarCobro);
    }
    
    public static List<EntidadCapacidad> getCapacidad() throws SQLException, Exception 
    {
           return ModeloHotel.getCapacidad();
    }
    
    
    public static List<EntidadReserva> getFecha(EntidadReserva er) throws SQLException, Exception 
    {
		return ModeloRecepcionista.getFecha(er);
    }
    
    public static List<EntidadPago> mostrarPago(EntidadPago epa) throws SQLException, Exception 
    {
           return ModeloRecepcionista.mostrarPago(epa);
    }
    
    public static List<EntidadPago> mostrarPagoPorFecha(EntidadPago epa) throws SQLException, Exception 
    {
           return ModeloRecepcionista.mostrarPagoPorFecha(epa);
    }
    
    public static List<EntidadCheckIn> getCheckIn(EntidadCheckIn echi) throws SQLException, Exception 
    {
		return ModeloRecepcionista.getCheckIn(echi);
    }
    
    public static List<EntidadPago> getPagoRealizado(EntidadPago epa) throws SQLException, Exception 
    {
		return ModeloRecepcionista.getPagoRealizado(epa);
    }
    
    //buscar por pension
        
    public static List<EntidadPension> getPension() throws SQLException, Exception 
    {
	return ModeloHotel.getPension();
    }
    
    
    //INSERTAR RESERVAS
	
    public static void insertarReserva(EntidadReserva nuevaReserva) throws Exception 
    {
            ModeloRecepcionista.insertarReserva(nuevaReserva);
    }
    
    
    //MOSTRAR DATOS DE RESERVAS
	
    public static List<EntidadReserva> getReservas() throws SQLException, Exception 
    {
            return ModeloRecepcionista.getReservas();
    }
    
    //MOSTRAR PRECIO DE LAS HABITACIONES
	
    public static List<EntidadHabitación> getPrecio() throws SQLException, Exception 
    {
            return ModeloRecepcionista.getPrecio();
    }
    
    public static List<EntidadCheckIn> mostrarCheckIn() throws SQLException, Exception 
    {
            return ModeloRecepcionista.mostrarCheckIn();
    }
    
    public static List<EntidadCheckOut> mostrarCheckOut() throws SQLException, Exception 
    {
            return ModeloRecepcionista.mostrarCheckOut();
    }
    
    //COMPROBAR USUARIO
	
    public static List<EntidadReserva> getReservasClientes(EntidadReserva reservasClientes) throws SQLException, Exception 
    {
            return ModeloRecepcionista.getReservasClientes(reservasClientes);
    }
    
    public static void eliminarReserva(EntidadReserva eliminarReserva) throws Exception 
    {
	 ModeloRecepcionista.eliminarReserva(eliminarReserva);
    }
    
    
    
    
    
    public void iniciar() throws SQLException, Exception
    {
       consultaNombreHotel();
        
       vistaRec.jTree.addTreeSelectionListener(new TreeSelectionListener() 
       {

           @Override
           public void valueChanged(TreeSelectionEvent e) 
           {
             
             if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Clientes"))
             {
                 vistaRec.jPanel2.setVisible(true);
                 rellenarComboClientes();
                 vistaRec.jComboBoxBúsquedas.setVisible(true);
                 vistaRec.jTextFieldFiltrarBúsqueda.setVisible(true);
                 mostrarClientes();
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Histórico de reservas"))
             {
                 historicoDeReservas();
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Control de caja"))
             {
                 vistaRec.jComboBoxBúsquedas.setVisible(false);
                 vistaRec.jTextFieldFiltrarBúsqueda.setVisible(false);
                 vistaRec.jPanel2.setVisible(true);
                 
                 try {
                     verPagos();
                 } catch (SQLException ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Entradas hoy"))
             {
                 vistaRec.jComboBoxBúsquedas.setVisible(false);
                 vistaRec.jTextFieldFiltrarBúsqueda.setVisible(false);
                 vistaRec.jPanel2.setVisible(true);
                 entradasHoy();        
                 
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Salidas hoy"))
             {
                 vistaRec.jComboBoxBúsquedas.setVisible(false);
                 vistaRec.jTextFieldFiltrarBúsqueda.setVisible(false);
                 vistaRec.jPanel2.setVisible(true);
                 salidasHoy();
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Reservas de un cliente"))
             {
                 consultaReservaCliente();
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Habitaciones"))
             {
                 vistaRec.jPanel2.setVisible(true);
                 rellenarComboHabitaciones();
                 vistaRec.jComboBoxBúsquedas.setVisible(true);
                 vistaRec.jTextFieldFiltrarBúsqueda.setVisible(true);
                 mostrarHabitaciones();
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Clientes en hotel hoy"))
             {
                  JOptionPane.showMessageDialog(null, "Clientes en hotel hoy");
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Control de caja por fechas"))
             {
                 try {
                     pagosPorFechas();
                 } catch (SQLException ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Check in realizados"))
             {
                 try {
                     consultarCheckIn();
                 } catch (SQLException ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             
             else if(vistaRec.jTree.getLastSelectedPathComponent().toString().equals("Check out realizados"))
             {
                 try {
                     consultarCheckOut();
                 } catch (SQLException ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (Exception ex) {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                     
         }
       });
       
       
       vistaRec.jButtonReservas.setActionCommand("reservas");
       vistaRec.jButtonReservas.addActionListener(this);
       
       vistaRes.jButtonBuscarHabitacion.setActionCommand("buscar habitacion");
       vistaRes.jButtonBuscarHabitacion.addActionListener(this);
       
       vistaRes.jButtonReservar.setActionCommand("reservar");
       vistaRes.jButtonReservar.addActionListener(this);
       
       vistaRec.jToggleButtonPreciosHabitacion.setActionCommand("precios habitacion");
       vistaRec.jToggleButtonPreciosHabitacion.addActionListener(this);
       
       vistaRec.jToggleButtonPreciosPension.setActionCommand("precios pension");
       vistaRec.jToggleButtonPreciosPension.addActionListener(this);
       
       vistaRec.jTextFieldFiltrarBúsqueda.setActionCommand("filtrar busqueda");
       vistaRec.jTextFieldFiltrarBúsqueda.addActionListener(this);
       
       vistaRec.jButtonCancelarReserva.setActionCommand("cancelar reserva");
       vistaRec.jButtonCancelarReserva.addActionListener(this);
       
       vistaRec.jButtonModificar.setActionCommand("modificar cliente");
       vistaRec.jButtonModificar.addActionListener(this);
       
       vistaRec.jToggleButtonCheckIn.setActionCommand("check in");
       vistaRec.jToggleButtonCheckIn.addActionListener(this);
       
       
       vistaCheckIn.jTextFieldDni.setActionCommand("dni cliente");
       vistaCheckIn.jTextFieldDni.addActionListener(this);
       
       vistaCheckIn.jButtonRegistrar.setActionCommand("registrar cliente");
       vistaCheckIn.jButtonRegistrar.addActionListener(this);
       
       vistaCheckIn.jButtonRealizarCheckIn.setActionCommand("realizar check in");
       vistaCheckIn.jButtonRealizarCheckIn.addActionListener(this);
       
       vistaCheckIn.jButtonRefrescar.setActionCommand("refrescar check in");
       vistaCheckIn.jButtonRefrescar.addActionListener(this);
       
       vistaCheckIn.jButtonCobrarReserva.setActionCommand("cobrar reserva check in");
       vistaCheckIn.jButtonCobrarReserva.addActionListener(this);
       
       cobrar.jButtonEfectivo.setActionCommand("cobrar reserva efectivo");
       cobrar.jButtonEfectivo.addActionListener(this);
       
       cobrar.jButtonTarjeta.setActionCommand("cobrar reserva tarjeta");
       cobrar.jButtonTarjeta.addActionListener(this);
       
       vistaRec.jToggleButtonCheckOut.setActionCommand("check out");
       vistaRec.jToggleButtonCheckOut.addActionListener(this);
       
       vistaRec.jButtonFichaCliente.setActionCommand("ficha cliente");
       vistaRec.jButtonFichaCliente.addActionListener(this);
       
       vistaRec.jButtonInformes.setActionCommand("Informes");
       vistaRec.jButtonInformes.addActionListener(this);
       
       inforecep.jButtonInformesCheckIn.setActionCommand("Informe CheckIn");
       inforecep.jButtonInformesCheckIn.addActionListener(this);
       
       inforecep.jButtonInformesCheckOut.setActionCommand("Informe CheckOut");
       inforecep.jButtonInformesCheckOut.addActionListener(this);
       
       inforecep.jButtonInformesPension.setActionCommand("Informe Pension");
       inforecep.jButtonInformesPension.addActionListener(this);
       
       inforecep.jButtonInformesCaja.setActionCommand("Informe Caja");
       inforecep.jButtonInformesCaja.addActionListener(this);
       
       inforecep.jButtonInformesReservasRecep.setActionCommand("Informe Reserva");
       inforecep.jButtonInformesReservasRecep.addActionListener(this);
       
       ficha.jTextFieldDni.setActionCommand("ficha dni");
       ficha.jTextFieldDni.addActionListener(this);
       
       ficha.jButtonRefrescar.setActionCommand("refrescar ficha");
       ficha.jButtonRefrescar.addActionListener(this);
       
       
       val.Sletras(vistaCheckIn.jTextFieldNombre);
       val.Sletras(vistaCheckIn.jTextFieldApellidos);
       val.longitudCampo(vistaCheckIn.jTextFieldDni);
       val.SNumeros(vistaCheckIn.jTextFieldCp);
       val.longitudCampo2(vistaCheckIn.jTextFieldCp);
       val.SNumeros(vistaCheckIn.jTextFieldTelefono);
       val.longitudCampo1(vistaCheckIn.jTextFieldTelefono);
       val.SNumeros(vistaCheckIn.jTextFieldFechaNacimiento);
       val.Sletras(vistaCheckIn.jTextFieldLocalidad);
       val.Sletras(vistaCheckIn.jTextFieldProvincia);
       val.Sletras(vistaCheckIn.jTextFieldPais);
       
       val.pasarTextField(vistaCheckIn.jTextFieldNombre);
       val.pasarTextField(vistaCheckIn.jTextFieldApellidos);
       val.pasarTextField(vistaCheckIn.jTextFieldCp);
       val.pasarTextField(vistaCheckIn.jTextFieldTelefono);
       val.pasarTextField(vistaCheckIn.jTextFieldFechaNacimiento);
       val.pasarTextField(vistaCheckIn.jTextFieldLocalidad);
       val.pasarTextField(vistaCheckIn.jTextFieldProvincia);
       val.pasarTextField(vistaCheckIn.jTextFieldPais);
       val.longitudCampo(vistaRes.jTextFielDniCliente);
       
       //cuando un jbutton esta marcado podemos pulsar enter para que realice su funcion
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
        
        ficha.jButtonRefrescar.setInputMap(0, map);
       
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e!=null)
        {
        String s = e.getActionCommand();
        
        if(s.equals("reservas"))
        {
            try {
                mostrarCapacidad();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            vistaRes.setVisible(true);
        }else if(s.equals("Informes")){
            
            inforecep.setVisible(true);
        }
        
        else if (s.equals("Informe CheckIn")){
            mostrarInformeCheckIn();
        }else if(s.equals("Informe CheckOut")){
            mostrarInformeCheckOut();
        }else if (s.equals("Informe Pension")){
            mostrarInformePension();
        }else if (s.equals("Informe Caja")){
            mostrarInformeCaja();
        }else if (s.equals("Informe Reserva")){
            mostrarInformeReserva();
        }
        
        else if(s.equals("cancelar reserva"))
        {
            try {                    
                cancelarReserva();
            } catch (Exception ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(s.equals("registrar cliente"))
        {
            try
            {
               camposCorrectos = true;
               ec.setDni(vistaCheckIn.jTextFieldDni.getText());
               ec.setNombre(vistaCheckIn.jTextFieldNombre.getText());
               ec.setApellidos(vistaCheckIn.jTextFieldApellidos.getText());
               ec.setDireccion(vistaCheckIn.jTextFieldDireccion.getText());
               
               if(vistaCheckIn.jTextFieldTelefono.getText().equals(""))
               {
                   ec.setTelefono(0);
               }
               
               else
               {
                   ec.setTelefono(Integer.parseInt(vistaCheckIn.jTextFieldTelefono.getText()));
               }
               
               ec.setEmail(vistaCheckIn.jTextFieldEmail.getText());
               ec.setFechaNacimiento(vistaCheckIn.jTextFieldFechaNacimiento.getText());
               
               if(vistaCheckIn.jTextFieldCp.getText().equals(""))
               {
                   ec.setCp(0);
               }
               
               else
               {
                   ec.setCp(Integer.parseInt(vistaCheckIn.jTextFieldCp.getText()));
               }
               
               ec.setPais(vistaCheckIn.jTextFieldPais.getText());
               ec.setProvincia(vistaCheckIn.jTextFieldProvincia.getText());
               ec.setLocalidad(vistaCheckIn.jTextFieldLocalidad.getText());
               
               if(!val.NifValido(ec.getDni().trim()))
               {
                    //si el dni no es valido (llamamos al metodo que lo comprueba, instanciado en la clase validaciones)
                    camposCorrectos = false;
                    JOptionPane.showMessageDialog(null, "Introduzca un DNI valido");
               }
               
               else if(!val.isEmail((ec.getEmail().trim())))
               {
                   //si el email no es valido (llamamos al metodo que lo comprueba, instanciado en la clase validaciones)
                   camposCorrectos = false;
                   JOptionPane.showMessageDialog(null, "Introduzca un email válido");
               }
               
               else if(vistaCheckIn.jTextFieldTelefono.getText().length()!=9)
               {
                   JOptionPane.showMessageDialog(null, "El teléfono debe contener 9 dígitos");
                   camposCorrectos = false;
               }
               
               else if(vistaCheckIn.jTextFieldCp.getText().length()!=5)
               {
                   JOptionPane.showMessageDialog(null, "El CP debe contener 5 dígitos");
                   camposCorrectos = false;
               }
               
               else if(vistaCheckIn.jTextFieldDni.getText().equals("") || vistaCheckIn.jTextFieldNombre.getText().equals("") || 
                       vistaCheckIn.jTextFieldApellidos.getText().equals("") || vistaCheckIn.jTextFieldDireccion.getText().equals("") || 
                       vistaCheckIn.jTextFieldTelefono.getText().equals("") || vistaCheckIn.jTextFieldCp.getText().equals("") ||
                       vistaCheckIn.jTextFieldEmail.getText().equals("") || vistaCheckIn.jTextFieldFechaNacimiento.getText().equals("") ||
                       vistaCheckIn.jTextFieldLocalidad.getText().equals("") || vistaCheckIn.jTextFieldPais.getText().equals("") ||
                       vistaCheckIn.jTextFieldProvincia.getText().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                   camposCorrectos = false;
               }
               
               if(camposCorrectos)
               {
                   registrarClientes(ec);
               }
           }
           
           catch (Exception e1) 
           {
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: ya hay un cliente registrado con ese dni");
           }
        }
        
        
        else if(s.equals("realizar check in"))
        {
            total = 0;
            
            if(ec.getDni().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Introduzca el DNI del cliente");
            }
            
            else
            {
                try 
                {
                    String condiciones = "";
                    int comprobando = 0;
                    nPensiones = 0;
                    pensiones = 0;


                    DefaultTableModel dtm2 = (DefaultTableModel) vistaCheckIn.jTablePensiones.getModel();
                    DefaultTableModel dtm3 = (DefaultTableModel) vistaCheckIn.jTableDetallesReserva.getModel();


                    j = 0;

                        List<EntidadPension> listPrecioPension = ControladorRecepcionista.getPension();
                        dtm2.setNumRows(listPrecioPension.size());

                        encontrado = true;

                                        for (j = 0; j < listPrecioPension.size(); j++) 
                                        {
                                              dtm2.setValueAt(listPrecioPension.get(j).getPension(), j, 2);
                                              dtm2.setValueAt(listPrecioPension.get(j).getPrecio(), j, 3);

                                              if(dtm2.getValueAt(j, 0)==true)
                                              {
                                                  pensiones = Integer.parseInt(dtm2.getValueAt(j, 1).toString());
                                                  nPensiones=nPensiones + pensiones;
                                                  precio = Integer.parseInt(dtm2.getValueAt(j, 3).toString());
                                                  total = total+(precio*pensiones);

                                                  condiciones = condiciones+Integer.parseInt(dtm2.getValueAt(j, 1).toString())+ " "+dtm2.getValueAt(j, 2).toString()+"\n";
                                              }

                                            comprobando = Integer.parseInt(dtm3.getValueAt(0, 5).toString());

                                            if(nPensiones > comprobando)
                                            {
                                                 encontrado = false;
                                            }
                                        }

                                        if(!encontrado)
                                        {

                                                 JOptionPane.showMessageDialog(null, "No puede seleccionar más pensiones que"
                                                              + " personas en la reserva");
                                        }

                                        else
                                        {
                                            total = total + Integer.parseInt(dtm3.getValueAt(0, 7).toString());

                                            ech.setIdReserva(Integer.parseInt(dtm3.getValueAt(0, 0).toString()));
                                            ech.setNumHab(Integer.parseInt(dtm3.getValueAt(0, 1).toString()));

                                            Calendar cal = new GregorianCalendar();
                                            String diaActual1, mesActual1;

                                             diaActual=cal.get(Calendar.DAY_OF_MONTH);

                                             if(Integer.toString(diaActual).length()==1)
                                             {
                                                 diaActual1 = String.valueOf(diaActual);
                                                 diaActual1="0"+diaActual1;
                                             }

                                             else
                                             {
                                                 diaActual1 = String.valueOf(diaActual);
                                             }

                                             mesActual=cal.get(Calendar.MONTH);
                                             mesActual=mesActual+1;

                                             if(Integer.toString(mesActual).length()==1)
                                             {
                                                 mesActual1 = String.valueOf(mesActual);
                                                 mesActual1="0"+mesActual1;
                                             }

                                             else
                                             {
                                                 mesActual1 = String.valueOf(mesActual);
                                             }

                                             anyoActual=cal.get(Calendar.YEAR);

                                             String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;
                                             ech.setFechaEntrada(fechaActual);

                                             ech.setPrecioTotal(total);

                                             ech.setCondicionAlojamiento(condiciones);
                                             ech.setDnicliente(vistaCheckIn.jTextFieldDni.getText());
                                             ech.setNumPersonas(Integer.parseInt(dtm3.getValueAt(0, 5).toString()));

                                             vistaCheckIn.jButtonCobrarReserva.setEnabled(true);

                                             ControladorRecepcionista.insertarCheckIn(ech);
                                             
                                        }
                } 

                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Error: este check in ya ha sido realizado");
                    
                    vistaCheckIn.jButtonCobrarReserva.setEnabled(false);
                    vistaCheckIn.jTextFieldDni.setEnabled(true);
                    vistaCheckIn.jTextFieldNombre.setText("");
                    vistaCheckIn.jTextFieldApellidos.setText("");
                    vistaCheckIn.jTextFieldDni.setText("");
                    vistaCheckIn.jTextFieldCp.setText("");
                    vistaCheckIn.jTextFieldDireccion.setText("");
                    vistaCheckIn.jTextFieldEmail.setText("");
                    vistaCheckIn.jTextFieldTelefono.setText("");
                    vistaCheckIn.jTextFieldFechaNacimiento.setText("");
                    vistaCheckIn.jTextFieldLocalidad.setText("");
                    vistaCheckIn.jTextFieldProvincia.setText("");
                    vistaCheckIn.jTextFieldPais.setText("");
                    
                    DefaultTableModel tb=(DefaultTableModel) vistaCheckIn.jTableDetallesReserva.getModel();
                    int filas=vistaCheckIn.jTableDetallesReserva.getRowCount();

                    for(int i=1;i<=filas;i++)
                    {
                            tb.removeRow(0);
                    }
                } 

                catch (Exception ex) 
                {
                    Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
        else if(s.equals("refrescar check in"))
        {
            vistaCheckIn.jTextFieldDni.setEnabled(true);
            vistaCheckIn.jTextFieldDni.setText("");
            vistaCheckIn.jTextFieldNombre.setEnabled(false);
            vistaCheckIn.jTextFieldNombre.setText("");
            vistaCheckIn.jTextFieldApellidos.setEnabled(false);
            vistaCheckIn.jTextFieldApellidos.setText("");
            vistaCheckIn.jTextFieldDireccion.setEnabled(false);
            vistaCheckIn.jTextFieldDireccion.setText("");
            vistaCheckIn.jTextFieldCp.setEnabled(false);
            vistaCheckIn.jTextFieldCp.setText("");
            vistaCheckIn.jTextFieldEmail.setEnabled(false);
            vistaCheckIn.jTextFieldEmail.setText("");
            vistaCheckIn.jTextFieldFechaNacimiento.setEnabled(false);
            vistaCheckIn.jTextFieldFechaNacimiento.setText("");
            vistaCheckIn.jTextFieldTelefono.setEnabled(false);
            vistaCheckIn.jTextFieldTelefono.setText("");
            vistaCheckIn.jTextFieldLocalidad.setEnabled(false);
            vistaCheckIn.jTextFieldLocalidad.setText("");
            vistaCheckIn.jTextFieldProvincia.setEnabled(false);
            vistaCheckIn.jTextFieldProvincia.setText("");
            vistaCheckIn.jTextFieldPais.setEnabled(false);
            vistaCheckIn.jTextFieldPais.setText("");
            
            DefaultTableModel tb=(DefaultTableModel) vistaCheckIn.jTableDetallesReserva.getModel();
            DefaultTableModel tb1=(DefaultTableModel) vistaCheckIn.jTablePensiones.getModel();
            
            int filas=vistaCheckIn.jTableDetallesReserva.getRowCount();
            int filas1 = vistaCheckIn.jTablePensiones.getRowCount();
		
		for(int i=1;i<=filas;i++)
		{
			tb.removeRow(0);
		}
                
                for(i=1;i<=filas1;i++)
		{
                    tb1.removeRow(0);
		}
        }
        
        
        else if(s.equals("refrescar ficha"))
        {
            ficha.jTextFieldDni.setText("");
            ficha.jTextFieldNombre.setText("");
            ficha.jTextFieldApellidos.setText("");
            ficha.jTextFieldDireccion.setText("");
            ficha.jTextFieldCp.setText("");
            ficha.jTextFieldEmail.setText("");
            ficha.jTextFieldFechaNacimiento.setText("");
            ficha.jTextFieldTelefono.setText("");
            ficha.jTextFieldLocalidad.setText("");
            ficha.jTextFieldProvincia.setText("");
            ficha.jTextFieldPais.setText("");
            
            DefaultTableModel tb=(DefaultTableModel) ficha.jTableFichaCliente.getModel();
            filas=ficha.jTableFichaCliente.getRowCount();
		
		for(int i=1;i<=filas;i++)
		{
			tb.removeRow(0);
		}
        }
        
        
        
        else if(s.equals("dni cliente"))
        {
            dni = "";
            
            dni = vistaCheckIn.jTextFieldDni.getText();
            ec.setDni(dni);
            
            if(!val.NifValido(ec.getDni().trim()))
            {
                JOptionPane.showMessageDialog(null, "Introduzca un DNI correcto");
            }
            
            else
            {
            
                try 
                {
                     sportColumn = vistaCheckIn.jTablePensiones.getColumnModel().getColumn(1);
                     comboBox = new JComboBox();
                     rellenarComboCapacidad();


                     List<EntidadCliente> list=ControladorRecepcionista.getDniCliente(ec);

                     if(!list.isEmpty())
                     {
                        mostrarClientesReservas();

                        Calendar cal = new GregorianCalendar();
                        String diaActual1, mesActual1;

                         diaActual=cal.get(Calendar.DAY_OF_MONTH);

                         if(Integer.toString(diaActual).length()==1)
                         {
                             diaActual1 = String.valueOf(diaActual);
                             diaActual1="0"+diaActual1;
                         }

                         else
                         {
                             diaActual1 = String.valueOf(diaActual);
                         }

                         mesActual=cal.get(Calendar.MONTH);
                         mesActual=mesActual+1;

                         if(Integer.toString(mesActual).length()==1)
                         {
                             mesActual1 = String.valueOf(mesActual);
                             mesActual1="0"+mesActual1;
                         }

                         else
                         {
                             mesActual1 = String.valueOf(mesActual);
                         }

                         anyoActual=cal.get(Calendar.YEAR);

                         String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;

                         er.setFechaEntrada(fechaActual);
                         er.setDniCliente(dni);

                         encontrado = true;

                             try 
                             {
                                     String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones", "Precio reserva"};
                                     List<EntidadReserva> list1=ControladorRecepcionista.getFechaEntradaDniCliente(er);

                                     String[][] datos=new String[list1.size()][8];
                                     int i;
                                     for (i = 0; i < list1.size(); i++) 
                                     {
                                             datos[i][0]=Integer.toString(list1.get(i).getIdReserva());
                                             datos[i][1]=Integer.toString(list1.get(i).getNumHab());
                                             datos[i][2]=list1.get(i).getFechaEntrada();
                                             datos[i][3]=list1.get(i).getFechaSalida();
                                             datos[i][4]=list1.get(i).getDniCliente();
                                             datos[i][5]=Integer.toString(list1.get(i).getNumPersonas());
                                             datos[i][6]=list1.get(i).getObservaciones();
                                             datos[i][7]=Long.toString(list1.get(i).getPrecioHabitacion());

                                             eh.setNHabitacion(list1.get(i).getNumHab());
                                     }


                                     vistaCheckIn.jTableDetallesReserva.setModel(new DefaultTableModel(datos, cabecera));

                                     List<EntidadHabitación> listHab=ControladorRecepcionista.getNHabitacion(eh);
                                     
                                     if(listHab.isEmpty())
                                     {
                                         JOptionPane.showMessageDialog(null, "No hay reservas para este cliente en el día de hoy");
                                         vistaCheckIn.jButtonRealizarCheckIn.setEnabled(false);
                                     }
                                     
                                     else
                                     {

                                        for (i = 0; i < listHab.size(); i++) 
                                        {
                                                datos[i][0]=listHab.get(i).getEstado();
                                        }
                                           
                                            if(datos[0][0].equals("NO preparada"))
                                            {
                                                encontrado = false;
                                            }

                                            if(!encontrado)
                                            {
                                                JOptionPane.showMessageDialog(null, "La habitación no está preparada. No puede realizar aún el check in");
                                                vistaCheckIn.jButtonRealizarCheckIn.setEnabled(false);
                                            }

                                            else
                                            {
                                                 vistaCheckIn.jButtonRealizarCheckIn.setEnabled(true);
                                                 mostrarPensiones();
                                            }
                                        }

                             }

                             catch (Exception e1) 
                             {
                                     e1.printStackTrace();
                                     JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
                             }
                     }

                     else if(list.isEmpty())
                     {
                         JOptionPane.showMessageDialog(null, "REGISTRE EL CLIENTE");

                         vistaCheckIn.jTextFieldNombre.setEnabled(true);
                         vistaCheckIn.jTextFieldApellidos.setEnabled(true);
                         vistaCheckIn.jTextFieldDireccion.setEnabled(true);
                         vistaCheckIn.jTextFieldCp.setEnabled(true);
                         vistaCheckIn.jTextFieldTelefono.setEnabled(true);
                         vistaCheckIn.jTextFieldEmail.setEnabled(true);
                         vistaCheckIn.jTextFieldFechaNacimiento.setEnabled(true);
                         vistaCheckIn.jTextFieldLocalidad.setEnabled(true);
                         vistaCheckIn.jTextFieldProvincia.setEnabled(true);
                         vistaCheckIn.jTextFieldPais.setEnabled(true);

                         vistaCheckIn.jButtonRegistrar.setEnabled(true);
                         vistaCheckIn.jButtonRealizarCheckIn.setEnabled(false);
                         vistaCheckIn.jButtonCobrarReserva.setEnabled(false);
                     }
                 } 

                 catch (SQLException ex) 
                 {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 } 

                 catch (Exception ex) 
                 {
                     Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        }
        
        
        else if(s.equals("modificar cliente"))
        {
             filas = 0;
             resp = 0;

             try 
             {
                     filas = vistaRec.jTableConsultas.getSelectedRow();

                     if (filas == -1) 
                     {
                             JOptionPane.showMessageDialog(null, "Debe seleccionar el cliente que desea modificar");
                     }

                     else 
                     {
                             resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el cliente seleccionado?",
                             "Modificar", JOptionPane.YES_NO_OPTION);

                             if (resp == JOptionPane.YES_OPTION) 
                             {
                                     DefaultTableModel dtm = (DefaultTableModel) vistaRec.jTableConsultas.getModel();

                                     ec.setId(Integer.parseInt(dtm.getValueAt(filas, 0).toString()));

                                     ec.setDni(dtm.getValueAt(filas, 1).toString());

                                     ec.setNombre(dtm.getValueAt(filas, 2).toString());

                                     ec.setApellidos(dtm.getValueAt(filas, 3).toString());

                                     ec.setDireccion(dtm.getValueAt(filas, 4).toString());

                                     ec.setTelefono(Integer.parseInt(dtm.getValueAt(filas, 5).toString()));

                                     ec.setEmail(dtm.getValueAt(filas, 6).toString());
                                     
                                     ec.setFechaNacimiento( dtm.getValueAt(filas, 7).toString());
                                     
                                     ec.setCp(Integer.parseInt(dtm.getValueAt(filas, 8).toString()));
                                     
                                     ec.setLocalidad(dtm.getValueAt(filas, 9).toString());
                                     
                                     ec.setProvincia(dtm.getValueAt(filas, 10).toString());
                                     
                                     ec.setPais(dtm.getValueAt(filas, 11).toString());

                                     modificarCliente(ec);
                             }
                     }
             }

             catch (Exception e1) 
             {
                     e1.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Error: no se ha podido modificar correctamente");
             }
        }
        
        
        else if(s.equals("check in"))
        {
            vistaCheckIn.setVisible(true);
        }
        
        
        
        
        
        
        
        else if(s.equals("check out"))
        {
            nHabitacionCheckOut = JOptionPane.showInputDialog(null, "Introduzca el nº de habitación");
            
            er.setNumHab(Integer.parseInt(nHabitacionCheckOut));
            
            Calendar cal = new GregorianCalendar();
            
            String diaActual1, mesActual1;

            diaActual=cal.get(Calendar.DAY_OF_MONTH);

            if(Integer.toString(diaActual).length()==1)
            {
                     diaActual1 = String.valueOf(diaActual);
                     diaActual1="0"+diaActual1;
            }

            else
            {
                     diaActual1 = String.valueOf(diaActual);
            }

            mesActual=cal.get(Calendar.MONTH);
            mesActual=mesActual+1;

            if(Integer.toString(mesActual).length()==1)
            {
                     mesActual1 = String.valueOf(mesActual);
                     mesActual1="0"+mesActual1;
            }

            else
            {
                     mesActual1 = String.valueOf(mesActual);
            }

            anyoActual=cal.get(Calendar.YEAR);

            String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;
            
            er.setFechaSalida(fechaActual);
            
            
            
            try 
            {
                
		String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones", "Precio reserva"};
		List<EntidadReserva> list=ControladorRecepcionista.getFechaSalidaCheckOut(er);
					
		int i;
                boolean encontradoPago = false;
                
                if(list == null)
                {
                    JOptionPane.showMessageDialog(null, "No hay salidas programadas para esa habitación en el día de hoy");
                }
                
                else
                {
                
		for (i = 0; i < list.size(); i++) 
		{
			er.setIdReserva(list.get(i).getIdReserva());
                        er.setNumHab(list.get(i).getNumHab());
                        er.setFechaEntrada(list.get(i).getFechaEntrada());
                        er.setFechaSalida(list.get(i).getFechaSalida());
                        er.setDniCliente(list.get(i).getDniCliente());
                        er.setNumPersonas(list.get(i).getNumPersonas());
                        er.setObservaciones(list.get(i).getObservaciones());
                        er.setPrecioHabitacion(list.get(i).getPrecioHabitacion());
                        
                        epa.setIdReserva(list.get(i).getIdReserva());
		}
                
                    
                        List<EntidadPago> listPago=ControladorRecepcionista.getPago(epa);

                        for (i = 0; i < listPago.size(); i++) 
                        {
                                epa.setIdReserva(listPago.get(i).getIdReserva());
                                
                                if(er.getIdReserva()==epa.getIdReserva())
                                {
                                    encontradoPago = true;
                                }
                        }
                                
                                
                                
                                
                    if(!encontradoPago)
                    {
                                
                        JOptionPane.showMessageDialog(null, "PAGO PENDIENTE. COBRE LA RESERVA Y VUELVA A REALIZAR EL CHECK OUT");
                        
                        ech.setIdReserva(er.getIdReserva());
                        
                        List<EntidadCheckIn> list1=ControladorRecepcionista.getCheckIn(ech);
                        
                        
                            cobrar.jLabelDniCliente.setText(er.getDniCliente());
                            cobrar.jLabelIdReserva.setText(String.valueOf(er.getIdReserva()));
                            cobrar.jLabelPrecioReserva.setText(String.valueOf(er.getPrecioHabitacion()));
                            cobrar.jLabelFecha.setText(er.getFechaSalida());

                            for (i = 0; i < list1.size(); i++) 
                            {
                                cobrar.jLabelDesglosePensiones.setText(list1.get(i).getCondicionAlojamiento());
                                cobrar.jLabelTotal.setText(String.valueOf(list1.get(i).getPrecioTotal()));
                            }

                            cobrar.setVisible(true);
                        
                    }

                    else 
                    {
                        for (i = 0; i < list.size(); i++) 
                        {
                            echo.setIdReserva(list.get(i).getIdReserva());
                            echo.setNumHab(list.get(i).getNumHab());
                            echo.setFechaSalida(list.get(i).getFechaSalida().toString());
                            echo.setDniCliente(list.get(i).getDniCliente());
                            echo.setPrecioTotal(list.get(i).getPrecioHabitacion());
                        
                            eh.setNHabitacion(list.get(i).getNumHab());
                        }
                        

                        ControladorRecepcionista.insertarCheckOut(echo);
                            
                        List<EntidadHabitación> listHab=ModeloHabitacion.getNHabitacion(eh);

                        for (i = 0; i < listHab.size(); i++) 
                        {
                            eh.setNHabitacion(listHab.get(id).getNHabitacion());
                            eh.setNPlanta(listHab.get(id).getNPlanta());
                            eh.setVistas(listHab.get(id).getVistas());
                            eh.setTipo(listHab.get(id).getTipo());
                            eh.setEstado(listHab.get(id).getEstado());
                            eh.setDniLimpiadora(listHab.get(id).getDniLimpiadora());
                            eh.setCapacidad(listHab.get(id).getCapacidad());
                            eh.setDescripcion(listHab.get(id).getDescripcion());
                            eh.setPrecio(listHab.get(id).getPrecio());
                        }
                        
                        eh.setEstado("NO preparada");
                        
                        ModeloHabitacion.modificarHabitacion(eh);
                        
                        JOptionPane.showMessageDialog(null, "PAGO REALIZADO. TODO OK");
                    }  
                }
                
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Este check out ya se ha realizado anteriormente");
            } 
            
            catch (Exception ex) 
            {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Este check out ya se ha realizado anteriormente");
            }
        }
        
        
        
        
        else if(s.equals("ficha cliente"))
        {
            if(vistaRec.jComboBoxBúsquedas.getSelectedIndex()==0 || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==1
                    || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==2 || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==3
                    || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==4 || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==5
                    || vistaRec.jComboBoxBúsquedas.getSelectedIndex()==6)
            {
                 
                filas = vistaRec.jTableConsultas.getSelectedRow();
                 
                 if(filas != -1)
                 {
                      DefaultTableModel dtm = (DefaultTableModel) vistaRec.jTableConsultas.getModel();
                      ec.setDni(dtm.getValueAt(filas, 1).toString());
                      
                    try 
                    {
                        List<EntidadCliente> list=ControladorRecepcionista.getDniCliente(ec);
                        
				for (i = 0; i < list.size(); i++)
				{
					ficha.jTextFieldDni.setText(list.get(i).getDni());
					ficha.jTextFieldNombre.setText(list.get(i).getNombre());
					ficha.jTextFieldApellidos.setText(list.get(i).getApellidos());
					ficha.jTextFieldDireccion.setText(list.get(i).getDireccion());
					ficha.jTextFieldTelefono.setText(Integer.toString(list.get(i).getTelefono()));
                                        ficha.jTextFieldEmail.setText(list.get(i).getEmail());
                                        ficha.jTextFieldFechaNacimiento.setText(list.get(i).getFechaNacimiento());
                                        ficha.jTextFieldCp.setText(Integer.toString(list.get(i).getCp()));
                                        ficha.jTextFieldPais.setText(list.get(i).getPais());
                                        ficha.jTextFieldProvincia.setText(list.get(i).getProvincia());
                                        ficha.jTextFieldLocalidad.setText(list.get(i).getLocalidad());
                                        ficha.jTextFieldPais.setText(list.get(i).getProvincia());
                                        
                                        er.setDniCliente(list.get(i).getDni());
				}
                                
                                
                                String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
                                List<EntidadReserva> listReserva=ControladorRecepcionista.getDniClienteReserva(er);
                                String[][] datos=new String[listReserva.size()][7];
				
                                for (i = 0; i < listReserva.size(); i++) 
				{
					datos[i][0]=Integer.toString(listReserva.get(i).getIdReserva());
					datos[i][1]=Integer.toString(listReserva.get(i).getNumHab());
					datos[i][2]=listReserva.get(i).getFechaEntrada();
					datos[i][3]=listReserva.get(i).getFechaSalida();
					datos[i][4]=listReserva.get(i).getDniCliente();
					datos[i][5]=Integer.toString(listReserva.get(i).getNumPersonas());
                                        datos[i][6]=listReserva.get(i).getObservaciones();
				}
					
				ficha.jTableFichaCliente.setModel(new DefaultTableModel(datos, cabecera));
                                
                                ficha.setVisible(true);
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay reservas para este cliente");
                                }
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            
                else
                {
                    ficha.setVisible(true);
                }
            }
            
            else
            {
                ficha.setVisible(true);
            }
        }
        
        
        else if(s.equals("ficha dni"))
        {
            ec.setDni(ficha.jTextFieldDni.getText());
            
                    try 
                    {
                        List<EntidadCliente> list=ControladorRecepcionista.getDniCliente(ec);
                        
				for (i = 0; i < list.size(); i++)
				{
					ficha.jTextFieldDni.setText(list.get(i).getDni());
					ficha.jTextFieldNombre.setText(list.get(i).getNombre());
					ficha.jTextFieldApellidos.setText(list.get(i).getApellidos());
					ficha.jTextFieldDireccion.setText(list.get(i).getDireccion());
					ficha.jTextFieldTelefono.setText(Integer.toString(list.get(i).getTelefono()));
                                        ficha.jTextFieldEmail.setText(list.get(i).getEmail());
                                        ficha.jTextFieldFechaNacimiento.setText(list.get(i).getFechaNacimiento());
                                        ficha.jTextFieldCp.setText(Integer.toString(list.get(i).getCp()));
                                        ficha.jTextFieldPais.setText(list.get(i).getPais());
                                        ficha.jTextFieldProvincia.setText(list.get(i).getProvincia());
                                        ficha.jTextFieldLocalidad.setText(list.get(i).getLocalidad());
                                        ficha.jTextFieldPais.setText(list.get(i).getProvincia());
                                        
                                        er.setDniCliente(list.get(i).getDni());
				}
                                
                                if(list.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(null, "No se encuentra este cliente");
                                }
                                
                                else
                                {
                                
                                    er.setDniCliente(ficha.jTextFieldDni.getText());

                                    String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
                                    List<EntidadReserva> listReserva=ControladorRecepcionista.getDniClienteReserva(er);
                                    String[][] datos=new String[listReserva.size()][7];

                                    for (i = 0; i < listReserva.size(); i++) 
                                    {
                                            datos[i][0]=Integer.toString(listReserva.get(i).getIdReserva());
                                            datos[i][1]=Integer.toString(listReserva.get(i).getNumHab());
                                            datos[i][2]=listReserva.get(i).getFechaEntrada();
                                            datos[i][3]=listReserva.get(i).getFechaSalida();
                                            datos[i][4]=listReserva.get(i).getDniCliente();
                                            datos[i][5]=Integer.toString(listReserva.get(i).getNumPersonas());
                                            datos[i][6]=listReserva.get(i).getObservaciones();
                                    }

                                    ficha.jTableFichaCliente.setModel(new DefaultTableModel(datos, cabecera));

                                    if(datos.length==0)
                                    {
                                        JOptionPane.showMessageDialog(null, "No hay reservas para este cliente");
                                    }
                                }
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        
        else if(s.equals("cobrar reserva check in"))
        {
            cobrar.setVisible(true);
            cobrar.jLabelDniCliente.setText(ech.getDnicliente());
            cobrar.jLabelIdReserva.setText(String.valueOf(ech.getIdReserva()));
            
            DefaultTableModel dtm3 = (DefaultTableModel) vistaCheckIn.jTableDetallesReserva.getModel();
            cobrar.jLabelPrecioReserva.setText(dtm3.getValueAt(0, 7).toString());
            cobrar.jLabelFecha.setText(ech.getFechaEntrada());
            cobrar.jLabelDesglosePensiones.setText(ech.getCondicionAlojamiento());
            cobrar.jLabelTotal.setText(String.valueOf(ech.getPrecioTotal()));
            vistaCheckIn.dispose();
        }
        
        
        else if(s.equals("cobrar reserva efectivo"))
        {
            comprobarEfectivo = 0;
            
            ech.setIdReserva(er.getIdReserva());
            
            List<EntidadPago> list = null;
            
            ech.setIdReserva(Integer.parseInt(cobrar.jLabelIdReserva.getText()));
            epa.setIdReserva(ech.getIdReserva());
            
            try {
                list = ControladorRecepcionista.getPagoRealizado(epa);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!list.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Esta reserva ya ha sido cobrada");
                cobrar.dispose();
            }
            
            else
            {
                
                List<EntidadCheckIn> list1;

                try 
                {
                    list1=ControladorRecepcionista.getCheckIn(ech);


                    for (int i = 0; i<list1.size(); i++)
                    {
                        ech.setPrecioTotal(list1.get(i).getPrecioTotal());
                    }


                } catch (SQLException ex) {
                    Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                }

                efectivo = JOptionPane.showInputDialog(null, "Introduzca el efectivo que le ha entregado el cliente");

                if(efectivo.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Introduzca el efectivo que le ha entregado el cliente");
                }

                else
                {
                    comprobarEfectivo = Long.parseLong(efectivo);
                    comprobarEfectivo = comprobarEfectivo-ech.getPrecioTotal();

                    ech.setDnicliente(cobrar.jLabelDniCliente.getText());
                    ech.setIdReserva(Integer.parseInt(cobrar.jLabelIdReserva.getText()));
                    ech.setPrecioTotal(Long.parseLong(cobrar.jLabelPrecioReserva.getText()));
                    ech.setFechaEntrada(cobrar.jLabelFecha.getText());
                    ech.setMetodoPago("Efectivo");

                    JOptionPane.showMessageDialog(null, "Devuelva: "+comprobarEfectivo+" €");

                    try {
                        ControladorRecepcionista.insertarCobro(ech);
                        cobrar.dispose();

                    } catch (Exception ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        
        else if(s.equals("cobrar reserva tarjeta"))
        {
            List<EntidadPago> list = null;
            
            ech.setIdReserva(Integer.parseInt(cobrar.jLabelIdReserva.getText()));
            epa.setIdReserva(ech.getIdReserva());
            
            try {
                list = ControladorRecepcionista.getPagoRealizado(epa);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!list.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Esta reserva ya ha sido cobrada");
                cobrar.dispose();
            }
            
            else
            {
                
                tarjeta = JOptionPane.showInputDialog(null, "Introduzca el número de la tarjeta");
                
                while(tarjeta.equals(""))
                {
                    tarjeta = JOptionPane.showInputDialog(null, "Introduzca el número de la tarjeta");
                }

                    char array[]=tarjeta.toCharArray();

                    for(int i=0; i<array.length; i++ )
                    {
                        array[i]=(char)(array[i]+(char)5);
                    }

                    String encriptado = String.valueOf(array);

                    ech.setDnicliente(cobrar.jLabelDniCliente.getText());
                    ech.setIdReserva(Integer.parseInt(cobrar.jLabelIdReserva.getText()));
                    ech.setPrecioTotal(Long.parseLong(cobrar.jLabelPrecioReserva.getText()));
                    ech.setFechaEntrada(cobrar.jLabelFecha.getText());
                    ech.setMetodoPago(encriptado);

                    try {
                        ControladorRecepcionista.insertarCobro(ech);
                        cobrar.dispose();
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
        }
        
        
        else if(s.equals("buscar habitacion"))
        {
            nPersonas = Integer.parseInt(vistaRes.jComboBoxNPersonas.getSelectedItem().toString());
            
            eh.setCapacidad(nPersonas);
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "Precio", "Capacidad"};
				List<EntidadHabitación> list=ControladorRecepcionista.getCapacidad(eh);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getNHabitacion());
					datos[i][1]=Integer.toString(list.get(i).getNPlanta());
					datos[i][2]=list.get(i).getVistas();
					datos[i][3]=list.get(i).getTipo();
					datos[i][4]=list.get(i).getEstado();
					datos[i][5]=Integer.toString(list.get(i).getPrecio());
                                        datos[i][6]=Integer.toString(list.get(i).getCapacidad());                     
				}
					
				vistaRes.jTableHabitaciones.setModel(new DefaultTableModel(datos, cabecera));
                                
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
        
        
        else if(s.equals("reservar"))
        {
            encontrado = true;
            
            filas = vistaRes.jTableHabitaciones.getSelectedRow();
            
            if(vistaRes.jTextFielDniCliente.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Introduzca el dni del cliente");
                encontrado = false;
            }
            
            if(!val.NifValido(vistaRes.jTextFielDniCliente.getText().toString()))
            {
                JOptionPane.showMessageDialog(null, "Introduzca un dni correcto");
                encontrado = false;
            }
            
            if(filas == -1)
            {
                JOptionPane.showMessageDialog(null, "Asigne una habitación a la reserva del cliente");
                encontrado = false;
            }
            
            if(encontrado)
            {
                diaEntrada1=vistaRes.jDateChooserEntrada.getCalendar().get(Calendar.DATE);
                diaEntrada=String.valueOf(diaEntrada1);
                int dia=diaEntrada.length();

                if(dia==1)
                {
                        diaEntrada="0"+diaEntrada;
                }

                er.setDiaEntrada(diaEntrada);

                mesEntrada1=vistaRes.jDateChooserEntrada.getCalendar().get(Calendar.MONTH)+1;
                mesEntrada=String.valueOf(mesEntrada1);
                int mes=mesEntrada.length();
                
                if(mes==1)
                {
                        mesEntrada="0"+mesEntrada;
                }
                er.setMesEntrada(mesEntrada);

                anyoEntrada1=vistaRes.jDateChooserEntrada.getCalendar().get(Calendar.YEAR);
                anyoEntrada=String.valueOf(anyoEntrada1);
                er.setAnyoEntrada(anyoEntrada);

                diaSalida1=vistaRes.jDateChooserSalida.getCalendar().get(Calendar.DATE);
                diaSalida=String.valueOf(diaSalida1);
                int dia1=diaSalida.length();
                if(dia1==1)
                {
                        diaSalida="0"+diaSalida;
                }
                er.setDiaSalida(diaSalida);

                mesSalida1=vistaRes.jDateChooserSalida.getCalendar().get(Calendar.MONTH)+1;
                mesSalida=String.valueOf(mesSalida1);
                int mes1=mesSalida.length();

                if(mes1==1)
                {
                        mesSalida="0"+mesSalida;
                }
                er.setMesSalida(mesSalida);

                anyoSalida1=vistaRes.jDateChooserSalida.getCalendar().get(Calendar.YEAR);
                anyoSalida=String.valueOf(anyoSalida1);
                er.setAnyoSalida(anyoSalida);

                fechaEntrada2=er.getAnyoEntrada()+"-"+er.getMesEntrada()+"-"+er.getDiaEntrada();
                er.setFechaEntrada(fechaEntrada2);

                fechaSalida2=er.getAnyoSalida()+"-"+er.getMesSalida()+"-"+er.getDiaSalida();
                er.setFechaSalida(fechaSalida2);
                
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                
                cal1.set(anyoEntrada1, mesEntrada1-1, diaEntrada1);
                cal1.set(anyoSalida1, mesSalida1-1, diaSalida1);
                
                final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
                Calendar calendarSalida = new GregorianCalendar(anyoSalida1, mesSalida1-1, diaSalida1); 
                java.sql.Date fechaSalida = new java.sql.Date(calendarSalida.getTimeInMillis());
 
                Calendar calendarEntrada = new GregorianCalendar(anyoEntrada1, mesEntrada1-1, diaEntrada1); 
                java.sql.Date fechaEntrada = new java.sql.Date(calendarEntrada.getTimeInMillis());

                totalHoras = (fechaSalida.getTime() - fechaEntrada.getTime())/MILLSECS_PER_DAY;
                
                DefaultTableModel dtm = (DefaultTableModel) vistaRes.jTableHabitaciones.getModel();
                
                String precioHab = ((String)dtm.getValueAt(filas, 5));
                
                long precioTotal = 0;
                
                precioTotal = totalHoras*Integer.parseInt(precioHab);
                
		er.setPrecioHabitacion(precioTotal);
                
		//recorremos las fechas en las que esa habitación esta reservada para compararlas con la fecha nueva de reserva
		//para ver si coinciden
			
                String numHabi = ((String)dtm.getValueAt(filas, 0));
		er.setNumHab(Integer.parseInt(numHabi));
                er.setObservaciones(vistaRes.jTextAreaObservaciones.getText());
							
		try 
		{
			List<EntidadReserva> list5=ControladorRecepcionista.getFecha(er);
									
			String[][] datos1=new String[list5.size()][8];
			i=0;
			encontrado=false;

                        boolean alquilada=false;
									
			for (i = 0; i < list5.size(); i++) 
			{
				datos1[i][0]=Integer.toString(list5.get(i).getIdReserva());
				datos1[i][1]=Integer.toString(list5.get(i).getNumHab());
                                datos1[i][2]=list5.get(i).getFechaEntrada();
				datos1[i][3]=list5.get(i).getFechaSalida();
                                datos1[i][4]=list5.get(i).getDniCliente();
				datos1[i][5]=Integer.toString(list5.get(i).getNumPersonas());
                                datos1[i][6]=list5.get(i).getObservaciones();
                                datos1[i][7]=Long.toString(list5.get(i).getPrecioHabitacion());
                                
				//obtenemos las fechas de entrada de las reservas de esa habitación y la fecha que el recepcionista
                                // ha elegido actualmente
										
				diaEntrada=er.getDiaEntrada();									
				fechaEntradaDiaAnterior=list5.get(i).getFechaEntrada().substring(8, 10);										
										
				mesEntrada=er.getMesEntrada();
				fechaEntradaMesAnterior=list5.get(i).getFechaEntrada().substring(5, 7);
										
				anyoEntrada=er.getAnyoEntrada();
				fechaEntradaAnyoAnterior=list5.get(i).getFechaEntrada().substring(0, 4);
										
										
				//comprobamos las fechas de salida
										
				diaSalida=er.getDiaSalida();
				fechaSalidaDiaAnterior=list5.get(i).getFechaSalida().substring(8, 10);
										
				mesSalida=er.getMesSalida();
				fechaSalidaMesAnterior=list5.get(i).getFechaSalida().substring(5, 7);
										
                                anyoSalida=er.getAnyoSalida();
				fechaSalidaAnyoAnterior=list5.get(i).getFechaSalida().substring(0, 4);
										
										
				//pasamos las fechas a int (ya que estan en formato String) para poder hacer las comparaciones
										
				diaEntradaInt=Integer.parseInt(fechaEntradaDiaAnterior);
				diaEntradaInt1=Integer.parseInt(diaEntrada);
										
				mesEntradaInt=Integer.parseInt(fechaEntradaMesAnterior);
				mesEntradaInt1=Integer.parseInt(mesEntrada);
										
				anyoEntradaInt=Integer.parseInt(fechaEntradaAnyoAnterior);
				anyoEntradaInt1=Integer.parseInt(anyoEntrada);
										
				diaSalidaInt=Integer.parseInt(fechaSalidaDiaAnterior);
				diaSalidaInt1=Integer.parseInt(diaSalida);
										
				mesSalidaInt=Integer.parseInt(fechaSalidaMesAnterior);
				mesSalidaInt1=Integer.parseInt(mesSalida);
										
				anyoSalidaInt=Integer.parseInt(fechaSalidaAnyoAnterior);
				anyoSalidaInt1=Integer.parseInt(anyoSalida);
										
				//si en esas fechas la habitación esta alquilada no podra realizarse la reserva
										
				if((diaEntradaInt>=diaEntradaInt1 && diaEntradaInt<=diaSalidaInt1) || (diaSalidaInt>=diaEntradaInt1 && diaSalidaInt<=diaSalidaInt1))
				{
					alquilada=true;
					encontrado=true;
				}
										
                                else
                                {
					alquilada=false;
					encontrado=false;
                                }
			}
									
			//obtenemos la fecha actual
									
			Calendar cal = new GregorianCalendar();
								
			diaActual=cal.get(Calendar.DAY_OF_MONTH);
			mesActual=cal.get(Calendar.MONTH);
			mesActual=mesActual+1;
			anyoActual=cal.get(Calendar.YEAR);


			//comprobamos que la fecha de salida no pueda ser menor que la de entrada
									
                        if(diaSalidaInt1<diaEntradaInt1 && mesSalidaInt1 == mesEntradaInt1)
			{
				JOptionPane.showMessageDialog(null, "El dia de salida no puede ser menor que el día de entrada");
				encontrado=true;
			}
									
			else if(mesSalidaInt1<mesEntradaInt1)
			{
				JOptionPane.showMessageDialog(null, "El mes de salida no puede ser menor que el mes de entrada");
				encontrado=true;
			}
									
			else if(anyoSalidaInt1<anyoEntradaInt1)
			{
				JOptionPane.showMessageDialog(null, "El año de salida no puede ser menor que el año de entrada");
				encontrado=true;
			}
									
			//comprobamos que la fecha actual no sea mayor que la fecha en la que se desea alquilar
									
			if(diaActual>diaEntrada1 && mesActual>=mesEntrada1 && anyoActual>=anyoEntrada1
				|| diaActual>=diaSalida1 && mesActual>=mesSalida1 && anyoActual>=anyoSalida1)
			{
				actual=true;
				encontrado=true;
                        }
									
			else
                        {
				actual=false;
			}
                        
                        er.setDniCliente(vistaRes.jTextFielDniCliente.getText());
                        er.setNumPersonas(Integer.parseInt(vistaRes.jComboBoxNPersonas.getSelectedItem().toString()));
									
									
			//informacion al recepcionista de porque no puede realizar la reserva de esa habitación
                        
			if(actual)
			{
				JOptionPane.showMessageDialog(null, "No puede elegir una fecha menor a la actual");
			}
                        
                        else if(alquilada)
                        {
				JOptionPane.showMessageDialog(null, "La habitación no está disponible para esas fechas");
			}
									
			//si todo esta correcto, realizamos la consulta para realizar la reserva correctamente
									
			if(!encontrado)
			{
                            er.setFechaEntrada(fechaEntrada2);
                            er.setDniCliente(vistaRes.jTextFielDniCliente.getText());
                            
                            List<EntidadReserva> listReserva = ControladorRecepcionista.getDniClienteReservaFechaEntrada(er);
                            
                            String[][] datos=new String[listReserva.size()][1];
				for (i = 0; i < listReserva.size(); i++) 
				{
					datos[i][0]=listReserva.get(i).getFechaEntrada();
				}
                            
                            
                            
                            
                            if(listReserva.isEmpty())
                            {
				ControladorRecepcionista.insertarReserva(er);
				JOptionPane.showMessageDialog(null, "Reserva realizada correctamente");
                            }
                            
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Este cliente ya tiene asignada una reserva para el día de hoy");
                            }
			}
		}
								
		catch (Exception e1) 
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: no ha podido reservar correctamente");
		}
            }
        }
        
        
        else if(s.equals("precios habitacion"))
        {
            try {
                vistaRec.jPanel2.setVisible(true);
                mostrarPreciosHabitacion();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(s.equals("precios pension"))
        {
            try 
            {
                vistaRec.jPanel2.setVisible(true);
                vistaRec.jTextFieldFiltrarBúsqueda.setVisible(true);
                vistaRec.jComboBoxBúsquedas.setVisible(true);
                rellenarComboPension();
                mostrarPreciosPension();
            } 
            
            catch (SQLException ex) 
            {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            catch (Exception ex) 
            {
                Logger.getLogger(ControladorRecepcionista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        else if(s.equals("filtrar busqueda"))
        {
            if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Nº habitación"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                eh.setNHabitacion(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getNHabitacion(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
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
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir un número para realizar esta búsqueda");
                }
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Nº planta"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                eh.setNPlanta(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getNPlanta(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
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
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe indicar un número para realizar esta búsqueda");
                }
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Vistas"))
            {
                eh.setVistas(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getVistas(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
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
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Tipo"))
            {
                eh.setTipo(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getTipo(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este tipo de habitación");
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
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Capacidad"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                eh.setCapacidad(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getCapacidad(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
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
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe indicar un número para realizar esta búsqueda");
                }
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Precio"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                eh.setPrecio(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"Nº habitación", "Nª planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
				List<EntidadHabitación> list=ControladorRecepcionista.getBuscarPrecio(eh);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este precio");
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
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe indicar un número para realizar esta búsqueda");
                }
            }
            
            
            
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("DNI cliente"))
            {
                ec.setDni(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getDniCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este DNI");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Nombre"))
            {
                ec.setNombre(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getNombreCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nombre");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Apellidos"))
            {
                ec.setApellidos(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getApellidosCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este apellido");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Fecha de nacimiento"))
            {
                ec.setFechaNacimiento(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getFechaNacimientoCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta fecha de nacimiento");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Localidad"))
            {
                ec.setLocalidad(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getLocalidadCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta localidad");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Provincia"))
            {
                ec.setProvincia(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getProvinciaCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta provincia");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("País"))
            {
                ec.setPais(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento"
                                ,"CP", "Pais", "Localidad", "Provincia"};
				List<EntidadCliente> list=ControladorRecepcionista.getPaisCliente(ec);
					
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
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este país");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Número habitación"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                    er.setNumHab(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
				List<EntidadReserva> list=ControladorRecepcionista.getNHabitacionReserva(er);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos[i][1]=Integer.toString(list.get(i).getNumHab());
					datos[i][2]=list.get(i).getFechaEntrada();
					datos[i][3]=list.get(i).getFechaSalida();
					datos[i][4]=list.get(i).getDniCliente();
					datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                        datos[i][6]=list.get(i).getObservaciones();
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este nº de habitación");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir un número para realizar esta búsqueda");
                }
                
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Fecha entrada"))
            {
                er.setFechaEntrada(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
				List<EntidadReserva> list=ControladorRecepcionista.getFechaEntradaReserva(er);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos[i][1]=Integer.toString(list.get(i).getNumHab());
					datos[i][2]=list.get(i).getFechaEntrada();
					datos[i][3]=list.get(i).getFechaSalida();
					datos[i][4]=list.get(i).getDniCliente();
					datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                        datos[i][6]=list.get(i).getObservaciones();
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta fecha de entrada");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Fecha salida"))
            {
                er.setFechaSalida(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
				List<EntidadReserva> list=ControladorRecepcionista.getFechaSalidaReserva(er);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos[i][1]=Integer.toString(list.get(i).getNumHab());
					datos[i][2]=list.get(i).getFechaEntrada();
					datos[i][3]=list.get(i).getFechaSalida();
					datos[i][4]=list.get(i).getDniCliente();
					datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                        datos[i][6]=list.get(i).getObservaciones();
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta fecha de salida");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Dni cliente"))
            {
                er.setDniCliente(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
				List<EntidadReserva> list=ControladorRecepcionista.getDniClienteReserva(er);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos[i][1]=Integer.toString(list.get(i).getNumHab());
					datos[i][2]=list.get(i).getFechaEntrada();
					datos[i][3]=list.get(i).getFechaSalida();
					datos[i][4]=list.get(i).getDniCliente();
					datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                        datos[i][6]=list.get(i).getObservaciones();
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este cliente");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Número personas"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                er.setNumPersonas(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
				List<EntidadReserva> list=ControladorRecepcionista.getNPersonasReserva(er);
					
				String[][] datos=new String[list.size()][7];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos[i][1]=Integer.toString(list.get(i).getNumHab());
					datos[i][2]=list.get(i).getFechaEntrada();
					datos[i][3]=list.get(i).getFechaSalida();
					datos[i][4]=list.get(i).getDniCliente();
					datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                        datos[i][6]=list.get(i).getObservaciones();
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este número de personas");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir un número para realizar esta búsqueda");
                }
            }
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Pensión"))
            {
                ep.setPension(vistaRec.jTextFieldFiltrarBúsqueda.getText());
				
			try 
			{
				String [] cabecera={"Pensión", "Precio"};
				List<EntidadPension> list=ControladorRecepcionista.getNombrePension(ep);
					
				String[][] datos=new String[list.size()][2];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=list.get(i).getPension();
					datos[i][1]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para esta pensión");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
            }
            
            
            else if(vistaRec.jComboBoxBúsquedas.getSelectedItem().equals("Precio pensión"))
            {
                if(val.esNumero(vistaRec.jTextFieldFiltrarBúsqueda.getText()))
                {
                ep.setPrecio(Integer.parseInt(vistaRec.jTextFieldFiltrarBúsqueda.getText()));
				
			try 
			{
				String [] cabecera={"Pensión", "Precio"};
				List<EntidadPension> list=ControladorRecepcionista.getPrecioPension(ep);
					
				String[][] datos=new String[list.size()][2];
				int i;
				for (i = 0; i < list.size(); i++) 
				{
					datos[i][0]=list.get(i).getPension();
					datos[i][1]=Integer.toString(list.get(i).getPrecio());
				}
					
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                                if(datos.length==0)
                                {
                                    JOptionPane.showMessageDialog(null, "No hay resultados para este precio");
                                }
                                
			}
				
			catch (Exception e1) 
			{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
			}
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null, "Debe introducir un número para realizar esta búsqueda");
                }
            }
        }
    }
    }
    
    
    private void consultaNombreHotel() throws SQLException, Exception 
    {
        List<EntidadHotel> list = ModeloHotel.getHotel();
        
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
              vistaRec.jLabelBienvenidos2.setText("Debe registrar el hotel");
	}
        
        if(encontrado)
        {
            try 
            {
                    List<EntidadHotel> list1=ModeloHotel.getHotel();
                    
                    int j;
                    for (j = 0; j < list1.size(); j++) 
                    {
                            vistaRec.jLabelBienvenidos2.setText("Bienvenidos a "+list1.get(j).getNombreHotel());
                            System.out.println(list1.get(j).getNombreHotel());
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
    
    
    public void mostrarCapacidad() throws SQLException, Exception
    {
        vistaRes.jComboBoxNPersonas.removeAllItems();
        j = 0;
        
        List<EntidadCapacidad> listCapacidad = ControladorRecepcionista.getCapacidad();
        
              for (j = 0; j < listCapacidad.size(); j++) 
              {
                    vistaRes.jComboBoxNPersonas.addItem(listCapacidad.get(j).getCapacidad());
              }
    }
    
    
    private void historicoDeReservas() 
    {
        vistaRec.jButtonModificar.setVisible(false);
        
        rellenarComboReservas();
        
        vistaRec.jTextFieldFiltrarBúsqueda.setVisible(true);
        vistaRec.jComboBoxBúsquedas.setVisible(true);
        vistaRec.jPanel2.setVisible(true);
                       
                 try 
                 {

                       String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
                       List<EntidadReserva> list=ControladorRecepcionista.getReservas();

                       String[][] datos=new String[list.size()][7];
                       int i;
                       for (i = 0; i < list.size(); i++) 
                       {
                               datos[i][0]=Integer.toString(list.get(i).getIdReserva());
                               datos[i][1]=Integer.toString(list.get(i).getNumHab());
                               datos[i][2]=list.get(i).getFechaEntrada();
                               datos[i][3]=list.get(i).getFechaSalida();
                               datos[i][4]=list.get(i).getDniCliente();
                               datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                               datos[i][6]=list.get(i).getObservaciones();
                       }

                       vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
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

    private void mostrarPreciosHabitacion() throws SQLException, Exception 
    {
        vistaRec.jButtonModificar.setVisible(false);
        
            String [] cabeceraCapacidad = {"Nº habitación", "Nº planta", "Tipo habitación", "Precio"};
            j = 0;

            List<EntidadHabitación> listPrecioHabitacion = ControladorRecepcionista.getPrecio();
            String[][] datosCapacidad=new String[listPrecioHabitacion.size()][4];

                  for (j = 0; j < listPrecioHabitacion.size(); j++) 
                  {
                        datosCapacidad[j][0] = String.valueOf(listPrecioHabitacion.get(j).getNHabitacion());
                        datosCapacidad[j][1] = String.valueOf(listPrecioHabitacion.get(j).getNPlanta());
                        datosCapacidad[j][2] = String.valueOf(listPrecioHabitacion.get(j).getTipo());
                        datosCapacidad[j][3] = String.valueOf(listPrecioHabitacion.get(j).getPrecio());
                  }

            vistaRec.jTableConsultas.setModel(new DefaultTableModel(datosCapacidad, cabeceraCapacidad));
    }
    
    
    private void mostrarPreciosPension() throws SQLException, Exception 
    {
        vistaRec.jButtonModificar.setVisible(false);
        
            String [] cabeceraCapacidad = {"Pensión", "Precio"};
            j = 0;

            List<EntidadPension> listPrecioPension = ControladorRecepcionista.getPension();
            String[][] datosCapacidad=new String[listPrecioPension.size()][2];

                  for (j = 0; j < listPrecioPension.size(); j++) 
                  {
                        datosCapacidad[j][0] = listPrecioPension.get(j).getPension();
                        datosCapacidad[j][1] = String.valueOf(listPrecioPension.get(j).getPrecio());
                  }

            vistaRec.jTableConsultas.setModel(new DefaultTableModel(datosCapacidad, cabeceraCapacidad));
    }
    
    
    public void mostrarClientes()
    {
        vistaRec.jButtonModificar.setVisible(true);
        
        try
	{                
		String [] cabecera={"ID cliente", "DNI", "Nombre", "Apellidos", "Direccion", "Telefono", "Email", "Fecha nacimiento", "CP", "Pais", "Localidad", "Provincia"};
		List<EntidadCliente> list=ControladorRecepcionista.getClientes();
					
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
					
		vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
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
    
    
    public void consultaReservaCliente()
    {        
        vistaRec.jButtonModificar.setVisible(false);
        
        String dniCliente=JOptionPane.showInputDialog(null, "Introduzca el dni del cliente");
          
        
        vistaRec.jTextFieldFiltrarBúsqueda.setVisible(false);
        vistaRec.jComboBoxBúsquedas.setVisible(false);
                 
        if(dniCliente.equals(""))
        {
		JOptionPane.showMessageDialog(null, "Indique el dni del cliente del cual quiere ver los alquileres");
	}
			
	else
	{
		List<EntidadReserva> list = null;
                
                er.setDniCliente(dniCliente);
                
		i=0;             
			try 
			{
				String [] cabecera={"ID reserva", "Nª habitación", "Fecha entrada", "Fecha salida", "DNI cliente"};
				
                                list = ControladorRecepcionista.getCliente(er);
				String[][] datos1=new String[list.size()][5];
				i = 0;
				for (i = 0; i < list.size(); i++) 
				{
					datos1[i][0]=Integer.toString(list.get(i).getIdReserva());
					datos1[i][1]=Integer.toString(list.get(i).getNumHab());
					datos1[i][2]=list.get(i).getFechaEntrada();
                                        datos1[i][3]=list.get(i).getFechaSalida();
					datos1[i][4]=list.get(i).getDniCliente();
				}
						
				vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos1, cabecera));
                                
                                vistaRec.jPanel2.setVisible(true);
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
    
    
    public void mostrarHabitaciones()
    {
        vistaRec.jButtonModificar.setVisible(false);
        
        try 
	{
                
		String [] cabecera={"Nº habitación", "Nº planta", "Vistas", "Tipo", "Estado", "DNI limpiadora", "Capacidad", "Descripción", "Precio"};
		List<EntidadHabitación> list= ControladorRecepcionista.getHabitaciones();
					
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
					
		vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                
                rellenarComboHabitaciones();
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
    
    public void rellenarComboHabitaciones()
    {
        j = 0;
        vistaRec.jComboBoxBúsquedas.removeAllItems();
        
        String datos[]={"Nº habitación", "Nº planta", "Vistas", "Tipo", "Capacidad", "Precio"};
        
              for (j = 0; j < datos.length; j++) 
              {                  
                  vistaRec.jComboBoxBúsquedas.addItem(datos[j]);
              }
    }
    
    
    public void rellenarComboReservas()
    {
        j = 0;
        vistaRec.jComboBoxBúsquedas.removeAllItems();
        
        String datos[]={"Número habitación", "Fecha entrada", "Fecha salida", "Dni cliente", "Número personas"};
        
              for (j = 0; j < datos.length; j++) 
              {                  
                  vistaRec.jComboBoxBúsquedas.addItem(datos[j]);
              }
    }
    
    public void rellenarComboPension()
    {
        j = 0;
        vistaRec.jComboBoxBúsquedas.removeAllItems();
        
        String datos[]={"Pensión", "Precio pensión"};
        
              for (j = 0; j < datos.length; j++) 
              {                  
                  vistaRec.jComboBoxBúsquedas.addItem(datos[j]);
              }
    }
    
    
    public void rellenarComboClientes()
    {
        j = 0;
        vistaRec.jComboBoxBúsquedas.removeAllItems();
        
        String datos[]={"DNI cliente", "Nombre", "Apellidos", "Fecha de nacimiento", "Localidad", "Provincia", "País"};
        
              for (j = 0; j < datos.length; j++) 
              {                  
                  vistaRec.jComboBoxBúsquedas.addItem(datos[j]);
              }
    }

    private void cancelarReserva() throws Exception 
    {
        camposCorrectos = true;
        
        dni = JOptionPane.showInputDialog(null, "Introduzca el DNI del cliente que quiere cancelar la reserva");
        er.setDniCliente(dni);
        
        while(er.getDniCliente().equals(""))
        {
            dni = JOptionPane.showInputDialog(null, "Tiene que introducir el DNI del cliente que quiere cancelar la reserva");
            camposCorrectos = false;
            er.setDniCliente(dni);
        }
           
        fechaEntrada2= JOptionPane.showInputDialog(null, "Introduzca la fecha de la reserva (YYYY-mm-DD");
        er.setFechaEntrada(fechaEntrada2);
        camposCorrectos = true;
        
        while(fechaEntrada2.equals(""))
        {
            fechaEntrada2= JOptionPane.showInputDialog(null, "Introduzca la fecha de la reserva (YYYY-mm-DD");
            camposCorrectos = false;
            er.setFechaEntrada(fechaEntrada2);
        }
        
        if(camposCorrectos)
        {
            List <EntidadReserva> list = ControladorRecepcionista.getFechaEntradaDniCliente(er);

            if(list.size()==0)
            {
                JOptionPane.showMessageDialog(null, "No existe ninguna reserva con esos datos");
            }

            else
            {

                resp = JOptionPane.showConfirmDialog(null, "'¿Esta seguro que desea cancelar esa reserva?",
                "Cancelar", JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.YES_OPTION) 
                {
                       eliminarReserva(er);
                }
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "No ha introducido los datos correctamente");
        }
    }
    
    public void rellenarComboCapacidad() throws SQLException, Exception
    {
        j = 0;
        
        List<EntidadCapacidad> listCapacidad = ControladorRecepcionista.getCapacidad();
        
              for (j = 0; j < listCapacidad.size(); j++) 
              {                  
                  comboBox.addItem(listCapacidad.get(j).getCapacidad());
              }
              
              sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
    }
    
    
    public void mostrarPensiones() throws SQLException, Exception
    {
         DefaultTableModel dtm2 = (DefaultTableModel) vistaCheckIn.jTablePensiones.getModel();
         j = 0;

         List<EntidadPension> listPrecioPension = ControladorRecepcionista.getPension();
         dtm2.setNumRows(listPrecioPension.size());

                  for (j = 0; j < listPrecioPension.size(); j++) 
                  {
                        dtm2.setValueAt(listPrecioPension.get(j).getPension(), j, 2);
                        dtm2.setValueAt(listPrecioPension.get(j).getPrecio(), j, 3);
                  }
    }

    private void mostrarClientesReservas() throws SQLException, Exception 
    {
                    vistaCheckIn.jButtonRegistrar.setEnabled(false);
                    vistaCheckIn.jTextFieldDni.setEnabled(false);
                 
                    List<EntidadCliente> list=ControladorRecepcionista.getDniCliente(ec);
                    
			int i;
			for (i = 0; i < list.size(); i++) 
			{
                                vistaCheckIn.jTextFieldNombre.setEnabled(false);
                                vistaCheckIn.jTextFieldApellidos.setEnabled(false);
                                vistaCheckIn.jTextFieldDireccion.setEnabled(false);
                                vistaCheckIn.jTextFieldCp.setEnabled(false);
                                vistaCheckIn.jTextFieldTelefono.setEnabled(false);
                                vistaCheckIn.jTextFieldEmail.setEnabled(false);
                                vistaCheckIn.jTextFieldFechaNacimiento.setEnabled(false);
                                vistaCheckIn.jTextFieldLocalidad.setEnabled(false);
                                vistaCheckIn.jTextFieldProvincia.setEnabled(false);
                                vistaCheckIn.jTextFieldPais.setEnabled(false);

                                vistaCheckIn.jButtonRegistrar.setEnabled(false);
                                vistaCheckIn.jButtonRealizarCheckIn.setEnabled(true);
                                vistaCheckIn.jButtonCobrarReserva.setEnabled(false);
                                
				vistaCheckIn.jTextFieldNombre.setText(list.get(i).getNombre().toString());
				vistaCheckIn.jTextFieldApellidos.setText(list.get(i).getApellidos().toString());
				vistaCheckIn.jTextFieldDireccion.setText(list.get(i).getNombre().toString());
				vistaCheckIn.jTextFieldCp.setText(String.valueOf(list.get(i).getCp()));
				vistaCheckIn.jTextFieldTelefono.setText(String.valueOf(list.get(i).getTelefono()));
				vistaCheckIn.jTextFieldEmail.setText(list.get(i).getEmail().toString());
                                vistaCheckIn.jTextFieldFechaNacimiento.setText(String.valueOf(list.get(i).getFechaNacimiento()));                   
                                vistaCheckIn.jTextFieldLocalidad.setText(String.valueOf(list.get(i).getLocalidad()));
                                vistaCheckIn.jTextFieldProvincia.setText(String.valueOf(list.get(i).getProvincia()));
                                vistaCheckIn.jTextFieldPais.setText(String.valueOf(list.get(i).getPais()));
                        }
    }
    
    
    
    public void verPagos() throws SQLException, Exception
    {
        String [] cabecera={"DNI cliente", "ID reserva", "Pago", "Método pago"};
        
        Calendar cal = new GregorianCalendar();
        
        String diaActual1, mesActual1;

        diaActual=cal.get(Calendar.DAY_OF_MONTH);

        if(Integer.toString(diaActual).length()==1)
        {
               diaActual1 = String.valueOf(diaActual);
               diaActual1="0"+diaActual1;
        }

        else
        {
               diaActual1 = String.valueOf(diaActual);
        }

        mesActual=cal.get(Calendar.MONTH);
        mesActual=mesActual+1;

        if(Integer.toString(mesActual).length()==1)
        {
               mesActual1 = String.valueOf(mesActual);
               mesActual1="0"+mesActual1;
        }

        else
        {
               mesActual1 = String.valueOf(mesActual);
        }

        anyoActual=cal.get(Calendar.YEAR);

        String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;
        
        epa.setFechaPago(fechaActual);
        
        List<EntidadPago> listPago = ControladorRecepcionista.mostrarPago(epa);
					
        String[][] datos=new String[listPago.size()][5];
	int i;
        long calcularTotal = 0;
        
	for (i = 0; i < listPago.size(); i++) 
	{
		datos[i][0]=listPago.get(i).getDniCliente();
		datos[i][1]=Integer.toString(listPago.get(i).getIdReserva());
		datos[i][2]=Long.toString(listPago.get(i).getPrecioTotal());
                
                //Desencriptar
        
                char arrayD[]=listPago.get(i).getMetodoPago().toCharArray();
                
                for(j=0; j<arrayD.length;j++)
                {
                    arrayD[j]=(char)(arrayD[j]-(char)5);
                }

                String desencriptado = String.valueOf(arrayD);
                
                datos[i][3]=String.valueOf(desencriptado);
                
                calcularTotal = calcularTotal+listPago.get(i).getPrecioTotal();
	}
					
	vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
        
        JOptionPane.showMessageDialog(null, "El total del día es: "+calcularTotal+" €");
    }
    
    
    public void pagosPorFechas() throws SQLException, Exception
    {
        String [] cabecera={"DNI cliente", "ID reserva", "Pago"};
        

        String fecha = JOptionPane.showInputDialog(null, "Introduzca la fecha de la que desea ver el total de la caja (YYYY-mm-DD)");
        
        if(fecha.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Introduzca una fecha");
        }
        
        else
        {
        
            epa.setFechaPago(fecha);

            List<EntidadPago> listPago = ControladorRecepcionista.mostrarPagoPorFecha(epa);

            String[][] datos=new String[listPago.size()][5];
            int i;
            long calcularTotal = 0;

            for (i = 0; i < listPago.size(); i++) 
            {
                    datos[i][0]=listPago.get(i).getDniCliente();
                    datos[i][1]=Integer.toString(listPago.get(i).getIdReserva());
                    datos[i][2]=Long.toString(listPago.get(i).getPrecioTotal());


                    calcularTotal = calcularTotal+listPago.get(i).getPrecioTotal();
            }

            vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));

            JOptionPane.showMessageDialog(null, "El total del día " +fecha+ " es: "+calcularTotal+" €");
        }
    }
    
    
    public void consultarCheckIn() throws SQLException, Exception
    {
        vistaRec.jPanel2.setVisible(true);
        String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Condición alojamiento", "DNI cliente", "Nº personas", "Precio total"};
        
            List<EntidadCheckIn> listCheckIn = ControladorRecepcionista.mostrarCheckIn();

            String[][] datos=new String[listCheckIn.size()][7];
            int i;

            for (i = 0; i < listCheckIn.size(); i++) 
            {
                    datos[i][0]=Integer.toString(listCheckIn.get(i).getIdReserva());
                    datos[i][1]=Integer.toString(listCheckIn.get(i).getNumHab());
                    datos[i][2]=listCheckIn.get(i).getFechaEntrada();
                    datos[i][3]=listCheckIn.get(i).getCondicionAlojamiento();
                    datos[i][4]=listCheckIn.get(i).getDnicliente();
                    datos[i][5]=Integer.toString(listCheckIn.get(i).getNumPersonas());
                    datos[i][6]=Long.toString(listCheckIn.get(i).getPrecioTotal());
            }

            vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
    }
    
    
    public void consultarCheckOut() throws SQLException, Exception
    {
        vistaRec.jPanel2.setVisible(true);
        String [] cabecera={"ID reserva", "Nº habitación", "Fecha salida", "Precio total", "DNI cliente"};
        
            List<EntidadCheckOut> listCheckOut = ControladorRecepcionista.mostrarCheckOut();

            String[][] datos=new String[listCheckOut.size()][5];
            int i;

            for (i = 0; i < listCheckOut.size(); i++) 
            {
                    datos[i][0]=Integer.toString(listCheckOut.get(i).getIdReserva());
                    datos[i][1]=Integer.toString(listCheckOut.get(i).getNumHab());
                    datos[i][2]=listCheckOut.get(i).getFechaSalida();
                    datos[i][3]=Long.toString(listCheckOut.get(i).getPrecioTotal());
                    datos[i][4]=listCheckOut.get(i).getDniCliente();
            }

            vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
    }
    
    
    
    public void entradasHoy()
    {
         Calendar cal = new GregorianCalendar();
        
                String diaActual1, mesActual1;

                diaActual=cal.get(Calendar.DAY_OF_MONTH);

                if(Integer.toString(diaActual).length()==1)
                {
                      diaActual1 = String.valueOf(diaActual);
                      diaActual1="0"+diaActual1;
                }

               else
               {
                      diaActual1 = String.valueOf(diaActual);
               }

                mesActual=cal.get(Calendar.MONTH);
                mesActual=mesActual+1;

        if(Integer.toString(mesActual).length()==1)
        {
               mesActual1 = String.valueOf(mesActual);
               mesActual1="0"+mesActual1;
        }

        else
        {
               mesActual1 = String.valueOf(mesActual);
        }

        anyoActual=cal.get(Calendar.YEAR);

        String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;
        
        er.setFechaEntrada(fechaActual);
        
        try 
	{
		String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
		List<EntidadReserva> list=ControladorRecepcionista.getFechaEntradaReserva(er);
					
		String[][] datos=new String[list.size()][7];
		for (i = 0; i < list.size(); i++) 
		{
			datos[i][0]=Integer.toString(list.get(i).getIdReserva());
			datos[i][1]=Integer.toString(list.get(i).getNumHab());
			datos[i][2]=list.get(i).getFechaEntrada();
			datos[i][3]=list.get(i).getFechaSalida();
			datos[i][4]=list.get(i).getDniCliente();
			datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                        datos[i][6]=list.get(i).getObservaciones();
		}
					
		vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));
                                
                if(datos.length==0)
                {
                        JOptionPane.showMessageDialog(null, "No se esperan entradas en el día de hoy");
                }
                                
	}
				
	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
	}
    }
    
    public void salidasHoy()
    {
        
               Calendar cal = new GregorianCalendar();
        
               String diaActual1, mesActual1;

               diaActual=cal.get(Calendar.DAY_OF_MONTH);

               if(Integer.toString(diaActual).length()==1)
               {
                      diaActual1 = String.valueOf(diaActual);
                      diaActual1="0"+diaActual1;
               }

               else
               {
                      diaActual1 = String.valueOf(diaActual);
               }

                mesActual=cal.get(Calendar.MONTH);
                mesActual=mesActual+1;

                if(Integer.toString(mesActual).length()==1)
                {
                       mesActual1 = String.valueOf(mesActual);
                       mesActual1="0"+mesActual1;
                }

                else
                {
                       mesActual1 = String.valueOf(mesActual);
                }

                anyoActual=cal.get(Calendar.YEAR);

                String fechaActual = anyoActual+"-"+mesActual1+"-"+diaActual1;

                er.setFechaSalida(fechaActual);

                try 
                {
                        String [] cabecera={"ID reserva", "Nº habitación", "Fecha entrada", "Fecha salida", "DNI cliente", "Nº personas", "Observaciones"};
                        List<EntidadReserva> list=ControladorRecepcionista.getFechaSalidaReserva(er);

                        String[][] datos=new String[list.size()][7];
                        for (i = 0; i < list.size(); i++) 
                        {
                                datos[i][0]=Integer.toString(list.get(i).getIdReserva());
                                datos[i][1]=Integer.toString(list.get(i).getNumHab());
                                datos[i][2]=list.get(i).getFechaEntrada();
                                datos[i][3]=list.get(i).getFechaSalida();
                                datos[i][4]=list.get(i).getDniCliente();
                                datos[i][5]=Integer.toString(list.get(i).getNumPersonas());
                                datos[i][6]=list.get(i).getObservaciones();
                        }

                        vistaRec.jTableConsultas.setModel(new DefaultTableModel(datos, cabecera));

                        if(datos.length==0)
                        {
                                JOptionPane.showMessageDialog(null, "No hay salidas en el día de hoy");
                        }

                }

                catch (Exception e1) 
                {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error: no se ha podido mostrar correctamente");
                }
    }
    
    
    public void mostrarInformeCheckIn(){
             try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("CheckIn.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("CheckIn.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("CheckIn.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        inforecep.jPanelInformesRecepcionista.updateUI();
    }
    
    public void mostrarInformeCheckOut(){
        
          try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("CheckOut.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("CheckOut.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("CheckOut.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        inforecep.jPanelInformesRecepcionista.updateUI();
        
    }
    
    public void mostrarInformePension(){
        
          try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("Pension.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Pension.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("Pension.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        inforecep.jPanelInformesRecepcionista.updateUI();
        
    }
    
    public void  mostrarInformeCaja(){
        
          try {
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(new File("Caja.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,(Conexiones.getConexion()));
            
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Caja.pdf"));
            exporter.exportReport();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al generar PDF", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VistaAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        detener();
        destruir();
        dibujarGIU();
        File file = new File("Caja.pdf");
        final String url = file.toURI().toString();
        URL documentURL = null;
        try {
            documentURL = new URL(url);
        } catch (MalformedURLException e) {
        }

        if (documentURL != null) {
            controlador.openDocument(documentURL);
        }
        
        inforecep.jPanelInformesRecepcionista.updateUI();
        
    }
    
    public void mostrarInformeReserva(){
        
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
        
        inforecep.jPanelInformesRecepcionista.updateUI();
        
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
        inforecep.jPanelInformesRecepcionista.removeAll();
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

        inforecep.jPanelInformesRecepcionista.setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(factory.buildViewerPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        inforecep.jPanelInformesRecepcionista.add(scroll,BorderLayout.CENTER);
    }
    
    
}
