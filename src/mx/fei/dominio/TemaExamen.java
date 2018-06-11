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
    
    private String parcial;
    private String temas;
    
    public TemaExamen(){}
    
    public void setTemas(String temas){
        this.temas = temas;
    }
    
    public String getTemas(){
        return temas;
    }
    
    public void setParcial(String parcial){
        this.parcial = parcial;
    }
    
    public String getParcial(){
        return parcial;
    }
}
