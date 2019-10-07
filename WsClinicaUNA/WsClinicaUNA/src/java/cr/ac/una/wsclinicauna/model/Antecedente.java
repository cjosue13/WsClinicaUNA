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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_ANTECEDENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedente.findAll", query = "SELECT a FROM Antecedente a")
    , @NamedQuery(name = "Antecedente.findByAntId", query = "SELECT a FROM Antecedente a WHERE a.antId = :antId")
    , @NamedQuery(name = "Antecedente.findByAntEnfermedad", query = "SELECT a FROM Antecedente a WHERE a.antEnfermedad = :antEnfermedad")
    , @NamedQuery(name = "Antecedente.findByAntParentezco", query = "SELECT a FROM Antecedente a WHERE a.antParentezco = :antParentezco")
    , @NamedQuery(name = "Antecedente.findByAntExpediente", query = "SELECT a FROM Antecedente a WHERE a.antExpediente = :antExpediente")
    , @NamedQuery(name = "Antecedente.findByAntVersion", query = "SELECT a FROM Antecedente a WHERE a.antVersion = :antVersion")})
public class Antecedente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ANT_ID_GENERATOR", sequenceName = "ClinicaUNA.SEQ_ANTECEDENTES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ANT_ID")
    private Long antId;
    @Basic(optional = false)
    @Column(name = "ANT_ENFERMEDAD")
    private String antEnfermedad;
    @Basic(optional = false)
    @Column(name = "ANT_PARENTEZCO")
    private String antParentezco;
    @Basic(optional = false)
    @Column(name = "ANT_VERSION")
    private Long antVersion;
    @JoinColumn(name = "ANT_EXPEDIENTE", referencedColumnName = "EXP_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Expediente antExpediente;

    public Antecedente() {
    }

    public Antecedente(Long antId) {
        this.antId = antId;
    }

    public Antecedente(Long antId, String antEnfermedad, String antParentezco, Long antVersion) {
        this.antId = antId;
        this.antEnfermedad = antEnfermedad;
        this.antParentezco = antParentezco;
        this.antVersion = antVersion;
    }

    public Antecedente(AntecedenteDto antecente) {
        this.antId = antecente.getAntId();
        actualizar(antecente);
    }

    public void actualizar(AntecedenteDto antecente) {
        this.antEnfermedad = antecente.getAntEnfermedad();
        this.antExpediente = new Expediente(antecente.getAntExpediente());
        this.antParentezco = antecente.getAntParentezco();
        this.antVersion = antecente.getAntVersion();
    }

    public Long getAntId() {
        return antId;
    }

    public void setAntId(Long antId) {
        this.antId = antId;
    }

    public String getAntEnfermedad() {
        return antEnfermedad;
    }

    public void setAntEnfermedad(String antEnfermedad) {
        this.antEnfermedad = antEnfermedad;
    }

    public String getAntParentezco() {
        return antParentezco;
    }

    public void setAntParentezco(String antParentezco) {
        this.antParentezco = antParentezco;
    }

    public Long getAntVersion() {
        return antVersion;
    }

    public void setAntVersion(Long antVersion) {
        this.antVersion = antVersion;
    }

    public Expediente getAntExpediente() {
        return antExpediente;
    }

    public void setAntExpediente(Expediente antExpediente) {
        this.antExpediente = antExpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (antId != null ? antId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedente)) {
            return false;
        }
        Antecedente other = (Antecedente) object;
        if ((this.antId == null && other.antId != null) || (this.antId != null && !this.antId.equals(other.antId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.Antecedente[ antId=" + antId + " ]";
    }

}
