
package cl.NexuCompra.controlador;

import cl.NexuCompra.DAO.ProductoDAO;
import cl.NexuCompra.DAO.UsuarioDAO;
import cl.NexuCompra.DataBase.Conexion;
import cl.NexuCompra.modelo.Producto;
import cl.NexuCompra.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Andaur-Cornejo
 */
public class Registro {
    
  private ProductoDAO productoDAO = new ProductoDAO();
  private UsuarioDAO usuarioDAO = new UsuarioDAO();
   
    
   public boolean agregarProducto(Producto prod) throws SQLException {
       
    String query = "INSERT INTO producto(nombre, descripcion, codigo, precio, cantidad) VALUES(?,?,?,?,?)";
    
    try (Connection cnx = new Conexion().obtenerConexion();
            
         PreparedStatement stmt = cnx.prepareStatement(query)) {

        stmt.setString(1, prod.getNomproducto());
        stmt.setString(2, prod.getDescripcion());
        stmt.setInt(4, prod.getCodigo());
        stmt.setInt(5, prod.getPrecio());
        stmt.setInt(6, prod.getCantidad());

        stmt.executeUpdate();
        
        return true;
        
    } catch (SQLException e) {
        
        System.out.println("Error SQL al agregar producto: " + e.getMessage());
        return false;
        
    }
    
}
    
    public boolean eliminarProducto(int codigo)
    {
        try (Conexion con = new Conexion();Connection cnx = con.obtenerConexion()){
           String query = "delete from producto where codProd=?"; 
           try (PreparedStatement stmt = cnx.prepareStatement(query)){
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
          
           }
            return true;  
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar producto " + e.getMessage() );
            return false;
        }
    }
    
    public boolean actualizarProducto(Producto prod)
    {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "update producto set nombre=?,descripcion=?,codigo=?,precio=?,cantidad=? where codigo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, prod.getNomproducto());
            stmt.setString(2, prod.getDescripcion());
            stmt.setInt(3,prod.getCodigo());
            stmt.setInt(4,prod.getPrecio());
            stmt.setInt(5, prod.getCantidad());
           
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar producto " + e.getMessage() );
            return false;
        }
    }
    
    public Producto buscarCodProducto(int codigo)
    {
        Producto prod = new Producto();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from producto where codigo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNomproducto(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getInt("precio"));
                prod.setCantidad(rs.getInt("cantidad"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto por codigo" + e.getMessage() );
        }
        return prod;
    }
    
     public ArrayList<Producto> buscarTodosProductos()
    {
        ArrayList<Producto> lista = new ArrayList<>();
        try (Conexion con = new Conexion();Connection cnx = con.obtenerConexion();
             PreparedStatement stmt = cnx.prepareStatement("select * from usuario by codigo");
              ResultSet rs = stmt.executeQuery()  ){
                                  
        
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNomproducto(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getInt("precio"));
                prod.setCantidad(rs.getInt("cantidad"));
                
                
               lista.add(prod);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto " + e.getMessage() );
        }
        return lista;
    }
     
     
     public boolean agregarUsuario(Usuario user) throws SQLException {
       
    String query = "INSERT INTO usuario(nombre, rut, apellido,correo,contraseña ) VALUES(?,?,?,?,?)";
    
    try (Connection cnx = new Conexion().obtenerConexion();
            
         PreparedStatement stmt = cnx.prepareStatement(query)) {

        stmt.setString(1, user.getNombre());
        stmt.setString(2, user.getApellido());
        stmt.setString(3, user.getRut());
        stmt.setString(5, user.getCorreo());
        stmt.setString(4, user.getContraseña());
        
        stmt.executeUpdate();
        
        return true;
        
    } catch (SQLException e) {
        
        System.out.println("Error SQL al agregar usuario: " + e.getMessage());
        return false;
        
    }
    
}
    
   public boolean eliminarUsuario(String rutUser) {
    try (Conexion con = new Conexion(); Connection cnx = con.obtenerConexion()) {
        String query = "DELETE FROM usuario WHERE rutUser=?";
        try (PreparedStatement stmt = cnx.prepareStatement(query)) {
            stmt.setString(1, rutUser);
            stmt.executeUpdate();
        }
        return true;
    } catch (SQLException e) {
        System.out.println("Error SQL al eliminar usuario: " + e.getMessage());
        return false;
    }
}

    public boolean actualizarUusuario(Usuario user)
    {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "update usuario set nombre=?,apellido=?,rut=?,correo=?,contraseña=? WHERE rut=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1, user.getNombre());
           stmt.setString(2, user.getApellido());
           stmt.setString(3, user.getRut());
           stmt.setString(5, user.getCorreo());
           stmt.setString(4, user.getContraseña());
                       
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar usuario " + e.getMessage() );
            return false;
        }
    }
    
    public Usuario buscarUsuarioRut(int rutUser)
    {
        Usuario user = new Usuario();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from usuario where rutUser=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, rutUser);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setRut(rs.getString("rut"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuario por rut" + e.getMessage() );
        }
        return user;
    }
    
     public ArrayList<Usuario> buscarTodosUsuarios()
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        try (Conexion con = new Conexion();Connection cnx = con.obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement("select * from usuario by rut ");
                ResultSet rs = stmt.executeQuery()){
                
            
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setRut(rs.getString("rut"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                
               lista.add(user);
            }
                        
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuario " + e.getMessage() );
        }
        return lista;
    }
    
}