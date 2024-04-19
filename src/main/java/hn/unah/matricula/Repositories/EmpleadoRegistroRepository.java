package hn.unah.matricula.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.EmpleadoRegistro;

public interface EmpleadoRegistroRepository extends CrudRepository <EmpleadoRegistro, String>{
    
    public EmpleadoRegistro findByClave(String clave); 
}
