package br.com.caelum.ingresso.dto;

import java.time.Duration;

import br.com.caelum.ingresso.modelo.Filme;

public class FilmeDto {

	private Integer id;
	private String nome;
	private Duration duracao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(long duracao) {
		this.duracao = Duration.ofMinutes(duracao);
	}

	public Filme toFilme() {
		return new Filme(id, nome, duracao);
	}

}
