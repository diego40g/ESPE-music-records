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
public class SongPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODIGO_MUSICO")
    private String codigoMusico;
    @Basic(optional = false)
    @Column(name = "CODIGO_BANDA")
    private String codigoBanda;
    @Basic(optional = false)
    @Column(name = "CODIGO_CANCION")
    private String codigoCancion;

    public SongPK() {
    }

    public SongPK(String codigoMusico, String codigoBanda, String codigoCancion) {
        this.codigoMusico = codigoMusico;
        this.codigoBanda = codigoBanda;
        this.codigoCancion = codigoCancion;
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

    public String getCodigoCancion() {
        return codigoCancion;
    }

    public void setCodigoCancion(String codigoCancion) {
        this.codigoCancion = codigoCancion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMusico != null ? codigoMusico.hashCode() : 0);
        hash += (codigoBanda != null ? codigoBanda.hashCode() : 0);
        hash += (codigoCancion != null ? codigoCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SongPK)) {
            return false;
        }
        SongPK other = (SongPK) object;
        if ((this.codigoMusico == null && other.codigoMusico != null) || (this.codigoMusico != null && !this.codigoMusico.equals(other.codigoMusico))) {
            return false;
        }
        if ((this.codigoBanda == null && other.codigoBanda != null) || (this.codigoBanda != null && !this.codigoBanda.equals(other.codigoBanda))) {
            return false;
        }
        if ((this.codigoCancion == null && other.codigoCancion != null) || (this.codigoCancion != null && !this.codigoCancion.equals(other.codigoCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.CancionPK[ codigoMusico=" + codigoMusico + ", codigoBanda=" + codigoBanda + ", codigoCancion=" + codigoCancion + " ]";
    }
    
}
