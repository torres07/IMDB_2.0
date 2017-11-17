package br.ufc.quixada.IMDB_2_0.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import br.ufc.quixada.IMDB_2_0.model.Celebridade;

@Repository
@Primary
public class CelebridadeJpaDao implements CelebridadeDao{
	@Autowired
	private EntityManager em;

	@Override
	public Celebridade getUsuarioById(Integer id) {
		String hql = "select u from celebridades as u where u.id = :param_id";
		Query query = em.createQuery(hql);
		query.setParameter("param_id", id);
		
		@SuppressWarnings("unchecked")
		List<Celebridade> celebridades = query.getResultList();
		
		if (celebridades.size() != 0){
			return celebridades.get(0);
		}
		
		return null;
	}

	@Override
	public Celebridade getUsuarioByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}
