package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.dto.SessaoDto;
import br.com.caelum.ingresso.modelo.Filme;
import br.com.caelum.ingresso.modelo.Sala;
import br.com.caelum.ingresso.modelo.Sessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String salva(SessaoDto sessaoDto) {
		Filme filme = filmeDao.busca(sessaoDto.getFilmeId());
		Sala sala = salaDao.busca(sessaoDto.getSalaId());

		if (sala.temHorarioDisponivel(sessaoDto.getHorario(), filme)) {
			Sessao sessao = sessaoDto.toSessao(salaDao, filmeDao);
			sala.add(sessao);

			salaDao.atualiza(sala);
			return "adicionado";
		}
		return "erro";
	}


	@RequestMapping(value = "/sessoes/{id}")
	public String lista(@PathVariable("id") Integer id, Model model) {

		Sala sala = salaDao.busca(id);

		model.addAttribute("sala", sala);
		return "sessao/lista";
	}
}
