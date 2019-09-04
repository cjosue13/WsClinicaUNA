/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_EXAMEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByPkClnExamen", query = "SELECT e FROM Examen e WHERE e.pkClnExamen = :pkClnExamen")
    , @NamedQuery(name = "Examen.findByExmNombreExamen", query = "SELECT e FROM Examen e WHERE e.exmNombreExamen = :exmNombreExamen")
    , @NamedQuery(name = "Examen.findByExmFecha", query = "SELECT e FROM Examen e WHERE e.exmFecha = :exmFecha")
    , @NamedQuery(name = "Examen.findByExmAnotaciones", query = "SELECT e FROM Examen e WHERE e.exmAnotaciones = :exmAnotaciones")
    , @NamedQuery(name = "Examen.findByExmVersion", query = "SELECT e FROM Examen e WHERE e.exmVersion = :exmVersion", hints = @QueryHint(name = "eclipselink.refresh", value = "true" ))})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PK_CLN_EXAMEN")
    private Long pkClnExamen;
    @Basic(optional = false)
    @Column(name = "EXM_NOMBRE_EXAMEN")
    private String exmNombreExamen;
    @Basic(optional = false)
    @Column(name = "EXM_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exmFecha;
    @Basic(optional = false)
    @Column(name = "EXM_ANOTACIONES")
    private String exmAnotaciones;
    @Basic(optional = false)
    @Column(name = "EXM_VERSION")
    private Long exmVersion;
    @OneToMany(mappedBy = "pkClnExamen", fetch = FetchType.LAZY)
    private List<ControlPaciente> controlPacienteList;

    public Examen() {
    }

    public Examen(Long pkClnExamen) {
        this.pkClnExamen = pkClnExamen;
    }

    public Examen(Long pkClnExamen, String exmNombreExamen, Date exmFecha, String exmAnotaciones, Long exmVersion) {
        this.pkClnExamen = pkClnExamen;
        this.exmNombreExamen = exmNombreExamen;
        this.exmFecha = exmFecha;
        this.exmAnotaciones = exmAnotaciones;
        this.exmVersion = exmVersion;
    }

    public Long getPkClnExamen() {
        return pkClnExamen;
    }

    public void setPkClnExamen(Long pkClnExamen) {
        this.pkClnExamen = pkClnExamen;
    }

    public String getExmNombreExamen() {
        return exmNombreExamen;
    }

    public void setExmNombreExamen(String exmNombreExamen) {
        this.exmNombreExamen = exmNombreExamen;
    }

    public Date getExmFecha() {
        return exmFecha;
    }

    public void setExmFecha(Date exmFecha) {
        this.exmFecha = exmFecha;
    }

    public String getExmAnotaciones() {
        return exmAnotaciones;
    }

    public void setExmAnotaciones(String exmAnotaciones) {
        this.exmAnotaciones = exmAnotaciones;
    }

    public Long getExmVersion() {
        return exmVersion;
    }

    public void setExmVersion(Long exmVersion) {
        this.exmVersion = exmVersion;
    }

    @XmlTransient
    public List<ControlPaciente> getControlPacienteList() {
        return controlPacienteList;
    }

    public void setControlPacienteList(List<ControlPaciente> controlPacienteList) {
        this.controlPacienteList = controlPacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkClnExamen != null ? pkClnExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.pkClnExamen == null && other.pkClnExamen != null) || (this.pkClnExamen != null && !this.pkClnExamen.equals(other.pkClnExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.Examen[ pkClnExamen=" + pkClnExamen + " ]";
    }
    
}
