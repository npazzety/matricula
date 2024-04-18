package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.EmpleadoRegistro;
import hn.unah.matricula.Services.impl.EmpleadoRegistroServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoRegistroController {
    
    @Autowired
    private EmpleadoRegistroServiceImpl empleadoRegistroServiceImpl;

    @GetMapping("/empleado/obtener")    
    public List<EmpleadoRegistro> obtenerempleados(){
        return this.empleadoRegistroServiceImpl.obtenerEmpleados();
    }

    @PostMapping("/empleado/verificacion")
    public boolean loginEmpleado(DatosEmpleadosDTO loginempleado){
        return this.empleadoRegistroServiceImpl.verificarEmpleado(loginempleado);
    }
}
