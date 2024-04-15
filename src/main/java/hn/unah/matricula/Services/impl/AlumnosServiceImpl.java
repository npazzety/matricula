package hn.unah.matricula.Services.impl;

import java.sql.Date;

import org.springframework.stereotype.Service;

import hn.unah.matricula.CreateAlumnoDTO;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Services.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @SuppressWarnings("deprecation")
    @Override
    public Alumnos crearAlumno(CreateAlumnoDTO alumno) {

        Date date = new Date(0);
        date.getYear();

        String anio = date.toString();

        int siguientesdigitos = 0;

        for(int i = 0; i < 7; i++){
            siguientesdigitos += Math.floor(Math.random() * 10);

        }
        String numeroCuenta = anio + siguientesdigitos;
        alumno.setNumeroCuenta(numeroCuenta);


        return this.crearAlumno(alumno);
    }

}
