package hn.unah.matricula.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Entities.Docentes;

public interface DocentesService {

    public boolean verificarDocente(DatosDocentesDTO docenteVerificar);

    public List<Docentes> obtenerDocentes();

    public Docentes crearDocente(String docente, MultipartFile image);

    public Docentes obtenerDocentePorId(String id);

    public List<Docentes> obtenerCoordinadores();

    public Docentes getDocentePorClave(String clave);
    
}
