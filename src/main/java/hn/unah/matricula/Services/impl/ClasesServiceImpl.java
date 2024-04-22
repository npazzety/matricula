package hn.unah.matricula.Services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.ClasesCardDTO;
import hn.unah.matricula.Dtos.ClasesDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Entities.Prerequisitos;
import hn.unah.matricula.Entities.Seccion;
import hn.unah.matricula.Repositories.CarrerasRepository;
import hn.unah.matricula.Repositories.ClasesRepository;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Repositories.PrerequisitosRepository;
import hn.unah.matricula.Services.ClasesService;

@Service
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private DocentesRepository docentesRepository;

    @Autowired
    private PrerequisitosRepository prerequisitosRepository;

    @Autowired
    private CarrerasRepository carreraRepo;

    @Autowired
    private ClasesRepository clasesRepository;

    @Override
    public List<Clases> obtenerClasesDeDocente(String numeroCuentaDocente) {

        Docentes docente = docentesRepository.findById(numeroCuentaDocente).orElse(null);
        if (docente == null) {
            throw new RuntimeException("No se encontró el docente con ID: " + numeroCuentaDocente);
        }
        
        // Obtener las clases asociadas a las carreras del docente
        List<Clases> clases = docente.getCarreras().getClases();

        return clases;
    }

    @Override
    public List<Clases> obtenerRequisitosDeClases(int idClase) {
        
        Prerequisitos prerequisitos = prerequisitosRepository.findById(idClase).orElse(null);
        if (prerequisitos == null) {
            throw new RuntimeException("No se encontró el requisito de la clase con id : " + idClase);
        }
        
        // Obtener los requisitos de la clase
        List<Clases> clases = prerequisitos.getClases();
        
        return clases;
    }

    @Override
    public Clases crearClases(ClasesDTO clases) {
        Clases nvoclase = new Clases();
        nvoclase.setCodigo(clases.getCodigo());
        nvoclase.setNombre(clases.getNombre());
        nvoclase.setUv(clases.getUv());

        // se asocia con la carrera
        Carreras carrera = this.carreraRepo.findById(clases.getIdCarrera()).get();
        if (!(carrera.getClases().contains(nvoclase))) {
            carrera.getClases().add(nvoclase);
            this.carreraRepo.save(carrera);
        }
        nvoclase.setCarrera(carrera);

        return this.clasesRepository.save(nvoclase);
    }

    @Override
    public List<ClasesCardDTO> obtenerSeccionesDocente(String numeroCuentaDocente) {
       
        Docentes docente = docentesRepository.findById(numeroCuentaDocente).orElse(null);
        if (docente == null) {
            throw new RuntimeException("No se encontró el docente con ID: " + numeroCuentaDocente);
        }
        
        List<ClasesCardDTO> secciones = new ArrayList<>();
        for (Seccion seccion : docente.getSecciones()) {
            Clases clase = seccion.getClases();

            ClasesCardDTO claseCard = new ClasesCardDTO();
            claseCard.setNombre(clase.getNombre());
            claseCard.setCodigo(clase.getCodigo());
            claseCard.setUv(clase.getUv());
            claseCard.setIdseccion(seccion.getIdSeccion());
            secciones.add(claseCard);
        }
        return secciones;
    }

    @Override
    public List<Clases> obtenerClases() {
        return (List<Clases>) this.clasesRepository.findAll();
    }

    
}
    
