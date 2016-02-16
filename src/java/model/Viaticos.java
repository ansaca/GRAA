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
@Table(name = "viaticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaticos.findAll", query = "SELECT v FROM Viaticos v"),
    @NamedQuery(name = "Viaticos.findByCodigoviatico", query = "SELECT v FROM Viaticos v WHERE v.codigoviatico = :codigoviatico"),
    @NamedQuery(name = "Viaticos.findByLugardesplazamientoviatico", query = "SELECT v FROM Viaticos v WHERE v.lugardesplazamientoviatico = :lugardesplazamientoviatico"),
    @NamedQuery(name = "Viaticos.findByFechainicioviatico", query = "SELECT v FROM Viaticos v WHERE v.fechainicioviatico = :fechainicioviatico"),
    @NamedQuery(name = "Viaticos.findByFechafinviatico", query = "SELECT v FROM Viaticos v WHERE v.fechafinviatico = :fechafinviatico")})
public class Viaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoviatico")
    private Integer codigoviatico;
    @Size(max = 50)
    @Column(name = "lugardesplazamientoviatico")
    private String lugardesplazamientoviatico;
    @Column(name = "fechainicioviatico")
    @Temporal(TemporalType.DATE)
    private Date fechainicioviatico;
    @Column(name = "fechafinviatico")
    @Temporal(TemporalType.DATE)
    private Date fechafinviatico;
    @Lob
    @Size(max = 65535)
    @Column(name = "propositoviatico")
    private String propositoviatico;
    @Lob
    @Size(max = 65535)
    @Column(name = "actividadesviatico")
    private String actividadesviatico;
    @JoinColumn(name = "codigopago", referencedColumnName = "codigopago")
    @ManyToOne
    private Pago codigopago;

    public Viaticos() {
    }

    public Viaticos(Integer codigoviatico) {
        this.codigoviatico = codigoviatico;
    }

    public Integer getCodigoviatico() {
        return codigoviatico;
    }

    public void setCodigoviatico(Integer codigoviatico) {
        this.codigoviatico = codigoviatico;
    }

    public String getLugardesplazamientoviatico() {
        return lugardesplazamientoviatico;
    }

    public void setLugardesplazamientoviatico(String lugardesplazamientoviatico) {
        this.lugardesplazamientoviatico = lugardesplazamientoviatico;
    }

    public Date getFechainicioviatico() {
        return fechainicioviatico;
    }

    public void setFechainicioviatico(Date fechainicioviatico) {
        this.fechainicioviatico = fechainicioviatico;
    }

    public Date getFechafinviatico() {
        return fechafinviatico;
    }

    public void setFechafinviatico(Date fechafinviatico) {
        this.fechafinviatico = fechafinviatico;
    }

    public String getPropositoviatico() {
        return propositoviatico;
    }

    public void setPropositoviatico(String propositoviatico) {
        this.propositoviatico = propositoviatico;
    }

    public String getActividadesviatico() {
        return actividadesviatico;
    }

    public void setActividadesviatico(String actividadesviatico) {
        this.actividadesviatico = actividadesviatico;
    }

    public Pago getCodigopago() {
        return codigopago;
    }

    public void setCodigopago(Pago codigopago) {
        this.codigopago = codigopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoviatico != null ? codigoviatico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaticos)) {
            return false;
        }
        Viaticos other = (Viaticos) object;
        if ((this.codigoviatico == null && other.codigoviatico != null) || (this.codigoviatico != null && !this.codigoviatico.equals(other.codigoviatico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Viaticos[ codigoviatico=" + codigoviatico + " ]";
    }
    
}
