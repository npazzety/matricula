package hn.unah.matricula.Services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hn.unah.matricula.Dtos.AlumnoDTO;
import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Services.AlumnosService;
import hn.unah.matricula.util.AlumnoUtil;
import hn.unah.matricula.util.ImageStorage;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Override
    public String crearAlumno(String alumnoJsonString, MultipartFile image) {
        Alumnos nuevoAlumno = new Alumnos();
        AlumnoDTO alumno = null;
        try {
            alumno = objectMapper.readValue(alumnoJsonString, AlumnoDTO.class);
        } catch(JsonProcessingException e) {
            return "No se pudo crear el alumno";
        }
        
        // El correo siempre será único debido a la implementacion usando un set.
        String correo = AlumnoUtil.generarCorreo(alumno.getNombre(), alumno.getApellidos());

        // guarda la imagen
        String imagePath = "";
        try {
            imagePath = ImageStorage.saveImage(image);
        } catch(IOException e) {
            return "No se pudo crear" + e.getMessage();
        }

        String numeroCuenta = AlumnoUtil.crearNumeroCuenta(); 
        nuevoAlumno.setNumeroCuenta(numeroCuenta);
        nuevoAlumno.setNombre(alumno.getNombre());
        nuevoAlumno.setApellido(alumno.getApellidos());
        nuevoAlumno.setSexo(alumno.isSexo());
        nuevoAlumno.setDireccion(alumno.getDireccion());
        nuevoAlumno.setCarrera(alumno.getCarrera());
        nuevoAlumno.setIndice(100);
        nuevoAlumno.setCorreo(correo);        
        nuevoAlumno.setContrasena(alumno.getContrasena());
        nuevoAlumno.setFechaCreacion(LocalDate.now());
        nuevoAlumno.setFoto(imagePath);

        this.alumnosRepository.save(nuevoAlumno);

        return "Se ha creado alumno";
    }

    @Override
    public List<Alumnos> obtenerAlumnos() {
       return (List<Alumnos>) this.alumnosRepository.findAll();
    }


    @Override
    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar) {

        if (null == this.alumnosRepository.findByCorreo(alumnoVerificar.getCorreo()))
            return false;
        // como el alumno existe se comprueba la contrasena
        Alumnos alumno = this.alumnosRepository.findByCorreo(alumnoVerificar.getCorreo());
        if (alumno.getContrasena().equals(alumnoVerificar.getContrasena())){
            return true;
        }
        return false;
    }

    @Override
    public Alumnos obtenerAlumnoPorId(String id) {
        boolean existeAlumno = this.alumnosRepository.findById(id).isPresent();

        if (existeAlumno) {
            return this.alumnosRepository.findById(id).get();
            
        }
        return null;
    }

    

}
