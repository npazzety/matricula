package hn.unah.matricula.Services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hn.unah.matricula.Dtos.AlumnoDTO;
import hn.unah.matricula.Dtos.DatosAlumnosDto;
import hn.unah.matricula.Entities.Alumnos;
import hn.unah.matricula.Repositories.AlumnosRepository;
import hn.unah.matricula.Services.AlumnosService;
import hn.unah.matricula.util.AlumnoUtil;
import hn.unah.matricula.util.ImageStorage;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository alumnosRepository;

    @Override
    public Alumnos crearAlumno(AlumnoDTO alumno, MultipartFile image) {
        try {
            Alumnos nuevoAlumno = new Alumnos();
            
            // verificar si el correo ya existe
            String correo;
            int contador = 0;
            do {
                correo = AlumnoUtil.generarCorreo(alumno.getNombre(), alumno.getApellidos(), contador);
                contador++;
            } while(null != alumnosRepository.findByCorreo(correo));

            // guarda la imagen
            String imagePath = "";
            try {
                imagePath = ImageStorage.saveImage(image);
            } catch(IOException e) {
                return null;
            }

            String numeroCuenta = AlumnoUtil.crearNumeroCuenta(); 
            nuevoAlumno.setNumeroCuenta(numeroCuenta);
            nuevoAlumno.setNombre(alumno.getNombre());
            nuevoAlumno.setApellido(alumno.getApellidos());
            nuevoAlumno.setSexo(alumno.isSexo());
            nuevoAlumno.setDireccion(alumno.getDireccion());
            nuevoAlumno.setCarrera(alumno.getCarrera());
            nuevoAlumno.setIndice(100);
            nuevoAlumno.setCorreo(correo);        
            nuevoAlumno.setContrasena(alumno.getContrasena());
            nuevoAlumno.setFechaCreacion(LocalDate.now());
            nuevoAlumno.setFoto(imagePath);
    
            return this.alumnosRepository.save(nuevoAlumno);

        } catch (Error e) {
            return null;
        }
    }

    @Override
    public List<Alumnos> obtenerAlumnos() {
       return (List<Alumnos>) this.alumnosRepository.findAll();
    }


    @Override
    public boolean verificarAlumno(DatosAlumnosDto alumnoVerificar) {

        if (null == this.alumnosRepository.findByCorreo(alumnoVerificar.getCorreo()))
            return false;
        // como el alumno existe se comprueba la contrasena
        Alumnos alumno = this.alumnosRepository.findByCorreo(alumnoVerificar.getCorreo());
        if (alumno.getContrasena().equals(alumnoVerificar.getContraseña()))
            return true;

        return false;
    }

}
