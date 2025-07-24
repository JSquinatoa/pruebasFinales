package controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.IDetalleService;
import service.to.DetalleTo;

@Path("ventas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VentaController {

    @Inject
    private IDetalleService iDetalleService;

    @POST
    @Path("/{numeroVenta}")
    public Response crearVenta(@RequestBody List<DetalleTo> detalles, @PathParam("numeroVenta") Integer numeroVenta,
            @QueryParam("cedula") String cedula) {
        
        
        return Response.status(Response.Status.NO_CONTENT).build();

    }

}
