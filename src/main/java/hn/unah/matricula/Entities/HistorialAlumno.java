package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "historialalumno")
public class HistorialAlumno {


    @Id
    @Column(name = "idhistorial")
    private int idHistorial;

    @OneToOne()
    @JoinColumn(name = "numerocuenta", referencedColumnName = "numerocuenta")
    private Alumnos alumnos;

    @OneToMany
    private List<Seccion> secciones;

    @JoinColumn(name = "idnotas", referencedColumnName = "idnotas")
    @OneToOne
    private Notas notas;

    
}
