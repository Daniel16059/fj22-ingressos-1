package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.ingresso.modelo.Sessao;

@Transactional
@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void adiciona(Sessao sessao){
		manager.persist(sessao);
	}
	
	public List<Sessao> lista(){
		return manager.createQuery("select s from Sessao s", Sessao.class).getResultList();
	}

	public List<Sessao> buscaSessoesDoCinema(Integer cinemaId) {
		return manager.createQuery("select s from Sessao s where s.sala.id = :id",Sessao.class).setParameter("id", cinemaId).getResultList();
	}
	
}
