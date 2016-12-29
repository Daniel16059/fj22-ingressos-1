package br.com.caelum.ingresso.modelo;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Duration duracao;

	/**
	 * @deprecated hibernate only
	 */
	public Filme(){
		
	}

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
