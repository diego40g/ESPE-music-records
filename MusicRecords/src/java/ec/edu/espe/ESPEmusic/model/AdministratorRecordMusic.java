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
    , @NamedQuery(name = "AdministradorRecordMusic.findByCodigoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.codeAdmin = :codeAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByApellidoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.lastNameAdmin = :lastNameAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByNombreAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.nameAdmin = :nameAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByEmailAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.emailAdmin = :emailAdmin")
    , @NamedQuery(name = "AdministradorRecordMusic.findByTelefonoAdmin", query = "SELECT a FROM AdministradorRecordMusic a WHERE a.phoneAdmin = :phoneAdmin")})
public class AdministratorRecordMusic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_ADMIN")
    private String codeAdmin;
    @Basic(optional = false)
    @Column(name = "LASTNAME_ADMIN")
    private String lastNameAdmin;
    @Basic(optional = false)
    @Column(name = "NAME_ADMIN")
    private String nameAdmin;
    @Basic(optional = false)
    @Column(name = "EMAIL_ADMIN")
    private String emailAdmin;
    @Basic(optional = false)
    @Column(name = "PHONE_ADMIN")
    private String phoneAdmin;
    @OneToMany(mappedBy = "codeAdmin")
    private Collection<Manager> managerCollection;

    public AdministratorRecordMusic() {
    }

    public AdministratorRecordMusic(String codeAdmin) {
        this.codeAdmin = codeAdmin;
    }

    public AdministratorRecordMusic(String codeAdmin, String lastNameAdmin, String nameAdmin, String emailAdmin, String phoneAdmin) {
        this.codeAdmin = codeAdmin;
        this.lastNameAdmin = lastNameAdmin;
        this.nameAdmin = nameAdmin;
        this.emailAdmin = emailAdmin;
        this.phoneAdmin = phoneAdmin;
    }

    public String getCodeAdmin() {
        return codeAdmin;
    }

    public void setCodeAdmin(String codeAdmin) {
        this.codeAdmin = codeAdmin;
    }

    public String getLastNameAdmin() {
        return lastNameAdmin;
    }

    public void setLastNameAdmin(String lastNameAdmin) {
        this.lastNameAdmin = lastNameAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPhoneAdmin() {
        return phoneAdmin;
    }

    public void setPhoneAdmin(String phoneAdmin) {
        this.phoneAdmin = phoneAdmin;
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
        hash += (codeAdmin != null ? codeAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministratorRecordMusic)) {
            return false;
        }
        AdministratorRecordMusic other = (AdministratorRecordMusic) object;
        if ((this.codeAdmin == null && other.codeAdmin != null) || (this.codeAdmin != null && !this.codeAdmin.equals(other.codeAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.AdministradorRecordMusic[ codeAdmin=" + codeAdmin + " ]";
    }
    
}
