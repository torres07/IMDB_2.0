package br.ufc.quixada.IMDB_2_0.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.quixada.IMDB_2_0.model.Celebridade;

public interface CelebridadeRepository extends JpaRepository<Celebridade, Integer>{

}
