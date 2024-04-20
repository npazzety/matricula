package hn.unah.matricula.Services.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.HistorialDocenteClasesDTO;
import hn.unah.matricula.Entities.Carreras;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Entities.HistorialDocente;
import hn.unah.matricula.Repositories.HistorialDocenteRepository;
import hn.unah.matricula.Services.HistorialDocenteService;

@Service
public class HistorialDocenteServiceImpl implements HistorialDocenteService{

    @Autowired
    private HistorialDocenteRepository historialDocenteRepository;

    @Override
    public HistorialDocente obteberHistorialDocente(int id) {
        boolean existeExpediente = this.historialDocenteRepository.findById(id).isPresent();

        if (existeExpediente) {
            return this.historialDocenteRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public HistorialDocenteClasesDTO obtenerHistorialDocenteClases(HistorialDocenteClasesDTO historial) {

        Optional<HistorialDocente> historialDocenteOptional = historialDocenteRepository.findById(historial.getIdHistorialDocente());

        if (historialDocenteOptional.isPresent()) {
        HistorialDocente historialDocente = historialDocenteOptional.get();
        
        // Obtener el docente del historial
        Docentes docente = historialDocente.getDocentes();
        
        // Verificar si el docente existe
        if (docente != null) {
            // Obtener el número de cuenta del docente
            String numeroCuenta = docente.getNumeroCuenta();
    
            Carreras carrera = docente.getCarreras();

            List<Clases> clases = carrera.getClases();
 
            historial.setNumeroCuenta(numeroCuenta);
            historial.setNombre(docente.getNombre());
            historial.setClases(clases);

            this.historialDocenteRepository.save(historial);
    
            return historial;
       }
       return null;
    }
    return null;
    }
}