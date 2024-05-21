package br.com.premiumtechnology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class Index {
	
	@RequestMapping("listar")
	public String home(Model model) {
		return "index";
	}
	
}
