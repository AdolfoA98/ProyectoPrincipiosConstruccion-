/**
* Programa:    SGPA
* Clase:       DataBase
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Maneja la conexión del programa con la Base de Datos del sistema.
*/
package mx.fei.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DataBase {
    
    private static Connection conexion;
    
    //TODO poner en un archivo de propiedades
    
    private static void crearConexion(){
        Configuracion configuracion = new Configuracion();
        Properties properties = null;
        try{
            properties = configuracion.cargarConfiguracion();
            String url = "jdbc:mysql://" + properties.getProperty("server") + "/";
            String dataBase = properties.getProperty("database");
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            conexion = (Connection) DriverManager.getConnection(url + dataBase + "?autoReconnect=true&useSSL=false", userName, password);
        }catch(IOException | SQLException ex){
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void cargarPropiedades(){
        
    }
    
    public static Connection obtenerConexion(){
        crearConexion();
        return DataBase.conexion;
    }
    
    public static void cerrarConexion(){
        if(conexion != null){
            try{
                if(conexion.isClosed()){
                    conexion.close();
                }
            }catch(SQLException ex){
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
