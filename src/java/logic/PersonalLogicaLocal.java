/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Personal;

/**
 *
 * @author andres
 */
@Local
public interface PersonalLogicaLocal {
    void crear(Personal personal) throws Exception;
    void modificar(Personal personal) throws Exception;
    void eliminar(Personal personal) throws Exception;
    Personal consultarCodigo(Integer idPersonal) throws Exception;
    List<Personal> consultarTodo() throws Exception;
    
}
