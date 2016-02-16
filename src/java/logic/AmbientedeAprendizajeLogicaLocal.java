/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Ambientedeaprendizaje;

/**
 *
 * @author Eduar
 */
@Local
public interface AmbientedeAprendizajeLogicaLocal {
    
    void crear(Ambientedeaprendizaje ambiente) throws Exception;
    void modificar(Ambientedeaprendizaje ambiente) throws Exception;
    void eliminar(Ambientedeaprendizaje ambiente) throws Exception;
    Ambientedeaprendizaje consultarCodigo(Integer idAmbiente) throws Exception;
    List<Ambientedeaprendizaje> consultarTodo() throws Exception;

    
}
