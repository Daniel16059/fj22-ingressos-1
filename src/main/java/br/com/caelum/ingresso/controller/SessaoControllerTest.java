package br.com.caelum.ingresso.controller;

import java.time.LocalTime;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.dto.SessaoDto;
import br.com.caelum.ingresso.modelo.Cinema;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sessao;
import junit.framework.TestCase;

public class SessaoControllerTest extends TestCase {

	@Test
	public void testaSessao(){
		Cinema cinema = new Cinema("teste");
		Filme filme = new Filme();
		filme.setDuracao(120);
		LocalTime horario = LocalTime.now();
		

		SessaoDto dto = new SessaoDto();
		dto.setHorario(horario);
		
		SessaoController controller = new SessaoController();
		Assert.assertFalse(controller.temHorarioDisponivel(dto, filme, Arrays.asList(new Sessao(horario, cinema, filme))));
	}
}
