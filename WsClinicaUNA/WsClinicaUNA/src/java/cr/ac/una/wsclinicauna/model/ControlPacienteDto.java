/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.util.LocalDateAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "ControlPacienteDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ControlPacienteDto {
    
    Long ctrPacID;
    Long ctrPacVersion;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    LocalDate fecha;
    String hora;
    float presion;
    float frecuenciaCardiaca;
    float peso;
    float talla;
    float temperatura;
    float imc;
    String anotacionEnfermeria;
    String razonConsulta;
    String PlanAtencion;
    String Observaciones;
    String examenFisico;
    String tratamiento;
    PacienteDto paciente;
    ExamenDto examen;

    
    public ControlPacienteDto(ControlPaciente control) {
        //this.ctrPacID = control.getPacId();
        this.ctrPacVersion = control.getCntVersion();
        this.fecha = control.getCntFecha().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        LocalDateTime localDateTime = control.getCntControl().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        
        this.hora = localDateTime.toLocalTime().toString();
        
        this.presion = control.getCntPresion();
        this.frecuenciaCardiaca = control.getCntFrecuenciaCardiaca();
        this.peso = control.getCntPeso();
        this.talla = control.getCntTalla();
        this.temperatura = control.getCntTemperatura();
        this.imc = control.getCntImc();
        this.anotacionEnfermeria = control.getCntAnotacionEnfermeria();
        this.razonConsulta = control.getCntRazonConsulta();
        this.PlanAtencion = control.getCntPlanAtencion();
        this.Observaciones = control.getCntObservaciones();
        this.examenFisico = control.getCntExamenFisico();
        this.tratamiento = control.getCntTratamiento();
        this.paciente = new PacienteDto(control.getPacId());
        this.examen = new ExamenDto(control.getPkClnExamen());
    }
    
    
    public Long getCtrPacID() {
        return ctrPacID;
    }

    public void setCtrPacID(Long ctrPacID) {
        this.ctrPacID = ctrPacID;
    }

    public Long getCtrPacVersion() {
        return ctrPacVersion;
    }

    public void setCtrPacVersion(Long ctrPacVersion) {
        this.ctrPacVersion = ctrPacVersion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getPresion() {
        return presion;
    }

    public void setPresion(float presion) {
        this.presion = presion;
    }

    public float getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(float frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getAnotacionEnfermeria() {
        return anotacionEnfermeria;
    }

    public void setAnotacionEnfermeria(String anotacionEnfermeria) {
        this.anotacionEnfermeria = anotacionEnfermeria;
    }

    public String getRazonConsulta() {
        return razonConsulta;
    }

    public void setRazonConsulta(String razonConsulta) {
        this.razonConsulta = razonConsulta;
    }

    public String getPlanAtencion() {
        return PlanAtencion;
    }

    public void setPlanAtencion(String PlanAtencion) {
        this.PlanAtencion = PlanAtencion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public ExamenDto getExamen() {
        return examen;
    }

    public void setExamen(ExamenDto examen) {
        this.examen = examen;
    }

    
    
    
    
}
