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
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import logic.FuncionarioLogicaLocal;
import logic.PersonalLogicaLocal;
import logic.SedeLogicaLocal;
import model.Funcionario;
import model.Personal;
import model.Reservaambiente;
import model.Sede;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author G40-80
 */
@Named(value = "vistaSede")
@RequestScoped
public class VistaSede {

  @EJB
  private SedeLogicaLocal sedeDAO;
  
  @EJB
  private PersonalLogicaLocal personalDAO;
  
  @EJB
  private FuncionarioLogicaLocal funcionarioDAO;
  
    private InputText txtIdSede;
    private InputText txtNombreSede;
    private InputText txtDireccionSede;
    private List<Sede> listaSede;
    private List<Funcionario> listaFuncionario;
    private Sede sedeSeleccionada;

    //Combo box id funcionario
    private String car;  
    private List<SelectItem> cars; 
   
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
  
    public VistaSede() {
          
          SelectItemGroup g2 = new SelectItemGroup("American Cars");
          g2.setSelectItems(new SelectItem[] {new SelectItem("hola1", "hola2")});
          
          cars = new ArrayList<>();
          
          cars.add(g2);
     
    }     

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    
    

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List<SelectItem> getCars() {
        return cars;
    }

    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
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

    public InputText getTxtIdSede() {
        return txtIdSede;
    }

    public void setTxtIdSede(InputText txtIdSede) {
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
            
            txtIdSede.setValue(s.getNumerosede());
            txtNombreSede.setValue(s.getNombresede());
            txtDireccionSede.setValue(s.getDireccionsede());
 
            btnRegistrar.setDisabled(true);
            btnModificar.setDisabled(false);
            btnEliminar.setDisabled(false);
                
        } catch (Exception ex) {
            Logger.getLogger(VistaReservaAmbiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
     
           
    
}
