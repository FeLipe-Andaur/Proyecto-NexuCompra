
package cl.NexuCompra.util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class Utils {
    
    
       public static String obtenerInput(JTextField campo){
      
        return campo.getText();
      
      } 
       
       public static String obtenerInputPassword(JPasswordField campo){
      
        return String.valueOf(campo.getPassword());
        
      } 
    
}
