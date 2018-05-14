package mx.fei.dao;

import java.util.List;
import mx.fei.domain.PlanCurso;

public interface IPlanCursoDAO {
    List<PlanCurso> buscaPlanCursoPorFecha(String fecha);
    //List<PlanCurso> buscaContactosPorCorreo(String fecha);
    public void agregaPlanCurso();
    boolean eliminaPlanCursoPorFecha(String fecha);
}
