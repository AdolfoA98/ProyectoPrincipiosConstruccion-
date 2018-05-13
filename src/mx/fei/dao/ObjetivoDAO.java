/**
* Programa:    SGPA
* Clase:       ObjetivoDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       07/05/2018
* Versión:     0.1
* Descripción: Clase del patrón Data Access Object que maneja los datos de la clase
*              Objetivos perteneciente al documento de Plan de Trabajo.
*/
package mx.fei.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.database.DataBase;
import mx.fei.dominio.Actividad;
import mx.fei.dominio.Objetivo;

public class ObjetivoDAO  implements IObjetivoDAO{
    
    private List<Objetivo> listaObjetivos;
    private String query;
    private Connection conexion;
    
    public ObjetivoDAO(){}
    
    @Override
    public List<Objetivo> obtenerObjetivos() {
        
        ActividadDAO actividadDAO = new ActividadDAO();
        query = "select * from objetivo";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            ResultSet tablaSQL = comando.executeQuery();
            
            while(tablaSQL.next()){
                
                Objetivo objetivo = new Objetivo();
                
                objetivo.setId(tablaSQL.getInt("idObjetivo"));
                objetivo.setTextoObjetivo(tablaSQL.getString("objetivo"));
                objetivo.setMeta(tablaSQL.getString("meta"));
                
                objetivo.setActividades(actividadDAO.obtenerActividades(objetivo.getId()));
                
                listaObjetivos.add(objetivo);
            }
        }catch(SQLException ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return listaObjetivos;
    }

    @Override
    public boolean agregarObjetivo(Objetivo objetivo) {
        
        boolean success = true;
        query = "insert into objetivo values(?, ?, ?)";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, objetivo.getId());
            comando.setString(2, objetivo.getMeta());
            comando.setString(3, objetivo.getTextObjetivo());
            comando.execute();
        }catch(SQLException ex){
            success = false;
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean eliminarObjetivo(int idObjetivo) {
        
        boolean success = true;
        query = "delete from objetivo where idObjetivo = ?";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idObjetivo);
            comando.execute();
        }catch(SQLException ex){
            success = false;
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean actualizarObjetivos(List<Objetivo> listaObjetivosActualizada) {
        
        List<Objetivo> objetivoActualizar = new ArrayList<>();
        
        for(int i = 0; i < listaObjetivosActualizada.size(); i++){
            for(int j = 0; j < listaObjetivos.size(); j++){
                if(listaObjetivosActualizada.get(i).getId() == listaObjetivos.get(j).getId()){
                    objetivoActualizar.add(listaObjetivosActualizada.get(i));
                    listaObjetivosActualizada.remove(i);
                    listaObjetivos.remove(j);
                }
            }
        }
        
        for(int i = 0; i < objetivoActualizar.size(); i++){
            actualizarObjetivo(objetivoActualizar.get(i));
        }
        
        for(int j = 0; j < listaObjetivos.size(); j++){
            eliminarObjetivo(listaObjetivos.get(j).getId());
            listaObjetivos.remove(j);
        }
        
        for(int k = 0; k < listaObjetivosActualizada.size(); k++){
            agregarObjetivo(listaObjetivosActualizada.get(k));
        }
        
        listaObjetivos.clear();
        obtenerObjetivos();
        
        return true;
    }
    
    @Override
    public boolean actualizarObjetivo(Objetivo objetivoActualizado){
        
        boolean success = true;
        conexion = DataBase.obtenerConexion();
        String[] datos = new String[2];
        datos[0] = objetivoActualizado.getMeta();
        datos[1] = objetivoActualizado.getTextObjetivo();
        
        for(int i = 0; i < 2; i++){
            query = getColumnQuery(i);
            
            try{
                PreparedStatement comando = conexion.prepareStatement(query);
                comando.setString(1, datos[i]);
                comando.setInt(i, objetivoActualizado.getId());
                comando.execute();
            }catch(SQLException ex){
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                success = false;
            }finally{
                DataBase.cerrarConexion();
            }
        }
        
        return success;
    }
    
    private String getColumnQuery(int columna){
        
        String query = "";
        
        switch(columna){
            case 0: query = "update objetivo set meta = ? where idObjetivo = ?";
            break;
            case 1: query = "update objetivo set objetivo = ? where idObjetivo = ?";
            break;
        }
        
        return query;
    }
    
}
