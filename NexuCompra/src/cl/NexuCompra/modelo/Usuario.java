
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
    private String correo;
    private  String contraseña;
    

    public Usuario() {
    }

    public Usuario(String nombre,  String apellido ,String rut,String correo ,String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.contraseña = contraseña;
        
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
    
      public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

  

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre +  ", apellido=" + apellido + ", rut=" + rut + ", correo=" + correo + ", contraseña=" + contraseña +  '}';
    }

    

      
}
