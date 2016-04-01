/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Instructor;

/**
 *
 * @author G40-80
 */
@Local
public interface InstructorLogicaLocal {
      void crear(Instructor instructor) throws Exception;
    void modificar(Instructor instructor) throws Exception;
    void eliminar(Instructor instructor) throws Exception;
    Instructor consultarCodigo(Integer idInstructor) throws Exception;
    List<Instructor> consultarTodo() throws Exception;
    
}
