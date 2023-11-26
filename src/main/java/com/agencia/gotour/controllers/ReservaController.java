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

import com.agencia.gotour.model.Reserva;
import com.agencia.gotour.services.ReservaServices;


	@Controller
	@RequestMapping("/reserva")
	
	public class ReservaController {

		@Autowired
		private ReservaServices reservaServices;
		

		@GetMapping("/areaReserva")
		public String areaReserva (@PathVariable Long id, Model model) {
		List<Reserva> listarReservas =  reservaServices.buscarReservas();		
		model.addAttribute("reservas", listarReservas);
		return "areaReserva";
		}
							

		@GetMapping("/cadastro")
		public String cadastroReservaform(Model model) {
		Reserva reserva = new Reserva();
		model.addAttribute("reserva", reserva);
		return "cadastroReserva";
		}
			

		@PostMapping("/cadastrar")
		public String cadastrarReserva(@ModelAttribute("reserva") Reserva reserva) {
		reservaServices.salvarReserva(reserva);
							
		return "areaReserva";
		}
			

		@GetMapping("/editar/{id}")
		public String editarReservaform(@PathVariable Long id, Model model) {
			Reserva reserva = reservaServices.buscarReservaporId(id);
			model.addAttribute("reserva", reserva);
			return "editarReserva";
		}
		
		@PostMapping("/editarReserva/{id}")
		public String editarReserva(@PathVariable Long id, @ModelAttribute("reserva") Reserva reserva) {		
			reservaServices.atualizarReserva(id, reserva);
			return "areaReserva";
		}
		

		@GetMapping("/deletar/{id}")
		public String deletarReserva(@PathVariable Long id) {
			reservaServices.deletarReserva(id);
			return "areaReserva";
		}
	
	
	}
	

