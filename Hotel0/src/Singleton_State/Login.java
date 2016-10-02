/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton_State;

import Controlador.ControladorAdministrador;
import Entidad.EntidadEmpleado;
import Modelo.ModeloEmpleados;
import java.sql.SQLException;


import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Angel
 */
public class Login implements IResource{
   
    private static String username;
    private static String password;
    private static Login instance;
    private static IResource resource;
    private static String[] args;
    
    VistaLoggin loggeo = new VistaLoggin();
   
    
    
        private Login(){
            username="";
            password="";
        }
    
  
    public static String getUsername(){
       String result;
        
        result = username;
        return result;
    }
    
    //////GETS AND SETS DE LOS ATRIBUTOS
    public static void setUsername(String u){
        username = u;
    }
    
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Login.password = password;
    }

    public static Login getInstance() {
        return instance;
    }

    public static void setInstance(Login instance) {
        Login.instance = instance;
    }

    public static IResource getResource() {
        return resource;
    }

    public static void setResource(IResource resource) {
        Login.resource = resource;
    }
    ///////////FIN GETS AND SETS
    
    
    
    public static void authenticate() throws SQLException, Exception{
        
        //setDefaultLookAndFeelDecorated(true);
        
        (new VistaLoggin()).setVisible(true);
    }
    
   
     /////ESTE METODO ES EL ENCARGADO DE ESCRIBIR EN EL LOG
    static int validate() throws Exception
    {
        int result = 0;
        
        
        List<EntidadEmpleado> list = ModeloEmpleados.getEmpleado();
        
        String[][] datos=new String[list.size()][3];
	int i;
	 
        
        if(username.equals("") || password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Introduzca un nombre de usuario y la contraseña");
        }
        
        for (i = 0; i < list.size(); i++)
	{
		datos[i][0]=list.get(i).getUsuario();
		datos[i][1]=list.get(i).getClave();
                datos[i][2]=list.get(i).getRol();
               
	
                if(datos[i][0].equals(username) && datos[i][1].equals(password) && datos[i][2].equals("Administrador"))
		{
                    String usuarioSesion = username;
                    
                    result = 1;
                   
                    username.equals("");
                    password.equals("");
		}
                
                else if(datos[i][0].equals(username) && datos[i][1].equals(password) && datos[i][2].equals("Recepcionista"))
		{
                    String usuarioSesion = username;
                    
                    result = 2;
                   
                    username.equals("");
                    password.equals("");
		}
                
                else if(datos[i][0].equals(username) && datos[i][1].equals(password) && datos[i][2].equals("Limpiadora"))
		{
                    String usuarioSesion = username;
                    
                    result = 3;
                   
                    username.equals("");
                    password.equals("");
		}
	}
         
         return result;
    }
    

    //@Override
    public void run() {
    }
    
    
}
