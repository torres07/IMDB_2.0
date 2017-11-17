package br.ufc.quixada.IMDB_2_0.dao;

import br.ufc.quixada.IMDB_2_0.model.Usuario;

public interface UsuarioDao {
	
	public void adiciona(Usuario usuario);
	
	public Usuario getUsuarioByLogin(String login);
	
	public Usuario getUsuarioByEmail(String email);

}
