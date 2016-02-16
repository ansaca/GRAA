/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Tipopractica;

/**
 *
 * @author andres
 */
@Local
public interface TipopracticaFacadeLocal {

    void create(Tipopractica tipopractica);

    void edit(Tipopractica tipopractica);

    void remove(Tipopractica tipopractica);

    Tipopractica find(Object id);

    List<Tipopractica> findAll();

    List<Tipopractica> findRange(int[] range);

    int count();
    
}
