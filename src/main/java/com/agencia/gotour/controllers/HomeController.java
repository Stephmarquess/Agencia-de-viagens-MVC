package com.agencia.gotour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String pagIndex (Model model) { 
		return "index";
	}
	
	@GetMapping("/login")
	public String pagLogin (Model model) { 
		return "login";
	}
	
	@GetMapping("/promocoes")
	public String pagPromocoes (Model model) { 
		return "promocoes";
	}
	
	@GetMapping("/destinos")
	public String pagDestinos (Model model) { 
		return "destinos";
	}
	
	@GetMapping("/contatos")
	public String pagContatos (Model model) { 
		return "contato";
	}
}