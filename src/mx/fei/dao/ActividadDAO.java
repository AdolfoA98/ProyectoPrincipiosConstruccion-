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
                actividad.setFecha(tablaSQL.getString("fecha"));
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
        String fecha = actividad.getFecha();
        String formaDeOperar = actividad.getFormaDeOperar();
        
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
            comando.setInt(1, id);
            comando.setInt(2, idObjetivo);
            comando.setString(3, nombre);
            comando.setString(4, fecha);
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
        
        String informacionActividad[] = new String[4];
        informacionActividad[0] = Integer.toString(idObjetivo);
        informacionActividad[1] = actividadActualizada.getNombre();
        informacionActividad[2] = actividadActualizada.getFecha();
        informacionActividad[3] = actividadActualizada.getFormaDeOperar();
        
        boolean success = true;
        conexion = DataBase.obtenerConexion();
        
        try{
            for(int i = 0; i < 4; i++){
                query = getColumnaQuery(i);
                PreparedStatement comando = conexion.prepareStatement(query);
                if(i == 0){
                    comando.setInt(1, Integer.parseInt(informacionActividad[i]));
                }else{
                    comando.setString(1, informacionActividad[i]);
                }
                
                comando.setInt(2, actividadActualizada.getId());
                comando.execute();
            }
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        }finally{
            DataBase.cerrarConexion();
        }
        
        return success;
    }
    
    private String getColumnaQuery(int columna){
        
        String query = "";
        
        switch(columna){
            case 0: query = "update actividad set idObjetivo = ? where idActividad = ?";
            break;
            case 1: query = "update actividad set nombre = ? where idActividad = ?";
            break;
            case 2: query = "update actividad set fecha = ? where idActividad = ?";
            break;
            case 3: query = "update actividad set forma_operar = ? where idActividad = ?";
            break;
        }
        
        return query;
    } 

}
