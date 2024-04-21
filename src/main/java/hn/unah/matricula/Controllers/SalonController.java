package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.SalonDTO;
import hn.unah.matricula.Entities.Salon;
import hn.unah.matricula.Services.impl.SalonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/salon")
public class SalonController {

    @Autowired
    private SalonServiceImpl salonServiceImpl;

    @PostMapping("/crear")
    public Salon crearSalon(@RequestBody SalonDTO salon) {
        return this.salonServiceImpl.CrearSalon(salon);
    }
    
}
