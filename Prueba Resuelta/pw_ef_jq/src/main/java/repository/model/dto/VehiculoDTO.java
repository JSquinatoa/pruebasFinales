package repository.model.dto;

public class VehiculoDTO {

    private Integer id;
    private String placa;
    private String marca;
    private String modelo;

    public VehiculoDTO() {
        super();
    }

    public VehiculoDTO(Integer id, String placa, String marca, String modelo) {
        super();
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
