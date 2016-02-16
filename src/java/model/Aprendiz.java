/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a"),
    @NamedQuery(name = "Aprendiz.findByDocumentoaprendiz", query = "SELECT a FROM Aprendiz a WHERE a.documentoaprendiz = :documentoaprendiz")})
public class Aprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoaprendiz")
    private Long documentoaprendiz;
    @OneToMany(mappedBy = "documentoaprendiz")
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aprendiz")
    private List<Seguimientoaprendiz> seguimientoaprendizList;
    @OneToMany(mappedBy = "documentoaprendiz")
    private List<Eproductiva> eproductivaList;
    @OneToMany(mappedBy = "documentoaprendiz")
    private List<Evaluacionaprendiz> evaluacionaprendizList;
    @JoinColumn(name = "fichatitulacionaprendiz", referencedColumnName = "fichatitulacion")
    @ManyToOne
    private Fichatitulacion fichatitulacionaprendiz;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentoaprendiz")
    private List<Monitor> monitorList;

    public Aprendiz() {
    }

    public Aprendiz(Long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Long getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Seguimientoaprendiz> getSeguimientoaprendizList() {
        return seguimientoaprendizList;
    }

    public void setSeguimientoaprendizList(List<Seguimientoaprendiz> seguimientoaprendizList) {
        this.seguimientoaprendizList = seguimientoaprendizList;
    }

    @XmlTransient
    public List<Eproductiva> getEproductivaList() {
        return eproductivaList;
    }

    public void setEproductivaList(List<Eproductiva> eproductivaList) {
        this.eproductivaList = eproductivaList;
    }

    @XmlTransient
    public List<Evaluacionaprendiz> getEvaluacionaprendizList() {
        return evaluacionaprendizList;
    }

    public void setEvaluacionaprendizList(List<Evaluacionaprendiz> evaluacionaprendizList) {
        this.evaluacionaprendizList = evaluacionaprendizList;
    }

    public Fichatitulacion getFichatitulacionaprendiz() {
        return fichatitulacionaprendiz;
    }

    public void setFichatitulacionaprendiz(Fichatitulacion fichatitulacionaprendiz) {
        this.fichatitulacionaprendiz = fichatitulacionaprendiz;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
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
        hash += (documentoaprendiz != null ? documentoaprendiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprendiz)) {
            return false;
        }
        Aprendiz other = (Aprendiz) object;
        if ((this.documentoaprendiz == null && other.documentoaprendiz != null) || (this.documentoaprendiz != null && !this.documentoaprendiz.equals(other.documentoaprendiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Aprendiz[ documentoaprendiz=" + documentoaprendiz + " ]";
    }
    
}
