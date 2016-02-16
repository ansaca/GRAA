/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "lideresficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lideresficha.findAll", query = "SELECT l FROM Lideresficha l"),
    @NamedQuery(name = "Lideresficha.findByDocumentoinstructor", query = "SELECT l FROM Lideresficha l WHERE l.lideresfichaPK.documentoinstructor = :documentoinstructor"),
    @NamedQuery(name = "Lideresficha.findByFichatitulacion", query = "SELECT l FROM Lideresficha l WHERE l.lideresfichaPK.fichatitulacion = :fichatitulacion"),
    @NamedQuery(name = "Lideresficha.findByFechaasignacion", query = "SELECT l FROM Lideresficha l WHERE l.fechaasignacion = :fechaasignacion")})
public class Lideresficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LideresfichaPK lideresfichaPK;
    @Column(name = "fechaasignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaasignacion;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "fichatitulacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fichatitulacion fichatitulacion1;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Instructor instructor;

    public Lideresficha() {
    }

    public Lideresficha(LideresfichaPK lideresfichaPK) {
        this.lideresfichaPK = lideresfichaPK;
    }

    public Lideresficha(long documentoinstructor, int fichatitulacion) {
        this.lideresfichaPK = new LideresfichaPK(documentoinstructor, fichatitulacion);
    }

    public LideresfichaPK getLideresfichaPK() {
        return lideresfichaPK;
    }

    public void setLideresfichaPK(LideresfichaPK lideresfichaPK) {
        this.lideresfichaPK = lideresfichaPK;
    }

    public Date getFechaasignacion() {
        return fechaasignacion;
    }

    public void setFechaasignacion(Date fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public Fichatitulacion getFichatitulacion1() {
        return fichatitulacion1;
    }

    public void setFichatitulacion1(Fichatitulacion fichatitulacion1) {
        this.fichatitulacion1 = fichatitulacion1;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lideresfichaPK != null ? lideresfichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lideresficha)) {
            return false;
        }
        Lideresficha other = (Lideresficha) object;
        if ((this.lideresfichaPK == null && other.lideresfichaPK != null) || (this.lideresfichaPK != null && !this.lideresfichaPK.equals(other.lideresfichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lideresficha[ lideresfichaPK=" + lideresfichaPK + " ]";
    }
    
}
