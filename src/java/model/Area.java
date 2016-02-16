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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByCodigoarea", query = "SELECT a FROM Area a WHERE a.codigoarea = :codigoarea"),
    @NamedQuery(name = "Area.findByNombrearea", query = "SELECT a FROM Area a WHERE a.nombrearea = :nombrearea")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoarea")
    private Integer codigoarea;
    @Size(max = 50)
    @Column(name = "nombrearea")
    private String nombrearea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoarea")
    private List<Turno> turnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoarea")
    private List<Funcionario> funcionarioList;
    @JoinColumn(name = "codigodependencia", referencedColumnName = "codigodependencia")
    @ManyToOne
    private Dependencia codigodependencia;

    public Area() {
    }

    public Area(Integer codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Integer getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Integer codigoarea) {
        this.codigoarea = codigoarea;
    }

    public String getNombrearea() {
        return nombrearea;
    }

    public void setNombrearea(String nombrearea) {
        this.nombrearea = nombrearea;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public Dependencia getCodigodependencia() {
        return codigodependencia;
    }

    public void setCodigodependencia(Dependencia codigodependencia) {
        this.codigodependencia = codigodependencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoarea != null ? codigoarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codigoarea == null && other.codigoarea != null) || (this.codigoarea != null && !this.codigoarea.equals(other.codigoarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Area[ codigoarea=" + codigoarea + " ]";
    }
    
}
