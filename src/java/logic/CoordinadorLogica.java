/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Coordinador;
import persistence.CoordinadorFacadeLocal;

/**
 *
 * @author andres
 */
@Stateless
public class CoordinadorLogica implements CoordinadorLogicaLocal {

    @EJB
    public CoordinadorFacadeLocal coordinadorDAO;

    @Override
    public void crear(Coordinador coordinador) throws Exception {
        Coordinador coordinadorViejo = coordinadorDAO.find(coordinador.getDocumentocoordinador());
        if (coordinadorViejo== null) {
            coordinadorDAO.create(coordinador);
            
        }else{
            throw new Exception("El Coordinador ya esta registrado");
        }

    }

    @Override
    public void modificar(Coordinador coordinador) throws Exception {

        Coordinador coordinadorViejo = coordinadorDAO.find(coordinador.getDocumentocoordinador());
        if (coordinadorViejo == null) {
            throw new Exception("El Coordinador no se  encuentra");
        }else{
            coordinadorDAO.edit(coordinador);
        }
    }

    @Override
    public void eliminar(Coordinador coordinador) throws Exception {

        Coordinador coordinadorViejo = coordinadorDAO.find(coordinador.getDocumentocoordinador());
        if (coordinadorViejo==null) {
            throw  new Exception("El Coordinador no se encuentra!!");
        }else{
        coordinadorDAO.remove(coordinador);
        }
    }

    @Override
    public Coordinador consultarCodigo(Integer idCoordinador) throws Exception {
        if (idCoordinador==null) {
            throw  new Exception("Ingrese un codigo");
        }else{
            return coordinadorDAO.find(idCoordinador);
        }
    }

    @Override
    public List<Coordinador> consultarTodo() throws Exception {
        return coordinadorDAO.findAll();
    }

}
