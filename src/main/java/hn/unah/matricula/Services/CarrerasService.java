package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.CarreraClasesDatosDTO;
import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Dtos.CarrerasClasesDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;

public interface CarrerasService {
    

    public List<Carreras> obtenerCarreras();

    public boolean registrarCarrera(CarreraDTO carrera); 

    public CarreraClasesDatosDTO obtenerCarreraDatos(CarreraClasesDatosDTO infocarrera);
    
    public List<Carreras> obtenerCarrerasPorClase(CarrerasClasesDTO carrerasClasesDTO);

    public List<Clases> obtenerClasesPorCarrera(String idCarrera); 

}
