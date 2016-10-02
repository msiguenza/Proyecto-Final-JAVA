package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexiones;
import Entidad.EntidadCheckIn;
import Entidad.EntidadCheckOut;
import Entidad.EntidadHabitación;
import Entidad.EntidadPago;
import Entidad.EntidadPension;
import Entidad.EntidadReserva;
import javax.swing.JOptionPane;

public class ModeloRecepcionista 
{
	//INSERTAR RESERVAS
	
	public static void insertarReserva(EntidadReserva reserva) throws Exception
	{
            if(reserva!= null)
            {
		String sql=" insert into reserva (idreserva,numhab,fechaentrada, fechasalida, dnicliente, numpersonas, observaciones, precioHabitacion) values("+null+"," +
		" "+reserva.getNumHab()+", '"+reserva.getFechaEntrada()+"', '"+reserva.getFechaSalida()+"', '"+reserva.getDniCliente()+"', "+reserva.getNumPersonas()+", '"+reserva.getObservaciones()+"', "+reserva.getPrecioHabitacion()+");";
		
		Conexiones.executeNonQuery(sql, Conexiones.getConexion());
            }
	}
        
        public static void insertarCheckIn(EntidadCheckIn check) throws Exception
	{
            if(check != null)
            {
		String sql="insert into check_in (idreserva,numhab,fechaentrada, condicionalojamiento, dnicliente, numpersonas, preciototal) values("+check.getIdReserva()+"," +
		" "+check.getNumHab()+", '"+check.getFechaEntrada()+"', '"+check.getCondicionAlojamiento()+"', '"+check.getDnicliente()+"', "+check.getNumPersonas()+", '"+check.getPrecioTotal()+"');";
		
		Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Check in realizado correctamente");
            }
	}
        
        
        public static void insertarCheckOut(EntidadCheckOut check) throws Exception
	{
            if(check!= null)
            {
		String sql="insert into check_out (idreserva,numhab,fechasalida, preciototal, dnicliente) values("+check.getIdReserva()+"," +
		" "+check.getNumHab()+", '"+check.getFechaSalida()+"', "+check.getPrecioTotal()+", '"+check.getDniCliente()+"');";
		
		Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Check out realizado correctamente");
            }
	}
        
        
        public static void insertarCobro(EntidadCheckIn check) throws Exception
	{
            if(check!= null)
            {
		String sql="insert into pago (idpago,dnicliente,idreserva,precio_total, fecha_pago, metodo_pago) values("+null+",'"+check.getDnicliente()+"', "+check.getIdReserva()+", '"+check.getPrecioTotal()+"', '"+check.getFechaEntrada()+"', '"+check.getMetodoPago()+"');";
		
		Conexiones.executeNonQuery(sql, Conexiones.getConexion());
                JOptionPane.showMessageDialog(null, "Cobro realizado correctamente");
            }
	}
        
        public static void modificarCobro(EntidadCheckIn cobro) throws Exception
    {
        if(cobro!= null)
        {
            String sql="update pago set dnicliente='"+ cobro.getDnicliente()+"', idreserva="+ cobro.getIdReserva()+", precio_total='"+ cobro.getPrecioTotal()+"', "
                  + "fecha_pago='"+ cobro.getFechaEntrada()+"', metodo_pago='"+ cobro.getMetodoPago()+"' WHERE idreserva="+ cobro.getIdReserva()+"";
            Conexiones.executeNonQuery(sql, Conexiones.getConexion());
        }
    }
	
	
	
	//MOSTRAR FECHAS RESERVA POR Nº HABITACION
	
	public static List<EntidadReserva> getFecha(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
            
            if(reserva != null)
            {
		String sql="select * from reserva where numhab="+ reserva.getNumHab()+"";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadPago> getPago(EntidadPago pago) throws SQLException, Exception 
        {
		List<EntidadPago> list = null;
                if(pago != null)
                {
                    String sql="select * from pago where idreserva="+ pago.getIdReserva()+"";
                    list=getResultSet5(sql, Conexiones.getConexion());
                }
		
		return list;
	}
        
        
        public static List<EntidadReserva> getDniClienteReservaFechaEntrada(EntidadReserva reserva) throws SQLException, Exception 
        {
            	List<EntidadReserva> list = null;
                
                if(reserva != null)
                {
                    String sql="select * from reserva where dnicliente='"+ reserva.getDniCliente()+"' and fechaentrada='"+ reserva.getFechaEntrada()+"'";
                    list=getResultSet1(sql, Conexiones.getConexion());
                }
		
		return list;
	}
        
        //MOSTRAR RESERVAS
	
	public static List<EntidadReserva> getReservas() throws SQLException, Exception 
        {
		String sql="select * from reserva";
		List<EntidadReserva> list = null;
		list=getResultSet1(sql, Conexiones.getConexion());
		
		return list;
	}
	
	public static List<EntidadHabitación> getPrecio() throws SQLException, Exception 
        {
		String sql="select * from habitacion";
		List<EntidadHabitación> list = null;
		list=getResultSet2(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadCheckIn> mostrarCheckIn() throws SQLException, Exception 
        {
		String sql="select * from check_in";
		List<EntidadCheckIn> list = null;
		list=getResultSet4(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadCheckOut> mostrarCheckOut() throws SQLException, Exception 
        {
		String sql="select * from check_out";
		List<EntidadCheckOut> list = null;
		list=getResultSet6(sql, Conexiones.getConexion());
		
		return list;
	}
        
        public static List<EntidadPago> mostrarPago(EntidadPago pago) throws SQLException, Exception 
        {
            List<EntidadPago> list = null;
                
            if(pago != null)
            {
		String sql="select * from pago where fecha_pago='"+ pago.getFechaPago()+"'";
		list=getResultSet5(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        
        public static List<EntidadPago> mostrarPagoPorFecha(EntidadPago pago) throws SQLException, Exception 
        {
            List<EntidadPago> list = null;
                
            if(pago != null)
            {
		String sql="select * from pago where fecha_pago='"+ pago.getFechaPago()+"'";
		list=getResultSet5(sql, Conexiones.getConexion());
            }
		
		return list;
	}
	
	//MOSTRAR FECHAS RESERVA POR USUARIO
	
	public static List<EntidadReserva> getReservasClientes(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
            
            if(reserva != null)
            {
		String sql="select * from reserva where dnicliente='"+ reserva.getDniCliente()+"'";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadCheckIn> getCheckIn(EntidadCheckIn reserva) throws SQLException, Exception 
        {
            List<EntidadCheckIn> list = null;
            
            if(reserva != null)
            {
		String sql="select * from check_in where idreserva='"+ reserva.getIdReserva()+"'";
		list=getResultSet4(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadPago> getPagoRealizado(EntidadPago pago) throws SQLException, Exception 
        {
            List<EntidadPago> list = null;
            
            if(pago != null)
            {
		String sql="select * from pago where idreserva='"+ pago.getIdReserva()+"'";
		list=getResultSet5(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getNHabitacion(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
                
            if(reserva != null)
            {
		String sql="select * from reserva where numhab="+ reserva.getNumHab()+"";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getFechaEntradaReserva(EntidadReserva reserva) throws SQLException, Exception 
        {
		List<EntidadReserva> list = null;
                
            if(reserva != null)
            {
		String sql="select * from reserva where fechaentrada='"+ reserva.getFechaEntrada()+"'";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}        
        
        public static List<EntidadReserva> getFechaEntradaDniCliente(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
            
            if(reserva != null)
            {
		String sql="select * from reserva where fechaentrada='"+ reserva.getFechaEntrada()+"' and dnicliente='"+ reserva.getDniCliente()+"'";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getFechaSalidaReserva(EntidadReserva reserva) throws SQLException, Exception 
        {
            
		List<EntidadReserva> list = null;
                
            if(reserva!= null)
            {
		String sql="select * from reserva where fechasalida='"+ reserva.getFechaSalida()+"'";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getDniClienteReserva(EntidadReserva reserva) throws SQLException, Exception 
        {
            
		List<EntidadReserva> list = null;
                
            if(reserva!= null)
            {
		String sql="select * from reserva where dnicliente='"+ reserva.getDniCliente()+"'";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getNPersonasReserva(EntidadReserva reserva) throws SQLException, Exception 
        {
            
		List<EntidadReserva> list = null;
                
            if(reserva!= null)
            {
		String sql="select * from reserva where numpersonas="+ reserva.getNumPersonas()+"";
		list=getResultSet1(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadPension> getNombrePension(EntidadPension pension) throws SQLException, Exception 
        {
            
		List<EntidadPension> list = null;
                
            if(pension!= null)
            {
		String sql="select * from pension where pension like '%"+ pension.getPension()+"%'";
		list=getResultSet3(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadPension> getPrecioPension(EntidadPension pension) throws SQLException, Exception 
        {
            
		List<EntidadPension> list = null;
                
            if(pension!= null)
            {
		String sql="select * from pension where precio = "+ pension.getPrecio()+"";
		list=getResultSet3(sql, Conexiones.getConexion());
            }
		
		return list;
	}
        
        public static List<EntidadReserva> getFechaSalidaCheckOut(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
            int idReserva = 0;
            Statement stmt=Conexiones.getConexion().createStatement();
            //ResultSet rs;
            
            if(reserva != null)
            {
                ResultSet rs;
                idReserva = obtieneIdReserva(reserva);
                
                // Comprobamos si esta reserva hizo check in, es decir, q exista en la tabla checkin ese idReserva
                String sql="select 1 from check_in ci where ci.idreserva="+ idReserva;
                rs=stmt.executeQuery(sql); 
                
                // Si esto devuelve algo (1) es que ha hecho checkin, sino devuelve nada es que no.
                 while(rs.next())
                 {
                       String sqlReserva = "select * from reserva where idreserva= " + idReserva;
                       list=getResultSetIdReserva(sqlReserva, Conexiones.getConexion());
                 }
            
            
			
			rs.close();
			stmt.close();
			Conexiones.getConexion().close();
                
            }
		
		return list;
	}
        
        
        public static int obtieneIdReserva(EntidadReserva reserva) throws SQLException, Exception 
        {
            List<EntidadReserva> list = null;
            //List<String>
                int lista=0, columna = 0;
            
            if(reserva != null)
            {
		String sql="select idreserva from reserva where fechasalida='"+ reserva.getFechaSalida()+"' and numhab="+reserva.getNumHab()+"";
                Statement stmt=Conexiones.getConexion().createStatement();
		ResultSet rs=stmt.executeQuery(sql); 
                        
                        columna=rs.findColumn("idreserva");
                        
                        while(rs.next())
                        {
                            lista=rs.getInt(columna);
                        }
			
			//rs.close();
			//stmt.close();
			//Conexiones.getConexion().close();
			
                
                
		//list=getResultSet1(sql, Conexiones.getConexion());
                //Statement stmt = Conexiones.getConexion().createStatement();

               /* ResultSet rs = stmt.executeQuery("select * from check_in where idreserva = (select idreserva from reserva where fechasalida='"+ reserva.getFechaSalida()+"' and numhab="+reserva.getNumHab()+")"); 
                
                while(rs.next())
                {
                    list.add(rs.next());
                }*/
            }
			return lista;
	}
        
         //ELIMINAR
	
        public static void eliminarReserva(EntidadReserva reserva) throws Exception
        {
            if(reserva!= null)
            {
              String sql="delete from reserva where dnicliente='"+reserva.getDniCliente()+"' and fechaentrada='"+reserva.getFechaEntrada()+"';";
              Conexiones.executeNonQuery(sql, Conexiones.getConexion());
              JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente");
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
				EntidadReserva reservaActual=new EntidadReserva(rs.getInt("idreserva"), rs.getInt("numhab"), rs.getString("fechaentrada"), rs.getString("fechasalida"), rs.getString("dnicliente"), rs.getInt("numpersonas"), rs.getString("observaciones"), rs.getInt("precioHabitacion"));
				
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
        
        private static List<EntidadReserva> getResultSetIdReserva(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadReserva>lista=new ArrayList<EntidadReserva>();
			
			
			while(rs.next())
			{
				EntidadReserva reservaActual=new EntidadReserva(rs.getInt("idreserva"), rs.getInt("numhab"), rs.getString("fechaentrada"), rs.getString("fechasalida"), rs.getString("dnicliente"), rs.getInt("numpersonas"), rs.getString("observaciones"), rs.getInt("precioHabitacion"));
				
				lista.add(reservaActual);
			}
			
			return lista;
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			throw e;
		}		
	}
        
        private static List<EntidadHabitación> getResultSet2(String sql, Connection conn) throws SQLException {
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
        
        private static List<EntidadPension> getResultSet3(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadPension>lista=new ArrayList<EntidadPension>();
			
			
			while(rs.next())
			{
				EntidadPension pensionActual=new EntidadPension(rs.getString("pension"), rs.getInt("precio"));
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
        
        
        private static List<EntidadCheckIn> getResultSet4(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadCheckIn>lista=new ArrayList<EntidadCheckIn>();
			
			
			while(rs.next())
			{
				EntidadCheckIn checkInActual=new EntidadCheckIn(rs.getInt("idreserva"), rs.getInt("numhab"), rs.getString("fechaentrada"), rs.getString("condicionalojamiento"), rs.getString("dnicliente"), rs.getInt("numpersonas"), rs.getInt("preciototal"));
                                lista.add(checkInActual);
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
        
        
        private static List<EntidadPago> getResultSet5(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadPago>lista=new ArrayList<EntidadPago>();
			
			
			while(rs.next())
			{
				EntidadPago pagoActual=new EntidadPago(rs.getInt("idpago"),rs.getString("dnicliente"), rs.getInt("idreserva"), rs.getLong("precio_total"), rs.getString("fecha_pago"), rs.getString("metodo_pago"));
                                lista.add(pagoActual);
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
        
        
        private static List<EntidadCheckOut> getResultSet6(String sql, Connection conn) throws SQLException {
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			List<EntidadCheckOut>lista=new ArrayList<EntidadCheckOut>();
			
			
			while(rs.next())
			{
				EntidadCheckOut checkOutActual=new EntidadCheckOut(rs.getInt("idreserva"), rs.getInt("numhab"), rs.getString("fechasalida"), rs.getInt("preciototal"), rs.getString("dnicliente"));
                                lista.add(checkOutActual);
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
