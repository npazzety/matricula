package hn.unah.matricula.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class EmpleadoRegistroDTO {

    private int idEmpleado;

    private String nombre;

    private String apellido;

    private String direccion;

    private String correo;

    private String telefono;

    private boolean sexo;

    private String contrasena;

    private Date fechaContratacion;

    private String clave;
    
}
