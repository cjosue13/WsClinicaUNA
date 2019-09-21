/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.Agenda;
import cr.ac.una.wsclinicauna.model.AgendaDto;
import cr.ac.una.wsclinicauna.model.Agenda;
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
public class AgendaService {
    private static final Logger LOG = Logger.getLogger(AgendaService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    
    public Respuesta getAgendas() {
        try {
            Query qryAgendas = em.createNamedQuery("Agenda.findAll", Agenda.class);
            List<Agenda> Agendas = qryAgendas.getResultList();
            List<AgendaDto> AgendasDto = new ArrayList<>();
            for (Agenda Agendas1 : Agendas) {
                AgendasDto.add(new AgendaDto(Agendas1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Agendas", AgendasDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Agendas con los criterios ingresados.", "getAgendas NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Agenda.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Agenda.", "getAgendas " + ex.getMessage());
        }
    }
    
    public Respuesta guardarAgenda(AgendaDto AgendaDto) {
        try {
            Agenda Agenda;
            if (AgendaDto.getID() != null && AgendaDto.getID() > 0) {
                Agenda = em.find(Agenda.class, AgendaDto.getID());

                if (Agenda == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Agenda a modificar.", "guardarAgenda NoResultException");
                }

                Agenda.actualizarAgenda(AgendaDto);
                Agenda = em.merge(Agenda);

            } else {
                Agenda = new Agenda(AgendaDto);
                em.persist(Agenda);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Agenda", new AgendaDto(Agenda));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Agenda.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Agenda.", "guardarAgenda " + ex.getMessage());
        }
    }
    public Respuesta eliminarAgenda(Long id) {
        try {
            //Empleado empleado;
            Agenda Agenda;
            if (id != null && id > 0) {
                Agenda = em.find(Agenda.class, id);
                if (Agenda == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el empleado a eliminar.", "EliminarAgenda NoResultException");
                }
                em.remove(Agenda);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Agenda a eliminar.", "EliminarAgenda NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Agenda porque tiene relaciones con otros registros.", "EliminarAgenda " + ex.getMessage());
            }
            Logger.getLogger(AgendaService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Agenda.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el Agenda.", "EliminarAgenda " + ex.getMessage());
        }
    }
    
}