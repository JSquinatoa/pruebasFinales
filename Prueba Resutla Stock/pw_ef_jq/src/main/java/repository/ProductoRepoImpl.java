package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Producto;

@ApplicationScoped
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Producto seleccionarPorId(Integer id) {
        return this.entityManager.find(Producto.class, id);
    }

    @Override
    public Producto seleccionarPorCodigoBarras(String codigoBarras) {

        try {
            TypedQuery<Producto> myQuery = this.entityManager
                    .createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras", Producto.class);
            myQuery.setParameter("codigoBarras", codigoBarras);
            return myQuery.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void insertar(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    public Integer seleccionarStock(String codigoBarras) {

        try {
            TypedQuery<Integer> myQuery = this.entityManager
                    .createQuery("SELECT p.stock FROM Producto p WHERE p.codigoBarras = :codigoBarras", Integer.class);
            myQuery.setParameter("codigoBarras", codigoBarras);
            return myQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void actualizar(Producto producto) {
        this.entityManager.merge(producto);
    }
}
