/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logic.FuncionarioLogicaLocal;
import model.Funcionario;

/**
 *
 * @author G40-80
 */
@ManagedBean
@ViewScoped
public class VistaFuncionario {

    @EJB
    private FuncionarioLogicaLocal funcionarioDAO;
    
   protected List<Funcionario> listaFuncionario;
           
           
    public VistaFuncionario() {
    }

    public List<Funcionario> getListaFuncionario() {
       if (listaFuncionario == null) {
            try {
                listaFuncionario = funcionarioDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public FuncionarioLogicaLocal getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioLogicaLocal funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
    
    
    
}
