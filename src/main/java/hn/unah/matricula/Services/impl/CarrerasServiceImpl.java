package hn.unah.matricula.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.matricula.Dtos.CarreraClasesDatosDTO;
import hn.unah.matricula.Dtos.CarreraDTO;
import hn.unah.matricula.Dtos.CarrerasClasesDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;
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
            this.carrerasRepository.save(registroCarrera);
            return true; 
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CarreraClasesDatosDTO obtenerCarreraDatos(CarreraClasesDatosDTO infocarrera) {
        Optional<Carreras> carreraOptional = carrerasRepository.findById(infocarrera.getIdCarrera());

        if (carreraOptional.isPresent()) {
        Carreras carreraexist = carreraOptional.get();

        List<Clases> clases = carreraexist.getClases();
        infocarrera.setClases(clases);

        return infocarrera ;
        }

        return null;
    }

   

    @Override
    public List<Clases> obtenerClasesPorCarrera(String idCarrera) {
        Carreras carrera = this.carrerasRepository.findById(Integer.parseInt(idCarrera)).get();
        return carrera.getClases();
    }

    @Override
    public List<Carreras> obtenerCarrerasPorClase(CarrerasClasesDTO carrerasClasesDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCarrerasPorClase'");
    }

}
