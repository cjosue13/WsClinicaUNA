/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.Antecedente;
import cr.ac.una.wsclinicauna.model.AntecedenteDto;
import cr.ac.una.wsclinicauna.util.CodigoRespuesta;
import cr.ac.una.wsclinicauna.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Olivares
 */
@Stateless
@LocalBean
public class AntecedenteService {

    private static final Logger LOG = Logger.getLogger(AntecedenteService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    
     public Respuesta guardarAntecedente(AntecedenteDto AntecedenteDto) {
        try {
            Antecedente Antecedente;
            if (AntecedenteDto.getAntId() != null && AntecedenteDto.getAntId() > 0) {
                Antecedente = em.find(Antecedente.class, AntecedenteDto.getAntId());

                if (Antecedente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Antecedente a modificar.", "guardarAntecedente NoResultException");
                }

                Antecedente.actualizar(AntecedenteDto);
                Antecedente = em.merge(Antecedente);

            } else {
                Antecedente = new Antecedente(AntecedenteDto);
                em.persist(Antecedente);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Antecedente", new AntecedenteDto(Antecedente));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Antecedente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Antecedente.", "guardarAntecedente " + ex.getMessage());
        }
    }
    public Respuesta eliminarAntecendente(Long id) {
        try {
            //Empleado empleado;
            Antecedente Antecedente;
            if (id != null && id > 0) {
                Antecedente = em.find(Antecedente.class, id);
                if (Antecedente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el antecedente a eliminar.", "EliminarAntecedente NoResultException");
                }
                em.remove(Antecedente);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Antecedente a eliminar.", "EliminarAntecedente NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Antecedente porque tiene relaciones con otros registros.", "EliminarAntecedente " + ex.getMessage());
            }
            Logger.getLogger(AntecedenteService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Antecedente.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el Antecedente.", "EliminarAntecedente " + ex.getMessage());
        }
    }
    
}
