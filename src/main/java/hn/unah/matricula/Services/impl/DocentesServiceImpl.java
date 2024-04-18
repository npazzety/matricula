package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Entities.Docentes;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Services.DocentesService;

@Service
public class DocentesServiceImpl implements DocentesService {


    @Autowired
    private DocentesRepository docentesRepository;
    
    @Override
    public boolean verificarDocente(DatosDocentesDTO docenteVerificar) {

        if (null == this.docentesRepository.findByClave(docenteVerificar.getClave()))
        return false;
    
    Docentes docente = this.docentesRepository.findByClave(docenteVerificar.getClave());
    if (docente.getContraseña().equals(docenteVerificar.getContraseña()))
        return true;

    return false;
    }

    @Override
    public List<Docentes> obtenerDocentes() {
        return (List<Docentes>) this.docentesRepository.findAll();
    }


     
}
