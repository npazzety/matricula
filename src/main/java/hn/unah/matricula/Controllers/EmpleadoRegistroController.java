package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.EmpleadoRegistro;
import hn.unah.matricula.Services.impl.EmpleadoRegistroServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/matricula")
public class EmpleadoRegistroController {
    
    @Autowired
    private EmpleadoRegistroServiceImpl empleadoRegistroServiceImpl;

    @Operation(summary = "Obtiene todos los empleados")
    @GetMapping("/empleado/obtener")    
    public List<EmpleadoRegistro> obtenerempleados(){
        return this.empleadoRegistroServiceImpl.obtenerEmpleados();
    }

    @Operation(summary = "Verifica el login de los empleados")
    @PostMapping("/empleado/verificacion")
    public boolean loginEmpleado(@RequestBody DatosEmpleadosDTO loginempleado){
        return this.empleadoRegistroServiceImpl.verificarEmpleado(loginempleado);
    }

    @Operation(summary = "Obtiene un empleado por clave")
    @GetMapping("/empleado/{clave}")
    public EmpleadoRegistro obtenerEmpleado(@PathVariable String clave) {
        return this.empleadoRegistroServiceImpl.obtenerEmpleado(clave);
    }
    
    @Operation(summary = "Crea un empleado de registro")
    @PostMapping("/empleado/crear")
    public EmpleadoRegistro crearEmpleado(@RequestBody EmpleadoRegistro empleado) {
        return this.empleadoRegistroServiceImpl.crearEmpleado(empleado);
    }
    
}
