/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_AGENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findByPkClnAgenda", query = "SELECT a FROM Agenda a WHERE a.pkClnAgenda = :pkClnAgenda")
    , @NamedQuery(name = "Agenda.findByAgeVersion", query = "SELECT a FROM Agenda a WHERE a.ageVersion = :ageVersion" , hints = @QueryHint(name = "eclipselink.refresh", value = "true" ) )})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PK_CLN_AGENDA")
    private Long pkClnAgenda;
    @Basic(optional = false)
    @Column(name = "AGE_VERSION")
    private Long ageVersion;
    @OneToMany(mappedBy = "pkClnAgenda", fetch = FetchType.LAZY)
    private List<EspacioHora> espacioHoraList;
    @JoinColumn(name = "MED_ID", referencedColumnName = "MED_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Medico medId;

    public Agenda() {
    }

    public Agenda(Long pkClnAgenda) {
        this.pkClnAgenda = pkClnAgenda;
    }

    public Agenda(Long pkClnAgenda, Long ageVersion) {
        this.pkClnAgenda = pkClnAgenda;
        this.ageVersion = ageVersion;
    }
    
    public void actualizarAgenda(AgendaDto agenda){
        this.pkClnAgenda = agenda.getID();
        this.medId = new Medico(agenda.getMedicoDto());
        this.ageVersion = agenda.getAgenVersion();
    }
    
    public Agenda(AgendaDto agendaDto) {
        this.pkClnAgenda = agendaDto.getID();
        actualizarAgenda(agendaDto);
    }
    
    public Long getPkClnAgenda() {
        return pkClnAgenda;
    }

    public void setPkClnAgenda(Long pkClnAgenda) {
        this.pkClnAgenda = pkClnAgenda;
    }

    public Long getAgeVersion() {
        return ageVersion;
    }

    public void setAgeVersion(Long ageVersion) {
        this.ageVersion = ageVersion;
    }

    @XmlTransient
    public List<EspacioHora> getEspacioHoraList() {
        return espacioHoraList;
    }

    public void setEspacioHoraList(List<EspacioHora> espacioHoraList) {
        this.espacioHoraList = espacioHoraList;
    }

    public Medico getMedId() {
        return medId;
    }

    public void setMedId(Medico medId) {
        this.medId = medId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClnAgenda != null ? pkClnAgenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.pkClnAgenda == null && other.pkClnAgenda != null) || (this.pkClnAgenda != null && !this.pkClnAgenda.equals(other.pkClnAgenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.Agenda[ pkClnAgenda=" + pkClnAgenda + " ]";
    }
    
}
