package hn.unah.matricula.Entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "matricula")
@Entity
public class Matricula {

    @Column(name = "idmatricula")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;

    @ManyToOne
    private Alumnos alumno;

    @OneToMany(mappedBy = "matricula")
    private List<Clases> clases;

    @Column(name = "fechainiciomatricula")
    private LocalDate fechaInicioMatricula;

    @Column(name = "fechafinmatricula")
    private LocalDate fechaFinMatricula;

    @Column(name = "horainiciomatricula")
    private LocalDate horainicioMatricula;

    @Column(name = "horafinmatricula")
    private LocalDate horafinMatricula;
    
    @Column(name = "estadomatricula")
    private boolean estadoMatricula;

    @Column(name = "fechacreacion")
    private LocalDate fechaCreacion;

}
