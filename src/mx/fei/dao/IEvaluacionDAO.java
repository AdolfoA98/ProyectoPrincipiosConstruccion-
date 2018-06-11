
package mx.fei.dao;

import java.util.List;
import mx.fei.dominio.Evaluacion;

public interface IEvaluacionDAO {
    
    List<Evaluacion> obtenerEvaluaciones(int idPlanDeTrabajo);
    boolean agregarEvaluacion(Evaluacion evaluacion, int idPlanDeTrabajo);
    boolean eliminarEvaluacion(int idEvaluacion);
    boolean editarEvaluacion(Evaluacion evaluacion, int idPlanDeTrabajo);
    boolean actualizarEvaluaciones(List<Evaluacion> evaluaciones,int idPlanDeTrabajo);
}
