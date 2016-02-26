/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logic.AmbientedeAprendizajeLogicaLocal;
import logic.FichaTitulacionLogicaLocal;
import logic.PersonalLogicaLocal;
import logic.ReservaAmbienteLogicaLocal;
import model.Ambientedeaprendizaje;
import model.Fichatitulacion;
import model.Personal;
import model.Reservaambiente;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.overlaypanel.OverlayPanel;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.Overlay;

/**
 *
 * @author andres
 */
@ManagedBean
@ViewScoped
public class VistaReservaAmbiente {

    @EJB
    private ReservaAmbienteLogicaLocal reservaDAO;
    @EJB
    private AmbientedeAprendizajeLogicaLocal ambienteDAO;
    @EJB
    private PersonalLogicaLocal personalDAO;
    @EJB
    private FichaTitulacionLogicaLocal fichaDAO;

    private Integer txtIdReservaAmbiente = null;

    private InputText txtIdAmbiente;
    private CommandButton btnIdAmbiente;

    private InputText txtIdPersonal;
    private CommandButton btnIdPersonal;

    private InputText txtIdFicha;
    private CommandButton btnIdFicha;

    private Calendar txtFechaInicio;
    private Calendar txtFechaFin;
    private Calendar txtHoraInicio;
    private Calendar txtHoraFin;

    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;

    private List<Reservaambiente> listaReserva = null;
    private Reservaambiente reservaSeleccionada;

    private List<Ambientedeaprendizaje> listaAmbiente;
    private List<Personal> listaPersonal;
    private List<Fichatitulacion> listaFicha;
    private Ambientedeaprendizaje ambienteSeleccionado;
    private Personal personalSeleccionado;
    private Fichatitulacion fichaSeleccionada;
    
    public ReservaAmbienteLogicaLocal getReservaDAO() {
        return reservaDAO;
    }

    public void setReservaDAO(ReservaAmbienteLogicaLocal reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public List<Ambientedeaprendizaje> getListaAmbiente() {
        try {
            if (listaAmbiente == null) {
                listaAmbiente = ambienteDAO.consultarTodo();
            }

        } catch (Exception ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAmbiente;
    }

    public void setListaAmbiente(List<Ambientedeaprendizaje> listaAmbiente) {
        this.listaAmbiente = listaAmbiente;
    }

    public List<Personal> getListaPersonal() {
        try {
            listaPersonal = personalDAO.consultarTodo();
        } catch (Exception ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPersonal;
    }

    public void setListaPersonal(List<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public List<Fichatitulacion> getListaFicha() {
        try {
            listaFicha = fichaDAO.consultarTodo();
        } catch (Exception ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFicha;
    }

    public void setListaFicha(List<Fichatitulacion> listaFicha) {
        this.listaFicha = listaFicha;
    }

    public VistaReservaAmbiente() {
       
        
    }

    public Ambientedeaprendizaje getAmbienteSeleccionado() {
        return ambienteSeleccionado;
    }

    public void setAmbienteSeleccionado(Ambientedeaprendizaje ambienteSeleccionado) {
        this.ambienteSeleccionado = ambienteSeleccionado;
    }

    public Personal getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Personal personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }

    public Fichatitulacion getFichaSeleccionada() {
        return fichaSeleccionada;
    }

    public void setFichaSeleccionada(Fichatitulacion fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

    public Integer getTxtIdReservaAmbiente() {
        //txtIdReservaAmbiente.setValue(32);
        if (listaReserva == null) {
            try {
                listaReserva = reservaDAO.consultarTodo();
                txtIdReservaAmbiente =codigoMayor();
            } catch (Exception ex) {
                Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return txtIdReservaAmbiente;
        
    }

    public void setTxtIdReservaAmbiente(Integer txtIdReservaAmbiente) {
        this.txtIdReservaAmbiente = txtIdReservaAmbiente;
    }

    public InputText getTxtIdAmbiente() {
        return txtIdAmbiente;
    }

    public void setTxtIdAmbiente(InputText txtIdAmbiente) {
        this.txtIdAmbiente = txtIdAmbiente;
    }

    public CommandButton getBtnIdAmbiente() {
        return btnIdAmbiente;
    }

    public void setBtnIdAmbiente(CommandButton btnIdAmbiente) {
        this.btnIdAmbiente = btnIdAmbiente;
    }

    public InputText getTxtIdPersonal() {
        return txtIdPersonal;
    }

    public void setTxtIdPersonal(InputText txtIdPersonal) {
        this.txtIdPersonal = txtIdPersonal;
    }

    public CommandButton getBtnIdPersonal() {
        return btnIdPersonal;
    }

    public void setBtnIdPersonal(CommandButton btnIdPersonal) {
        this.btnIdPersonal = btnIdPersonal;
    }

    public InputText getTxtIdFicha() {
        return txtIdFicha;
    }

    public void setTxtIdFicha(InputText txtIdFicha) {
        this.txtIdFicha = txtIdFicha;
    }

    public CommandButton getBtnIdFicha() {
        return btnIdFicha;
    }

    public void setBtnIdFicha(CommandButton btnIdFicha) {
        this.btnIdFicha = btnIdFicha;
    }

    public Calendar getTxtFechaInicio() {
        return  txtFechaInicio;
    }

    public void setTxtFechaInicio(Calendar txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public Calendar getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Calendar txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public Calendar getTxtHoraInicio() {
        return txtHoraInicio;
    }

    public void setTxtHoraInicio(Calendar txtHoraInicio) {
        this.txtHoraInicio = txtHoraInicio;
    }

    public Calendar getTxtHoraFin() {
        return txtHoraFin;
    }

    public void setTxtHoraFin(Calendar txtHoraFin) {
        this.txtHoraFin = txtHoraFin;
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

    public List<Reservaambiente> getListaReserva() {
        if (listaReserva == null) {
            try {
                listaReserva = reservaDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaReserva;
    }

    public void setListaReserva(List<Reservaambiente> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Reservaambiente getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Reservaambiente reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
/*
    public void verAmbientes() {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("tablaAmbiente", options, null);

        //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
        //RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
*/
    public void onRowSelect(SelectEvent evt) {
        
        try {
            Reservaambiente r = reservaSeleccionada;
            
            txtIdReservaAmbiente=(r.getCodigoreservambiente());
            txtIdAmbiente.setValue(r.getCodigoambiente().getCodigoambiente());
            txtIdPersonal.setValue(r.getDocumentopersonal().getDocumentopersonal());
            txtIdFicha.setValue(r.getFichatitulacion().getFichatitulacion());
            
            txtFechaInicio.setValue(r.getFechainicioreserva());
            txtFechaFin.setValue(r.getFechafinreserva());
            
            //pasar de date a calendar 
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date horaI = sdf.parse(r.getHorainicioreserva());
            Date horaF = sdf.parse(r.getHorafinreserva());
            txtHoraInicio.setValue(horaI);
            txtHoraFin.setValue(horaF);
            
            btnRegistrar.setDisabled(true);
            btnModificar.setDisabled(false);
            btnEliminar.setDisabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void filaSeleccionadaAmbiente(SelectEvent evt) {
        Ambientedeaprendizaje a = ambienteSeleccionado;
        txtIdAmbiente.setValue(a.getCodigoambiente());
    }

    public void filaSeleccionadaPersonal(SelectEvent evt) {
        Personal p = personalSeleccionado;
        txtIdPersonal.setValue(p.getDocumentopersonal());
    }

    public void filaSeleccionadaFichaTitulacion(SelectEvent evt) {
        Fichatitulacion ficha = fichaSeleccionada;
        txtIdFicha.setValue(ficha.getFichatitulacion());
    }

    public void limpiar() {
        //txtIdReservaAmbiente=0;
        txtIdReservaAmbiente=codigoMayor(); 
        txtIdFicha.setValue("");
        txtIdPersonal.setValue("");
        txtIdAmbiente.setValue("");        
        txtFechaFin.setValue(null);
        txtFechaInicio.setValue(null);
        txtHoraFin.setValue(null);
        txtHoraInicio.setValue(null);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
        btnRegistrar.setDisabled(false);
        listaReserva=null;
    }
    
    public Integer codigoMayor(){
        int numero=1;
        try {
            numero = (listaReserva.get(listaReserva.size()-1).getCodigoreservambiente())+1;
        } catch (Exception ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }

    public void registrar(){
        try {
            Reservaambiente re = new Reservaambiente();
            Ambientedeaprendizaje am = new Ambientedeaprendizaje();
            Personal p = new Personal();
            Fichatitulacion f = new Fichatitulacion();
            
            re.setCodigoreservambiente(txtIdReservaAmbiente);
            
            am.setCodigoambiente(Integer.parseInt(txtIdAmbiente.getValue().toString()));
            re.setCodigoambiente(am);
            p.setDocumentopersonal(Long.parseLong(txtIdPersonal.getValue().toString()));
            re.setDocumentopersonal(p);
            f.setFichatitulacion(Integer.parseInt(txtIdFicha.getValue().toString()));
            re.setFichatitulacion(f);
                
            re.setFechainicioreserva((Date)txtFechaInicio.getValue());
            re.setFechafinreserva((Date)txtFechaFin.getValue());
            
            SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
            
            String h1 = format1.format(txtHoraInicio.getValue());
            String h2 = format1.format(txtHoraFin.getValue());
            re.setHorainicioreserva(h1);
            re.setHorafinreserva(h2);
            
            reservaDAO.crear(re);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro creado!"));
            limpiar();
            
        }catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", ex.getMessage()));
        }
        
        
    }
    
    public  void modificar(){
         
        try {
            Reservaambiente re = new Reservaambiente();
            Ambientedeaprendizaje am = new Ambientedeaprendizaje();
            Personal p = new Personal();
            Fichatitulacion f = new Fichatitulacion();
            
            re.setCodigoreservambiente(txtIdReservaAmbiente);
            
            am.setCodigoambiente(Integer.parseInt(txtIdAmbiente.getValue().toString()));
            re.setCodigoambiente(am);
            p.setDocumentopersonal(Long.parseLong(txtIdPersonal.getValue().toString()));
            re.setDocumentopersonal(p);
            f.setFichatitulacion(Integer.parseInt(txtIdFicha.getValue().toString()));
            re.setFichatitulacion(f);
                
            re.setFechainicioreserva((Date)txtFechaInicio.getValue());
            re.setFechafinreserva((Date)txtFechaFin.getValue());
            
            SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
            
            String h1 = format1.format(txtHoraInicio.getValue());
            String h2 = format1.format(txtHoraFin.getValue());
            re.setHorainicioreserva(h1);
            re.setHorafinreserva(h2);
            
            reservaDAO.editar(re);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Registro modificado!"));
            
        }catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "Error modificando datos"+ex.getMessage()));
        }
        
    }
    
    public  void eliminar(){
    
    }
}
