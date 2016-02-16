/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author andres
 */
@Embeddable
public class ValoracionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoevaluaciondesempeno")
    private int codigoevaluaciondesempeno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigocriterio")
    private int codigocriterio;

    public ValoracionPK() {
    }

    public ValoracionPK(int codigoevaluaciondesempeno, int codigocriterio) {
        this.codigoevaluaciondesempeno = codigoevaluaciondesempeno;
        this.codigocriterio = codigocriterio;
    }

    public int getCodigoevaluaciondesempeno() {
        return codigoevaluaciondesempeno;
    }

    public void setCodigoevaluaciondesempeno(int codigoevaluaciondesempeno) {
        this.codigoevaluaciondesempeno = codigoevaluaciondesempeno;
    }

    public int getCodigocriterio() {
        return codigocriterio;
    }

    public void setCodigocriterio(int codigocriterio) {
        this.codigocriterio = codigocriterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoevaluaciondesempeno;
        hash += (int) codigocriterio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionPK)) {
            return false;
        }
        ValoracionPK other = (ValoracionPK) object;
        if (this.codigoevaluaciondesempeno != other.codigoevaluaciondesempeno) {
            return false;
        }
        if (this.codigocriterio != other.codigocriterio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ValoracionPK[ codigoevaluaciondesempeno=" + codigoevaluaciondesempeno + ", codigocriterio=" + codigocriterio + " ]";
    }
    
}
