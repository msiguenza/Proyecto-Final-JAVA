/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton_State;

import javax.swing.JOptionPane;

/**
 *
 * @author MIGUE
 */
public class NoConectado implements Estados {

        public void estadosconexion() {
            JOptionPane.showMessageDialog(null, "Conexión  fallida");
     
   }

   public String toString(){
      return "Testeo incorrecto de la conexión";
   }

}