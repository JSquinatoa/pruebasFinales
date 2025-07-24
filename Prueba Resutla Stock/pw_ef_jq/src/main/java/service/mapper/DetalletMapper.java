package service.mapper;

import repository.model.Detalle;
import repository.model.Producto;
import repository.model.Venta;
import service.to.DetalleTo;

public class DetalletMapper {

    public static Detalle toEntity(DetalleTo detalleTo) {
        Detalle d = new Detalle();
        d.setId(detalleTo.getId());
        d.setCantidad(detalleTo.getCantidad());
        d.setPrecioUnitario(detalleTo.getPrecioUnitario());

        Producto p = new Producto();
        Venta v = new Venta();
        d.setVenta(v);
        d.setProducto(p);
        return d;
    }

}
