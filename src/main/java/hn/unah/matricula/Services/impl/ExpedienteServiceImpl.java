package hn.unah.matricula.Services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hn.unah.matricula.Dtos.AlumnoExpedienteDTO;
import hn.unah.matricula.Entities.Expediente;
import hn.unah.matricula.Repositories.ExpedienteRepository;
import hn.unah.matricula.Services.ExpedienteService;
import hn.unah.matricula.util.ImageStorage;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{

    @Autowired
    private ExpedienteRepository expedienteRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean crearExpediente(String alumnoJsonString, MultipartFile image) {
       Expediente expediente = new Expediente();
       AlumnoExpedienteDTO alumnoExpediente = null;
       
       try {
            alumnoExpediente = objectMapper.readValue(alumnoJsonString, AlumnoExpedienteDTO.class);
        } catch(JsonProcessingException e) {
            return false;
        }

        // guarda la imagen
        String imagePath = "";
        try {
            imagePath = ImageStorage.saveImage(image);
        } catch(IOException e) {
            return false;
        }

        expediente.setApellidos(alumnoExpediente.getApellidos());
        expediente.setCarrera(alumnoExpediente.getCarrera());
        expediente.setCorreo(alumnoExpediente.getCorreo());
        expediente.setDireccion(alumnoExpediente.getDireccion());
        expediente.setNombres(alumnoExpediente.getNombres());
        expediente.setSexo(alumnoExpediente.isSexo());
        expediente.setFoto(imagePath);
        this.expedienteRepo.save(expediente);
        return true;
    }

    @Override
    public Expediente obtenerExpediente(int id) {
        boolean existeExpediente = this.expedienteRepo.findById(id).isPresent();

        if (existeExpediente) {
            return this.expedienteRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public List<Expediente> obtenerExpedientes() {
       return (List<Expediente>) expedienteRepo.findAll(); 
    }

    @Override
    public String eliminarExpediente(int id) {

        if(this.expedienteRepo.existsById(id)){
            this.expedienteRepo.deleteById(id);
            return "Expediente eliminado";
        }        

        return "No existe el Expediente";
    }


    
    
}
