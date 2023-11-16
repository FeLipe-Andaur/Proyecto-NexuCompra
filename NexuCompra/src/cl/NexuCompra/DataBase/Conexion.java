
package cl.NexuCompra.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andaur-Cornejo
 */
public class Conexion {
    
    public Connection obtenerConexion()
    {
        Connection con = null;
        //trycatch+tab
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "");
            System.out.println("Conexión exitosa!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion " + e.getMessage());
        }
        return con;
    }
    
}
