package br.com.caelum.ingresso.controller;

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

	@RequestMapping(value="/sessao", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("cinemas", cinemaDao.lista());
		model.addAttribute("filmes", filmeDao.lista());
		return "sessao/sessao";
	}
	
	@RequestMapping(value="/sessao", method=RequestMethod.POST)
	public String salva(SessaoDto sessao){
		Filme filme = filmeDao.busca(sessao.getFilmeId());
		List<Sessao> sessõesDoCinema = sessaoDao.buscaSessõesDoCinema(sessao.getCinemaId());
		for (Sessao sessaoDoCinema : sessõesDoCinema) {
			if(sessaoDoCinema.getHorario().compareTo(sessao.getHorario()) <= 0){
				if(sessaoDoCinema.getHorario().plusMinutes(sessaoDoCinema.getFilme().getDuracao().toMinutes()).compareTo(sessao.getHorario()) >= 0){
					System.out.println("invalido");
					return "erro";
				}
			}
			else {
				if(sessao.getHorario().plusMinutes(filme.getDuracao().toMinutes()).compareTo(sessaoDoCinema.getHorario()) >= 0){
					System.out.println("invalido");
					return "erro";
				}
			}
		}
		sessaoDao.adiciona(sessao.toSessao(cinemaDao, filmeDao));
		return "adicionado";
	}

	@RequestMapping(value="/sessoes")
	public String lista(Model model){
		model.addAttribute("sessoes",sessaoDao.lista());
		return "sessao/lista";
	}
}
