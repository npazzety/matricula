package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Services.impl.ClasesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/matricula/clases")
public class ClasesController {
    
    @Autowired
    private ClasesServiceImpl clasesServiceImpl;

    @Operation(summary = "Obtiene las clases por medio del numero de cuenta del docente")
    @GetMapping("/numeroCuentaDocente")
    public List<Clases> obtenerClasesDeDocente(@RequestParam String idDocente) {
        return clasesServiceImpl.obtenerClasesDeDocente(idDocente);
    }
}
