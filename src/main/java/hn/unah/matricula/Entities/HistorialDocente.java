package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int idHistorial;

    @JoinColumn(name = "iddocente", referencedColumnName = "numerocuenta")
    @OneToOne
    private Docentes docentes;
    
    @OneToMany
    private List<Seccion> seccion;


    
}
