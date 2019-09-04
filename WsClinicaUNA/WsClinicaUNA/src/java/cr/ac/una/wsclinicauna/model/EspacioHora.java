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
@Table(name = "CLN_ESPACIO_HORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspacioHora.findAll", query = "SELECT e FROM EspacioHora e")
    , @NamedQuery(name = "EspacioHora.findByPkClnEspacioHora", query = "SELECT e FROM EspacioHora e WHERE e.pkClnEspacioHora = :pkClnEspacioHora")
    , @NamedQuery(name = "EspacioHora.findByEspVersion", query = "SELECT e FROM EspacioHora e WHERE e.espVersion = :espVersion", hints = @QueryHint(name = "eclipselink.refresh", value = "true" ))})
public class EspacioHora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PK_CLN_ESPACIO_HORA")
    private Long pkClnEspacioHora;
    @Basic(optional = false)
    @Column(name = "ESP_VERSION")
    private Long espVersion;
    @OneToMany(mappedBy = "pkClnEspacioHora", fetch = FetchType.LAZY)
    private List<Cita> citaList;
    @JoinColumn(name = "PK_CLN_AGENDA", referencedColumnName = "PK_CLN_AGENDA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agenda pkClnAgenda;

    public EspacioHora() {
    }

    public EspacioHora(Long pkClnEspacioHora) {
        this.pkClnEspacioHora = pkClnEspacioHora;
    }

    public EspacioHora(Long pkClnEspacioHora, Long espVersion) {
        this.pkClnEspacioHora = pkClnEspacioHora;
        this.espVersion = espVersion;
    }

    public Long getPkClnEspacioHora() {
        return pkClnEspacioHora;
    }

    public void setPkClnEspacioHora(Long pkClnEspacioHora) {
        this.pkClnEspacioHora = pkClnEspacioHora;
    }

    public Long getEspVersion() {
        return espVersion;
    }

    public void setEspVersion(Long espVersion) {
        this.espVersion = espVersion;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public Agenda getPkClnAgenda() {
        return pkClnAgenda;
    }

    public void setPkClnAgenda(Agenda pkClnAgenda) {
        this.pkClnAgenda = pkClnAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClnEspacioHora != null ? pkClnEspacioHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspacioHora)) {
            return false;
        }
        EspacioHora other = (EspacioHora) object;
        if ((this.pkClnEspacioHora == null && other.pkClnEspacioHora != null) || (this.pkClnEspacioHora != null && !this.pkClnEspacioHora.equals(other.pkClnEspacioHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.EspacioHora[ pkClnEspacioHora=" + pkClnEspacioHora + " ]";
    }
    
}
