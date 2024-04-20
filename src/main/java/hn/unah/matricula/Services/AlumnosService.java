package hn.unah.matricula.Services;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;


public interface AlumnosService {

    public String crearAlumno(String alumno, MultipartFile image);

    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar);

    public List<Alumnos> obtenerAlumnos();

    public Alumnos obtenerAlumnoPorId(String id);
    
}
