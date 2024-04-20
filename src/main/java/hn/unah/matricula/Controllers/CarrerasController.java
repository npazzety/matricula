package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Services.impl.CarrerasServiceImpl;

@RestController
@RequestMapping("/api")
public class CarrerasController {

    @Autowired
    private CarrerasServiceImpl carrerasServiceImpl;

    @GetMapping("/carreras/obtener")    
    public List<Carreras> obtenerAlumnos(){
        return this.carrerasServiceImpl.obtenerCarreras();
    }
}
