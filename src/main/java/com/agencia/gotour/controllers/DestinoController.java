package com.agencia.gotour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agencia.gotour.model.Destino;


import com.agencia.gotour.services.DestinoServices;


@Controller
@RequestMapping("/destino")
public class DestinoController {
	
	@Autowired
	private DestinoServices destinoServices;
	

	@GetMapping("/areaDestino")
	public String areaDestino (@PathVariable Long id, Model model) {
	List<Destino> listarDestinos =  destinoServices.buscarDestinos();		
	model.addAttribute("destinos", listarDestinos);
	return "areaReserva";
	}
						

	@GetMapping("/cadastro")
	public String cadastroDestinoform(Model model) {
	Destino destino = new Destino();
	model.addAttribute("destino", destino);
	return "cadastroDestino";
	}
		

	@PostMapping("/cadastrar")
	public String cadastrarDestino(@ModelAttribute("destino") Destino destino) {
	destinoServices.salvarDestino(destino);
						
	return "areaDestino";
	}
		

	@GetMapping("/editar/{id}")
	public String editarDestinoform(@PathVariable Long id, Model model) {
		Destino destino = destinoServices.buscarDestinoporId(id);
		model.addAttribute("destino", destino);
		return "editarDestino";
	}
	
	@PostMapping("/editarDestino/{id}")
	public String editarDestino(@PathVariable Long id, @ModelAttribute("destino") Destino destino) {		
		destinoServices.atualizarDestino(id, destino);
		return "areaDestino";
	}
	

	@GetMapping("/deletar/{id}")
	public String deletarDestino(@PathVariable Long id) {
		destinoServices.deletarDestino(id);
		return "areaDestino";
	}


}
