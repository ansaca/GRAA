/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Coordinador;

/**
 *
 * @author andres
 */
@Local
public interface CoordinadorLogicaLocal {
    void crear(Coordinador coordinador) throws Exception;
    void modificar(Coordinador coordinador) throws Exception;
    void eliminar(Coordinador coordinador) throws Exception;
    Coordinador consultarCodigo(Integer idCoordinador) throws Exception;
    List<Coordinador> consultarTodo() throws Exception;
}
