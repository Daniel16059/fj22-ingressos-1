package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.dto.SessaoDto;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessaoController {

	@Autowired
	private SalaDao salaDao;

	@Autowired
	private SessaoDao sessaoDao;

	@Autowired
	private FilmeDao filmeDao;

	@RequestMapping(value = "/sessao", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("salas", salaDao.lista());
		model.addAttribute("filmes", filmeDao.lista());
		return "sessao/sessao";
	}

	@RequestMapping(value = "/sessao", method = RequestMethod.POST)
	public String salva(SessaoDto sessao) {
		Filme filme = filmeDao.busca(sessao.getFilmeId());
		Sala sala = salaDao.busca(sessao.getSalaId());

		if (sala.temHorarioDisponivel(sessao.getHorario(), filme)) {
			sessaoDao.adiciona(sessao.toSessao(salaDao, filmeDao));
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
