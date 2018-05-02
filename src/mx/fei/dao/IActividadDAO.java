/**
* Programa:    SGPA
* Clase:       IActividadDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: .
*/
package mx.fei.dao;

import java.util.List;
import mx.fei.dominio.Actividad;

public interface IActividadDAO{
    
    List<Actividad> obtenerActividades(int idObjetivo);
    boolean agregarActividad(Actividad actividad, int idObjetivo);
    boolean eliminarActividad(int idActividad);
    
}
