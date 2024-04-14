package hn.unah.matricula.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "periodos")
@Entity

public class Periodos {

    @Id
    @Column(name = "idperiodo")
    private int idPeriodo;

    @Column(name = "numeroperiodo")
    private int numeroPeriodo;

    private Date anio;
    
}
