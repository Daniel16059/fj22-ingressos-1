package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.ingresso.modelo.Sala;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SalaDao {
	
	@PersistenceContext	
	private EntityManager manager;

	public void adiciona(Sala sala) {
		manager.persist(sala);
	}

	public List<Sala> lista() {
		return manager.createQuery("select c from Sala c", Sala.class).getResultList();
	}

	public Sala busca(Integer salaId) {
		return manager.find(Sala.class, salaId);
	}
	
	
	
}
