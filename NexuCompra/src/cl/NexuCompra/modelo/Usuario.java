
package cl.NexuCompra.modelo;

/**
 *
 * @author Andaur-Cornejo
 * @version 1.0
 */
public  class Usuario {
    
    private  String nombre;
    private  String apellido;
    private  String rut;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String rut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + '}';
    }
      
}
