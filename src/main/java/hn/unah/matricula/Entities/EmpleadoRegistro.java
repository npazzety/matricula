package hn.unah.matricula.Entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empleadoregistro")
public class EmpleadoRegistro {

    @Id
    @Column(name = "idempleado")
    private String idEmpleado;

    private String dni;

    private String nombre;

    private String apellido;

    private String direccion;

    private String correo;

    private String telefono;

    private boolean sexo;

    private String contraseña;

    private Date fechaContratacion;

    private String clave;

    @Column(name = "idexpediente")
    private int idExpediente;

    
}
