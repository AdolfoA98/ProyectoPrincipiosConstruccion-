/**
* Programa:    SGPA
* Clase:       PlanDeTrabajo
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa el formato de documento de Plan de Trabajo
*              de una Academia.
*/
package mx.fei.dominio;

import java.util.List;

public class PlanDeTrabajo {
    
    private String fechaAprobacion;
    private String objetivoGeneral;
    private List<Objetivo> objetivos;
    private List<TemaExamen> temasDeExamen;
    private List<Evaluacion> evaluaciones;
    
    public PlanDeTrabajo(){}
    
    public void setFechaAprobacion(String fechaAprobacion){
        this.fechaAprobacion = fechaAprobacion;
    }
    
    public String getFechaAprobacion(){
        return fechaAprobacion;
    }
    
    public void setObjetivoGeneral(String objetivoGeneral){
        this.objetivoGeneral = objetivoGeneral;
    }
    
    public String getObjetivoGeneral(){
        return objetivoGeneral;
    }
    
    public void setObjetivos(List<Objetivo> objetivos){
        this.objetivos = objetivos;
    }
    
    public List<Objetivo> getObjetivos(){
        return objetivos;
    }
    
    public void setTemasDeExamen(List<TemaExamen> temasDeExamen){
        this.temasDeExamen = temasDeExamen;
    }
    
    public List<TemaExamen> getTemasDeExamen(){
        return temasDeExamen;
    }
    
    public void setEvaluacion(List<Evaluacion> evaluaciones){
        this.evaluaciones = evaluaciones;
    }
    
    public List<Evaluacion> getEvaluaciones(){
        return evaluaciones;
    }
}
