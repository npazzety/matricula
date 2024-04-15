package hn.unah.matricula.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")

public class Alumnos {


    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private String nombre;

    private String apellido;

    private boolean sexo;

    private String direccion;

    private String correo;

    private String foto;

    private int indice;

    private String contrasena;

    @Column(name = "fechacreacion")
    private LocalDate fechaCreacion;

    @ManyToMany
    @JoinTable(name = "alumno_clase", joinColumns = @JoinColumn(name = "idalumno"), inverseJoinColumns = @JoinColumn(name = "idclase"))
    private List<Clases> clases;

    @ManyToMany
    @JoinTable(name = "alumno_docente", joinColumns = @JoinColumn(name ="idalumno"), inverseJoinColumns = @JoinColumn(name = "iddocente"))
    private List<Docentes> docentes; 

    @OneToOne
    @JsonBackReference
    private Carreras carrera;
}


