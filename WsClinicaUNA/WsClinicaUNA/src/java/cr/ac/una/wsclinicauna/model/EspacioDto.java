/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
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
    
    private Long espId;
    private String espHoraFin;
    private String espHoraInicio;
    private Long espVersion;
    private List<CitaPorEspacioDto> citasPorEspacioList;
    private AgendaDto espAgenda;

    public EspacioDto(){
    }
    
    public EspacioDto(Espacio espacio) {
        this.espId = espacio.getEspId();
        this.espVersion = espacio.getEspVersion();
        this.espAgenda = new AgendaDto(espacio.getEspAgenda());
        LocalDateTime localDateTime = espacio.getEspHoraFin().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        this.espHoraFin = localDateTime.toLocalTime().toString();
        LocalDateTime localDateTime2 = espacio.getEspHoraInicio().toInstant()
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


    public Long getEspVersion() {
        return espVersion;
    }

    public void setEspVersion(Long espVersion) {
        this.espVersion = espVersion;
    }

    public Long getEspId() {
        return espId;
    }

    public void setEspId(Long espId) {
        this.espId = espId;
    }

    public List<CitaPorEspacioDto> getCitasPorEspacioList() {
        return citasPorEspacioList;
    }

    public void setCitasPorEspacioList(List<CitaPorEspacioDto> citasPorEspacioList) {
        this.citasPorEspacioList = citasPorEspacioList;
    }

    public AgendaDto getEspAgenda() {
        return espAgenda;
    }

    public void setEspAgenda(AgendaDto espAgenda) {
        this.espAgenda = espAgenda;
    }
    
}
