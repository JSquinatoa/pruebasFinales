package service;

import java.util.List;

import repository.model.Vehiculo;
import repository.model.dto.VehiculoDTO;

public interface IVehiculoService {

    public Vehiculo buscarPorId(Integer id);

    public List<VehiculoDTO> buscarTodosVehiculosDTO();

    public void guardar(Vehiculo vehiculo);

    public void borrar(Integer id);
}
