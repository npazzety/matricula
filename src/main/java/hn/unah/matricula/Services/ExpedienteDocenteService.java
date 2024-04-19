package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Entities.ExpedienteDocente;


public interface ExpedienteDocenteService {

    public List<ExpedienteDocente> obtenerExpedientesDocentes();

    public ExpedienteDocente obtenerExpedienteDocente(int id);
    
}
