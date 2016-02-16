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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByCodigocriterio", query = "SELECT c FROM Criterio c WHERE c.codigocriterio = :codigocriterio"),
    @NamedQuery(name = "Criterio.findByNombrecriterio", query = "SELECT c FROM Criterio c WHERE c.nombrecriterio = :nombrecriterio")})
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigocriterio")
    private Integer codigocriterio;
    @Size(max = 200)
    @Column(name = "nombrecriterio")
    private String nombrecriterio;
    @JoinTable(name = "criterioevaluacion", joinColumns = {
        @JoinColumn(name = "codigocriterio", referencedColumnName = "codigocriterio")}, inverseJoinColumns = {
        @JoinColumn(name = "codigoevaluacion", referencedColumnName = "codigoevaluacion")})
    @ManyToMany
    private List<Evaluacion> evaluacionList;
    @JoinColumn(name = "codigoelemento", referencedColumnName = "codigoelemento")
    @ManyToOne
    private Elemento codigoelemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio")
    private List<Valoracion> valoracionList;

    public Criterio() {
    }

    public Criterio(Integer codigocriterio) {
        this.codigocriterio = codigocriterio;
    }

    public Integer getCodigocriterio() {
        return codigocriterio;
    }

    public void setCodigocriterio(Integer codigocriterio) {
        this.codigocriterio = codigocriterio;
    }

    public String getNombrecriterio() {
        return nombrecriterio;
    }

    public void setNombrecriterio(String nombrecriterio) {
        this.nombrecriterio = nombrecriterio;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    public Elemento getCodigoelemento() {
        return codigoelemento;
    }

    public void setCodigoelemento(Elemento codigoelemento) {
        this.codigoelemento = codigoelemento;
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
        hash += (codigocriterio != null ? codigocriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.codigocriterio == null && other.codigocriterio != null) || (this.codigocriterio != null && !this.codigocriterio.equals(other.codigocriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Criterio[ codigocriterio=" + codigocriterio + " ]";
    }
    
}
