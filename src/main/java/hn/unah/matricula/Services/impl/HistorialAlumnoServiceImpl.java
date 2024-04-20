package hn.unah.matricula.Services.impl;



import org.springframework.stereotype.Service;

import hn.unah.matricula.Dtos.DatosHistorialAlumnoDTO;


import hn.unah.matricula.Services.HistorialAlumnoService;

@Service
public class HistorialAlumnoServiceImpl  implements HistorialAlumnoService{

   

    @Override
    public String obtenerHistorialAcademico(DatosHistorialAlumnoDTO datos) {
       return "idHistorial: " + datos.getIdHistorial() + 
               ", Clase: " + datos.getClase() +
               ", UV: " + datos.getUv() +
               ", Periodo: " + datos.getPeriodo() +
               ", Año: " + datos.getAnio() +
               ", Nota: " + datos.getNota() +
               ", Observacion " + datos.getObservacion();
            
            }


    }

    




