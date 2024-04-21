package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Entities.Carreras;

import hn.unah.matricula.Services.impl.CarrerasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/matricula/carreras")
public class CarrerasController {

    @Autowired
    private CarrerasServiceImpl carrerasServiceImpl;


    @Operation(summary = "Obtiene todas las carrearas")
    @GetMapping("/obtener")    
    public List<Carreras> obtenerCarreras(){
        return this.carrerasServiceImpl.obtenerCarreras();
    }
    
    @Operation(summary = "Registra/crea una carrera")
    @PostMapping("/registrar")
    public boolean crearCarrera(@RequestBody CarreraDTO carrera) {
        try {
            return this.carrerasServiceImpl.registrarCarrera(carrera);
        } catch(Exception e) {
            return false;
        }
    }
}
