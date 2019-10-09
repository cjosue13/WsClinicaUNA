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
 * @author Carlos Olivares
 */
@XmlRootElement(name = "EspacioDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitaPorEspacioDto {
    private Long ctxespId;
    private Long ctxespTiempoCita;
    private Long ctxespVersion;
    private CitaDto ctxespCita;
    private EspacioDto ctxespEspacio;

    public CitaPorEspacioDto() {
    }
    
    public CitaPorEspacioDto(CitasPorEspacio cxp) {
        this.ctxespCita = new CitaDto(cxp.getCtxespCita());
        this.ctxespEspacio = new EspacioDto(cxp.getCtxespEspacio());
        this.ctxespTiempoCita = cxp.getCtxespTiempoCita();
        this.ctxespVersion = cxp.getCtxespVersion();
    }
    
    
    public Long getCtxespId() {
        return ctxespId;
    }

    public void setCtxespId(Long ctxespId) {
        this.ctxespId = ctxespId;
    }

    public Long getCtxespTiempoCita() {
        return ctxespTiempoCita;
    }

    public void setCtxespTiempoCita(Long ctxespTiempoCita) {
        this.ctxespTiempoCita = ctxespTiempoCita;
    }

    public Long getCtxespVersion() {
        return ctxespVersion;
    }

    public void setCtxespVersion(Long ctxespVersion) {
        this.ctxespVersion = ctxespVersion;
    }

    public CitaDto getCtxespCita() {
        return ctxespCita;
    }

    public void setCtxespCita(CitaDto ctxespCita) {
        this.ctxespCita = ctxespCita;
    }

    public EspacioDto getCtxespEspacio() {
        return ctxespEspacio;
    }

    public void setCtxespEspacio(EspacioDto ctxespEspacio) {
        this.ctxespEspacio = ctxespEspacio;
    }
    
}
