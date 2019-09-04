/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_CITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByPkClnCita", query = "SELECT c FROM Cita c WHERE c.pkClnCita = :pkClnCita")
    , @NamedQuery(name = "Cita.findByCtEstado", query = "SELECT c FROM Cita c WHERE c.ctEstado = :ctEstado")
    , @NamedQuery(name = "Cita.findByCtMotivo", query = "SELECT c FROM Cita c WHERE c.ctMotivo = :ctMotivo")
    , @NamedQuery(name = "Cita.findByCtVersion", query = "SELECT c FROM Cita c WHERE c.ctVersion = :ctVersion" , hints = @QueryHint(name = "eclipselink.refresh", value = "true" ) )})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PK_CLN_CITA")
    private BigDecimal pkClnCita;
    @Basic(optional = false)
    @Column(name = "CT_ESTADO")
    private String ctEstado;
    @Column(name = "CT_MOTIVO")
    private String ctMotivo;
    @Basic(optional = false)
    @Column(name = "CT_VERSION")
    private BigInteger ctVersion;
    @JoinColumn(name = "PK_CLN_ESPACIO_HORA", referencedColumnName = "PK_CLN_ESPACIO_HORA")
    @ManyToOne(fetch = FetchType.LAZY)
    private EspacioHora pkClnEspacioHora;
    @JoinColumn(name = "PAC_ID", referencedColumnName = "PAC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente pacId;

    public Cita() {
    }

    public Cita(BigDecimal pkClnCita) {
        this.pkClnCita = pkClnCita;
    }

    public Cita(BigDecimal pkClnCita, String ctEstado, BigInteger ctVersion) {
        this.pkClnCita = pkClnCita;
        this.ctEstado = ctEstado;
        this.ctVersion = ctVersion;
    }

    public BigDecimal getPkClnCita() {
        return pkClnCita;
    }

    public void setPkClnCita(BigDecimal pkClnCita) {
        this.pkClnCita = pkClnCita;
    }

    public String getCtEstado() {
        return ctEstado;
    }

    public void setCtEstado(String ctEstado) {
        this.ctEstado = ctEstado;
    }

    public String getCtMotivo() {
        return ctMotivo;
    }

    public void setCtMotivo(String ctMotivo) {
        this.ctMotivo = ctMotivo;
    }

    public BigInteger getCtVersion() {
        return ctVersion;
    }

    public void setCtVersion(BigInteger ctVersion) {
        this.ctVersion = ctVersion;
    }

    public EspacioHora getPkClnEspacioHora() {
        return pkClnEspacioHora;
    }

    public void setPkClnEspacioHora(EspacioHora pkClnEspacioHora) {
        this.pkClnEspacioHora = pkClnEspacioHora;
    }

    public Paciente getPacId() {
        return pacId;
    }

    public void setPacId(Paciente pacId) {
        this.pacId = pacId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClnCita != null ? pkClnCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.pkClnCita == null && other.pkClnCita != null) || (this.pkClnCita != null && !this.pkClnCita.equals(other.pkClnCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.Cita[ pkClnCita=" + pkClnCita + " ]";
    }
    
}
