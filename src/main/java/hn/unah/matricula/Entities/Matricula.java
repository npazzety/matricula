package hn.unah.matricula.Entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "numerocuenta", referencedColumnName = "numerocuenta")
    private Alumnos alumno;

    @OneToMany(mappedBy = "clases")
    private List<Clases> clases;

    @Column(name = "fechainiciomatricula")
    private Date fechaInicioMatricula;

    @Column(name = "fechafinmatricula")
    private Date fechaFinMatricula;

    @Column(name = "horainiciomatricula")
    private Date horainicioMatricula;

    @Column(name = "horafinmatricula")
    private Date horafinMatricula;
    
    @Column(name = "estadomatricula")
    private boolean estadoMatricula;

    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    @Column(name = "fechaactualizacion")
    private Date fechaActualizacion;
    
}
