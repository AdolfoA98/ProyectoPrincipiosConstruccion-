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
    private ActividadDAO actividadDAO;
    
    public ObjetivoDAO(){}
    
    @Override
    public List<Objetivo> obtenerObjetivos() {
        
        listaObjetivos = new ArrayList<>();
        
        actividadDAO = new ActividadDAO();
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
                
                List<Actividad> actividades = actividadDAO.obtenerActividades(objetivo.getId());
                
                if(actividades == null){
                    actividades = new ArrayList<>();
                }
                
                objetivo.setActividades(actividades);
                
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
    public boolean agregarObjetivo(Objetivo objetivo, int idPlanDeTrabajo) {
        
        boolean success = true;
        query = "insert into objetivo values(?, ?, ?, ?)";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, objetivo.getId());
            comando.setInt(2, idPlanDeTrabajo);
            comando.setString(3, objetivo.getTextObjetivo());
            comando.setString(4, objetivo.getMeta());
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
    public boolean eliminarObjetivo(Objetivo objetivo) {
        
        boolean success = true;
        
        List<Actividad> actividades = objetivo.getActividades();
        
        if(actividades != null){
            for(int i = 0; i < actividades.size(); i++){
                actividadDAO.eliminarActividad(actividades.get(i).getId());
            }
        }
        
        query = "delete from objetivo where idObjetivo = ?";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, objetivo.getId());
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
    public boolean actualizarObjetivos(List<Objetivo> listaObjetivosActualizada, int idPlanDeTrabajo) {
        
        List<Objetivo> objetivoActualizar = new ArrayList<>();
        
        if(listaObjetivos == null){
            obtenerObjetivos();
        }
        
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
            actualizarObjetivo(objetivoActualizar.get(i), idPlanDeTrabajo);
        }
        
        for(int j = 0; j < listaObjetivos.size(); j++){
            eliminarObjetivo(listaObjetivos.get(j));
            listaObjetivos.remove(j);
        }
        
        for(int k = 0; k < listaObjetivosActualizada.size(); k++){
            agregarObjetivo(listaObjetivosActualizada.get(k), idPlanDeTrabajo);
        }
        
        listaObjetivos.clear();
        obtenerObjetivos();
        
        return true;
    }
    
    @Override
    public boolean actualizarObjetivo(Objetivo objetivoActualizado, int idPlanDeTrabajo){
        
        boolean success = true;
        conexion = DataBase.obtenerConexion();
        String[] datos = new String[2];
        datos[0] = objetivoActualizado.getMeta();
        datos[1] = objetivoActualizado.getTextObjetivo();
          
        try{
            query = "update objetivo set idPlanDeTrabajo = ? where idObjetivo = ?";
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idPlanDeTrabajo);
            comando.setInt(2, objetivoActualizado.getId());
            comando.execute();
            
            query = "update objetivo set meta = ? where idObjetivo = ?";
            comando = conexion.prepareStatement(query);
            comando.setString(1, objetivoActualizado.getMeta());
            comando.setInt(2, objetivoActualizado.getId());
            comando.execute();
            
            query = "update objetivo set objetivo = ? where idObjetivo = ?";
            comando = conexion.prepareStatement(query);
            comando.setString(1, objetivoActualizado.getTextObjetivo());
            comando.setInt(2, objetivoActualizado.getId());
            comando.execute();
            
        }catch(SQLException ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }
    
}
