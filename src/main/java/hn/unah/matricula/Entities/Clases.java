package hn.unah.matricula.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "clases")
@Entity
public class Clases {

    @Id
    @Column(name = "idclase")
    private int idClase;

    private String codigo;

    private String nombre;

    private int uv;

    @ManyToMany(mappedBy = "clases")
    private List<Alumnos> alumnos; 

}
