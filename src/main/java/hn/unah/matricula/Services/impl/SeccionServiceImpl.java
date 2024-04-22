package hn.unah.matricula.Services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.SeccionDTO;
import hn.unah.matricula.Entities.Clases;
import hn.unah.matricula.Entities.Seccion;
import hn.unah.matricula.Repositories.ClasesRepository;
import hn.unah.matricula.Repositories.DocentesRepository;
import hn.unah.matricula.Repositories.SalonRepository;
import hn.unah.matricula.Repositories.SeccionRepository;
import hn.unah.matricula.Services.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService{

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private ClasesRepository clasesRepository;

    @Autowired
    private SalonRepository salonRepository;

    @Autowired
    private DocentesRepository docentesRepository;

    @Override
    public Seccion CrearSeccion(SeccionDTO seccion) {
        Seccion nvoseccion = new Seccion();

        // agregar la seccion a la clase
        Clases clase = this.clasesRepository.findById(seccion.getIdClase()).get();
        nvoseccion.setClases(clase);
        nvoseccion.setHoraInicio(seccion.getHoraInicio());
        nvoseccion.setHoraFin(seccion.getHoraFin());
        nvoseccion.setSalon(this.salonRepository.findById(Integer.parseInt(seccion.getIdSalon())).get());
        nvoseccion.setDocentes(this.docentesRepository.findById(seccion.getNumeroCuenta()).get());
        Seccion sec = this.seccionRepository.save(nvoseccion);
        if (!(clase.getSecciones().contains(nvoseccion))) {
            clase.getSecciones().add(sec);
            this.clasesRepository.save(clase);
        }
        return sec;
    }
    
}
