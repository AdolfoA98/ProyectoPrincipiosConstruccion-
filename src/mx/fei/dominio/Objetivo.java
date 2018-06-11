/**
* Programa:    SGPA
* Clase:       Objetivo
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa un objetivo en un Plan de Trabajo.
*/

package mx.fei.dominio;

import java.util.List;

public class Objetivo {
    
    private int idObjetivo;
    private String objetivo;
    private String meta;
    private List<Actividad> actividades;
    
    public Objetivo(){}
    
    public void setId(int id){
        this.idObjetivo = id;
    }
    
    public int getId(){
        return idObjetivo;
    }
    
    public void setTextoObjetivo(String objetivo){
        this.objetivo = objetivo;
    }
    
    public String getTextObjetivo(){
        return objetivo;
    }
    
    public void setMeta(String meta){
        this.meta = meta;
    }
    
    public String getMeta(){
        return meta;
    }
    
    public void setActividades(List<Actividad> actividades){
        this.actividades = actividades;
    }
    
    public List<Actividad> getActividades(){
        return actividades;
    }
}
