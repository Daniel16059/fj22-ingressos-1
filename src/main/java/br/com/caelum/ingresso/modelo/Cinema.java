package br.com.caelum.ingresso.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cinema {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	/**
	 * @deprecated hibernate only
	 */
	protected Cinema(){
		
	}
	public Cinema(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
