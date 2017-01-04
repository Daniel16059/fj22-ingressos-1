package br.com.caelum.ingresso.dto;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.modelo.Sessao;

public class SessaoDto {

	private Integer salaId;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horario;
	private Integer filmeId;
	
	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer cinemaId) {
		this.salaId = cinemaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		return new Sessao(horario, salaDao.busca(salaId), filmeDao.busca(filmeId));
	}

}
