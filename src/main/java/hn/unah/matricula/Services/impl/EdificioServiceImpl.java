package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Entities.Edificio;
import hn.unah.matricula.Repositories.EdificioRepository;
import hn.unah.matricula.Services.EdificioService;

@Service
public class EdificioServiceImpl  implements EdificioService{

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public Edificio crearEdificio(Edificio edificio) {
        return this.edificioRepository.save(edificio);
    }

    @Override
    public List<Edificio> getEdificios() {
        return (List<Edificio>) this.edificioRepository.findAll();
    }
     
}
