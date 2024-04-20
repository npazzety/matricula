package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.AlumnoDTO;
import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Services.impl.AlumnosServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AlumnosController {
    
    @Autowired
    private AlumnosServiceImpl alumnosServiceImpl;

    @PostMapping("/alumnos/crear")
    public boolean crearAlumno(@RequestBody AlumnoDTO alumno) {
        return this.alumnosServiceImpl.crearAlumno(alumno);
    }

    @GetMapping("/alumnos/obtener")    
    public List<Alumnos> obtenerAlumnos(){
        return this.alumnosServiceImpl.obtenerAlumnos();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/alumno/verificacion")
    public boolean loginAlumno(@RequestBody DatosAlumnosDto loginalumno){
        return this.alumnosServiceImpl.verificarAlumno(loginalumno);
    }

    @GetMapping("/alumnos/{id}")
    public Alumnos getAlumnoPorId(@PathVariable String id) {
        return alumnosServiceImpl.getAlumnoPorId(id);
    }
    

    @GetMapping("/alumno/correo/{correo}")
    public Alumnos getAlumnoPorCorreo(@PathVariable String correo) {
        return this.alumnosServiceImpl.getAlumnoPorCorreo(correo);
    }
    
}


