package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Services.impl.AlumnosServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class AlumnosController {
    
    @Autowired
    private AlumnosServiceImpl alumnosServiceImpl;

    @GetMapping("/alumno/obtener")    
    public List<Alumnos> obtenerAlumnos(){
        return this.alumnosServiceImpl.obtenerAlumnos();
    }

    @PostMapping("/alumno/verificacion")
    public String loginAlumno(DatosAlumnosDto loginalumno){
        if(this.alumnosServiceImpl.verificarAlumno(loginalumno) == true){
            return "Alumno verificado";
        }
        return "Alumno no verificado";
    }

}


