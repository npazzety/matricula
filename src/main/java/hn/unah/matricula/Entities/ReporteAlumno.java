package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reportealumno")

public class ReporteAlumno {

    @Id
    @Column(name = "idreporte")
    private int reporte;

    @OneToMany
    private List<Alumnos> alumnos;

    @OneToMany
    private List<Clases> clases;

    private int nota;

    private String observacion;

    
}
