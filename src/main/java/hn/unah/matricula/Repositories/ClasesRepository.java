package hn.unah.matricula.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Dtos.RequisitosClaseDTO;
import hn.unah.matricula.Entities.Clases;

public interface ClasesRepository  extends CrudRepository<Clases, Integer>{

    void save(RequisitosClaseDTO requisitos);
    
}
