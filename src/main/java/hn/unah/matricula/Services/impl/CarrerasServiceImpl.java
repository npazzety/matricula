package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Repositories.CarrerasRepository;
import hn.unah.matricula.Services.CarrerasService;

@Service
public class CarrerasServiceImpl implements CarrerasService {

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Override
    public List<Carreras> obtenerCarreras() {
        return (List<Carreras>) this.carrerasRepository.findAll();
    }
    
}
