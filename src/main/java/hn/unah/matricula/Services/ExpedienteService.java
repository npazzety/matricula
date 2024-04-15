package hn.unah.matricula.Services;

import hn.unah.matricula.Entities.Expediente;

public interface ExpedienteService {

    public Expediente CrearExpediente(Expediente expediente);

    public Expediente obtenerExpediente(int id);
    
}
