/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logic.SesionLogica;
import logic.SesionLogicaLocal;
import model.Coordinador;
import model.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author andres
 */
@ManagedBean
@RequestScoped
public class VistaSesion {
    @EJB
    private SesionLogicaLocal sesionDAO;
    
    private InputText txtUsuario;
    private Password txtContraseña;
    private CommandButton btnIngresar;
    
    public VistaSesion() {
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public SesionLogicaLocal getSesionDAO() {
        return sesionDAO;
    }

    public void setSesionDAO(SesionLogicaLocal sesionDAO) {
        this.sesionDAO = sesionDAO;
    }

    public Password getTxtContraseña() {
        return txtContraseña;
    }

    public void setTxtContraseña(Password txtContraseña) {
        this.txtContraseña = txtContraseña;
    }



    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void ingresar(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String urlCoordinador = "", urlFuncionario ="" ;
        
        try {
            urlCoordinador = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/gestionReserva.xhtml"));
            urlFuncionario = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/index.xhtml"));
            
            Long documento = Long.parseLong(txtUsuario.getValue().toString());
            String contraseña = txtContraseña.getValue().toString();
            
            System.out.println("Datos "+documento +"clave "+contraseña);
            Personal personalC = sesionDAO.iniciarSesionCoordinador(documento, contraseña);
            
            Personal personalF = null;
            
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "informe"+personalC.getIdPersonal()+", "+personalC.getClave()));
            
            if (personalC == null) {
                personalF = sesionDAO.iniciarSesionFuncionario(documento, contraseña); 
                if (personalF == null) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe usuario"));
                }else{
                    //esta logueado funcionario
                    extContext.getSessionMap().put("Usuario",  personalF);
                    extContext.getSessionMap().put("tipo",  "Funcionario");
                    extContext.redirect(urlFuncionario);
                }
            }else{
                //esta logueado coordinador
                extContext.getSessionMap().put("Usuario",  personalC);
                extContext.getSessionMap().put("tipo",  "Coordinador");
                extContext.redirect(urlCoordinador);
            }
        } catch (Exception ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Hubo un error: "+ex.getMessage()));
        }
    }
    
}
