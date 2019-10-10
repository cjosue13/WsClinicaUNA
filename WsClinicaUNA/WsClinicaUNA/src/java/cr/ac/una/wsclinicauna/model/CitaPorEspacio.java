/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_CITAS_POR_ESPACIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitaPorEspacio.findAll", query = "SELECT c FROM CitaPorEspacio c", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
    , @NamedQuery(name = "CitaPorEspacio.findByCtxespId", query = "SELECT c FROM CitaPorEspacio c WHERE c.ctxespId = :ctxespId", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
    , @NamedQuery(name = "CitaPorEspacio.findByCtxespTiempoCita", query = "SELECT c FROM CitaPorEspacio c WHERE c.ctxespTiempoCita = :ctxespTiempoCita")
    , @NamedQuery(name = "CitaPorEspacio.findByCtxespVersion", query = "SELECT c FROM CitaPorEspacio c WHERE c.ctxespVersion = :ctxespVersion")})
public class CitaPorEspacio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CXP_ID_GENERATOR", sequenceName = "ClinicaUNA.SEQ_CITAS_POR_ESPACIOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CXP_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "CTXESP_ID")
    private Long ctxespId;
    @Basic(optional = false)
    @Column(name = "CTXESP_TIEMPO_CITA")
    private Integer ctxespTiempoCita;
    @Basic(optional = false)
    @Column(name = "CTXESP_VERSION")
    private Long ctxespVersion;
    @JoinColumn(name = "CTXESP_CITA", referencedColumnName = "CT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cita ctxespCita;
    @JoinColumn(name = "CTXESP_ESPACIO", referencedColumnName = "ESP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Espacio ctxespEspacio;

    public CitaPorEspacio() {
    }

    public CitaPorEspacio(CitaPorEspacioDto cxp) {
        this.ctxespId = cxp.getCtxespId();
        actualizar(cxp);
    }

    public void actualizar(CitaPorEspacioDto cxp) {
        this.ctxespCita = new Cita(cxp.getCtxespCita());
        this.ctxespEspacio = new Espacio(cxp.getCtxespEspacio());
        this.ctxespTiempoCita = cxp.getCtxespTiempoCita();
        this.ctxespVersion = cxp.getCtxespVersion();
    }

    public CitaPorEspacio(Long ctxespId) {
        this.ctxespId = ctxespId;
    }

    public CitaPorEspacio(Long ctxespId, Integer ctxespTiempoCita, Long ctxespVersion) {
        this.ctxespId = ctxespId;
        this.ctxespTiempoCita = ctxespTiempoCita;
        this.ctxespVersion = ctxespVersion;
    }

    public Long getCtxespId() {
        return ctxespId;
    }

    public void setCtxespId(Long ctxespId) {
        this.ctxespId = ctxespId;
    }

    public Integer getCtxespTiempoCita() {
        return ctxespTiempoCita;
    }

    public void setCtxespTiempoCita(Integer ctxespTiempoCita) {
        this.ctxespTiempoCita = ctxespTiempoCita;
    }

    public Long getCtxespVersion() {
        return ctxespVersion;
    }

    public void setCtxespVersion(Long ctxespVersion) {
        this.ctxespVersion = ctxespVersion;
    }

    public Cita getCtxespCita() {
        return ctxespCita;
    }

    public void setCtxespCita(Cita ctxespCita) {
        this.ctxespCita = ctxespCita;
    }

    public Espacio getCtxespEspacio() {
        return ctxespEspacio;
    }

    public void setCtxespEspacio(Espacio ctxespEspacio) {
        this.ctxespEspacio = ctxespEspacio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctxespId != null ? ctxespId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaPorEspacio)) {
            return false;
        }
        CitaPorEspacio other = (CitaPorEspacio) object;
        if ((this.ctxespId == null && other.ctxespId != null) || (this.ctxespId != null && !this.ctxespId.equals(other.ctxespId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanillaws2.model.CitaPorEspacio[ ctxespId=" + ctxespId + " ]";
    }

}
