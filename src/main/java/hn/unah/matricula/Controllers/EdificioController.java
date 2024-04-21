package hn.unah.matricula.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.Edificio;
import hn.unah.matricula.Services.impl.EdificioServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Autowired
    private EdificioServiceImpl edificioServiceImpl;

    @PostMapping("/crear")
    public Edificio crearEdifcio(@RequestBody Edificio edificio) {
        return this.edificioServiceImpl.crearEdificio(edificio);
    }
    
}
