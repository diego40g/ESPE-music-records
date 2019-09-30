/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")
    , @NamedQuery(name = "Cancion.findByCodigoMusico", query = "SELECT c FROM Cancion c WHERE c.cancionPK.codigoMusico = :codigoMusico")
    , @NamedQuery(name = "Cancion.findByCodigoBanda", query = "SELECT c FROM Cancion c WHERE c.cancionPK.codigoBanda = :codigoBanda")
    , @NamedQuery(name = "Cancion.findByCodigoCancion", query = "SELECT c FROM Cancion c WHERE c.cancionPK.codigoCancion = :codigoCancion")
    , @NamedQuery(name = "Cancion.findByNombreCancion", query = "SELECT c FROM Cancion c WHERE c.nombreCancion = :nombreCancion")
    , @NamedQuery(name = "Cancion.findByDuracion", query = "SELECT c FROM Cancion c WHERE c.duracion = :duracion")
    , @NamedQuery(name = "Cancion.findByGeneroCancion", query = "SELECT c FROM Cancion c WHERE c.generoCancion = :generoCancion")})
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SongPK cancionPK;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CANCION")
    private String nombreCancion;
    @Basic(optional = false)
    @Column(name = "DURACION")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @Column(name = "GENERO_CANCION")
    private String generoCancion;
    @ManyToMany(mappedBy = "cancionCollection")
    private Collection<Album> albumCollection;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_MUSICO", referencedColumnName = "CODIGO_MUSICO", insertable = false, updatable = false)
        , @JoinColumn(name = "CODIGO_BANDA", referencedColumnName = "CODIGO_BANDA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Band banda;

    public Song() {
    }

    public Song(SongPK cancionPK) {
        this.cancionPK = cancionPK;
    }

    public Song(SongPK cancionPK, String nombreCancion, Date duracion, String generoCancion) {
        this.cancionPK = cancionPK;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
        this.generoCancion = generoCancion;
    }

    public Song(String codigoMusico, String codigoBanda, String codigoCancion) {
        this.cancionPK = new SongPK(codigoMusico, codigoBanda, codigoCancion);
    }

    public SongPK getCancionPK() {
        return cancionPK;
    }

    public void setCancionPK(SongPK cancionPK) {
        this.cancionPK = cancionPK;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getGeneroCancion() {
        return generoCancion;
    }

    public void setGeneroCancion(String generoCancion) {
        this.generoCancion = generoCancion;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    public Band getBanda() {
        return banda;
    }

    public void setBanda(Band banda) {
        this.banda = banda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancionPK != null ? cancionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.cancionPK == null && other.cancionPK != null) || (this.cancionPK != null && !this.cancionPK.equals(other.cancionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Cancion[ cancionPK=" + cancionPK + " ]";
    }
    
}
