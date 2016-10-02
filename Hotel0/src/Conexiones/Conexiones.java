/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Singleton_State.Conectado;
import Singleton_State.Context;
import Singleton_State.Estados;
import Singleton_State.NoConectado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Silvia
 */
public class Conexiones 
{
    private static Connection conn;
    
   
    
    	public static void inicializarConexionMYSQL() {     
            
        Context context = new Context();

        Estados Conectado = new Conectado();

        Estados NoConectado = new NoConectado();
        
          

            
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection
					(
					"jdbc:mysql://localhost/hotel", "root", "");
			
			//conn = DriverManager.getConnection(
			//		"jdbc:mysql://192.168.200.100:3306/sperezg", "dam", "dam");
                            
                               context.setState(Conectado);

                               context.doAction();
                        
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
                        
                        
                          context.setState(NoConectado);
             
                          context.doAction();
                        
		}

	}
	
	public static Connection getConexion() {
		try 
		{
			if(conn==null || conn.isClosed())
			{
				inicializarConexionMYSQL();
			}
			return conn;
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	
	}
        
        	public static int executeNonQuery(String sql,Connection conn) throws Exception{
		try {
			Statement stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
                
                
                
          public Connection getConnection() {
        return this.conn;
    }      
                
    
}
