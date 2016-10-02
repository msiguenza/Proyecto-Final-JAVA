/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadPago 
{
    String dniCliente = "", fechaPago = "", metodoPago = "";
    int idReserva = 0, idPago=0;
    long precioTotal = 0;
    
    public EntidadPago()
    {
        
    }
    
    public EntidadPago(int idPago,String dniCliente, int idReserva, long precioTotal, String fechaPago, String metodoPago)
    {
        this.idPago = idPago;
        this.dniCliente = dniCliente;
        this.idReserva = idReserva;
        this.precioTotal = precioTotal;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public long getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(long precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
