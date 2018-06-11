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

import java.sql.Date;

public class PlanDeTrabajo {
    
    private String nombre; 
    private Date fechaAprobacion;
    private String objetivoGeneral;
    private Date fechaCreacion;
    
    public PlanDeTrabajo(){}
    
    public void setFechaAprobacion(Date fechaAprobacion){
        this.fechaAprobacion = fechaAprobacion;
    }
    
    public Date getFechaAprobacion(){
        return fechaAprobacion;
    }
    
    public void setObjetivoGeneral(String objetivoGeneral){
        this.objetivoGeneral = objetivoGeneral;
    }
    
    public String getObjetivoGeneral(){
        return objetivoGeneral;
    }
}
