package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IDetalleRepo;
import repository.IProductoRepo;
import repository.IVentaRepo;
import repository.model.Detalle;
import repository.model.Producto;
import repository.model.Venta;
import service.to.DetalleTo;

@ApplicationScoped
public class DetalleServiceImpl implements IDetalleService{

    @Inject
    private IDetalleRepo iDetalleRepo;

    @Inject 
    private IVentaRepo iVentaRepo;

    @Inject
    private IProductoRepo iProductoRepo;

    @Override
    public void guardar(List<DetalleTo> detalles, Integer numeroVenta, String cedula) {

        Venta v = new Venta();
        v.setNumeroVenta(numeroVenta);
        v.setCedulaCliente(cedula);
        List<Detalle> detallesVenta = new ArrayList<>();
        Float total = 0f;

        for (DetalleTo detalle : detalles) {
            
            Producto p = this.iProductoRepo.seleccionarPorCodigoBarras(null);
                        
        }
        



        
    }

}
