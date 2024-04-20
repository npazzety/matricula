package hn.unah.matricula.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class DatosHistorialAlumnoDTO {

    private int idHistorial;

    private String clase;

    private int uv;

    private int periodo;

    private Date anio;

    private int nota;

    private String observacion;


    
}
