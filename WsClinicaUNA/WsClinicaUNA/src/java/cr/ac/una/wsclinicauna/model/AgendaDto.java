/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.util.LocalDateAdapter;
import cr.ac.una.wsclinicauna.util.LocalDateTimeAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "AgendaDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgendaDto {
    
    Long ageID;
    MedicoDto medicoDto;
    Long agenVersion;

    public AgendaDto(Agenda agenda) {
        this.ageID = agenda.getPkClnAgenda();
        this.medicoDto = new MedicoDto(agenda.getMedId());
        this.agenVersion = agenda.getAgeVersion();
    }

    public Long getID() {
        return ageID;
    }

    public void setID(Long ID) {
        this.ageID = ID;
    }

    public MedicoDto getMedicoDto() {
        return medicoDto;
    }

    public void setMedicoDto(MedicoDto medicoDto) {
        this.medicoDto = medicoDto;
    }

    public Long getAgenVersion() {
        return agenVersion;
    }

    public void setAgenVersion(Long agenVersion) {
        this.agenVersion = agenVersion;
    }
    
    
}