package hn.unah.matricula.Services;
import java.util.List;

import hn.unah.matricula.Dtos.AlumnoDTO;
import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;


public interface AlumnosService {

    public Alumnos crearAlumno(AlumnoDTO alumno);

    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar);

    public List<Alumnos> obtenerAlumnos();
    
}
