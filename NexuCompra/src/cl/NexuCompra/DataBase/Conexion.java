
package cl.NexuCompra.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements AutoCloseable {

    
    
    private Connection connection;

    public Conexion(Connection connection) {
        this.connection = connection;
    }
    
    

    public Conexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nexucompra", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de conexion: Driver no encontrado - " + e.getMessage());
            throw new SQLException("Driver no encontrado", e);
        }
    }

    public Connection obtenerConexion() {
        return this.connection;
    }

    @Override
    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
            System.out.println("Conexión cerrada.");
        }
    }
}
