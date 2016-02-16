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
@Table(name = "elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e"),
    @NamedQuery(name = "Elemento.findByCodigoelemento", query = "SELECT e FROM Elemento e WHERE e.codigoelemento = :codigoelemento"),
    @NamedQuery(name = "Elemento.findByNombreelemento", query = "SELECT e FROM Elemento e WHERE e.nombreelemento = :nombreelemento")})
public class Elemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoelemento")
    private Integer codigoelemento;
    @Size(max = 50)
    @Column(name = "nombreelemento")
    private String nombreelemento;
    @OneToMany(mappedBy = "codigoelemento")
    private List<Criterio> criterioList;

    public Elemento() {
    }

    public Elemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public Integer getCodigoelemento() {
        return codigoelemento;
    }

    public void setCodigoelemento(Integer codigoelemento) {
        this.codigoelemento = codigoelemento;
    }

    public String getNombreelemento() {
        return nombreelemento;
    }

    public void setNombreelemento(String nombreelemento) {
        this.nombreelemento = nombreelemento;
    }

    @XmlTransient
    public List<Criterio> getCriterioList() {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList) {
        this.criterioList = criterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoelemento != null ? codigoelemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.codigoelemento == null && other.codigoelemento != null) || (this.codigoelemento != null && !this.codigoelemento.equals(other.codigoelemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Elemento[ codigoelemento=" + codigoelemento + " ]";
    }
    
}
