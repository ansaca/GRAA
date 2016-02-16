/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Personal;
import persistence.PersonalFacadeLocal;

/**
 *
 * @author andres
 */
@Stateless
public class PersonalLogica implements PersonalLogicaLocal {

    @EJB
    public PersonalFacadeLocal personalDAO;

    @Override
    public void crear(Personal personal) throws Exception {
        Personal personalViejo = personalDAO.find(personal.getDocumentopersonal());
        if (personalViejo == null) {
            personalDAO.create(personal);
            
        }else{
            throw new Exception("El personal ya esta registrado");
        }

    }

    @Override
    public void modificar(Personal personal) throws Exception {

        Personal personalViejo = personalDAO.find(personal.getDocumentopersonal());
        if (personalViejo == null) {
            throw new Exception("El personal no se  encuentra");
        }else{
            personalDAO.edit(personal);
        }
    }

    @Override
    public void eliminar(Personal personal) throws Exception {

        Personal personalViejo = personalDAO.find(personal.getDocumentopersonal());
        if (personalViejo==null) {
            throw  new Exception("El Personal no se encuentra!!");
        }else{
        personalDAO.remove(personal);
        }
    }

    @Override
    public Personal consultarCodigo(Integer personal) throws Exception {
        if (personal==null) {
            throw  new Exception("Ingrese un codigo");
        }else{
            return personalDAO.find(personal);
        }
    }

    @Override
    public List<Personal> consultarTodo() throws Exception {
        return personalDAO.findAll();
    }

}
