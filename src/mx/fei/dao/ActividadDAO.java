/**
* Programa:    SGPA
* Clase:       ActividadDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: 
*/
package mx.fei.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.database.DataBase;
import mx.fei.dominio.Actividad;

public class ActividadDAO implements IActividadDAO{
    
    private ArrayList<Actividad> listaActividades;
    private String query;
    private Connection conexion;
    
    public ActividadDAO(){}

    @Override
    public List<Actividad> obtenerActividades(int idObjetivo) {
        
        listaActividades = new ArrayList<>();
        query = "select * from actividad where idObjetivo = ?";
        conexion = DataBase.obtenerConexion();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idObjetivo);
            ResultSet tablaSQL = comando.executeQuery();
            while(tablaSQL.next()){
                Actividad actividad = new Actividad();
                actividad.setId(tablaSQL.getInt("idActividad"));
                actividad.setNombre(tablaSQL.getString("nombre"));
                actividad.setFecha(tablaSQL.getDate("fecha"));
                actividad.setFormaDeOperar(tablaSQL.getString("forma_operar"));
                listaActividades.add(actividad);
            }
            conexion.close();
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return listaActividades;
    }

    @Override
    public boolean agregarActividad(Actividad actividad, int idObjetivo) {
        
        boolean success = false;
        query = "insert into actividad values (?, ?, ?, ?, ?)";
        conexion = DataBase.obtenerConexion();
        
        int id = actividad.getId();
        String nombre = actividad.getNombre();
        Date fecha = actividad.getFecha();
        String formaDeOperar = actividad.getFormaDeOperar();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, id);
            comando.setInt(2, idObjetivo);
            comando.setString(3, nombre);
            comando.setDate(4, fecha);
            comando.setString(5, formaDeOperar);
            success = comando.execute();
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean eliminarActividad(int idActividad) {
        
        boolean success = false;
        conexion = DataBase.obtenerConexion();
        query = "delete from actividad where idActividad = ?";
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idActividad);
            success = comando.execute();
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

    @Override
    public boolean editarActividad(Actividad actividadActualizada, int idObjetivo) {
        
        boolean success = true;
        conexion = DataBase.obtenerConexion();
        
        try{
            query = "update actividad set idObjetivo = ? where idActividad = ?";
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, idObjetivo);
            comando.setInt(2, actividadActualizada.getId());
            comando.execute();
            
            query = "update actividad set nombre = ? where idActividad = ?";
            comando = conexion.prepareStatement(query);
            comando.setString(1, actividadActualizada.getNombre());
            comando.setInt(2, actividadActualizada.getId());
            comando.execute();
            
            query = "update actividad set fecha = ? where idActividad = ?";
            comando = conexion.prepareStatement(query);
            comando.setDate(1, actividadActualizada.getFecha());
            comando.setInt(2, actividadActualizada.getId());
            comando.execute();
            
            query = "update actividad set forma_operar = ? where idActividad = ?";
            comando = conexion.prepareStatement(query);
            comando.setString(1, actividadActualizada.getFormaDeOperar());
            comando.setInt(2, actividadActualizada.getId());
            comando.execute();
            
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }

}
