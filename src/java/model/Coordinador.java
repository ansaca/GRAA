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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "coordinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coordinador.findAll", query = "SELECT c FROM Coordinador c"),
    @NamedQuery(name = "Coordinador.findByDocumentocoordinador", query = "SELECT c FROM Coordinador c WHERE c.documentocoordinador = :documentocoordinador"),
    @NamedQuery(name = "Coordinador.findByTipocoordinador", query = "SELECT c FROM Coordinador c WHERE c.tipocoordinador = :tipocoordinador")})
public class Coordinador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentocoordinador")
    private Long documentocoordinador;
    @Size(max = 50)
    @Column(name = "tipocoordinador")
    private String tipocoordinador;
    @OneToMany(mappedBy = "documentocoordinador")
    private List<Permiso> permisoList;
    @OneToMany(mappedBy = "documentocoordinadorcontrato")
    private List<Contrato> contratoList;
    @JoinColumn(name = "documentocoordinador", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentocoordinador")
    private List<Evaluacioncoordinador> evaluacioncoordinadorList;

    public Coordinador() {
    }

    public Coordinador(Long documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public Long getDocumentocoordinador() {
        return documentocoordinador;
    }

    public void setDocumentocoordinador(Long documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public String getTipocoordinador() {
        return tipocoordinador;
    }

    public void setTipocoordinador(String tipocoordinador) {
        this.tipocoordinador = tipocoordinador;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public List<Evaluacioncoordinador> getEvaluacioncoordinadorList() {
        return evaluacioncoordinadorList;
    }

    public void setEvaluacioncoordinadorList(List<Evaluacioncoordinador> evaluacioncoordinadorList) {
        this.evaluacioncoordinadorList = evaluacioncoordinadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentocoordinador != null ? documentocoordinador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinador)) {
            return false;
        }
        Coordinador other = (Coordinador) object;
        if ((this.documentocoordinador == null && other.documentocoordinador != null) || (this.documentocoordinador != null && !this.documentocoordinador.equals(other.documentocoordinador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Coordinador[ documentocoordinador=" + documentocoordinador + " ]";
    }
    
}
