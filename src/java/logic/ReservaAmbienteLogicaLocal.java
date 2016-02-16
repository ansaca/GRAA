/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Reservaambiente;

/**
 *
 * @author andres
 */
@Local
public interface ReservaAmbienteLogicaLocal {
    void crear(Reservaambiente reservaAmbiente) throws Exception;
    void editar(Reservaambiente reservaAmbiente) throws  Exception;
    void eliminar(Reservaambiente reservaAmbiente) throws Exception;
    Reservaambiente consultarCodigo(Integer idReservaAmbiente) throws Exception;
    List<Reservaambiente> consultarTodo() throws  Exception;
}
