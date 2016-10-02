/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexiones.Conexiones;
import Entidad.EntidadHabitación;
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
public class ModeloHabitacion 
{
    //INSERCION DE DATOS
	
    public static void insertarHabitacion(EntidadHabitación habitacion) throws Exception
    {
        if(habitacion!= null)
        {
            String sql=" insert into habitacion (numhab,numplanta,vistas,tipo,estado,dnilimpiadora,capacidad, descripcion, precio)"
                    + " values("+habitacion.getNHabitacion()+"," +" "+habitacion.getNPlanta()+", '"+habitacion.getVistas()+"', "
                    + "'"+habitacion.getTipo()+"', '"+habitacion.getEstado()+"', "+null+","
                    + +habitacion.getCapacidad()+", '"+habitacion.getDescripcion()+"', "+habitacion.getPrecio()+");";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            
            JOptionPane.showMessageDialog(null, "Habitación registrada correctamente");
        }
    }
    
    //MOSTRAR DATOS
	
    public static List<EntidadHabitación> getHabitaciones() throws SQLException, Exception 
    {
            String sql="select * from habitacion";
            List<EntidadHabitación> list=getResultSet(sql, Conexiones.getConexion());
            return list;
    }
    
    
    public static List<EntidadHabitación> getHabitaciones1() throws SQLException, Exception 
    {
            String sql="select * from habitacion where dnilimpiadora is null or dnilimpiadora =''";
            List<EntidadHabitación> list=getResultSet(sql, Conexiones.getConexion());
            return list;
    }
    
    //ASIGNAR HABITACION A LIMPIADORA 
	
    public static void asignarHabitacion(EntidadHabitación habitacion) throws Exception
    {
        if(habitacion!= null)
        {
            String sql="update habitacion set numhab="+ habitacion.getNHabitacion()+", numplanta="+ habitacion.getNPlanta()+", vistas='"+ habitacion.getVistas()+"', tipo='"+ habitacion.getTipo()+"', estado='"+ habitacion.getEstado()+"', dnilimpiadora='"+ habitacion.getDniLimpiadora()+"', capacidad="+ habitacion.getCapacidad()+" WHERE numhab=" + habitacion.getNHabitacion()+ "";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            JOptionPane.showMessageDialog(null, "Se ha asignado correctamente");
        }
    }
    
    
        //filtrando nº habitacion

        public static List<EntidadHabitación> getNHabitacion(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where numhab= "+ habitacion.getNHabitacion()+"";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                
            return list;
        }
        
        //filtrando nº planta

        public static List<EntidadHabitación> getNPlanta(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion!=null)
            {
                String sql="select * from habitacion where numplanta= "+ habitacion.getNPlanta()+"";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando vistas

        public static List<EntidadHabitación> getVistas(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list= null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where vistas like '%"+ habitacion.getVistas()+"%'";
                list =getResultSet(sql, Conexiones.getConexion());
            }
                
            return list;
        }
        
        //filtrando tipo

        public static List<EntidadHabitación> getTipo(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where tipo like '%"+ habitacion.getTipo()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                
            return list;
        }
        
        //filtrando capacidad

        public static List<EntidadHabitación> getCapacidad(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where capacidad="+ habitacion.getCapacidad()+"";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando estado

        public static List<EntidadHabitación> getEstado(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where estado '%"+ habitacion.getEstado()+"%'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando precio

        public static List<EntidadHabitación> getPrecio(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion != null)
            {
                String sql="select * from habitacion where precio= "+ habitacion.getPrecio()+"";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
        //filtrando dni limpiadora

        public static List<EntidadHabitación> getDniLimpiadora(EntidadHabitación habitacion) throws SQLException, Exception 
        {
            List<EntidadHabitación> list = null;
            
            if(habitacion!= null)
            {
                String sql="select * from habitacion where dnilimpiadora='"+ habitacion.getDniLimpiadora()+"'";
                list=getResultSet(sql, Conexiones.getConexion());
            }
                return list;
        }
        
   //MODIFICAR HABITACIONES
	
    public static void modificarHabitacion(EntidadHabitación habitacion) throws Exception
    {
        if(habitacion!=null)
        {
            String sql="update habitacion set numplanta="+ habitacion.getNPlanta()+", vistas='"+ habitacion.getVistas()+"', tipo='"+ habitacion.getTipo()+"', "
                    + "estado='"+ habitacion.getEstado()+"', dnilimpiadora='"+ habitacion.getDniLimpiadora()+"', capacidad="+ habitacion.getCapacidad()+", "
                    + "descripcion='"+ habitacion.getDescripcion()+"', precio="+ habitacion.getPrecio()+" WHERE numhab=" + habitacion.getNHabitacion()+ "";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            
            JOptionPane.showMessageDialog(null, "Habitación modificada correctamente");
        }
    }
    
    //ELIMINAR
	
    public static void eliminarHabitacion(EntidadHabitación habitacion) throws Exception
    {
        if(habitacion!=null)
        {
            String sql="delete from habitacion where numhab="+habitacion.getNHabitacion();
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    
        private static List<EntidadHabitación> getResultSet(String sql, Connection conn) throws SQLException {
	try 
	{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<EntidadHabitación>lista=new ArrayList<EntidadHabitación>();
		while(rs.next())
		{
                    
			EntidadHabitación habitacionActual=new EntidadHabitación(rs.getInt("numhab"), rs.getInt("numplanta"), rs.getString("vistas"), rs.getString("tipo"), rs.getString("estado"), rs.getString("dnilimpiadora"), rs.getInt("capacidad"), rs.getString("descripcion"), rs.getInt("precio"));
			lista.add(habitacionActual);
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
