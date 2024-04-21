package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Dtos.ClasesDTO;
import hn.unah.matricula.Entities.Clases;


public interface ClasesService {

    public Clases crearClases(ClasesDTO clases);
    
    public List<Clases> obtenerClasesDeDocente(String numeroCuentaDocente);


    public List<Clases> obtenerRequisitosDeClases(int idClase);

}
