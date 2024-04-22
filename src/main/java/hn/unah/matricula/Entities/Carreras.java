package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Entity
@Table(name = "carreras")
@Data
public class Carreras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private int idCarrera;

    private String nombre;


    @Column(name = "cantidadestudiantes")
    private int cantidadestudiantes;

    @JsonBackReference
    @OneToOne
    private Docentes docentes;
 
    @OneToMany
    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    private List<Clases> clases;
}
