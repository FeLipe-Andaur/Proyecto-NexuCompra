package cl.NexuCompra.DAO;


import cl.NexuCompra.DataBase.Conexion;
import cl.NexuCompra.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Felipe
 */
public class ProductoDAO {
    
    public boolean agregarProducto(Producto prod) throws SQLException {
       
    String query = "INSERT INTO producto(nombre, descripcion, codigo, precio, cantidad) VALUES(?,?,?,?,?)";
    
    try (Connection cnx = new Conexion().obtenerConexion();
            
         PreparedStatement stmt = cnx.prepareStatement(query)) {

        stmt.setString(1, prod.getNomproducto());
        stmt.setString(2, prod.getDescripcion());
        stmt.setInt(3, prod.getCodigo());
        stmt.setInt(4, prod.getPrecio());
        stmt.setInt(5, prod.getCantidad());

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
           String query = "delete from producto where codigo=?"; 
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
            
            String query = "update producto set nombre=?,descripcion=?,precio=?,cantidad=? where codigo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, prod.getNomproducto());
            stmt.setString(2, prod.getDescripcion());
            stmt.setInt(3,prod.getPrecio());
            stmt.setInt(4, prod.getCantidad());
            stmt.setInt(5,prod.getCodigo());
           
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar producto " + e.getMessage() );
            return false;
        }
    }
    
    public Producto buscarProductoPorCodigo(int codigo)
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
                
                System.out.println("Detalles del producto encontrado:");
                System.out.println("Código: " + prod.getCodigo());
                System.out.println("Nombre: " + prod.getNomproducto());
                System.out.println("Descripción: " + prod.getDescripcion());
                System.out.println("Precio: " + prod.getPrecio());
                System.out.println("Cantidad: " + prod.getCantidad());
                
            }else{
            System.out.println(" No se encontro el producto con el codigo: " + codigo);
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
             PreparedStatement stmt = cnx.prepareStatement("select * from producto order by codigo");
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
            
            
             System.out.println("Detalles de todos los productos:");
        for (Producto producto : lista) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNomproducto());
            System.out.println("Descripción: " + producto.getDescripcion());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad: " + producto.getCantidad());
            System.out.println("-------------------");
        }
            
        } catch (SQLException e) {
            System.out.println("Error SQL al listar producto " + e.getMessage() );
        }
        return lista;
    }
    
}
