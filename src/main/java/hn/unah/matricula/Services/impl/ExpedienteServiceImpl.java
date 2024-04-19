package hn.unah.matricula.Services.impl;

import java.util.List;

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

    @Override
    public List<Expediente> obtenerExpedientes() {
        return (List<Expediente>) this.expedienteRepository.findAll();
    }

    @Override
    public boolean eliminarUsuario(int id) {
        try{
            expedienteRepository.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }
    }

}
