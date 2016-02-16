/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Hablaidioma;

/**
 *
 * @author andres
 */
@Local
public interface HablaidiomaFacadeLocal {

    void create(Hablaidioma hablaidioma);

    void edit(Hablaidioma hablaidioma);

    void remove(Hablaidioma hablaidioma);

    Hablaidioma find(Object id);

    List<Hablaidioma> findAll();

    List<Hablaidioma> findRange(int[] range);

    int count();
    
}
