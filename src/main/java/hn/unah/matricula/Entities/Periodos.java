package hn.unah.matricula.Entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "periodos")

public class Periodos {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperiodo")
    @JsonManagedReference
    private int idPeriodo;

    @Column(name = "numeroperiodo")
    private int numeroPeriodo;

    private Date anio;

    @OneToMany
    @JsonBackReference
    @JsonIgnore
    private List<Notas> notas;
}
