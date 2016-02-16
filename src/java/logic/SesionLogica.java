/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Coordinador;
import model.Funcionario;
import model.Personal;
import persistence.CoordinadorFacadeLocal;
import persistence.FuncionarioFacadeLocal;
import persistence.PersonalFacadeLocal;

/**
 *
 * @author andres
 */

@Stateless
public class SesionLogica implements SesionLogicaLocal {

    @EJB 
    private CoordinadorFacadeLocal coordinadorDAO;
    @EJB
    private FuncionarioFacadeLocal funcionarioDAO;
    @EJB
    private PersonalFacadeLocal personalDAO;
    
    @Override
    public Personal iniciarSesionCoordinador(Long documento, String contraseña) throws Exception {
       // contraseña ="123";
        if (documento==null || documento.toString().equals("")) {
            throw  new Exception("El docimento es obligatorio");
        }
        if (contraseña.equals("")) {
            throw  new Exception("La contraseña es obligatoria"+documento+"---"+contraseña);
        }
        
        Coordinador coordinadorViejo = coordinadorDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (coordinadorViejo!=null) {
            throw  new Exception("El coordinador no existe");
        }else {
            
            if (!(personalViejo.getClavepersonal().equals(contraseña))) {
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return personalViejo;
    }

    @Override
    public Personal iniciarSesionFuncionario(Long documento, String contraseña) throws Exception {
        if (documento==null || contraseña==null) {
            throw  new Exception("Datos obligatorios");
        }
        if (contraseña.equals("")) {
            throw  new Exception("La contraseña es obligatoria");
        }
        
        Funcionario funcioarioViejo = funcionarioDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (personalViejo==null) {
            throw  new Exception("El funcionario no existe");
        }else {
            
            if (!personalViejo.getClavepersonal().equals(contraseña)) {
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return personalViejo;
    }

    
}
