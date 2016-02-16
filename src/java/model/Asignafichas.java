/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "asignafichas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignafichas.findAll", query = "SELECT a FROM Asignafichas a"),
    @NamedQuery(name = "Asignafichas.findByCodigoasigna", query = "SELECT a FROM Asignafichas a WHERE a.codigoasigna = :codigoasigna")})
public class Asignafichas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoasigna")
    private Integer codigoasigna;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "fichatitulacion")
    @ManyToOne
    private Fichatitulacion fichatitulacion;

    public Asignafichas() {
    }

    public Asignafichas(Integer codigoasigna) {
        this.codigoasigna = codigoasigna;
    }

    public Integer getCodigoasigna() {
        return codigoasigna;
    }

    public void setCodigoasigna(Integer codigoasigna) {
        this.codigoasigna = codigoasigna;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public Fichatitulacion getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(Fichatitulacion fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoasigna != null ? codigoasigna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignafichas)) {
            return false;
        }
        Asignafichas other = (Asignafichas) object;
        if ((this.codigoasigna == null && other.codigoasigna != null) || (this.codigoasigna != null && !this.codigoasigna.equals(other.codigoasigna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Asignafichas[ codigoasigna=" + codigoasigna + " ]";
    }
    
}
