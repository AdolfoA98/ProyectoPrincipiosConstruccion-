/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author adolf
 */
public class Configuracion {
    
    public Properties cargarConfiguracion() throws FileNotFoundException, IOException{
        
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("ConfiguracionBD.properties"));
        
        return properties;
    }
}
