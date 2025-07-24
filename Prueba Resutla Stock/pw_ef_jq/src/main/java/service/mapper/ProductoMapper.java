package service.mapper;

import repository.model.Producto;
import service.to.ProductoTo;

public class ProductoMapper {

    public static ProductoTo toTo(Producto producto) {
        if (producto == null) {
            return null;
        }

        ProductoTo pTo = new ProductoTo();
        pTo.setId(producto.getId());
        pTo.setCodigoBarras(producto.getCodigoBarras());
        pTo.setNombre(producto.getNombre());
        pTo.setCategoria(producto.getCategoria());
        pTo.setStock(producto.getStock());
        pTo.setPrecio(producto.getPrecio());

        return pTo;
    }

    public static Producto toEntyty(ProductoTo productoTo) {
        Producto p = new Producto();
        p.setId(productoTo.getId());
        p.setCodigoBarras(productoTo.getCodigoBarras());
        p.setNombre(productoTo.getNombre());
        p.setCategoria(productoTo.getCategoria());
        p.setStock(productoTo.getStock());
        p.setPrecio(productoTo.getPrecio());

        return p;
    }
}
