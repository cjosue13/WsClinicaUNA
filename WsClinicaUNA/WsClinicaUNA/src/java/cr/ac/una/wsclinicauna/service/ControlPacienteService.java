/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.ControlPaciente;
import cr.ac.una.wsclinicauna.model.ControlPacienteDto;
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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jose Pablo Bermudez
 */
@Stateless
@LocalBean
public class ControlPacienteService {
    private static final Logger LOG = Logger.getLogger(ControlPacienteService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getControlPacientes() {
        try {
            Query qryControlPacientes = em.createNamedQuery("ControlPaciente.findAll", ControlPaciente.class);
            List<ControlPaciente> ControlPacientes = qryControlPacientes.getResultList();
            List<ControlPacienteDto> ControlPacientesDto = new ArrayList<>();
            for (ControlPaciente ControlPacientes1 : ControlPacientes) {
                ControlPacientesDto.add(new ControlPacienteDto(ControlPacientes1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "ControlPacientes", ControlPacientesDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen ControlPacientes con los criterios ingresados.", "getControlPacientes NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el ControlPaciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el ControlPaciente.", "getControlPacientes " + ex.getMessage());
        }
    }
    
    public Respuesta guardarControlPaciente(ControlPacienteDto ControlPacienteDto) {
        try {
            ControlPaciente ControlPaciente;
            if (ControlPacienteDto.getCtrPacID()!= null && ControlPacienteDto.getCtrPacID()> 0) {
                ControlPaciente = em.find(ControlPaciente.class, ControlPacienteDto.getCtrPacID());

                if (ControlPaciente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el ControlPaciente a modificar.", "guardarControlPaciente NoResultException");
                }

                ControlPaciente.actualizarControlPaciente(ControlPacienteDto);
                ControlPaciente = em.merge(ControlPaciente);

            } else {
                ControlPaciente = new ControlPaciente(ControlPacienteDto);
                em.persist(ControlPaciente);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "ControlPaciente", new ControlPacienteDto(ControlPaciente));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el ControlPaciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el ControlPaciente.", "guardarControlPaciente " + ex.getMessage());
        }
    }
    public Respuesta eliminarControlPaciente(Long id) {
        try {
            //Empleado empleado;
            ControlPaciente ControlPaciente;
            if (id != null && id > 0) {
                ControlPaciente = em.find(ControlPaciente.class, id);
                if (ControlPaciente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el ControlPaciente a eliminar.", "EliminarControlPaciente NoResultException");
                }
                em.remove(ControlPaciente);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el ControlPaciente a eliminar.", "EliminarControlPaciente NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el ControlPaciente porque tiene relaciones con otros registros.", "EliminarControlPaciente " + ex.getMessage());
            }
            Logger.getLogger(PacienteService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Paciente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el ControlPaciente.", "EliminarControlPaciente " + ex.getMessage());
        }
    }
}
