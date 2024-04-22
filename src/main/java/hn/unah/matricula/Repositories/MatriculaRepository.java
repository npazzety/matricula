package hn.unah.matricula.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Entities.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Integer>{
  public List<Matricula> findByAlumno(Alumnos alumno);
}
