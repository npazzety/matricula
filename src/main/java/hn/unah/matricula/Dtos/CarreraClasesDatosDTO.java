package hn.unah.matricula.Dtos;

import java.util.List;

import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Prerequisitos;
import hn.unah.matricula.Entities.Seccion;
import lombok.Data;

@Data
public class CarreraClasesDatosDTO {

    private int idCarrera;

    private List<Clases> clases;

    private List<Prerequisitos> prerequisitos;

    private List<Seccion> seccion;
    
}
