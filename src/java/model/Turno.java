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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t"),
    @NamedQuery(name = "Turno.findByCodigoturno", query = "SELECT t FROM Turno t WHERE t.codigoturno = :codigoturno"),
    @NamedQuery(name = "Turno.findByNumeroturno", query = "SELECT t FROM Turno t WHERE t.numeroturno = :numeroturno"),
    @NamedQuery(name = "Turno.findByFechaturno", query = "SELECT t FROM Turno t WHERE t.fechaturno = :fechaturno"),
    @NamedQuery(name = "Turno.findByHoraingresoturno", query = "SELECT t FROM Turno t WHERE t.horaingresoturno = :horaingresoturno"),
    @NamedQuery(name = "Turno.findByHorasalidaturno", query = "SELECT t FROM Turno t WHERE t.horasalidaturno = :horasalidaturno"),
    @NamedQuery(name = "Turno.findByEstadoturno", query = "SELECT t FROM Turno t WHERE t.estadoturno = :estadoturno"),
    @NamedQuery(name = "Turno.findByObservacionesturno", query = "SELECT t FROM Turno t WHERE t.observacionesturno = :observacionesturno")})
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoturno")
    private Integer codigoturno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroturno")
    private int numeroturno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaturno")
    @Temporal(TemporalType.DATE)
    private Date fechaturno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "horaingresoturno")
    private String horaingresoturno;
    @Size(max = 50)
    @Column(name = "horasalidaturno")
    private String horasalidaturno;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "motivoturno")
    private String motivoturno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estadoturno")
    private String estadoturno;
    @Size(max = 50)
    @Column(name = "observacionesturno")
    private String observacionesturno;
    @JoinColumn(name = "codigoarea", referencedColumnName = "codigoarea")
    @ManyToOne(optional = false)
    private Area codigoarea;
    @JoinColumn(name = "documentocliente", referencedColumnName = "documentocliente")
    @ManyToOne(optional = false)
    private Clienteexterno documentocliente;

    public Turno() {
    }

    public Turno(Integer codigoturno) {
        this.codigoturno = codigoturno;
    }

    public Turno(Integer codigoturno, int numeroturno, Date fechaturno, String horaingresoturno, String motivoturno, String estadoturno) {
        this.codigoturno = codigoturno;
        this.numeroturno = numeroturno;
        this.fechaturno = fechaturno;
        this.horaingresoturno = horaingresoturno;
        this.motivoturno = motivoturno;
        this.estadoturno = estadoturno;
    }

    public Integer getCodigoturno() {
        return codigoturno;
    }

    public void setCodigoturno(Integer codigoturno) {
        this.codigoturno = codigoturno;
    }

    public int getNumeroturno() {
        return numeroturno;
    }

    public void setNumeroturno(int numeroturno) {
        this.numeroturno = numeroturno;
    }

    public Date getFechaturno() {
        return fechaturno;
    }

    public void setFechaturno(Date fechaturno) {
        this.fechaturno = fechaturno;
    }

    public String getHoraingresoturno() {
        return horaingresoturno;
    }

    public void setHoraingresoturno(String horaingresoturno) {
        this.horaingresoturno = horaingresoturno;
    }

    public String getHorasalidaturno() {
        return horasalidaturno;
    }

    public void setHorasalidaturno(String horasalidaturno) {
        this.horasalidaturno = horasalidaturno;
    }

    public String getMotivoturno() {
        return motivoturno;
    }

    public void setMotivoturno(String motivoturno) {
        this.motivoturno = motivoturno;
    }

    public String getEstadoturno() {
        return estadoturno;
    }

    public void setEstadoturno(String estadoturno) {
        this.estadoturno = estadoturno;
    }

    public String getObservacionesturno() {
        return observacionesturno;
    }

    public void setObservacionesturno(String observacionesturno) {
        this.observacionesturno = observacionesturno;
    }

    public Area getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Area codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Clienteexterno getDocumentocliente() {
        return documentocliente;
    }

    public void setDocumentocliente(Clienteexterno documentocliente) {
        this.documentocliente = documentocliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoturno != null ? codigoturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.codigoturno == null && other.codigoturno != null) || (this.codigoturno != null && !this.codigoturno.equals(other.codigoturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Turno[ codigoturno=" + codigoturno + " ]";
    }
    
}
