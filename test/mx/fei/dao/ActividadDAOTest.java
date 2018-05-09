/**
* Programa:    SGPA
* Clase:       ActividadDAOTest
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase Test de la clase ActividadDAO.
*/
package mx.fei.dao;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import mx.fei.dominio.Actividad;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.dominio.GeneradorClave;
import mx.fei.excepcion.TablaNoEncontradaException;

public class ActividadDAOTest {
    
    private List<Actividad> listaActividades = new ArrayList<>();
    private ActividadDAO actividadDAO = new ActividadDAO();
    private int primerId = obtenerId();
    private int segundoId = obtenerId();
    
    public ActividadDAOTest() {
        Actividad actividad1 = new Actividad();
        actividad1.setId(primerId);
        actividad1.setNombre("Smell Code");
        actividad1.setFecha("28/03/2018");
        actividad1.setFormaDeOperar("Reporte de lectura del texto Smell Code");
        
        Actividad actividad2 = new Actividad();
        actividad2.setId(segundoId);
        actividad2.setNombre("Secure Code");
        actividad2.setFecha("20/03/2018");
        actividad2.setFormaDeOperar("Reporte de lectura del texto Secure Code");
        
        listaActividades.add(actividad1);
        listaActividades.add(actividad2);
    }
    
    private int obtenerId(){
        int id = 15;
        
        try{
            id = GeneradorClave.obtenerId("Actividad");
        }catch(TablaNoEncontradaException ex){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    /*
    *   Funciones Test del método agregar contacto.
    */
    @Test
    public void pruebaAgregarContacto(){
        
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
    
}
