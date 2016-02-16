/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Criterio;

/**
 *
 * @author andres
 */
@Stateless
public class CriterioFacade extends AbstractFacade<Criterio> implements CriterioFacadeLocal {
    @PersistenceContext(unitName = "Proyecto12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriterioFacade() {
        super(Criterio.class);
    }
    
}
