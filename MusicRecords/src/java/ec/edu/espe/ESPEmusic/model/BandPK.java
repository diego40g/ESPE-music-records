/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pc
 */
@Embeddable
public class BandPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_MUSICO")
    private String codigoMusico;
    @Basic(optional = false)
    @Column(name = "CODIGO_BANDA")
    private String codigoBanda;

    public BandPK() {
    }

    public BandPK(String codigoMusico, String codigoBanda) {
        this.codigoMusico = codigoMusico;
        this.codigoBanda = codigoBanda;
    }

    public String getCodigoMusico() {
        return codigoMusico;
    }

    public void setCodigoMusico(String codigoMusico) {
        this.codigoMusico = codigoMusico;
    }

    public String getCodigoBanda() {
        return codigoBanda;
    }

    public void setCodigoBanda(String codigoBanda) {
        this.codigoBanda = codigoBanda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMusico != null ? codigoMusico.hashCode() : 0);
        hash += (codigoBanda != null ? codigoBanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BandPK)) {
            return false;
        }
        BandPK other = (BandPK) object;
        if ((this.codigoMusico == null && other.codigoMusico != null) || (this.codigoMusico != null && !this.codigoMusico.equals(other.codigoMusico))) {
            return false;
        }
        if ((this.codigoBanda == null && other.codigoBanda != null) || (this.codigoBanda != null && !this.codigoBanda.equals(other.codigoBanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.BandaPK[ codigoMusico=" + codigoMusico + ", codigoBanda=" + codigoBanda + " ]";
    }
    
}
