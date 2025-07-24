package controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.IProductoService;
import service.mapper.ProductoMapper;
import service.to.ProductoTo;

@Path("productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoController {

    @Inject
    private IProductoService iProductoService;

    @POST
    @Path("")
    public Response guardarProducto(@RequestBody ProductoTo productoTo) {
        this.iProductoService.guardar(ProductoMapper.toEntyty(productoTo));
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/stock/{codigoBarras}")
    public Response obtenerStock(@PathParam("codigoBarras") String codigoBarras,
            @QueryParam("stockPorVender") Integer stockPorVender) {
        boolean res = this.iProductoService.controlStock(codigoBarras, stockPorVender);
        return Response.status(Response.Status.OK).entity(res).build();
    }

    @GET
    @Path("/{codigoBarras}")
    public Response obtenerProducto(@PathParam("codigoBarras") String codigoBarras) {
        ProductoTo pto = ProductoMapper.toTo(this.iProductoService.buscarPorCodigoBarras(codigoBarras));
        return Response.status(Response.Status.OK).entity(pto).build();
    }

}
