package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "notas")
@Entity
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idnota")
    private int idNota;

    private int idSeccion;

    private int idPeriodo;

    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private int nota;
}
