
package cl.NexuCompra.modelo;

/**
 *
 * @author Andaur-Cornejo
 * @version 1.0
 */
public  class Usuario {
    
    private  String nombre;
    private  String rut;
    private  String apellido;
    private  String contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String rut, String apellido, String contraseña) {
        this.nombre = nombre;
        this.rut = rut;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", rut=" + rut + ", apellido=" + apellido + ", contrase\u00f1a=" + contraseña + '}';
    }

   

}
