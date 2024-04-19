package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Services.impl.ExpedienteDocenteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

<<<<<<< HEAD:src/main/java/hn/unah/matricula/Controllers/ExpedienteDocente.java
=======
import hn.unah.matricula.Entities.ExpedienteDocente;


>>>>>>> 628fa494464d18362bf7735c44cc4dd37030f585:src/main/java/hn/unah/matricula/Controllers/ExpedienteDocenteController.java
@RestController
@RequestMapping("api/matricula/expedienteDocente")

public class ExpedienteDocenteController {

    @Autowired
    private ExpedienteDocenteServiceImpl expedienteDocenteServiceImpl;

    @GetMapping("/obtener")    
    public List<ExpedienteDocente> obtenerExpedienteDocente(){
        return this.expedienteDocenteServiceImpl.obtenerExpedientesDocentes();
    }    
    
}
