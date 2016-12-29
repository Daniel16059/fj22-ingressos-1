package br.com.caelum.ingresso.modelo;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id
	@GeneratedValue
	private final Integer id;
	private final String nome;
	private final Duration duracao;

	public Filme(Integer id, String nome, Duration duracao) {
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Duration getDuracao() {
		return duracao;
	}
}
