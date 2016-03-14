/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Usodeambientes;
import persistence.SedeFacadeLocal;
import persistence.UsodeambientesFacadeLocal;

/**
 *
 * @author G40-80
 */
@Stateless
public class UsosAmbienteLogica implements UsosAmbienteLogicaLocal {
    
     @EJB
   private UsodeambientesFacadeLocal usoDao;

    @Override
    public void crear(Usodeambientes usoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Usodeambientes usoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usodeambientes usoAmbiente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usodeambientes consultarCodigo(Integer idUsoAmbieente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usodeambientes> consultarTodo() throws Exception {
        return usoDao.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
