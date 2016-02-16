/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Tipoambiente;

/**
 *
 * @author andres
 */
@Local
public interface TipoambienteFacadeLocal {

    void create(Tipoambiente tipoambiente);

    void edit(Tipoambiente tipoambiente);

    void remove(Tipoambiente tipoambiente);

    Tipoambiente find(Object id);

    List<Tipoambiente> findAll();

    List<Tipoambiente> findRange(int[] range);

    int count();
    
}
