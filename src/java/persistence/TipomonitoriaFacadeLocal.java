/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Tipomonitoria;

/**
 *
 * @author andres
 */
@Local
public interface TipomonitoriaFacadeLocal {

    void create(Tipomonitoria tipomonitoria);

    void edit(Tipomonitoria tipomonitoria);

    void remove(Tipomonitoria tipomonitoria);

    Tipomonitoria find(Object id);

    List<Tipomonitoria> findAll();

    List<Tipomonitoria> findRange(int[] range);

    int count();
    
}
