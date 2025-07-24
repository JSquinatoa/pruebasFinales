package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import repository.model.Venta;

@ApplicationScoped
@Transactional
public class VentaRepoImpl implements IVentaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Venta venta) {
        this.entityManager.persist(venta);
    }

}
