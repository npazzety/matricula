package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Services.impl.ExpedienteDocenteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/matricula/expedienteDocente")

public class ExpedienteDocente {

    @Autowired
    private ExpedienteDocenteServiceImpl expedienteDocenteServiceImpl;

    @GetMapping("/obtener")    
    public List<ExpedienteDocente> obtenerExpedienteDocente(){
        return this.expedienteDocenteServiceImpl.obtenerExpedientesDocentes();
    }    
    
}
