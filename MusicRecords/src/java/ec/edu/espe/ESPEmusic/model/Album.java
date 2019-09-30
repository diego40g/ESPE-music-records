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
    , @NamedQuery(name = "Album.findByCodigoAlbum", query = "SELECT a FROM Album a WHERE a.codigoAlbum = :codigoAlbum")
    , @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nombreAlbum = :nombreAlbum")
    , @NamedQuery(name = "Album.findByGeneroAlbum", query = "SELECT a FROM Album a WHERE a.generoAlbum = :generoAlbum")
    , @NamedQuery(name = "Album.findByNumeroCanciones", query = "SELECT a FROM Album a WHERE a.numeroCanciones = :numeroCanciones")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ALBUM")
    private String codigoAlbum;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ALBUM")
    private String nombreAlbum;
    @Basic(optional = false)
    @Column(name = "GENERO_ALBUM")
    private String generoAlbum;
    @Basic(optional = false)
    @Column(name = "NUMERO_CANCIONES")
    private String numeroCanciones;
    @JoinTable(name = "crea", joinColumns = {
        @JoinColumn(name = "CODIGO_ALBUM", referencedColumnName = "CODIGO_ALBUM")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGO_MUSICO", referencedColumnName = "CODIGO_MUSICO")
        , @JoinColumn(name = "CODIGO_BANDA", referencedColumnName = "CODIGO_BANDA")
        , @JoinColumn(name = "CODIGO_CANCION", referencedColumnName = "CODIGO_CANCION")})
    @ManyToMany
    private Collection<Song> cancionCollection;

    public Album() {
    }

    public Album(String codigoAlbum) {
        this.codigoAlbum = codigoAlbum;
    }

    public Album(String codigoAlbum, String nombreAlbum, String generoAlbum, String numeroCanciones) {
        this.codigoAlbum = codigoAlbum;
        this.nombreAlbum = nombreAlbum;
        this.generoAlbum = generoAlbum;
        this.numeroCanciones = numeroCanciones;
    }

    public String getCodigoAlbum() {
        return codigoAlbum;
    }

    public void setCodigoAlbum(String codigoAlbum) {
        this.codigoAlbum = codigoAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getGeneroAlbum() {
        return generoAlbum;
    }

    public void setGeneroAlbum(String generoAlbum) {
        this.generoAlbum = generoAlbum;
    }

    public String getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(String numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
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
        hash += (codigoAlbum != null ? codigoAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.codigoAlbum == null && other.codigoAlbum != null) || (this.codigoAlbum != null && !this.codigoAlbum.equals(other.codigoAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Album[ codigoAlbum=" + codigoAlbum + " ]";
    }
    
}
