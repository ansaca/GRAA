/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Reservaambiente;

/**
 *
 * @author andres
 */
@Stateless
public class ReservaambienteFacade extends AbstractFacade<Reservaambiente> implements ReservaambienteFacadeLocal {
    @PersistenceContext(unitName = "Proyecto12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaambienteFacade() {
        super(Reservaambiente.class);
    }

    @Override
    public List<Reservaambiente> findxIdAmbiente(Integer ambiente) {
        String consulta = "select r from Reservaambiente r where r.codigoambiente.codigoambiente="+ambiente;
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }
    
}
