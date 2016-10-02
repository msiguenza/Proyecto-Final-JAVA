/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadCheckIn 
{
    int idReserva = 0, numHab = 0, numPersonas = 0;
    long precioTotal = 0;
    String dnicliente = "", condicionAlojamiento = "", fechaEntrada = "", metodoPago = "";
    
    public EntidadCheckIn()
    {
        
    }
    
    public EntidadCheckIn(int idReserva, int numHab, String fechaEntrada, String condicionAlojamiento,
            String dnicliente, int numPersonas, long precioTotal)
    {
        this.idReserva = idReserva;
        this.numHab = numHab;
        this.fechaEntrada = fechaEntrada;
        this.precioTotal = precioTotal;
        this.condicionAlojamiento = condicionAlojamiento;
        this.dnicliente = dnicliente;
        this.numPersonas = numPersonas;
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

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }

    public String getCondicionAlojamiento() {
        return condicionAlojamiento;
    }

    public void setCondicionAlojamiento(String condicionAlojamiento) {
        this.condicionAlojamiento = condicionAlojamiento;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
