package hn.unah.matricula.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Entities.Expediente;
import hn.unah.matricula.Repositories.ExpedienteRepository;
import hn.unah.matricula.Services.ExpedienteService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{

    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Override
    public Expediente CrearExpediente(Expediente expediente) {
        return this.expedienteRepository.save(expediente);
    }

    @Override
    public Expediente obtenerExpediente(int id) {
        boolean existeExpediente = this.expedienteRepository.findById(id).isPresent();

        if (existeExpediente) {
            return this.expedienteRepository.findById(id).get();
        }
        return null;
    }


    
}
