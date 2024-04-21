package hn.unah.matricula.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.EmpleadoRegistro;
import hn.unah.matricula.Repositories.EmpleadoRegistroRepository;
import hn.unah.matricula.Services.EmpleadoRegistroService;

@Service
public class EmpleadoRegistroServiceImpl implements EmpleadoRegistroService{

    @Autowired
    private ObjectMapper objectMapper;

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
    if (empleado.getContrasena().equals(empleadoVerificar.getContrasena()))
        return true;

    return false;
    }

    @Override
    public EmpleadoRegistro obtenerEmpleado(String clave) {
        return this.empleadoRegistroRepository.findByClave(clave);
    }

    @Override
    public EmpleadoRegistro crearEmpleado(EmpleadoRegistro empleado) {
        objectMapper.registerModule(new JavaTimeModule());
        return this.empleadoRegistroRepository.save(empleado);
    }
    
 


}
