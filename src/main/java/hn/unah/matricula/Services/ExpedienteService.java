package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Entities.Expediente;

public interface ExpedienteService {

    public Expediente CrearExpediente(Expediente expediente);

    public boolean eliminarUsuario(int id);

    public Expediente obtenerExpediente(int id);

    public List<Expediente> obtenerExpedientes();
    
}
