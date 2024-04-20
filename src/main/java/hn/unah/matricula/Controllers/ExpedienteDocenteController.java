package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.ExpedienteDocente;
import hn.unah.matricula.Services.impl.ExpedienteDocenteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/matricula/expedienteDocente")

public class ExpedienteDocenteController {

    @Autowired
    private ExpedienteDocenteServiceImpl expedienteDocenteServiceImpl;

    @Operation(summary = "Obtiene todos los expedientes de los docentes")
    @GetMapping("/obtener")    
    public List<ExpedienteDocente> obtenerExpedienteDocente(){
        return this.expedienteDocenteServiceImpl.obtenerExpedientesDocentes();
    }    

    @Operation(summary = "Guarda el expediente de un docente")
    @PostMapping("/guardar")
    public ExpedienteDocente guardarExpedienteDocente(@RequestBody ExpedienteDocente expedienteDocente){
        return this.expedienteDocenteServiceImpl.CrearExpediente(expedienteDocente);
    }
    
    @Operation(summary = "Obtiene el expediente de un docente")
    @GetMapping("/obtenerPorId")
    public ExpedienteDocente obtenerExpedienteDocenteXid(@RequestParam(name = "id") int id){
        return this.expedienteDocenteServiceImpl.obtenerExpedienteDocente(id);
    }
    

}
