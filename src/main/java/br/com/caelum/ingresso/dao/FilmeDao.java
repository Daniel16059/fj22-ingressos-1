package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.ingresso.modelo.Filme;

@Transactional
@Repository
public class FilmeDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Filme filme){
		manager.persist(filme);
	}

	public List<Filme> lista() {
		return manager.createQuery("select f from Filme f", Filme.class).getResultList();
	}

	public Filme busca(Integer filmeId) {
		return manager.find(Filme.class, filmeId);
	}
}
