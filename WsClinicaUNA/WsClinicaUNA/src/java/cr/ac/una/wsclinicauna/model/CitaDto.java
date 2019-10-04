/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
    
    private Long CtID;
    private Long CtVersion;
    private PacienteDto paciente;
//    EspacioHoraDto espacioHora;
    private String motivo;
    private String estado;
    private String telefono;
    private String correo;
    private String hora;

    public CitaDto(){
    }
    
    public CitaDto(Cita cita) {
        this.CtID = cita.getCtId();
        this.CtVersion = cita.getCtVersion();
        this.paciente = new PacienteDto(cita.getCtPaciente());
        this.motivo = cita.getCtMotivo();
        this.estado = cita.getCtEstado();
        this.telefono = cita.getCtTelefono();
        this.correo = cita.getCtCorreo();
        if (cita.getCtHora() != null) {
            LocalDateTime localDateTime = cita.getCtHora().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            this.hora = localDateTime.toLocalTime().toString();
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

   /* public EspacioHoraDto getEspacioHora() {
        return espacioHora;
    }

    public void setEspacioHora(EspacioHoraDto espacioHora) {
        this.espacioHora = espacioHora;
    }*/

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}