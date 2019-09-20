/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.Espacio;
import cr.ac.una.wsclinicauna.model.EspacioDto;
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
public class EspacioHoraService {
    
    private static final Logger LOG = Logger.getLogger(EspacioHoraService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getEspacioHoras() {
        try {
            Query qryEspacioHoras = em.createNamedQuery("EspacioHora.findAll", Espacio.class);
            List<Espacio> EspacioHoras = qryEspacioHoras.getResultList();
            List<EspacioDto> EspacioHorasDto = new ArrayList<>();
            for (Espacio EspacioHoras1 : EspacioHoras) {
                EspacioHorasDto.add(new EspacioDto(EspacioHoras1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EspacioHoras", EspacioHorasDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen EspacioHoras con los criterios ingresados.", "getEspacioHoras NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el EspacioHora.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el EspacioHora.", "getEspacioHoras " + ex.getMessage());
        }
    }
    
    public Respuesta guardarEspacioHora(EspacioDto EspacioHoraDto) {
        try {
            Espacio EspacioHora;
            if (EspacioHoraDto.getEspID()!= null && EspacioHoraDto.getEspID()> 0) {
                EspacioHora = em.find(Espacio.class, EspacioHoraDto.getEspID());

                if (EspacioHora == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el EspacioHora a modificar.", "guardarEspacioHora NoResultException");
                }

                EspacioHora.actualizarEspacioHora(EspacioHoraDto);
                EspacioHora = em.merge(EspacioHora);

            } else {
                EspacioHora = new Espacio(EspacioHoraDto);
                em.persist(EspacioHora);
            }

            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "EspacioHora", new EspacioDto(EspacioHora));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el EspacioHora.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el EspacioHora.", "guardarEspacioHora " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarEspacioHora(Long id) {
        try {
            //Empleado empleado;
            Espacio EspacioHora;
            if (id != null && id > 0) {
                EspacioHora = em.find(Espacio.class, id);
                if (EspacioHora == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el empleado a eliminar.", "EliminarEspacioHora NoResultException");
                }
                em.remove(EspacioHora);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el EspacioHora a eliminar.", "EliminarEspacioHora NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el EspacioHora porque tiene relaciones con otros registros.", "EliminarEspacioHora " + ex.getMessage());
            }
            Logger.getLogger(EspacioHoraService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el EspacioHora.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el EspacioHora.", "EliminarEspacioHora " + ex.getMessage());
        }
    }
    
    
}