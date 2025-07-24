package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IProductoRepo;
import repository.model.Producto;

@ApplicationScoped
public class ProductoServiceImpl implements IProductoService {

    @Inject
    private IProductoRepo iProductoRepo;

    @Override
    public Producto buscarPorId(Integer id) {
        return this.iProductoRepo.seleccionarPorId(id);
    }

    @Override
    public Producto buscarPorCodigoBarras(String codigoBarras) {
        return this.iProductoRepo.seleccionarPorCodigoBarras(codigoBarras);
    }

    @Override
    public void guardar(Producto producto) {
        Producto prodExite = buscarPorCodigoBarras(producto.getCodigoBarras());
        if (prodExite == null) {
            this.iProductoRepo.insertar(producto);
        } else {
            prodExite.setStock(prodExite.getStock() + producto.getStock());
            actualizar(prodExite);
        }
    }

    @Override
    public Integer buscarStock(String codigoBarras) {
        return this.iProductoRepo.seleccionarStock(codigoBarras);
    }

    @Override
    public void actualizar(Producto producto) {
        this.iProductoRepo.actualizar(producto);
        
    }

    @Override
    public boolean controlStock(String codigoBarras, Integer stockPorVender) {
        Producto p = buscarPorCodigoBarras(codigoBarras);
        if (p.getStock() >= stockPorVender) {
            p.setStock(p.getStock() - stockPorVender);
            actualizar(p);
            return true;     
        }else{
            return false;
        }
        
    }

}
