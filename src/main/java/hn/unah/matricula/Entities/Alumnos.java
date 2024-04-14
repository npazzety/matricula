package hn.unah.matricula.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    private String contraseña;


    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @ManyToMany
    @JoinTable(name = "alumno_clase", JoinC)
    private List
}

