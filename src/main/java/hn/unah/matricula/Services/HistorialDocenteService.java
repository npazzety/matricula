package hn.unah.matricula.Services;

import hn.unah.matricula.Dtos.HistorialDocenteClasesDTO;
import hn.unah.matricula.Entities.HistorialDocente;

public interface HistorialDocenteService {

    public HistorialDocente obteberHistorialDocente(int id);

    public HistorialDocenteClasesDTO obtenerHistorialDocenteClases(HistorialDocenteClasesDTO historial);
    
}
