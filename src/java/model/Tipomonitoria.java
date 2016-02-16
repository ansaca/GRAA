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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "tipomonitoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomonitoria.findAll", query = "SELECT t FROM Tipomonitoria t"),
    @NamedQuery(name = "Tipomonitoria.findByCodigotipomonitoria", query = "SELECT t FROM Tipomonitoria t WHERE t.codigotipomonitoria = :codigotipomonitoria"),
    @NamedQuery(name = "Tipomonitoria.findByNombretipomonitoria", query = "SELECT t FROM Tipomonitoria t WHERE t.nombretipomonitoria = :nombretipomonitoria"),
    @NamedQuery(name = "Tipomonitoria.findByDescripciontipomonitoria", query = "SELECT t FROM Tipomonitoria t WHERE t.descripciontipomonitoria = :descripciontipomonitoria")})
public class Tipomonitoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigotipomonitoria")
    private Integer codigotipomonitoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombretipomonitoria")
    private String nombretipomonitoria;
    @Size(max = 100)
    @Column(name = "descripciontipomonitoria")
    private String descripciontipomonitoria;
    @OneToMany(mappedBy = "codigotipomonitoria")
    private List<Monitor> monitorList;

    public Tipomonitoria() {
    }

    public Tipomonitoria(Integer codigotipomonitoria) {
        this.codigotipomonitoria = codigotipomonitoria;
    }

    public Tipomonitoria(Integer codigotipomonitoria, String nombretipomonitoria) {
        this.codigotipomonitoria = codigotipomonitoria;
        this.nombretipomonitoria = nombretipomonitoria;
    }

    public Integer getCodigotipomonitoria() {
        return codigotipomonitoria;
    }

    public void setCodigotipomonitoria(Integer codigotipomonitoria) {
        this.codigotipomonitoria = codigotipomonitoria;
    }

    public String getNombretipomonitoria() {
        return nombretipomonitoria;
    }

    public void setNombretipomonitoria(String nombretipomonitoria) {
        this.nombretipomonitoria = nombretipomonitoria;
    }

    public String getDescripciontipomonitoria() {
        return descripciontipomonitoria;
    }

    public void setDescripciontipomonitoria(String descripciontipomonitoria) {
        this.descripciontipomonitoria = descripciontipomonitoria;
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
        hash += (codigotipomonitoria != null ? codigotipomonitoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomonitoria)) {
            return false;
        }
        Tipomonitoria other = (Tipomonitoria) object;
        if ((this.codigotipomonitoria == null && other.codigotipomonitoria != null) || (this.codigotipomonitoria != null && !this.codigotipomonitoria.equals(other.codigotipomonitoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipomonitoria[ codigotipomonitoria=" + codigotipomonitoria + " ]";
    }
    
}
