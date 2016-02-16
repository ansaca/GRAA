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
@Table(name = "seguimientop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimientop.findAll", query = "SELECT s FROM Seguimientop s"),
    @NamedQuery(name = "Seguimientop.findByNumeroseguimientop", query = "SELECT s FROM Seguimientop s WHERE s.numeroseguimientop = :numeroseguimientop"),
    @NamedQuery(name = "Seguimientop.findByFechaseguimientoa", query = "SELECT s FROM Seguimientop s WHERE s.fechaseguimientoa = :fechaseguimientoa"),
    @NamedQuery(name = "Seguimientop.findByFechaseguimientoi", query = "SELECT s FROM Seguimientop s WHERE s.fechaseguimientoi = :fechaseguimientoi"),
    @NamedQuery(name = "Seguimientop.findByFechainicioseguimiento", query = "SELECT s FROM Seguimientop s WHERE s.fechainicioseguimiento = :fechainicioseguimiento"),
    @NamedQuery(name = "Seguimientop.findByFechafinseguimiento", query = "SELECT s FROM Seguimientop s WHERE s.fechafinseguimiento = :fechafinseguimiento")})
public class Seguimientop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroseguimientop")
    private Integer numeroseguimientop;
    @Column(name = "fechaseguimientoa")
    @Temporal(TemporalType.DATE)
    private Date fechaseguimientoa;
    @Column(name = "fechaseguimientoi")
    @Temporal(TemporalType.DATE)
    private Date fechaseguimientoi;
    @Lob
    @Size(max = 65535)
    @Column(name = "actividadesseguimiento")
    private String actividadesseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "balanceseguimiento")
    private String balanceseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionesseguimientoa")
    private String observacionesseguimientoa;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionesseguimientoi")
    private String observacionesseguimientoi;
    @Column(name = "fechainicioseguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechainicioseguimiento;
    @Column(name = "fechafinseguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechafinseguimiento;
    @JoinColumn(name = "codigoeproductiva", referencedColumnName = "codigoeproductiva")
    @ManyToOne
    private Eproductiva codigoeproductiva;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Seguimientop() {
    }

    public Seguimientop(Integer numeroseguimientop) {
        this.numeroseguimientop = numeroseguimientop;
    }

    public Integer getNumeroseguimientop() {
        return numeroseguimientop;
    }

    public void setNumeroseguimientop(Integer numeroseguimientop) {
        this.numeroseguimientop = numeroseguimientop;
    }

    public Date getFechaseguimientoa() {
        return fechaseguimientoa;
    }

    public void setFechaseguimientoa(Date fechaseguimientoa) {
        this.fechaseguimientoa = fechaseguimientoa;
    }

    public Date getFechaseguimientoi() {
        return fechaseguimientoi;
    }

    public void setFechaseguimientoi(Date fechaseguimientoi) {
        this.fechaseguimientoi = fechaseguimientoi;
    }

    public String getActividadesseguimiento() {
        return actividadesseguimiento;
    }

    public void setActividadesseguimiento(String actividadesseguimiento) {
        this.actividadesseguimiento = actividadesseguimiento;
    }

    public String getBalanceseguimiento() {
        return balanceseguimiento;
    }

    public void setBalanceseguimiento(String balanceseguimiento) {
        this.balanceseguimiento = balanceseguimiento;
    }

    public String getObservacionesseguimientoa() {
        return observacionesseguimientoa;
    }

    public void setObservacionesseguimientoa(String observacionesseguimientoa) {
        this.observacionesseguimientoa = observacionesseguimientoa;
    }

    public String getObservacionesseguimientoi() {
        return observacionesseguimientoi;
    }

    public void setObservacionesseguimientoi(String observacionesseguimientoi) {
        this.observacionesseguimientoi = observacionesseguimientoi;
    }

    public Date getFechainicioseguimiento() {
        return fechainicioseguimiento;
    }

    public void setFechainicioseguimiento(Date fechainicioseguimiento) {
        this.fechainicioseguimiento = fechainicioseguimiento;
    }

    public Date getFechafinseguimiento() {
        return fechafinseguimiento;
    }

    public void setFechafinseguimiento(Date fechafinseguimiento) {
        this.fechafinseguimiento = fechafinseguimiento;
    }

    public Eproductiva getCodigoeproductiva() {
        return codigoeproductiva;
    }

    public void setCodigoeproductiva(Eproductiva codigoeproductiva) {
        this.codigoeproductiva = codigoeproductiva;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroseguimientop != null ? numeroseguimientop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimientop)) {
            return false;
        }
        Seguimientop other = (Seguimientop) object;
        if ((this.numeroseguimientop == null && other.numeroseguimientop != null) || (this.numeroseguimientop != null && !this.numeroseguimientop.equals(other.numeroseguimientop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seguimientop[ numeroseguimientop=" + numeroseguimientop + " ]";
    }
    
}
