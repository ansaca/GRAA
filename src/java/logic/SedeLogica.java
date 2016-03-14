
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
import persistence.SedeFacadeLocal;

/**
 *
 * @author G40-80
 */
@Stateless
public class SedeLogica implements SedeLogicaLocal {

   @EJB
   private SedeFacadeLocal sedeDao;
   
   @Override
    public void crear(Sede sede) throws Exception {
        Sede sedeVieja = sedeDao.find(sede.getNumerosede());
        if (sedeVieja==null) {
            sedeDao.create(sede);
        }else{
            throw new Exception("La sede a craer ya existe");
        }
    }

    @Override
    public void editar(Sede sede) throws Exception {
        Sede sedeVieja = sedeDao.find(sede.getNumerosede());
        if (sedeVieja==null) {
            throw new Exception("La sede a editar no existe");
        }else{
            sedeDao.edit(sede);
        }
    }

    @Override
    public void eliminar(Sede sede) throws Exception {
        Sede sedeVieja = sedeDao.find(sede.getNumerosede());
        if (sedeVieja==null) {
            throw new Exception("La sede a eliminar no existe");
        }else{
            sedeDao.remove(sede);
        }
    }

    @Override
    public Sede consultarCodigo(Integer idSede) throws Exception {
        if (idSede==null) {
            throw new Exception("Ingrese el id de la sede para poderla consultar");
        }else{
            return sedeDao.find(idSede);
        }
    }

    @Override
    public List<Sede> consultarTodo() throws Exception {
        return sedeDao.findAll();
    }
   
   
}