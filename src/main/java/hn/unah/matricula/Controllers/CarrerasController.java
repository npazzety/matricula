package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.CarreraClasesDatosDTO;
import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Services.impl.CarrerasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
<<<<<<< HEAD
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> 9a175a9b89eb971c31b4d994832307c724ef0bcf

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

<<<<<<< HEAD
    @GetMapping("/obtenerCarreraDatos")
    public CarreraClasesDatosDTO getMethodName(@RequestParam CarreraClasesDatosDTO carrera) {
        return this.carrerasServiceImpl.obtenerCarreraDatos(carrera);
    }
    
=======
    
    @GetMapping("/clases")
    public List<Clases> obtenerClasesPorCarrera(@PathVariable String idCarrera) {
        return this.carrerasServiceImpl.obtenerClasesPorCarrera(idCarrera);
    }
>>>>>>> 9a175a9b89eb971c31b4d994832307c724ef0bcf
}
