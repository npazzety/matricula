package hn.unah.matricula.Services;

import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Entities.Expediente;

public interface ExpedienteService {

    public boolean crearExpediente(String alumno, MultipartFile image);

    public Expediente obtenerExpediente(int id);
    
}
