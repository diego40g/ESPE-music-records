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
    , @NamedQuery(name = "MiembrosBanda.findByCodigoMusico", query = "SELECT m FROM MiembrosBanda m WHERE m.codigoMusico = :codigoMusico")
    , @NamedQuery(name = "MiembrosBanda.findByApellido", query = "SELECT m FROM MiembrosBanda m WHERE m.apellido = :apellido")
    , @NamedQuery(name = "MiembrosBanda.findByNombre", query = "SELECT m FROM MiembrosBanda m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MiembrosBanda.findByCargo", query = "SELECT m FROM MiembrosBanda m WHERE m.cargo = :cargo")
    , @NamedQuery(name = "MiembrosBanda.findByEmail", query = "SELECT m FROM MiembrosBanda m WHERE m.email = :email")
    , @NamedQuery(name = "MiembrosBanda.findByTelefono", query = "SELECT m FROM MiembrosBanda m WHERE m.telefono = :telefono")})
public class MiembrosBanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_MUSICO")
    private String codigoMusico;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miembrosBanda")
    private Collection<Banda> bandaCollection;

    public MiembrosBanda() {
    }

    public MiembrosBanda(String codigoMusico) {
        this.codigoMusico = codigoMusico;
    }

    public MiembrosBanda(String codigoMusico, String apellido, String nombre, String cargo, String email, String telefono) {
        this.codigoMusico = codigoMusico;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cargo = cargo;
        this.email = email;
        this.telefono = telefono;
    }

    public String getCodigoMusico() {
        return codigoMusico;
    }

    public void setCodigoMusico(String codigoMusico) {
        this.codigoMusico = codigoMusico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Banda> getBandaCollection() {
        return bandaCollection;
    }

    public void setBandaCollection(Collection<Banda> bandaCollection) {
        this.bandaCollection = bandaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMusico != null ? codigoMusico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembrosBanda)) {
            return false;
        }
        MiembrosBanda other = (MiembrosBanda) object;
        if ((this.codigoMusico == null && other.codigoMusico != null) || (this.codigoMusico != null && !this.codigoMusico.equals(other.codigoMusico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.MiembrosBanda[ codigoMusico=" + codigoMusico + " ]";
    }
    
}
