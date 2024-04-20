package hn.unah.matricula.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Expediente;

public interface ExpedienteRepository extends CrudRepository<Expediente, Integer>{
  List<Expediente> findByAceptado(boolean aceptado);
}
