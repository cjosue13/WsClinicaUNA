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
@XmlRootElement(name = "EspacioDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class EspacioDto {
    
    Long espID;
    Long espVersion;
    AgendaDto agenda;
    String espHoraFin;
    String espHoraInicio;

    public EspacioDto(){
    }
    
    public EspacioDto(Espacio espacioh) {
        this.espID = espacioh.getEspVersion();
        this.espVersion = espacioh.getEspVersion();
        this.agenda = new AgendaDto(espacioh.getEspAgenda());
        LocalDateTime localDateTime = espacioh.getEspHoraFin().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        this.espHoraFin = localDateTime.toLocalTime().toString();
        LocalDateTime localDateTime2 = espacioh.getEspHoraInicio().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        this.espHoraInicio = localDateTime2.toLocalTime().toString();
    }

    public String getEspHoraFin() {
        return espHoraFin;
    }

    public void setEspHoraFin(String espHoraFin) {
        this.espHoraFin = espHoraFin;
    }

    public String getEspHoraInicio() {
        return espHoraInicio;
    }

    public void setEspHoraInicio(String espHoraInicio) {
        this.espHoraInicio = espHoraInicio;
    }

    public Long getEspID() {
        return espID;
    }

    public void setEspID(Long espID) {
        this.espID = espID;
    }

    public Long getEspVersion() {
        return espVersion;
    }

    public void setEspVersion(Long espVersion) {
        this.espVersion = espVersion;
    }

    public AgendaDto getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaDto agenda) {
        this.agenda = agenda;
    }
    
    
}
