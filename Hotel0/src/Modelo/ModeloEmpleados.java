/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexiones.Conexiones;
import Entidad.EntidadEmpleado;
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
public class ModeloEmpleados 
{
    
    	//INSERCION DE DATOS
	
	public static void insertarEmpleado(EntidadEmpleado empleado) throws Exception
	{
            if(empleado!=null)
            {
		String sql=" insert into empleado (idempleado,dniempleado,nombreempleado,apellidosempleado,"
                        + "direccionempleado,telefonoempleado,rolempleado,usuario,clave,cp,localidad,provincia,pais,email) values("+null+"," +
                        " '"+empleado.getDni()+"', '"+empleado.getNombre()+"', '"
                        +empleado.getApellidos()+"', '"+empleado.getDireccion()+"', "+empleado.getTelefono()+", '"+empleado.getRol()+"', "
                        + "'"+empleado.getUsuario()+"', '"+empleado.getClave()+"', "+empleado.getCp()+", '"+empleado.getLocalidad()+"', "
                        + "'"+empleado.getProvincia()+"', '"+empleado.getPais()+"', '"+empleado.getEmail()+"');";
		Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            }
	}
        
        
    	
	public static List<EntidadEmpleado> getEmpleado() throws SQLException, Exception 
        {
		String sql="select * from empleado";
                
		List<EntidadEmpleado> list = null;
		list=getResultSet(sql, Conexiones.getConexion());
		
		return list;
	}
        
        
        public static List<EntidadEmpleado> getEmpleados() throws SQLException, Exception 
        {
		String sql="select * from empleado";
                
		List<EntidadEmpleado> list = null;
		list=getResultSet2(sql, Conexiones.getConexion());
		
		return list;
	}
        
        
        
        public static List<EntidadEmpleado> getComprobarDni() throws SQLException, Exception 
        {
		String sql="select * from empleado";
                
		List<EntidadEmpleado> list = null;
		list=getResultSet1(sql, Conexiones.getConexion());
		
		return list;
	}
        
            //filtrando dni

            public static List<EntidadEmpleado> getDniEmpleado(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list = null;
                
                if(empleado!=null)
                {
                    String sql="select * from empleado where dniempleado like '%"+ empleado.getDni() +"%'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando nombre

            public static List<EntidadEmpleado> getNombreEmpleado(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list= null;
                
                if(empleado!=null)
                {
                    String sql="select * from empleado where nombreempleado like '%"+ empleado.getNombre()+"%'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando apellidos

            public static List<EntidadEmpleado> getApellidosEmpleado(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list=null;
                
                if(empleado!= null)
                {
                    String sql="select * from empleado where apellidosempleado like '%"+ empleado.getApellidos()+"%'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando rol

            public static List<EntidadEmpleado> getRolEmpleado(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list = null;
                
                if(empleado!=null)
                {
                    String sql="select * from empleado where rolempleado like '%"+ empleado.getRol()+"%'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                   
                return list;
            }
            
            
            //filtrando dni limpiadora

            public static List<EntidadEmpleado> getDniLimpiadora(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list = null;
                
                if(empleado!= null)
                {
                    String sql="select * from empleado where dniempleado like '%"+ empleado.getDni()+"%'and rolempleado='Limpiadora'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando nombre limpiadora

            public static List<EntidadEmpleado> getNombreLimpiadora(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list = null;
                
                if(empleado!= null)
                {
                    String sql="select * from empleado where nombreempleado like '%"+ empleado.getNombre()+"%' and rolempleado='Limpiadora'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                   
                return list;
            }
            
            //filtrando apellidos limpiadora

            public static List<EntidadEmpleado> getApellidosLimpiadora(EntidadEmpleado empleado) throws SQLException, Exception 
            {
                List<EntidadEmpleado> list = null;
                
                if(empleado!= null)
                {
                    String sql="select * from empleado where apellidosempleado like '%"+ empleado.getDni()+"%' and rolempleado='Limpiadora'";
                    list=getResultSet2(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando nº habitacion

            public static List<EntidadHabitación> getNHabitacion(EntidadHabitación habitacion) throws SQLException, Exception 
            {
                List<EntidadHabitación> list = null;
                
                if(habitacion != null)
                {
                    String sql="select * from habitacion where numhab = "+ habitacion.getNHabitacion()+"";
                    list=getResultSet3(sql, Conexiones.getConexion());
                }
                    
                return list;
            }
            
            //filtrando nº planta

            public static List<EntidadHabitación> getNPlanta(EntidadHabitación habitacion) throws SQLException, Exception 
            {
                List<EntidadHabitación> list = null;
                
                if(habitacion != null)
                {
                    String sql="select * from habitacion where numplanta = "+ habitacion.getNPlanta()+"";
                    list=getResultSet3(sql, Conexiones.getConexion());
                }
                
                    return list;
            }
            
            
    //filtrando limpiadoras

    public static List<EntidadEmpleado> getLimpiadora(EntidadEmpleado empleado) throws SQLException, Exception 
    {
        List<EntidadEmpleado> list = null;
        
        if(empleado!=null)
        {
            String sql="select * from empleado where rolempleado like '%"+ empleado.getRol()+"%'";
            list=getResultSet2(sql, Conexiones.getConexion());
        }
        
            return list;
    }
    
    //MODIFICAR 
	
    public static void modificarEmpleado(EntidadEmpleado empleado) throws Exception
    {
        if(empleado!=null)
        {
            String sql="update empleado set dniempleado='"+ empleado.getDni()+"', nombreempleado='"+ empleado.getNombre()+"', apellidosempleado='"+ empleado.getApellidos()+"', "
                    + "direccionempleado='"+ empleado.getDireccion()+"', telefonoempleado="+ empleado.getTelefono()+", rolempleado='"+ empleado.getRol()+"', usuario='"+ empleado.getUsuario()+"', clave='"+ empleado.getClave()+"' WHERE idempleado=" + empleado.getId()+ "";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    
    //ELIMINAR
	
    public static void eliminarEmpleados(EntidadEmpleado empleado) throws Exception
    {
        if(empleado!=null)
        {
            String sql="delete from empleado where idempleado="+empleado.getId();
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
        }
    }
    
    
    
        
        
        private static List<EntidadEmpleado> getResultSet(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadEmpleado>lista=new ArrayList<EntidadEmpleado>();
			
			
			while(rs.next())
			{
				EntidadEmpleado adminActual=new EntidadEmpleado(rs.getString("usuario"), rs.getString("clave"), rs.getString("rolempleado"));
				
				lista.add(adminActual);
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
        
        
    
        private static List<EntidadEmpleado> getResultSet1(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadEmpleado>lista=new ArrayList<EntidadEmpleado>();
			
			
			while(rs.next())
			{
				EntidadEmpleado adminActual=new EntidadEmpleado(rs.getString("dniempleado"));
				
				lista.add(adminActual);
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
        
        
        private static List<EntidadEmpleado> getResultSet2(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadEmpleado>lista=new ArrayList<EntidadEmpleado>();
			
			
			while(rs.next())
			{
				EntidadEmpleado adminActual=new EntidadEmpleado(rs.getInt("idempleado"), rs.getString("dniempleado"), rs.getString("nombreempleado"), rs.getString("apellidosempleado"), rs.getString("direccionempleado"), 
                                        rs.getInt("telefonoempleado"), rs.getString("rolempleado"), rs.getString("usuario"), rs.getString("clave"), rs.getInt("cp"), rs.getString("localidad"), rs.getString("provincia"), rs.getString("pais"), rs.getString("email"));
				
				lista.add(adminActual);
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
        
        private static List<EntidadHabitación> getResultSet3(String sql, Connection conn) throws SQLException 
        {
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
