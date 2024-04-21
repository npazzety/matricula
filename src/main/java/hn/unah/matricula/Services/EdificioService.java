package hn.unah.matricula.Services;

import java.util.List;

import hn.unah.matricula.Entities.Edificio;

public interface EdificioService {

    public Edificio crearEdificio(Edificio edificio);
    
    public List<Edificio> getEdificios();
}
