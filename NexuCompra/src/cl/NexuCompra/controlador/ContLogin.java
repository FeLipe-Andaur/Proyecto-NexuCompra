
package cl.NexuCompra.controlador;

import cl.NexuCompra.DAO.UsuarioDAO;
import cl.NexuCompra.DataBase.Conexion;
import cl.NexuCompra.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class ContLogin {
    
    private Conexion con = new Conexion();
    private UsuarioDAO userDAO = new UsuarioDAO();

    public ContLogin() {
    }
    
    
    public ContLogin(Conexion con) {
        this.con=con;
    }
    
   
    
 public boolean validarLogin(int rut, String contrasenna) {
     // Buscar al usuario por su rut
     Usuario usuario = userDAO.buscarUsuarioRut(rut);
     // Verificar si se encontró un usuario y la contraseña es correcta
     if (usuario != null && usuario.getContraseña().equals(contrasenna)) {
         System.out.println("Conexion Valida");
         return true;
     } else {
         System.out.println("conexion invalida");
         return false;
     }
}

}
