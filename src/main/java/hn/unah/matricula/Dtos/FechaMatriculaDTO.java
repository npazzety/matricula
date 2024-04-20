package hn.unah.matricula.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class FechaMatriculaDTO {

    private Date primerDia;

    private Date ultimoDia;

    private Date horaComienzo;

    private Date horaFinal;
    
}
