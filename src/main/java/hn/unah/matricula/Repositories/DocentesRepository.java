package hn.unah.matricula.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Docentes;

public interface DocentesRepository extends CrudRepository<Docentes, String> {

    public Docentes findByClave(String clave);

    public Optional<Docentes> findByNumeroCuenta(String numeroCuenta); 

}
