package hn.unah.matricula.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Prerequisitos;


public interface PrerequisitosRepository extends CrudRepository<Prerequisitos, Integer>{

    List<Prerequisitos> findByClaseIdClase(Object idClase);
}
