
package mx.fei.dominio;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.dao.ActividadDAO;


public class GeneradorClave {
    
    private static int clave = -1;;
        
    public static int obtenerId(){
        
        SecureRandom llave;
        
        try{
            llave = SecureRandom.getInstance("SHA1PRNG");
            clave = llave.nextInt(50000);
        }catch(NoSuchAlgorithmException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clave;
    }
    public GeneradorClave(){}
}
