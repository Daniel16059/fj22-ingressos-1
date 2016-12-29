package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.ingresso.dao.CinemaDao;
import br.com.caelum.ingresso.dto.CinemaDto;

@Controller
public class CinemaController {

	@Autowired
	private CinemaDao dao;
	
	@RequestMapping(value="/cinema", method=RequestMethod.GET)
	public String form(){
		return "cinema/cinema";
	}

	@RequestMapping(value="/cinema", method=RequestMethod.POST)
	public String salva(CinemaDto cinema){
		dao.adiciona(cinema.toCinema());
		return "adicionado";
	}
	
	@RequestMapping(value="/cinemas")
	public String lista(Model model){
		model.addAttribute("cinemas", dao.lista());
		return "cinema/lista";
	}
	
}
