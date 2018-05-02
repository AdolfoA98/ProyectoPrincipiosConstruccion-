/**
* Programa:    SGPA
* Clase:       DataBase
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Maneja la conexión del programa con la Base de Datos del sistema.
*/
package mx.fei.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DataBase {
    
    private static Connection conexion;
    
    //TODO poner en un archivo de propiedades
    static String url = "jdbc:mysql://localhost/";
    static String database = "sgpa";
    static String userName = "adolfo";
    static String contra = "dima670208";
    
    private static void crearConexion(){
        try{
            conexion = (Connection) DriverManager.getConnection(url + database, userName, contra);
        }catch(SQLException ex){
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
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
