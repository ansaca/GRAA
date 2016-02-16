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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByCodigopago", query = "SELECT p FROM Pago p WHERE p.codigopago = :codigopago"),
    @NamedQuery(name = "Pago.findByNumeropago", query = "SELECT p FROM Pago p WHERE p.numeropago = :numeropago"),
    @NamedQuery(name = "Pago.findByFechainiciopago", query = "SELECT p FROM Pago p WHERE p.fechainiciopago = :fechainiciopago"),
    @NamedQuery(name = "Pago.findByFechafinpago", query = "SELECT p FROM Pago p WHERE p.fechafinpago = :fechafinpago"),
    @NamedQuery(name = "Pago.findBySaldoanteriorpago", query = "SELECT p FROM Pago p WHERE p.saldoanteriorpago = :saldoanteriorpago"),
    @NamedQuery(name = "Pago.findBySaldonuevopago", query = "SELECT p FROM Pago p WHERE p.saldonuevopago = :saldonuevopago"),
    @NamedQuery(name = "Pago.findByNumerohoraspago", query = "SELECT p FROM Pago p WHERE p.numerohoraspago = :numerohoraspago"),
    @NamedQuery(name = "Pago.findByDiasliquidarpago", query = "SELECT p FROM Pago p WHERE p.diasliquidarpago = :diasliquidarpago"),
    @NamedQuery(name = "Pago.findByNumeroplanillapago", query = "SELECT p FROM Pago p WHERE p.numeroplanillapago = :numeroplanillapago"),
    @NamedQuery(name = "Pago.findByIbcpago", query = "SELECT p FROM Pago p WHERE p.ibcpago = :ibcpago"),
    @NamedQuery(name = "Pago.findByAportessaludpago", query = "SELECT p FROM Pago p WHERE p.aportessaludpago = :aportessaludpago"),
    @NamedQuery(name = "Pago.findByAportepensionpago", query = "SELECT p FROM Pago p WHERE p.aportepensionpago = :aportepensionpago"),
    @NamedQuery(name = "Pago.findByAportesolidariopago", query = "SELECT p FROM Pago p WHERE p.aportesolidariopago = :aportesolidariopago"),
    @NamedQuery(name = "Pago.findByAportearl", query = "SELECT p FROM Pago p WHERE p.aportearl = :aportearl"),
    @NamedQuery(name = "Pago.findByAhorrovoluntariopago", query = "SELECT p FROM Pago p WHERE p.ahorrovoluntariopago = :ahorrovoluntariopago"),
    @NamedQuery(name = "Pago.findByDependientespago", query = "SELECT p FROM Pago p WHERE p.dependientespago = :dependientespago"),
    @NamedQuery(name = "Pago.findBySaludprepagadapago", query = "SELECT p FROM Pago p WHERE p.saludprepagadapago = :saludprepagadapago"),
    @NamedQuery(name = "Pago.findByInteresviviendapago", query = "SELECT p FROM Pago p WHERE p.interesviviendapago = :interesviviendapago")})
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigopago")
    private Integer codigopago;
    @Column(name = "numeropago")
    private Integer numeropago;
    @Column(name = "fechainiciopago")
    @Temporal(TemporalType.DATE)
    private Date fechainiciopago;
    @Column(name = "fechafinpago")
    @Temporal(TemporalType.DATE)
    private Date fechafinpago;
    @Column(name = "saldoanteriorpago")
    private Integer saldoanteriorpago;
    @Column(name = "saldonuevopago")
    private Integer saldonuevopago;
    @Column(name = "numerohoraspago")
    private Integer numerohoraspago;
    @Column(name = "diasliquidarpago")
    private Integer diasliquidarpago;
    @Column(name = "numeroplanillapago")
    private Integer numeroplanillapago;
    @Column(name = "ibcpago")
    private Integer ibcpago;
    @Column(name = "aportessaludpago")
    private Integer aportessaludpago;
    @Column(name = "aportepensionpago")
    private Integer aportepensionpago;
    @Column(name = "aportesolidariopago")
    private Integer aportesolidariopago;
    @Column(name = "aportearl")
    private Integer aportearl;
    @Column(name = "ahorrovoluntariopago")
    private Integer ahorrovoluntariopago;
    @Column(name = "dependientespago")
    private Integer dependientespago;
    @Column(name = "saludprepagadapago")
    private Integer saludprepagadapago;
    @Column(name = "interesviviendapago")
    private Integer interesviviendapago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pago")
    private List<Accionescontrato> accionescontratoList;
    @JoinColumn(name = "numerocontratopago", referencedColumnName = "numerocontrato")
    @ManyToOne
    private Contrato numerocontratopago;
    @OneToMany(mappedBy = "codigopago")
    private List<Viaticos> viaticosList;

    public Pago() {
    }

    public Pago(Integer codigopago) {
        this.codigopago = codigopago;
    }

    public Integer getCodigopago() {
        return codigopago;
    }

    public void setCodigopago(Integer codigopago) {
        this.codigopago = codigopago;
    }

    public Integer getNumeropago() {
        return numeropago;
    }

    public void setNumeropago(Integer numeropago) {
        this.numeropago = numeropago;
    }

    public Date getFechainiciopago() {
        return fechainiciopago;
    }

    public void setFechainiciopago(Date fechainiciopago) {
        this.fechainiciopago = fechainiciopago;
    }

    public Date getFechafinpago() {
        return fechafinpago;
    }

    public void setFechafinpago(Date fechafinpago) {
        this.fechafinpago = fechafinpago;
    }

    public Integer getSaldoanteriorpago() {
        return saldoanteriorpago;
    }

    public void setSaldoanteriorpago(Integer saldoanteriorpago) {
        this.saldoanteriorpago = saldoanteriorpago;
    }

    public Integer getSaldonuevopago() {
        return saldonuevopago;
    }

    public void setSaldonuevopago(Integer saldonuevopago) {
        this.saldonuevopago = saldonuevopago;
    }

    public Integer getNumerohoraspago() {
        return numerohoraspago;
    }

    public void setNumerohoraspago(Integer numerohoraspago) {
        this.numerohoraspago = numerohoraspago;
    }

    public Integer getDiasliquidarpago() {
        return diasliquidarpago;
    }

    public void setDiasliquidarpago(Integer diasliquidarpago) {
        this.diasliquidarpago = diasliquidarpago;
    }

    public Integer getNumeroplanillapago() {
        return numeroplanillapago;
    }

    public void setNumeroplanillapago(Integer numeroplanillapago) {
        this.numeroplanillapago = numeroplanillapago;
    }

    public Integer getIbcpago() {
        return ibcpago;
    }

    public void setIbcpago(Integer ibcpago) {
        this.ibcpago = ibcpago;
    }

    public Integer getAportessaludpago() {
        return aportessaludpago;
    }

    public void setAportessaludpago(Integer aportessaludpago) {
        this.aportessaludpago = aportessaludpago;
    }

    public Integer getAportepensionpago() {
        return aportepensionpago;
    }

    public void setAportepensionpago(Integer aportepensionpago) {
        this.aportepensionpago = aportepensionpago;
    }

    public Integer getAportesolidariopago() {
        return aportesolidariopago;
    }

    public void setAportesolidariopago(Integer aportesolidariopago) {
        this.aportesolidariopago = aportesolidariopago;
    }

    public Integer getAportearl() {
        return aportearl;
    }

    public void setAportearl(Integer aportearl) {
        this.aportearl = aportearl;
    }

    public Integer getAhorrovoluntariopago() {
        return ahorrovoluntariopago;
    }

    public void setAhorrovoluntariopago(Integer ahorrovoluntariopago) {
        this.ahorrovoluntariopago = ahorrovoluntariopago;
    }

    public Integer getDependientespago() {
        return dependientespago;
    }

    public void setDependientespago(Integer dependientespago) {
        this.dependientespago = dependientespago;
    }

    public Integer getSaludprepagadapago() {
        return saludprepagadapago;
    }

    public void setSaludprepagadapago(Integer saludprepagadapago) {
        this.saludprepagadapago = saludprepagadapago;
    }

    public Integer getInteresviviendapago() {
        return interesviviendapago;
    }

    public void setInteresviviendapago(Integer interesviviendapago) {
        this.interesviviendapago = interesviviendapago;
    }

    @XmlTransient
    public List<Accionescontrato> getAccionescontratoList() {
        return accionescontratoList;
    }

    public void setAccionescontratoList(List<Accionescontrato> accionescontratoList) {
        this.accionescontratoList = accionescontratoList;
    }

    public Contrato getNumerocontratopago() {
        return numerocontratopago;
    }

    public void setNumerocontratopago(Contrato numerocontratopago) {
        this.numerocontratopago = numerocontratopago;
    }

    @XmlTransient
    public List<Viaticos> getViaticosList() {
        return viaticosList;
    }

    public void setViaticosList(List<Viaticos> viaticosList) {
        this.viaticosList = viaticosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopago != null ? codigopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.codigopago == null && other.codigopago != null) || (this.codigopago != null && !this.codigopago.equals(other.codigopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pago[ codigopago=" + codigopago + " ]";
    }
    
}
