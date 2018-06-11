/**
* Programa:    SGPA
* Clase:       Docente
* Nombre:      Adolfo Angel de la Cruz Diaz
* Fecha:       16/04/2018
* Versión:     0.1
* Descripción: Clase que representa al Docente que es parte de una Academia.
*/
package mx.fei.dominio;

public class Docente {
    
    private int numeroPersonal;
    private String nombre;
    private String email;
    
    public Docente() {}
    
    public void setNumeroPersonal(int numeroPersonal){
        this.numeroPersonal = numeroPersonal;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getNumeroPersonal(){
        return numeroPersonal;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
}
