/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.Paciente;
import cr.ac.una.wsclinicauna.model.PacienteDto;
import cr.ac.una.wsclinicauna.model.Paciente;
import cr.ac.una.wsclinicauna.model.PacienteDto;
import cr.ac.una.wsclinicauna.model.Paciente;
import cr.ac.una.wsclinicauna.util.CodigoRespuesta;
import cr.ac.una.wsclinicauna.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose Pablo Bermudez
 */
@Stateless
@LocalBean
public class PacienteService {
    
    private static final Logger LOG = Logger.getLogger(PacienteService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getPacientes() {
        try {
            Query qrypacientes = em.createNamedQuery("Paciente.findAll", Paciente.class);
            List<Paciente> pacientes = qrypacientes.getResultList();
            List<PacienteDto> pacientesDto = new ArrayList<>();
            for (Paciente pacientes1 : pacientes) {
                pacientesDto.add(new PacienteDto(pacientes1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Pacientes", pacientesDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen pacientes con los criterios ingresados.", "getPacientes NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el paciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el paciente.", "getPacientes " + ex.getMessage());
        }
    }
    
    public Respuesta guardarPaciente(PacienteDto PacienteDto) {
        try {
            Paciente Paciente;
            if (PacienteDto.getID() != null && PacienteDto.getID() > 0) {
                Paciente = em.find(Paciente.class, PacienteDto.getID());

                if (Paciente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Paciente a modificar.", "guardarPaciente NoResultException");
                }

                Paciente.actualizarPaciente(PacienteDto);
                Paciente = em.merge(Paciente);

            } else {
                Paciente = new Paciente(PacienteDto);
                em.persist(Paciente);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Paciente", new PacienteDto(Paciente));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Paciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Paciente.", "guardarPaciente " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarPaciente(Long id) {
        try {
            //Empleado empleado;
            Paciente Paciente;
            if (id != null && id > 0) {
                Paciente = em.find(Paciente.class, id);
                if (Paciente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el empleado a eliminar.", "EliminarPaciente NoResultException");
                }
                em.remove(Paciente);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Paciente a eliminar.", "EliminarPaciente NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Paciente porque tiene relaciones con otros registros.", "EliminarPaciente " + ex.getMessage());
            }
            Logger.getLogger(PacienteService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Paciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el Paciente.", "EliminarPaciente " + ex.getMessage());
        }
    }
    
    
}
