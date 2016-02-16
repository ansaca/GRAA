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
public class LideresfichaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoinstructor")
    private long documentoinstructor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fichatitulacion")
    private int fichatitulacion;

    public LideresfichaPK() {
    }

    public LideresfichaPK(long documentoinstructor, int fichatitulacion) {
        this.documentoinstructor = documentoinstructor;
        this.fichatitulacion = fichatitulacion;
    }

    public long getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(long documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    public int getFichatitulacion() {
        return fichatitulacion;
    }

    public void setFichatitulacion(int fichatitulacion) {
        this.fichatitulacion = fichatitulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentoinstructor;
        hash += (int) fichatitulacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LideresfichaPK)) {
            return false;
        }
        LideresfichaPK other = (LideresfichaPK) object;
        if (this.documentoinstructor != other.documentoinstructor) {
            return false;
        }
        if (this.fichatitulacion != other.fichatitulacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LideresfichaPK[ documentoinstructor=" + documentoinstructor + ", fichatitulacion=" + fichatitulacion + " ]";
    }
    
}
