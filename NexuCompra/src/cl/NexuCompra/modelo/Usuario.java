
package cl.NexuCompra.modelo;

/**
 *
 * @author Andaur-Cornejo
 */
public class Usuario {
    
    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int id, String rut, String nombre, String apellido, String email, String contraseña) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
}
