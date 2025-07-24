package service.to;

import java.net.URI;
import java.util.HashMap;

import controller.VehiculoController;
import jakarta.ws.rs.core.UriInfo;

public class VehiculoDTOTo {

    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    public HashMap<String, String> _links = new HashMap<>();

    // GET y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void buildURI(UriInfo uriInfo) {
        URI vehiculo = uriInfo.getBaseUriBuilder().path(VehiculoController.class)
                .path(VehiculoController.class, "obtenerPorId").build(id);
        _links.put("completo", vehiculo.toString());
    }

}
