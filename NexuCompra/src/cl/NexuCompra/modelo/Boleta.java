
package cl.NexuCompra.modelo;

import java.util.ArrayList;

/**
 *
 * @author Andaur - Cornejo
 * @version 1.0
 */
public class Boleta {
    
    ArrayList<Usuario>ColeccionProd;

    public Boleta() {
        ColeccionProd = new ArrayList<>();
    }
    
    public boolean agregarProducto(Usuario user){
    
        return ColeccionProd.add(user);
    
    }
    
    
}
