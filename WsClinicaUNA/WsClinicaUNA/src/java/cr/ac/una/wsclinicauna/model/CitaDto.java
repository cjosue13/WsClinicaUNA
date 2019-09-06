/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "CitaDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitaDto {
    
    Long CtID;
    Long CtVersion;
    PacienteDto paciente;
    EspacioHoraDto espacioHora;
    String motivo;
    String estado;

    public CitaDto(){
    }
    
    public CitaDto(Cita cita) {
        this.CtID = cita.getPkClnCita();
        this.CtVersion = cita.getCtVersion();
        this.paciente = new PacienteDto(cita.getPacId());
        this.espacioHora = new EspacioHoraDto(cita.getPkClnEspacioHora());
        this.motivo = cita.getCtMotivo();
        this.estado = cita.getCtEstado();
    }
    
    public Long getID() {
        return CtID;
    }

    public void setID(Long CtID) {
        this.CtID = CtID;
    }

    public Long getCtVersion() {
        return CtVersion;
    }

    public void setCtVersion(Long CtVersion) {
        this.CtVersion = CtVersion;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public EspacioHoraDto getEspacioHora() {
        return espacioHora;
    }

    public void setEspacioHora(EspacioHoraDto espacioHora) {
        this.espacioHora = espacioHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
