package hn.unah.matricula.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Dtos.HistorialDocenteClasesDTO;
import hn.unah.matricula.Entities.HistorialDocente;


public interface HistorialDocenteRepository extends CrudRepository<HistorialDocente, Integer> {

    void save(HistorialDocenteClasesDTO historial);
}
