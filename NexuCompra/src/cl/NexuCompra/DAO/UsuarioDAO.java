
package cl.NexuCompra.DAO;

import cl.NexuCompra.DataBase.Conexion;
import cl.NexuCompra.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class UsuarioDAO {
    
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
