/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Silvia
 */
public class EntidadEmpleado 
{
    String dni = "", nombre = "", apellidos = "", direccion = "", rol = "", usuario = "", email = "",
            clave = "", provincia = "", localidad = "", pais = "";
    int id = 0, telefono = 0, cp = 0;
    
    public EntidadEmpleado()
    {
        
    }
    
    public EntidadEmpleado(String dni)
    {
        this.dni = dni;
    }
    
    public EntidadEmpleado(String usuario, String clave, String rol)
    {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }
    
    public EntidadEmpleado(int id, String dni, String nombre, String apellidos, String direccion, int telefono, String rol, 
            String usuario, String clave, int cp, String localidad, String provincia, String pais, String email)
    {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = rol;
        this.usuario = usuario;
        this.clave = clave;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
