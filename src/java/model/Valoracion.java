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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v"),
    @NamedQuery(name = "Valoracion.findByCodigoevaluaciondesempeno", query = "SELECT v FROM Valoracion v WHERE v.valoracionPK.codigoevaluaciondesempeno = :codigoevaluaciondesempeno"),
    @NamedQuery(name = "Valoracion.findByCodigocriterio", query = "SELECT v FROM Valoracion v WHERE v.valoracionPK.codigocriterio = :codigocriterio"),
    @NamedQuery(name = "Valoracion.findByPuntajevaloracion", query = "SELECT v FROM Valoracion v WHERE v.puntajevaloracion = :puntajevaloracion")})
public class Valoracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValoracionPK valoracionPK;
    @Column(name = "puntajevaloracion")
    private Integer puntajevaloracion;
    @JoinColumn(name = "codigocriterio", referencedColumnName = "codigocriterio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criterio criterio;
    @JoinColumn(name = "codigoevaluaciondesempeno", referencedColumnName = "codigoevaluaciondesempeno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evaluaciondesempeno evaluaciondesempeno;

    public Valoracion() {
    }

    public Valoracion(ValoracionPK valoracionPK) {
        this.valoracionPK = valoracionPK;
    }

    public Valoracion(int codigoevaluaciondesempeno, int codigocriterio) {
        this.valoracionPK = new ValoracionPK(codigoevaluaciondesempeno, codigocriterio);
    }

    public ValoracionPK getValoracionPK() {
        return valoracionPK;
    }

    public void setValoracionPK(ValoracionPK valoracionPK) {
        this.valoracionPK = valoracionPK;
    }

    public Integer getPuntajevaloracion() {
        return puntajevaloracion;
    }

    public void setPuntajevaloracion(Integer puntajevaloracion) {
        this.puntajevaloracion = puntajevaloracion;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public Evaluaciondesempeno getEvaluaciondesempeno() {
        return evaluaciondesempeno;
    }

    public void setEvaluaciondesempeno(Evaluaciondesempeno evaluaciondesempeno) {
        this.evaluaciondesempeno = evaluaciondesempeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valoracionPK != null ? valoracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.valoracionPK == null && other.valoracionPK != null) || (this.valoracionPK != null && !this.valoracionPK.equals(other.valoracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Valoracion[ valoracionPK=" + valoracionPK + " ]";
    }
    
}
