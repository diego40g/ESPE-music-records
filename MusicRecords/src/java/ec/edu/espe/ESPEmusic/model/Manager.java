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
    , @NamedQuery(name = "Manager.findByCodigoManager", query = "SELECT m FROM Manager m WHERE m.codigoManager = :codigoManager")
    , @NamedQuery(name = "Manager.findByApellidoManager", query = "SELECT m FROM Manager m WHERE m.apellidoManager = :apellidoManager")
    , @NamedQuery(name = "Manager.findByNombreManager", query = "SELECT m FROM Manager m WHERE m.nombreManager = :nombreManager")
    , @NamedQuery(name = "Manager.findByEmailManager", query = "SELECT m FROM Manager m WHERE m.emailManager = :emailManager")
    , @NamedQuery(name = "Manager.findByTelefonoManager", query = "SELECT m FROM Manager m WHERE m.telefonoManager = :telefonoManager")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_MANAGER")
    private String codigoManager;
    @Basic(optional = false)
    @Column(name = "APELLIDO_MANAGER")
    private String apellidoManager;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MANAGER")
    private String nombreManager;
    @Basic(optional = false)
    @Column(name = "EMAIL_MANAGER")
    private String emailManager;
    @Basic(optional = false)
    @Column(name = "TELEFONO_MANAGER")
    private String telefonoManager;
    @JoinColumn(name = "CODIGO_ADMIN", referencedColumnName = "CODIGO_ADMIN")
    @ManyToOne
    private AdministratorRecordMusic codigoAdmin;
    @JoinColumns({
        @JoinColumn(name = "CODIGO_MUSICO", referencedColumnName = "CODIGO_MUSICO")
        , @JoinColumn(name = "CODIGO_BANDA", referencedColumnName = "CODIGO_BANDA")})
    @ManyToOne
    private Band banda;

    public Manager() {
    }

    public Manager(String codigoManager) {
        this.codigoManager = codigoManager;
    }

    public Manager(String codigoManager, String apellidoManager, String nombreManager, String emailManager, String telefonoManager) {
        this.codigoManager = codigoManager;
        this.apellidoManager = apellidoManager;
        this.nombreManager = nombreManager;
        this.emailManager = emailManager;
        this.telefonoManager = telefonoManager;
    }

    public String getCodigoManager() {
        return codigoManager;
    }

    public void setCodigoManager(String codigoManager) {
        this.codigoManager = codigoManager;
    }

    public String getApellidoManager() {
        return apellidoManager;
    }

    public void setApellidoManager(String apellidoManager) {
        this.apellidoManager = apellidoManager;
    }

    public String getNombreManager() {
        return nombreManager;
    }

    public void setNombreManager(String nombreManager) {
        this.nombreManager = nombreManager;
    }

    public String getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(String emailManager) {
        this.emailManager = emailManager;
    }

    public String getTelefonoManager() {
        return telefonoManager;
    }

    public void setTelefonoManager(String telefonoManager) {
        this.telefonoManager = telefonoManager;
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
        hash += (codigoManager != null ? codigoManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.codigoManager == null && other.codigoManager != null) || (this.codigoManager != null && !this.codigoManager.equals(other.codigoManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Manager[ codigoManager=" + codigoManager + " ]";
    }
    
}
