package service.mapper;

import repository.model.dto.VehiculoDTO;
import service.to.VehiculoDTOTo;

public class VehiculoDTOMapper {

    public static VehiculoDTOTo toTo(VehiculoDTO vehiculoDTO) {
        if (vehiculoDTO == null) {
            return null;
        }

        VehiculoDTOTo vDTOTo = new VehiculoDTOTo();
        vDTOTo.setId(vehiculoDTO.getId());
        vDTOTo.setPlaca(vehiculoDTO.getPlaca());
        vDTOTo.setMarca(vehiculoDTO.getMarca());
        vDTOTo.setModelo(vehiculoDTO.getModelo());

        return vDTOTo;
    }

}
