/**
* Programa:    SGPA
* Clase:       Actividad
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa las actividades de academia en un Plan de Trabajo.
*/
package mx.fei.dominio;

public class Actividad{
    
    private int id;
    private String nombre;
    private String fecha;
    private String formaDeOperar;
    
    public Actividad(){}
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFormaDeOperar(String formaDeOperar){
        this.formaDeOperar = formaDeOperar;
    }
    
    public String getFormaDeOperar(){
        return formaDeOperar;
    }
}
