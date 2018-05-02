/**
* Programa:    SGPA
* Clase:       Evaluacion
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa el método de evaluación especificado en el Plan de Trabajo
*              de la Academia.
*/

package mx.fei.dominio;

public class Evaluacion {
    
    private String elemento;
    private double porcentaje;
    
    public Evaluacion(){}
    
    public void setElemento(String elemento){
        this.elemento = elemento;
    }
    
    public String getElemento(){
        return elemento;
    }
    
    public void setPorcentaje(double porcentaje){
        this.porcentaje = porcentaje;
    }
    
    public double getPorcentaje(){
        return porcentaje;
    }
}
