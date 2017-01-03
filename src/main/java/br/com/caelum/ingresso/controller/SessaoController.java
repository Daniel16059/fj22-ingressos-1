package br.com.caelum.ingresso.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.dto.SessaoDto;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sessao;

@Controller
public class SessaoController {

	@Autowired
	private CinemaDao cinemaDao;

	@Autowired
	private SessaoDao sessaoDao;

	@Autowired
	private FilmeDao filmeDao;

	@RequestMapping(value = "/sessao", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("cinemas", cinemaDao.lista());
		model.addAttribute("filmes", filmeDao.lista());
		return "sessao/sessao";
	}

	@RequestMapping(value = "/sessao", method = RequestMethod.POST)
	public String salva(SessaoDto sessao) {
		Filme filme = filmeDao.busca(sessao.getFilmeId());
		List<Sessao> sessõesDoCinema = sessaoDao.buscaSessõesDoCinema(sessao.getCinemaId());
		if (temHorarioDisponivel(sessao, filme, sessõesDoCinema)) {
			sessaoDao.adiciona(sessao.toSessao(cinemaDao, filmeDao));
			return "adicionado";
		}
		return "erro";
	}

	public boolean temHorarioDisponivel(SessaoDto sessao, Filme filme, List<Sessao> sessõesDoCinema) {
		for (Sessao sessaoDoCinema : sessõesDoCinema) {
			if (horarioIsValido(sessaoDoCinema.getHorario(), sessaoDoCinema.getFilme(), sessao.getHorario())
					&& horarioIsValido(sessao.getHorario(), filme, sessaoDoCinema.getHorario())) {
				return false;
			}
		}
		return true;
	}

	private boolean horarioIsValido(LocalTime horario, Filme filme, LocalTime horarioProximaSessao) {
		System.out.println(horario.plusMinutes(filme.getDuracao().toMinutes()));
		System.out.println(horario + "eeeeee" + horarioProximaSessao);
		return horario.plusMinutes(filme.getDuracao().toMinutes()).compareTo(horarioProximaSessao) >= 0;
	}

	@RequestMapping(value = "/sessoes")
	public String lista(Model model) {
		model.addAttribute("sessoes", sessaoDao.lista());
		return "sessao/lista";
	}
}
