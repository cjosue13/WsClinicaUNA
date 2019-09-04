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
@XmlRootElement(name = "EspacioHoraDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class EspacioHoraDto {
    
    Long espID;
    Long espVersion;
    AgendaDto agenda;

    public EspacioHoraDto(Long espID, Long espVersion, AgendaDto agenda) {
        this.espID = espID;
        this.espVersion = espVersion;
        this.agenda = agenda;
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
