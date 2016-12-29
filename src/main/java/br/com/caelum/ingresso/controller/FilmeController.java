package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dto.FilmeDto;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmeDao dao;

	@RequestMapping(value="/filme", method=RequestMethod.GET)
	public String form(){
		return "filme";
	}

	@RequestMapping(value="/filme", method=RequestMethod.POST)
	public String salva(FilmeDto filme){
		dao.salva(filme.toFilme());
		return "adicionado";
	}
	
	@RequestMapping(value="/filmes")
	public String lista(Model model){
		model.addAttribute("filmes", dao.lista());
		return "lista";
	}
}
