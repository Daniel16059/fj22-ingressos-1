package br.com.caelum.ingresso.dto;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.modelo.Sessao;

public class SessaoDto {

	private Integer cinemaId;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horario;
	private Integer filmeId;
	
	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

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

	public Sessao toSessao(CinemaDao cinemaDao, FilmeDao filmeDao) {
		return new Sessao(horario, cinemaDao.busca(cinemaId), filmeDao.busca(filmeId));
	}

}
