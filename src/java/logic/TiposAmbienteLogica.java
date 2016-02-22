/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Sede;
import model.Tipoambiente;
import persistence.SedeFacadeLocal;
import persistence.TipoambienteFacadeLocal;

/**
 *
 * @author G40-80
 */
@Stateless
public class TiposAmbienteLogica implements TiposAmbienteLogicaLocal {

     @EJB
   private TipoambienteFacadeLocal tipoAmbienteDao;
    
    @Override
    public void crear(Tipoambiente tipoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Tipoambiente tipoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Tipoambiente tipoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sede consultarCodigo(Integer idTipoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tipoambiente> consultarTodo() throws Exception {
        return tipoAmbienteDao.findAll();
    }

  

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
