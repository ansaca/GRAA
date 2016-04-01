/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logic.SesionLogicaLocal;
import model.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author JuanP
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

    public void ingresar() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String urlCoordinador = "", urlFuncionario = "", urlInstructor = " ", urlGuarda = "";

        try {
            urlCoordinador = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/Coordinador/gestionReservaCoordinadores.xhtml"));
            urlFuncionario = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/Funcionario/Instructor/gestionReserva.xhtml"));
            urlInstructor = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/Funcionario/Instructor/gestionReserva.xhtml"));
            urlGuarda = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/Guarda/gestionUsosAmbiente.xhtml"));
            Long documento = Long.parseLong(txtUsuario.getValue().toString());
            String contraseña = txtContraseña.getValue().toString();

            Personal personalLogueado = null;
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "informe" + personalC.getIdPersonal() + ", " + personalC.getClave()  ));
            personalLogueado = sesionDAO.iniciarSesionCoordinador(documento,contraseña);
            if (personalLogueado == null) {
                personalLogueado = sesionDAO.iniciarSesionFuncionario(documento,contraseña);
                if (personalLogueado == null) {
                    personalLogueado = sesionDAO.iniciarSesionGuarda(documento,contraseña);
                    if (personalLogueado == null) {
                        personalLogueado = sesionDAO.iniciarSesionInstructor(documento,contraseña);
                        if (personalLogueado == null) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El Usuario No Existe"));
                        } else {
                            //Esta Logeado Instructor
                            extContext.getSessionMap().put("Usuario", personalLogueado);
                            extContext.getSessionMap().put("tipo", "Instructor");
                            extContext.redirect(urlInstructor);
                        }
                    } else {
                        //Esta Logeado Guarda
                        extContext.getSessionMap().put("Usuario", personalLogueado);
                        extContext.getSessionMap().put("tipo", "Guarda");
                        extContext.redirect(urlGuarda);
                    }
                } else {
                    //esta logueado funcionario
                    extContext.getSessionMap().put("Usuario", personalLogueado);
                    extContext.getSessionMap().put("tipo", "Funcionario");
                    extContext.redirect(urlFuncionario);
                }
            } else {
                //esta logueado coordinador
                extContext.getSessionMap().put("Usuario", personalLogueado);
                extContext.getSessionMap().put("tipo", "Coordinador");
                extContext.redirect(urlCoordinador);
            }
        } catch (Exception ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Por Favor Ingresa Tus Datos Correctamente"));
        }
    }

    public void cerrarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            extContext.getSessionMap().remove("tipo");
            extContext.getSessionMap().remove("Usuario");
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "../SesionInvalida.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(VistaSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
