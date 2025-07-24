package service;

import java.util.List;

import service.to.DetalleTo;

public interface IDetalleService {

    public void guardar(List<DetalleTo> detalles, Integer numeroVenta, String cedula);

}
