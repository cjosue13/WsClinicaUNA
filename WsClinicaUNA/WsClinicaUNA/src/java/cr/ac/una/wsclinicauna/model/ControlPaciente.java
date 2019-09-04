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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@Entity
@Table(name = "CLN_CONTROL_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlPaciente.findAll", query = "SELECT c FROM ControlPaciente c")
    , @NamedQuery(name = "ControlPaciente.findByPkClnControlPaciente", query = "SELECT c FROM ControlPaciente c WHERE c.pkClnControlPaciente = :pkClnControlPaciente")
    , @NamedQuery(name = "ControlPaciente.findByCntFecha", query = "SELECT c FROM ControlPaciente c WHERE c.cntFecha = :cntFecha")
    , @NamedQuery(name = "ControlPaciente.findByCntControl", query = "SELECT c FROM ControlPaciente c WHERE c.cntControl = :cntControl")
    , @NamedQuery(name = "ControlPaciente.findByCntPresion", query = "SELECT c FROM ControlPaciente c WHERE c.cntPresion = :cntPresion")
    , @NamedQuery(name = "ControlPaciente.findByCntFrecuenciaCardiaca", query = "SELECT c FROM ControlPaciente c WHERE c.cntFrecuenciaCardiaca = :cntFrecuenciaCardiaca")
    , @NamedQuery(name = "ControlPaciente.findByCntPeso", query = "SELECT c FROM ControlPaciente c WHERE c.cntPeso = :cntPeso")
    , @NamedQuery(name = "ControlPaciente.findByCntTalla", query = "SELECT c FROM ControlPaciente c WHERE c.cntTalla = :cntTalla")
    , @NamedQuery(name = "ControlPaciente.findByCntTemperatura", query = "SELECT c FROM ControlPaciente c WHERE c.cntTemperatura = :cntTemperatura")
    , @NamedQuery(name = "ControlPaciente.findByCntImc", query = "SELECT c FROM ControlPaciente c WHERE c.cntImc = :cntImc")
    , @NamedQuery(name = "ControlPaciente.findByCntAnotacionEnfermeria", query = "SELECT c FROM ControlPaciente c WHERE c.cntAnotacionEnfermeria = :cntAnotacionEnfermeria")
    , @NamedQuery(name = "ControlPaciente.findByCntRazonConsulta", query = "SELECT c FROM ControlPaciente c WHERE c.cntRazonConsulta = :cntRazonConsulta")
    , @NamedQuery(name = "ControlPaciente.findByCntPlanAtencion", query = "SELECT c FROM ControlPaciente c WHERE c.cntPlanAtencion = :cntPlanAtencion")
    , @NamedQuery(name = "ControlPaciente.findByCntObservaciones", query = "SELECT c FROM ControlPaciente c WHERE c.cntObservaciones = :cntObservaciones")
    , @NamedQuery(name = "ControlPaciente.findByCntExamenFisico", query = "SELECT c FROM ControlPaciente c WHERE c.cntExamenFisico = :cntExamenFisico")
    , @NamedQuery(name = "ControlPaciente.findByCntTratamiento", query = "SELECT c FROM ControlPaciente c WHERE c.cntTratamiento = :cntTratamiento")
    , @NamedQuery(name = "ControlPaciente.findByCntVersion", query = "SELECT c FROM ControlPaciente c WHERE c.cntVersion = :cntVersion" , hints = @QueryHint(name = "eclipselink.refresh", value = "true" ) )})
public class ControlPaciente implements Serializable {

    @Basic(optional = false)
    @Column(name = "CNT_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntHora;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PK_CLN_CONTROL_PACIENTE")
    private Long pkClnControlPaciente;
    @Basic(optional = false)
    @Column(name = "CNT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntFecha;
    @Basic(optional = false)
    @Column(name = "CNT_CONTROL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cntControl;
    @Basic(optional = false)
    @Column(name = "CNT_PRESION")
    private Double cntPresion;
    @Basic(optional = false)
    @Column(name = "CNT_FRECUENCIA_CARDIACA")
    private Double cntFrecuenciaCardiaca;
    @Basic(optional = false)
    @Column(name = "CNT_PESO")
    private Double cntPeso;
    @Basic(optional = false)
    @Column(name = "CNT_TALLA")
    private Double cntTalla;
    @Basic(optional = false)
    @Column(name = "CNT_TEMPERATURA")
    private Double cntTemperatura;
    @Basic(optional = false)
    @Column(name = "CNT_IMC")
    private Double cntImc;
    @Basic(optional = false)
    @Column(name = "CNT_ANOTACION_ENFERMERIA")
    private String cntAnotacionEnfermeria;
    @Basic(optional = false)
    @Column(name = "CNT_RAZON_CONSULTA")
    private String cntRazonConsulta;
    @Basic(optional = false)
    @Column(name = "CNT_PLAN_ATENCION")
    private String cntPlanAtencion;
    @Basic(optional = false)
    @Column(name = "CNT_OBSERVACIONES")
    private String cntObservaciones;
    @Basic(optional = false)
    @Column(name = "CNT_EXAMEN_FISICO")
    private String cntExamenFisico;
    @Basic(optional = false)
    @Column(name = "CNT_TRATAMIENTO")
    private String cntTratamiento;
    @Basic(optional = false)
    @Column(name = "CNT_VERSION")
    private Long cntVersion;
    @JoinColumn(name = "PK_CLN_EXAMEN", referencedColumnName = "PK_CLN_EXAMEN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Examen pkClnExamen;
    @JoinColumn(name = "PAC_ID", referencedColumnName = "PAC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Paciente pacId;

    public ControlPaciente() {
    }

    public ControlPaciente(Long pkClnControlPaciente) {
        this.pkClnControlPaciente = pkClnControlPaciente;
    }

    public ControlPaciente(Long pkClnControlPaciente, Date cntFecha, Date cntControl, Double cntPresion, Double cntFrecuenciaCardiaca, Double cntPeso, Double cntTalla, Double cntTemperatura, Double cntImc, String cntAnotacionEnfermeria, String cntRazonConsulta, String cntPlanAtencion, String cntObservaciones, String cntExamenFisico, String cntTratamiento, Long cntVersion) {
        this.pkClnControlPaciente = pkClnControlPaciente;
        this.cntFecha = cntFecha;
        this.cntControl = cntControl;
        this.cntPresion = cntPresion;
        this.cntFrecuenciaCardiaca = cntFrecuenciaCardiaca;
        this.cntPeso = cntPeso;
        this.cntTalla = cntTalla;
        this.cntTemperatura = cntTemperatura;
        this.cntImc = cntImc;
        this.cntAnotacionEnfermeria = cntAnotacionEnfermeria;
        this.cntRazonConsulta = cntRazonConsulta;
        this.cntPlanAtencion = cntPlanAtencion;
        this.cntObservaciones = cntObservaciones;
        this.cntExamenFisico = cntExamenFisico;
        this.cntTratamiento = cntTratamiento;
        this.cntVersion = cntVersion;
    }
    
    public void actualizarControlPaciente(ControlPacienteDto control) throws ParseException{
    
        this.cntVersion = control.getCtrPacVersion();
        this.cntFecha = java.util.Date.from(control.getFecha().atStartOfDay()
      .atZone(ZoneId.systemDefault())
      .toInstant());
 
        Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(control.getHora());
        this.cntHora = date1;
        
        this.cntPresion = control.getPresion();
        this.cntFrecuenciaCardiaca = control.getFrecuenciaCardiaca();
        this.cntPeso = control.getPeso();
        this.cntTalla = control.getTalla();
        this.cntTemperatura = control.getTemperatura();
        this.cntImc = control.getImc();
        this.cntAnotacionEnfermeria = control.getAnotacionEnfermeria();
        this.cntRazonConsulta = control.getRazonConsulta();
        this.cntPlanAtencion = control.getPlanAtencion();
        this.cntObservaciones = control.getObservaciones();
        this.cntExamenFisico = control.getExamenFisico();
        this.cntTratamiento = control.getTratamiento();
        this.pacId = new Paciente(control.getCtrPacID());
        this.pkClnExamen = new Examen(control.getCtrPacID());
    
    }
    
    public Long getPkClnControlPaciente() {
        return pkClnControlPaciente;
    }

    public void setPkClnControlPaciente(Long pkClnControlPaciente) {
        this.pkClnControlPaciente = pkClnControlPaciente;
    }

    public Date getCntFecha() {
        return cntFecha;
    }

    public void setCntFecha(Date cntFecha) {
        this.cntFecha = cntFecha;
    }

    public Date getCntControl() {
        return cntControl;
    }

    public void setCntControl(Date cntControl) {
        this.cntControl = cntControl;
    }

    public Double getCntPresion() {
        return cntPresion;
    }

    public void setCntPresion(Double cntPresion) {
        this.cntPresion = cntPresion;
    }

    public Double getCntFrecuenciaCardiaca() {
        return cntFrecuenciaCardiaca;
    }

    public void setCntFrecuenciaCardiaca(Double cntFrecuenciaCardiaca) {
        this.cntFrecuenciaCardiaca = cntFrecuenciaCardiaca;
    }

    public Double getCntPeso() {
        return cntPeso;
    }

    public void setCntPeso(Double cntPeso) {
        this.cntPeso = cntPeso;
    }

    public Double getCntTalla() {
        return cntTalla;
    }

    public void setCntTalla(Double cntTalla) {
        this.cntTalla = cntTalla;
    }

    public Double getCntTemperatura() {
        return cntTemperatura;
    }

    public void setCntTemperatura(Double cntTemperatura) {
        this.cntTemperatura = cntTemperatura;
    }

    public Double getCntImc() {
        return cntImc;
    }

    public void setCntImc(Double cntImc) {
        this.cntImc = cntImc;
    }

    public String getCntAnotacionEnfermeria() {
        return cntAnotacionEnfermeria;
    }

    public void setCntAnotacionEnfermeria(String cntAnotacionEnfermeria) {
        this.cntAnotacionEnfermeria = cntAnotacionEnfermeria;
    }

    public String getCntRazonConsulta() {
        return cntRazonConsulta;
    }

    public void setCntRazonConsulta(String cntRazonConsulta) {
        this.cntRazonConsulta = cntRazonConsulta;
    }

    public String getCntPlanAtencion() {
        return cntPlanAtencion;
    }

    public void setCntPlanAtencion(String cntPlanAtencion) {
        this.cntPlanAtencion = cntPlanAtencion;
    }

    public String getCntObservaciones() {
        return cntObservaciones;
    }

    public void setCntObservaciones(String cntObservaciones) {
        this.cntObservaciones = cntObservaciones;
    }

    public String getCntExamenFisico() {
        return cntExamenFisico;
    }

    public void setCntExamenFisico(String cntExamenFisico) {
        this.cntExamenFisico = cntExamenFisico;
    }

    public String getCntTratamiento() {
        return cntTratamiento;
    }

    public void setCntTratamiento(String cntTratamiento) {
        this.cntTratamiento = cntTratamiento;
    }

    public Long getCntVersion() {
        return cntVersion;
    }

    public void setCntVersion(Long cntVersion) {
        this.cntVersion = cntVersion;
    }

    public Examen getPkClnExamen() {
        return pkClnExamen;
    }

    public void setPkClnExamen(Examen pkClnExamen) {
        this.pkClnExamen = pkClnExamen;
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
        hash += (pkClnControlPaciente != null ? pkClnControlPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlPaciente)) {
            return false;
        }
        ControlPaciente other = (ControlPaciente) object;
        if ((this.pkClnControlPaciente == null && other.pkClnControlPaciente != null) || (this.pkClnControlPaciente != null && !this.pkClnControlPaciente.equals(other.pkClnControlPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.wsclinicauna.model.ControlPaciente[ pkClnControlPaciente=" + pkClnControlPaciente + " ]";
    }

    public Date getCntHora() {
        return cntHora;
    }

    public void setCntHora(Date cntHora) {
        this.cntHora = cntHora;
    }
    
}
