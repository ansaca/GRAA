/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Reservaambiente;

/**
 *
 * @author andres
 */
@Local
public interface ReservaambienteFacadeLocal {

    void create(Reservaambiente reservaambiente);

    void edit(Reservaambiente reservaambiente);

    void remove(Reservaambiente reservaambiente);

    Reservaambiente find(Object id);

    List<Reservaambiente> findAll();

    List<Reservaambiente> findRange(int[] range);

    int count();
    
}
