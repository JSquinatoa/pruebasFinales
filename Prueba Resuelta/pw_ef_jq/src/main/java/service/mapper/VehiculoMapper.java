package service.mapper;

import repository.model.Vehiculo;
import service.to.VehiculoTo;

public class VehiculoMapper {

    public static VehiculoTo toTO(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return null;
        }
        VehiculoTo vTo = new VehiculoTo();
        vTo.setId(vehiculo.getId());
        vTo.setPlaca(vehiculo.getPlaca());
        vTo.setMarca(vehiculo.getMarca());
        vTo.setModelo(vehiculo.getModelo());
        vTo.setColor(vehiculo.getColor());
        vTo.setPrecio(vehiculo.getPrecio());

        return vTo;
    }

    public static Vehiculo toEntity(VehiculoTo vehiculoTo) {
        Vehiculo v = new Vehiculo();
        v.setId(vehiculoTo.getId());
        v.setPlaca(vehiculoTo.getPlaca());
        v.setMarca(vehiculoTo.getMarca());
        v.setModelo(vehiculoTo.getModelo());
        v.setColor(vehiculoTo.getColor());
        v.setPrecio(vehiculoTo.getPrecio());

        return v;
    }

}
