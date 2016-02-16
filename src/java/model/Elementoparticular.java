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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "elementoparticular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elementoparticular.findAll", query = "SELECT e FROM Elementoparticular e"),
    @NamedQuery(name = "Elementoparticular.findByNumeroserieelemento", query = "SELECT e FROM Elementoparticular e WHERE e.numeroserieelemento = :numeroserieelemento"),
    @NamedQuery(name = "Elementoparticular.findByNombreelemento", query = "SELECT e FROM Elementoparticular e WHERE e.nombreelemento = :nombreelemento")})
public class Elementoparticular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numeroserieelemento")
    private String numeroserieelemento;
    @Size(max = 50)
    @Column(name = "nombreelemento")
    private String nombreelemento;
    @Lob
    @Size(max = 65535)
    @Column(name = "accesorioselemento")
    private String accesorioselemento;
    @JoinTable(name = "ingresoelemento", joinColumns = {
        @JoinColumn(name = "numeroserielemento", referencedColumnName = "numeroserieelemento")}, inverseJoinColumns = {
        @JoinColumn(name = "numeroingreso", referencedColumnName = "numeroingreso")})
    @ManyToMany
    private List<Ingreso> ingresoList;

    public Elementoparticular() {
    }

    public Elementoparticular(String numeroserieelemento) {
        this.numeroserieelemento = numeroserieelemento;
    }

    public String getNumeroserieelemento() {
        return numeroserieelemento;
    }

    public void setNumeroserieelemento(String numeroserieelemento) {
        this.numeroserieelemento = numeroserieelemento;
    }

    public String getNombreelemento() {
        return nombreelemento;
    }

    public void setNombreelemento(String nombreelemento) {
        this.nombreelemento = nombreelemento;
    }

    public String getAccesorioselemento() {
        return accesorioselemento;
    }

    public void setAccesorioselemento(String accesorioselemento) {
        this.accesorioselemento = accesorioselemento;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroserieelemento != null ? numeroserieelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elementoparticular)) {
            return false;
        }
        Elementoparticular other = (Elementoparticular) object;
        if ((this.numeroserieelemento == null && other.numeroserieelemento != null) || (this.numeroserieelemento != null && !this.numeroserieelemento.equals(other.numeroserieelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Elementoparticular[ numeroserieelemento=" + numeroserieelemento + " ]";
    }
    
}
