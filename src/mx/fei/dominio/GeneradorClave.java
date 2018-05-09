
package mx.fei.dominio;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.dao.ActividadDAO;
import mx.fei.database.DataBase;
import mx.fei.excepcion.TablaNoEncontradaException;

public class GeneradorClave {
    
    private static int clave = -1;;
        
    public static int obtenerId(String tabla) throws TablaNoEncontradaException {
        
        SecureRandom llave;
        
        try{
            llave = SecureRandom.getInstance("SHA1PRNG");
            clave = llave.nextInt(500000);
            
            while(haSidoUsada(clave, tabla)){
                clave = llave.nextInt(500000);
            }
        }catch(NoSuchAlgorithmException ex){
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clave;
    }
    
    private static boolean haSidoUsada(int clave, String tabla) throws TablaNoEncontradaException{
        
        boolean estaEnTabla = false;
        
        Connection conexion = DataBase.obtenerConexion();
        String query = "";
        
        tabla = tabla.toLowerCase();
        
        switch(tabla){
            case "academia": query = "select idAcademia from academia";
            break;
            case "actividad": query = "select idActividad from actividad";
            break;
            case "avance": query = "select idAvance from avance";
            break;
            case "avance_programatico": query = "select idAvance from avance_programatico";
            break;
            case "bibliografia": query = "select idBibliografia from bibliografia";
            break;
            case "calendario_evaluacion": query = "select idCalendario from calendario_evaluacion";
            break;
            case "coordinador": query = "select numeroPersonal from coordinador";
            break;
            case "curso": query = "select iCurso from curso";
            break;
            case "docente": query = "select numeroPersonal from docente";
            break;
            case "ee": query = "select idExperiencia from ee";
            break;
            case "evaluacion": query = "select idEvaluacion from evaluacion";
            break;
            case "objetivo": query = "select idObjetivo from objetivo";
            break;
            case "participa_plandetrabajo": query = "select idParticipacion from participa_plandetrabajo";
            break;
            case "pe": query = "select iProgramEdu from pe";
            break;
            case "plan_de_curso": query = "select idPlan from plan_de_curso";
            break;
            case "plan_de_trabajo": query = "select idPlanDeTrabajo from plan_de_trabajo";
            break;
            case "planeacion": query = "select idPlaneacion from planeacion";
            break;
            case "reporte_coordinador": query = "select idReporteCoordinador from reporte_coordinador";
            break;
            case "tema": query = "select idTema from tema";
            break;
            case "temas_examen": query = "select idTemaExam from temas_examen";
            break;
            case "unidad": query = "select idUnidad from unidad";
            break;
            default: throw new TablaNoEncontradaException("La tabla " + tabla + " no exite la base de datos");
        }
        
        try{
           PreparedStatement comando = conexion.prepareStatement(query);
           ResultSet tablaSQL = comando.executeQuery();
           
           while(tablaSQL.next()){
               if(tablaSQL.getInt(1) == clave){
                   estaEnTabla = true;
               }
           }
        }catch(SQLException ex){
            Logger.getLogger(GeneradorClave.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estaEnTabla;
    }
    
    public GeneradorClave(){}
    
}

