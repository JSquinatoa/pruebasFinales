package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IVehiculoRepo;
import repository.model.Vehiculo;
import repository.model.dto.VehiculoDTO;

@ApplicationScoped
public class VehiculoServiceImpl implements IVehiculoService {

    @Inject
    private IVehiculoRepo iVehiculoRepo;

    @Override
    public Vehiculo buscarPorId(Integer id) {
        Vehiculo v = this.iVehiculoRepo.seleccionarPorId(id);
        if (v == null) {                        
            throw new UnsupportedOperationException("El vehículo con el id:" + id + " no existe");
        }
        return v;
    }

    @Override
    public List<VehiculoDTO> buscarTodosVehiculosDTO() {
        return this.iVehiculoRepo.seleecionarTodosVehiculosDTO();
    }

    @Override
    public void guardar(Vehiculo vehiculo) {
        this.iVehiculoRepo.insertar(vehiculo);
    }

    @Override
    public void borrar(Integer id) {
        this.iVehiculoRepo.eliminar(id);
    }

}
