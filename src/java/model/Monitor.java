/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByCodigomonitor", query = "SELECT m FROM Monitor m WHERE m.codigomonitor = :codigomonitor"),
    @NamedQuery(name = "Monitor.findByFechainiciomonitoria", query = "SELECT m FROM Monitor m WHERE m.fechainiciomonitoria = :fechainiciomonitoria"),
    @NamedQuery(name = "Monitor.findByFechafinmonitoria", query = "SELECT m FROM Monitor m WHERE m.fechafinmonitoria = :fechafinmonitoria"),
    @NamedQuery(name = "Monitor.findByEstadomonitoria", query = "SELECT m FROM Monitor m WHERE m.estadomonitoria = :estadomonitoria"),
    @NamedQuery(name = "Monitor.findByNumerocuentamonitor", query = "SELECT m FROM Monitor m WHERE m.numerocuentamonitor = :numerocuentamonitor")})
public class Monitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigomonitor")
    private Integer codigomonitor;
    @Column(name = "fechainiciomonitoria")
    @Temporal(TemporalType.DATE)
    private Date fechainiciomonitoria;
    @Column(name = "fechafinmonitoria")
    @Temporal(TemporalType.DATE)
    private Date fechafinmonitoria;
    @Lob
    @Size(max = 65535)
    @Column(name = "proyectomonitor")
    private String proyectomonitor;
    @Size(max = 50)
    @Column(name = "estadomonitoria")
    private String estadomonitoria;
    @Column(name = "numerocuentamonitor")
    private BigInteger numerocuentamonitor;
    @OneToMany(mappedBy = "codigomonitoractividad")
    private List<Actividad> actividadList;
    @OneToMany(mappedBy = "codigomonitor")
    private List<Informe> informeList;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;
    @JoinColumn(name = "codigotipomonitoria", referencedColumnName = "codigotipomonitoria")
    @ManyToOne
    private Tipomonitoria codigotipomonitoria;

    public Monitor() {
    }

    public Monitor(Integer codigomonitor) {
        this.codigomonitor = codigomonitor;
    }

    public Integer getCodigomonitor() {
        return codigomonitor;
    }

    public void setCodigomonitor(Integer codigomonitor) {
        this.codigomonitor = codigomonitor;
    }

    public Date getFechainiciomonitoria() {
        return fechainiciomonitoria;
    }

    public void setFechainiciomonitoria(Date fechainiciomonitoria) {
        this.fechainiciomonitoria = fechainiciomonitoria;
    }

    public Date getFechafinmonitoria() {
        return fechafinmonitoria;
    }

    public void setFechafinmonitoria(Date fechafinmonitoria) {
        this.fechafinmonitoria = fechafinmonitoria;
    }

    public String getProyectomonitor() {
        return proyectomonitor;
    }

    public void setProyectomonitor(String proyectomonitor) {
        this.proyectomonitor = proyectomonitor;
    }

    public String getEstadomonitoria() {
        return estadomonitoria;
    }

    public void setEstadomonitoria(String estadomonitoria) {
        this.estadomonitoria = estadomonitoria;
    }

    public BigInteger getNumerocuentamonitor() {
        return numerocuentamonitor;
    }

    public void setNumerocuentamonitor(BigInteger numerocuentamonitor) {
        this.numerocuentamonitor = numerocuentamonitor;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    public Tipomonitoria getCodigotipomonitoria() {
        return codigotipomonitoria;
    }

    public void setCodigotipomonitoria(Tipomonitoria codigotipomonitoria) {
        this.codigotipomonitoria = codigotipomonitoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigomonitor != null ? codigomonitor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.codigomonitor == null && other.codigomonitor != null) || (this.codigomonitor != null && !this.codigomonitor.equals(other.codigomonitor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Monitor[ codigomonitor=" + codigomonitor + " ]";
    }
    
}
