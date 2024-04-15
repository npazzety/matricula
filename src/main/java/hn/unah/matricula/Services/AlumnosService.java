package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;

public interface AlumnosService {

    public List<Alumnos> obtenerAlumnos();


    public boolean verificarAlumno(DatosAlumnosDto alumno);
    
}
