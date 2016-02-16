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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "fichatitulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichatitulacion.findAll", query = "SELECT f FROM Fichatitulacion f"),
    @NamedQuery(name = "Fichatitulacion.findByFichatitulacion", query = "SELECT f FROM Fichatitulacion f WHERE f.fichatitulacion = :fichatitulacion"),
    @NamedQuery(name = "Fichatitulacion.findByJornadatitulacion", query = "SELECT f FROM Fichatitulacion f WHERE f.jornadatitulacion = :jornadatitulacion")})
public class Fichatitulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fichatitulacion")
    private Integer fichatitulacion;
    @Size(max = 50)
    @Column(name = "jornadatitulacion")
    private String jornadatitulacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichatitulacion1")
    private List<Lideresficha> lideresfichaList;
    @OneToMany(mappedBy = "fichatitulacion")
    private List<Reservaambiente> reservaambienteList;
    @OneToMany(mappedBy = "fichatitulacion")
    private List<Usodeambientes> usodeambientesList;
    @OneToMany(mappedBy = "fichatitulacionaprendiz")
    private List<Aprendiz> aprendizList;
    @JoinColumn(name = "numerosede", referencedColumnName = "numerosede")
    @ManyToOne
    private Sede numerosede;
    @JoinColumn(name = "codigoprograma", referencedColumnName = "codigoprograma")
    @ManyToOne
    private Programa codigoprograma;
    @OneToMany(mappedBy = "fichatitulacion")
    private List<Seguimiento> seguimientoList;
    @OneToMany(mappedBy = "fichatitulacion")
    private List<Asignafichas> asignafichasList;

    public Fichatitulacion() {
    }

    public Fichatitulacion(Integer fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    public Integer getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(Integer fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    public String getJornadatitulacion() {
        return jornadatitulacion;
    }

    public void setJornadatitulacion(String jornadatitulacion) {
        this.jornadatitulacion = jornadatitulacion;
    }

    @XmlTransient
    public List<Lideresficha> getLideresfichaList() {
        return lideresfichaList;
    }

    public void setLideresfichaList(List<Lideresficha> lideresfichaList) {
        this.lideresfichaList = lideresfichaList;
    }

    @XmlTransient
    public List<Reservaambiente> getReservaambienteList() {
        return reservaambienteList;
    }

    public void setReservaambienteList(List<Reservaambiente> reservaambienteList) {
        this.reservaambienteList = reservaambienteList;
    }

    @XmlTransient
    public List<Usodeambientes> getUsodeambientesList() {
        return usodeambientesList;
    }

    public void setUsodeambientesList(List<Usodeambientes> usodeambientesList) {
        this.usodeambientesList = usodeambientesList;
    }

    @XmlTransient
    public List<Aprendiz> getAprendizList() {
        return aprendizList;
    }

    public void setAprendizList(List<Aprendiz> aprendizList) {
        this.aprendizList = aprendizList;
    }

    public Sede getNumerosede() {
        return numerosede;
    }

    public void setNumerosede(Sede numerosede) {
        this.numerosede = numerosede;
    }

    public Programa getCodigoprograma() {
        return codigoprograma;
    }

    public void setCodigoprograma(Programa codigoprograma) {
        this.codigoprograma = codigoprograma;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<Asignafichas> getAsignafichasList() {
        return asignafichasList;
    }

    public void setAsignafichasList(List<Asignafichas> asignafichasList) {
        this.asignafichasList = asignafichasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichatitulacion != null ? fichatitulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichatitulacion)) {
            return false;
        }
        Fichatitulacion other = (Fichatitulacion) object;
        if ((this.fichatitulacion == null && other.fichatitulacion != null) || (this.fichatitulacion != null && !this.fichatitulacion.equals(other.fichatitulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fichatitulacion[ fichatitulacion=" + fichatitulacion + " ]";
    }
    
}
