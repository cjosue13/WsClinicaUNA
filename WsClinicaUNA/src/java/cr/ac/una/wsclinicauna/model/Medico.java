/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
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
@Table(name = "CLN_TB_MEDICOS", schema = "ClinicaUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByMedId", query = "SELECT m FROM Medico m WHERE m.medId = :medId")
    , @NamedQuery(name = "Medico.findByMedCodigo", query = "SELECT m FROM Medico m WHERE m.medCodigo = :medCodigo")
    , @NamedQuery(name = "Medico.findByMedFolio", query = "SELECT m FROM Medico m WHERE m.medFolio = :medFolio")
    , @NamedQuery(name = "Medico.findByMedCarne", query = "SELECT m FROM Medico m WHERE m.medCarne = :medCarne")
    , @NamedQuery(name = "Medico.findByMedEstado", query = "SELECT m FROM Medico m WHERE m.medEstado = :medEstado")
    , @NamedQuery(name = "Medico.findByMedIniciojornada", query = "SELECT m FROM Medico m WHERE m.medIniciojornada = :medIniciojornada")
    , @NamedQuery(name = "Medico.findByMedFinjornada", query = "SELECT m FROM Medico m WHERE m.medFinjornada = :medFinjornada")
    , @NamedQuery(name = "Medico.findByMedEspaciosporhora", query = "SELECT m FROM Medico m WHERE m.medEspaciosporhora = :medEspaciosporhora", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "MED_ID_GENERATOR", sequenceName = "ClinicaUNA.SEQ_MEDICOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MED_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "MED_ID")
    private Long medId;
    @Basic(optional = false)
    @Column(name = "MED_CODIGO")
    private String medCodigo;
    @Basic(optional = false)
    @Column(name = "MED_FOLIO")
    private String medFolio;
    @Basic(optional = false)
    @Column(name = "MED_CARNE")
    private String medCarne;
    @Basic(optional = false)
    @Column(name = "MED_ESTADO")
    private String medEstado;
    @Basic(optional = false)
    @Column(name = "MED_INICIOJORNADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date medIniciojornada;
    @Basic(optional = false)
    @Column(name = "MED_FINJORNADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date medFinjornada;
    @Basic(optional = false)
    @Column(name = "MED_ESPACIOSPORHORA")
    private Integer medEspaciosporhora;
    @JoinTable(name = "CLN_TB_MEDICOS_PACIENTES", joinColumns = {
        @JoinColumn(name = "MED_ID", referencedColumnName = "MED_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PAC_ID", referencedColumnName = "PAC_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Paciente> pacienteList;
    @JoinColumn(name = "US_ID", referencedColumnName = "US_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Usuario usId;

    public Medico() {
    }

    public Medico(Long medId) {
        this.medId = medId;
    }

    public Medico(Long medId, String medCodigo, String medFolio, String medCarne, String medEstado, Date medIniciojornada, Date medFinjornada, Integer medEspaciosporhora) {
        this.medId = medId;
        this.medCodigo = medCodigo;
        this.medFolio = medFolio;
        this.medCarne = medCarne;
        this.medEstado = medEstado;
        this.medIniciojornada = medIniciojornada;
        this.medFinjornada = medFinjornada;
        this.medEspaciosporhora = medEspaciosporhora;
    }

    public Medico(MedicoDto MedicoDto) {
        this.medId = MedicoDto.getID();
        actualizarMedico(MedicoDto);
    }

    public void actualizarMedico(MedicoDto MedicoDto) {
        this.medCarne = MedicoDto.getCarne();
        this.medCodigo = MedicoDto.getCodigo();
        this.medEspaciosporhora = MedicoDto.getEspacios();
        this.medEstado = MedicoDto.getEstado();

        //SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        if (MedicoDto.getInicioJornada() != null && MedicoDto.getFinJornada() != null) {
            LocalDateTime inicioJornada = LocalDateTime.parse(MedicoDto.getInicioJornada(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            LocalDateTime finJornada = LocalDateTime.parse(MedicoDto.getFinJornada(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.medIniciojornada = Date.from(inicioJornada.atZone(ZoneId.systemDefault()).toInstant());

            this.medFinjornada = Date.from(finJornada.atZone(ZoneId.systemDefault()).toInstant());
        }

        /*this.medFinjornada = java.util.Date
      .from(MedicoDto.getInicioJornada().atZone(ZoneId.systemDefault())
      .toInstant());*/
        this.medFolio = MedicoDto.getFolio();
        this.medId = MedicoDto.getID();
        /*this.medIniciojornada = java.util.Date
      .from(MedicoDto.getFinJornada().atZone(ZoneId.systemDefault())
      .toInstant());*/
        this.pacienteList = new ArrayList<>();
        //this.usId = MedicoDto.getID();
        this.usId = new Usuario(MedicoDto.getUs());
    }

    public Long getMedId() {
        return medId;
    }

    public void setMedId(Long medId) {
        this.medId = medId;
    }

    public String getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(String medCodigo) {
        this.medCodigo = medCodigo;
    }

    public String getMedFolio() {
        return medFolio;
    }

    public void setMedFolio(String medFolio) {
        this.medFolio = medFolio;
    }

    public String getMedCarne() {
        return medCarne;
    }

    public void setMedCarne(String medCarne) {
        this.medCarne = medCarne;
    }

    public String getMedEstado() {
        return medEstado;
    }

    public void setMedEstado(String medEstado) {
        this.medEstado = medEstado;
    }

    public Date getMedIniciojornada() {
        return medIniciojornada;
    }

    public void setMedIniciojornada(Date medIniciojornada) {
        this.medIniciojornada = medIniciojornada;
    }

    public Date getMedFinjornada() {
        return medFinjornada;
    }

    public void setMedFinjornada(Date medFinjornada) {
        this.medFinjornada = medFinjornada;
    }

    public Integer getMedEspaciosporhora() {
        return medEspaciosporhora;
    }

    public void setMedEspaciosporhora(Integer medEspaciosporhora) {
        this.medEspaciosporhora = medEspaciosporhora;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Usuario getUsId() {
        return usId;
    }

    public void setUsId(Usuario usId) {
        this.usId = usId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medId != null ? medId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.medId == null && other.medId != null) || (this.medId != null && !this.medId.equals(other.medId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.Medico[ medId=" + medId + " ]";
    }

}
