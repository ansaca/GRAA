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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import logic.SedeLogicaLocal;
import logic.UsosAmbienteLogicaLocal;
import model.Usodeambientes;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author G40-80
 */
@ManagedBean
@ViewScoped
public class VistaUsosAmbiente {

   @EJB
  private SedeLogicaLocal sedeDAO;
   
    @EJB
  private UsosAmbienteLogicaLocal usoDAO;
  
  
    private Integer txtIdUsosAmbiente=null; //desabilitado siempre
    private InputText txtDocumentoGuarda; //desabilitado siempre
    
    //Combo box estado sede
    private String comboSede;  
    private List<SelectItem> comboSedes; 
    
    //Combo box estado sede
    private String comboDocumentoPersonal;  
    private List<SelectItem> combosDocumentoPersonal; 
    
    private InputText txtIdAmbiente; 
    private InputText txtIdPersonal; 
    
    private String comboFichaTitulacion;  
    private List<SelectItem> combosFichaTitulacion; 
    
    private Calendar txtFechaUsoAmbiente; 
    
    private Calendar txtHoraInicioUsosAmbiente; 
    private Calendar txtHoraFinUsosAmbiente; 
    
    //Combo box entrega del ambiente
    private String comboEntregaAmbiente;  
    private List<SelectItem> combosEntregaAmbiente; 
    
     private InputText txtObservaciones; 
    
    
    private List<Usodeambientes> listaUsosAmbiente=null;
    private Usodeambientes usoAmbienteSeleccionado;
   
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    public VistaUsosAmbiente() {
    }

    public UsosAmbienteLogicaLocal getUsoDAO() {
        return usoDAO;
    }

    public void setUsoDAO(UsosAmbienteLogicaLocal usoDAO) {
        this.usoDAO = usoDAO;
    }
    
    

    public Calendar getTxtFechaUsoAmbiente() {
        return txtFechaUsoAmbiente;
    }

    public void setTxtFechaUsoAmbiente(Calendar txtFechaUsoAmbiente) {
        this.txtFechaUsoAmbiente = txtFechaUsoAmbiente;
    }

    public String getComboEntregaAmbiente() {
        return comboEntregaAmbiente;
    }

    public void setComboEntregaAmbiente(String comboEntregaAmbiente) {
        this.comboEntregaAmbiente = comboEntregaAmbiente;
    }

    public List<SelectItem> getCombosEntregaAmbiente() {
        return combosEntregaAmbiente;
    }

    public void setCombosEntregaAmbiente(List<SelectItem> combosEntregaAmbiente) {
        this.combosEntregaAmbiente = combosEntregaAmbiente;
    }

    public InputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(InputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    
    
    public InputText getTxtIdAmbiente() {
        return txtIdAmbiente;
    }

    public void setTxtIdAmbiente(InputText txtIdAmbiente) {
        this.txtIdAmbiente = txtIdAmbiente;
    }

    public InputText getTxtIdPersonal() {
        return txtIdPersonal;
    }

    public void setTxtIdPersonal(InputText txtIdPersonal) {
        this.txtIdPersonal = txtIdPersonal;
    }

    
    
    public SedeLogicaLocal getSedeDAO() {
        return sedeDAO;
    }

    public void setSedeDAO(SedeLogicaLocal sedeDAO) {
        this.sedeDAO = sedeDAO;
    }

    public Integer getTxtIdUsosAmbiente() {
        return txtIdUsosAmbiente;
    }

    public void setTxtIdUsosAmbiente(Integer txtIdUsosAmbiente) {
        this.txtIdUsosAmbiente = txtIdUsosAmbiente;
    }

    public InputText getTxtDocumentoGuarda() {
        return txtDocumentoGuarda;
    }

    public void setTxtDocumentoGuarda(InputText txtDocumentoGuarda) {
        this.txtDocumentoGuarda = txtDocumentoGuarda;
    }

    public String getComboSede() {
        return comboSede;
    }

    public void setComboSede(String comboSede) {
        this.comboSede = comboSede;
    }

    public List<SelectItem> getComboSedes() {
        return comboSedes;
    }

    public void setComboSedes(List<SelectItem> comboSedes) {
        this.comboSedes = comboSedes;
    }

    public String getComboDocumentoPersonal() {
        return comboDocumentoPersonal;
    }

    public void setComboDocumentoPersonal(String comboDocumentoPersonal) {
        this.comboDocumentoPersonal = comboDocumentoPersonal;
    }

    public List<SelectItem> getCombosDocumentoPersonal() {
        return combosDocumentoPersonal;
    }

    public void setCombosDocumentoPersonal(List<SelectItem> combosDocumentoPersonal) {
        this.combosDocumentoPersonal = combosDocumentoPersonal;
    }

    public String getComboFichaTitulacion() {
        return comboFichaTitulacion;
    }

    public void setComboFichaTitulacion(String comboFichaTitulacion) {
        this.comboFichaTitulacion = comboFichaTitulacion;
    }

    public List<SelectItem> getCombosFichaTitulacion() {
        return combosFichaTitulacion;
    }

    public void setCombosFichaTitulacion(List<SelectItem> combosFichaTitulacion) {
        this.combosFichaTitulacion = combosFichaTitulacion;
    }

    public Calendar getTxtHoraInicioUsosAmbiente() {
        return txtHoraInicioUsosAmbiente;
    }

    public void setTxtHoraInicioUsosAmbiente(Calendar txtHoraInicioUsosAmbiente) {
        this.txtHoraInicioUsosAmbiente = txtHoraInicioUsosAmbiente;
    }

    public Calendar getTxtHoraFinUsosAmbiente() {
        return txtHoraFinUsosAmbiente;
    }

    public void setTxtHoraFinUsosAmbiente(Calendar txtHoraFinUsosAmbiente) {
        this.txtHoraFinUsosAmbiente = txtHoraFinUsosAmbiente;
    }


    public List<Usodeambientes> getListaUsosAmbiente() {
       listaUsosAmbiente=null;
        if (listaUsosAmbiente == null) {
            try {
                listaUsosAmbiente = usoDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsosAmbiente;
    }

    public void setListaUsosAmbiente(List<Usodeambientes> listaUsosAmbiente) {
        this.listaUsosAmbiente = listaUsosAmbiente;
    }

    public Usodeambientes getUsoAmbienteSeleccionado() {
        return usoAmbienteSeleccionado;
    }

    public void setUsoAmbienteSeleccionado(Usodeambientes usoAmbienteSeleccionado) {
        this.usoAmbienteSeleccionado = usoAmbienteSeleccionado;
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
    
 
    
    public void registrarUsosAmbiente()
    {
        
    }
    
    public void modificarUsosAmbiente()
    {
        
    }
    
    public void eliminarUsosAmbiente()
    {
        
    }
    
    public void limpiarUsosAmbiente()
    {
        
    }
}
