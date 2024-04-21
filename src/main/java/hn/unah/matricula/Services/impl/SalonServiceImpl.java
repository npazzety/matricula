package hn.unah.matricula.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.SalonDTO;
import hn.unah.matricula.Entities.Salon;
import hn.unah.matricula.Repositories.EdificioRepository;
import hn.unah.matricula.Repositories.SalonRepository;
import hn.unah.matricula.Services.SalonService;

@Service
public class SalonServiceImpl  implements SalonService{

    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public Salon CrearSalon(SalonDTO salon) {

        Salon nvosalon = new Salon();
        
        

        nvosalon.setNombre(salon.getNombre());
        nvosalon.setEdifio(this.edificioRepository.findById(salon.getIdEdificio()).get());
        nvosalon.setCapacidad(salon.getCapacidad());
        nvosalon.setObservacion(salon.getObservacion());

        return this.salonRepository.save(nvosalon);
       
    }
    
}
