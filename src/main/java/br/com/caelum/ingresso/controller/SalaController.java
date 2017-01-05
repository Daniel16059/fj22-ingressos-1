package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.modelo.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SalaController {

	@Autowired
	private SalaDao dao;
	
	@RequestMapping(value= "/sala", method=RequestMethod.GET)
	public String form(Sala sala){
		return "sala/sala";
	}

	@RequestMapping(value="/sala", method=RequestMethod.POST)
	public String salva(@Valid  Sala sala, BindingResult result, Model model){

		if (result.hasErrors()){
			model.addAttribute("result", result );
			return form(sala);
		}

		dao.adiciona(sala);
		return "adicionado";
	}
	
	@RequestMapping(value="/salas")
	public String lista(Model model){
		model.addAttribute("salas", dao.lista());
		return "sala/lista";
	}
	
}
