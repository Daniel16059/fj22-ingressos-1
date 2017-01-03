package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.dto.SessaoDto;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sessao;
import br.com.caelum.ingresso.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;

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
		List<Sessao> sessõesDoCinema = sessaoDao.buscaSessoesDoCinema(sessao.getCinemaId());
		if (sessaoService.temHorarioDisponivel(sessao.getHorario(), filme, sessõesDoCinema)) {
			sessaoDao.adiciona(sessao.toSessao(cinemaDao, filmeDao));
			return "adicionado";
		}
		return "erro";
	}


	@RequestMapping(value = "/sessoes")
	public String lista(Model model) {
		model.addAttribute("sessoes", sessaoDao.lista());
		return "sessao/lista";
	}
}
