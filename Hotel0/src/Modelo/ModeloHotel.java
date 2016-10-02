/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexiones.Conexiones;
import Entidad.EntidadCapacidad;
import Entidad.EntidadHotel;
import Entidad.EntidadPension;
import Entidad.EntidadPlanta;
import Entidad.EntidadRol;
import Entidad.EntidadTipos;
import Entidad.EntidadVistas;
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
public class ModeloHotel 
{
        public static void insertarHotel(EntidadHotel hotel) throws Exception
        {
            if(hotel != null)
            {
                String sql=" insert into hotel (nombrehotel,cifhotel,direccionhotel,cphotel,"
                        + "telefonohotel,localidadhotel,paishotel,provinciahotel,emailhotel,plantashotel,roleshotel,"
                        + "vistashabitacion,capacidadhabitacion,tiposhabitacion) values('"+hotel.getNombreHotel()+"', '"+hotel.getCif()+"', "
                        + "'"+hotel.getDireccion()+"', "+hotel.getCp()+", "+hotel.getTelefono()+", '"+hotel.getLocalidad()+"', "
                        + "'"+hotel.getPais()+"', '"+hotel.getProvincia()+"', '"+hotel.getEmailHotel()+"', "+hotel.getPlantas()+""
                        + ", '"+hotel.getRoles()+"', '"+hotel.getVistas()+"', "+hotel.getCapacidad()+", '"+hotel.getTipos()+"');";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            }
        }
        
        public static void insertarRoles(EntidadRol rol) throws Exception
        {
            if(rol != null)
            {
                String sql=" insert into rolempleado (rol) values('"+rol.getRol()+"');";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Rol introducido correctamente");
            }
        }
        
        public static void insertarVistas(EntidadVistas vista) throws Exception
        {
            if(vista!=null)
            {
                String sql=" insert into vistashabitacion (vistas) values('"+vista.getVista()+"');";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Vista registrada correctamente");
            }
        }
        
        public static void insertarTipo(EntidadTipos tipo) throws Exception
        {
            if(tipo!=null)
            {
                String sql=" insert into tipohabitacion (tipo) values('"+tipo.getTipo()+"');";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                 JOptionPane.showMessageDialog(null, "Tipo de habitación registrado correctamente");
            }
        }
        
        public static void insertarCapacidad(EntidadCapacidad capacidad) throws Exception
        {
            if(capacidad!= null)
            {
                String sql=" insert into capacidadhabitacion (capacidadhab) values("+capacidad.getCapacidad()+");";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Capacidad registrada correctamente");
            }
        }
        
        public static void insertarPlanta(EntidadPlanta planta) throws Exception
        {
            if(planta!= null)
            {
                String sql=" insert into planta (numplanta) values("+planta.getnPlanta()+");";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Planta registrada correctamente");
            }
        }
        
        public static void insertarPension(EntidadPension pension) throws Exception
        {
            if(pension!= null)
            {
             String sql=" insert into pension (pension, precio) values('"+pension.getPension()+"', "+pension.getPrecio()+");";
             Conexiones.executeNonQuery(sql, Conexiones.getConexion());
             JOptionPane.showMessageDialog(null, "Pensión registrada correctamente");
            }
        }
        
        
        
        public static List<EntidadHotel> getHotel() throws SQLException, Exception 
        {
		String sql="select * from hotel";
                
		List<EntidadHotel> list = null;
		list=getResultSet(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadRol> getRoles() throws SQLException, Exception 
        {
		String sql="select * from rolempleado";
                
		List<EntidadRol> list = null;
		list=getResultSet1(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadVistas> getVistas() throws SQLException, Exception 
        {
		String sql="select * from vistashabitacion";
                
		List<EntidadVistas> list = null;
		list=getResultSet2(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadPlanta> getNPlantas() throws SQLException, Exception 
        {
		String sql="select * from planta";
                
		List<EntidadPlanta> list = null;
		list=getResultSet6(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadTipos> getTipos() throws SQLException, Exception 
        {
		String sql="select * from tipohabitacion";
                
		List<EntidadTipos> list = null;
		list=getResultSet3(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadCapacidad> getCapacidad() throws SQLException, Exception 
        {
		String sql="select * from capacidadhabitacion";
                
		List<EntidadCapacidad> list = null;
		list=getResultSet4(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static int getNplanta() throws SQLException, Exception 
        {
                int list = 0;
		String sql="select plantashotel from hotel";
                list = getResultSetInt(sql, Conexiones.getConexion());
		return list;
	}
        
        public static List<EntidadPension> getPension() throws SQLException, Exception 
        {
		String sql="select * from pension";
                
		List<EntidadPension> list = null;
		list=getResultSet7(sql, Conexiones.getConexion());
		
		return list;
	}
        
        //MODIFICAR
	
    public static void modificarHotel(EntidadHotel hotel) throws Exception
    {
        if(hotel!=null)
        {
           String sql=" update hotel set nombrehotel='"+hotel.getNombreHotel()+"', cifHotel='"+hotel.getCif()+"', "
                        + "direccionhotel='"+hotel.getDireccion()+"', cphotel="+hotel.getCp()+", telefonohotel="+hotel.getTelefono()+", localidadhotel='"+hotel.getLocalidad()+"', "
                        + "paishotel='"+hotel.getPais()+"', provinciahotel='"+hotel.getProvincia()+"', emailhotel='"+hotel.getEmailHotel()+"', plantashotel="+hotel.getPlantas()+""
                        + ", roleshotel='"+hotel.getRoles()+"', vistashabitacion='"+hotel.getVistas()+"', capacidadhabitacion="+hotel.getCapacidad()+", tiposhabitacion='"+hotel.getTipos()+"';";
                Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
        }
    }
    
    
    //ELIMINAR
	
    public static void eliminarCapacidad(EntidadCapacidad capacidad) throws Exception
    {
        if(capacidad!= null)
        {
            String sql="delete from capacidadhabitacion where capacidadhab="+capacidad.getCapacidad();
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    public static void eliminarRol(EntidadRol rol) throws Exception
    {
        if(rol!= null)
        {
            String sql = "delete from rolempleado where rol='"+rol.getRol()+"';";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    public static void eliminarVista(EntidadVistas vista) throws Exception
    {
        if(vista!= null)
        {
            String sql="delete from vistashabitacion where vistas='"+vista.getVista()+"';";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    public static void eliminarTipo(EntidadTipos tipo) throws Exception
    {
        if(tipo!= null)
        {
            String sql="delete from tipohabitacion where tipo='"+tipo.getTipo()+"';";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
    public static void eliminarPension(EntidadPension pension) throws Exception
    {
        if(pension!=null)
        {
            String sql="delete from pension where pension='"+pension.getPension()+"';";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
    
        
        
        
        private static List<EntidadHotel> getResultSet(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadHotel>lista=new ArrayList<EntidadHotel>();
			
			
			while(rs.next())
			{
                                EntidadHotel hotelActual = new EntidadHotel(rs.getString("nombrehotel"), rs.getString("cifhotel"), rs.getString("direccionhotel"), rs.getInt("cphotel"), rs.getInt("telefonohotel"), rs.getString("localidadhotel"), rs.getString("paishotel"), rs.getString("provinciahotel"), rs.getString("emailhotel"), rs.getInt("plantashotel"), rs.getString("roleshotel"), rs.getString("vistashabitacion"), rs.getInt("capacidadhabitacion"), rs.getString("tiposhabitacion"));
				lista.add(hotelActual);
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
        
        private static List<EntidadRol> getResultSet1(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadRol>lista=new ArrayList<EntidadRol>();
			
			
			while(rs.next())
			{
                                EntidadRol rolActual = new EntidadRol(rs.getString("rol"));
				lista.add(rolActual);
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
        
        
        private static List<EntidadVistas> getResultSet2(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadVistas>lista=new ArrayList<EntidadVistas>();
			
			
			while(rs.next())
			{
                                EntidadVistas vistaActual = new EntidadVistas(rs.getString("vistas"));
				lista.add(vistaActual);
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
        
        private static List<EntidadTipos> getResultSet3(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadTipos>lista=new ArrayList<EntidadTipos>();
			
			
			while(rs.next())
			{
                                EntidadTipos tiposActual = new EntidadTipos(rs.getString("tipo"));
				lista.add(tiposActual);
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
        
        private static List<EntidadCapacidad> getResultSet4(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadCapacidad>lista=new ArrayList<EntidadCapacidad>();
			
			
			while(rs.next())
			{
                                EntidadCapacidad capacidadActual = new EntidadCapacidad(rs.getInt("capacidadhab"));
				lista.add(capacidadActual);
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
        
        
        private static List<EntidadHotel> getResultSet5(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadHotel>lista=new ArrayList<EntidadHotel>();
			
			
			while(rs.next())
			{
                                EntidadHotel nPlantaActual = new EntidadHotel(rs.getInt("plantashotel"));
				lista.add(nPlantaActual);
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
        
        
        
        private static int getResultSetInt(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int lista=0, columna = 0;
                        
                        columna=rs.findColumn("plantashotel");
                        
                        while(rs.next())
                        {
                            lista=rs.getInt(columna);
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
        
        
        private static List<EntidadPlanta> getResultSet6(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadPlanta>lista=new ArrayList<EntidadPlanta>();
			
			
			while(rs.next())
			{
                                EntidadPlanta plantaActual = new EntidadPlanta(rs.getInt("numplanta"));
				lista.add(plantaActual);
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
        
        
        private static List<EntidadPension> getResultSet7(String sql, Connection conn) throws SQLException 
        {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadPension>lista=new ArrayList<EntidadPension>();
			
			
			while(rs.next())
			{
                                EntidadPension pensionActual = new EntidadPension(rs.getString("pension"), rs.getInt("precio"));
				lista.add(pensionActual);
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
