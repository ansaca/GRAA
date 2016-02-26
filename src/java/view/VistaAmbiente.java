/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import logic.AmbientedeAprendizajeLogicaLocal;
import logic.FichaTitulacionLogicaLocal;
import logic.PersonalLogicaLocal;
import logic.ReservaAmbienteLogicaLocal;
import logic.SedeLogicaLocal;
import logic.TiposAmbienteLogicaLocal;
import model.Ambientedeaprendizaje;
import model.Fichatitulacion;
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
 * @author G40-80
 */
@ManagedBean
@ViewScoped
public final class VistaAmbiente {

    @EJB
    private AmbientedeAprendizajeLogicaLocal ambienteDAO;
    
    @EJB
    private TiposAmbienteLogicaLocal tipoDAO;
    
    @EJB
    private SedeLogicaLocal sedeDAO;
    
    private Integer txtIdAmbiente=null;
    private InputText txtNombreAmbiente;
    private InputText txtCapacidadAmbiente;
    private InputText txtAreaAmbiente;
    
    //Combo box tipo de ambiente
    private String comboTipoAmbiente;  
    private List<SelectItem> comboTiposAmbientes; 
  
    
    //Combo box id sede del ambiente
    private String comboSedeAmbiente;  
    private List<SelectItem> comboSedeAmbientes; 

    //Combo box estado ambiente
    private String comboestadoAmbiente;  
    private List<SelectItem> comboestadoAmbientes; 

    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;

    private List<Ambientedeaprendizaje> listaAmbiente;
    private Ambientedeaprendizaje ambienteSeleccionado;
    
    private List<Tipoambiente> listaTipo; //lista para llenar el combo tipoambiente
    private List<Sede> listaSede; //lista para llenar combo sedes
    
    public VistaAmbiente() {
          
    }   
    
    @PostConstruct
    public void Init()
    {
         llenarComboTiposAmbientes();
         llenarComboSedeAmbiente();
         llenarComboEstadoAmbiente();
    }    

    public List<Tipoambiente> getListaTipo() {
        if (listaTipo == null) {
            try {
                listaTipo =tipoDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaTipo;
    }

    public void setListaTipo(List<Tipoambiente> listaTipo) {
        this.listaTipo = listaTipo;
    }
    

    public TiposAmbienteLogicaLocal getTipoDAO() {
        return tipoDAO;
    }

    public void setTipoDAO(TiposAmbienteLogicaLocal tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public List<Sede> getListaSede() {
        listaSede=null;
       if (listaSede == null) {
            try {
                listaSede =sedeDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaSede;
    }

    public void setListaSede(List<Sede> listaSede) {
        this.listaSede = listaSede;
    }

    public AmbientedeAprendizajeLogicaLocal getAmbienteDAO() {
        return ambienteDAO;
    }

    public void setAmbienteDAO(AmbientedeAprendizajeLogicaLocal ambienteDAO) {
        this.ambienteDAO = ambienteDAO;
    }

    public Integer getTxtIdAmbiente() {
        if (listaAmbiente == null) {
            try {
                
                listaAmbiente = ambienteDAO.consultarTodo();
                txtIdAmbiente=codigoMayor();
            } catch (Exception ex) {
                Logger.getLogger(VistaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return txtIdAmbiente;
    }

    public void setTxtIdAmbiente(Integer txtIdAmbiente) {
        this.txtIdAmbiente = txtIdAmbiente;
    }

    public SedeLogicaLocal getSedeDAO() {
        return sedeDAO;
    }

    public void setSedeDAO(SedeLogicaLocal sedeDAO) {
        this.sedeDAO = sedeDAO;
    }

    

    public InputText getTxtNombreAmbiente() {
        return txtNombreAmbiente;
    }

    public void setTxtNombreAmbiente(InputText txtNombreAmbiente) {
        this.txtNombreAmbiente = txtNombreAmbiente;
    }

    public InputText getTxtCapacidadAmbiente() {
        return txtCapacidadAmbiente;
    }

    public void setTxtCapacidadAmbiente(InputText txtCapacidadAmbiente) {
        this.txtCapacidadAmbiente = txtCapacidadAmbiente;
    }

    public InputText getTxtAreaAmbiente() {
        return txtAreaAmbiente;
    }

    public void setTxtAreaAmbiente(InputText txtAreaAmbiente) {
        this.txtAreaAmbiente = txtAreaAmbiente;
    }

    public String getComboTipoAmbiente() {
        if (listaTipo == null) {
            try {
                listaTipo =tipoDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaTipo.get(0).getCodigotipoambiente()+"";
    }

    public void setComboTipoAmbiente(String comboTipoAmbiente) {
        this.comboTipoAmbiente = comboTipoAmbiente;
    }

    public List<SelectItem> getComboTiposAmbientes() {
        return comboTiposAmbientes;
    }

    public void setComboTiposAmbientes(List<SelectItem> comboTiposAmbientes) {
        this.comboTiposAmbientes = comboTiposAmbientes;
    }

    public String getComboSedeAmbiente() {
        listaSede=null;
       if (listaSede == null) {
            try {
                listaSede =sedeDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaTipo.get(0).getCodigotipoambiente()+"";
    }

    public void setComboSedeAmbiente(String comboSedeAmbiente) {
        this.comboSedeAmbiente = comboSedeAmbiente;
    }

    public List<SelectItem> getComboSedeAmbientes() {
        return comboSedeAmbientes;
    }

    public void setComboSedeAmbientes(List<SelectItem> comboSedeAmbientes) {
        this.comboSedeAmbientes = comboSedeAmbientes;
    }

    public String getComboestadoAmbiente() {
        return comboestadoAmbiente;
    }

    public void setComboestadoAmbiente(String comboestadoAmbiente) {
        this.comboestadoAmbiente = comboestadoAmbiente;
    }

    public List<SelectItem> getComboestadoAmbientes() {
        return comboestadoAmbientes;
    }

    public void setComboestadoAmbientes(List<SelectItem> comboestadoAmbientes) {
        this.comboestadoAmbientes = comboestadoAmbientes;
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

    public List<Ambientedeaprendizaje> getListaAmbiente() {
        if (listaAmbiente == null) {
            try {
                listaAmbiente = ambienteDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaAmbiente;
    }

    public void setListaAmbiente(List<Ambientedeaprendizaje> listaAmbiente) {
        this.listaAmbiente = listaAmbiente;
    }

    public Ambientedeaprendizaje getAmbienteSeleccionado() {
        return ambienteSeleccionado;
    }

    public void setAmbienteSeleccionado(Ambientedeaprendizaje ambienteSeleccionado) {
        this.ambienteSeleccionado = ambienteSeleccionado;
    }
    
    public void OnRowSelect(SelectEvent evt)
    {
           Ambientedeaprendizaje a = ambienteSeleccionado;
        txtIdAmbiente = (a.getCodigoambiente());
        txtNombreAmbiente.setValue(a.getNombreambiente());
        txtCapacidadAmbiente.setValue(a.getCapacidadambiente());
        txtAreaAmbiente.setValue(a.getAreaambiente());

        //llenar combo tipo ambiente
        Tipoambiente t = new Tipoambiente();
        t.setCodigotipoambiente(a.getCodigotipoambiente().getCodigotipoambiente());
        t.setDescripciontipoambiente(a.getCodigotipoambiente().getDescripciontipoambiente());
        llenarComboBoxTiposAmbientesSeleccionado(t);

        //llenar combo sede ambiente
        Sede s = new Sede();
        s.setNumerosede(a.getNumerosedeambiente().getNumerosede());
        s.setNombresede(a.getNumerosedeambiente().getNombresede());
        llenarComboBoxSedeSeleccionado(s);

        //llenar combo estado ambiente
        llenarComboBoxEstadoSeleccionado(a.getEstadoambiente());

        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);  

    }
    
    public void limpiar()
    {
        txtIdAmbiente=codigoMayor();
        listaAmbiente=null;
        txtNombreAmbiente.setValue("");
        txtCapacidadAmbiente.setValue("");
        txtAreaAmbiente.setValue("");
        btnRegistrar.setDisabled(false);
        btnEliminar.setDisabled(true);
        btnModificar.setDisabled(true);
        llenarComboTiposAmbientes();
        llenarComboSedeAmbiente();
        llenarComboEstadoAmbiente();
        
    }

public void llenarComboTiposAmbientes()
{
    List<Tipoambiente> lista = getListaTipo();  //lista de los tipos de ambiente 
        int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
            si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDescripciontipoambiente()); // descripcion del nuevo item
        si.setValue(lista.get(n).getCodigotipoambiente()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboTiposAmbientes=datos;
}
    

public void llenarComboSedeAmbiente()
{
    List<Sede> listaSede = getListaSede();  //lista de los tipos de ambiente 
        int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
            si = new SelectItem();  //creamos nuevo item
        si.setLabel(listaSede.get(n).getNombresede()); // descripcion del nuevo item
        si.setValue(listaSede.get(n).getNumerosede()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<listaSede.size());
        comboSedeAmbientes=datos;
}


public void llenarComboEstadoAmbiente()
{ 
      comboestadoAmbientes=null;
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        
        si = new SelectItem();  //creamos nuevo item
        si.setLabel("Disponible"); // descripcion del nuevo item
        si.setValue("Disponible"); //valor del nuevo item
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        si = new SelectItem();  //creamos nuevo item
        si.setLabel("Ocupado"); // descripcion del nuevo item
        si.setValue("Ocupado"); //valor del nuevo item
        datos.add(si); // añadimos el nuevo item a la lista de items
        
        comboestadoAmbientes=datos;
}

public Integer codigoMayor(){
        
        int numero = (listaAmbiente.get(listaAmbiente.size()-1).getCodigoambiente())+1;
        return  numero;
    }

public void registrarAmbiente()
{ 
    int id=txtIdAmbiente;
   
    String nombre="";
    int capacidad=0;
    int area=0;
    String estadoAmbiente="";
    
    
    if (txtIdAmbiente.toString().equals("") || txtNombreAmbiente.toString().equals("") || txtCapacidadAmbiente.toString().equals("") || txtAreaAmbiente.toString().equals(""))
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios"));
    }
    else
    {   
    nombre = txtNombreAmbiente.getValue().toString();
    
    try
    {
        capacidad = Integer.parseInt(txtCapacidadAmbiente.getValue().toString());
    }catch(NumberFormatException e2)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error 2 ", "El campo Capacidad solo permite numeros."));
    }
    
    try
    {
         area = Integer.parseInt(txtAreaAmbiente.getValue().toString());
    }catch(NumberFormatException e3)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error 3 ", "El campo Area solo permite numeros."));
    }
   
    try
        {
            Tipoambiente t = new Tipoambiente();
    t.setCodigotipoambiente(Integer.parseInt(comboTipoAmbiente));
    
            Sede s = new Sede();
    s.setNumerosede(Integer.parseInt(comboSedeAmbiente));
    
     estadoAmbiente = comboestadoAmbiente;
    
            Ambientedeaprendizaje a = new Ambientedeaprendizaje();
            a.setCodigoambiente(id);
            a.setNombreambiente(nombre);
            a.setCapacidadambiente(capacidad);
            a.setAreaambiente(area);
            a.setCodigotipoambiente(t);
            a.setNumerosedeambiente(s);
            a.setEstadoambiente(estadoAmbiente);
            
            List<Reservaambiente> listaReserva =null;
            a.setReservaambienteList(listaReserva);
            
            List<Usodeambientes> listaUsos = null;
            a.setUsodeambientesList(listaUsos);
            
          ambienteDAO.crear(a);
            
         //si todo sale bien aplique esto
            addMessage("Exito", "El ambiente se ha Registrado con exito");
            limpiar();
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error 5 "+e5.getMessage()));
        }
    } 
}


public void eliminar()
{
        try {
            int id=txtIdAmbiente;
            
            Ambientedeaprendizaje a = new Ambientedeaprendizaje();
            a.setCodigoambiente(id);
            ambienteDAO.eliminar(a);
            
            //si todo sale bien aplique esto
            addMessage("Exito", "El ambiente se ha modificado con exito");
            limpiar();
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Error eliminando el ambiente"));
        }
    
}


public void llenarComboBoxTiposAmbientesSeleccionado(Tipoambiente tipo)
{
    List<Tipoambiente> lista = getListaTipo();  //lista de los tipos de ambiente 
     
    if(lista.contains(tipo))
    {
    lista.remove(tipo);
   lista.add(0, tipo);
   
    int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDescripciontipoambiente()); // descripcion del nuevo item
        si.setValue(lista.get(n).getCodigotipoambiente()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboTiposAmbientes=datos;
    }
    else
    {
          int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDescripciontipoambiente()); // descripcion del nuevo item
        si.setValue(lista.get(n).getCodigotipoambiente()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboTiposAmbientes=datos;     
    }     
}

public void llenarComboBoxSedeSeleccionado(Sede sede)
{
 
    List<Sede> lista = getListaSede();  //lista de los tipos de ambiente 
      
     if(lista.contains(sede))
    {
    lista.remove(sede);
   lista.add(0, sede);
    
    int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getNombresede()); // descripcion del nuevo item
        si.setValue(lista.get(n).getNumerosede()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboSedeAmbientes=datos;
    }
    else
     {
         int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getNombresede()); // descripcion del nuevo item
        si.setValue(lista.get(n).getNumerosede()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboSedeAmbientes=datos;
     }
    
}


public void llenarComboBoxEstadoSeleccionado(String estadoSeleccionado)
{
 
    List<String> listaEstado= new ArrayList<>();
    
    listaEstado.add("Disponible");
    listaEstado.add("Ocupado");
    
     if(listaEstado.contains(estadoSeleccionado))
    {
    listaEstado.remove(estadoSeleccionado);
   listaEstado.add(0, estadoSeleccionado);
    
    int n =0;
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(listaEstado.get(n)); // descripcion del nuevo item
        si.setValue(listaEstado.get(n)); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<listaEstado.size());
        comboestadoAmbientes=datos;
    }
    else
     {
        
     }
    
}

//metodos

public void modificarambiente(){
    
    int id=txtIdAmbiente;
    String nombre="";
    int capacidad=0;
    int area=0;
    String estadoAmbiente="";
    
    if (txtIdAmbiente.toString().equals("") || txtNombreAmbiente.toString().equals("") || txtCapacidadAmbiente.toString().equals("") || txtAreaAmbiente.toString().equals(""))
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios"));
    }
    else
    {   
    nombre = txtNombreAmbiente.getValue().toString();
    
    try
    {
        capacidad = Integer.parseInt(txtCapacidadAmbiente.getValue().toString());
    }catch(NumberFormatException e2)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error 2 ", "El campo Capacidad solo permite numeros."));
    }
    
    try
    {
         area = Integer.parseInt(txtAreaAmbiente.getValue().toString());
    }catch(NumberFormatException e3)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error 3 ", "El campo Area solo permite numeros."));
    }
   
    try
        {
            Tipoambiente t = new Tipoambiente();
    t.setCodigotipoambiente(Integer.parseInt(comboTipoAmbiente));
    
            Sede s = new Sede();
    s.setNumerosede(Integer.parseInt(comboSedeAmbiente));
    
     estadoAmbiente = comboestadoAmbiente;
    
            Ambientedeaprendizaje a = new Ambientedeaprendizaje();
            a.setCodigoambiente(id);
            a.setNombreambiente(nombre);
            a.setCapacidadambiente(capacidad);
            a.setAreaambiente(area);
            a.setCodigotipoambiente(t);
            a.setNumerosedeambiente(s);
            a.setEstadoambiente(estadoAmbiente);
            
            List<Reservaambiente> listaReserva =null;
            a.setReservaambienteList(listaReserva);
            
            List<Usodeambientes> listaUsos = null;
            a.setUsodeambientesList(listaUsos);
            
          ambienteDAO.modificar(a);
            
            //si todo sale bien aplique esto
            addMessage("Exito", "El ambiente se ha modificado con exito");
            limpiar();
    
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error 5 "+e5.getMessage()));
        }
    } 
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
