package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.ingresso.modelo.Cinema;

@Transactional
@Repository
public class CinemaDao {
	
	@PersistenceContext	
	private EntityManager manager;

	public void adiciona(Cinema cinema) {
		manager.persist(cinema);
	}

	public List<Cinema> lista() {
		return manager.createQuery("select c from Cinema c", Cinema.class).getResultList();
	}

	public Cinema busca(Integer cinemaId) {
		return manager.find(Cinema.class, cinemaId);
	}
	
	
	
}
