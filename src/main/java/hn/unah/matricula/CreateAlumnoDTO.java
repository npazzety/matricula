package hn.unah.matricula;

import java.sql.Date;

import lombok.Data;

@Data

public class CreateAlumnoDTO {

    private String numeroCuenta;

    private String nombre;

    private String apellidos;

    private String direccion;

    private String correo;

    private boolean sexo;

    private String contraseña;

    private Date fechaCreacion;

}
