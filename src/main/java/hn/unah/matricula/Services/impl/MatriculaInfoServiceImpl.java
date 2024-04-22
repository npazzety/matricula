package hn.unah.matricula.Services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import hn.unah.matricula.Dtos.MatriculaDTO;
import hn.unah.matricula.Entities.MatriculaInfo;
import hn.unah.matricula.Repositories.MatriculaInfoRepository;
import hn.unah.matricula.Services.MatriculaInfoService;

@Service
public class MatriculaInfoServiceImpl implements MatriculaInfoService {

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MatriculaInfoRepository matriculaRepo;

  @Override
  public boolean crearMatriculaInfo(MatriculaDTO matricula) {
    try {

      objectMapper.registerModule(new JavaTimeModule());

      MatriculaInfo nuevaMatricula = new MatriculaInfo();
      nuevaMatricula.setAnio(matricula.getAnio());
      nuevaMatricula.setFechaComienzo(LocalDate.parse(matricula.getFechaComienzo()));
      nuevaMatricula.setFechaFinal(LocalDate.parse(matricula.getFechaFinal()));
      nuevaMatricula.setHoraComienzo(LocalTime.parse(matricula.getHoraComienzo()));
      nuevaMatricula.setHoraFinal(LocalTime.parse(matricula.getHoraFinal()));
      nuevaMatricula.setPeriodo(matricula.getPeriodo());
      // si una matricula está activa las demás deben estar no activas
      List<MatriculaInfo> matriculas = this.matriculaRepo.findAll();
      for (MatriculaInfo matriculaRegistrada : matriculas) {
        matriculaRegistrada.setEstado(false);
        this.matriculaRepo.save(matriculaRegistrada);
      }
      nuevaMatricula.setEstado(true);
      this.matriculaRepo.save(nuevaMatricula);
      return true;
    } catch(Exception e) {
      return false;
    }
  }
  
}
