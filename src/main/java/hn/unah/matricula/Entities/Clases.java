package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "clases")
@Entity
public class Clases {

    @Id
    @Column(name = "idclase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClase;

    private String codigo;

    private String nombre;

    private int uv;

    @OneToMany(mappedBy = "clases")
    private List<Seccion> secciones;

    @ManyToMany(mappedBy = "clases")
    @JsonManagedReference
    private List<Alumnos> alumnos;  

    @ManyToOne
    @JoinColumn(name="idcarrera", referencedColumnName = "idcarrera")
    @JsonBackReference
    private Carreras carrera;

    @ManyToMany
    @JoinTable(name = "clase_requisito", joinColumns = @JoinColumn(name = "idclase"), inverseJoinColumns = @JoinColumn(name = "idprerequisito"))
    @JsonBackReference
    private List<Prerequisitos> prerequisitos;

    
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula")
    @ManyToOne
    @JsonBackReference

    private Matricula matricula;
}
