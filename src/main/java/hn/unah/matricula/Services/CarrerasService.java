package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Entities.Carreras;

public interface CarrerasService {
    

    public List<Carreras> obtenerCarreras();

    public boolean registrarCarrera(CarreraDTO carrera); 
}
