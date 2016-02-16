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
@Table(name = "informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i"),
    @NamedQuery(name = "Informe.findByCodigoinforme", query = "SELECT i FROM Informe i WHERE i.codigoinforme = :codigoinforme"),
    @NamedQuery(name = "Informe.findByFechainforme", query = "SELECT i FROM Informe i WHERE i.fechainforme = :fechainforme"),
    @NamedQuery(name = "Informe.findByPeriodoinforme", query = "SELECT i FROM Informe i WHERE i.periodoinforme = :periodoinforme"),
    @NamedQuery(name = "Informe.findByEstadoinforme", query = "SELECT i FROM Informe i WHERE i.estadoinforme = :estadoinforme")})
public class Informe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoinforme")
    private Integer codigoinforme;
    @Column(name = "fechainforme")
    @Temporal(TemporalType.DATE)
    private Date fechainforme;
    @Size(max = 100)
    @Column(name = "periodoinforme")
    private String periodoinforme;
    @Lob
    @Size(max = 65535)
    @Column(name = "balanceinforme")
    private String balanceinforme;
    @Lob
    @Size(max = 65535)
    @Column(name = "sugerenciasinforme")
    private String sugerenciasinforme;
    @Lob
    @Column(name = "archivoevidencias")
    private byte[] archivoevidencias;
    @Size(max = 50)
    @Column(name = "estadoinforme")
    private String estadoinforme;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionesinforme")
    private String observacionesinforme;
    @OneToMany(mappedBy = "codigoinformeactividad")
    private List<Actividad> actividadList;
    @JoinColumn(name = "codigomonitor", referencedColumnName = "codigomonitor")
    @ManyToOne
    private Monitor codigomonitor;

    public Informe() {
    }

    public Informe(Integer codigoinforme) {
        this.codigoinforme = codigoinforme;
    }

    public Integer getCodigoinforme() {
        return codigoinforme;
    }

    public void setCodigoinforme(Integer codigoinforme) {
        this.codigoinforme = codigoinforme;
    }

    public Date getFechainforme() {
        return fechainforme;
    }

    public void setFechainforme(Date fechainforme) {
        this.fechainforme = fechainforme;
    }

    public String getPeriodoinforme() {
        return periodoinforme;
    }

    public void setPeriodoinforme(String periodoinforme) {
        this.periodoinforme = periodoinforme;
    }

    public String getBalanceinforme() {
        return balanceinforme;
    }

    public void setBalanceinforme(String balanceinforme) {
        this.balanceinforme = balanceinforme;
    }

    public String getSugerenciasinforme() {
        return sugerenciasinforme;
    }

    public void setSugerenciasinforme(String sugerenciasinforme) {
        this.sugerenciasinforme = sugerenciasinforme;
    }

    public byte[] getArchivoevidencias() {
        return archivoevidencias;
    }

    public void setArchivoevidencias(byte[] archivoevidencias) {
        this.archivoevidencias = archivoevidencias;
    }

    public String getEstadoinforme() {
        return estadoinforme;
    }

    public void setEstadoinforme(String estadoinforme) {
        this.estadoinforme = estadoinforme;
    }

    public String getObservacionesinforme() {
        return observacionesinforme;
    }

    public void setObservacionesinforme(String observacionesinforme) {
        this.observacionesinforme = observacionesinforme;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public Monitor getCodigomonitor() {
        return codigomonitor;
    }

    public void setCodigomonitor(Monitor codigomonitor) {
        this.codigomonitor = codigomonitor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoinforme != null ? codigoinforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.codigoinforme == null && other.codigoinforme != null) || (this.codigoinforme != null && !this.codigoinforme.equals(other.codigoinforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Informe[ codigoinforme=" + codigoinforme + " ]";
    }
    
}
