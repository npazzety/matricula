package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.EmpleadoRegistro;
import hn.unah.matricula.Repositories.EmpleadoRegistroRepository;
import hn.unah.matricula.Services.EmpleadoRegistroService;

@Service
public class EmpleadoRegistroServiceImpl implements EmpleadoRegistroService{

    @Autowired
    private EmpleadoRegistroRepository empleadoRegistroRepository;

    @Override
    public List<EmpleadoRegistro> obtenerEmpleados() {
        return (List<EmpleadoRegistro>) this.empleadoRegistroRepository.findAll();
    }

    @Override
    public boolean verificarEmpleado(DatosEmpleadosDTO empleadoVerificar) {

        if (null == this.empleadoRegistroRepository.findByClave(empleadoVerificar.getClave()))
        return false;
   
    EmpleadoRegistro empleado = this.empleadoRegistroRepository.findByClave(empleadoVerificar.getClave());
    if (empleado.getContraseña().equals(empleadoVerificar.getContrasena()))
        return true;

    return false;
    }
    
 


}
