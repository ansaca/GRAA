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
import model.Guarda;
import model.Instructor;
import model.Personal;
import persistence.CoordinadorFacadeLocal;
import persistence.FuncionarioFacadeLocal;
import persistence.GuardaFacadeLocal;
import persistence.InstructorFacadeLocal;
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
    @EJB
    private GuardaFacadeLocal guardaDAO;
    @EJB 
    private InstructorFacadeLocal instructorDAO;
    
    @Override
    public Personal iniciarSesionCoordinador(Long documento, String contraseña) throws Exception {
        if (documento==null || documento == null) {
            throw  new Exception("Datos obligatorios");
        }
        if (contraseña.equals("")) {
            throw  new Exception("La contraseña es obligatoria");
        }
        Coordinador coordinadorViejo = coordinadorDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (coordinadorViejo==null) {
           // throw  new Exception("El coordinador no existe");
           return null;
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
        Funcionario funcionarioViejo = funcionarioDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (funcionarioViejo==null) {
            //throw  new Exception("El funcionario no existe");
            return null;
        }else {
               if (!personalViejo.getClavepersonal().equals(contraseña)) {
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return personalViejo;
    }

    @Override
    public Personal iniciarSesionGuarda(Long documento, String contraseña) throws Exception {
    if (documento==null || contraseña==null) {
            throw  new Exception("Datos obligatorios");
        }
        if (contraseña.equals("")) {
            throw  new Exception("La contraseña es obligatoria");
        }
        Guarda guardaViejo = guardaDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (guardaViejo==null) {
           // throw  new Exception("El Guarda no existe");
           return null;
        }else {
            if (!personalViejo.getClavepersonal().equals(contraseña)) {
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return personalViejo;    
    }

    @Override
    public Personal iniciarSesionInstructor(Long documento, String contraseña) throws Exception {
    if (documento==null || contraseña==null) {
            throw  new Exception("Datos obligatorios");
        }
        if (contraseña.equals("")) {
            throw  new Exception("La contraseña es obligatoria");
        }
        Instructor instructorViejo = instructorDAO.find(documento);
        Personal personalViejo = personalDAO.find(documento);
        if (instructorViejo==null) {
          //  throw  new Exception("El Instructor no existe");
          return null;
        }else {
            
            if (!personalViejo.getClavepersonal().equals(contraseña)) {
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return personalViejo;  
    }

    
}
