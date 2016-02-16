/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Regional;

/**
 *
 * @author andres
 */
@Local
public interface RegionalFacadeLocal {

    void create(Regional regional);

    void edit(Regional regional);

    void remove(Regional regional);

    Regional find(Object id);

    List<Regional> findAll();

    List<Regional> findRange(int[] range);

    int count();
    
}
