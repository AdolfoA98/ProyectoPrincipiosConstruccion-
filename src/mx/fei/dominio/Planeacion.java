/**
* Programa:    SGPA
* Clase:       Planeacion
* Nombre:      Primitio Cruz Hernandez
* Fecha:       25/05/2018
* Versión:     0.2
* Descripción: Atributos de la clase Planeacion 
*/

package mx.fei.domain;

public class Planeacion {
    private int unidad;
    private String temas, fechaInicio, fechaFin, tecnicaDesarrollo;
    protected Practica practica;
    
    public Planeacion(){
        practica=new Practica();
    }

    public void setUnidad(int unidadEntrada) {
        this.unidad = unidadEntrada;
    }
    
    public int getUnidad() {
        return unidad;
    }

    public void setTemas(String temasEntrada) {
        this.temas = temasEntrada;
    }
    
    public String getTemas() {
        return temas;
    }

    public void setFechaInicio(String fechaInicioEntrada) {
        this.fechaInicio = fechaInicioEntrada;
    }
    
    public String getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaFin(String fechaFinEntrada) {
        this.fechaFin = fechaFinEntrada;
    }
    
    public String getFechaFin() {
        return fechaFin;
    }

    public void setTecnicaDesarrollo(String tecnicaDesarrolloEntrada) {
        this.tecnicaDesarrollo = tecnicaDesarrolloEntrada;
    }
    
    public String getTecnicaDesarrollo() {
        return tecnicaDesarrollo;
    }     
}
