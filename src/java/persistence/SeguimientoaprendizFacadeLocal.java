/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Seguimientoaprendiz;

/**
 *
 * @author andres
 */
@Local
public interface SeguimientoaprendizFacadeLocal {

    void create(Seguimientoaprendiz seguimientoaprendiz);

    void edit(Seguimientoaprendiz seguimientoaprendiz);

    void remove(Seguimientoaprendiz seguimientoaprendiz);

    Seguimientoaprendiz find(Object id);

    List<Seguimientoaprendiz> findAll();

    List<Seguimientoaprendiz> findRange(int[] range);

    int count();
    
}
