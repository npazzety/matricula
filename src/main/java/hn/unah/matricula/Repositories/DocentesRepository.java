package hn.unah.matricula.Repositories;


import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Docentes;

public interface DocentesRepository extends CrudRepository<Docentes, String> {

    public Docentes findByClave(String clave);

}
