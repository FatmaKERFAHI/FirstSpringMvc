package org.eclipse.FirstSpringMvc.controller;

import org.eclipse.FirstSpringMvc.dao.PersonneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	@Autowired
	private PersonneRepository personneRepository;
	@GetMapping("/thymeleaf")
	public String showView(Model model) {
	model.addAttribute("message", "Hello World!");
	model.addAttribute("personne", personneRepository.findById((long) 1).orElse(null));
	model.addAttribute("personnes", personneRepository.findAll());
	return "thymeleaf/view";
	}
}
