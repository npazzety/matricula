package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.EmpleadoRegistro;

public interface EmpleadoRegistroService {
 
    public List<EmpleadoRegistro> obtenerEmpleados();

    public boolean verificarEmpleado(DatosEmpleadosDTO empleadoVerificar);
    
    public EmpleadoRegistro obtenerEmpleado(String clave);

    public EmpleadoRegistro crearEmpleado(EmpleadoRegistro empleado);
}
