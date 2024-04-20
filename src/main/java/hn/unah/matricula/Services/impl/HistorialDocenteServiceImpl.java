package hn.unah.matricula.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
