/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import cr.ac.una.wsclinicauna.util.LocalDateAdapter;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jose Pablo Bermudez
 */
@XmlRootElement(name = "ExamenDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExamenDto {
    
    Long exmID;
    String nombreExamen;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    LocalDate fecha;
    String anotaciones;
    Long exmVersion;

    public ExamenDto(){
    }
    
    public ExamenDto(Examen examen) {
        this.exmID = examen.getPkClnExamen();
        this.nombreExamen = examen.getExmNombreExamen();
        this.fecha = examen.getExmFecha().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        this.anotaciones = examen.getExmAnotaciones();
        this.exmVersion = examen.getExmVersion();
    }

    public Long getExmID() {
        return exmID;
    }

    public void setExmID(Long exmID) {
        this.exmID = exmID;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public Long getExmVersion() {
        return exmVersion;
    }

    public void setExmVersion(Long exmVersion) {
        this.exmVersion = exmVersion;
    }
    
    
}
