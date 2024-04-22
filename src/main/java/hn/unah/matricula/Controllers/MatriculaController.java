package hn.unah.matricula.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Services.impl.MatriculaServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/matricula")
public class MatriculaController {
  
  @Autowired
  private MatriculaServiceImpl matriculaService;

  @GetMapping("/clases/matriculadas/{idEstudiante}")
  public List<Clases> getClasesMatriculadas(@PathVariable String idEstudiante) {
    return this.matriculaService.obtenerMatriculasPorEstudiante(idEstudiante);
  }
  
}
