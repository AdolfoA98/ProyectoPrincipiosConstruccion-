/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.fei.dao;

import java.util.List;
import mx.fei.dominio.GeneradorClave;
import mx.fei.dominio.Objetivo;
import mx.fei.excepcion.TablaNoEncontradaException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adolf
 */
public class ObjetivoDAOTest {
    
    private static final Logger logger = LogManager.getLogger(GeneradorClave.class);
    private ObjetivoDAO objetivoDao;
    
    public ObjetivoDAOTest() {
        objetivoDao = new ObjetivoDAO();
    }
    
    @Test
    public void obtenerObjetivos(){
        
        List<Objetivo> listaObjetivos = objetivoDao.obtenerObjetivos();
        
        int numObjetivosActual = listaObjetivos.size();
        int numObjetivosEsperados = 3;
        
        assertEquals("Prueba número de objetivos en la BD", numObjetivosEsperados, numObjetivosActual);
    }
    
    @Test
    public void pruebaAgregarObjetivo(){
        
        Objetivo objetivo = new Objetivo();
        
        int id = 15;
        
        try{
            id = GeneradorClave.obtenerId("Actividad");
        }catch(TablaNoEncontradaException ex){
            logger.error("La tabla introducida no existe en la base de datos");
        }
        
        objetivo.setId(id);
        objetivo.setTextoObjetivo("Introducir al alumno a los aspectos básicos de la programación orientada a objetos");
        objetivo.setMeta("Que el alumno comprenda y codifique de manera eficiente código orientado a objetos");
        
        objetivoDao.agregarObjetivo(objetivo, 567890);
        
        List<Objetivo> listaObjetivos = objetivoDao.obtenerObjetivos();
        
        int tamanoActual = listaObjetivos.size();
        
        assertEquals("Prueba agregar objetivo", 3, tamanoActual);
    }
    
    @Test
    public void pruebaEliminarObjetivo(){
        
        List<Objetivo> listaObjetivos = objetivoDao.obtenerObjetivos();
        
        int tamanoListaAnterior = listaObjetivos.size();
        
        objetivoDao.eliminarObjetivo(listaObjetivos.get(0));
        
        listaObjetivos = objetivoDao.obtenerObjetivos();
        
        int tamanoActual = listaObjetivos.size();
        
        assertEquals("Prueba eliminsar objetivo", tamanoListaAnterior - 1, tamanoActual);
    }
    
}
