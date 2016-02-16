/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "eproductiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eproductiva.findAll", query = "SELECT e FROM Eproductiva e"),
    @NamedQuery(name = "Eproductiva.findByCodigoeproductiva", query = "SELECT e FROM Eproductiva e WHERE e.codigoeproductiva = :codigoeproductiva"),
    @NamedQuery(name = "Eproductiva.findByFechainicioproductiva", query = "SELECT e FROM Eproductiva e WHERE e.fechainicioproductiva = :fechainicioproductiva"),
    @NamedQuery(name = "Eproductiva.findByFechafinproductiva", query = "SELECT e FROM Eproductiva e WHERE e.fechafinproductiva = :fechafinproductiva"),
    @NamedQuery(name = "Eproductiva.findByEstadoproductiva", query = "SELECT e FROM Eproductiva e WHERE e.estadoproductiva = :estadoproductiva"),
    @NamedQuery(name = "Eproductiva.findByCartaproductiva", query = "SELECT e FROM Eproductiva e WHERE e.cartaproductiva = :cartaproductiva"),
    @NamedQuery(name = "Eproductiva.findByFormatoproductiva", query = "SELECT e FROM Eproductiva e WHERE e.formatoproductiva = :formatoproductiva")})
public class Eproductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoeproductiva")
    private Integer codigoeproductiva;
    @Column(name = "fechainicioproductiva")
    @Temporal(TemporalType.DATE)
    private Date fechainicioproductiva;
    @Column(name = "fechafinproductiva")
    @Temporal(TemporalType.DATE)
    private Date fechafinproductiva;
    @Lob
    @Size(max = 65535)
    @Column(name = "funcionesproductiva")
    private String funcionesproductiva;
    @Size(max = 50)
    @Column(name = "estadoproductiva")
    private String estadoproductiva;
    @Size(max = 50)
    @Column(name = "cartaproductiva")
    private String cartaproductiva;
    @Size(max = 50)
    @Column(name = "formatoproductiva")
    private String formatoproductiva;
    @OneToMany(mappedBy = "codigoeproductiva")
    private List<Seguimientop> seguimientopList;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "documentocoformador", referencedColumnName = "documentocoformador")
    @ManyToOne
    private Coformador documentocoformador;
    @JoinColumn(name = "numeroempresa", referencedColumnName = "numeroempresa")
    @ManyToOne
    private Empresa numeroempresa;
    @JoinColumn(name = "codigotipopractica", referencedColumnName = "codigotipopractica")
    @ManyToOne
    private Tipopractica codigotipopractica;
    @OneToMany(mappedBy = "codigoeproductiva")
    private List<Visita> visitaList;

    public Eproductiva() {
    }

    public Eproductiva(Integer codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    public Integer getCodigoeproductiva() {
        return codigoeproductiva;
    }

    public void setCodigoeproductiva(Integer codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    public Date getFechainicioproductiva() {
        return fechainicioproductiva;
    }

    public void setFechainicioproductiva(Date fechainicioproductiva) {
        this.fechainicioproductiva = fechainicioproductiva;
    }

    public Date getFechafinproductiva() {
        return fechafinproductiva;
    }

    public void setFechafinproductiva(Date fechafinproductiva) {
        this.fechafinproductiva = fechafinproductiva;
    }

    public String getFuncionesproductiva() {
        return funcionesproductiva;
    }

    public void setFuncionesproductiva(String funcionesproductiva) {
        this.funcionesproductiva = funcionesproductiva;
    }

    public String getEstadoproductiva() {
        return estadoproductiva;
    }

    public void setEstadoproductiva(String estadoproductiva) {
        this.estadoproductiva = estadoproductiva;
    }

    public String getCartaproductiva() {
        return cartaproductiva;
    }

    public void setCartaproductiva(String cartaproductiva) {
        this.cartaproductiva = cartaproductiva;
    }

    public String getFormatoproductiva() {
        return formatoproductiva;
    }

    public void setFormatoproductiva(String formatoproductiva) {
        this.formatoproductiva = formatoproductiva;
    }

    @XmlTransient
    public List<Seguimientop> getSeguimientopList() {
        return seguimientopList;
    }

    public void setSeguimientopList(List<Seguimientop> seguimientopList) {
        this.seguimientopList = seguimientopList;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Coformador getDocumentocoformador() {
        return documentocoformador;
    }

    public void setDocumentocoformador(Coformador documentocoformador) {
        this.documentocoformador = documentocoformador;
    }

    public Empresa getNumeroempresa() {
        return numeroempresa;
    }

    public void setNumeroempresa(Empresa numeroempresa) {
        this.numeroempresa = numeroempresa;
    }

    public Tipopractica getCodigotipopractica() {
        return codigotipopractica;
    }

    public void setCodigotipopractica(Tipopractica codigotipopractica) {
        this.codigotipopractica = codigotipopractica;
    }

    @XmlTransient
    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoeproductiva != null ? codigoeproductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eproductiva)) {
            return false;
        }
        Eproductiva other = (Eproductiva) object;
        if ((this.codigoeproductiva == null && other.codigoeproductiva != null) || (this.codigoeproductiva != null && !this.codigoeproductiva.equals(other.codigoeproductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Eproductiva[ codigoeproductiva=" + codigoeproductiva + " ]";
    }
    
}
