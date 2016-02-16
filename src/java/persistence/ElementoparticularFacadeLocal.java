/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Elementoparticular;

/**
 *
 * @author andres
 */
@Local
public interface ElementoparticularFacadeLocal {

    void create(Elementoparticular elementoparticular);

    void edit(Elementoparticular elementoparticular);

    void remove(Elementoparticular elementoparticular);

    Elementoparticular find(Object id);

    List<Elementoparticular> findAll();

    List<Elementoparticular> findRange(int[] range);

    int count();
    
}
