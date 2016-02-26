/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import logic.FuncionarioLogicaLocal;
import logic.PersonalLogicaLocal;
import logic.SedeLogicaLocal;
import model.Ambientedeaprendizaje;
import model.Funcionario;
import model.Personal;
import model.Reservaambiente;
import model.Sede;
import model.Tipoambiente;
import model.Usodeambientes;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author G40-80
 */
@ManagedBean
@ViewScoped
public class VistaSede {

  @EJB
  private SedeLogicaLocal sedeDAO;
  
  @EJB
  private PersonalLogicaLocal personalDAO;
  
  @EJB
  private FuncionarioLogicaLocal funcionarioDAO;
  
  private Integer txtIdSede=null;
    private InputText txtNombreSede;
    private InputText txtDireccionSede;
    private List<Sede> listaSede=null;
    private List<Funcionario> listaFuncionario;
    private Sede sedeSeleccionada;

    //Combo box id funcionario
    private String comboFuncionario;  
    private List<SelectItem> comboFuncionarios; 
    
    //Combo box estado sede
    private String comboEstadoSede;  
    private List<SelectItem> comboEstadoSedes; 
   
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
  
    public VistaSede() {

    }  
    
     @PostConstruct
    public void Init()
    {
         llenarComboFuncionarios();  
         llenarComboEstadoSede();
    }  

    public String getComboFuncionario() {
        if (listaFuncionario == null) {
            try {
                listaFuncionario =funcionarioDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaFuncionario.get(0).getDocumentofuncionario()+"";
    }

    public void setComboFuncionario(String comboFuncionario) {
        this.comboFuncionario = comboFuncionario;
    }

    public List<SelectItem> getComboFuncionarios() {
        return comboFuncionarios;
    }

    public void setComboFuncionarios(List<SelectItem> comboFuncionarios) {
        this.comboFuncionarios = comboFuncionarios;
    }

    public String getComboEstadoSede() {
        return comboEstadoSede;
    }

    public void setComboEstadoSede(String comboEstadoSede) {
        this.comboEstadoSede = comboEstadoSede;
    }

    public List<SelectItem> getComboEstadoSedes() {
        return comboEstadoSedes;
    }

    public void setComboEstadoSedes(List<SelectItem> comboEstadoSedes) {
        this.comboEstadoSedes = comboEstadoSedes;
    }

    public List<Funcionario> getListaFuncionario() {
       if (listaFuncionario == null) {
            try {
                listaFuncionario = funcionarioDAO.consultarTodo();
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "Error en el get de la lista en vistambiente"+ex.getMessage()));
            }
        }
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    
    public FuncionarioLogicaLocal getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioLogicaLocal funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }   

    public Sede getSedeSeleccionada() {
        return sedeSeleccionada;
    }

    public void setSedeSeleccionada(Sede sedeSeleccionada) {
        this.sedeSeleccionada = sedeSeleccionada;
    }
    
    public List<Sede> getListaSede() {
       listaSede=null;
        if (listaSede == null) {
            try {
                listaSede = sedeDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSede;
    }

    public void setListaSede(List<Sede> listaSede) {
        this.listaSede = listaSede;
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

    public PersonalLogicaLocal getPersonalDAO() {
        return personalDAO;
    }

    public void setPersonalDAO(PersonalLogicaLocal personalDAO) {
        this.personalDAO = personalDAO;
    }
 
    public SedeLogicaLocal getSedeDAO() {
        return sedeDAO;
    }

    public void setSedeDAO(SedeLogicaLocal sedeDAO) {
        this.sedeDAO = sedeDAO;
    }

    public Integer getTxtIdSede() {
        if (listaSede == null) {
            try {
                listaSede = sedeDAO.consultarTodo();
                txtIdSede=codigoMayor();
            } catch (Exception ex) {
                Logger.getLogger(VistaSede.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return txtIdSede;
    }

    public void setTxtIdSede(Integer txtIdSede) {
        this.txtIdSede = txtIdSede;
    }

    public InputText getTxtNombreSede() {
        return txtNombreSede;
    }

    public void setTxtNombreSede(InputText txtNombreSede) {
        this.txtNombreSede = txtNombreSede;
    }

    public InputText getTxtDireccionSede() {
        return txtDireccionSede;
    }

    public void setTxtDireccionSede(InputText txtDireccionSede) {
        this.txtDireccionSede = txtDireccionSede;
    }

    public void onRowSelect(SelectEvent evt) {  
        try {
            Sede s = sedeSeleccionada;
            
            txtIdSede=(s.getNumerosede());
            txtNombreSede.setValue(s.getNombresede());
            txtDireccionSede.setValue(s.getDireccionsede());
            
             //llenar combo tipo ambiente
            Funcionario f = new Funcionario();
            f.setDocumentofuncionario(s.getDocumentofuncionario().getDocumentofuncionario());
            llenarComboBoxFuncionariosSeleccionado(f);
            
            //llenar combo estado ambiente
        llenarComboBoxEstadoSeleccionado(s.getEstadosede());
 
            btnRegistrar.setDisabled(true);
            btnModificar.setDisabled(false);
            btnEliminar.setDisabled(false);
                
        } catch (Exception ex) {
            Logger.getLogger(VistaSede.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void registrarSede()
   {
       int id=txtIdSede;
  
    String nombre="";
    String direccion="";   
    String estadoSede="";
    
    if (txtIdSede.toString().equals("") || txtNombreSede.toString().equals("") || txtDireccionSede.toString().equals(""))
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios"));
    }
    else
    {   
    nombre = txtNombreSede.getValue().toString();
    direccion = txtDireccionSede.getValue().toString();
 
    try
        {
            Funcionario f = new Funcionario();
    f.setDocumentofuncionario(Long.parseLong(comboFuncionario));
    
     estadoSede = comboEstadoSede;
     
            Sede s = new Sede();
            s.setNumerosede(id);
            s.setNombresede(nombre);
            s.setDireccionsede(direccion);
            s.setDocumentofuncionario(f);
            s.setEstadosede(estadoSede);
            
            sedeDAO.crear(s);
            
         //si todo sale bien aplique esto
            addMessage("Exito", "La sede se ha Registrado con exito");
            limpiar();
   
        }catch(Exception e5)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error 5 "+e5.getMessage()));
        }
    } 
   }
   
   public void modificarSede()
   {
       
   }
     
   public void eliminarSede()
   {
       
   }
   
   public void limpiar()
   {
       txtIdSede=codigoMayor();
        listaSede=null;
        txtNombreSede.setValue("");
        txtDireccionSede.setValue("");
        llenarComboFuncionarios();
        llenarComboEstadoSede();
   }
    
   public Integer codigoMayor(){
        
        int numero = (listaSede.get(listaSede.size()-1).getNumerosede())+1;
        return  numero;
    }
   
   
   public void llenarComboFuncionarios()
{
    List<Funcionario> lista = getListaFuncionario();  //lista de los tipos de ambiente 
        int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
            si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDocumentofuncionario()+""); // descripcion del nuevo item
        si.setValue(lista.get(n).getDocumentofuncionario()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboFuncionarios=datos;
}
   
   public void llenarComboBoxFuncionariosSeleccionado(Funcionario funcionario)
{
    List<Funcionario> lista = getListaFuncionario();  //lista de los tipos de ambiente 
     
    if(lista.contains(funcionario))
    {
    lista.remove(funcionario);
   lista.add(0, funcionario);
   
    int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDocumentofuncionario()+""); // descripcion del nuevo item
        si.setValue(lista.get(n).getDocumentofuncionario()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboFuncionarios=datos;
    }
    else
    {
          int n =0;
        
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        do
        {
        si = new SelectItem();  //creamos nuevo item
        si.setLabel(lista.get(n).getDocumentofuncionario()+""); // descripcion del nuevo item
        si.setValue(lista.get(n).getDocumentofuncionario()); //valor del nuevo item
        n++;
        
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        }while(n<lista.size());
        comboFuncionarios=datos;     
    }     
}
   
   public void llenarComboEstadoSede()
{ 
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
        
        comboEstadoSedes=datos;
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
        comboEstadoSedes=datos;
    }
    else
     {
        
     }
    
}
   
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
     
}
