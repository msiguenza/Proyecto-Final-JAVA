/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Singleton_State;

/**
 *
 * @author MIGUE
 */
public class Context {
    
      private Estados estadosConexion;

    public void setState(Estados state) {

        this.estadosConexion=state;

    }

    public Estados getState() {

        return this.estadosConexion;
                
    }

    public void doAction() {

        this.estadosConexion.estadosconexion();

    }

}
