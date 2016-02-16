/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Local;
import model.Eproductiva;

/**
 *
 * @author andres
 */
@Local
public interface EproductivaFacadeLocal {

    void create(Eproductiva eproductiva);

    void edit(Eproductiva eproductiva);

    void remove(Eproductiva eproductiva);

    Eproductiva find(Object id);

    List<Eproductiva> findAll();

    List<Eproductiva> findRange(int[] range);

    int count();
    
}
