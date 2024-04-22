package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "clases")
@Entity
public class Clases {

    @Id
    @Column(name = "idclase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    private int idClase;

    private String codigo;

    private String nombre;

    private int uv;

    @ManyToMany(mappedBy = "clases")
    @JsonManagedReference
    @JsonIgnore
    private List<Alumnos> alumnos;  

    @ManyToMany
    @JoinTable(name = "clases_carrera", joinColumns = @JoinColumn(name = "idclase"), inverseJoinColumns = @JoinColumn(name = "idcarrera"))
    @JsonIgnore
    @JsonBackReference
    private List<Carreras> carreras;

    @ManyToMany
    @JoinTable(name = "clase_requisito", joinColumns = @JoinColumn(name = "idclase"), inverseJoinColumns = @JoinColumn(name = "idprerequisito"))
    @JsonBackReference
    @JsonIgnore
    private List<Prerequisitos> prerequisitos;
}
