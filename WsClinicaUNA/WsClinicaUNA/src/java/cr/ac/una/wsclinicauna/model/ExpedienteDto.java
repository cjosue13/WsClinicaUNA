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
@XmlRootElement(name = "ExpedienteDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExpedienteDto {
    
    private Long expID;
    private Long expVersion;
    private String antecedentesPatologicos;
    private String hospitalizaciones;
    private String operaciones;
    private String alergias;
    private String tratamientos;
    //private String antecedentesFamiliares;
    private PacienteDto paciente;

    public ExpedienteDto(){
    }
    
    public ExpedienteDto(Expediente expediente) {
        this.expID = expediente.getExpId();
        this.expVersion = expediente.getExpVersion();
        this.antecedentesPatologicos = expediente.getExpAntecedentePatologicos();
        this.hospitalizaciones = expediente.getExpHospitalizaciones();
        this.operaciones = expediente.getExpOperaciones();
        this.alergias = expediente.getExpAlergias();
        this.tratamientos = expediente.getExpTratamientos();
        //this.antecedentesFamiliares = expediente.getExpAntecedentesFamiliares();
        this.paciente = new PacienteDto(expediente.getExpPaciente());
    }

    public Long getExpID() {
        return expID;
    }

    public void setExpID(Long expID) {
        this.expID = expID;
    }

    public Long getExpVersion() {
        return expVersion;
    }

    public void setExpVersion(Long expVersion) {
        this.expVersion = expVersion;
    }

    public String getAntecedentesPatologicos() {
        return antecedentesPatologicos;
    }

    public void setAntecedentesPatologicos(String antecedentesPatologicos) {
        this.antecedentesPatologicos = antecedentesPatologicos;
    }

    public String getHospitalizaciones() {
        return hospitalizaciones;
    }

    public void setHospitalizaciones(String hospitalizaciones) {
        this.hospitalizaciones = hospitalizaciones;
    }

    public String getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    /*public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }*/

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    
    
    
}
