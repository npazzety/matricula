package hn.unah.matricula.Services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.ClasesDTO;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Entities.Prerequisitos;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Repositories.PrerequisitosRepository;
import hn.unah.matricula.Services.ClasesService;

@Service
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private DocentesRepository docentesRepository;

    @Autowired
    private PrerequisitosRepository prerequisitosRepository;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearClases'");
    }

}
    
