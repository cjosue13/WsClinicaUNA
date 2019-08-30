/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.service;

import cr.ac.una.wsclinicauna.model.Usuario;
import cr.ac.una.wsclinicauna.model.UsuarioDto;
import cr.ac.una.wsclinicauna.util.CodigoRespuesta;
import cr.ac.una.wsclinicauna.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
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
 * @author Carlos Olivares
 */
@Stateless
@LocalBean
public class UsuarioService {

    private static final Logger LOG = Logger.getLogger(UsuarioService.class.getName());
    @PersistenceContext(unitName = "WsClinicaUNAPU")
    private EntityManager em;

    public Respuesta validarUsuario(String usuario, String clave) {
        try {
            Query qryActividad = em.createNamedQuery("Usuario.findByUsuClave", Usuario.class);
            qryActividad.setParameter("usUsuario", usuario);
            qryActividad.setParameter("usClave", clave);
            qryActividad.setParameter("usClaveTemp", clave);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Usuario", new UsuarioDto((Usuario) qryActividad.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }

    public Respuesta guardarUsuario(UsuarioDto UsuarioDto) {
        try {
            Usuario Usuario;
            if (UsuarioDto.getID() != null && UsuarioDto.getID() > 0) {
                Usuario = em.find(Usuario.class, UsuarioDto.getID());

                if (Usuario == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Usuario a modificar.", "guardarUsuario NoResultException");
                }

                Usuario.actualizarUsuario(UsuarioDto);
                Usuario = em.merge(Usuario);

            } else {
                Usuario = new Usuario(UsuarioDto);
                em.persist(Usuario);
            }
            
            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Usuario", new UsuarioDto(Usuario));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Usuario.", "guardarUsuario " + ex.getMessage());
        }
    }
    public Respuesta eliminarUsuario(Long id) {
        try {
            //Empleado empleado;
            Usuario usuario;
            if (id != null && id > 0) {
                usuario = em.find(Usuario.class, id);
                if (usuario == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el empleado a eliminar.", "EliminarUsuario NoResultException");
                }
                em.remove(usuario);
            } else {
                return new Respuesta(false,CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el usuario a eliminar.", "EliminarEmpleado NoResultException");
            }
            return new Respuesta(true,CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el usuario porque tiene relaciones con otros registros.", "EliminarUsuario " + ex.getMessage());
            }
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el usuario.", "EliminarUsuario " + ex.getMessage());
        }
    }

}
