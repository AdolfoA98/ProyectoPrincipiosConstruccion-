package mx.fei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.datasource.DataBase;
import mx.fei.domain.PlanCurso;
import mx.fei.gui.PlanCurso_GUI;

public class PlanCursoDAO{
    private String query;
    private Connection coneccion;
    DataBase db;
    PlanCurso_GUI plancurso_gui;
    
    public void agregaPlanCurso(PlanCurso plancurso){
        db=new DataBase();
        coneccion=db.getDataBaseConnection();
        query="INSERT INTO plan_de_curso (experienciaEducativa, periodo_educativo, bloque, seccion, academico, periodo, objetivo_general)"
            + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=coneccion.prepareStatement(query);
            ps.setString(1, plancurso.getExperienciaEducativa());
            ps.setString(2, plancurso.getPeriodoEducativo());
            ps.setString(3, plancurso.getBloque());
            ps.setString(4, plancurso.getSeccion());
            ps.setString(5, plancurso.getAcademico());
            ps.setString(6, plancurso.getPeriodo());
            ps.setString(7, plancurso.getObjetivoGeneral());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PlanCursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
