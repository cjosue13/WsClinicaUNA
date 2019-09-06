/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.controller;

import cr.ac.una.wsclinicauna.model.EspacioHoraDto;
import cr.ac.una.wsclinicauna.service.EspacioHoraService;
import cr.ac.una.wsclinicauna.util.CodigoRespuesta;
import cr.ac.una.wsclinicauna.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jose Pablo Bermudez
 */
@Path("/EspacioHoraController")
public class EspacioHoraController {

    @EJB
    EspacioHoraService EspacioHoraService;

    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarEspacioHora(EspacioHoraDto EspacioHora) {
        try {
            Respuesta respuesta = EspacioHoraService.guardarEspacioHora(EspacioHora);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((EspacioHoraDto) respuesta.getResultado("EspacioHora")).build();
        } catch (Exception ex) {
            Logger.getLogger(EspacioHoraController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando el EspacioHora").build();
        }
    }
    
    @GET
    @Path("/EspacioHoras")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEspacioHoras() {
        try {
            Respuesta respuesta = EspacioHoraService.getEspacioHoras();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ArrayList<EspacioHoraDto> EspacioHorasDto = (ArrayList<EspacioHoraDto>) respuesta.getResultado("EspacioHoras");
            
            return Response.ok(new GenericEntity<List<EspacioHoraDto>>(EspacioHorasDto){}).build();

        } catch (Exception ex) {
            Logger.getLogger(EspacioHoraController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el EspacioHora").build();
        }
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response EliminarEspacioHora(@PathParam("id") Long ID) {
        try {
            Respuesta respuesta = EspacioHoraService.eliminarEspacioHora(ID);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((EspacioHoraDto) respuesta.getResultado("EspacioHora")).build();
        } catch (Exception ex) {
            Logger.getLogger(EspacioHoraController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error Eliminar el EspacioHora").build();
        }
    }
    
}

