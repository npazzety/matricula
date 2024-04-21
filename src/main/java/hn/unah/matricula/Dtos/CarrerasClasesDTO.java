package hn.unah.matricula.Dtos;

import java.util.List;

import hn.unah.matricula.Entities.Clases;
import lombok.Data;

@Data
public class CarrerasClasesDTO {

    private int idCarrera;

    private String nombre;

    private List<Clases> clases;
    
}
