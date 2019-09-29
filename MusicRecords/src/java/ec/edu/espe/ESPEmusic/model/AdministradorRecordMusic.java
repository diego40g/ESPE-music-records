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
@Table(name = "administrador_record_music")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministradorRecordMusic.findAll", query = "SELECT a FROM AdministradorRecordMusic a")
    , @NamedQuery(name = "AdministradorRecordMusic.findByCodigoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.codigoAdmin = :codigoAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByApellidoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.apellidoAdmin = :apellidoAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByNombreAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.nombreAdmin = :nombreAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByEmailAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.emailAdmin = :emailAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByTelefonoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.telefonoAdmin = :telefonoAdmin")})
public class AdministradorRecordMusic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ADMIN")
    private String codigoAdmin;
    @Basic(optional = false)
    @Column(name = "APELLIDO_ADMIN")
    private String apellidoAdmin;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ADMIN")
    private String nombreAdmin;
    @Basic(optional = false)
    @Column(name = "EMAIL_ADMIN")
    private String emailAdmin;
    @Basic(optional = false)
    @Column(name = "TELEFONO_ADMIN")
    private String telefonoAdmin;
    @OneToMany(mappedBy = "codigoAdmin")
    private Collection<Manager> managerCollection;

    public AdministradorRecordMusic() {
    }

    public AdministradorRecordMusic(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }

    public AdministradorRecordMusic(String codigoAdmin, String apellidoAdmin, String nombreAdmin, String emailAdmin, String telefonoAdmin) {
        this.codigoAdmin = codigoAdmin;
        this.apellidoAdmin = apellidoAdmin;
        this.nombreAdmin = nombreAdmin;
        this.emailAdmin = emailAdmin;
        this.telefonoAdmin = telefonoAdmin;
    }

    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }

    public String getApellidoAdmin() {
        return apellidoAdmin;
    }

    public void setApellidoAdmin(String apellidoAdmin) {
        this.apellidoAdmin = apellidoAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getTelefonoAdmin() {
        return telefonoAdmin;
    }

    public void setTelefonoAdmin(String telefonoAdmin) {
        this.telefonoAdmin = telefonoAdmin;
    }

    @XmlTransient
    public Collection<Manager> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(Collection<Manager> managerCollection) {
        this.managerCollection = managerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAdmin != null ? codigoAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministradorRecordMusic)) {
            return false;
        }
        AdministradorRecordMusic other = (AdministradorRecordMusic) object;
        if ((this.codigoAdmin == null && other.codigoAdmin != null) || (this.codigoAdmin != null && !this.codigoAdmin.equals(other.codigoAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.AdministradorRecordMusic[ codigoAdmin=" + codigoAdmin + " ]";
    }
    
}
