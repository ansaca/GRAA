/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Seguimiento;

/**
 *
 * @author andres
 */
@Local
public interface SeguimientoFacadeLocal {

    void create(Seguimiento seguimiento);

    void edit(Seguimiento seguimiento);

    void remove(Seguimiento seguimiento);

    Seguimiento find(Object id);

    List<Seguimiento> findAll();

    List<Seguimiento> findRange(int[] range);

    int count();
    
}
