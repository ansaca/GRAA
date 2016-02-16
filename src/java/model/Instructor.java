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
import javax.persistence.Lob;
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
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByDocumentoinstructor", query = "SELECT i FROM Instructor i WHERE i.documentoinstructor = :documentoinstructor"),
    @NamedQuery(name = "Instructor.findByTipoinstructor", query = "SELECT i FROM Instructor i WHERE i.tipoinstructor = :tipoinstructor")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoinstructor")
    private Long documentoinstructor;
    @Size(max = 50)
    @Column(name = "tipoinstructor")
    private String tipoinstructor;
    @Lob
    @Size(max = 65535)
    @Column(name = "perfilocupacionalinstructor")
    private String perfilocupacionalinstructor;
    @Lob
    @Size(max = 65535)
    @Column(name = "logrosinstructor")
    private String logrosinstructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<Lideresficha> lideresfichaList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Capacitacion> capacitacionList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Seguimientop> seguimientopList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Formacion> formacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoinstructor")
    private List<Evaluaciondesempeno> evaluaciondesempenoList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Permiso> permisoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private List<Hablaidioma> hablaidiomaList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Visita> visitaList;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Evaluacionaprendiz> evaluacionaprendizList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Experiencia> experienciaList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Asignafichas> asignafichasList;
    @OneToMany(mappedBy = "documentoinstructor")
    private List<Evaluacioncoordinador> evaluacioncoordinadorList;

    public Instructor() {
    }

    public Instructor(Long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public Long getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public String getTipoinstructor() {
        return tipoinstructor;
    }

    public void setTipoinstructor(String tipoinstructor) {
        this.tipoinstructor = tipoinstructor;
    }

    public String getPerfilocupacionalinstructor() {
        return perfilocupacionalinstructor;
    }

    public void setPerfilocupacionalinstructor(String perfilocupacionalinstructor) {
        this.perfilocupacionalinstructor = perfilocupacionalinstructor;
    }

    public String getLogrosinstructor() {
        return logrosinstructor;
    }

    public void setLogrosinstructor(String logrosinstructor) {
        this.logrosinstructor = logrosinstructor;
    }

    @XmlTransient
    public List<Lideresficha> getLideresfichaList() {
        return lideresfichaList;
    }

    public void setLideresfichaList(List<Lideresficha> lideresfichaList) {
        this.lideresfichaList = lideresfichaList;
    }

    @XmlTransient
    public List<Capacitacion> getCapacitacionList() {
        return capacitacionList;
    }

    public void setCapacitacionList(List<Capacitacion> capacitacionList) {
        this.capacitacionList = capacitacionList;
    }

    @XmlTransient
    public List<Seguimientop> getSeguimientopList() {
        return seguimientopList;
    }

    public void setSeguimientopList(List<Seguimientop> seguimientopList) {
        this.seguimientopList = seguimientopList;
    }

    @XmlTransient
    public List<Formacion> getFormacionList() {
        return formacionList;
    }

    public void setFormacionList(List<Formacion> formacionList) {
        this.formacionList = formacionList;
    }

    @XmlTransient
    public List<Evaluaciondesempeno> getEvaluaciondesempenoList() {
        return evaluaciondesempenoList;
    }

    public void setEvaluaciondesempenoList(List<Evaluaciondesempeno> evaluaciondesempenoList) {
        this.evaluaciondesempenoList = evaluaciondesempenoList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @XmlTransient
    public List<Hablaidioma> getHablaidiomaList() {
        return hablaidiomaList;
    }

    public void setHablaidiomaList(List<Hablaidioma> hablaidiomaList) {
        this.hablaidiomaList = hablaidiomaList;
    }

    @XmlTransient
    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @XmlTransient
    public List<Evaluacionaprendiz> getEvaluacionaprendizList() {
        return evaluacionaprendizList;
    }

    public void setEvaluacionaprendizList(List<Evaluacionaprendiz> evaluacionaprendizList) {
        this.evaluacionaprendizList = evaluacionaprendizList;
    }

    @XmlTransient
    public List<Experiencia> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<Experiencia> experienciaList) {
        this.experienciaList = experienciaList;
    }

    @XmlTransient
    public List<Asignafichas> getAsignafichasList() {
        return asignafichasList;
    }

    public void setAsignafichasList(List<Asignafichas> asignafichasList) {
        this.asignafichasList = asignafichasList;
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
        hash += (documentoinstructor != null ? documentoinstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.documentoinstructor == null && other.documentoinstructor != null) || (this.documentoinstructor != null && !this.documentoinstructor.equals(other.documentoinstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Instructor[ documentoinstructor=" + documentoinstructor + " ]";
    }

}
