package hn.unah.matricula.Services;
import hn.unah.matricula.CreateAlumnoDTO;
import hn.unah.matricula.Entities.Alumnos;


public interface AlumnosService {

    public Alumnos crearAlumno(CreateAlumnoDTO alumno);
    
}
