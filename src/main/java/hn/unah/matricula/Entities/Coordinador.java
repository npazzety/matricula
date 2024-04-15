package hn.unah.matricula.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "coordinador")
public class Coordinador {

    @Id
    private String dni;

    private String nombre;

    private String apellido;

    private String direccion;


    @JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
    @OneToOne
    private Carreras carreras;

    private String correo;

    private String telefono;

    private String foto;

    private String especializacion;

    private String contraseña;


    @Column(name = "fechacoodinador")
    private Date fechaCoordinador ;

    private boolean sexo;
    
}
