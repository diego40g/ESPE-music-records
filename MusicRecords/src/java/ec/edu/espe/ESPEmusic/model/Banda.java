/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "banda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banda.findAll", query = "SELECT b FROM Banda b")
    , @NamedQuery(name = "Banda.findByCodigoMusico", query = "SELECT b FROM Banda b WHERE b.bandaPK.codigoMusico = :codigoMusico")
    , @NamedQuery(name = "Banda.findByCodigoBanda", query = "SELECT b FROM Banda b WHERE b.bandaPK.codigoBanda = :codigoBanda")
    , @NamedQuery(name = "Banda.findByNombreBanda", query = "SELECT b FROM Banda b WHERE b.nombreBanda = :nombreBanda")
    , @NamedQuery(name = "Banda.findByNumeroIntegrantes", query = "SELECT b FROM Banda b WHERE b.numeroIntegrantes = :numeroIntegrantes")
    , @NamedQuery(name = "Banda.findByGeneroBanda", query = "SELECT b FROM Banda b WHERE b.generoBanda = :generoBanda")})
public class Banda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BandaPK bandaPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE_BANDA")
    private String nombreBanda;
    @Column(name = "NUMERO_INTEGRANTES")
    private Integer numeroIntegrantes;
    @Basic(optional = false)
    @Column(name = "GENERO_BANDA")
    private String generoBanda;
    @OneToMany(mappedBy = "banda")
    private Collection<Manager> managerCollection;
    @JoinColumn(name = "CODIGO_MUSICO", referencedColumnName = "CODIGO_MUSICO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MiembrosBanda miembrosBanda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banda")
    private Collection<Cancion> cancionCollection;

    public Banda() {
    }

    public Banda(BandaPK bandaPK) {
        this.bandaPK = bandaPK;
    }

    public Banda(BandaPK bandaPK, String nombreBanda, String generoBanda) {
        this.bandaPK = bandaPK;
        this.nombreBanda = nombreBanda;
        this.generoBanda = generoBanda;
    }

    public Banda(String codigoMusico, String codigoBanda) {
        this.bandaPK = new BandaPK(codigoMusico, codigoBanda);
    }

    public BandaPK getBandaPK() {
        return bandaPK;
    }

    public void setBandaPK(BandaPK bandaPK) {
        this.bandaPK = bandaPK;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public Integer getNumeroIntegrantes() {
        return numeroIntegrantes;
    }

    public void setNumeroIntegrantes(Integer numeroIntegrantes) {
        this.numeroIntegrantes = numeroIntegrantes;
    }

    public String getGeneroBanda() {
        return generoBanda;
    }

    public void setGeneroBanda(String generoBanda) {
        this.generoBanda = generoBanda;
    }

    @XmlTransient
    public Collection<Manager> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(Collection<Manager> managerCollection) {
        this.managerCollection = managerCollection;
    }

    public MiembrosBanda getMiembrosBanda() {
        return miembrosBanda;
    }

    public void setMiembrosBanda(MiembrosBanda miembrosBanda) {
        this.miembrosBanda = miembrosBanda;
    }

    @XmlTransient
    public Collection<Cancion> getCancionCollection() {
        return cancionCollection;
    }

    public void setCancionCollection(Collection<Cancion> cancionCollection) {
        this.cancionCollection = cancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandaPK != null ? bandaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banda)) {
            return false;
        }
        Banda other = (Banda) object;
        if ((this.bandaPK == null && other.bandaPK != null) || (this.bandaPK != null && !this.bandaPK.equals(other.bandaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Banda[ bandaPK=" + bandaPK + " ]";
    }
    
}
