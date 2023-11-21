
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
        Producto prod3 = new Producto("pan", "marraqueta", 88734, 4200, 15);
        Producto prod4 = new Producto("tallarines", "spagueti", 568945, 1500, 10);
        
        Usuario user1 = new Usuario("Juan", "Romero", "154632789");
        Usuario user2 = new Usuario("Maria", "Carmen", "128332152");
        Usuario user3 = new Usuario("Helena", "perez", "182733515");
        
        
        
        //Productos
        
        boolean prodDAO = new ProductoDAO().agregarProducto(prod4);//Funciona
        //boolean prodDAO = new ProductoDAO().eliminarProducto(12344);//Funciona
       // boolean prodDAO  = new ProductoDAO().actualizarProducto(prod3);//Funciona
       // Producto prodDAO = new ProductoDAO().buscarProductoPorCodigo(12245);//Funciona
       // ArrayList<Producto> prodDAO = new ProductoDAO().buscarTodosProductos();//Funciona
        
        
        //Usuarios
        
        //boolean userDAO = new UsuarioDAO().agregarUsuario(user3);//Funciona
       // boolean userDAO = new UsuarioDAO().eliminarUsuario("128332152");//Funciona
       // boolean userDAO = new UsuarioDAO().actualizarUusuario(user1);//Funciona
      //  Usuario userDao = new UsuarioDAO().buscarUsuarioPorRut("182733515");//Funciona
      //  ArrayList<Usuario> userDAO = new UsuarioDAO().buscarTodosUsuarios();//Funcional
         
        
        
        
        
        
  
            
        
        Boleta bol = new Boleta();
        
        bol.agregarProducto(prod1);
        bol.agregarProducto(prod2);
        bol.agregarProducto(prod3);
       
        
     
        
                        
    
       
               
        
        
    }
    
}
