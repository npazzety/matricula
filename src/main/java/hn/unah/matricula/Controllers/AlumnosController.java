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
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/matricula")
public class AlumnosController {
    
    @Autowired
    private AlumnosServiceImpl alumnosServiceImpl;


    @Operation(summary = "Crea alumnos")
    @PostMapping("/alumnos/crear")
    public String crearAlumno(@RequestParam("alumno") String alumnoJsonString, @RequestParam("image") MultipartFile image) {
        return this.alumnosServiceImpl.crearAlumno(alumnoJsonString, image);
    }

    @Operation(summary = "obtiene todos los alumnos")
    @GetMapping("/alumnos/obtener")    
    public List<Alumnos> obtenerAlumnos(){
        return this.alumnosServiceImpl.obtenerAlumnos();
    }

    @Operation(summary = "Funcion para verificar los alumnos")
    @PostMapping("/alumnos/verificacion")
    public boolean loginAlumno(DatosAlumnosDto loginalumno){
        return this.alumnosServiceImpl.verificarAlumno(loginalumno);
    }

    @Operation(summary = "Obtine un alumno por id")
    @GetMapping("/alumnos/obtenerPorID")
    public Alumnos obtenerDocentePorId(@RequestParam(name = "id") String id){
        return this.alumnosServiceImpl.obtenerAlumnoPorId(id);
    }
}


