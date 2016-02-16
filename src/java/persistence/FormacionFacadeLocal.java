/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Formacion;

/**
 *
 * @author andres
 */
@Local
public interface FormacionFacadeLocal {

    void create(Formacion formacion);

    void edit(Formacion formacion);

    void remove(Formacion formacion);

    Formacion find(Object id);

    List<Formacion> findAll();

    List<Formacion> findRange(int[] range);

    int count();
    
}
