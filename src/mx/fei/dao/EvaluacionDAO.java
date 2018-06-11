/**
* Programa:    SGPA
* Clase:       EvaluacionDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       14/05/2018
* Versión:     0.1
* Descripción: Clase que maneja la información de la clase Evaluacion. Forma parte del Patrón DAO.
*/
package mx.fei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.fei.database.DataBase;
import mx.fei.dominio.Evaluacion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EvaluacionDAO implements IEvaluacionDAO{
    
    private Logger logger = LogManager.getLogger(EvaluacionDAO.class);
    
    private List<Evaluacion> listaEvaluaciones;
    private Connection conexion;
    private String query;
    
    @Override
    public List<Evaluacion> obtenerEvaluaciones(int idPlanDeTrabajo) {
        listaEvaluaciones = new ArrayList<>();
        
        conexion = DataBase.obtenerConexion();
        query = "select * from evaluacion where idPlanDeTrabajo = ?";
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idPlanDeTrabajo);
            ResultSet tablaSql = comando.executeQuery();
            
            while(tablaSql.next()){
                Evaluacion evaluacion = new Evaluacion();
                
                evaluacion.setElemento(tablaSql.getString("elemento"));
                evaluacion.setPorcentaje(tablaSql.getFloat("porcentaje"));
                
                listaEvaluaciones.add(evaluacion);
            }
        }catch(SQLException ex){
            logger.error("Error al obtener evaluaciones. " + ex.getMessage());
        }
        
        return listaEvaluaciones;
    }

    @Override
    public boolean agregarEvaluacion(Evaluacion evaluacion, int idPlanDeTrabajo) {
        
        boolean success = true;
        
        if(evaluacion == null){
            return false;
        }
        
        conexion = DataBase.obtenerConexion();
        query = "Insert into evaluacion values (?, ?, ?, ?)";
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, evaluacion.getId());
            comando.setInt(2, idPlanDeTrabajo);
            comando.setString(3, evaluacion.getElemento());
            comando.setFloat(4, evaluacion.getPorcentaje());
            comando.execute();
        }catch(SQLException ex){
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean eliminarEvaluacion(int idEvaluacion) {
        
        boolean success = true;
        
        conexion = DataBase.obtenerConexion();
        query = "delete from evaluacion where idEvaluacion = ?";
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idEvaluacion);
            comando.execute();
        }catch(SQLException ex){
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean editarEvaluacion(Evaluacion evaluacion, int idPlanDeTrabajo) {
        
        boolean success = true;
        
        conexion = DataBase.obtenerConexion();
        
        try{
            query = "update evaluacion set idPlanDeTrabajo = ? where idEvaluacion = ?";
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idPlanDeTrabajo);
            comando.setInt(2, evaluacion.getId());
            
            query = "update evaluacion set elemento = ? where idEvaluacion = ?";
            comando = conexion.prepareStatement(query);
            comando.setString(1, evaluacion.getElemento());
            comando.setInt(2, evaluacion.getId());
            
            query = "update evaluacion set porcentaje = ? where idEvaluacion = ?";
            comando = conexion.prepareStatement(query);
            comando.setFloat(1, evaluacion.getPorcentaje());
            comando.setInt(2, evaluacion.getId());
        }catch(SQLException ex){
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean actualizarEvaluaciones(List<Evaluacion> evaluaciones, int idPlanDeTrabajo) {
        
        List<Evaluacion> listaAActualizar = new ArrayList<>();
        
        if(listaEvaluaciones == null){
            obtenerEvaluaciones(idPlanDeTrabajo);
        }
        
        for(int i = 0; i < evaluaciones.size(); i++){
            for(int j = 0; j < listaEvaluaciones.size(); j++){
                if(evaluaciones.get(i).getId() == listaEvaluaciones.get(j).getId()){
                    listaAActualizar.add(evaluaciones.get(i));
                    evaluaciones.remove(i);
                    listaEvaluaciones.remove(j);
                }
            }
        }
        
        for(int i = 0; i < listaAActualizar.size(); i++){
            editarEvaluacion(listaAActualizar.get(i), idPlanDeTrabajo);
        }
        
        for(int i = 0; i < listaEvaluaciones.size(); i++){
            eliminarEvaluacion(listaEvaluaciones.get(i).getId());
        }
        
        for(int i = 0; i < evaluaciones.size(); i++){
            agregarEvaluacion(evaluaciones.get(i), idPlanDeTrabajo);
        }
        
        listaEvaluaciones.clear();
        obtenerEvaluaciones(idPlanDeTrabajo);
        
        
        return true;
    }
    
}
