/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByDocumentopersonal", query = "SELECT p FROM Personal p WHERE p.documentopersonal = :documentopersonal"),
    @NamedQuery(name = "Personal.findByNombrepersonal", query = "SELECT p FROM Personal p WHERE p.nombrepersonal = :nombrepersonal"),
    @NamedQuery(name = "Personal.findByApellidopersonal", query = "SELECT p FROM Personal p WHERE p.apellidopersonal = :apellidopersonal"),
    @NamedQuery(name = "Personal.findByDireccionpersonal", query = "SELECT p FROM Personal p WHERE p.direccionpersonal = :direccionpersonal"),
    @NamedQuery(name = "Personal.findByCorreopersonal", query = "SELECT p FROM Personal p WHERE p.correopersonal = :correopersonal"),
    @NamedQuery(name = "Personal.findByTelefonopersonal", query = "SELECT p FROM Personal p WHERE p.telefonopersonal = :telefonopersonal"),
    @NamedQuery(name = "Personal.findByClavepersonal", query = "SELECT p FROM Personal p WHERE p.clavepersonal = :clavepersonal"),
    @NamedQuery(name = "Personal.findByFechanacimientopersonal", query = "SELECT p FROM Personal p WHERE p.fechanacimientopersonal = :fechanacimientopersonal"),
    @NamedQuery(name = "Personal.findByLugarnacimientopersonal", query = "SELECT p FROM Personal p WHERE p.lugarnacimientopersonal = :lugarnacimientopersonal"),
    @NamedQuery(name = "Personal.findByFotopersonal", query = "SELECT p FROM Personal p WHERE p.fotopersonal = :fotopersonal")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentopersonal")
    private Long documentopersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrepersonal")
    private String nombrepersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidopersonal")
    private String apellidopersonal;
    @Size(max = 100)
    @Column(name = "direccionpersonal")
    private String direccionpersonal;
    @Size(max = 100)
    @Column(name = "correopersonal")
    private String correopersonal;
    @Size(max = 100)
    @Column(name = "telefonopersonal")
    private String telefonopersonal;
    @Size(max = 255)
    @Column(name = "clavepersonal")
    private String clavepersonal;
    @Column(name = "fechanacimientopersonal")
    @Temporal(TemporalType.DATE)
    private Date fechanacimientopersonal;
    @Size(max = 50)
    @Column(name = "lugarnacimientopersonal")
    private String lugarnacimientopersonal;
    @Size(max = 100)
    @Column(name = "fotopersonal")
    private String fotopersonal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Funcionario funcionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Clienteexterno clienteexterno;
    @OneToMany(mappedBy = "documentopersonalcontrato")
    private List<Contrato> contratoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Coordinador coordinador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Instructor instructor;
    @OneToMany(mappedBy = "documentopersonal")
    private List<Ingreso> ingresoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Guarda guarda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal")
    private List<Comite> comiteList;
    @OneToMany(mappedBy = "documentopersonal")
    private List<Reservaambiente> reservaambienteList;
    @OneToMany(mappedBy = "documentopersonal")
    private List<Usodeambientes> usodeambientesList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personal")
    private Aprendiz aprendiz;
    @OneToMany(mappedBy = "documentopersonal")
    private List<Monitor> monitorList;

    public Personal() {
    }

    public Personal(Long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public Personal(Long documentopersonal, String nombrepersonal, String apellidopersonal) {
        this.documentopersonal = documentopersonal;
        this.nombrepersonal = nombrepersonal;
        this.apellidopersonal = apellidopersonal;
    }

    public Long getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Long documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public String getNombrepersonal() {
        return nombrepersonal;
    }

    public void setNombrepersonal(String nombrepersonal) {
        this.nombrepersonal = nombrepersonal;
    }

    public String getApellidopersonal() {
        return apellidopersonal;
    }

    public void setApellidopersonal(String apellidopersonal) {
        this.apellidopersonal = apellidopersonal;
    }

    public String getDireccionpersonal() {
        return direccionpersonal;
    }

    public void setDireccionpersonal(String direccionpersonal) {
        this.direccionpersonal = direccionpersonal;
    }

    public String getCorreopersonal() {
        return correopersonal;
    }

    public void setCorreopersonal(String correopersonal) {
        this.correopersonal = correopersonal;
    }

    public String getTelefonopersonal() {
        return telefonopersonal;
    }

    public void setTelefonopersonal(String telefonopersonal) {
        this.telefonopersonal = telefonopersonal;
    }

    public String getClavepersonal() {
        return clavepersonal;
    }

    public void setClavepersonal(String clavepersonal) {
        this.clavepersonal = clavepersonal;
    }

    public Date getFechanacimientopersonal() {
        try{
        return new java.sql.Date(fechanacimientopersonal.getTime());
        }catch(NullPointerException n){
            return null;
        }
    }

    public void setFechanacimientopersonal(Date fechanacimientopersonal) {
        this.fechanacimientopersonal = fechanacimientopersonal;
    }

    public String getLugarnacimientopersonal() {
        return lugarnacimientopersonal;
    }

    public void setLugarnacimientopersonal(String lugarnacimientopersonal) {
        this.lugarnacimientopersonal = lugarnacimientopersonal;
    }

    public String getFotopersonal() {
        return fotopersonal;
    }

    public void setFotopersonal(String fotopersonal) {
        this.fotopersonal = fotopersonal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Clienteexterno getClienteexterno() {
        return clienteexterno;
    }

    public void setClienteexterno(Clienteexterno clienteexterno) {
        this.clienteexterno = clienteexterno;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    public Guarda getGuarda() {
        return guarda;
    }

    public void setGuarda(Guarda guarda) {
        this.guarda = guarda;
    }

    @XmlTransient
    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
    }

    @XmlTransient
    public List<Reservaambiente> getReservaambienteList() {
        return reservaambienteList;
    }

    public void setReservaambienteList(List<Reservaambiente> reservaambienteList) {
        this.reservaambienteList = reservaambienteList;
    }

    @XmlTransient
    public List<Usodeambientes> getUsodeambientesList() {
        return usodeambientesList;
    }

    public void setUsodeambientesList(List<Usodeambientes> usodeambientesList) {
        this.usodeambientesList = usodeambientesList;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    @XmlTransient
    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentopersonal != null ? documentopersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.documentopersonal == null && other.documentopersonal != null) || (this.documentopersonal != null && !this.documentopersonal.equals(other.documentopersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Personal[ documentopersonal=" + documentopersonal + " ]";
    }
    
}
