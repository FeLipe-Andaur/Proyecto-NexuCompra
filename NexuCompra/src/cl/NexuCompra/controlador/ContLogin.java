
package cl.NexuCompra.controlador;
import cl.NexuCompra.DAO.UsuarioDAO;
import cl.NexuCompra.modelo.Usuario;
import cl.NexuCompra.vista.JF_Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class ContLogin {
    
    
    private UsuarioDAO userDAO;
    


    public ContLogin() {
        
        this.userDAO = new UsuarioDAO();
    }

    public ContLogin(JF_Login aThis) {
       
    }

   
        
               
public boolean validarLogin(String rut, String contrasenna) {
    try {
        // Buscar al usuario por su rut
        Usuario usuario = userDAO.buscarUsuarioPorRut(rut);

        // Verificar si se encontró un usuario y la contraseña es correcta
        if (usuario != null && usuario.getContraseña().equals(contrasenna)) {
            JOptionPane.showMessageDialog(null, "Ingreso correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No coincide el usuario y/o la contraseña", "Informacion", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    } catch (Exception e) {
         
        e.printStackTrace();
        return false;
    }
}

 
   


}