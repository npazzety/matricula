package hn.unah.matricula.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.matricula.Dtos.MatriculaDTO;
import hn.unah.matricula.Services.impl.MatriculaInfoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaInfoController {
  
  @Autowired
  private MatriculaInfoServiceImpl matriculaService;

  @Operation(summary = "crea un registro de matricula general")
  @PostMapping("/crear/nuevo")
  public boolean crearMatricula(@RequestBody MatriculaDTO matricula) {
    return this.matriculaService.crearMatriculaInfo(matricula);
  }
}
