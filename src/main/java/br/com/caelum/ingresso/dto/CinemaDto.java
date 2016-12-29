package br.com.caelum.ingresso.dto;

import br.com.caelum.ingresso.modelo.Cinema;

public class CinemaDto {

	private Integer id;
	private String nome;
	
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

	public Cinema toCinema(){
		return new Cinema(nome);
	}
	
}
