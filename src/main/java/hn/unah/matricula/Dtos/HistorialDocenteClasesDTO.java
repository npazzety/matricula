package hn.unah.matricula.Dtos;

import java.util.List;

import hn.unah.matricula.Entities.Clases;
import lombok.Data;

@Data
public class HistorialDocenteClasesDTO {

    private int idHistorialDocente;

    private String numeroCuenta;

    private String nombre;

    private List<Clases> clases;
    
}
