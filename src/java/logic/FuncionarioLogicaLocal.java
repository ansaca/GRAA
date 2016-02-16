/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Local;
import model.Funcionario;

/**
 *
 * @author andres
 */
@Local
public interface FuncionarioLogicaLocal {
    void crear(Funcionario funcionario) throws Exception;
    void modificar(Funcionario funcionario) throws Exception;
    void eliminar(Funcionario funcionario) throws Exception;
    Funcionario consultarCodigo(Integer idFuncionario) throws Exception;
    List<Funcionario> consultarTodo() throws Exception;
}
