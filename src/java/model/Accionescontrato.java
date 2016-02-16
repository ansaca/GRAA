/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "accionescontrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accionescontrato.findAll", query = "SELECT a FROM Accionescontrato a"),
    @NamedQuery(name = "Accionescontrato.findByNumerocontratoacciones", query = "SELECT a FROM Accionescontrato a WHERE a.accionescontratoPK.numerocontratoacciones = :numerocontratoacciones"),
    @NamedQuery(name = "Accionescontrato.findByCodigoclausulaacciones", query = "SELECT a FROM Accionescontrato a WHERE a.accionescontratoPK.codigoclausulaacciones = :codigoclausulaacciones"),
    @NamedQuery(name = "Accionescontrato.findByCodigopagoacciones", query = "SELECT a FROM Accionescontrato a WHERE a.accionescontratoPK.codigopagoacciones = :codigopagoacciones")})
public class Accionescontrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccionescontratoPK accionescontratoPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionacciones")
    private String descripcionacciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "evidenciasacciones")
    private String evidenciasacciones;
    @JoinColumn(name = "codigoclausulaacciones", referencedColumnName = "codigoclausula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clausula clausula;
    @JoinColumn(name = "numerocontratoacciones", referencedColumnName = "numerocontrato", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contrato contrato;
    @JoinColumn(name = "codigopagoacciones", referencedColumnName = "codigopago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pago pago;

    public Accionescontrato() {
    }

    public Accionescontrato(AccionescontratoPK accionescontratoPK) {
        this.accionescontratoPK = accionescontratoPK;
    }

    public Accionescontrato(int numerocontratoacciones, int codigoclausulaacciones, int codigopagoacciones) {
        this.accionescontratoPK = new AccionescontratoPK(numerocontratoacciones, codigoclausulaacciones, codigopagoacciones);
    }

    public AccionescontratoPK getAccionescontratoPK() {
        return accionescontratoPK;
    }

    public void setAccionescontratoPK(AccionescontratoPK accionescontratoPK) {
        this.accionescontratoPK = accionescontratoPK;
    }

    public String getDescripcionacciones() {
        return descripcionacciones;
    }

    public void setDescripcionacciones(String descripcionacciones) {
        this.descripcionacciones = descripcionacciones;
    }

    public String getEvidenciasacciones() {
        return evidenciasacciones;
    }

    public void setEvidenciasacciones(String evidenciasacciones) {
        this.evidenciasacciones = evidenciasacciones;
    }

    public Clausula getClausula() {
        return clausula;
    }

    public void setClausula(Clausula clausula) {
        this.clausula = clausula;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accionescontratoPK != null ? accionescontratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionescontrato)) {
            return false;
        }
        Accionescontrato other = (Accionescontrato) object;
        if ((this.accionescontratoPK == null && other.accionescontratoPK != null) || (this.accionescontratoPK != null && !this.accionescontratoPK.equals(other.accionescontratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Accionescontrato[ accionescontratoPK=" + accionescontratoPK + " ]";
    }
    
}
