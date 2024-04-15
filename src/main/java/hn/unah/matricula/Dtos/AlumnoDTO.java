package hn.unah.matricula.Dtos;


import hn.unah.matricula.Entities.Carreras;
import lombok.Data;

@Data
public class AlumnoDTO {

  private String nombre;

  private String apellidos;

  private String direccion;

  private boolean sexo;

  private String contrasena;

  private Carreras carrera;
  
}





