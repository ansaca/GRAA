/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Coformador;

/**
 *
 * @author andres
 */
@Local
public interface CoformadorFacadeLocal {

    void create(Coformador coformador);

    void edit(Coformador coformador);

    void remove(Coformador coformador);

    Coformador find(Object id);

    List<Coformador> findAll();

    List<Coformador> findRange(int[] range);

    int count();
    
}
