package br.com.caelum.ingresso.dto;

import java.time.LocalTime;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.modelo.Sessao;

public class SessaoDto {

	private Integer cinemaId;
	private LocalTime horario;
	
	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Sessao toSessao(CinemaDao cinemaDao) {
		return new Sessao(horario, cinemaDao.busca(cinemaId));
	}

}
