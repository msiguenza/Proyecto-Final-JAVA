/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton_State;


import Vistas.VistaAdministrador;
import java.sql.SQLException;


/**
 *
 * @author Miguel Angel
 */
public class Test {
    
    Test(){
    }
    
    ////////METODO QUE REQUIERE VALIDACION LLAMANDO AL METODO QUE DEVUELVE LA INSTANCIA DE
    ///////TRACER Y AL METODO QUE HACE VISIBLE EL FRAME CON EL LOGIN
    void testAuth() throws SQLException, Exception{
        
         //Login.setResource(new VistaAdministrador());
        
        Login.authenticate();
        
    }
    
    
}
