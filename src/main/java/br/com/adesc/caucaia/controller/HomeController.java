package br.com.adesc.caucaia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {
	
	private static String HOME = "Home";
	
	@GetMapping
	public ModelAndView start() {
		ModelAndView view = new ModelAndView(HOME);
		System.out.println(view);
		return view;
	}
}
