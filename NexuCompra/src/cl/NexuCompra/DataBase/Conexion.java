
package cl.NexuCompra.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andaur-Cornejo
 */
public class Conexion {
    
    public Connection obtenerConexion() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/nexucompra", "root", "");
    } catch (ClassNotFoundException e) {
        System.out.println("Error de conexion: Driver no encontrado - " + e.getMessage());
        throw new SQLException("Driver no encontrado", e);
    }
}

   public void cerrarConexion(Connection con) {
    if (con != null) {
        try {
            con.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
    
}
