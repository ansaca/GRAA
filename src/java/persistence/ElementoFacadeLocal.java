/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Elemento;

/**
 *
 * @author andres
 */
@Local
public interface ElementoFacadeLocal {

    void create(Elemento elemento);

    void edit(Elemento elemento);

    void remove(Elemento elemento);

    Elemento find(Object id);

    List<Elemento> findAll();

    List<Elemento> findRange(int[] range);

    int count();
    
}
