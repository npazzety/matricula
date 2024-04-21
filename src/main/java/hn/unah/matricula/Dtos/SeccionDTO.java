package hn.unah.matricula.Dtos;

import java.sql.Date;

import lombok.Data;
@Data
public class SeccionDTO {

    private int idClase;

    private Date horaInicio;

    private Date horaFin;

    private String numeroCuenta;

    private String idSalon;

}
