package hn.unah.matricula.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.HistorialDocente;
import hn.unah.matricula.Services.impl.HistorialDocenteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/matricula/historialDocente")
public class HistorialDocenteController {
    

    @Autowired
    private HistorialDocenteServiceImpl historialDocenteServiceImpl;

    @Operation(summary = "Obtiene el Historial del docente por medio del id")
    @GetMapping("/obtenerPorId")
    public HistorialDocente obtenerHistorialDocenteXid(@RequestParam(name = "id") int id){
        return this.historialDocenteServiceImpl.obteberHistorialDocente(id);
    }
}
