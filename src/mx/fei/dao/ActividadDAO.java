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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mx.fei.database.DataBase;
import mx.fei.dominio.Actividad;

public class ActividadDAO implements IActividadDAO{
    
    private ArrayList<Actividad> listaActividades;
    private String query;
    private Connection conexion;
    
    public ActividadDAO(){}

    @Override
    public List<Actividad> obtenerActividades() {
        listaActividades = new ArrayList<>();
        query = "select * from actividad";
        conexion = DataBase.obtenerConexion();
        try{
            PreparedStatement comando = conexion.prepareStatement(query);
        }catch(SQLException ex){
            
        }
        
        return listaActividades;
    }

    @Override
    public Actividad obtenerActividad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarActividad(Actividad actividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarActividad(String idActividad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
