/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton_State;

import javax.naming.Context;

/**
 *
 * @author MIGUE
 */
public class Conectado implements Estados {

        public void estadosconexion() {
      System.out.println("Conexión  realizada con exito");
     
   }

   public String toString(){
      return "Testea correctamente la conexión";
   }

}
