package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
    @OneToMany
    private Alumnos alumnos;

    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @OneToMany
    private Clases clases;

    @JoinColumn(name = "idperiodo", referencedColumnName = "idperiodo")
    @OneToMany
    private Periodos periodos;

    private int nota;

    private String observacion;

    
}
