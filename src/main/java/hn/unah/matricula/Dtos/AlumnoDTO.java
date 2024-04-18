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

  @Override
  public String toString() {
    return "{ " + "nombre: " + this.nombre + "apellidos: " + this.apellidos + "direccion: " + this.direccion + "sexo: " + this.sexo + "contrasena: " + this.contrasena +  " }";
  }

}





