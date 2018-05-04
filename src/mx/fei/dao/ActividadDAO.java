/**
* Programa:    SGPA
* Clase:       ActividadDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: 
*/
package mx.fei.dao;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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
        }catch(SQLException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        }
        
        return success;
    }

}
