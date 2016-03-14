/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Sede;
import model.Usodeambientes;

/**
 *
 * @author G40-80
 */
@Local
public interface UsosAmbienteLogicaLocal {
    
     void crear(Usodeambientes usoAmbiente) throws Exception;
    void editar(Usodeambientes usoAmbiente) throws  Exception;
    void eliminar(Usodeambientes usoAmbiente) throws Exception;
    Usodeambientes consultarCodigo(Integer idUsoAmbieente) throws Exception;
    List<Usodeambientes> consultarTodo() throws  Exception;
    
}
