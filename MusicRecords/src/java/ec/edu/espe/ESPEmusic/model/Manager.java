/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m")
    , @NamedQuery(name = "Manager.findByCodigoManager", query = "SELECT m FROM Manager m WHERE m.codeManager = :codeManager")
    , @NamedQuery(name = "Manager.findByApellidoManager", query = "SELECT m FROM Manager m WHERE m.lastNameManager = :lastNameManager")
    , @NamedQuery(name = "Manager.findByNombreManager", query = "SELECT m FROM Manager m WHERE m.nameManager = :nameManager")
    , @NamedQuery(name = "Manager.findByEmailManager", query = "SELECT m FROM Manager m WHERE m.emailManager = :emailManager")
    , @NamedQuery(name = "Manager.findByTelefonoManager", query = "SELECT m FROM Manager m WHERE m.phoneManager = :phoneManager")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_MANAGER")
    private String codeManager;
    @Basic(optional = false)
    @Column(name = "LASTNAME_MANAGER")
    private String lastNameManager;
    @Basic(optional = false)
    @Column(name = "NAME_MANAGER")
    private String nameManager;
    @Basic(optional = false)
    @Column(name = "EMAIL_MANAGER")
    private String emailManager;
    @Basic(optional = false)
    @Column(name = "PHONE_MANAGER")
    private String phoneManager;
    @JoinColumn(name = "CODE_ADMIN", referencedColumnName = "CODE_ADMIN")
    @ManyToOne
    private AdministratorRecordMusic codigoAdmin;
    @JoinColumns({
        @JoinColumn(name = "CODE_MUSICAL", referencedColumnName = "CODE_MUSICAL")
        , @JoinColumn(name = "CODE_BAND", referencedColumnName = "CODE_BAND")})
    @ManyToOne
    private Band banda;

    public Manager() {
    }

    public Manager(String codeManager) {
        this.codeManager = codeManager;
    }

    public Manager(String codeManager, String lastNameManager, String nameManager, String emailManager, String phoneManager) {
        this.codeManager = codeManager;
        this.lastNameManager = lastNameManager;
        this.nameManager = nameManager;
        this.emailManager = emailManager;
        this.phoneManager = phoneManager;
    }

    public String getCodeManager() {
        return codeManager;
    }

    public void setCodeManager(String codeManager) {
        this.codeManager = codeManager;
    }

    public String getLastNameManager() {
        return lastNameManager;
    }

    public void setLastNameManager(String lastNameManager) {
        this.lastNameManager = lastNameManager;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(String emailManager) {
        this.emailManager = emailManager;
    }

    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public AdministratorRecordMusic getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(AdministratorRecordMusic codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
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
        hash += (codeManager != null ? codeManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.codeManager == null && other.codeManager != null) || (this.codeManager != null && !this.codeManager.equals(other.codeManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Manager[ codeManager=" + codeManager + " ]";
    }
    
}
