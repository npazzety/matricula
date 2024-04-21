package hn.unah.matricula.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.RequisitosClaseDTO;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Entities.Prerequisitos;
import hn.unah.matricula.Repositories.ClasesRepository;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Repositories.PrerequisitosRepository;
import hn.unah.matricula.Services.ClasesService;

@Service
public class ClasesServiceImpl implements ClasesService {

    @Autowired
    private DocentesRepository docentesRepository;

    @Autowired
    private ClasesRepository clasesRepository;

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
    public RequisitosClaseDTO obtenerRequisitosClases(RequisitosClaseDTO requisitos) {

         // Verificar la existencia de la clase y el prerequisito
    Optional<Clases> claseOptional = clasesRepository.findById(requisitos.getIdClase());
    Optional<Clases> prerequisitoOptional = clasesRepository.findById(requisitos.getIdPrerequisito());

    if (claseOptional.isPresent() && prerequisitoOptional.isPresent()) {
        // Obtener los prerequisitos de la clase
        Optional<Prerequisitos> prerequisitosClase = prerequisitosRepository.findById(requisitos.getIdClase());

        if (prerequisitosClase.isPresent()) {

       
            requisitos.setIdClase(0);
            requisitos.setClases(null);
               
            return requisitos;

            }    
        return null;
    }

    return null;
    
    }
}
