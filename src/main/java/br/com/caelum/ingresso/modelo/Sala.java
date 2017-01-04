package br.com.caelum.ingresso.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sala {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	/**
	 * @deprecated hibernate only
	 */
	protected Sala(){
		
	}
	public Sala(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
