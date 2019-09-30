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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "band")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banda.findAll", query = "SELECT b FROM Banda b")
    , @NamedQuery(name = "Banda.findByCodigoMusico", query = "SELECT b FROM Banda b WHERE b.bandPK.codigoMusico = :codigoMusico")
    , @NamedQuery(name = "Banda.findByCodigoBanda", query = "SELECT b FROM Banda b WHERE b.bandPK.codigoBanda = :codigoBanda")
    , @NamedQuery(name = "Banda.findByNombreBanda", query = "SELECT b FROM Banda b WHERE b.nameBand = :nameBand")
    , @NamedQuery(name = "Banda.findByNumeroIntegrantes", query = "SELECT b FROM Banda b WHERE b.numberParticipants = :numberParticipants")
    , @NamedQuery(name = "Banda.findByGeneroBanda", query = "SELECT b FROM Banda b WHERE b.genderBand = :genderBand")})
public class Band implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BandPK bandPK;
    @Basic(optional = false)
    @Column(name = "NAME_BAND")
    private String nameBand;
    @Column(name = "NUMBER_PARTICIPANTS")
    private Integer numberParticipants;
    @Basic(optional = false)
    @Column(name = "GENDER_BAND")
    private String genderBand;
    @OneToMany(mappedBy = "band")
    private Collection<Manager> managerCollection;
    @JoinColumn(name = "CODE_MUSICAL", referencedColumnName = "CODE_MUSICAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MembersBand membersBand;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Song> cancionCollection;

    public Band() {
    }

    public Band(BandPK bandPK) {
        this.bandPK = bandPK;
    }

    public Band(BandPK bandPK, String nameBand, String genderBand) {
        this.bandPK = bandPK;
        this.nameBand = nameBand;
        this.genderBand = genderBand;
    }

    public Band(String codigoMusico, String codigoBanda) {
        this.bandPK = new BandPK(codigoMusico, codigoBanda);
    }

    public BandPK getBandPK() {
        return bandPK;
    }

    public void setBandPK(BandPK bandPK) {
        this.bandPK = bandPK;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public Integer getNumberParticipants() {
        return numberParticipants;
    }

    public void setNumberParticipants(Integer numberParticipants) {
        this.numberParticipants = numberParticipants;
    }

    public String getGenderBand() {
        return genderBand;
    }

    public void setGenderBand(String genderBand) {
        this.genderBand = genderBand;
    }

    @XmlTransient
    public Collection<Manager> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(Collection<Manager> managerCollection) {
        this.managerCollection = managerCollection;
    }

    public MembersBand getMiembrosBanda() {
        return membersBand;
    }

    public void setMembersBand(MembersBand membersBand) {
        this.membersBand = membersBand;
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
        hash += (bandPK != null ? bandPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Band)) {
            return false;
        }
        Band other = (Band) object;
        if ((this.bandPK == null && other.bandPK != null) || (this.bandPK != null && !this.bandPK.equals(other.bandPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.ESPEmusic.model.Band[ bandPK=" + bandPK + " ]";
    }
    
}
