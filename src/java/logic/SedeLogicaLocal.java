/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Sede;

/**
 *
 * @author G40-80
 */
@Local
public interface SedeLogicaLocal {
    void crear(Sede sede) throws Exception;
    void editar(Sede sede) throws  Exception;
    void eliminar(Sede sede) throws Exception;
    Sede consultarCodigo(Integer idSede) throws Exception;
    List<Sede> consultarTodo() throws  Exception;
}
