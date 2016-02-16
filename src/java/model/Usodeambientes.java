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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "usodeambientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usodeambientes.findAll", query = "SELECT u FROM Usodeambientes u"),
    @NamedQuery(name = "Usodeambientes.findByCodigousoambiente", query = "SELECT u FROM Usodeambientes u WHERE u.codigousoambiente = :codigousoambiente"),
    @NamedQuery(name = "Usodeambientes.findByFechausoambiente", query = "SELECT u FROM Usodeambientes u WHERE u.fechausoambiente = :fechausoambiente"),
    @NamedQuery(name = "Usodeambientes.findByHoraentradaambiente", query = "SELECT u FROM Usodeambientes u WHERE u.horaentradaambiente = :horaentradaambiente"),
    @NamedQuery(name = "Usodeambientes.findByHorasalidaambiente", query = "SELECT u FROM Usodeambientes u WHERE u.horasalidaambiente = :horasalidaambiente"),
    @NamedQuery(name = "Usodeambientes.findByEntregaambiente", query = "SELECT u FROM Usodeambientes u WHERE u.entregaambiente = :entregaambiente")})
public class Usodeambientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigousoambiente")
    private Integer codigousoambiente;
    @Column(name = "fechausoambiente")
    @Temporal(TemporalType.DATE)
    private Date fechausoambiente;
    @Size(max = 50)
    @Column(name = "horaentradaambiente")
    private String horaentradaambiente;
    @Size(max = 50)
    @Column(name = "horasalidaambiente")
    private String horasalidaambiente;
    @Size(max = 50)
    @Column(name = "entregaambiente")
    private String entregaambiente;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionesusoambiente")
    private String observacionesusoambiente;
    @JoinColumn(name = "codigoambiente", referencedColumnName = "codigoambiente")
    @ManyToOne
    private Ambientedeaprendizaje codigoambiente;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "fichatitulacion")
    @ManyToOne
    private Fichatitulacion fichatitulacion;
    @JoinColumn(name = "documentoguarda", referencedColumnName = "documentoguarda")
    @ManyToOne
    private Guarda documentoguarda;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;
    @JoinColumn(name = "codigoreservaambiente", referencedColumnName = "codigoreservambiente")
    @ManyToOne
    private Reservaambiente codigoreservaambiente;

    public Usodeambientes() {
    }

    public Usodeambientes(Integer codigousoambiente) {
        this.codigousoambiente = codigousoambiente;
    }

    public Integer getCodigousoambiente() {
        return codigousoambiente;
    }

    public void setCodigousoambiente(Integer codigousoambiente) {
        this.codigousoambiente = codigousoambiente;
    }

    public Date getFechausoambiente() {
        return fechausoambiente;
    }

    public void setFechausoambiente(Date fechausoambiente) {
        this.fechausoambiente = fechausoambiente;
    }

    public String getHoraentradaambiente() {
        return horaentradaambiente;
    }

    public void setHoraentradaambiente(String horaentradaambiente) {
        this.horaentradaambiente = horaentradaambiente;
    }

    public String getHorasalidaambiente() {
        return horasalidaambiente;
    }

    public void setHorasalidaambiente(String horasalidaambiente) {
        this.horasalidaambiente = horasalidaambiente;
    }

    public String getEntregaambiente() {
        return entregaambiente;
    }

    public void setEntregaambiente(String entregaambiente) {
        this.entregaambiente = entregaambiente;
    }

    public String getObservacionesusoambiente() {
        return observacionesusoambiente;
    }

    public void setObservacionesusoambiente(String observacionesusoambiente) {
        this.observacionesusoambiente = observacionesusoambiente;
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

    public Guarda getDocumentoguarda() {
        return documentoguarda;
    }

    public void setDocumentoguarda(Guarda documentoguarda) {
        this.documentoguarda = documentoguarda;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public Reservaambiente getCodigoreservaambiente() {
        return codigoreservaambiente;
    }

    public void setCodigoreservaambiente(Reservaambiente codigoreservaambiente) {
        this.codigoreservaambiente = codigoreservaambiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigousoambiente != null ? codigousoambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usodeambientes)) {
            return false;
        }
        Usodeambientes other = (Usodeambientes) object;
        if ((this.codigousoambiente == null && other.codigousoambiente != null) || (this.codigousoambiente != null && !this.codigousoambiente.equals(other.codigousoambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usodeambientes[ codigousoambiente=" + codigousoambiente + " ]";
    }
    
}
