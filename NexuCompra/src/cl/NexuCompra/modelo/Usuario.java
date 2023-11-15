
package cl.NexuCompra.modelo;

/**
 *
 * @author Andaur-Cornejo
 */
public abstract class Usuario implements ICalculable{
    
    protected  String nombre;
    protected  String rut;
    protected  String apellido;
    protected  String email;
    protected  String contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String rut, String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.rut = rut;
        this.apellido = apellido;
        this.email = email;
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
        return "Usuario{" + "nombre=" + nombre + ", rut=" + rut + ", apellido=" + apellido + ", email=" + email + ", contrase\u00f1a=" + contraseña + '}';
    }

   
   
    
    
}
