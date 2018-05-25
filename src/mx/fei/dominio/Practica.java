/**
* Programa:    SGPA
* Clase:       Planeacion
* Nombre:      Primitio Cruz Hernandez
* Fecha:       25/05/2018
* Versión:     0.1
* Descripción: Atributos de la clase Practica
*/

package mx.fei.domain;

public class Practica {
    private int numeroActividad;
    private String descripcion;
    
    Practica(){
    }
    
    public void setNumeroActividad(int numeroActividadEntrada) {
        this.numeroActividad = numeroActividadEntrada;
    }
    
    public int getNumeroActividad() {
        return numeroActividad;
    }

    public void setDescripcion(String descripcionEntrada) {
        this.descripcion = descripcionEntrada;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
