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
@Table(name = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findByCodigobanco", query = "SELECT b FROM Banco b WHERE b.codigobanco = :codigobanco"),
    @NamedQuery(name = "Banco.findByNombrebanco", query = "SELECT b FROM Banco b WHERE b.nombrebanco = :nombrebanco")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigobanco")
    private Integer codigobanco;
    @Size(max = 50)
    @Column(name = "nombrebanco")
    private String nombrebanco;
    @OneToMany(mappedBy = "codigobancocontrato")
    private List<Contrato> contratoList;

    public Banco() {
    }

    public Banco(Integer codigobanco) {
        this.codigobanco = codigobanco;
    }

    public Integer getCodigobanco() {
        return codigobanco;
    }

    public void setCodigobanco(Integer codigobanco) {
        this.codigobanco = codigobanco;
    }

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    @XmlTransient
    public List<Contrato> getContratoList() {
        return contratoList;
    }

    public void setContratoList(List<Contrato> contratoList) {
        this.contratoList = contratoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigobanco != null ? codigobanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codigobanco == null && other.codigobanco != null) || (this.codigobanco != null && !this.codigobanco.equals(other.codigobanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Banco[ codigobanco=" + codigobanco + " ]";
    }
    
}
