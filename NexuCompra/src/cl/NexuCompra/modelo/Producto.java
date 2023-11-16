
package cl.NexuCompra.modelo;

import java.util.Date;

/**
 *
 * @author Andaur - Cornejo
 * @version 1.0
 */
public class Producto extends Usuario{
    
    private String nomproducto,descripcion;
    private int codigo,precio,cantidad;

    public Producto() {
    }

    public Producto(String nomproducto, String descripcion, int codigo, int precio, int cantidad, String nombre, String rut, String apellido, String email, String contraseña) {
        super(nombre, rut, apellido, email, contraseña);
        this.nomproducto = nomproducto;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNomproducto() {
        return nomproducto;
    }

    public void setNomproducto(String nomproducto) {
        this.nomproducto = nomproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nomproducto=" + nomproducto + ", descripcion=" + descripcion + ", codigo=" + codigo + ", precio=" + precio + ", cantidad=" + cantidad + '}' + " " + super.toString();
    }

    public Date getPublicacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setCodProd(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

    

  
    
    

 
    
    
    
    
}
