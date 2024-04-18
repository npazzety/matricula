package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Dtos.DocenteDTO;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Services.impl.DocentesServiceImpl;

@RestController
@RequestMapping("/api")
public class DocentesController {
    

    @Autowired
    private DocentesServiceImpl docentesServiceImpl;


    @GetMapping("/docentes/obtener")    
    public List<Docentes> obtenerDocentes(){
        return this.docentesServiceImpl.obtenerDocentes();
    }

    @PostMapping("/docente/verificacion")
    public boolean loginDocente(DatosDocentesDTO logindocente){
        return this.docentesServiceImpl.verificarDocente(logindocente);
    }

    @PostMapping("/docente/guardar")
    public Docentes guardarDocente(@RequestBody DocenteDTO docente){
        return this.docentesServiceImpl.crearDocente(docente);
    }
}
