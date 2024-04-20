package hn.unah.matricula.Services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import hn.unah.matricula.Dtos.AlumnoDTO;
import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Expediente;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Repositories.CarrerasRepository;
import hn.unah.matricula.Repositories.ExpedienteRepository;
import hn.unah.matricula.Services.AlumnosService;
import hn.unah.matricula.util.AlumnoUtil;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;
    
    @Autowired
    ObjectMapper objectMapper;
    
    @Autowired
    CarrerasRepository carreraRepo;
    
    @Autowired
    ExpedienteRepository expedienteRepo;
    
    @Override
    public boolean crearAlumno(AlumnoDTO alumno) {
        try {
            
            Alumnos nuevoAlumno = new Alumnos();
            
            // El correo siempre será único debido a la implementacion usando un set.
            String correo = AlumnoUtil.generarCorreo(alumno.getNombre(), alumno.getApellidos());
            String numeroCuenta = AlumnoUtil.crearNumeroCuenta(); 
            
            Carreras carrera = carreraRepo.findByNombre(alumno.getNombre());
            if (null != carrera) {
                carrera.setCantidadestudiantes(carrera.getCantidadestudiantes() + 1);
                carrera = this.carreraRepo.save(carrera);
            }

            Expediente expediente = this.expedienteRepo.findById(alumno.getIdExpediente()).get();
            expediente.setAceptado(true);
            this.expedienteRepo.save(expediente);
            
            nuevoAlumno.setNumeroCuenta(numeroCuenta);
            nuevoAlumno.setNombre(alumno.getNombre());
            nuevoAlumno.setApellido(alumno.getApellidos());
            nuevoAlumno.setSexo(alumno.isSexo());
            nuevoAlumno.setDireccion(alumno.getDireccion());
            nuevoAlumno.setCarrera(carrera);
            nuevoAlumno.setIndice(100);
            nuevoAlumno.setCorreo(correo);        
            nuevoAlumno.setContrasena(alumno.getContrasena());
            nuevoAlumno.setFechaCreacion(LocalDate.now());
            nuevoAlumno.setFoto(alumno.getFoto());
            nuevoAlumno.setExpediente(expediente); 
            
            this.alumnosRepository.save(nuevoAlumno);
    
            return true;
        } catch(Error e) {
            return false;
        }
    }
    
    @Override
    public List<Alumnos> obtenerAlumnos() {
       return (List<Alumnos>) this.alumnosRepository.findAll();
    }
    
    
    @Override
    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar) {

        if (null == this.alumnosRepository.findById(alumnoVerificar.getNumeroCuenta()))
            return false;
            // como el alumno existe se comprueba la contrasena
        Alumnos alumno = this.alumnosRepository.findById(alumnoVerificar.getNumeroCuenta()).get();
        if (alumno.getContrasena().equals(alumnoVerificar.getContrasena())){
            return true;
        }
        return false;
    }

    @Override
    public Alumnos getAlumnoPorCorreo(String correo) {
        objectMapper.registerModule(new JavaTimeModule());
        String correoCompleto = correo + "@unah.hn";
        return this.alumnosRepository.findByCorreo(correoCompleto);
    }
    
    @Override
    public Alumnos getAlumnoPorId(String id) {
        objectMapper.registerModule(new JavaTimeModule());
        return this.alumnosRepository.findById(id).get();

    }


}
