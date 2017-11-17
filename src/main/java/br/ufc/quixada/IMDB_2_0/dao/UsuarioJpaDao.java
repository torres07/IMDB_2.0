package br.ufc.quixada.IMDB_2_0.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.ufc.quixada.IMDB_2_0.model.Usuario;

@Repository
@Primary
public class UsuarioJpaDao implements UsuarioDao{

	@Autowired
	private EntityManager em;
	
	@Override
	public void adiciona(Usuario usuario) {
		
	}

	@Override
	public Usuario getUsuarioByLogin(String login) {
		String hql = "select u from usuarios as u where u.login = :param_login";
		Query query = em.createQuery(hql);
		query.setParameter("param_login", login);
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		
		if (usuarios.size() != 0){
			return usuarios.get(0);
		}				
		return null;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		String hql = "select u from usuarios as u where u.email = :param_email";
		Query query = em.createQuery(hql);
		query.setParameter("param_email", email);
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		
		if (usuarios.size() != 0){
			return usuarios.get(0);
		}				
		return null;
	}


}
