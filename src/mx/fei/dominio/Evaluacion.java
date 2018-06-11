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
    
    private int id;
    private String elemento;
    private float porcentaje;
    
    public Evaluacion(){}
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setElemento(String elemento){
        this.elemento = elemento;
    }
    
    public String getElemento(){
        return elemento;
    }
    
    public void setPorcentaje(float porcentaje){
        this.porcentaje = porcentaje;
    }
    
    public float getPorcentaje(){
        return porcentaje;
    }
}
