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
@Table(name = "evaluacionaprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacionaprendiz.findAll", query = "SELECT e FROM Evaluacionaprendiz e"),
    @NamedQuery(name = "Evaluacionaprendiz.findByCodigoevaluaciona", query = "SELECT e FROM Evaluacionaprendiz e WHERE e.codigoevaluaciona = :codigoevaluaciona"),
    @NamedQuery(name = "Evaluacionaprendiz.findByFechaevaluaciona", query = "SELECT e FROM Evaluacionaprendiz e WHERE e.fechaevaluaciona = :fechaevaluaciona")})
public class Evaluacionaprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoevaluaciona")
    private Integer codigoevaluaciona;
    @Column(name = "fechaevaluaciona")
    @Temporal(TemporalType.DATE)
    private Date fechaevaluaciona;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Evaluacionaprendiz() {
    }

    public Evaluacionaprendiz(Integer codigoevaluaciona) {
        this.codigoevaluaciona = codigoevaluaciona;
    }

    public Integer getCodigoevaluaciona() {
        return codigoevaluaciona;
    }

    public void setCodigoevaluaciona(Integer codigoevaluaciona) {
        this.codigoevaluaciona = codigoevaluaciona;
    }

    public Date getFechaevaluaciona() {
        return fechaevaluaciona;
    }

    public void setFechaevaluaciona(Date fechaevaluaciona) {
        this.fechaevaluaciona = fechaevaluaciona;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
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
        hash += (codigoevaluaciona != null ? codigoevaluaciona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacionaprendiz)) {
            return false;
        }
        Evaluacionaprendiz other = (Evaluacionaprendiz) object;
        if ((this.codigoevaluaciona == null && other.codigoevaluaciona != null) || (this.codigoevaluaciona != null && !this.codigoevaluaciona.equals(other.codigoevaluaciona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Evaluacionaprendiz[ codigoevaluaciona=" + codigoevaluaciona + " ]";
    }
    
}
