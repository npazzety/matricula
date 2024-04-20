package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Services.impl.AlumnosServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/matricula")
public class AlumnosController {
    
    @Autowired
    private AlumnosServiceImpl alumnosServiceImpl;

    @PostMapping("/alumnos/crear")
    public String crearAlumno(@RequestParam("alumno") String alumnoJsonString, @RequestParam("image") MultipartFile image) {
        return this.alumnosServiceImpl.crearAlumno(alumnoJsonString, image);
    }

    @GetMapping("/alumnos/obtener")    
    public List<Alumnos> obtenerAlumnos(){
        return this.alumnosServiceImpl.obtenerAlumnos();
    }

    @PostMapping("/alumnos/verificacion")
    public boolean loginAlumno(DatosAlumnosDto loginalumno){
        return this.alumnosServiceImpl.verificarAlumno(loginalumno);
    }

}


