package hn.unah.matricula.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "edificio")

public class Edificio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idedificio")
    private int idEdificio;

    private String nombre;

    @Column(name = "numeropisos")
    private int numeroPisos;
    
}
