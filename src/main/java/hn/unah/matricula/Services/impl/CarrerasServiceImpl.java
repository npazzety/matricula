package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Dtos.CarrerasClasesDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Repositories.CarrerasRepository;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Services.CarrerasService;

@Service
public class CarrerasServiceImpl implements CarrerasService {

    @Autowired
    private CarrerasRepository carrerasRepository;

    @Autowired
    private DocentesRepository docentesRepo;

    @Override
    public List<Carreras> obtenerCarreras() {
        return (List<Carreras>) this.carrerasRepository.findAll();
    }

    @Override
    public boolean registrarCarrera(CarreraDTO carrera) {
        try {
            Carreras registroCarrera = new Carreras();
            registroCarrera.setNombre(carrera.getNombre());
    
            // buscar el coordinador
            Docentes coordinador = this.docentesRepo.findById(carrera.getCoordinador()).get();
            registroCarrera.setDocentes(coordinador);

            registroCarrera.setCantidadestudiantes(0);
    
            return true; 
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Carreras> obtenerCarrerasPorClase(CarrerasClasesDTO carrerasClasesDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCarrerasPorClase'");
    }

}
