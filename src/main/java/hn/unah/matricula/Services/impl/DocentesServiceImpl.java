package hn.unah.matricula.Services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Dtos.DocenteDTO;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Services.DocentesService;
import hn.unah.matricula.util.AlumnoUtil;
import hn.unah.matricula.util.DocenteUtil;
import hn.unah.matricula.util.ImageStorage;

@Service
public class DocentesServiceImpl implements DocentesService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DocentesRepository docentesRepository;
    
    @Override
    public boolean verificarDocente(DatosDocentesDTO docenteVerificar) {

        if (null == this.docentesRepository.findByClave(docenteVerificar.getClave()))
        return false;
    
    Docentes docente = this.docentesRepository.findByClave(docenteVerificar.getClave());
    if (docente.getContrasena().equals(docenteVerificar.getContrasena()))
        return true;

    return false;
    }

    @Override
    public List<Docentes> obtenerDocentes() {
        return (List<Docentes>) this.docentesRepository.findAll();
    }

    @Override
    public Docentes crearDocente(String docenteJsonString, MultipartFile image) {
        DocenteDTO docente = null;
        try {
            docente = objectMapper.readValue(docenteJsonString, DocenteDTO.class); 
        } catch(JsonProcessingException e) {
            return null;
        }

        String imagePath = "";
        try {
            imagePath = ImageStorage.saveImage(image);
        } catch(IOException e) {
            return null;
        }

        String numeroCuenta = AlumnoUtil.crearNumeroCuenta();
        String clave = DocenteUtil.generarClave();
        String correo = AlumnoUtil.generarCorreo(docente.getNombre(), docente.getApellido());

        Docentes nvoDocente = new Docentes();
        nvoDocente.setNumeroCuenta(numeroCuenta);
        nvoDocente.setClave(clave);
        nvoDocente.setNombre(docente.getNombre());
        nvoDocente.setApellido(docente.getApellido());
        nvoDocente.setCoordinador(docente.isCoordinador());
        nvoDocente.setEspecializacion(docente.getEspecilizacion());
        nvoDocente.setContrasena(docente.getContrasena());
        nvoDocente.setCorreo(correo);
        nvoDocente.setSexo(docente.isSexo());
        nvoDocente.setDireccion(docente.getDepartamento());
        nvoDocente.setFechaContratacion(LocalDate.now());
        nvoDocente.setFoto(imagePath);
        return this.docentesRepository.save(nvoDocente);
    }

    @Override
    public Docentes obtenerDocentePorId(String id) {

        boolean existeDocente = this.docentesRepository.findById(id).isPresent();

        if (existeDocente) {
            return this.docentesRepository.findById(id).get();
            
        }
        return null;
    }

    @Override
    public List<Docentes> obtenerCoordinadores() {
        ArrayList<Docentes> coordinadores = new ArrayList<>();
        List<Docentes> docentes = (List<Docentes>) this.docentesRepository.findAll();

        for (Docentes docente : docentes) {
            if (docente.isCoordinador())
              coordinadores.add(docente);
        }

        return coordinadores;
    }
}

