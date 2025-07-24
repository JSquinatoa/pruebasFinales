package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import service.IVehiculoService;
import service.mapper.VehiculoDTOMapper;
import service.mapper.VehiculoMapper;
import service.to.VehiculoDTOTo;
import service.to.VehiculoTo;

@Path("vehiculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoController {

    @Inject
    private IVehiculoService iVehiculoService;

    @GET
    @Path("/{id}")
    @Operation(summary = "Obtener un Vehículo por su id", description = "Esta capacidad me permite obtener un Vehiuclo por su id")
    public Response obtenerPorId(@PathParam("id") Integer id) {
        VehiculoTo vTo = VehiculoMapper.toTO(this.iVehiculoService.buscarPorId(id));
        return Response.status(Response.Status.OK).entity(vTo).build();
    }

    @GET
    @Path("")
    @Operation(summary = "Obtener todos los VehiculosDTO", description = "Esta capacidad me permite obtener Todos los VehicutlosDTO")
    public Response obtenerTodosVehiculosDTO(@Context UriInfo uriInfo) {
        List<VehiculoDTOTo> vDtoTo = this.iVehiculoService.buscarTodosVehiculosDTO().stream()
                .map(VehiculoDTOMapper::toTo).peek(vDTOTo -> vDTOTo.buildURI(uriInfo)).collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(vDtoTo).build();
    }

    @POST
    @Path("")
    @Operation(summary = "Guardar un Vehiculo", description = "Esta capacidad me permite guardar un vehiculo")
    public Response guardar(@RequestBody VehiculoTo vehiculoTo) {
        this.iVehiculoService.guardar(VehiculoMapper.toEntity(vehiculoTo));
        return Response.status(Response.Status.CREATED).entity("").build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar un Vehículo por su id", description = "Esta capacidad me permite Eliminar un Vehiculo por su id")
    public Response borrarPorId(@PathParam("id") Integer id) {
        this.iVehiculoService.borrar(id);
        return Response.status(Response.Status.NO_CONTENT).entity("").build();
    }

}
