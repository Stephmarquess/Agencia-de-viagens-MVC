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

import com.agencia.gotour.model.Cliente;
import com.agencia.gotour.model.Destino;
import com.agencia.gotour.model.Reserva;
import com.agencia.gotour.services.ClienteServices;
import com.agencia.gotour.services.DestinoServices;
import com.agencia.gotour.services.ReservaServices;


	@Controller
	@RequestMapping("/reserva")
	
	public class ReservaController {

		@Autowired
		private ReservaServices reservaServices;
		@Autowired
		private ClienteServices clienteServices;
		@Autowired
		private DestinoServices destinoServices;

		@GetMapping
		public String areaReserva (Model model) {
		List<Reserva> listarReservas =  reservaServices.buscarReservas();		
		model.addAttribute("reservas", listarReservas);
		return "areaReserva";
		}
							

		@GetMapping("/cadastro")
		public String cadastroReservaform(Model model) {
		
		Reserva reserva = new Reserva();
		model.addAttribute("reserva", reserva);
		List<Cliente> listaClientes = clienteServices.buscarClientes();
		model.addAttribute("cliente", listaClientes);
		List<Destino> listaDestinos = destinoServices.buscarDestinos();
		model.addAttribute("destino", listaDestinos);		
		
		return "cadastroReserva";
		}
			

		@PostMapping("/cadastrar")
		public String cadastrarReserva(@ModelAttribute("reserva") Reserva reserva) {
		reservaServices.salvarReserva(reserva);							
		return "listarReserva";
		}
		
		@GetMapping("/listarReserva")
		public String editarReservaform(Model model) {			
			List<Reserva> listaReservas = reservaServices.buscarReservas();
			model.addAttribute("reservas", listaReservas);
			return "listarReserva";
		}
			
		@GetMapping("/editarReserva/{id}")
		public String editarReservaform(@PathVariable Long id, Model model) {
			Reserva reserva = reservaServices.buscarReservaporId(id);
			model.addAttribute("reserva", reserva);
			List<Cliente> listaClientes = clienteServices.buscarClientes();
			model.addAttribute("cliente", listaClientes);
			List<Destino> listaDestinos = destinoServices.buscarDestinos();
			model.addAttribute("destino", listaDestinos);	
			return "editarReserva";
		}
		
		@PostMapping("/editarReserva/{id}")
		public String editarReserva(@PathVariable Long id, @ModelAttribute("reserva") Reserva reserva) {		
			reservaServices.atualizarReserva(id, reserva);
			return "listaReserva";
		}
		

		@GetMapping("/deletar/{id}")
		public String deletarReserva(@PathVariable Long id) {
			reservaServices.deletarReserva(id);
			return "areaReserva";
		}
	
	
	}
	

