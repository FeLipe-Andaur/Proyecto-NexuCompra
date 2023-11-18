
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
        
        return productoDAO.agregarProducto(prod);
        
    } catch (SQLException e) {
        
        System.out.println("Error SQL al agregar producto: " + e.getMessage());
        return false;
        
    }
    
}
    
    public boolean eliminarProducto(int codProd)
    {
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
        
            
            String query = "delete from producto where codProd=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codProd);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
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
            
            String query = "update producto set nombre=?,descripcion=?,codigo=?,precio=?,cantidad=? where codProducto=?";
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
    
    public Producto buscarCodProducto(int codProd)
    {
        Producto prod = new Producto();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from producto where codProd=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, codProd);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                prod.setCodProd(rs.getInt("codprod"));
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
    
     public ArrayList<Producto> buscarTodosProducto()
    {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from producto order by codigo";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setCodProd(rs.getInt("codLibro"));
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
       
    String query = "INSERT INTO producto(nombre, rut, apellido, contraseña, ) VALUES(?,?,?,?)";
    
    try (Connection cnx = new Conexion().obtenerConexion();
            
         PreparedStatement stmt = cnx.prepareStatement(query)) {

        stmt.setString(1, user.getNombre());
        stmt.setString(2, user.getApellido());
        stmt.setInt(3, user.getRut());
        stmt.setString(4, user.getContraseña());


        stmt.executeUpdate();
        
        return true;
        
    } catch (SQLException e) {
        
        System.out.println("Error SQL al agregar usuario: " + e.getMessage());
        return false;
        
    }
    
}
    
    public boolean eliminarUsuario(int rutUser)
    {
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
        
            
            String query = "delete from producto where codProd=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, rutUser);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar usuario " + e.getMessage() );
            return false;
        }
    }
    
    public boolean actualizarUusuario(Usuario user)
    {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "update producto set nombre=?,apellido=?,rut=?,contraseña=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getApellido());
            stmt.setInt(3, user.getRut());
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
                user.setRut(rs.getInt("rut"));
                user.setContraseña(rs.getString("contraseña"));
                
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuario por codigo" + e.getMessage() );
        }
        return user;
    }
    
     public ArrayList<Usuario> buscarTodosUsuarios()
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from usuario order by rut";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setRut(rs.getInt("rut"));
                user.setContraseña(rs.getString("contraseña"));
                
                
               lista.add(user);
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto " + e.getMessage() );
        }
        return lista;
    }
     
     
    
}