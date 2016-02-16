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
import javax.persistence.CascadeType;
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
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByCodigoseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.codigoseguimiento = :codigoseguimiento"),
    @NamedQuery(name = "Seguimiento.findByNumeroactaseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.numeroactaseguimiento = :numeroactaseguimiento"),
    @NamedQuery(name = "Seguimiento.findByFechaseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.fechaseguimiento = :fechaseguimiento"),
    @NamedQuery(name = "Seguimiento.findByFaseseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.faseseguimiento = :faseseguimiento"),
    @NamedQuery(name = "Seguimiento.findByCompetenciasseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.competenciasseguimiento = :competenciasseguimiento"),
    @NamedQuery(name = "Seguimiento.findByLugarseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.lugarseguimiento = :lugarseguimiento"),
    @NamedQuery(name = "Seguimiento.findByHoraseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horaseguimiento = :horaseguimiento"),
    @NamedQuery(name = "Seguimiento.findByHorafinseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horafinseguimiento = :horafinseguimiento"),
    @NamedQuery(name = "Seguimiento.findByEstadoseguimiento", query = "SELECT s FROM Seguimiento s WHERE s.estadoseguimiento = :estadoseguimiento")})
public class Seguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoseguimiento")
    private Integer codigoseguimiento;
    @Column(name = "numeroactaseguimiento")
    private Integer numeroactaseguimiento;
    @Column(name = "fechaseguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaseguimiento;
    @Size(max = 200)
    @Column(name = "faseseguimiento")
    private String faseseguimiento;
    @Size(max = 200)
    @Column(name = "competenciasseguimiento")
    private String competenciasseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "obsseguimiento")
    private String obsseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "conclusionesseguimiento")
    private String conclusionesseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "compromisosseguimiento")
    private String compromisosseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "ciudadseguimiento")
    private String ciudadseguimiento;
    @Size(max = 100)
    @Column(name = "lugarseguimiento")
    private String lugarseguimiento;
    @Size(max = 100)
    @Column(name = "horaseguimiento")
    private String horaseguimiento;
    @Size(max = 100)
    @Column(name = "horafinseguimiento")
    private String horafinseguimiento;
    @Size(max = 100)
    @Column(name = "estadoseguimiento")
    private String estadoseguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private List<Seguimientoaprendiz> seguimientoaprendizList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguimiento")
    private List<Comite> comiteList;
    @JoinColumn(name = "fichatitulacion", referencedColumnName = "fichatitulacion")
    @ManyToOne
    private Fichatitulacion fichatitulacion;

    public Seguimiento() {
    }

    public Seguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public Integer getCodigoseguimiento() {
        return codigoseguimiento;
    }

    public void setCodigoseguimiento(Integer codigoseguimiento) {
        this.codigoseguimiento = codigoseguimiento;
    }

    public Integer getNumeroactaseguimiento() {
        return numeroactaseguimiento;
    }

    public void setNumeroactaseguimiento(Integer numeroactaseguimiento) {
        this.numeroactaseguimiento = numeroactaseguimiento;
    }

    public Date getFechaseguimiento() {
        return fechaseguimiento;
    }

    public void setFechaseguimiento(Date fechaseguimiento) {
        this.fechaseguimiento = fechaseguimiento;
    }

    public String getFaseseguimiento() {
        return faseseguimiento;
    }

    public void setFaseseguimiento(String faseseguimiento) {
        this.faseseguimiento = faseseguimiento;
    }

    public String getCompetenciasseguimiento() {
        return competenciasseguimiento;
    }

    public void setCompetenciasseguimiento(String competenciasseguimiento) {
        this.competenciasseguimiento = competenciasseguimiento;
    }

    public String getObsseguimiento() {
        return obsseguimiento;
    }

    public void setObsseguimiento(String obsseguimiento) {
        this.obsseguimiento = obsseguimiento;
    }

    public String getConclusionesseguimiento() {
        return conclusionesseguimiento;
    }

    public void setConclusionesseguimiento(String conclusionesseguimiento) {
        this.conclusionesseguimiento = conclusionesseguimiento;
    }

    public String getCompromisosseguimiento() {
        return compromisosseguimiento;
    }

    public void setCompromisosseguimiento(String compromisosseguimiento) {
        this.compromisosseguimiento = compromisosseguimiento;
    }

    public String getCiudadseguimiento() {
        return ciudadseguimiento;
    }

    public void setCiudadseguimiento(String ciudadseguimiento) {
        this.ciudadseguimiento = ciudadseguimiento;
    }

    public String getLugarseguimiento() {
        return lugarseguimiento;
    }

    public void setLugarseguimiento(String lugarseguimiento) {
        this.lugarseguimiento = lugarseguimiento;
    }

    public String getHoraseguimiento() {
        return horaseguimiento;
    }

    public void setHoraseguimiento(String horaseguimiento) {
        this.horaseguimiento = horaseguimiento;
    }

    public String getHorafinseguimiento() {
        return horafinseguimiento;
    }

    public void setHorafinseguimiento(String horafinseguimiento) {
        this.horafinseguimiento = horafinseguimiento;
    }

    public String getEstadoseguimiento() {
        return estadoseguimiento;
    }

    public void setEstadoseguimiento(String estadoseguimiento) {
        this.estadoseguimiento = estadoseguimiento;
    }

    @XmlTransient
    public List<Seguimientoaprendiz> getSeguimientoaprendizList() {
        return seguimientoaprendizList;
    }

    public void setSeguimientoaprendizList(List<Seguimientoaprendiz> seguimientoaprendizList) {
        this.seguimientoaprendizList = seguimientoaprendizList;
    }

    @XmlTransient
    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
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
        hash += (codigoseguimiento != null ? codigoseguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codigoseguimiento == null && other.codigoseguimiento != null) || (this.codigoseguimiento != null && !this.codigoseguimiento.equals(other.codigoseguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seguimiento[ codigoseguimiento=" + codigoseguimiento + " ]";
    }
    
}
