package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.dto.SessaoDto;

@Controller
public class SessaoController {

	@Autowired
	private CinemaDao cinemaDao;
	
	@Autowired
	private SessaoDao sessaoDao;

	@RequestMapping(value="/sessao", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("cinemas", cinemaDao.lista());
		return "sessao/sessao";
	}
	
	@RequestMapping(value="/sessao", method=RequestMethod.POST)
	public String salva(SessaoDto sessao){
		System.out.println(">>>>>>>>>>>>>>>>Horario : " + sessao.getHorario());
		sessaoDao.adiciona(sessao.toSessao(cinemaDao));
		return "adicionado";
	}

	@RequestMapping(value="/sessoes")
	public String lista(Model model){
		model.addAttribute("sessoes",sessaoDao.lista());
		return "sessao/lista";
	}
}
