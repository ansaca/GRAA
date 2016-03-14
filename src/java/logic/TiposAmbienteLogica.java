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
        Tipoambiente tipoViejo = tipoAmbienteDao.find(tipoAmbiente.getCodigotipoambiente());
        if (tipoViejo==null) {
            tipoAmbienteDao.create(tipoAmbiente);
        }else{
            throw new Exception("El tipo de ambiente a craer ya existe");
        }
    }

    @Override
    public void editar(Tipoambiente tipoAmbiente) throws Exception {
        Tipoambiente tipoViejo = tipoAmbienteDao.find(tipoAmbiente.getCodigotipoambiente());
        if (tipoViejo==null) {
            throw new Exception("El tipo de ambiente a editar no existe");
        }else{
            tipoAmbienteDao.edit(tipoAmbiente);
        }    }

    @Override
    public void eliminar(Tipoambiente tipoAmbiente) throws Exception {
        Tipoambiente tipoViejo = tipoAmbienteDao.find(tipoAmbiente.getCodigotipoambiente());
        if (tipoViejo==null) {
            throw new Exception("El tipo de ambiente a eliminar no existe");
        }else{
            tipoAmbienteDao.remove(tipoAmbiente);
        }
    }

    @Override
    public Tipoambiente consultarCodigo(Integer idTipoAmbiente) throws Exception {
       if (idTipoAmbiente==null) {
            throw new Exception("Ingrese el id del tipo de ambiente para poderla consultar");
        }else{
            return tipoAmbienteDao.find(idTipoAmbiente);
        }
    }

    @Override
    public List<Tipoambiente> consultarTodo() throws Exception {
        return tipoAmbienteDao.findAll();
    }

  

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
