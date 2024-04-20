package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonManagedReference
    private int idEquipo;

    @Column(name = "tipoequipo")
    private int tipoEquipo;

    private String descripcion;

    @ManyToMany(mappedBy = "equipos")
    @JsonBackReference
    @JsonIgnore
    private List<Salon> salon;


    
}
