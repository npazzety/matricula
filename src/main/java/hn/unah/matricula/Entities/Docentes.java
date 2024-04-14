package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "docentes")
@Entity

public class Docentes {

    @Id
    @Column(name = "numerocuenta")
    private String numeroCuenta;

    private String nombre;

    private String apellido;

    private boolean sexo;

    private String direccion;

    private String corre;

    private String foto;

    private String especializacion;

    private int likes;

    private int dislikes;

    private String contraseña;

    @Column(name = "fechacontratacion")
    private int fechaContratacion;

}
