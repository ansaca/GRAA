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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByCodigoevaluacion", query = "SELECT e FROM Evaluacion e WHERE e.codigoevaluacion = :codigoevaluacion"),
    @NamedQuery(name = "Evaluacion.findByTipoevaluacion", query = "SELECT e FROM Evaluacion e WHERE e.tipoevaluacion = :tipoevaluacion"),
    @NamedQuery(name = "Evaluacion.findByEstadoevaluacion", query = "SELECT e FROM Evaluacion e WHERE e.estadoevaluacion = :estadoevaluacion")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoevaluacion")
    private Integer codigoevaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoevaluacion")
    private String tipoevaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estadoevaluacion")
    private String estadoevaluacion;
    @ManyToMany(mappedBy = "evaluacionList")
    private List<Criterio> criterioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoevaluacion")
    private List<Evaluaciondesempeno> evaluaciondesempenoList;

    public Evaluacion() {
    }

    public Evaluacion(Integer codigoevaluacion) {
        this.codigoevaluacion = codigoevaluacion;
    }

    public Evaluacion(Integer codigoevaluacion, String tipoevaluacion, String estadoevaluacion) {
        this.codigoevaluacion = codigoevaluacion;
        this.tipoevaluacion = tipoevaluacion;
        this.estadoevaluacion = estadoevaluacion;
    }

    public Integer getCodigoevaluacion() {
        return codigoevaluacion;
    }

    public void setCodigoevaluacion(Integer codigoevaluacion) {
        this.codigoevaluacion = codigoevaluacion;
    }

    public String getTipoevaluacion() {
        return tipoevaluacion;
    }

    public void setTipoevaluacion(String tipoevaluacion) {
        this.tipoevaluacion = tipoevaluacion;
    }

    public String getEstadoevaluacion() {
        return estadoevaluacion;
    }

    public void setEstadoevaluacion(String estadoevaluacion) {
        this.estadoevaluacion = estadoevaluacion;
    }

    @XmlTransient
    public List<Criterio> getCriterioList() {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList) {
        this.criterioList = criterioList;
    }

    @XmlTransient
    public List<Evaluaciondesempeno> getEvaluaciondesempenoList() {
        return evaluaciondesempenoList;
    }

    public void setEvaluaciondesempenoList(List<Evaluaciondesempeno> evaluaciondesempenoList) {
        this.evaluaciondesempenoList = evaluaciondesempenoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoevaluacion != null ? codigoevaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.codigoevaluacion == null && other.codigoevaluacion != null) || (this.codigoevaluacion != null && !this.codigoevaluacion.equals(other.codigoevaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evaluacion[ codigoevaluacion=" + codigoevaluacion + " ]";
    }
    
}
