package hn.unah.matricula.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.matricula.Dtos.CarreraClasesDatosDTO;
import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Services.impl.CarrerasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/matricula/carreras")
public class CarrerasController {

    @Autowired
    private CarrerasServiceImpl carrerasServiceImpl;


    @Operation(summary = "Obtiene todas las carrearas")
    @CrossOrigin(origins = "*")
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

    @GetMapping("/obtenerCarreraDatos")
    public CarreraClasesDatosDTO getMethodName(@RequestParam CarreraClasesDatosDTO carrera) {
        return this.carrerasServiceImpl.obtenerCarreraDatos(carrera);
    }
    
    @Operation(summary = "obtiene clases de una carrera")
    @CrossOrigin(origins = "*")
    @GetMapping("/{idCarrera}/clases")
    public List<Clases> obtenerClasesPorCarrera(@PathVariable String idCarrera) {
        return this.carrerasServiceImpl.obtenerClasesPorCarrera(idCarrera);
    }

}
