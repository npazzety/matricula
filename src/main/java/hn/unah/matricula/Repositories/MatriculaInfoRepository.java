package hn.unah.matricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.matricula.Entities.MatriculaInfo;

public interface MatriculaInfoRepository extends JpaRepository<MatriculaInfo, Integer> {
  
}
