package service;

import repository.model.Producto;

public interface IProductoService {

    public Producto buscarPorId(Integer id);

    public Producto buscarPorCodigoBarras(String codigoBarras);

    public void guardar(Producto producto);

    public Integer buscarStock(String codigoBarras);

    public void actualizar(Producto producto);

    public boolean controlStock(String codigoBarras, Integer stockvPorVender);

}
