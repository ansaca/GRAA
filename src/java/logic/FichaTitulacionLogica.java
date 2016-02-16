/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Fichatitulacion;
import persistence.FichatitulacionFacadeLocal;


/**
 *
 * @author andres
 */
@Stateless
public class FichaTitulacionLogica implements FichaTitulacionLogicaLocal {

    @EJB
    private FichatitulacionFacadeLocal fichatitulacionDAO;
    
    @Override
    public void crear(Fichatitulacion fichatitulacion) throws Exception {
        Fichatitulacion fichaVieja = fichatitulacionDAO.find(fichatitulacion.getFichatitulacion());
       if(fichatitulacion==null)
       {
           fichatitulacionDAO.create(fichatitulacion);
       }else{
        throw  new Exception("La Ficha Ya Existe");
       }
       }
    

    @Override
    public void modificar(Fichatitulacion fichatitulacion) throws Exception {
      Fichatitulacion fichaVieja = fichatitulacionDAO.find(fichatitulacion.getFichatitulacion());
       if(fichatitulacion==null)
       {
         throw  new Exception("La Ficha No Se Encuentra Para Modificar");
       }else{
         fichatitulacionDAO.edit(fichatitulacion);
       }
    }

    @Override
    public void eliminar(Fichatitulacion fichatitulacion) throws Exception {
       Fichatitulacion fichaVieja = fichatitulacionDAO.find(fichatitulacion.getFichatitulacion());
       if(fichatitulacion==null)
       {
            throw  new Exception("La Ficha No Se Encuentra Para Eliminar");
       }else{
           fichatitulacionDAO.remove(fichatitulacion);
       }
    }

    @Override
    public Fichatitulacion consultarCodigo(Integer idFichatitulacion) throws Exception {
        if(idFichatitulacion==null){
        throw  new Exception("Ingrese Un Codigo");
      }else{
            return fichatitulacionDAO.find(idFichatitulacion);
        }
    
    }

    @Override
    public List<Fichatitulacion> consultarTodo() throws Exception {
    return fichatitulacionDAO.findAll();
    }

}
