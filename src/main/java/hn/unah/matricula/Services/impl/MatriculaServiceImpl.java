package hn.unah.matricula.Services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Matricula;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Repositories.MatriculaRepository;
import hn.unah.matricula.Services.MatriculaService;


@Service
public class MatriculaServiceImpl implements MatriculaService {

  @Autowired
  private AlumnosRepository alumnoRepo;

  @Autowired
  private MatriculaRepository matriculaRepo;

  @Override
  public List<Clases> obtenerMatriculasPorEstudiante(String $idAlumno) {
    Alumnos alumno = this.alumnoRepo.findById($idAlumno).get();
    List<Matricula> matriculas = this.matriculaRepo.findByAlumno(alumno);
    if (matriculas.size() == 0)
      return new ArrayList<>();
    Matricula ultimaMatricula = matriculas.get(matriculas.size() - 1);
    return ultimaMatricula.getClases();
  }
    
}
