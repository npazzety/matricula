package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prerequisitos")

public class Prerequisitos {

    @Id
    @Column(name = "prerequisito")
    private int idPrerequisito;

    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    private Clases clases;

    @ManyToMany(mappedBy = "prerequisito")
    private List<Clases> clasesprerequisitos;
    
}
