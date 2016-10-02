/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadPension 
{
    String pension = "";
    int precio = 0;
    
    public EntidadPension()
    {
        
    }
    
    public EntidadPension(String pension, int precio)
    {
        this.pension = pension;
        this.precio = precio;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
