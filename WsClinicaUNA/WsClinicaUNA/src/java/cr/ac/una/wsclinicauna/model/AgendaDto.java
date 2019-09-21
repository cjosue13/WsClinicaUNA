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
@XmlRootElement(name = "AgendaDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgendaDto {
    
    Long ageID;
    MedicoDto medicoDto;
    Long agenVersion;

    public AgendaDto(){
    }
    
    public AgendaDto(Agenda agenda) {
        this.ageID = agenda.getAgeId();
        this.medicoDto = new MedicoDto(agenda.getAgeMedico());
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
