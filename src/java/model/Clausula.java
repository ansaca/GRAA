/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "clausula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clausula.findAll", query = "SELECT c FROM Clausula c"),
    @NamedQuery(name = "Clausula.findByCodigoclausula", query = "SELECT c FROM Clausula c WHERE c.codigoclausula = :codigoclausula")})
public class Clausula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoclausula")
    private Integer codigoclausula;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionclausula")
    private String descripcionclausula;
    @JoinTable(name = "clausulacontrato", joinColumns = {
        @JoinColumn(name = "codigoclausula", referencedColumnName = "codigoclausula")}, inverseJoinColumns = {
        @JoinColumn(name = "numerocontrato", referencedColumnName = "numerocontrato")})
    @ManyToMany
    private List<Contrato> contratoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clausula")
    private List<Accionescontrato> accionescontratoList;

    public Clausula() {
    }

    public Clausula(Integer codigoclausula) {
        this.codigoclausula = codigoclausula;
    }

    public Integer getCodigoclausula() {
        return codigoclausula;
    }

    public void setCodigoclausula(Integer codigoclausula) {
        this.codigoclausula = codigoclausula;
    }

    public String getDescripcionclausula() {
        return descripcionclausula;
    }

    public void setDescripcionclausula(String descripcionclausula) {
        this.descripcionclausula = descripcionclausula;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @XmlTransient
    public List<Accionescontrato> getAccionescontratoList() {
        return accionescontratoList;
    }

    public void setAccionescontratoList(List<Accionescontrato> accionescontratoList) {
        this.accionescontratoList = accionescontratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoclausula != null ? codigoclausula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clausula)) {
            return false;
        }
        Clausula other = (Clausula) object;
        if ((this.codigoclausula == null && other.codigoclausula != null) || (this.codigoclausula != null && !this.codigoclausula.equals(other.codigoclausula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clausula[ codigoclausula=" + codigoclausula + " ]";
    }
    
}
