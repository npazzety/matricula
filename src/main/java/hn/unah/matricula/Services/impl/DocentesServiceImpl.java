package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosDocentesDTO;
import hn.unah.matricula.Dtos.DocenteDTO;
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
    if (docente.getContrasena().equals(docenteVerificar.getContrasena()))
        return true;

    return false;
    }

    @Override
    public List<Docentes> obtenerDocentes() {
        return (List<Docentes>) this.docentesRepository.findAll();
    }

    @Override
    public Docentes crearDocente(DocenteDTO docente) {

        Docentes nvoDocente = new Docentes();
        nvoDocente.setNombre(docente.getNombre());
        nvoDocente.setApellido(docente.getApellido());
        nvoDocente.setCorreo(docente.getCorreo());
        nvoDocente.setSexo(docente.isSexo());
        nvoDocente.setDepartamento(docente.getDepartamento());
        nvoDocente.setFoto(docente.getFoto());
        return this.docentesRepository.save(nvoDocente);
    }

    @Override
    public Docentes obtenerDocentePorId(String id) {

        boolean existeDocente = this.docentesRepository.findById(id).isPresent();

        if (existeDocente) {
            return this.docentesRepository.findById(id).get();
        }
        return null;
    }
    }

