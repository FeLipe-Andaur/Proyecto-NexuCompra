
package cl.NexuCompra.controlador;
import cl.NexuCompra.DAO.UsuarioDAO;
import cl.NexuCompra.modelo.Usuario;

/**
 *
 * @author Felipe
 */
public class ContLogin {
    
    
    private UsuarioDAO userDAO = new UsuarioDAO();
    
     

    public ContLogin() {
        this.userDAO= userDAO;
    }
        
               
public boolean validarLogin(int rut, String contrasenna) {
    try {
        // Buscar al usuario por su rut
        Usuario usuario = userDAO.buscarUsuarioRut(rut);

        // Verificar si se encontró un usuario y la contraseña es correcta
        if (usuario != null && usuario.getContraseña().equals(contrasenna)) {
            System.out.println("Conexión Válida");
            return true;
        } else {
            System.out.println("Conexión Inválida");
            return false;
        }
    } catch (Exception e) {
        // Manejar la excepción (puedes imprimir el error o registrar en un log)
        e.printStackTrace();
        return false;
    }
 }
}