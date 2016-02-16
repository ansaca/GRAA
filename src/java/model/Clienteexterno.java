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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "clienteexterno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteexterno.findAll", query = "SELECT c FROM Clienteexterno c"),
    @NamedQuery(name = "Clienteexterno.findByDocumentocliente", query = "SELECT c FROM Clienteexterno c WHERE c.documentocliente = :documentocliente")})
public class Clienteexterno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentocliente")
    private Long documentocliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentocliente")
    private List<Turno> turnoList;
    @JoinColumn(name = "documentocliente", referencedColumnName = "documentopersonal", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personal personal;

    public Clienteexterno() {
    }

    public Clienteexterno(Long documentocliente) {
        this.documentocliente = documentocliente;
    }

    public Long getDocumentocliente() {
        return documentocliente;
    }

    public void setDocumentocliente(Long documentocliente) {
        this.documentocliente = documentocliente;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentocliente != null ? documentocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteexterno)) {
            return false;
        }
        Clienteexterno other = (Clienteexterno) object;
        if ((this.documentocliente == null && other.documentocliente != null) || (this.documentocliente != null && !this.documentocliente.equals(other.documentocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Clienteexterno[ documentocliente=" + documentocliente + " ]";
    }
    
}
