/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "controlvehicular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controlvehicular.findAll", query = "SELECT c FROM Controlvehicular c"),
    @NamedQuery(name = "Controlvehicular.findByCodigocontrol", query = "SELECT c FROM Controlvehicular c WHERE c.codigocontrol = :codigocontrol"),
    @NamedQuery(name = "Controlvehicular.findByFechacontrol", query = "SELECT c FROM Controlvehicular c WHERE c.fechacontrol = :fechacontrol"),
    @NamedQuery(name = "Controlvehicular.findByHorasalida", query = "SELECT c FROM Controlvehicular c WHERE c.horasalida = :horasalida"),
    @NamedQuery(name = "Controlvehicular.findByHorallegada", query = "SELECT c FROM Controlvehicular c WHERE c.horallegada = :horallegada"),
    @NamedQuery(name = "Controlvehicular.findByKmsalida", query = "SELECT c FROM Controlvehicular c WHERE c.kmsalida = :kmsalida"),
    @NamedQuery(name = "Controlvehicular.findByKmllegada", query = "SELECT c FROM Controlvehicular c WHERE c.kmllegada = :kmllegada")})
public class Controlvehicular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigocontrol")
    private Integer codigocontrol;
    @Column(name = "fechacontrol")
    @Temporal(TemporalType.DATE)
    private Date fechacontrol;
    @Size(max = 50)
    @Column(name = "horasalida")
    private String horasalida;
    @Size(max = 50)
    @Column(name = "horallegada")
    private String horallegada;
    @Column(name = "kmsalida")
    private Integer kmsalida;
    @Column(name = "kmllegada")
    private Integer kmllegada;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentofuncionario")
    @ManyToOne
    private Funcionario documentofuncionario;
    @JoinColumn(name = "placavehiculo", referencedColumnName = "placavehiculo")
    @ManyToOne
    private Vehiculo placavehiculo;

    public Controlvehicular() {
    }

    public Controlvehicular(Integer codigocontrol) {
        this.codigocontrol = codigocontrol;
    }

    public Integer getCodigocontrol() {
        return codigocontrol;
    }

    public void setCodigocontrol(Integer codigocontrol) {
        this.codigocontrol = codigocontrol;
    }

    public Date getFechacontrol() {
        return fechacontrol;
    }

    public void setFechacontrol(Date fechacontrol) {
        this.fechacontrol = fechacontrol;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    public Integer getKmsalida() {
        return kmsalida;
    }

    public void setKmsalida(Integer kmsalida) {
        this.kmsalida = kmsalida;
    }

    public Integer getKmllegada() {
        return kmllegada;
    }

    public void setKmllegada(Integer kmllegada) {
        this.kmllegada = kmllegada;
    }

    public Funcionario getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Funcionario documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    public Vehiculo getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(Vehiculo placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocontrol != null ? codigocontrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlvehicular)) {
            return false;
        }
        Controlvehicular other = (Controlvehicular) object;
        if ((this.codigocontrol == null && other.codigocontrol != null) || (this.codigocontrol != null && !this.codigocontrol.equals(other.codigocontrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Controlvehicular[ codigocontrol=" + codigocontrol + " ]";
    }
    
}
