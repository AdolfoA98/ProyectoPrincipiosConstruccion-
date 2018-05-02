/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgpa;

import mx.fei.dao.ActividadDAO;

public class SGPA
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ActividadDAO actividadDao = new ActividadDAO();
        
        actividadDao.obtenerActividades(123456);
    }
    
}
