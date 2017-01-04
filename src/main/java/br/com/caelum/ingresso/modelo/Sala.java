package br.com.caelum.ingresso.modelo;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
public class Sala {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	@OneToMany(mappedBy = "sala")
	private List<Sessao> sessoes;

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

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public boolean temHorarioDisponivel(LocalTime horario, Filme filme) {
		for (Sessao sessaoDoCinema : sessoes) {
			if (! horarioIsValido(horario, filme, sessaoDoCinema)) {
				return false;
			}
		}
		return true;
	}

	private boolean horarioIsValido(LocalTime horarioAtual, Filme filme, Sessao sessao) {

		LocalTime horarioSessao = sessao.getHorario();


		if (horarioAtual.compareTo(sessao.getHorario()) == 0) return false;

		boolean ehAntes = horarioAtual.isBefore(horarioSessao);

		if (ehAntes){
			long tempoDisponivel = horarioAtual.until(horarioSessao, ChronoUnit.MINUTES);

			long duracaoDoFilme = filme.getDuracao().toMinutes();

			return duracaoDoFilme <= tempoDisponivel;
		}else {

			LocalTime horarioTermino = sessao.getHorarioTermino();

			long tempoDisponivel = horarioAtual.until(horarioTermino, ChronoUnit.MINUTES);

			return  tempoDisponivel >= filme.getDuracao().toMinutes();

		}
	}

}
