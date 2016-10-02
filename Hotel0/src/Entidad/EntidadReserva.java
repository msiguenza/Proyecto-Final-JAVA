/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadReserva 
{
    int idReserva = 0, numHab = 0, numPersonas = 0;
    long precioHabitacion = 0;
    String diaEntrada = "", mesEntrada = "", anyoEntrada = "", diaSalida = "", mesSalida = "", anyoSalida = "", 
            dniCliente = "", observaciones = "", fechaEntrada = "", fechaSalida = "";

    public EntidadReserva() 
    {
        
    }
    
    public EntidadReserva(int idReserva, int numHab, String fechaEntrada, String fechaSalida, String dniCliente, 
            int numPersonas, String observaciones, long precioHabitacion) 
    {
        this.idReserva = idReserva;
        this.numHab = numHab;
        this.dniCliente = dniCliente;
        this.numPersonas = numPersonas;
        this.observaciones = observaciones;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioHabitacion = precioHabitacion;
    }

    public long getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(long precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public String getMesEntrada() {
        return mesEntrada;
    }

    public void setMesEntrada(String mesEntrada) {
        this.mesEntrada = mesEntrada;
    }

    public String getAnyoEntrada() {
        return anyoEntrada;
    }

    public void setAnyoEntrada(String anyoEntrada) {
        this.anyoEntrada = anyoEntrada;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public String getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(String mesSalida) {
        this.mesSalida = mesSalida;
    }

    public String getAnyoSalida() {
        return anyoSalida;
    }

    public void setAnyoSalida(String anyoSalida) {
        this.anyoSalida = anyoSalida;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
