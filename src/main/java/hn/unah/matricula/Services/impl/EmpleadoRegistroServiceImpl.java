package hn.unah.matricula.Services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Dtos.EmpleadoRegistroDTO;
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
    if (empleado.getContrasena().equals(empleadoVerificar.getContrasena()))
        return true;

    return false;
    }

    @Override
    public EmpleadoRegistro obtenerEmpleado(String clave) {
        return this.empleadoRegistroRepository.findByClave(clave);
    }


    @Override
    public EmpleadoRegistro crearEmpleadoRegistro(EmpleadoRegistroDTO empleado) {

        Date fechaacual = new Date();
        fechaacual.getTime();

        String idempleado = "";
        for(int i = 0; i < 7; i++) 
          idempleado += Integer.toString((int) Math.floor(Math.random() * 10));

        String clave = "";
        for(int i = 0; i < 5; i++) 
        idempleado += Integer.toString((int) Math.floor(Math.random() * 10));

          EmpleadoRegistro nvoEmpleadoRegistro = new EmpleadoRegistro();

          nvoEmpleadoRegistro.setIdEmpleado(idempleado);
          nvoEmpleadoRegistro.setNombre(empleado.getNombre());
          nvoEmpleadoRegistro.setApellido(empleado.getApellido());
          nvoEmpleadoRegistro.setDireccion(empleado.getDireccion());
          nvoEmpleadoRegistro.setCorreo(empleado.getCorreo());
          nvoEmpleadoRegistro.setTelefono(empleado.getTelefono());
          nvoEmpleadoRegistro.setSexo(empleado.isSexo());
          nvoEmpleadoRegistro.setContrasena(empleado.getContrasena());
          nvoEmpleadoRegistro.setFechaContratacion(fechaacual);
          nvoEmpleadoRegistro.setClave(clave);
         
          return this.empleadoRegistroRepository.save(nvoEmpleadoRegistro);
    }


}
