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
public class AccionescontratoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocontratoacciones")
    private int numerocontratoacciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoclausulaacciones")
    private int codigoclausulaacciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigopagoacciones")
    private int codigopagoacciones;

    public AccionescontratoPK() {
    }

    public AccionescontratoPK(int numerocontratoacciones, int codigoclausulaacciones, int codigopagoacciones) {
        this.numerocontratoacciones = numerocontratoacciones;
        this.codigoclausulaacciones = codigoclausulaacciones;
        this.codigopagoacciones = codigopagoacciones;
    }

    public int getNumerocontratoacciones() {
        return numerocontratoacciones;
    }

    public void setNumerocontratoacciones(int numerocontratoacciones) {
        this.numerocontratoacciones = numerocontratoacciones;
    }

    public int getCodigoclausulaacciones() {
        return codigoclausulaacciones;
    }

    public void setCodigoclausulaacciones(int codigoclausulaacciones) {
        this.codigoclausulaacciones = codigoclausulaacciones;
    }

    public int getCodigopagoacciones() {
        return codigopagoacciones;
    }

    public void setCodigopagoacciones(int codigopagoacciones) {
        this.codigopagoacciones = codigopagoacciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numerocontratoacciones;
        hash += (int) codigoclausulaacciones;
        hash += (int) codigopagoacciones;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionescontratoPK)) {
            return false;
        }
        AccionescontratoPK other = (AccionescontratoPK) object;
        if (this.numerocontratoacciones != other.numerocontratoacciones) {
            return false;
        }
        if (this.codigoclausulaacciones != other.codigoclausulaacciones) {
            return false;
        }
        if (this.codigopagoacciones != other.codigopagoacciones) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AccionescontratoPK[ numerocontratoacciones=" + numerocontratoacciones + ", codigoclausulaacciones=" + codigoclausulaacciones + ", codigopagoacciones=" + codigopagoacciones + " ]";
    }
    
}
