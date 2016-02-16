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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "evaluaciondesempeno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluaciondesempeno.findAll", query = "SELECT e FROM Evaluaciondesempeno e"),
    @NamedQuery(name = "Evaluaciondesempeno.findByCodigoevaluaciondesempeno", query = "SELECT e FROM Evaluaciondesempeno e WHERE e.codigoevaluaciondesempeno = :codigoevaluaciondesempeno"),
    @NamedQuery(name = "Evaluaciondesempeno.findByFechaevaluacion", query = "SELECT e FROM Evaluaciondesempeno e WHERE e.fechaevaluacion = :fechaevaluacion"),
    @NamedQuery(name = "Evaluaciondesempeno.findByPuntajeevaluacion", query = "SELECT e FROM Evaluaciondesempeno e WHERE e.puntajeevaluacion = :puntajeevaluacion")})
public class Evaluaciondesempeno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoevaluaciondesempeno")
    private Integer codigoevaluaciondesempeno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaevaluacion")
    @Temporal(TemporalType.DATE)
    private Date fechaevaluacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacionesevaluacion")
    private String observacionesevaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajeevaluacion")
    private int puntajeevaluacion;
    @JoinColumn(name = "codigoevaluacion", referencedColumnName = "codigoevaluacion")
    @ManyToOne(optional = false)
    private Evaluacion codigoevaluacion;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne(optional = false)
    private Instructor documentoinstructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluaciondesempeno")
    private List<Valoracion> valoracionList;

    public Evaluaciondesempeno() {
    }

    public Evaluaciondesempeno(Integer codigoevaluaciondesempeno) {
        this.codigoevaluaciondesempeno = codigoevaluaciondesempeno;
    }

    public Evaluaciondesempeno(Integer codigoevaluaciondesempeno, Date fechaevaluacion, String observacionesevaluacion, int puntajeevaluacion) {
        this.codigoevaluaciondesempeno = codigoevaluaciondesempeno;
        this.fechaevaluacion = fechaevaluacion;
        this.observacionesevaluacion = observacionesevaluacion;
        this.puntajeevaluacion = puntajeevaluacion;
    }

    public Integer getCodigoevaluaciondesempeno() {
        return codigoevaluaciondesempeno;
    }

    public void setCodigoevaluaciondesempeno(Integer codigoevaluaciondesempeno) {
        this.codigoevaluaciondesempeno = codigoevaluaciondesempeno;
    }

    public Date getFechaevaluacion() {
        return fechaevaluacion;
    }

    public void setFechaevaluacion(Date fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    public String getObservacionesevaluacion() {
        return observacionesevaluacion;
    }

    public void setObservacionesevaluacion(String observacionesevaluacion) {
        this.observacionesevaluacion = observacionesevaluacion;
    }

    public int getPuntajeevaluacion() {
        return puntajeevaluacion;
    }

    public void setPuntajeevaluacion(int puntajeevaluacion) {
        this.puntajeevaluacion = puntajeevaluacion;
    }

    public Evaluacion getCodigoevaluacion() {
        return codigoevaluacion;
    }

    public void setCodigoevaluacion(Evaluacion codigoevaluacion) {
        this.codigoevaluacion = codigoevaluacion;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoevaluaciondesempeno != null ? codigoevaluaciondesempeno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluaciondesempeno)) {
            return false;
        }
        Evaluaciondesempeno other = (Evaluaciondesempeno) object;
        if ((this.codigoevaluaciondesempeno == null && other.codigoevaluaciondesempeno != null) || (this.codigoevaluaciondesempeno != null && !this.codigoevaluaciondesempeno.equals(other.codigoevaluaciondesempeno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evaluaciondesempeno[ codigoevaluaciondesempeno=" + codigoevaluaciondesempeno + " ]";
    }
    
}
