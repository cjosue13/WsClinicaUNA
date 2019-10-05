/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.util.ArrayList;
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
    /*private ArrayList<AntecedenteDto> antecedentes;
    private ArrayList<ExamenDto> examenes;
    private ArrayList<ControlDto> controles;*/
    
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
        this.paciente = new PacienteDto(expediente.getExpPaciente());
        /*this.antecedentes = new ArrayList();
        this.examenes = new ArrayList();
        this.controles = new ArrayList();
        if(!expediente.getAntecedenteList().isEmpty()){
            for (Antecedente antecedente : expediente.getAntecedenteList()) {
                antecedentes.add(new AntecedenteDto(antecedente));
            }
        }
        if(!expediente.getControlList().isEmpty()){
            for (Control control : expediente.getControlList()) {
                controles.add(new ControlDto(control));
            }
        }
        if(!expediente.getExamenList().isEmpty()){
            for (Examen examen : expediente.getExamenList()) {
                examenes.add(new ExamenDto(examen));
            }
        }
    }

    public ArrayList<AntecedenteDto> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(ArrayList<AntecedenteDto> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public ArrayList<ExamenDto> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<ExamenDto> examenes) {
        this.examenes = examenes;
    }

    public ArrayList<ControlDto> getControles() {
        return controles;
    }

    public void setControles(ArrayList<ControlDto> controles) {
        this.controles = controles;
    }*/
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

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }
}
