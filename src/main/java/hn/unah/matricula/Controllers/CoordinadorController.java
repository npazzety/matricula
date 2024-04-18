package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosEmpleadosDTO;
import hn.unah.matricula.Entities.Coordinador;
import hn.unah.matricula.Services.impl.CoordinadorServiceImpl;

@RestController
@RequestMapping("/api")
public class CoordinadorController {
    
    @Autowired
    private CoordinadorServiceImpl coordinadorServiceImpl;


    @GetMapping("/coordinador/obtener")    
    public List<Coordinador> obtenerempleados(){
        return this.coordinadorServiceImpl.obtenerEmpleados();
    }

    @PostMapping("/coordinador/verificacion")
    public boolean loginEmpleado(DatosEmpleadosDTO loginempleado){
        return this.coordinadorServiceImpl.verificarEmpleado(loginempleado);
    }
}
