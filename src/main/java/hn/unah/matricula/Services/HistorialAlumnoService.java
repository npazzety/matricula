package hn.unah.matricula.Services;

import hn.unah.matricula.Dtos.DatosHistorialAlumnoDTO;
import hn.unah.matricula.Entities.HistorialAlumno;

public interface HistorialAlumnoService {

    public HistorialAlumno obtenerHistorial(DatosHistorialAlumnoDTO historial);
    
}
