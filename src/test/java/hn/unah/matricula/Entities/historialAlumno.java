package hn.unah.matricula.Entities;

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
public class historialAlumno {


    @Id
    @Column(name = "idhistorial")
    private int idHistorial;

    @OneToOne()
    @JoinColumn(name = "numerocuenta", referencedColumnName = "numerocuenta")
    private Alumnos alumnos;

    @Id
    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @OneToMany()
    private Clases clases;


    
}
