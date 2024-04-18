package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.Coordinador;
import hn.unah.matricula.Repositories.CoordinadorRepository;
import hn.unah.matricula.Services.CoordinadorService;

@Service
public class CoordinadorServiceImpl implements CoordinadorService {

    @Autowired
    private CoordinadorRepository coordinadorRepository;


    @Override
    public List<Coordinador> obtenerEmpleados() {
        return (List<Coordinador>) this.coordinadorRepository.findAll();
    }

    @Override
    public boolean verificarEmpleado(DatosEmpleadosDTO empleadoVerificar) {

          if (null == this.coordinadorRepository.findByClave(empleadoVerificar.getClave()))
            return false;
       
        Coordinador coordinador = this.coordinadorRepository.findByClave(empleadoVerificar.getClave());
        if (coordinador.getContraseña().equals(empleadoVerificar.getContraseña()))
            return true;

        return false;
    }
     
}
