package hn.unah.matricula.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="matriculainfo")
@Data
public class MatriculaInfo {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="idmatriculainfo")
  private int idMatriculaInfo;

  private boolean estado;

  private LocalDate fechaComienzo;
  private LocalDate fechaFinal;
  private LocalTime horaComienzo;
  private LocalTime horaFinal; 
  private String anio;
  private String periodo;
}
