/**
* Programa:    SGPA
* Clase:       IObjetivoDAO
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       05/05/2018
* Versión:     0.1
* Descripción: Interfaz de la clase ObjetivoDAo pertenciente al patrón
*              Data Access Objetct.
*/
package mx.fei.dao;

import java.util.List;
import mx.fei.dominio.Objetivo;

public interface IObjetivoDAO {
    
    List<Objetivo> obtenerObjetivos();
    boolean agregarObjetivo(Objetivo objetivo);
    boolean eliminarObjetivo(int idObjetivo);
    boolean actualizarObjetivos(List<Objetivo> listaObjetivosActualizada);
    boolean actualizarObjetivo(Objetivo objetivoActualizado);
}
