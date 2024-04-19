package hn.unah.matricula.Entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "periodos")

public class Periodos {

    @Id
    @Column(name = "idperiodo")
    private int idPeriodo;

    @Column(name = "numeroperiodo")
    private int numeroPeriodo;

    private Date anio;

    @OneToMany
    private List<Notas> notas;
}
