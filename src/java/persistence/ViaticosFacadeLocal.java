/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Viaticos;

/**
 *
 * @author andres
 */
@Local
public interface ViaticosFacadeLocal {

    void create(Viaticos viaticos);

    void edit(Viaticos viaticos);

    void remove(Viaticos viaticos);

    Viaticos find(Object id);

    List<Viaticos> findAll();

    List<Viaticos> findRange(int[] range);

    int count();
    
}
