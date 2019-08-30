/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Olivares
 */
@XmlRootElement(name = "PacienteDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class PacienteDto {
    private Long ID;
    private String nombre;
    private String pApellido;
    private String sApellido;
    private String cedula;
    private String correo;
    private String genero;
    private LocalDateTime fechaNacimiento;

    public PacienteDto() {
    }

    public PacienteDto(Paciente Paciente) {
        this.ID = Paciente.getPacId();
        this.nombre = Paciente.getPacNombre();
        this.pApellido = Paciente.getPacPapellido();
        this.sApellido = Paciente.getPacSapellido();
        this.cedula = Paciente.getPacCedula();
        this.correo = Paciente.getPacCorreo();
        this.fechaNacimiento = LocalDateTime.ofInstant(Paciente.getPacFechanacimiento().toInstant(),ZoneId.systemDefault());
        this.genero = Paciente.getPacGenero();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}