/**
* Programa:    SGPA
* Clase:       PlanCurso
* Nombre:      Primitio Cruz Hernandez
* Fecha:       10/05/2018
* Versión:     0.2
* Descripción: Atributos de la clase Plan de curso
*/

package mx.fei.domain;

public class PlanCurso {
    private int claveNrc;
    private String experienciaEducativa, peridoEducativo, bloque, seccion, academico, periodo, objetivoGeneral;
    protected Planeacion planeacion;
    
    public PlanCurso(){
        planeacion=new Planeacion();
    }

    public void setClaveNrc(int claveNrcEntrada) {
        this.claveNrc = claveNrcEntrada;
    }
    
    public int getClaveNrc() {
        return claveNrc;
    }

    public void setExperienciaEducativa(String experienciaEducativaEntrada) {
        this.experienciaEducativa = experienciaEducativaEntrada;
    }
    
    public String getExperienciaEducativa() {
        return experienciaEducativa;
    }

    public void setPeriodoEducativo(String periodoEducativoEntrada) {
        this.peridoEducativo = periodoEducativoEntrada;
    }
    
    public String getPeriodoEducativo() {
        return peridoEducativo;
    }
    
    public void setBloque(String bloqueEntrada) {
        this.bloque = bloqueEntrada;
    }
    
    public String getBloque() {
        return bloque;
    }

    public void setSeccion(String seccionEntrada) {
        this.seccion = seccionEntrada;
    }
    
    public String getSeccion() {
        return seccion;
    }   
    
    public void setAcademico(String academicoEntrada) {
        this.academico = academicoEntrada;
    }
    
    public String getAcademico() {
        return academico;
    }   
    
    public void setPeriodo(String periodoEntrada) {
        this.periodo = periodoEntrada;
    }
    
    public String getPeriodo() {
        return periodo;
    }   
    
    public void setObjetivoGeneral(String objetivoGeneralEntrada) {
        this.objetivoGeneral = objetivoGeneralEntrada;
    }
    
    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }   
}
