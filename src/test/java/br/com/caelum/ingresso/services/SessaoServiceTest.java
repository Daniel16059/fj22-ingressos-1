package br.com.caelum.ingresso.services;

import br.com.caelum.ingresso.modelo.Cinema;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sessao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class SessaoServiceTest {

	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario(){
		Cinema cinema = new Cinema("teste");
		Filme filme = new Filme();
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();

		SessaoService service = new SessaoService();
		Assert.assertFalse(service.temHorarioDisponivel(horario, filme, Arrays.asList(new Sessao(horario, cinema, filme))));
	}

	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente(){
		Cinema cinema = new Cinema("teste");
		Filme filme = new Filme();
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();


		SessaoService service = new SessaoService();
		Assert.assertFalse(service.temHorarioDisponivel(horario.minus(1,ChronoUnit.HOURS), filme, Arrays.asList(new Sessao(horario, cinema, filme))));

	}


	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente(){
		Cinema cinema = new Cinema("teste");
		Filme filme = new Filme();
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();


		SessaoService service = new SessaoService();
		Assert.assertFalse(service.temHorarioDisponivel(horario.plus(1,ChronoUnit.HOURS), filme, Arrays.asList(new Sessao(horario, cinema, filme))));

	}

}
