/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Criterio;

/**
 *
 * @author andres
 */
@Local
public interface CriterioFacadeLocal {

    void create(Criterio criterio);

    void edit(Criterio criterio);

    void remove(Criterio criterio);

    Criterio find(Object id);

    List<Criterio> findAll();

    List<Criterio> findRange(int[] range);

    int count();
    
}
