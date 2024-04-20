package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Entities.Expediente;
import hn.unah.matricula.Services.impl.ExpedienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/matricula/expediente")

public class ExpedienteController {

    @Autowired
    private ExpedienteServiceImpl expedienteServiceImpl;


    @Operation(summary = "Guarda el expediente de alumno")
    @PostMapping("/guardar")
    public boolean GuardarExpediente(@RequestParam("alumno") String alumnoJsonString, @RequestParam("image") MultipartFile image) {
        return this.expedienteServiceImpl.crearExpediente(alumnoJsonString, image);
    }
    
    @Operation(summary = "Obtiene el expediente del alumno por id")
    @GetMapping("/obtener/{id}")
    public Expediente obtenerXid(@PathVariable int id) {
        return this.expedienteServiceImpl.obtenerExpediente(id);
    }

    @Operation(summary = "Obtiene todos los expedientes de los alumnos")
    @GetMapping("/alumnos/obtener")
    public List<Expediente> getExpedientesEstudiantes() {
        return this.expedienteServiceImpl.obtenerExpedientes();
    }
    
    @Operation(summary = "Elimina expediente alumno por medio de un id")
    @DeleteMapping("/eliminar")
    public String eliminarExpediente(@RequestParam (name = "id") int id) {
        return this.expedienteServiceImpl.eliminarExpediente(id);
    }

}
