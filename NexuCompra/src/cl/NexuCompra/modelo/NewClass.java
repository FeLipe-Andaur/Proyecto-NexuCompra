
package cl.NexuCompra.modelo;
import cl.NexuCompra.DAO.ProductoDAO;
import cl.NexuCompra.DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class NewClass {
    
    
    public static void main(String[] args) throws SQLException {
                        
              
            
        Producto prod1 = new Producto("chetos", "light", 12344, 2000, 3);
        Producto prod2 = new Producto("cafe", "nescafe", 12245, 7000, 2);
        Producto prod3 = new Producto("pan", "marraqueta", 88734, 4200, 7);
        
        Usuario user1 = new Usuario("pepito", "1234", "montañecez", "holamundo", "pepito123@gmail.com");
        
        
        
        boolean prodDAO = new ProductoDAO().agregarProducto(prod1);
        
        
        
        System.out.println(user1);
            
        
        Boleta bol = new Boleta();
        
        bol.agregarProducto(prod1);
        bol.agregarProducto(prod2);
        bol.agregarProducto(prod3);
       
        
       prod1.imprimirDetalles();
       System.out.println("-------------------");
       prod2.imprimirDetalles();
        System.out.println("------------------");
       prod3.imprimirDetalles();
        
                        
       
               
        
        
    }
    
}
