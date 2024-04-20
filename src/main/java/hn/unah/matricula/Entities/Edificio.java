package hn.unah.matricula.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "edificio")

public class Edificio {

    @Id
    @Column(name = "idedificio")
    @JsonManagedReference
    private String idEdificio;

    private String nombre;

    @Column(name = "numeropisos")
    private int numeroPisos;
    
}
