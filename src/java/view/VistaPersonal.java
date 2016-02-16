/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logic.PersonalLogicaLocal;
import model.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author andres
 */
@ManagedBean
@RequestScoped
public class VistaPersonal {

    @EJB
    public PersonalLogicaLocal personalDAO;
    
    private InputText idPersonal;
    private InputText idNombre;
    private InputText idApellido;
    private InputText idCorreo;
    private InputText idTelefono;
    private InputText idClave;
    private Personal personalSeleccionado;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    

    public VistaPersonal() {
    }

}
