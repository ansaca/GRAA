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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByNumerocontrato", query = "SELECT c FROM Contrato c WHERE c.numerocontrato = :numerocontrato"),
    @NamedQuery(name = "Contrato.findByFechainiciocontrato", query = "SELECT c FROM Contrato c WHERE c.fechainiciocontrato = :fechainiciocontrato"),
    @NamedQuery(name = "Contrato.findByFechafincontrato", query = "SELECT c FROM Contrato c WHERE c.fechafincontrato = :fechafincontrato"),
    @NamedQuery(name = "Contrato.findByEstadocontrato", query = "SELECT c FROM Contrato c WHERE c.estadocontrato = :estadocontrato"),
    @NamedQuery(name = "Contrato.findByValortotalcontrato", query = "SELECT c FROM Contrato c WHERE c.valortotalcontrato = :valortotalcontrato"),
    @NamedQuery(name = "Contrato.findByNumerocompromisosiifcontrato", query = "SELECT c FROM Contrato c WHERE c.numerocompromisosiifcontrato = :numerocompromisosiifcontrato"),
    @NamedQuery(name = "Contrato.findByFormapagocontrato", query = "SELECT c FROM Contrato c WHERE c.formapagocontrato = :formapagocontrato"),
    @NamedQuery(name = "Contrato.findByNumerocuentacontrato", query = "SELECT c FROM Contrato c WHERE c.numerocuentacontrato = :numerocuentacontrato"),
    @NamedQuery(name = "Contrato.findByTipocuentacontrato", query = "SELECT c FROM Contrato c WHERE c.tipocuentacontrato = :tipocuentacontrato"),
    @NamedQuery(name = "Contrato.findByClasepersonacontrato", query = "SELECT c FROM Contrato c WHERE c.clasepersonacontrato = :clasepersonacontrato"),
    @NamedQuery(name = "Contrato.findByIngresossuperiorescontrato", query = "SELECT c FROM Contrato c WHERE c.ingresossuperiorescontrato = :ingresossuperiorescontrato"),
    @NamedQuery(name = "Contrato.findByRegimenivacontrato", query = "SELECT c FROM Contrato c WHERE c.regimenivacontrato = :regimenivacontrato"),
    @NamedQuery(name = "Contrato.findByExcluidoivacontrato", query = "SELECT c FROM Contrato c WHERE c.excluidoivacontrato = :excluidoivacontrato"),
    @NamedQuery(name = "Contrato.findByDeclarantecontrato", query = "SELECT c FROM Contrato c WHERE c.declarantecontrato = :declarantecontrato"),
    @NamedQuery(name = "Contrato.findByPensionadocontrato", query = "SELECT c FROM Contrato c WHERE c.pensionadocontrato = :pensionadocontrato"),
    @NamedQuery(name = "Contrato.findByDependientescontratp", query = "SELECT c FROM Contrato c WHERE c.dependientescontratp = :dependientescontratp"),
    @NamedQuery(name = "Contrato.findByEmbargocontrato", query = "SELECT c FROM Contrato c WHERE c.embargocontrato = :embargocontrato"),
    @NamedQuery(name = "Contrato.findByValorembargocontrato", query = "SELECT c FROM Contrato c WHERE c.valorembargocontrato = :valorembargocontrato"),
    @NamedQuery(name = "Contrato.findByValormensualcontrato", query = "SELECT c FROM Contrato c WHERE c.valormensualcontrato = :valormensualcontrato"),
    @NamedQuery(name = "Contrato.findByValorhoracontrato", query = "SELECT c FROM Contrato c WHERE c.valorhoracontrato = :valorhoracontrato"),
    @NamedQuery(name = "Contrato.findByTipoarlcontrato", query = "SELECT c FROM Contrato c WHERE c.tipoarlcontrato = :tipoarlcontrato")})
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocontrato")
    private Integer numerocontrato;
    @Column(name = "fechainiciocontrato")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocontrato;
    @Column(name = "fechafincontrato")
    @Temporal(TemporalType.DATE)
    private Date fechafincontrato;
    @Lob
    @Size(max = 65535)
    @Column(name = "objetocontrato")
    private String objetocontrato;
    @Size(max = 50)
    @Column(name = "estadocontrato")
    private String estadocontrato;
    @Column(name = "valortotalcontrato")
    private BigInteger valortotalcontrato;
    @Column(name = "numerocompromisosiifcontrato")
    private Integer numerocompromisosiifcontrato;
    @Size(max = 50)
    @Column(name = "formapagocontrato")
    private String formapagocontrato;
    @Column(name = "numerocuentacontrato")
    private BigInteger numerocuentacontrato;
    @Size(max = 50)
    @Column(name = "tipocuentacontrato")
    private String tipocuentacontrato;
    @Size(max = 50)
    @Column(name = "clasepersonacontrato")
    private String clasepersonacontrato;
    @Size(max = 50)
    @Column(name = "ingresossuperiorescontrato")
    private String ingresossuperiorescontrato;
    @Size(max = 50)
    @Column(name = "regimenivacontrato")
    private String regimenivacontrato;
    @Size(max = 50)
    @Column(name = "excluidoivacontrato")
    private String excluidoivacontrato;
    @Size(max = 50)
    @Column(name = "declarantecontrato")
    private String declarantecontrato;
    @Size(max = 50)
    @Column(name = "pensionadocontrato")
    private String pensionadocontrato;
    @Size(max = 50)
    @Column(name = "dependientescontratp")
    private String dependientescontratp;
    @Size(max = 50)
    @Column(name = "embargocontrato")
    private String embargocontrato;
    @Column(name = "valorembargocontrato")
    private Integer valorembargocontrato;
    @Column(name = "valormensualcontrato")
    private BigInteger valormensualcontrato;
    @Column(name = "valorhoracontrato")
    private Integer valorhoracontrato;
    @Column(name = "tipoarlcontrato")
    private Integer tipoarlcontrato;
    @ManyToMany(mappedBy = "contratoList")
    private List<Clausula> clausulaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contrato")
    private List<Accionescontrato> accionescontratoList;
    @JoinColumn(name = "codigobancocontrato", referencedColumnName = "codigobanco")
    @ManyToOne
    private Banco codigobancocontrato;
    @JoinColumn(name = "documentocoordinadorcontrato", referencedColumnName = "documentocoordinador")
    @ManyToOne
    private Coordinador documentocoordinadorcontrato;
    @JoinColumn(name = "codigolineacontrato", referencedColumnName = "codigolinea")
    @ManyToOne
    private Lineacentro codigolineacontrato;
    @JoinColumn(name = "documentopersonalcontrato", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonalcontrato;
    @OneToMany(mappedBy = "numerocontratopago")
    private List<Pago> pagoList;

    public Contrato() {
    }

    public Contrato(Integer numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public Integer getNumerocontrato() {
        return numerocontrato;
    }

    public void setNumerocontrato(Integer numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public Date getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    public void setFechainiciocontrato(Date fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public Date getFechafincontrato() {
        return fechafincontrato;
    }

    public void setFechafincontrato(Date fechafincontrato) {
        this.fechafincontrato = fechafincontrato;
    }

    public String getObjetocontrato() {
        return objetocontrato;
    }

    public void setObjetocontrato(String objetocontrato) {
        this.objetocontrato = objetocontrato;
    }

    public String getEstadocontrato() {
        return estadocontrato;
    }

    public void setEstadocontrato(String estadocontrato) {
        this.estadocontrato = estadocontrato;
    }

    public BigInteger getValortotalcontrato() {
        return valortotalcontrato;
    }

    public void setValortotalcontrato(BigInteger valortotalcontrato) {
        this.valortotalcontrato = valortotalcontrato;
    }

    public Integer getNumerocompromisosiifcontrato() {
        return numerocompromisosiifcontrato;
    }

    public void setNumerocompromisosiifcontrato(Integer numerocompromisosiifcontrato) {
        this.numerocompromisosiifcontrato = numerocompromisosiifcontrato;
    }

    public String getFormapagocontrato() {
        return formapagocontrato;
    }

    public void setFormapagocontrato(String formapagocontrato) {
        this.formapagocontrato = formapagocontrato;
    }

    public BigInteger getNumerocuentacontrato() {
        return numerocuentacontrato;
    }

    public void setNumerocuentacontrato(BigInteger numerocuentacontrato) {
        this.numerocuentacontrato = numerocuentacontrato;
    }

    public String getTipocuentacontrato() {
        return tipocuentacontrato;
    }

    public void setTipocuentacontrato(String tipocuentacontrato) {
        this.tipocuentacontrato = tipocuentacontrato;
    }

    public String getClasepersonacontrato() {
        return clasepersonacontrato;
    }

    public void setClasepersonacontrato(String clasepersonacontrato) {
        this.clasepersonacontrato = clasepersonacontrato;
    }

    public String getIngresossuperiorescontrato() {
        return ingresossuperiorescontrato;
    }

    public void setIngresossuperiorescontrato(String ingresossuperiorescontrato) {
        this.ingresossuperiorescontrato = ingresossuperiorescontrato;
    }

    public String getRegimenivacontrato() {
        return regimenivacontrato;
    }

    public void setRegimenivacontrato(String regimenivacontrato) {
        this.regimenivacontrato = regimenivacontrato;
    }

    public String getExcluidoivacontrato() {
        return excluidoivacontrato;
    }

    public void setExcluidoivacontrato(String excluidoivacontrato) {
        this.excluidoivacontrato = excluidoivacontrato;
    }

    public String getDeclarantecontrato() {
        return declarantecontrato;
    }

    public void setDeclarantecontrato(String declarantecontrato) {
        this.declarantecontrato = declarantecontrato;
    }

    public String getPensionadocontrato() {
        return pensionadocontrato;
    }

    public void setPensionadocontrato(String pensionadocontrato) {
        this.pensionadocontrato = pensionadocontrato;
    }

    public String getDependientescontratp() {
        return dependientescontratp;
    }

    public void setDependientescontratp(String dependientescontratp) {
        this.dependientescontratp = dependientescontratp;
    }

    public String getEmbargocontrato() {
        return embargocontrato;
    }

    public void setEmbargocontrato(String embargocontrato) {
        this.embargocontrato = embargocontrato;
    }

    public Integer getValorembargocontrato() {
        return valorembargocontrato;
    }

    public void setValorembargocontrato(Integer valorembargocontrato) {
        this.valorembargocontrato = valorembargocontrato;
    }

    public BigInteger getValormensualcontrato() {
        return valormensualcontrato;
    }

    public void setValormensualcontrato(BigInteger valormensualcontrato) {
        this.valormensualcontrato = valormensualcontrato;
    }

    public Integer getValorhoracontrato() {
        return valorhoracontrato;
    }

    public void setValorhoracontrato(Integer valorhoracontrato) {
        this.valorhoracontrato = valorhoracontrato;
    }

    public Integer getTipoarlcontrato() {
        return tipoarlcontrato;
    }

    public void setTipoarlcontrato(Integer tipoarlcontrato) {
        this.tipoarlcontrato = tipoarlcontrato;
    }

    @XmlTransient
    public List<Clausula> getClausulaList() {
        return clausulaList;
    }

    public void setClausulaList(List<Clausula> clausulaList) {
        this.clausulaList = clausulaList;
    }

    @XmlTransient
    public List<Accionescontrato> getAccionescontratoList() {
        return accionescontratoList;
    }

    public void setAccionescontratoList(List<Accionescontrato> accionescontratoList) {
        this.accionescontratoList = accionescontratoList;
    }

    public Banco getCodigobancocontrato() {
        return codigobancocontrato;
    }

    public void setCodigobancocontrato(Banco codigobancocontrato) {
        this.codigobancocontrato = codigobancocontrato;
    }

    public Coordinador getDocumentocoordinadorcontrato() {
        return documentocoordinadorcontrato;
    }

    public void setDocumentocoordinadorcontrato(Coordinador documentocoordinadorcontrato) {
        this.documentocoordinadorcontrato = documentocoordinadorcontrato;
    }

    public Lineacentro getCodigolineacontrato() {
        return codigolineacontrato;
    }

    public void setCodigolineacontrato(Lineacentro codigolineacontrato) {
        this.codigolineacontrato = codigolineacontrato;
    }

    public Personal getDocumentopersonalcontrato() {
        return documentopersonalcontrato;
    }

    public void setDocumentopersonalcontrato(Personal documentopersonalcontrato) {
        this.documentopersonalcontrato = documentopersonalcontrato;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocontrato != null ? numerocontrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.numerocontrato == null && other.numerocontrato != null) || (this.numerocontrato != null && !this.numerocontrato.equals(other.numerocontrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contrato[ numerocontrato=" + numerocontrato + " ]";
    }
    
}
