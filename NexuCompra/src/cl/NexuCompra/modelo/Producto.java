
package cl.NexuCompra.modelo;



/**
 *
 * @author Andaur - Cornejo
 * @version 1.0
 */
public class Producto {
    
    private String nomproducto,descripcion;
    private int codigo,precio,cantidad;

    public Producto() {
    }

    public Producto(String nomproducto, String descripcion, int codigo, int precio, int cantidad) {
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
        return "Producto{" + "nomproducto=" + nomproducto + ", descripcion=" + descripcion + ", codigo=" + codigo + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

    
    public void imprimirDetalles(){
    
        System.out.println("nombre: "+ nomproducto);
        System.out.println("descripcion: "+ descripcion);
        System.out.println("codigo: "+ codigo);
        System.out.println("precio: "+"$"+ precio);
        System.out.println("cantidad: "+ cantidad);
    
    
    
    
    }
  
      
  
      
    
       
}
