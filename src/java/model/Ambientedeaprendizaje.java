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
import javax.persistence.JoinColumn;
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
@Table(name = "ambientedeaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambientedeaprendizaje.findAll", query = "SELECT a FROM Ambientedeaprendizaje a"),
    @NamedQuery(name = "Ambientedeaprendizaje.findByCodigoambiente", query = "SELECT a FROM Ambientedeaprendizaje a WHERE a.codigoambiente = :codigoambiente"),
    @NamedQuery(name = "Ambientedeaprendizaje.findByNombreambiente", query = "SELECT a FROM Ambientedeaprendizaje a WHERE a.nombreambiente = :nombreambiente"),
    @NamedQuery(name = "Ambientedeaprendizaje.findByCapacidadambiente", query = "SELECT a FROM Ambientedeaprendizaje a WHERE a.capacidadambiente = :capacidadambiente"),
    @NamedQuery(name = "Ambientedeaprendizaje.findByAreaambiente", query = "SELECT a FROM Ambientedeaprendizaje a WHERE a.areaambiente = :areaambiente"),
    @NamedQuery(name = "Ambientedeaprendizaje.findByEstadoambiente", query = "SELECT a FROM Ambientedeaprendizaje a WHERE a.estadoambiente = :estadoambiente")})
public class Ambientedeaprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoambiente")
    private Integer codigoambiente;
    @Size(max = 100)
    @Column(name = "nombreambiente")
    private String nombreambiente;
    @Column(name = "capacidadambiente")
    private Integer capacidadambiente;
    @Column(name = "areaambiente")
    private Integer areaambiente;
    @Size(max = 50)
    @Column(name = "estadoambiente")
    private String estadoambiente;
    @JoinColumn(name = "numerosedeambiente", referencedColumnName = "numerosede")
    @ManyToOne
    private Sede numerosedeambiente;
    @JoinColumn(name = "codigotipoambiente", referencedColumnName = "codigotipoambiente")
    @ManyToOne
    private Tipoambiente codigotipoambiente;
    @OneToMany(mappedBy = "codigoambiente")
    private List<Reservaambiente> reservaambienteList;
    @OneToMany(mappedBy = "codigoambiente")
    private List<Usodeambientes> usodeambientesList;

    public Ambientedeaprendizaje() {
    }

    public Ambientedeaprendizaje(Integer codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public Integer getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Integer codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public String getNombreambiente() {
        return nombreambiente;
    }

    public void setNombreambiente(String nombreambiente) {
        this.nombreambiente = nombreambiente;
    }

    public Integer getCapacidadambiente() {
        return capacidadambiente;
    }

    public void setCapacidadambiente(Integer capacidadambiente) {
        this.capacidadambiente = capacidadambiente;
    }

    public Integer getAreaambiente() {
        return areaambiente;
    }

    public void setAreaambiente(Integer areaambiente) {
        this.areaambiente = areaambiente;
    }

    public String getEstadoambiente() {
        return estadoambiente;
    }

    public void setEstadoambiente(String estadoambiente) {
        this.estadoambiente = estadoambiente;
    }

    public Sede getNumerosedeambiente() {
        return numerosedeambiente;
    }

    public void setNumerosedeambiente(Sede numerosedeambiente) {
        this.numerosedeambiente = numerosedeambiente;
    }

    public Tipoambiente getCodigotipoambiente() {
        return codigotipoambiente;
    }

    public void setCodigotipoambiente(Tipoambiente codigotipoambiente) {
        this.codigotipoambiente = codigotipoambiente;
    }

    @XmlTransient
    public List<Reservaambiente> getReservaambienteList() {
        return reservaambienteList;
    }

    public void setReservaambienteList(List<Reservaambiente> reservaambienteList) {
        this.reservaambienteList = reservaambienteList;
    }

    @XmlTransient
    public List<Usodeambientes> getUsodeambientesList() {
        return usodeambientesList;
    }

    public void setUsodeambientesList(List<Usodeambientes> usodeambientesList) {
        this.usodeambientesList = usodeambientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoambiente != null ? codigoambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ambientedeaprendizaje)) {
            return false;
        }
        Ambientedeaprendizaje other = (Ambientedeaprendizaje) object;
        if ((this.codigoambiente == null && other.codigoambiente != null) || (this.codigoambiente != null && !this.codigoambiente.equals(other.codigoambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ambientedeaprendizaje[ codigoambiente=" + codigoambiente + " ]";
    }
    
}
