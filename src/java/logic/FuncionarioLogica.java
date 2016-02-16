/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Funcionario;
import persistence.FuncionarioFacadeLocal;

/**
 *
 * @author andres
 */
@Stateless
public class FuncionarioLogica implements FuncionarioLogicaLocal {

   @EJB
    public FuncionarioFacadeLocal funcionarioDAO;

    @Override
    public void crear(Funcionario funcionario) throws Exception {
        Funcionario personalViejo = funcionarioDAO.find(funcionario.getDocumentofuncionario());
        if (personalViejo == null) {
            funcionarioDAO.create(funcionario);
            
        }else{
            throw new Exception("El personal ya esta registrado");
        }

    }

    @Override
    public void modificar(Funcionario funcionario) throws Exception {

        Funcionario funcionarioViejo = funcionarioDAO.find(funcionario.getDocumentofuncionario());
        if (funcionarioViejo == null) {
            throw new Exception("El Funcionario no se  encuentra");
        }else{
            funcionarioDAO.edit(funcionario);
        }
    }

    @Override
    public void eliminar(Funcionario funcionario) throws Exception {

        Funcionario funcionarioViejo = funcionarioDAO.find(funcionario.getDocumentofuncionario());
        if (funcionarioViejo==null) {
            throw  new Exception("El Funcionario no se encuentra!!");
        }else{
        funcionarioDAO.remove(funcionario);
        }
    }

    @Override
    public Funcionario consultarCodigo(Integer funcionario) throws Exception {
        if (funcionario==null) {
            throw  new Exception("Ingrese un codigo");
        }else{
            return funcionarioDAO.find(funcionario);
        }
    }

    @Override
    public List<Funcionario> consultarTodo() throws Exception {
        return funcionarioDAO.findAll();
    }

}
