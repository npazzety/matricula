package hn.unah.matricula.Dtos;

import java.util.List;

import hn.unah.matricula.Entities.Clases;
import lombok.Data;

@Data
public class RequisitosClaseDTO {

    private int idClase;

    private int idPrerequisito;
    
    private String codigo;

    private String nombre;

    private List<Clases> clases;




    
    
}
