package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String idSalon;

    @JoinColumn(name = "idedificio", referencedColumnName = "idedificio")
    @ManyToOne
    private Edificio edifio;

    private String nombre;

    private int capacidad;

    @ManyToMany
    @JoinTable(name = "alumno_docente", joinColumns = @JoinColumn(name ="idalumno"), inverseJoinColumns = @JoinColumn(name = "iddocente"))
    private List<Docentes> docentes; 


    @ManyToMany
    @JoinTable(name = "salon_equipo", joinColumns = @JoinColumn(name = "idsalon"), inverseJoinColumns = @JoinColumn(name = "idequipo") )
    private List<Equipos> equipos;
}
