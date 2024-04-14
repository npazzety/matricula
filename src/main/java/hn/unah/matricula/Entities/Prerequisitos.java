package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

<<<<<<< HEAD
=======
    @Column(name = "idclase")
    private int idClase;

>>>>>>> 62eca6eca911f5af750752c28085d7cc0a3ba26b
    @ManyToMany(mappedBy = "prerequisito")
    private List<Clases> clases;
    
}
