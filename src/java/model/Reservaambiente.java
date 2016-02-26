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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "reservaambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaambiente.findAll", query = "SELECT r FROM Reservaambiente r"),
    @NamedQuery(name = "Reservaambiente.findByCodigoreservambiente", query = "SELECT r FROM Reservaambiente r WHERE r.codigoreservambiente = :codigoreservambiente"),
    @NamedQuery(name = "Reservaambiente.findByFechainicioreserva", query = "SELECT r FROM Reservaambiente r WHERE r.fechainicioreserva = :fechainicioreserva"),
    @NamedQuery(name = "Reservaambiente.findByFechafinreserva", query = "SELECT r FROM Reservaambiente r WHERE r.fechafinreserva = :fechafinreserva"),
    @NamedQuery(name = "Reservaambiente.findByHorainicioreserva", query = "SELECT r FROM Reservaambiente r WHERE r.horainicioreserva = :horainicioreserva"),
    @NamedQuery(name = "Reservaambiente.findByHorafinreserva", query = "SELECT r FROM Reservaambiente r WHERE r.horafinreserva = :horafinreserva")})
public class Reservaambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoreservambiente")
    private Integer codigoreservambiente;
    @Column(name = "fechainicioreserva")
    @Temporal(TemporalType.DATE)
    private Date fechainicioreserva;
    @Column(name = "fechafinreserva")
    @Temporal(TemporalType.DATE)
    private Date fechafinreserva;
    @Size(max = 50)
    @Column(name = "horainicioreserva")
    private String horainicioreserva;
    @Size(max = 50)
    @Column(name = "horafinreserva")
    private String horafinreserva;
    @JoinColumn(name = "codigoambiente", referencedColumnName = "codigoambiente")
    @ManyToOne
    private Ambientedeaprendizaje codigoambiente;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "fichatitulacion")
    @ManyToOne
    private Fichatitulacion fichatitulacion;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;
    @OneToMany(mappedBy = "codigoreservaambiente")
    private List<Usodeambientes> usodeambientesList;

    public Reservaambiente() {
    }

    public Reservaambiente(Integer codigoreservambiente) {
        this.codigoreservambiente = codigoreservambiente;
    }

    public Integer getCodigoreservambiente() {
        return codigoreservambiente;
    }

    public void setCodigoreservambiente(Integer codigoreservambiente) {
        this.codigoreservambiente = codigoreservambiente;
    }

    public Date getFechainicioreserva() {
        return new java.sql.Date(fechainicioreserva.getTime());
    }

    public void setFechainicioreserva(Date fechainicioreserva) {
        this.fechainicioreserva = fechainicioreserva;
    }

    public Date getFechafinreserva() {
        return new java.sql.Date(fechafinreserva.getTime());
    }

    public void setFechafinreserva(Date fechafinreserva) {
        this.fechafinreserva = fechafinreserva;
    }

    public String getHorainicioreserva() {
        return horainicioreserva;
    }

    public void setHorainicioreserva(String horainicioreserva) {
        this.horainicioreserva = horainicioreserva;
    }

    public String getHorafinreserva() {
        return horafinreserva;
    }

    public void setHorafinreserva(String horafinreserva) {
        this.horafinreserva = horafinreserva;
    }

    public Ambientedeaprendizaje getCodigoambiente() {
        return codigoambiente;
    }

    public void setCodigoambiente(Ambientedeaprendizaje codigoambiente) {
        this.codigoambiente = codigoambiente;
    }

    public Fichatitulacion getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(Fichatitulacion fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
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
        hash += (codigoreservambiente != null ? codigoreservambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaambiente)) {
            return false;
        }
        Reservaambiente other = (Reservaambiente) object;
        if ((this.codigoreservambiente == null && other.codigoreservambiente != null) || (this.codigoreservambiente != null && !this.codigoreservambiente.equals(other.codigoreservambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reservaambiente[ codigoreservambiente=" + codigoreservambiente + " ]";
    }
    
}
