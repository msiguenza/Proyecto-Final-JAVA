/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadHotel 
{
    String nombreHotel = "", cif = "", direccion = "", localidad = "", provincia = "", emailHotel = "", 
            pais = "", roles = "", vistas = "", tipos = "";
    int cp = 0, telefono = 0, plantas = 0, capacidad = 0;
    
    public EntidadHotel()
    {
        
    }
    
    public EntidadHotel(int plantas)
    {
        this.plantas = plantas;
    }
    
    
    public EntidadHotel(String nombreHotel, String cif, String direccion, int cp, int telefono, 
            String localidad, String pais, String provincia, String emailHotel, int plantas, 
            String roles, String vistas, int capacidad, String tipos)
    {
        this.nombreHotel = nombreHotel;
        this.cif = cif;
        this.direccion = direccion;
        this.cp = cp;
        this.telefono = telefono;
        this.localidad = localidad;
        this.pais = pais;
        this.provincia = provincia;
        this.emailHotel = emailHotel;
        this.plantas = plantas;
        this.roles = roles;
        this.vistas = vistas;
        this.capacidad = capacidad;
        this.tipos = tipos;
    }
    
    
    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmailHotel() {
        return emailHotel;
    }

    public void setEmailHotel(String emailHotel) {
        this.emailHotel = emailHotel;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }    

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getVistas() {
        return vistas;
    }

    public void setVistas(String vistas) {
        this.vistas = vistas;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public int getPlantas() {
        return plantas;
    }

    public void setPlantas(int plantas) {
        this.plantas = plantas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
