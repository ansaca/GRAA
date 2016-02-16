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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n"),
    @NamedQuery(name = "Novedad.findByNumeronovedad", query = "SELECT n FROM Novedad n WHERE n.numeronovedad = :numeronovedad"),
    @NamedQuery(name = "Novedad.findByNombrenovedad", query = "SELECT n FROM Novedad n WHERE n.nombrenovedad = :nombrenovedad")})
public class Novedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeronovedad")
    private Integer numeronovedad;
    @Size(max = 50)
    @Column(name = "nombrenovedad")
    private String nombrenovedad;
    @OneToMany(mappedBy = "numeronovedad")
    private List<Seguimientoaprendiz> seguimientoaprendizList;

    public Novedad() {
    }

    public Novedad(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public Integer getNumeronovedad() {
        return numeronovedad;
    }

    public void setNumeronovedad(Integer numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public String getNombrenovedad() {
        return nombrenovedad;
    }

    public void setNombrenovedad(String nombrenovedad) {
        this.nombrenovedad = nombrenovedad;
    }

    @XmlTransient
    public List<Seguimientoaprendiz> getSeguimientoaprendizList() {
        return seguimientoaprendizList;
    }

    public void setSeguimientoaprendizList(List<Seguimientoaprendiz> seguimientoaprendizList) {
        this.seguimientoaprendizList = seguimientoaprendizList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeronovedad != null ? numeronovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.numeronovedad == null && other.numeronovedad != null) || (this.numeronovedad != null && !this.numeronovedad.equals(other.numeronovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Novedad[ numeronovedad=" + numeronovedad + " ]";
    }
    
}
