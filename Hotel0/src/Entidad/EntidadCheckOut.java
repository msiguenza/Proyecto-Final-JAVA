/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.sql.Date;

/**
 *
 * @author Silvia
 */
public class EntidadCheckOut 
{
    int idReserva = 0, numHab = 0;
    String dniCliente = "", fechaSalida = "";
    long precioTotal = 0;
    
    public EntidadCheckOut()
    {
        
    }
    
    public EntidadCheckOut(int idReserva, int numHab, String fechaSalida, int precioTotal, String dniCliente)
    {
        this.idReserva = idReserva;
        this.numHab = numHab;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
        this.dniCliente = dniCliente;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }    
}
