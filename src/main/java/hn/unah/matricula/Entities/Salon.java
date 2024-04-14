package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

}
