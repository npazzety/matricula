package hn.unah.matricula.Dtos;

import lombok.Data;

@Data

public class DocenteDTO {

    private String nombre;
    
    private String apellido;

    private String especializacion; 

    private String contrasena;

    private boolean sexo;

    private boolean coordinador;

    private String departamento;

}
