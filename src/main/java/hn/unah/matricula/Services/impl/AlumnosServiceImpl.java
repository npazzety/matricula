package hn.unah.matricula.Services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.CreateAlumnoDTO;
import hn.unah.matricula.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Services.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

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

        char primeraLetra = alumno.getApellidos().charAt(0);

        String cuentaEmail = alumno.getNombre().toLowerCase() + primeraLetra + "@unah.hn";

        Alumnos nvoalumno = new Alumnos();

        nvoalumno.setNombre(alumno.getNombre());
        nvoalumno.setApellido(alumno.getApellidos());
        nvoalumno.setApellido(alumno.getContraseña());
        nvoalumno.setFechaCreacion(date);
        nvoalumno.setCorreo(cuentaEmail);
        nvoalumno.setNumeroCuenta(numeroCuenta);
        nvoalumno.setSexo(alumno.isSexo());;

        this.alumnosRepository.save(nvoalumno);

        return nvoalumno;

    }

    @Override
    public List<Alumnos> obtenerAlumnos() {
       return (List<Alumnos>) this.alumnosRepository.findAll();
    }


    @Override
    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar) {

        for(Alumnos alumno : obtenerAlumnos()){
            if (alumno.getCorreo().equals(alumnoVerificar.getCorreo())) {

                if (alumno.getContraseña().equals(alumnoVerificar.getContraseña())) {
                    return true;
                } 
            }
        }
        return false;
    }





}
