package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "historialdocente")
@Entity

public class HistorialDocente {

    @Id
    @Column(name = "idhistorial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorial;

    @JoinColumn(name = "iddocente", referencedColumnName = "numerocuenta")
    @OneToOne
    @JsonBackReference
    private Docentes docentes;
    
    @OneToMany
    @JsonBackReference
    @JsonIgnore
    private List<Seccion> seccion;


    
}
