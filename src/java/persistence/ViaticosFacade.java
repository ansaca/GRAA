/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Viaticos;

/**
 *
 * @author andres
 */
@Stateless
public class ViaticosFacade extends AbstractFacade<Viaticos> implements ViaticosFacadeLocal {
    @PersistenceContext(unitName = "Proyecto12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViaticosFacade() {
        super(Viaticos.class);
    }
    
}
