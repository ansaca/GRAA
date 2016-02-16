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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByCodigoactividad", query = "SELECT a FROM Actividad a WHERE a.codigoactividad = :codigoactividad"),
    @NamedQuery(name = "Actividad.findByFechaactividad", query = "SELECT a FROM Actividad a WHERE a.fechaactividad = :fechaactividad"),
    @NamedQuery(name = "Actividad.findByHoradesdeactividad", query = "SELECT a FROM Actividad a WHERE a.horadesdeactividad = :horadesdeactividad"),
    @NamedQuery(name = "Actividad.findByHorahastaactividad", query = "SELECT a FROM Actividad a WHERE a.horahastaactividad = :horahastaactividad"),
    @NamedQuery(name = "Actividad.findByCantidadhorasactividad", query = "SELECT a FROM Actividad a WHERE a.cantidadhorasactividad = :cantidadhorasactividad")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoactividad")
    private Integer codigoactividad;
    @Column(name = "fechaactividad")
    @Temporal(TemporalType.DATE)
    private Date fechaactividad;
    @Size(max = 50)
    @Column(name = "horadesdeactividad")
    private String horadesdeactividad;
    @Size(max = 50)
    @Column(name = "horahastaactividad")
    private String horahastaactividad;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionactividad")
    private String descripcionactividad;
    @Lob
    @Size(max = 65535)
    @Column(name = "resultadosobtenidosactividad")
    private String resultadosobtenidosactividad;
    @Column(name = "cantidadhorasactividad")
    private Integer cantidadhorasactividad;
    @JoinColumn(name = "codigoinformeactividad", referencedColumnName = "codigoinforme")
    @ManyToOne
    private Informe codigoinformeactividad;
    @JoinColumn(name = "codigomonitoractividad", referencedColumnName = "codigomonitor")
    @ManyToOne
    private Monitor codigomonitoractividad;

    public Actividad() {
    }

    public Actividad(Integer codigoactividad) {
        this.codigoactividad = codigoactividad;
    }

    public Integer getCodigoactividad() {
        return codigoactividad;
    }

    public void setCodigoactividad(Integer codigoactividad) {
        this.codigoactividad = codigoactividad;
    }

    public Date getFechaactividad() {
        return fechaactividad;
    }

    public void setFechaactividad(Date fechaactividad) {
        this.fechaactividad = fechaactividad;
    }

    public String getHoradesdeactividad() {
        return horadesdeactividad;
    }

    public void setHoradesdeactividad(String horadesdeactividad) {
        this.horadesdeactividad = horadesdeactividad;
    }

    public String getHorahastaactividad() {
        return horahastaactividad;
    }

    public void setHorahastaactividad(String horahastaactividad) {
        this.horahastaactividad = horahastaactividad;
    }

    public String getDescripcionactividad() {
        return descripcionactividad;
    }

    public void setDescripcionactividad(String descripcionactividad) {
        this.descripcionactividad = descripcionactividad;
    }

    public String getResultadosobtenidosactividad() {
        return resultadosobtenidosactividad;
    }

    public void setResultadosobtenidosactividad(String resultadosobtenidosactividad) {
        this.resultadosobtenidosactividad = resultadosobtenidosactividad;
    }

    public Integer getCantidadhorasactividad() {
        return cantidadhorasactividad;
    }

    public void setCantidadhorasactividad(Integer cantidadhorasactividad) {
        this.cantidadhorasactividad = cantidadhorasactividad;
    }

    public Informe getCodigoinformeactividad() {
        return codigoinformeactividad;
    }

    public void setCodigoinformeactividad(Informe codigoinformeactividad) {
        this.codigoinformeactividad = codigoinformeactividad;
    }

    public Monitor getCodigomonitoractividad() {
        return codigomonitoractividad;
    }

    public void setCodigomonitoractividad(Monitor codigomonitoractividad) {
        this.codigomonitoractividad = codigomonitoractividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoactividad != null ? codigoactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.codigoactividad == null && other.codigoactividad != null) || (this.codigoactividad != null && !this.codigoactividad.equals(other.codigoactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Actividad[ codigoactividad=" + codigoactividad + " ]";
    }
    
}
