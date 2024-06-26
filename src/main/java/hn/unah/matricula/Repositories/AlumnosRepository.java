package hn.unah.matricula.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.matricula.Entities.Alumnos;

public interface AlumnosRepository extends CrudRepository<Alumnos, String> {
  public Alumnos findByFoto(String foto);
  public Alumnos findByCorreo(String correo); 
}
