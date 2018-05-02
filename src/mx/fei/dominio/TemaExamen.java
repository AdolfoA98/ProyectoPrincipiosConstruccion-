/**
* Programa:    SGPA
* Clase:       TemaExamen
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa los temas de examen acordados en el Plan de Trabajo
*              de la Academia.
*/
package mx.fei.dominio;

public class TemaExamen {
    
    private String nombre;
    private String parcial;
    
    public TemaExamen(){}
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setParcial(String parcial){
        this.parcial = parcial;
    }
    
    public String getParcial(){
        return parcial;
    }
}
