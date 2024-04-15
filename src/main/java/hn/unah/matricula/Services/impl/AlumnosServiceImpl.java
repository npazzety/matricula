package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Services.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Override
    //obtiene la lista alumnos
    public List<Alumnos> obtenerAlumnos() {
        return (List<Alumnos>) this.alumnosRepository.findAll();
    }
    
    @Override
    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar) {
        
        for(Alumnos alumno: obtenerAlumnos()){
            if (alumno.getCorreo().equals(alumnoVerificar.getCorreo())){
                //existe correo
                if (alumno.getContraseña().equals(alumnoVerificar.getContrseña())){
                    return true; //Contraeña igual
               } 
            }
        }
        return false; // no existe correo
    }
}
