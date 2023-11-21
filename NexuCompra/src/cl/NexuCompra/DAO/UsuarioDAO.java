
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
       
    String query = "INSERT INTO usuario(nombre,apellido,rut ) VALUES(?,?,?)";
    
    try (Connection cnx = new Conexion().obtenerConexion();
            
         PreparedStatement stmt = cnx.prepareStatement(query)) {
 
        stmt.setString(1, user.getNombre());
        stmt.setString(2, user.getApellido());
        stmt.setString(3, user.getRut());
      
        
        stmt.executeUpdate();
        
        return true;
        
    } catch (SQLException e) {
        
        System.out.println("Error SQL al agregar usuario: " + e.getMessage());
        return false;
        
    }
    
}
    
   public boolean eliminarUsuario(String rut) {
    try (Conexion con = new Conexion(); Connection cnx = con.obtenerConexion()) {
        String query = "DELETE FROM usuario WHERE rut=?";
        try (PreparedStatement stmt = cnx.prepareStatement(query)) {
            stmt.setString(1, rut);
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
            
            String query = "update usuario set nombre=?,apellido=? WHERE rut=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getApellido());
            stmt.setString(3, user.getRut());
                       
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar usuario " + e.getMessage() );
            return false;
        }
    }
    
    public Usuario buscarUsuarioPorRut(String rut) {
    Usuario user = new Usuario();
    try {
        Conexion con = new Conexion();
        Connection cnx = con.obtenerConexion();
        String query = "SELECT * FROM usuario WHERE rut=?";
        try (PreparedStatement stmt = cnx.prepareStatement(query)) {
            stmt.setString(1, rut);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user.setRut(rs.getString("rut"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                
                
                System.out.println("Informacion del usuario encontrado:");
                System.out.println("rut: " + user.getRut());
                System.out.println("Nombre: " + user.getNombre());
                System.out.println("Apellido: " + user.getApellido());
                
            }else{
              System.out.println(" No se encontro el producto con el codigo: " + rut);
            }
            rs.close();
            stmt.close();
            cnx.close();
        }
    } catch (SQLException e) {
        System.out.println("Error SQL al buscar usuario por rut: " + e.getMessage());
    }
    return user;
}

    
     public ArrayList<Usuario> buscarTodosUsuarios()
    {
        ArrayList<Usuario> lista = new ArrayList<>();
        try (Conexion con = new Conexion();Connection cnx = con.obtenerConexion();
                PreparedStatement stmt = cnx.prepareStatement("select * from usuario order by rut ");
                ResultSet rs = stmt.executeQuery()){
                
            
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setRut(rs.getString("rut"));
                
                
               lista.add(user);
            }
                
            System.out.println("Información de todos los usuarios:");
        for (Usuario user : lista) {
            System.out.println("Nombre: " + user.getNombre());
            System.out.println("Apellido: " + user.getApellido());
            System.out.println("Rut: " + user.getRut());
          
            System.out.println("-------------------");
        }
        
        } catch (SQLException e) {
            System.out.println("Error SQL al listar usuario " + e.getMessage() );
        }
        return lista;
    }

   
    
    
    
    
}
