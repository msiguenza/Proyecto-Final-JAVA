/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadHabitación 
{
    int NHabitacion = 0, NPlanta = 0, capacidad = 0, precio = 0;
    String vistas = "", tipo = "", estado = "", dniLimpiadora = "", descripcion = "";
    
    public EntidadHabitación()
    {
        
    }
    
    public EntidadHabitación(int NHabitacion, int NPlanta, String vistas, String tipo, String estado, String dniLimpiadora, int capacidad, String descripcion, int precio)
    {
        this.NHabitacion = NHabitacion;
        this.NPlanta = NPlanta;
        this.vistas = vistas;
        this.tipo = tipo;
        this.estado = estado;
        this.dniLimpiadora = dniLimpiadora;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getNHabitacion() {
        return NHabitacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNHabitacion(int NHabitacion) {
        this.NHabitacion = NHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNPlanta() {
        return NPlanta;
    }

    public void setNPlanta(int NPlanta) {
        this.NPlanta = NPlanta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getVistas() {
        return vistas;
    }

    public void setVistas(String vistas) {
        this.vistas = vistas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDniLimpiadora() {
        return dniLimpiadora;
    }

    public void setDniLimpiadora(String dniLimpiadora) {
        this.dniLimpiadora = dniLimpiadora;
    }
}
