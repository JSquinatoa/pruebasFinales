package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IVentaRepo;
import repository.model.Venta;

@ApplicationScoped
public class VentaServiceImpl implements IVentaService {

    @Inject
    private IVentaRepo iVentaRepo;

    @Override
    public void guardar(Venta venta) {
        this.iVentaRepo.insertar(venta);
    }

}
