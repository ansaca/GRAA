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
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByPlacavehiculo", query = "SELECT v FROM Vehiculo v WHERE v.placavehiculo = :placavehiculo"),
    @NamedQuery(name = "Vehiculo.findByTipovehiculo", query = "SELECT v FROM Vehiculo v WHERE v.tipovehiculo = :tipovehiculo"),
    @NamedQuery(name = "Vehiculo.findByKmvehiculo", query = "SELECT v FROM Vehiculo v WHERE v.kmvehiculo = :kmvehiculo")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "placavehiculo")
    private String placavehiculo;
    @Size(max = 50)
    @Column(name = "tipovehiculo")
    private String tipovehiculo;
    @Column(name = "kmvehiculo")
    private Integer kmvehiculo;
    @OneToMany(mappedBy = "placavehiculo")
    private List<Controlvehicular> controlvehicularList;

    public Vehiculo() {
    }

    public Vehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    public String getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public Integer getKmvehiculo() {
        return kmvehiculo;
    }

    public void setKmvehiculo(Integer kmvehiculo) {
        this.kmvehiculo = kmvehiculo;
    }

    @XmlTransient
    public List<Controlvehicular> getControlvehicularList() {
        return controlvehicularList;
    }

    public void setControlvehicularList(List<Controlvehicular> controlvehicularList) {
        this.controlvehicularList = controlvehicularList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placavehiculo != null ? placavehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.placavehiculo == null && other.placavehiculo != null) || (this.placavehiculo != null && !this.placavehiculo.equals(other.placavehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vehiculo[ placavehiculo=" + placavehiculo + " ]";
    }
    
}
