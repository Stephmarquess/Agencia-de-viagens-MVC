package com.agencia.gotour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String Home (Model model) { 
		return "login";
	}
}