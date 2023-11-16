
package cl.NexuCompra.controlador;

import cl.NexuCompra.DataBase.Conexion;
import cl.NexuCompra.modelo.Producto;
import java.util.Date;
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
    
    public boolean agregar(Producto prod)
    {
        Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            date = prod.getPublicacion();
            
            String query = "insert into producto(nombre,descripcion,codigo,precio,cantidad) values(?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, prod.getNomproducto());
            stmt.setString(2, prod.getDescripcion());
            stmt.setInt(4,prod.getCodigo());
            stmt.setInt(5,prod.getPrecio());
            stmt.setInt(6,prod.getCantidad());
           
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Libro " + e.getMessage() );
            return false;
        }
    }
    
    public boolean eliminar(int codProd)
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
    
    public boolean actualizar(Producto prod)
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
            System.out.println("Error SQL al actualizar Libro " + e.getMessage() );
            return false;
        }
    }
    
    public Producto buscarPorCod(int codProd)
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
            System.out.println("Error SQL al listar Libro por id" + e.getMessage() );
        }
        return prod;
    }
    
     public ArrayList<Producto> buscarTodos()
    {
        ArrayList<Producto> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "select * from libro order by titulo";
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
            System.out.println("Error SQL al listar Libros " + e.getMessage() );
        }
        return lista;
    }
    
}