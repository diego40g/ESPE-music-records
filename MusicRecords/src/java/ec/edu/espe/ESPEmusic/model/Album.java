/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
    , @NamedQuery(name = "Album.findByCodigoAlbum", query = "SELECT a FROM Album a WHERE a.codeAlbum = :codeAlbum")
    , @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nameAlbum = :nameAlbum")
    , @NamedQuery(name = "Album.findByGeneroAlbum", query = "SELECT a FROM Album a WHERE a.genderAlbum = :genderAlbum")
    , @NamedQuery(name = "Album.findByNumeroCanciones", query = "SELECT a FROM Album a WHERE a.numberSongs = :numberSongs")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_ALBUM")
    private String codeAlbum;
    @Basic(optional = false)
    @Column(name = "NAME_ALBUM")
    private String nameAlbum;
    @Basic(optional = false)
    @Column(name = "GENDER_ALBUM")
    private String genderAlbum;
    @Basic(optional = false)
    @Column(name = "NUMBER_SONGS")
    private String numberSongs;
    @JoinTable(name = "crea", joinColumns = {
        @JoinColumn(name = "CODE_ALBUM", referencedColumnName = "CODE_ALBUM")}, inverseJoinColumns = {
        @JoinColumn(name = "CODE_MUSICO", referencedColumnName = "CODE_MUSICO")
        , @JoinColumn(name = "CODE_BANDA", referencedColumnName = "CODE_BANDA")
        , @JoinColumn(name = "CODE_CANCION", referencedColumnName = "CODE_CANCION")})
    @ManyToMany
    private Collection<Song> cancionCollection;

    public Album() {
    }

    public Album(String codeAlbum) {
        this.codeAlbum = codeAlbum;
    }

    public Album(String codeAlbum, String nameAlbum, String genderAlbum, String numberSongs) {
        this.codeAlbum = codeAlbum;
        this.nameAlbum = nameAlbum;
        this.genderAlbum = genderAlbum;
        this.numberSongs = numberSongs;
    }

    public String getCodeAlbum() {
        return codeAlbum;
    }

    public void setCodeAlbum(String codeAlbum) {
        this.codeAlbum = codeAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getGenderAlbum() {
        return genderAlbum;
    }

    public void setGenderAlbum(String genderAlbum) {
        this.genderAlbum = genderAlbum;
    }

    public String getNumberSongs() {
        return numberSongs;
    }

    public void setNumberSongs(String numberSongs) {
        this.numberSongs = numberSongs;
    }

    @XmlTransient
    public Collection<Song> getCancionCollection() {
        return cancionCollection;
    }

    public void setCancionCollection(Collection<Song> cancionCollection) {
        this.cancionCollection = cancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeAlbum != null ? codeAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.codeAlbum == null && other.codeAlbum != null) || (this.codeAlbum != null && !this.codeAlbum.equals(other.codeAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Album[ codeAlbum=" + codeAlbum + " ]";
    }
    
}
