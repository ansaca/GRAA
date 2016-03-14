
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Ambientedeaprendizaje;
import persistence.AmbientedeaprendizajeFacadeLocal;

/**
 *
 * @author Eduar
 */
@Stateless
public class AmbientedeAprendizajeLogica implements AmbientedeAprendizajeLogicaLocal {

     @EJB
    public AmbientedeaprendizajeFacadeLocal ambienteDAO;
     
     @Override
    public void crear(Ambientedeaprendizaje ambiente) throws Exception {
         Ambientedeaprendizaje ambienteViejo = ambienteDAO.find(ambiente.getCodigoambiente());
        if (ambienteViejo == null) {
            ambienteDAO.create(ambiente);
        }else{
            throw new Exception("El ambiente a registrar ya existe");
        }

    }

    @Override
    public void modificar(Ambientedeaprendizaje ambiente) throws Exception {

        Ambientedeaprendizaje ambienteViejo = ambienteDAO.find(ambiente.getCodigoambiente());
        if (ambienteViejo == null) {
            throw new Exception("El ambiente a modificar no existe");
        }else{
           ambienteDAO.edit(ambiente);
        }
    }

    @Override
    public void eliminar(Ambientedeaprendizaje ambiente) throws Exception {

       Ambientedeaprendizaje ambienteViejo = ambienteDAO.find(ambiente.getCodigoambiente());
        if (ambienteViejo==null) {
            throw  new Exception("El ambiente a eliminar no existe");
        }else{
        ambienteDAO.remove(ambiente);
        }
    }

    @Override
    public Ambientedeaprendizaje consultarCodigo(Integer idAmbiente) throws Exception {
        if (idAmbiente==null) {
            throw  new Exception("Ingrese un codigo a consultar");
        }else{
            return ambienteDAO.find(idAmbiente);
        }
    }

    @Override
    public List<Ambientedeaprendizaje> consultarTodo() throws Exception {
        return ambienteDAO.findAll();
    }
     
     
}