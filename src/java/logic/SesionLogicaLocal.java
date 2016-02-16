/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ejb.Local;
import model.Coordinador;
import model.Funcionario;
import model.Personal;

/**
 *
 * @author andres
 */
@Local
public interface SesionLogicaLocal {
    public Personal iniciarSesionCoordinador(Long docummento, String contraseña) throws Exception;
    public Personal iniciarSesionFuncionario(Long docummento, String contraseña) throws Exception;
}
