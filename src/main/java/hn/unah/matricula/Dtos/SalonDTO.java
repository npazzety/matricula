package hn.unah.matricula.Dtos;

import lombok.Data;

@Data
public class SalonDTO {

    private int idEdificio;

    private String nombre;

    private int capacidad;

    private String numeroCuenta;

    private String observacion;
}
