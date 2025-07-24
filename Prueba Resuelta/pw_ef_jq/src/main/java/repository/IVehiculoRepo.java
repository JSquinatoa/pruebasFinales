package repository;

import java.util.List;

import repository.model.Vehiculo;
import repository.model.dto.VehiculoDTO;

public interface IVehiculoRepo {

    public Vehiculo seleccionarPorId(Integer id);        

    public List<VehiculoDTO> seleecionarTodosVehiculosDTO();

    public void insertar(Vehiculo vehiculo);

    public void eliminar(Integer id);

}
