package hn.unah.matricula.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Entities.Expediente;

public interface ExpedienteService {

    public boolean crearExpediente(String expediente, MultipartFile image);

    public Expediente obtenerExpediente(int id);

    public List<Expediente> obtenerExpedientes();
    
}
