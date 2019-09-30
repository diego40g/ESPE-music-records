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
    , @NamedQuery(name = "Cancion.findByCodigoMusico", query = "SELECT c FROM Cancion c WHERE c.songPK.codigoMusico = :codigoMusico")
    , @NamedQuery(name = "Cancion.findByCodigoBanda", query = "SELECT c FROM Cancion c WHERE c.songPK.codigoBanda = :codigoBanda")
    , @NamedQuery(name = "Cancion.findByCodigoCancion", query = "SELECT c FROM Cancion c WHERE c.songPK.codigoCancion = :codigoCancion")
    , @NamedQuery(name = "Cancion.findByNombreCancion", query = "SELECT c FROM Cancion c WHERE c.nameSong = :nameSong")
    , @NamedQuery(name = "Cancion.findByDuracion", query = "SELECT c FROM Cancion c WHERE c.duration = :duration")
    , @NamedQuery(name = "Cancion.findByGeneroCancion", query = "SELECT c FROM Cancion c WHERE c.genderSong = :genderSong")})
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SongPK songPK;
    @Basic(optional = false)
    @Column(name = "NAME_SONG")
    private String nameSong;
    @Basic(optional = false)
    @Column(name = "DURATION")
    @Temporal(TemporalType.TIME)
    private Date duration;
    @Basic(optional = false)
    @Column(name = "GENDER_SONG")
    private String genderSong;
    @ManyToMany(mappedBy = "cancionCollection")
    private Collection<Album> albumCollection;
    @JoinColumns({
        @JoinColumn(name = "CODE_MUSICAL", referencedColumnName = "CODE_MUSICAL", insertable = false, updatable = false)
        , @JoinColumn(name = "CODE_BAND", referencedColumnName = "CODE_BAND", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Band banda;

    public Song() {
    }

    public Song(SongPK songPK) {
        this.songPK = songPK;
    }

    public Song(SongPK songPK, String nameSong, Date duration, String genderSong) {
        this.songPK = songPK;
        this.nameSong = nameSong;
        this.duration = duration;
        this.genderSong = genderSong;
    }

    public Song(String codigoMusico, String codigoBanda, String codigoCancion) {
        this.songPK = new SongPK(codigoMusico, codigoBanda, codigoCancion);
    }

    public SongPK getSongPK() {
        return songPK;
    }

    public void setSongPK(SongPK songPK) {
        this.songPK = songPK;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getGenderSong() {
        return genderSong;
    }

    public void setGenderSong(String genderSong) {
        this.genderSong = genderSong;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    public Band getBand() {
        return banda;
    }

    public void setBand(Band banda) {
        this.banda = banda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songPK != null ? songPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songPK == null && other.songPK != null) || (this.songPK != null && !this.songPK.equals(other.songPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Cancion[ songPK=" + songPK + " ]";
    }
    
}
