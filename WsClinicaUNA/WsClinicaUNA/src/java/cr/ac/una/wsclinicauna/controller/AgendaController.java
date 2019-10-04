/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.controller;
import cr.ac.una.wsclinicauna.model.AgendaDto;
import cr.ac.una.wsclinicauna.service.AgendaService;
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
@Path("/AgendaController")
public class AgendaController {

    @EJB
    AgendaService AgendaService;

    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarAgenda(AgendaDto Agenda) {
        try {
            Respuesta respuesta = AgendaService.guardarAgenda(Agenda);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((AgendaDto) respuesta.getResultado("Agenda")).build();
        } catch (Exception ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando el Agenda").build();
        }
    }
    
    @GET
    @Path("/Agendas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAgendas() {
        try {
            Respuesta respuesta = AgendaService.getAgendas();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ArrayList<AgendaDto> AgendasDto = (ArrayList<AgendaDto>) respuesta.getResultado("Agendas");
            
            return Response.ok(new GenericEntity<List<AgendaDto>>(AgendasDto){}).build();

        } catch (Exception ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el Agenda").build();
        }
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response EliminarAgenda(@PathParam("id") Long ID) {
        try {
            Respuesta respuesta = AgendaService.eliminarAgenda(ID);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((AgendaDto) respuesta.getResultado("Agenda")).build();
        } catch (Exception ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error Eliminar el Agenda").build();
        }
    }
    
}
