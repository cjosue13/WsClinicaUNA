/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "CLN_CITAS", catalog = "", schema = "CLINICAUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByCtId", query = "SELECT c FROM Cita c WHERE c.ctId = :ctId")
    , @NamedQuery(name = "Cita.findByCtEstado", query = "SELECT c FROM Cita c WHERE c.ctEstado = :ctEstado")
    , @NamedQuery(name = "Cita.findByCtMotivo", query = "SELECT c FROM Cita c WHERE c.ctMotivo = :ctMotivo")
    , @NamedQuery(name = "Cita.findByCtTelefono", query = "SELECT c FROM Cita c WHERE c.ctTelefono = :ctTelefono")
    , @NamedQuery(name = "Cita.findByCtCorreo", query = "SELECT c FROM Cita c WHERE c.ctCorreo = :ctCorreo")     
    , @NamedQuery(name = "Cita.findByCtVersion", query = "SELECT c FROM Cita c WHERE c.ctVersion = :ctVersion")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Id
    @SequenceGenerator(name = "CT_ID_GENERATOR", sequenceName = "ClinicaUNA.SEQ_CITAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "CT_ID")
    private Long ctId;
    @Basic(optional = false)
    @Column(name = "CT_ESTADO")
    private String ctEstado;
    @Column(name = "CT_MOTIVO")
    private String ctMotivo;
    @Basic(optional = false)
    @Column(name = "CT_TELEFONO")
    private String ctTelefono;
    @Basic(optional = false)
    @Column(name = "CT_CORREO")
    private String ctCorreo;
    @Basic(optional = false)
    @Column(name = "CT_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctHora;
    @JoinColumn(name = "CT_PACIENTE", referencedColumnName = "PAC_ID")
    @ManyToOne
    private Paciente ctPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctxespCita")
    private List<CitasPorEspacio> citasPorEspacioList;
    @Basic(optional = false)
    @Column(name = "CT_VERSION")
    private Long ctVersion;
    
    public Cita() {
    }

    public Cita(Long ctId) {
        this.ctId = ctId;
    }

    public Cita(Long ctId, String ctEstado, String ctMotivo, Long ctVersion, String ctTelefono, String ctCorreo, Paciente ctPaciente, List<CitasPorEspacio> citasPorEspacioList) {
        this.ctId = ctId;
        this.ctEstado = ctEstado;
        this.ctMotivo = ctMotivo;
        this.ctVersion = ctVersion;
        this.ctTelefono = ctTelefono;
        this.ctCorreo = ctCorreo;
        this.ctPaciente = ctPaciente;
        this.citasPorEspacioList = citasPorEspacioList;
    }

    public void actualizarCita(CitaDto cita) {

        this.ctVersion = cita.getCtVersion();
        this.ctPaciente = new Paciente(cita.getPaciente());
        this.ctMotivo = cita.getMotivo();
        this.ctEstado = cita.getEstado();
        this.ctCorreo = cita.getCorreo();
        this.ctTelefono = cita.getTelefono();
        if (cita.getHora() != null) {
            LocalDateTime inicioJornada = LocalDateTime.parse(cita.getHora(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.ctHora = Date.from(inicioJornada.atZone(ZoneId.systemDefault()).toInstant());
        }
    }

    public String getCtTelefono() {
        return ctTelefono;
    }

    public void setCtTelefono(String ctTelefono) {
        this.ctTelefono = ctTelefono;
    }

    public String getCtCorreo() {
        return ctCorreo;
    }

    public void setCtCorreo(String ctCorreo) {
        this.ctCorreo = ctCorreo;
    }

    public Cita(CitaDto citaDto) {
        this.ctId = citaDto.getID();
        actualizarCita(citaDto);
    }

    public Long getCtId() {
        return ctId;
    }

    public void setCtId(Long ctId) {
        this.ctId = ctId;
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

    public Long getCtVersion() {
        return ctVersion;
    }

    public void setCtVersion(Long ctVersion) {
        this.ctVersion = ctVersion;
    }

    public Paciente getCtPaciente() {
        return ctPaciente;
    }

    public void setCtPaciente(Paciente ctPaciente) {
        this.ctPaciente = ctPaciente;
    }

    @XmlTransient
    public List<CitasPorEspacio> getCitasPorEspacioList() {
        return citasPorEspacioList;
    }

    public void setCitasPorEspacioList(List<CitasPorEspacio> citasPorEspacioList) {
        this.citasPorEspacioList = citasPorEspacioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctId != null ? ctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.ctId == null && other.ctId != null) || (this.ctId != null && !this.ctId.equals(other.ctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cita[ ctId=" + ctId + " ]";
    }

    public Date getCtHora() {
        return ctHora;
    }

    public void setCtHora(Date ctHora) {
        this.ctHora = ctHora;
    }

}
