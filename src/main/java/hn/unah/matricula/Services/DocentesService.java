package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Dtos.DocenteDTO;
import hn.unah.matricula.Entities.Docentes;

public interface DocentesService {

    public boolean verificarDocente(DatosDocentesDTO docenteVerificar);

    public List<Docentes> obtenerDocentes();

    public Docentes crearDocente(DocenteDTO docente);
    
}
