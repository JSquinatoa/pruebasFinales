package repository;

import repository.model.Producto;

public interface IProductoRepo {

    public Producto seleccionarPorId(Integer id);

    public Producto seleccionarPorCodigoBarras(String codigoBarras);

    public void insertar(Producto producto);

    public Integer seleccionarStock(String codigoBarras);

    public void actualizar(Producto producto);

}
