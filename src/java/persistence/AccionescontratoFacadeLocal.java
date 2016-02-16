/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Accionescontrato;

/**
 *
 * @author andres
 */
@Local
public interface AccionescontratoFacadeLocal {

    void create(Accionescontrato accionescontrato);

    void edit(Accionescontrato accionescontrato);

    void remove(Accionescontrato accionescontrato);

    Accionescontrato find(Object id);

    List<Accionescontrato> findAll();

    List<Accionescontrato> findRange(int[] range);

    int count();
    
}
