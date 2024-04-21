package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "prerequisitos")

public class Prerequisitos {

    @Id
    @Column(name = "prerequisito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    private int idPrerequisito;

    @Column(name = "idclase")
    private int idClase;

    @ManyToMany()
    @JsonBackReference
    @JsonIgnore
    private List<Clases> clases;
    
}
