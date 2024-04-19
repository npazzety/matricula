package hn.unah.matricula.Dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AlumnoExpedienteDTO {

  private String nombres;
  private String apellidos;

  @Column(name="direccion")
  private String direccion;

  private String foto;

  private String correo;
  private boolean sexo;
  private String carrera;
    
}
