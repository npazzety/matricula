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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "salon")
public class Salon {
    

    @Id
    @Column(name = "idsalon")
    @JsonManagedReference
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idSalon;

    @JoinColumn(name = "idedificio", referencedColumnName = "idedificio")
    @ManyToOne
    @JsonBackReference
    @JsonIgnore
    private Edificio edifio;

    private String nombre;

    private int capacidad;

    @ManyToMany
    @JoinTable(name = "alumno_docente", joinColumns = @JoinColumn(name ="idalumno"), inverseJoinColumns = @JoinColumn(name = "iddocente"))
    @JsonBackReference
    @JsonIgnore
    private List<Docentes> docentes; 

    private String observacion;


}
