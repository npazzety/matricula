package hn.unah.matricula.Dtos;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SeccionDTO {

    private int idClase;

    private LocalDate horaInicio;

    private LocalDate horaFin;

    private String numeroCuenta;

    private String idSalon;

}
