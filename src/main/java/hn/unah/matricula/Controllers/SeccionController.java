package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.SeccionDTO;
import hn.unah.matricula.Entities.Seccion;
import hn.unah.matricula.Services.impl.SeccionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/seccion")
public class SeccionController {

    @Autowired
    private SeccionServiceImpl seccionServiceImpl;


    @PostMapping("/crear")
    public Seccion crearSeccion(@RequestParam SeccionDTO seccion) {
        return this.seccionServiceImpl.CrearSeccion(seccion);
    }
    
    
}
