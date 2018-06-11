/**
* Programa:    SGPA
* Clase:       ActividadDAOTest
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase Test de la clase ActividadDAO.
*/
package mx.fei.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import mx.fei.dominio.Actividad;
import mx.fei.dominio.GeneradorClave;
import mx.fei.excepcion.TablaNoEncontradaException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

public class ActividadDAOTest {
    
    private static final Logger logger = LogManager.getLogger(GeneradorClave.class);
    
    private List<Actividad> listaActividades = new ArrayList<>();
    private ActividadDAO actividadDAO = new ActividadDAO();
    private int primerId = obtenerId();
    private int segundoId = obtenerId();
    
    public ActividadDAOTest() {
        Actividad actividad1 = new Actividad();
        actividad1.setId(primerId);
        actividad1.setNombre("Smell Code");
        actividad1.setFecha(new Date(System.currentTimeMillis()));
        actividad1.setFormaDeOperar("Reporte de lectura del texto Smell Code");
        
        Actividad actividad2 = new Actividad();
        actividad2.setId(segundoId);
        actividad2.setNombre("Secure Code");
        actividad2.setFecha(new Date(System.currentTimeMillis()));
        actividad2.setFormaDeOperar("Reporte de lectura del texto Secure Code");
        
        listaActividades.add(actividad1);
        listaActividades.add(actividad2);
    }
    
    private int obtenerId(){
        int id = 15;
        
        try{
            id = GeneradorClave.obtenerId("Actividad");
        }catch(TablaNoEncontradaException ex){
            logger.error("La tabla introducida no existe en la base de datos");
        }
        
        return id;
    }
    
    /*
    *   Funciones Test del método agregar contacto.
    */
    @Test
    public void pruebaAgregarActividad(){
        
        boolean success = false;
        
        for(int i = 0; i < listaActividades.size(); i++){
            actividadDAO.agregarActividad(listaActividades.get(i), 123456);
        }
        
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        
        for(int j = 0; j < actividades.size(); j++){
            if(actividades.get(j).getId() == primerId){
                success = true;
            }
        }
        
        if(success == true){
            success = false;
            for(int j = 0; j < actividades.size(); j++){
                if(actividades.get(j).getId() == segundoId){
                    success = true;
                }
            }
        }
        
        assertEquals("Verifica si actividad ha sido agregada correctamente", true, success);
    }
    
    //Funiones Test del método obtenerActividades de la clase Actividad
    @Test
    public void pruebaCantidadActividades(){
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        
        assertEquals("Cantidad de Actividades en la BD", 6, actividades.size());
    }
    
    @Test
    public void pruebaEliminarActividad(){
        
        boolean success = true;
        
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        int idEliminado = actividades.get(0).getId();
        actividadDAO.eliminarActividad(idEliminado);
        
        actividades = actividadDAO.obtenerActividades(123456);
        
        for(int i = 0; i < actividades.size(); i++){
            if(actividades.get(i).getId() == idEliminado){
                success = false;
            }
        }
        
        assertEquals("Verifica si la actividad fue eliminada", true, success);
    }
    
    @Test
    public void pruebaEditarActividad(){
        
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        
        //String nombreActualizado = "Conferencia DAO Pattern";
        String formaActualizada ="Conferencia en auditorio de la faculta";
        
        Actividad actividadActualizada = actividades.get(actividades.size() - 1);
        //actividadActualizada.setNombre(nombreActualizado);
        actividadActualizada.setFormaDeOperar(formaActualizada);
        
        actividadDAO.editarActividad(actividadActualizada, 123456);
        
        actividades = actividadDAO.obtenerActividades(123456);
        
        //String nombreActual = actividades.get(actividades.size() - 1).getNombre();
        String formaActual = actividades.get(actividades.size() - 1).getFormaDeOperar();
        
        assertEquals("Prueba para editaractividad", formaActualizada, formaActual);
    }
    
}
