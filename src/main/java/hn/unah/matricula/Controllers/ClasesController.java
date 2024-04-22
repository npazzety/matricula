package hn.unah.matricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.ClasesCardDTO;
import hn.unah.matricula.Dtos.ClasesDTO;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Services.impl.ClasesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @Operation(summary = "Obtiene los requisitos de las clases")
    @GetMapping("/{idClase}")
    public List<Clases> obtenerClasesDeDocente(@PathVariable int idClase) {
        return clasesServiceImpl.obtenerRequisitosDeClases(idClase);
    }

    @Operation(summary = "crea una clase")
    @PostMapping("/crearClase")
    public Clases postMethodName(@RequestBody ClasesDTO clases) {
        return this.clasesServiceImpl.crearClases(clases);
    }


    @GetMapping("/secciones/{idDocente}")
    public List<ClasesCardDTO> obtenerSeccionDocente(@PathVariable String idDocente) {
        return this.clasesServiceImpl.obtenerSeccionesDocente(idDocente);
    }
    
    
    @Operation(summary = "devuelve lista de todas las clases")
    @GetMapping("/obtener")
    public List<Clases> obtenerClases() {
        return this.clasesServiceImpl.obtenerClases();
    }

}
