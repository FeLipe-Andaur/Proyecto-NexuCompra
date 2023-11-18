
package cl.NexuCompra.modelo;

import java.util.ArrayList;

/**
 *
 * @author Andaur - Cornejo
 * @version 1.0
 */
public class Boleta {
    
    ArrayList<Producto>ColeccionProd;

    public Boleta() {
        ColeccionProd = new ArrayList<>();
    }
    
    public boolean agregarProducto(Producto prod){
    
        return ColeccionProd.add(prod);
    
    }
    
    
}
