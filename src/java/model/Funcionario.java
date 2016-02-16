/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByDocumentofuncionario", query = "SELECT f FROM Funcionario f WHERE f.documentofuncionario = :documentofuncionario")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentofuncionario")
    private Long documentofuncionario;
    @OneToMany(mappedBy = "documentofuncionario")
    private List<Controlvehicular> controlvehicularList;
    @JoinColumn(name = "codigoarea", referencedColumnName = "codigoarea")
    @ManyToOne(optional = false)
    private Area codigoarea;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentofuncionariocentro")
    private List<Centro> centroList;
    @OneToMany(mappedBy = "documentofuncionario")
    private List<Sede> sedeList;

    public Funcionario() {
    }

    public Funcionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Long getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Long documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    @XmlTransient
    public List<Controlvehicular> getControlvehicularList() {
        return controlvehicularList;
    }

    public void setControlvehicularList(List<Controlvehicular> controlvehicularList) {
        this.controlvehicularList = controlvehicularList;
    }

    public Area getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Area codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public List<Centro> getCentroList() {
        return centroList;
    }

    public void setCentroList(List<Centro> centroList) {
        this.centroList = centroList;
    }

    @XmlTransient
    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentofuncionario != null ? documentofuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.documentofuncionario == null && other.documentofuncionario != null) || (this.documentofuncionario != null && !this.documentofuncionario.equals(other.documentofuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ documentofuncionario=" + documentofuncionario + " ]";
    }
    
}
