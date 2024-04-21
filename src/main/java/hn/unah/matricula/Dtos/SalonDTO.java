package hn.unah.matricula.Dtos;

import lombok.Data;

@Data
public class SalonDTO {

    private String idEdificio;

    private String nombre;

    private int capacidad;

    private String numeroCuenta;

    private String observacion;
}
