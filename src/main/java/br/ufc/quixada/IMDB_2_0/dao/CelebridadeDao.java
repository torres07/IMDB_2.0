package br.ufc.quixada.IMDB_2_0.dao;

import br.ufc.quixada.IMDB_2_0.model.Celebridade;

public interface CelebridadeDao {
	
	public Celebridade getUsuarioById(Integer id);
	
	public Celebridade getUsuarioByName(String nome);

}
