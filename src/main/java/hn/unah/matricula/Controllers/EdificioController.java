package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.Edificio;
import hn.unah.matricula.Services.impl.EdificioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Autowired
    private EdificioServiceImpl edificioServiceImpl;

    @Operation(summary = "crea un edificio")
    @PostMapping("/crear")
    public Edificio crearEdifcio(@RequestBody Edificio edificio) {
        return this.edificioServiceImpl.crearEdificio(edificio);
    }
   
    @Operation(summary = "obtiene lista de edificios")
    @GetMapping("/obtener/edificios")
    public List<Edificio> getEdificio() {
        return this.edificioServiceImpl.getEdificios();
    }
}
