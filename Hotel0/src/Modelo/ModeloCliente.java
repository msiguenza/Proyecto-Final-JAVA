/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexiones.Conexiones;
import Entidad.EntidadCliente;
import Entidad.EntidadReserva;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia
 */
public class ModeloCliente 
{
    
    //INSERCION DE DATOS
	
    public static void insertarCliente(EntidadCliente cliente) throws Exception
    {
        if(cliente != null)
        {
            String sql=" insert into cliente (idcliente,dnicliente,nombrecliente,apellidoscliente,direccioncliente,"
                    + "telefonocliente,emailcliente,fechanacimiento,codpostalcliente,paiscliente,provinciacliente,localidadcliente)"
                    + " values("+null+"," +" '"+cliente.getDni()+"', '"+cliente.getNombre()+"', '"+cliente.getApellidos()+"', "
                    + "'"+cliente.getDireccion()+"', "+cliente.getTelefono()+", '"+cliente.getEmail()+"', '"+cliente.getFechaNacimiento()+"'"
                    + ", "+cliente.getCp()+", '"+cliente.getPais()+"', '"+cliente.getProvincia()+"', '"+cliente.getLocalidad()+"');";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            
            JOptionPane.showMessageDialog(null, "El cliente se ha registrado correctamente");
        }
    }
    
    //MOSTRAR DATOS
	
    public static List<EntidadReserva> getCliente(EntidadReserva reserva) throws SQLException, Exception 
    {
        List<EntidadReserva> list = null;
        
        if(reserva != null)
        {
            String sql="select * from reserva where dnicliente like '%"+ reserva.getDniCliente()+"%'";
            list =getResultSet1(sql, Conexiones.getConexion());
        }
            return list;
    }
    
    //MOSTRAR DATOS
	
    public static List<EntidadCliente> getClientes() throws SQLException, Exception 
    {
            String sql="select * from cliente";
            List<EntidadCliente> list=getResultSet(sql, Conexiones.getConexion());
            return list;
    }
    
        //filtrando dni

        public static List<EntidadCliente> getDniCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where dnicliente like '%"+ cliente.getDni() +"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        
        public static List<EntidadCliente> getDniClienteReserva(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where dnicliente='"+ cliente.getDni() +"'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando nombre

        public static List<EntidadCliente> getNombreCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where nombrecliente like '%"+ cliente.getNombre()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                
            return list;
        }
        
        //filtrando apellidos

        public static List<EntidadCliente> getApellidosCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente != null)
            {
                String sql="select * from cliente where apellidoscliente like '%"+ cliente.getApellidos()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando fecha nacimiento

        public static List<EntidadCliente> getFechaNacimientoCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where fechanacimiento like '%"+ cliente.getFechaNacimiento()+"'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando pais

        public static List<EntidadCliente> getPaisCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where paiscliente like'%"+ cliente.getPais()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando localidad

        public static List<EntidadCliente> getLocalidadCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list = null;
            
            if(cliente!= null)
            {
                String sql="select * from cliente where localidadcliente like'%"+ cliente.getLocalidad()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
         //filtrando provincia

        public static List<EntidadCliente> getProvinciaCliente(EntidadCliente cliente) throws SQLException, Exception 
        {
            List<EntidadCliente> list= null;
            
            if(cliente!=null)
            {
                String sql="select * from cliente where provinciacliente like'%"+ cliente.getProvincia()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
   //MODIFICAR CLIENTES
	
    public static void modificarCliente(EntidadCliente cliente) throws Exception
    {
        if(cliente!=null)
        {
                String sql="update cliente set dnicliente='"+ cliente.getDni()+"', nombrecliente='"+ cliente.getNombre()+"', apellidoscliente='"+ cliente.getApellidos()+"', "
                     + "direccioncliente='"+ cliente.getDireccion()+"', telefonocliente="+ cliente.getTelefono()+", emailcliente='"+ cliente.getEmail()+"', fechanacimiento='"+ cliente.getFechaNacimiento()+"', "
                     + "codpostalcliente="+ cliente.getCp()+", localidadcliente='"+ cliente.getLocalidad()+"', provinciacliente='"+ cliente.getProvincia()+"', "
                    + "paiscliente='"+ cliente.getPais()+"' WHERE idcliente="+ cliente.getId()+"";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Cliente modificado correctamente");
        }
    }
    

    private static List<EntidadCliente> getResultSet(String sql, Connection conn) throws SQLException {
	try 
	{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<EntidadCliente>lista=new ArrayList<EntidadCliente>();
		while(rs.next())
		{
                    
			EntidadCliente clienteActual=new EntidadCliente(rs.getInt("idcliente"), rs.getString("dnicliente"), rs.getString("nombrecliente"), rs.getString("apellidoscliente"), rs.getString("direccioncliente"), rs.getInt("telefonocliente"), rs.getString("emailcliente"), rs.getString("fechanacimiento"), rs.getInt("codpostalcliente"), rs.getString("paiscliente"), rs.getString("provinciacliente"), rs.getString("localidadcliente"));
			lista.add(clienteActual);
		}
			
		rs.close();
		stmt.close();
		conn.close();
			
		return lista;
	} 
		
	catch (Exception e) 
	{
		e.printStackTrace();
		throw e;
	}
    }
    
    private static List<EntidadReserva> getResultSet1(String sql, Connection conn) throws SQLException {
	try 
	{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<EntidadReserva>lista=new ArrayList<EntidadReserva>();
		while(rs.next())
		{
			EntidadReserva reservaActual=new EntidadReserva(rs.getInt("idreserva"), rs.getInt("numhab"), rs.getString("fechaentrada"), rs.getString("fechasalida"), rs.getString("dnicliente"), rs.getInt("numpersonas"), rs.getString("observaciones"), rs.getLong("precioHabitacion"));
			lista.add(reservaActual);
		}
			
		rs.close();
		stmt.close();
		conn.close();
			
		return lista;
	} 
		
	catch (Exception e) 
	{
		e.printStackTrace();
		throw e;
	}
    }
}
