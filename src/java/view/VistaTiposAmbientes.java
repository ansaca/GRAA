
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
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logic.PersonalLogicaLocal;
import logic.SedeLogicaLocal;
import logic.TiposAmbienteLogicaLocal;
import model.Funcionario;
import model.Sede;
import model.Tipoambiente;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author G40-80
 */
@ManagedBean
@ViewScoped
public class VistaTiposAmbientes {

   @EJB
  private TiposAmbienteLogicaLocal tipoAmbienteDAO;
  
  @EJB
  private PersonalLogicaLocal personalDAO;
  
    private Integer txtIdTipoAmbiente=null;
    private InputText txtNombreTipoAmbiente;
    public List<Tipoambiente> listaTipoAmbiente;
    private Tipoambiente tipoAmbienteSeleccionad;   
    private InputText txtBuscarNombreTipoAmbiente;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private CommandButton btnBuscarNombreTipoAmbiente;
    
    public VistaTiposAmbientes() {
    }

    public TiposAmbienteLogicaLocal getTipoAmbienteDAO() {
        return tipoAmbienteDAO;
    }

    public void setTipoAmbienteDAO(TiposAmbienteLogicaLocal tipoAmbienteDAO) {
        this.tipoAmbienteDAO = tipoAmbienteDAO;
    }

    public List<Tipoambiente> getListaTipoAmbiente() {
    if (listaTipoAmbiente == null) {
            try {
                listaTipoAmbiente = tipoAmbienteDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaTiposAmbientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTipoAmbiente;
    }

    public void setListaTipoAmbiente(List<Tipoambiente> listaTipoAmbiente) {
        this.listaTipoAmbiente = listaTipoAmbiente;
    }

    

    public PersonalLogicaLocal getPersonalDAO() {
        return personalDAO;
    }

    public void setPersonalDAO(PersonalLogicaLocal personalDAO) {
        this.personalDAO = personalDAO;
    }

    public Integer getTxtIdTipoAmbiente() {
       if (listaTipoAmbiente == null) {
            try {
                listaTipoAmbiente = tipoAmbienteDAO.consultarTodo();
                txtIdTipoAmbiente=codigoMayor();
            } catch (Exception ex) {
                Logger.getLogger(VistaSede.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return txtIdTipoAmbiente;
    }
    
     public Integer codigoMayor(){
        
        int numero = (listaTipoAmbiente.get(listaTipoAmbiente.size()-1).getCodigotipoambiente())+1;
        return  numero;
    }

    public void setTxtIdTipoAmbiente(Integer txtIdTipoAmbiente) {
        this.txtIdTipoAmbiente = txtIdTipoAmbiente;
    }

    public InputText getTxtNombreTipoAmbiente() {
        return txtNombreTipoAmbiente;
    }

    public void setTxtNombreTipoAmbiente(InputText txtNombreTipoAmbiente) {
        this.txtNombreTipoAmbiente = txtNombreTipoAmbiente;
    }

    public Tipoambiente getTipoAmbienteSeleccionad() {
        return tipoAmbienteSeleccionad;
    }

    public void setTipoAmbienteSeleccionad(Tipoambiente tipoAmbienteSeleccionad) {
        this.tipoAmbienteSeleccionad = tipoAmbienteSeleccionad;
    }

    public InputText getTxtBuscarNombreTipoAmbiente() {
        return txtBuscarNombreTipoAmbiente;
    }

    public void setTxtBuscarNombreTipoAmbiente(InputText txtBuscarNombreTipoAmbiente) {
        this.txtBuscarNombreTipoAmbiente = txtBuscarNombreTipoAmbiente;
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

    public CommandButton getBtnBuscarNombreTipoAmbiente() {
        return btnBuscarNombreTipoAmbiente;
    }

    public void setBtnBuscarNombreTipoAmbiente(CommandButton btnBuscarNombreTipoAmbiente) {
        this.btnBuscarNombreTipoAmbiente = btnBuscarNombreTipoAmbiente;
    }
    
     public void onRowSelect(SelectEvent evt) {  
        try {
            Tipoambiente t = tipoAmbienteSeleccionad;
            
            txtIdTipoAmbiente=(t.getCodigotipoambiente());
            txtNombreTipoAmbiente.setValue(t.getDescripciontipoambiente());
 
            btnRegistrar.setDisabled(true);
            btnModificar.setDisabled(false);
            btnEliminar.setDisabled(false);
                
        } catch (Exception ex) {
            Logger.getLogger(VistaTiposAmbientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
      public void limpiar()
   {
       txtIdTipoAmbiente=codigoMayor();
        listaTipoAmbiente=null;
        txtNombreTipoAmbiente.setValue("");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
   }
      
      public void registrarTipo()
      {
          int id=txtIdTipoAmbiente;
        String nombre="";

    if (txtIdTipoAmbiente.toString().equals("") || txtNombreTipoAmbiente.getValue().toString().equals(""))
    {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios."));
    }
    else
    {   
    nombre = txtNombreTipoAmbiente.getValue().toString();

    try
        {
            Tipoambiente t = new Tipoambiente();
    t.setCodigotipoambiente(id);
     t.setDescripciontipoambiente(nombre);
   
            tipoAmbienteDAO.crear(t);
            
         //si todo sale bien aplique esto
            addMessage("Exito", "El tipo de ambiente se ha Registrado con éxito!");
            limpiar();
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando datos del nuevo Tipo de ambiente."));
        }
    } 
      }
      
      
      public void modificarTipoAmbiente()
      {
          int id=txtIdTipoAmbiente;
        String nombre="";

    if (txtIdTipoAmbiente.toString().equals("") || txtNombreTipoAmbiente.getValue().toString().equals(""))
    {
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios."));
    }
    else
    {   
    nombre = txtNombreTipoAmbiente.getValue().toString();

    try
        {
            Tipoambiente t = new Tipoambiente();
            t.setCodigotipoambiente(id);
            t.setDescripciontipoambiente(nombre);
   
            tipoAmbienteDAO.editar(t);
            
         //si todo sale bien aplique esto
            addMessage("Exito", "El tipo de ambiente se ha Modificado con éxito!");
            limpiar();
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando datos de la modificacion del Tipo de ambiente."));
        }
    } 
      }
      
      
        public void eliminarTipoAmbiente()
   {
       int id=txtIdTipoAmbiente;
 
    try
        {
            Tipoambiente t = new Tipoambiente();
            t.setCodigotipoambiente(id);
            
           tipoAmbienteDAO.eliminar(t);
            
         //si todo sale bien aplique esto
            addMessage("Exito", "El tipo de ambiente se ha Eliminado con éxito!");
            limpiar();
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos para la eliminacion del tipo de ambiente"));
        }
   
   }
      
      
      public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    
}
}
