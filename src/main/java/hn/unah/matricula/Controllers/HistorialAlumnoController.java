package hn.unah.matricula.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.DatosHistorialAlumnoDTO;
import hn.unah.matricula.Services.impl.HistorialAlumnoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/matricula/historialAlumno")
public class HistorialAlumnoController {
    
    @Autowired
    private HistorialAlumnoServiceImpl historialAlumnoServiceImpl;

    @Operation(summary = "obtiene el historial del alumno unicamente con los datos del DTO")
    @GetMapping("/obtener")    
    public String obtenerDatosHistorialAlumno(DatosHistorialAlumnoDTO usuario){
        return this.historialAlumnoServiceImpl.obtenerHistorialAcademico(usuario);
    }
    
}
