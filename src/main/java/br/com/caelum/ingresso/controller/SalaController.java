package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.modelo.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalaController {

	@Autowired
	private SalaDao dao;
	
	@RequestMapping(value= "/sala", method=RequestMethod.GET)
	public String form(){
		return "sala/sala";
	}

	@RequestMapping(value="/sala", method=RequestMethod.POST)
	public String salva(Sala sala){
		dao.adiciona(sala);
		return "adicionado";
	}
	
	@RequestMapping(value="/salas")
	public String lista(Model model){
		model.addAttribute("salas", dao.lista());
		return "sala/lista";
	}
	
}
