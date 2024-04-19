package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Controllers.ExpedienteDocente;
import hn.unah.matricula.Repositories.ExpedienteDocenteRepository;
import hn.unah.matricula.Services.ExpedienteDocenteService;

@Service
public class ExpedienteDocenteServiceImpl implements ExpedienteDocenteService{

    @Autowired
    private ExpedienteDocenteRepository expedienteDocenteRepository;

    @Override
    public List<ExpedienteDocente> obtenerExpedientesDocentes() {

        return (List<ExpedienteDocente>) this.expedienteDocenteRepository.findAll();
        
        }

    @Override
    public ExpedienteDocente obtenerExpedienteDocente(int id) {

        boolean existeExpedienteDocente = this.expedienteDocenteRepository.findById(id).isPresent();

        if (existeExpedienteDocente) {
            return this.expedienteDocenteRepository.findById(id).get();
            
        }
        return null;
    }

    }


