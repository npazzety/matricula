package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Entities.Clases;

public interface ClasesService {
    
    public List<Clases> obtenerClasesDeDocente(String numeroCuentaDocente);
}
