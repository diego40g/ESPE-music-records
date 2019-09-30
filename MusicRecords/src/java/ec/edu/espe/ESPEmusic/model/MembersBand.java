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
@Table(name = "miembros_banda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MiembrosBanda.findAll", query = "SELECT m FROM MiembrosBanda m")
    , @NamedQuery(name = "MiembrosBanda.findByCodigoMusico", query = "SELECT m FROM MiembrosBanda m WHERE m.codeMusical = :codeMusical")
    , @NamedQuery(name = "MiembrosBanda.findByApellido", query = "SELECT m FROM MiembrosBanda m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "MiembrosBanda.findByNombre", query = "SELECT m FROM MiembrosBanda m WHERE m.name = :name")
    , @NamedQuery(name = "MiembrosBanda.findByCargo", query = "SELECT m FROM MiembrosBanda m WHERE m.position = :position")
    , @NamedQuery(name = "MiembrosBanda.findByEmail", query = "SELECT m FROM MiembrosBanda m WHERE m.email = :email")
    , @NamedQuery(name = "MiembrosBanda.findByTelefono", query = "SELECT m FROM MiembrosBanda m WHERE m.phone = :phone")})
public class MembersBand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODE_MUSICAL")
    private String codeMusical;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "POSITION")
    private String position;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miembrosBanda")
    private Collection<Band> bandaCollection;

    public MembersBand() {
    }

    public MembersBand(String codeMusical) {
        this.codeMusical = codeMusical;
    }

    public MembersBand(String codeMusical, String lastName, String name, String position, String email, String phone) {
        this.codeMusical = codeMusical;
        this.lastName = lastName;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
    }

    public String getCodeMusical() {
        return codeMusical;
    }

    public void setCodeMusical(String codeMusical) {
        this.codeMusical = codeMusical;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<Band> getBandaCollection() {
        return bandaCollection;
    }

    public void setBandaCollection(Collection<Band> bandaCollection) {
        this.bandaCollection = bandaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeMusical != null ? codeMusical.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembersBand)) {
            return false;
        }
        MembersBand other = (MembersBand) object;
        if ((this.codeMusical == null && other.codeMusical != null) || (this.codeMusical != null && !this.codeMusical.equals(other.codeMusical))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.MiembrosBanda[ codeMusical=" + codeMusical + " ]";
    }
    
}
