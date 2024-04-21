package hn.unah.matricula.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "docentes")
@Entity

public class Docentes {

    @Id
    @Column(name = "numerocuenta")
    @JsonManagedReference
    private String numeroCuenta;

    private String nombre;

    private String apellido;

    private boolean sexo;

    private String direccion;

    private String correo;

    private String departamento;

    private String foto;

    private String especializacion;

    private String contrasena;

    private String clave;

    private boolean coordinador;

    @Column(name = "fechacontratacion")
    private int fechaContratacion;

    @ManyToMany(mappedBy = "docentes")
    @JsonBackReference
    @JsonIgnore
    private List<Alumnos> alumnos;

    @ManyToOne
    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    @JsonBackReference
    @JsonIgnore
    private Carreras carreras;

    @OneToOne(mappedBy="docentes")
    @JsonBackReference
    @JsonIgnore
    private HistorialDocente historialDocente;

}
