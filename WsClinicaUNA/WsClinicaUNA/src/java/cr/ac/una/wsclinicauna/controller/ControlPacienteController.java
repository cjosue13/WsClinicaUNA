/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wsclinicauna.controller;

import cr.ac.una.wsclinicauna.model.ControlPacienteDto;
import cr.ac.una.wsclinicauna.service.ControlPacienteService;
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
@Path("/ControlPacienteController")
public class ControlPacienteController {

    @EJB
    ControlPacienteService ControlPacienteService;

    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarControlPaciente(ControlPacienteDto ControlPaciente) {
        try {
            Respuesta respuesta = ControlPacienteService.guardarControlPaciente(ControlPaciente);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((ControlPacienteDto) respuesta.getResultado("ControlPaciente")).build();
        } catch (Exception ex) {
            Logger.getLogger(ControlPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando el ControlPaciente").build();
        }
    }
    
    @GET
    @Path("/ControlPacientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getControlPacientes() {
        try {
            Respuesta respuesta = ControlPacienteService.getControlPacientes();
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            ArrayList<ControlPacienteDto> ControlPacientesDto = (ArrayList<ControlPacienteDto>) respuesta.getResultado("ControlPacientes");
            
            return Response.ok(new GenericEntity<List<ControlPacienteDto>>(ControlPacientesDto){}).build();

        } catch (Exception ex) {
            Logger.getLogger(ControlPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo el ControlPaciente").build();
        }
    }
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response EliminarControlPaciente(@PathParam("id") Long ID) {
        try {
            Respuesta respuesta = ControlPacienteService.eliminarControlPaciente(ID);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((ControlPacienteDto) respuesta.getResultado("ControlPaciente")).build();
        } catch (Exception ex) {
            Logger.getLogger(ControlPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error Eliminar el ControlPaciente").build();
        }
    }
    
}

