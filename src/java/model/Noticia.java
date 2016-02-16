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
import javax.persistence.Lob;
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
@Table(name = "noticia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticia.findAll", query = "SELECT n FROM Noticia n"),
    @NamedQuery(name = "Noticia.findByNumeronoticia", query = "SELECT n FROM Noticia n WHERE n.numeronoticia = :numeronoticia"),
    @NamedQuery(name = "Noticia.findByTitulonoticia", query = "SELECT n FROM Noticia n WHERE n.titulonoticia = :titulonoticia"),
    @NamedQuery(name = "Noticia.findByFechapublicacionnoticia", query = "SELECT n FROM Noticia n WHERE n.fechapublicacionnoticia = :fechapublicacionnoticia")})
public class Noticia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeronoticia")
    private Integer numeronoticia;
    @Size(max = 100)
    @Column(name = "titulonoticia")
    private String titulonoticia;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionnoticia")
    private String descripcionnoticia;
    @Column(name = "fechapublicacionnoticia")
    @Temporal(TemporalType.DATE)
    private Date fechapublicacionnoticia;

    public Noticia() {
    }

    public Noticia(Integer numeronoticia) {
        this.numeronoticia = numeronoticia;
    }

    public Integer getNumeronoticia() {
        return numeronoticia;
    }

    public void setNumeronoticia(Integer numeronoticia) {
        this.numeronoticia = numeronoticia;
    }

    public String getTitulonoticia() {
        return titulonoticia;
    }

    public void setTitulonoticia(String titulonoticia) {
        this.titulonoticia = titulonoticia;
    }

    public String getDescripcionnoticia() {
        return descripcionnoticia;
    }

    public void setDescripcionnoticia(String descripcionnoticia) {
        this.descripcionnoticia = descripcionnoticia;
    }

    public Date getFechapublicacionnoticia() {
        return fechapublicacionnoticia;
    }

    public void setFechapublicacionnoticia(Date fechapublicacionnoticia) {
        this.fechapublicacionnoticia = fechapublicacionnoticia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeronoticia != null ? numeronoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.numeronoticia == null && other.numeronoticia != null) || (this.numeronoticia != null && !this.numeronoticia.equals(other.numeronoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Noticia[ numeronoticia=" + numeronoticia + " ]";
    }
    
}
