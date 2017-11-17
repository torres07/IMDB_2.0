package br.ufc.quixada.IMDB_2_0.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.quixada.IMDB_2_0.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer>{
	Iterable<Filme> findByGenero(String genero);
}
