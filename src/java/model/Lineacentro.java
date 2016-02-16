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
@Table(name = "lineacentro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineacentro.findAll", query = "SELECT l FROM Lineacentro l"),
    @NamedQuery(name = "Lineacentro.findByCodigolinea", query = "SELECT l FROM Lineacentro l WHERE l.codigolinea = :codigolinea"),
    @NamedQuery(name = "Lineacentro.findByNombrelinea", query = "SELECT l FROM Lineacentro l WHERE l.nombrelinea = :nombrelinea")})
public class Lineacentro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigolinea")
    private Integer codigolinea;
    @Size(max = 50)
    @Column(name = "nombrelinea")
    private String nombrelinea;
    @OneToMany(mappedBy = "codigolineacontrato")
    private List<Contrato> contratoList;
    @JoinColumn(name = "codigocentrolinea", referencedColumnName = "codigocentro")
    @ManyToOne
    private Centro codigocentrolinea;

    public Lineacentro() {
    }

    public Lineacentro(Integer codigolinea) {
        this.codigolinea = codigolinea;
    }

    public Integer getCodigolinea() {
        return codigolinea;
    }

    public void setCodigolinea(Integer codigolinea) {
        this.codigolinea = codigolinea;
    }

    public String getNombrelinea() {
        return nombrelinea;
    }

    public void setNombrelinea(String nombrelinea) {
        this.nombrelinea = nombrelinea;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    public Centro getCodigocentrolinea() {
        return codigocentrolinea;
    }

    public void setCodigocentrolinea(Centro codigocentrolinea) {
        this.codigocentrolinea = codigocentrolinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigolinea != null ? codigolinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineacentro)) {
            return false;
        }
        Lineacentro other = (Lineacentro) object;
        if ((this.codigolinea == null && other.codigolinea != null) || (this.codigolinea != null && !this.codigolinea.equals(other.codigolinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lineacentro[ codigolinea=" + codigolinea + " ]";
    }
    
}
