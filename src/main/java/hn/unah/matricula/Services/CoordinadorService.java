package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.Coordinador;

public interface CoordinadorService {
 
    public List<Coordinador> obtenerEmpleados();

    public boolean verificarEmpleado(DatosEmpleadosDTO empleadoVerificar);
}
