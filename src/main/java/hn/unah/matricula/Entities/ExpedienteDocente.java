package hn.unah.matricula.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "expedientedocente")
@Entity

public class ExpedienteDocente {

    @Id
    @Column(name = "idexpediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpedienteDocente;

    private String nombre;

    private String apellido;

    private String correo;

    private String especializacion;

    private String contrasena;

    private String departamento;

    private String foto;

    private boolean sexo;


    
}
