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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "evaluacioncoordinador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacioncoordinador.findAll", query = "SELECT e FROM Evaluacioncoordinador e"),
    @NamedQuery(name = "Evaluacioncoordinador.findByCodigoevaluacionc", query = "SELECT e FROM Evaluacioncoordinador e WHERE e.codigoevaluacionc = :codigoevaluacionc"),
    @NamedQuery(name = "Evaluacioncoordinador.findByFechaevaluacionc", query = "SELECT e FROM Evaluacioncoordinador e WHERE e.fechaevaluacionc = :fechaevaluacionc")})
public class Evaluacioncoordinador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoevaluacionc")
    private Integer codigoevaluacionc;
    @Column(name = "fechaevaluacionc")
    @Temporal(TemporalType.DATE)
    private Date fechaevaluacionc;
    @JoinColumn(name = "documentocoordinador", referencedColumnName = "documentocoordinador")
    @ManyToOne
    private Coordinador documentocoordinador;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Evaluacioncoordinador() {
    }

    public Evaluacioncoordinador(Integer codigoevaluacionc) {
        this.codigoevaluacionc = codigoevaluacionc;
    }

    public Integer getCodigoevaluacionc() {
        return codigoevaluacionc;
    }

    public void setCodigoevaluacionc(Integer codigoevaluacionc) {
        this.codigoevaluacionc = codigoevaluacionc;
    }

    public Date getFechaevaluacionc() {
        return fechaevaluacionc;
    }

    public void setFechaevaluacionc(Date fechaevaluacionc) {
        this.fechaevaluacionc = fechaevaluacionc;
    }

    public Coordinador getDocumentocoordinador() {
        return documentocoordinador;
    }

    public void setDocumentocoordinador(Coordinador documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoevaluacionc != null ? codigoevaluacionc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacioncoordinador)) {
            return false;
        }
        Evaluacioncoordinador other = (Evaluacioncoordinador) object;
        if ((this.codigoevaluacionc == null && other.codigoevaluacionc != null) || (this.codigoevaluacionc != null && !this.codigoevaluacionc.equals(other.codigoevaluacionc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evaluacioncoordinador[ codigoevaluacionc=" + codigoevaluacionc + " ]";
    }
    
}
