package org.eclipse.FirstSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

	@GetMapping(value = "/hello")
	public String sayHello(Model model) {
		model.addAttribute("nom", "Wick");
		return "jsp/hello";
	}
	
	@GetMapping(value="/helloMV")
	public ModelAndView sayHello(ModelAndView mv) {
	mv.setViewName("jsp/hello");
	mv.addObject("nom", "modelAndView");
	return mv;
	}
}
