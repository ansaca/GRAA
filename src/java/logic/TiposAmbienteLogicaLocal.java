/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Sede;
import model.Tipoambiente;

/**
 *
 * @author G40-80
 */
@Local
public interface TiposAmbienteLogicaLocal {
    
    void crear(Tipoambiente tipoAmbiente) throws Exception;
    void editar(Tipoambiente tipoAmbiente) throws  Exception;
    void eliminar(Tipoambiente tipoAmbiente) throws Exception;
    Sede consultarCodigo(Integer idTipoAmbiente) throws Exception;
    List<Tipoambiente> consultarTodo() throws  Exception;
    
}
