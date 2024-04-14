package hn.unah.matricula.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seccion")
public class Seccion {

    @Id
    @Column(name = "idseccion")
    private int idSeccion;

    @Column(name = "horainicio")
    private Date horaInicio;

    @Column(name = "horafin")
    private Date horaFin;

    @JoinColumn(name = "idclase", referencedColumnName = "idclase")
    @ManyToOne()
    private Clases clases;

    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne
    private Docentes docentes;

    @JoinColumn(name = "idsalon", referencedColumnName = "idsalon")
    @OneToOne
    private Salon salon;
    
    
}
