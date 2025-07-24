package service.mapper;

import repository.model.Venta;
import service.to.VentaTo;

public class VentaMapper {

    public static Venta toEntity(VentaTo ventaTo){
        Venta v = new Venta();
        v.setId(ventaTo.getId());
        v.setNumeroVenta(ventaTo.getNumeroVenta());
        v.setCedulaCliente(ventaTo.getCedulaCliente());
        return v;

    }

}
