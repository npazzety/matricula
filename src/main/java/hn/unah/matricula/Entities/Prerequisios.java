package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prerequisitos")

public class Prerequisios {

    @Id
    @Column(name = "prerequisito")
    private int idPrerequisito;

    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    private Clases clases;

    
}
