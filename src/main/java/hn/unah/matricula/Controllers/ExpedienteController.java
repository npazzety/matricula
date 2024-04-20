package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Entities.Expediente;
import hn.unah.matricula.Services.impl.ExpedienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/expediente")

public class ExpedienteController {

    @Autowired
    private ExpedienteServiceImpl expedienteServiceImpl;


    @PostMapping("/guardar")
    public boolean GuardarExpediente(@RequestParam("alumno") String alumnoJsonString, @RequestParam("image") MultipartFile image) {
        return this.expedienteServiceImpl.crearExpediente(alumnoJsonString, image);
    }
    
    @GetMapping("/obtener/{id}")
    public Expediente obtenerXid(@PathVariable int id) {
        return this.expedienteServiceImpl.obtenerExpediente(id);
    }

    @GetMapping("/alumnos/obtener")
    public List<Expediente> getExpedientesEstudiantes() {
        return this.expedienteServiceImpl.obtenerExpedientes();
    }
    
    
    
}
