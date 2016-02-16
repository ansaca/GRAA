/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Asignafichas;

/**
 *
 * @author andres
 */
@Local
public interface AsignafichasFacadeLocal {

    void create(Asignafichas asignafichas);

    void edit(Asignafichas asignafichas);

    void remove(Asignafichas asignafichas);

    Asignafichas find(Object id);

    List<Asignafichas> findAll();

    List<Asignafichas> findRange(int[] range);

    int count();
    
}
