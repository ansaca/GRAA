/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logic.CoordinadorLogicaLocal;
import logic.PersonalLogicaLocal;
import model.Area;
import model.Coordinador;
import model.Funcionario;
import model.Guarda;
import model.Instructor;
import model.Personal;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.column.Column;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author andres
 */
@ManagedBean
@SessionScoped
public class VistaPersonal {

    @EJB
    public PersonalLogicaLocal personalDAO;
    
    @EJB
    public CoordinadorLogicaLocal coordinadorDAO;
    
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
    
    //Combo box rol
    private String comboRol;  
    private List<SelectItem> combosRol; 
    
     //Combo box tipo coordinador
    private String comboTipoCoordinador;  
    private List<SelectItem> combosTipoCoordinador; 
    
    //mandar a coordinador
    public String cedulaRetornar;
    public String llegada;
    
    //salidas de texto    
    private Column columnaRol;
    private Column columnaLabelRol;
    
    private Column columnaLabelRegistrarComo;
    private Column columnaComboRegistrarComo;
    
    //combobox registrar como
    private String comboRegistrarComo;  
    private List<SelectItem> combosRegistrarComo; 

    private CommandButton btnRegistrarComo;
    
    
    
    
    
    
    
    //en el xhtml de coordinador
    public InputText txtCedulaPersonalCoordinador;
    public InputText txtTipoCoordinador;
    
    private List<Coordinador> listaCoordinador;
    private Coordinador coordinadorSeleccionado;
    
    private CommandButton btnRegistrarCoordinador;
    private CommandButton btnModificarCoordinador;
    private CommandButton btnEliminarCoordinador;
    private CommandButton btnLimpiarCoordinador;
    
    
    
    
    
    
    
     //en el xhtml de Funcionarios
    public InputText txtCedulaPersonalFuncionario;
    
    //lista de tipo area para sacar todos los nombres de las areas registradas
    List<Area> listaArea;
    
    //combobox para mostrar el tipo de area
    private String comboArea;  
    private List<SelectItem> combosArea; 
    
    private List<Funcionario> listaFuncionarios;
    private Funcionario funcionarioSeleccionado;
    
    private CommandButton btnRegistrarFuncionario;
    private CommandButton btnModificarFuncionario;
    private CommandButton btnEliminarFuncionario;
    private CommandButton btnLimpiarFuncionario;
    
    
    
    
    
    
     //en el xhtml de Instructor
    public InputText txtCedulaPersonalInstructor;
   
    //combobox tipo de instructor
    private String comboTipoInstructor;  
    private List<SelectItem> combosTipoInstructor; 
    
     public InputText txtPerfilOcupacionalInstructor;
     public InputText txtLogroInstructor;
    
    private List<Instructor> listaInstructor;
    private Instructor InstructorSeleccionado;
    
    private CommandButton btnRegistrarInstructor;
    private CommandButton btnModificarInstructor;
    private CommandButton btnEliminarInstructor;
    private CommandButton btnLimpiarInstructor;
    
    
    
    
    
    
    
     //en el xhtml de Guarda
    public InputText txtCedulaPersonalGuarda;
    
    private List<Guarda> listaGuarda;
    private Guarda GuardaSeleccionado;
    
    private CommandButton btnRegistrarGuarda;
    private CommandButton btnEliminarGuarda;
    private CommandButton btnLimpiarGuarda;
    
    
    
    
    
    
    public VistaPersonal() {

    }
    
      @PostConstruct
    public void Init()
    {
         llenarComboRol();
    } 

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }
    
    

    public Column getColumnaLabelRol() {
        return columnaLabelRol;
    }

    public void setColumnaLabelRol(Column columnaLabelRol) {
        this.columnaLabelRol = columnaLabelRol;
    }

    public String getComboRegistrarComo() {
        return comboRegistrarComo;
    }

    public void setComboRegistrarComo(String comboRegistrarComo) {
        this.comboRegistrarComo = comboRegistrarComo;
    }

    public List<SelectItem> getCombosRegistrarComo() {
        return combosRegistrarComo;
    }

    public void setCombosRegistrarComo(List<SelectItem> combosRegistrarComo) {
        this.combosRegistrarComo = combosRegistrarComo;
    }

    public Column getColumnaLabelRegistrarComo() {
        return columnaLabelRegistrarComo;
    }

    public void setColumnaLabelRegistrarComo(Column columnaLabelRegistrarComo) {
        this.columnaLabelRegistrarComo = columnaLabelRegistrarComo;
    }

    public Column getColumnaComboRegistrarComo() {
        return columnaComboRegistrarComo;
    }

    public void setColumnaComboRegistrarComo(Column columnaComboRegistrarComo) {
        this.columnaComboRegistrarComo = columnaComboRegistrarComo;
    }

    public CommandButton getBtnRegistrarComo() {
        return btnRegistrarComo;
    }

    public void setBtnRegistrarComo(CommandButton btnRegistrarComo) {
        this.btnRegistrarComo = btnRegistrarComo;
    }
    
    

    public Column getColumnaRol() {
        return columnaRol;
    }

    public void setColumnaRol(Column columnaRol) {
        this.columnaRol = columnaRol;
    }
    
    
    public CoordinadorLogicaLocal getCoordinadorDAO() {
        return coordinadorDAO;
    }

    public void setCoordinadorDAO(CoordinadorLogicaLocal coordinadorDAO) {
        this.coordinadorDAO = coordinadorDAO;
    }

    public InputText getTxtCedulaPersonalFuncionario() {
        return txtCedulaPersonalFuncionario;
    }

    public void setTxtCedulaPersonalFuncionario(InputText txtCedulaPersonalFuncionario) {
        this.txtCedulaPersonalFuncionario = txtCedulaPersonalFuncionario;
    }

    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }

    public String getComboArea() {
        return comboArea;
    }

    public void setComboArea(String comboArea) {
        this.comboArea = comboArea;
    }

    public List<SelectItem> getCombosArea() {
        return combosArea;
    }

    public void setCombosArea(List<SelectItem> combosArea) {
        this.combosArea = combosArea;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Funcionario getFuncionarioSeleccionado() {
        return funcionarioSeleccionado;
    }

    public void setFuncionarioSeleccionado(Funcionario funcionarioSeleccionado) {
        this.funcionarioSeleccionado = funcionarioSeleccionado;
    }

    public CommandButton getBtnRegistrarFuncionario() {
        return btnRegistrarFuncionario;
    }

    public void setBtnRegistrarFuncionario(CommandButton btnRegistrarFuncionario) {
        this.btnRegistrarFuncionario = btnRegistrarFuncionario;
    }

    public CommandButton getBtnModificarFuncionario() {
        return btnModificarFuncionario;
    }

    public void setBtnModificarFuncionario(CommandButton btnModificarFuncionario) {
        this.btnModificarFuncionario = btnModificarFuncionario;
    }

    public CommandButton getBtnEliminarFuncionario() {
        return btnEliminarFuncionario;
    }

    public void setBtnEliminarFuncionario(CommandButton btnEliminarFuncionario) {
        this.btnEliminarFuncionario = btnEliminarFuncionario;
    }

    public CommandButton getBtnLimpiarFuncionario() {
        return btnLimpiarFuncionario;
    }

    public void setBtnLimpiarFuncionario(CommandButton btnLimpiarFuncionario) {
        this.btnLimpiarFuncionario = btnLimpiarFuncionario;
    }

    public InputText getTxtCedulaPersonalInstructor() {
        return txtCedulaPersonalInstructor;
    }

    public void setTxtCedulaPersonalInstructor(InputText txtCedulaPersonalInstructor) {
        this.txtCedulaPersonalInstructor = txtCedulaPersonalInstructor;
    }

    public String getComboTipoInstructor() {
        return comboTipoInstructor;
    }

    public void setComboTipoInstructor(String comboTipoInstructor) {
        this.comboTipoInstructor = comboTipoInstructor;
    }

    public List<SelectItem> getCombosTipoInstructor() {
        return combosTipoInstructor;
    }

    public void setCombosTipoInstructor(List<SelectItem> combosTipoInstructor) {
        this.combosTipoInstructor = combosTipoInstructor;
    }

    public InputText getTxtPerfilOcupacionalInstructor() {
        return txtPerfilOcupacionalInstructor;
    }

    public void setTxtPerfilOcupacionalInstructor(InputText txtPerfilOcupacionalInstructor) {
        this.txtPerfilOcupacionalInstructor = txtPerfilOcupacionalInstructor;
    }

    public InputText getTxtLogroInstructor() {
        return txtLogroInstructor;
    }

    public void setTxtLogroInstructor(InputText txtLogroInstructor) {
        this.txtLogroInstructor = txtLogroInstructor;
    }

    public List<Instructor> getListaInstructor() {
        return listaInstructor;
    }

    public void setListaInstructor(List<Instructor> listaInstructor) {
        this.listaInstructor = listaInstructor;
    }

    public Instructor getInstructorSeleccionado() {
        return InstructorSeleccionado;
    }

    public void setInstructorSeleccionado(Instructor InstructorSeleccionado) {
        this.InstructorSeleccionado = InstructorSeleccionado;
    }

    public CommandButton getBtnRegistrarInstructor() {
        return btnRegistrarInstructor;
    }

    public void setBtnRegistrarInstructor(CommandButton btnRegistrarInstructor) {
        this.btnRegistrarInstructor = btnRegistrarInstructor;
    }

    public CommandButton getBtnModificarInstructor() {
        return btnModificarInstructor;
    }

    public void setBtnModificarInstructor(CommandButton btnModificarInstructor) {
        this.btnModificarInstructor = btnModificarInstructor;
    }

    public CommandButton getBtnEliminarInstructor() {
        return btnEliminarInstructor;
    }

    public void setBtnEliminarInstructor(CommandButton btnEliminarInstructor) {
        this.btnEliminarInstructor = btnEliminarInstructor;
    }

    public CommandButton getBtnLimpiarInstructor() {
        return btnLimpiarInstructor;
    }

    public void setBtnLimpiarInstructor(CommandButton btnLimpiarInstructor) {
        this.btnLimpiarInstructor = btnLimpiarInstructor;
    }

    public InputText getTxtCedulaPersonalGuarda() {
        return txtCedulaPersonalGuarda;
    }

    public void setTxtCedulaPersonalGuarda(InputText txtCedulaPersonalGuarda) {
        this.txtCedulaPersonalGuarda = txtCedulaPersonalGuarda;
    }

    public List<Guarda> getListaGuarda() {
        return listaGuarda;
    }

    public void setListaGuarda(List<Guarda> listaGuarda) {
        this.listaGuarda = listaGuarda;
    }

    public Guarda getGuardaSeleccionado() {
        return GuardaSeleccionado;
    }

    public void setGuardaSeleccionado(Guarda GuardaSeleccionado) {
        this.GuardaSeleccionado = GuardaSeleccionado;
    }

    public CommandButton getBtnRegistrarGuarda() {
        return btnRegistrarGuarda;
    }

    public void setBtnRegistrarGuarda(CommandButton btnRegistrarGuarda) {
        this.btnRegistrarGuarda = btnRegistrarGuarda;
    }

    public CommandButton getBtnEliminarGuarda() {
        return btnEliminarGuarda;
    }

    public void setBtnEliminarGuarda(CommandButton btnEliminarGuarda) {
        this.btnEliminarGuarda = btnEliminarGuarda;
    }

    public CommandButton getBtnLimpiarGuarda() {
        return btnLimpiarGuarda;
    }

    public void setBtnLimpiarGuarda(CommandButton btnLimpiarGuarda) {
        this.btnLimpiarGuarda = btnLimpiarGuarda;
    }

    
    
    public List<Coordinador> getListaCoordinador() {
       if (listaCoordinador == null) {
            try {
                listaCoordinador = coordinadorDAO.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCoordinador;
    }

    public void setListaCoordinador(List<Coordinador> listaCoordinador) {
        this.listaCoordinador = listaCoordinador;
    }

    public Coordinador getCoordinadorSeleccionado() {
        return coordinadorSeleccionado;
    }

    public void setCoordinadorSeleccionado(Coordinador coordinadorSeleccionado) {
        this.coordinadorSeleccionado = coordinadorSeleccionado;
    }

    public CommandButton getBtnRegistrarCoordinador() {
        return btnRegistrarCoordinador;
    }

    public void setBtnRegistrarCoordinador(CommandButton btnRegistrarCoordinador) {
        this.btnRegistrarCoordinador = btnRegistrarCoordinador;
    }

    public CommandButton getBtnModificarCoordinador() {
        return btnModificarCoordinador;
    }

    public void setBtnModificarCoordinador(CommandButton btnModificarCoordinador) {
        this.btnModificarCoordinador = btnModificarCoordinador;
    }

    public CommandButton getBtnEliminarCoordinador() {
        return btnEliminarCoordinador;
    }

    public void setBtnEliminarCoordinador(CommandButton btnEliminarCoordinador) {
        this.btnEliminarCoordinador = btnEliminarCoordinador;
    }

    public CommandButton getBtnLimpiarCoordinador() {
        return btnLimpiarCoordinador;
    }

    public void setBtnLimpiarCoordinador(CommandButton btnLimpiarCoordinador) {
        this.btnLimpiarCoordinador = btnLimpiarCoordinador;
    }
    
    

    public InputText getTxtCedulaPersonalCoordinador() {
        return txtCedulaPersonalCoordinador;
    }

    public void setTxtCedulaPersonalCoordinador(InputText txtCedulaPersonalCoordinador) {
        this.txtCedulaPersonalCoordinador = txtCedulaPersonalCoordinador;
    }

    public InputText getTxtTipoCoordinador() {
        return txtTipoCoordinador;
    }

    public void setTxtTipoCoordinador(InputText txtTipoCoordinador) {
        this.txtTipoCoordinador = txtTipoCoordinador;
    }

    
    
    public String getCedulaRetornar() {
       
        return cedulaRetornar;
    }

    public void setCedulaRetornar(String cedulaRetornar) {
        this.cedulaRetornar = cedulaRetornar;
    }
    
    public String getComboTipoCoordinador() {
        return comboTipoCoordinador;
    }

    public void setComboTipoCoordinador(String comboTipoCoordinador) {
        this.comboTipoCoordinador = comboTipoCoordinador;
    }

    public List<SelectItem> getCombosTipoCoordinador() {
        return combosTipoCoordinador;
    }

    public void setCombosTipoCoordinador(List<SelectItem> combosTipoCoordinador) {
        this.combosTipoCoordinador = combosTipoCoordinador;
    }
    
    

    public String getComboRol() {
        return comboRol;
    }

    public void setComboRol(String comboRol) {
        this.comboRol = comboRol;
    }

    public List<SelectItem> getCombosRol() {
        return combosRol;
    }

    public void setCombosRol(List<SelectItem> combosRol) {
        this.combosRol = combosRol;
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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios."));
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
            cedulaRetornar=p.getDocumentopersonal()+"";
            
            personalDAO.crear(p);
            
            switch (comboRol) {
                
            case "Coordinador":
                FacesContext.getCurrentInstance().getPartialViewContext().getExecuteIds().add("alert('peek-a-boo');" );
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionCoordinador.xhtml");
           llegada="nuevo";
            break;
            
            case "Funcionario":  
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionFuncionario.xhtml");
            llegada="nuevo";
            break;
            
            
            case "Instructor":
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionInstructor.xhtml");
            llegada="nuevo";
            break;
            
            case "Guarda":
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionGuarda.xhtml");
            llegada="nuevo";
            break;
            
            case "Ninguno":
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El personal se ha registrado con éxito."));
            break;              
            
            default:
            break;
            
            }

            limpiar();
            
            } catch (Exception e5) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del nuevo personal."+e5.getMessage()));
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
        
        llenarComboRol();
        
         columnaRol.setRendered(true);
        columnaLabelRol.setRendered(true);
        
        columnaComboRegistrarComo.setRendered(false); 
       columnaLabelRegistrarComo.setRendered(false);
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
 
        columnaRol.setRendered(false);
        columnaLabelRol.setRendered(false);
                
       columnaComboRegistrarComo.setRendered(true); 
       columnaLabelRegistrarComo.setRendered(true);
       llenarComboRegistrarComo();

    }
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
     public void llenarComboRol()
{ 
      combosRol=null;
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos

        
        si = new SelectItem();  //creamos nuevo item
        si.setLabel("Ninguno"); // descripcion del nuevo item
        si.setValue("Ninguno"); //valor del nuevo item
        datos.add(si); // añadimos el nuevo item a la lista de items
            
        si = new SelectItem();  //creamos nuevo item
        si.setLabel("Coordinador"); // descripcion del nuevo item
        si.setValue("Coordinador"); //valor del nuevo item
        datos.add(si); // añadimos el nuevo item a la lista de items
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Funcionario"); // descripcion del nuevo item
        si.setValue("Funcionario"); //valor del nuevo item
        datos.add(si);
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Instructor"); // descripcion del nuevo item
        si.setValue("Instructor"); //valor del nuevo item
        datos.add(si);
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Guarda"); // descripcion del nuevo item
        si.setValue("Guarda"); //valor del nuevo item
        datos.add(si);
        
        combosRol=datos;
}
     
     public void llenarComboRegistrarComo()
     {
        combosRegistrarComo=null;
        SelectItem si; //este sera un nuevo item
        List<SelectItem> datos = new ArrayList<SelectItem>();  //esta es la lista que alojara los items nuevos
            
        si = new SelectItem();  //creamos nuevo item
        si.setLabel("Coordinador"); // descripcion del nuevo item
        si.setValue("Coordinador"); //valor del nuevo item
        datos.add(si); // añadimos el nuevo item a la lista de items
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Funcionario"); // descripcion del nuevo item
        si.setValue("Funcionario"); //valor del nuevo item
        datos.add(si);
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Instructor"); // descripcion del nuevo item
        si.setValue("Instructor"); //valor del nuevo item
        datos.add(si);
        
         si = new SelectItem();  //creamos nuevo item
        si.setLabel("Guarda"); // descripcion del nuevo item
        si.setValue("Guarda"); //valor del nuevo item
        datos.add(si);
        
        combosRegistrarComo=datos;
     }
     
     
     public void registrarComo()
     {
         
    switch (comboRegistrarComo) {
                
            case "Coordinador":
    {
        try {
            cedulaRetornar=txtCedulaPersonal.getValue().toString();
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionCoordinador.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
            break;
            
            case "Funcionario":  
    {
        try {
            cedulaRetornar=txtCedulaPersonal.getValue().toString();
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionFuncionario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            break;
            
            
            case "Instructor":
    {
        try {
            cedulaRetornar=txtCedulaPersonal.getValue().toString();
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionInstructor.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            break;
            
            case "Guarda":
    {
        try {
            cedulaRetornar=txtCedulaPersonal.getValue().toString();
            FacesContext.getCurrentInstance().getExternalContext().redirect("gestionGuarda.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(VistaPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            break;         
            
            default:
            break;
            
            }
         
     }
     
             
             
             
             
     
     
     
     
 // xhtml coordinador
     
     public void registrarCoordinador()
     {
            long cedula = 0;
            String Tipo = "";
            
            int excepciones = 0;
            
            if (txtCedulaPersonalCoordinador.getValue().toString().equals("") || txtTipoCoordinador.getValue().toString().equals("") )
            {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios."));
            }
            else
            {
            
            try {
            cedula = Long.parseLong(txtCedulaPersonalCoordinador.getValue().toString());
            } catch (Exception error1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El campo cedula solo permite numeros."));
            excepciones++;
            }

            Tipo = txtTipoCoordinador.getValue().toString();

            if (excepciones == 0) {
            try {
            Coordinador c = new Coordinador();
            c.setDocumentocoordinador(cedula);
            c.setTipocoordinador(Tipo);

            coordinadorDAO.crear(c);

            //si todo sale bien aplique esto
            addMessage("Exito", "El coordinador se ha Registrado con éxito.");
            limpiarCoordinador();
            
            } catch (Exception e5) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del nuevo Coordinador."+e5.getMessage()));
            }
            } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Verifique los datos."));
            }
            
            }
         
         
     }
     
     public void modificarCoordinador()
     {
         
            long cedula = 0;
            String Tipo = "";
            
            int excepciones = 0;
            
            if (txtCedulaPersonalCoordinador.getValue().toString().equals("") || txtTipoCoordinador.getValue().toString().equals("") )
            {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Todos los campos son obligatorios."));
            }
            else
            {
            
            try {
            cedula = Long.parseLong(txtCedulaPersonalCoordinador.getValue().toString());
            } catch (Exception error1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El campo cedula solo permite numeros."));
            excepciones++;
            }

            Tipo = txtTipoCoordinador.getValue().toString();

            if (excepciones == 0) {
            try {
            Coordinador c = new Coordinador();
            c.setDocumentocoordinador(cedula);
            c.setTipocoordinador(Tipo);

            coordinadorDAO.modificar(c);

            //si todo sale bien aplique esto
            addMessage("Exito", "El coordinador se ha Modificado con éxito.");
            limpiarCoordinador();
            
            } catch (Exception e5) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del Coordinador a modificar."+e5.getMessage()));
            }
            } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Verifique los datos."));
            }
            
            }
         
     }
     
     public void eliminarCoordinador()
     {
         long cedula = 0;
            
            int excepciones = 0;
            
            if (txtCedulaPersonalCoordinador.getValue().toString().equals(""))
            {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Seleccione un coordinador para poderlo eliminar."));
            }
            else
            {
            
            try {
            cedula = Long.parseLong(txtCedulaPersonalCoordinador.getValue().toString());
            } catch (Exception error1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El campo cedula solo permite numeros."));
            excepciones++;
            }

            if (excepciones == 0) {
            try {
            Coordinador c = new Coordinador();
            c.setDocumentocoordinador(cedula);

            coordinadorDAO.eliminar(c);

            //si todo sale bien aplique esto
            addMessage("Exito", "El coordinador se ha Eliminado con éxito.");
            limpiarCoordinador();
            
            } catch (Exception e5) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Error llenando los datos del Coordinador a eliminar."+e5.getMessage()));
            }
            } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Verifique los datos."));
            }
            
            }
     }
     
     public void limpiarCoordinador()
     {
         listaCoordinador=null;
         txtCedulaPersonalCoordinador.setDisabled(false);
         txtCedulaPersonalCoordinador.setValue("");
         txtTipoCoordinador.setValue("");
         btnRegistrarCoordinador.setDisabled(false);
         btnModificarCoordinador.setDisabled(true);
         btnEliminarCoordinador.setDisabled(true);
         
         
     }
     
    public void OnRowSelectCoordinador(SelectEvent evt)
    {
          Coordinador c = coordinadorSeleccionado;
        txtCedulaPersonalCoordinador.setValue(c.getDocumentocoordinador());
        txtTipoCoordinador.setValue(c.getTipocoordinador());

        btnRegistrarCoordinador.setDisabled(true);
        btnModificarCoordinador.setDisabled(false);
        btnEliminarCoordinador.setDisabled(false);
        txtCedulaPersonalCoordinador.setDisabled(true);

    }
     
    
    
    //para el caso de funcionarios
    
    
    
    
    
    
    
    
    
    
    
    public void mensajeBienvenidaCoordinador()
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El personal se ha registrado con éxito, a continuación registrelo como Coordinador."));

    }
    
     public void mensajeBienvenidaFuncionario()
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El personal se ha registrado con éxito, a continuación registrelo como Funcionario."));

    }
     
      public void mensajeBienvenidaInstructor()
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El personal se ha registrado con éxito, a continuación registrelo como Instructor."));

    }
      
       public void mensajeBienvenidaGuarda()
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El personal se ha registrado con éxito, a continuación registrelo como Guarda."));

    }
}
