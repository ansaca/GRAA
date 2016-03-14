/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logic.PersonalLogicaLocal;
import model.Ambientedeaprendizaje;
import model.Personal;
import model.Reservaambiente;
import model.Sede;
import model.Tipoambiente;
import model.Usodeambientes;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author andres
 */
@ManagedBean
@RequestScoped
public class VistaPersonal {

    @EJB
    public PersonalLogicaLocal personalDAO;
    
    private InputText txtCedulaPersonal;
    private InputText txtNombrePersonal;
    private InputText txtApellidoPersonal;
    private InputText txtDireccionPersonal;
    private InputText txtCorreoPersonal;
    private InputText txtTelefonoPersonal;
    private InputText txtClavePersonal;
    private Calendar txtFechaNacimientoPersonal;
    private InputText txtLugarNacimientoPersonal;
    private String txtFotoPersonal;
    
    private List<Personal> listaPersonal;
    private Personal personalSeleccionado;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    
    public VistaPersonal() {
    }

    public PersonalLogicaLocal getPersonalDAO() {
        return personalDAO;
    }

    public void setPersonalDAO(PersonalLogicaLocal personalDAO) {
        this.personalDAO = personalDAO;
    }

    public InputText getTxtCedulaPersonal() {
        return txtCedulaPersonal;
    }

    public void setTxtCedulaPersonal(InputText txtCedulaPersonal) {
        this.txtCedulaPersonal = txtCedulaPersonal;
    }

    public InputText getTxtNombrePersonal() {
        return txtNombrePersonal;
    }

    public void setTxtNombrePersonal(InputText txtNombrePersonal) {
        this.txtNombrePersonal = txtNombrePersonal;
    }

    public InputText getTxtApellidoPersonal() {
        return txtApellidoPersonal;
    }

    public void setTxtApellidoPersonal(InputText txtApellidoPersonal) {
        this.txtApellidoPersonal = txtApellidoPersonal;
    }

    public InputText getTxtCorreoPersonal() {
        return txtCorreoPersonal;
    }

    public void setTxtCorreoPersonal(InputText txtCorreoPersonal) {
        this.txtCorreoPersonal = txtCorreoPersonal;
    }

    public InputText getTxtTelefonoPersonal() {
        return txtTelefonoPersonal;
    }

    public void setTxtTelefonoPersonal(InputText txtTelefonoPersonal) {
        this.txtTelefonoPersonal = txtTelefonoPersonal;
    }

    public InputText getTxtClavePersonal() {
        return txtClavePersonal;
    }

    public void setTxtClavePersonal(InputText txtClavePersonal) {
        this.txtClavePersonal = txtClavePersonal;
    }

    public Calendar getTxtFechaNacimientoPersonal() {
        return txtFechaNacimientoPersonal;
    }

    public void setTxtFechaNacimientoPersonal(Calendar txtFechaNacimientoPersonal) {
        this.txtFechaNacimientoPersonal = txtFechaNacimientoPersonal;
    }

    public String getTxtFotoPersonal() {
        return txtFotoPersonal;
    }

    public InputText getTxtLugarNacimientoPersonal() {
        return txtLugarNacimientoPersonal;
    }

    public void setTxtLugarNacimientoPersonal(InputText txtLugarNacimientoPersonal) {
        this.txtLugarNacimientoPersonal = txtLugarNacimientoPersonal;
    }

    public void setTxtFotoPersonal(String txtFotoPersonal) {
        this.txtFotoPersonal = txtFotoPersonal;
    }



    public List<Personal> getListaPersonal() {
       if (listaPersonal == null) {
            try {
                listaPersonal = personalDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPersonal;

    }

    public void setListaPersonal(List<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public Personal getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Personal personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public InputText getTxtDireccionPersonal() {
        return txtDireccionPersonal;
    }

    public void setTxtDireccionPersonal(InputText txtDireccionPersonal) {
        this.txtDireccionPersonal = txtDireccionPersonal;
    }
    
    public void registrarPersonal() {

        long cedula = 0;
        String nombre = "";
        String apellidos = "";
        String direccion = "";
        String correo = "";
        String telefono = "";
        String clave = "";
        Date fechaNacimiento;
        String lugarNacimiento = "";

        int excepciones = 0;

       if (txtCedulaPersonal.getValue().toString().equals("") || txtNombrePersonal.getValue().toString().equals("") || txtApellidoPersonal.getValue().toString().equals("") || txtDireccionPersonal.getValue().toString().equals("") || txtCorreoPersonal.getValue().toString().equals("") || txtTelefonoPersonal.getValue().toString().equals("") || txtClavePersonal.getValue().toString().equals("") || txtLugarNacimientoPersonal.getValue().toString().equals("") ) 
        {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos son obligatorios."));
        }
        else
        {
          
              try {
                cedula = Long.parseLong(txtCedulaPersonal.getValue().toString());
            } catch (Exception error1) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El campo cedula solo permite numeros."));
                excepciones++;
            }

            nombre = txtNombrePersonal.getValue().toString();
            apellidos = txtApellidoPersonal.getValue().toString();
            direccion = txtDireccionPersonal.getValue().toString();
            correo = txtCorreoPersonal.getValue().toString();
            telefono = txtTelefonoPersonal.getValue().toString();
            clave = txtClavePersonal.getValue().toString();
            fechaNacimiento = (Date) txtFechaNacimientoPersonal.getValue();
            lugarNacimiento = txtLugarNacimientoPersonal.getValue().toString();

            if (excepciones == 0) {
                try {
                    Personal p = new Personal();
                    p.setDocumentopersonal(cedula);
                    p.setNombrepersonal(nombre);
                    p.setApellidopersonal(apellidos);
                    p.setDireccionpersonal(direccion);
                    p.setCorreopersonal(correo);
                    p.setClavepersonal(clave);
                    p.setTelefonopersonal(telefono);
                    p.setFechanacimientopersonal(fechaNacimiento);
                    p.setLugarnacimientopersonal(lugarNacimiento);

                    personalDAO.crear(p);

                    //si todo sale bien aplique esto
                    addMessage("Exito", "El personal se ha Registrado con éxito.");
                    limpiar();

                } catch (Exception e5) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del nuevo personal."));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Verifique los datos."));
            }
        
        }

    }
    
    public void modificarPersonal()
    {
        
         long cedula = 0;
        String nombre = "";
        String apellidos = "";
        String direccion = "";
        String correo = "";
        String telefono = "";
        String clave = "";
        Date fechaNacimiento;
        String lugarNacimiento = "";

        int excepciones = 0;

       if (txtCedulaPersonal.getValue().toString().equals("") || txtNombrePersonal.getValue().toString().equals("") || txtApellidoPersonal.getValue().toString().equals("") || txtDireccionPersonal.getValue().toString().equals("") || txtCorreoPersonal.getValue().toString().equals("") || txtTelefonoPersonal.getValue().toString().equals("") || txtClavePersonal.getValue().toString().equals("") || txtLugarNacimientoPersonal.getValue().toString().equals("") ) 
        {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos son obligatorios."));
        }
        else
        {
          
              try {
                cedula = Long.parseLong(txtCedulaPersonal.getValue().toString());
            } catch (Exception error1) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El campo cedula solo permite numeros."));
                excepciones++;
            }

            nombre = txtNombrePersonal.getValue().toString();
            apellidos = txtApellidoPersonal.getValue().toString();
            direccion = txtDireccionPersonal.getValue().toString();
            correo = txtCorreoPersonal.getValue().toString();
            telefono = txtTelefonoPersonal.getValue().toString();
            clave = txtClavePersonal.getValue().toString();
            fechaNacimiento = (Date) txtFechaNacimientoPersonal.getValue();
            lugarNacimiento = txtLugarNacimientoPersonal.getValue().toString();

            if (excepciones == 0) {
                try {
                    Personal p = new Personal();
                    p.setDocumentopersonal(cedula);
                    p.setNombrepersonal(nombre);
                    p.setApellidopersonal(apellidos);
                    p.setDireccionpersonal(direccion);
                    p.setCorreopersonal(correo);
                    p.setClavepersonal(clave);
                    p.setTelefonopersonal(telefono);
                    p.setFechanacimientopersonal(fechaNacimiento);
                    p.setLugarnacimientopersonal(lugarNacimiento);

                    personalDAO.modificar(p);

                    //si todo sale bien aplique esto
                    addMessage("Exito", "El personal se ha modificado con éxito.");
                    limpiar();

                } catch (Exception e5) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del nuevo personal."));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Verifique los datos."));
            }
        
        }
        
    }
    
    public void eliminarPersonal()
    {
         try {
            long cedula= Long.parseLong(txtCedulaPersonal.getValue().toString());
            
            Personal p = new Personal();
            p.setDocumentopersonal(cedula);
            personalDAO.eliminar(p);
            
            //si todo sale bien aplique esto
            addMessage("Exito", "El personal se ha eliminado con éxito.");
            limpiar();
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Error eliminando el personal."));
        }
    }
    
    public void limpiar()
    {
        listaPersonal=null;
         txtCedulaPersonal.setValue("");
        txtNombrePersonal.setValue("");
        txtApellidoPersonal.setValue("");
        txtDireccionPersonal.setValue("");
        txtCorreoPersonal.setValue("");
        txtTelefonoPersonal.setValue("");
        txtClavePersonal.setValue("");
        txtFechaNacimientoPersonal.setValue(null);
        txtLugarNacimientoPersonal.setValue("");

        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true); 
        txtCedulaPersonal.setDisabled(false);
    }
    

    public void OnRowSelect(SelectEvent evt)
    {
           Personal p = personalSeleccionado;
        txtCedulaPersonal.setValue(p.getDocumentopersonal());
        txtNombrePersonal.setValue(p.getNombrepersonal());
        txtApellidoPersonal.setValue(p.getApellidopersonal());
        txtDireccionPersonal.setValue(p.getDireccionpersonal());
        txtCorreoPersonal.setValue(p.getCorreopersonal());
        txtTelefonoPersonal.setValue(p.getTelefonopersonal());
        txtClavePersonal.setValue(p.getClavepersonal());
        txtFechaNacimientoPersonal.setValue(p.getFechanacimientopersonal());
       txtLugarNacimientoPersonal.setValue(p.getLugarnacimientopersonal());

        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtCedulaPersonal.setDisabled(true);

    }
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
