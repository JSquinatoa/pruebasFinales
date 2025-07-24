package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Vehiculo;
import repository.model.dto.VehiculoDTO;

@ApplicationScoped
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Vehiculo seleccionarPorId(Integer id) {
        return this.entityManager.find(Vehiculo.class, id);
    }

    @Override
    public List<VehiculoDTO> seleecionarTodosVehiculosDTO() {
        TypedQuery<VehiculoDTO> myQuery = this.entityManager
                .createQuery("SELECT v.id, v.placa, v.marca, v.modelo FROM Vehiculo v", VehiculoDTO.class);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Vehiculo vehiculo) {
        this.entityManager.persist(vehiculo);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(seleccionarPorId(id));
    }

}
