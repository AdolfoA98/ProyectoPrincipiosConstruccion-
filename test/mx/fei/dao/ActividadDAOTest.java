/**
* Programa:    SGPA
* Clase:       ActividadDAOTest
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase Test de la clase ActividadDAO.
*/
package mx.fei.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import mx.fei.dominio.Actividad;
import java.util.List;

public class ActividadDAOTest {
    
    ActividadDAO actividadDAO = new ActividadDAO();
    
    public ActividadDAOTest() {
    }
    
    //Funiones Test del método obtenerActividades de la clase Actividad
    @Test
    public void pruebaCantidadActividades(){
        int numeroActividades = 2;
        
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        
        assertEquals("Catidad de Actividades en la BD", numeroActividades, actividades.size());
    }
    
    @Test
    public void pruebaInformacionActividades(){
        int idEsperado = 12345;
        
        List<Actividad> actividades = actividadDAO.obtenerActividades(123456);
        
        int idObtenido = actividades.get(0).getId();
        
        assertEquals("Verifica ID de actividades", idEsperado, idObtenido);
    }
}
