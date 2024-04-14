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
@Table(name = "equipos")

public class Equipos {

    @Id
    @Column(name = "idequipo")
    private int idEquipo;

    @Column(name = "tipoequipo")
    private int tipoEquipo;

    private String descripcion;

    @ManyToMany(mappedBy = "equipos")
    private List<Salon> salon;


    
}
