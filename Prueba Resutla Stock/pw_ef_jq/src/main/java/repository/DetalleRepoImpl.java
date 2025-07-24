package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import repository.model.Detalle;

@ApplicationScoped
@Transactional
public class DetalleRepoImpl implements IDetalleRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Detalle detalle) {
        this.entityManager.persist(detalle);
    }

}
