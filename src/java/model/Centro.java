/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Centro.findAll", query = "SELECT c FROM Centro c"),
    @NamedQuery(name = "Centro.findByCodigocentro", query = "SELECT c FROM Centro c WHERE c.codigocentro = :codigocentro"),
    @NamedQuery(name = "Centro.findByNombrecentro", query = "SELECT c FROM Centro c WHERE c.nombrecentro = :nombrecentro"),
    @NamedQuery(name = "Centro.findByDireccioncentro", query = "SELECT c FROM Centro c WHERE c.direccioncentro = :direccioncentro"),
    @NamedQuery(name = "Centro.findByCiudadcentro", query = "SELECT c FROM Centro c WHERE c.ciudadcentro = :ciudadcentro")})
public class Centro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocentro")
    private Integer codigocentro;
    @Size(max = 50)
    @Column(name = "nombrecentro")
    private String nombrecentro;
    @Size(max = 50)
    @Column(name = "direccioncentro")
    private String direccioncentro;
    @Size(max = 50)
    @Column(name = "ciudadcentro")
    private String ciudadcentro;
    @JoinColumn(name = "documentofuncionariocentro", referencedColumnName = "documentofuncionario")
    @ManyToOne
    private Funcionario documentofuncionariocentro;
    @JoinColumn(name = "codigoregionalcentro", referencedColumnName = "codigoregional")
    @ManyToOne
    private Regional codigoregionalcentro;
    @OneToMany(mappedBy = "codigocentrolinea")
    private List<Lineacentro> lineacentroList;

    public Centro() {
    }

    public Centro(Integer codigocentro) {
        this.codigocentro = codigocentro;
    }

    public Integer getCodigocentro() {
        return codigocentro;
    }

    public void setCodigocentro(Integer codigocentro) {
        this.codigocentro = codigocentro;
    }

    public String getNombrecentro() {
        return nombrecentro;
    }

    public void setNombrecentro(String nombrecentro) {
        this.nombrecentro = nombrecentro;
    }

    public String getDireccioncentro() {
        return direccioncentro;
    }

    public void setDireccioncentro(String direccioncentro) {
        this.direccioncentro = direccioncentro;
    }

    public String getCiudadcentro() {
        return ciudadcentro;
    }

    public void setCiudadcentro(String ciudadcentro) {
        this.ciudadcentro = ciudadcentro;
    }

    public Funcionario getDocumentofuncionariocentro() {
        return documentofuncionariocentro;
    }

    public void setDocumentofuncionariocentro(Funcionario documentofuncionariocentro) {
        this.documentofuncionariocentro = documentofuncionariocentro;
    }

    public Regional getCodigoregionalcentro() {
        return codigoregionalcentro;
    }

    public void setCodigoregionalcentro(Regional codigoregionalcentro) {
        this.codigoregionalcentro = codigoregionalcentro;
    }

    @XmlTransient
    public List<Lineacentro> getLineacentroList() {
        return lineacentroList;
    }

    public void setLineacentroList(List<Lineacentro> lineacentroList) {
        this.lineacentroList = lineacentroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocentro != null ? codigocentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centro)) {
            return false;
        }
        Centro other = (Centro) object;
        if ((this.codigocentro == null && other.codigocentro != null) || (this.codigocentro != null && !this.codigocentro.equals(other.codigocentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Centro[ codigocentro=" + codigocentro + " ]";
    }
    
}
