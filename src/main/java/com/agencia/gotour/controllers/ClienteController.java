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
import com.agencia.gotour.model.Reserva;
import com.agencia.gotour.repositories.ReservaRepository;
import com.agencia.gotour.services.ClienteServices;

	@Controller
	@RequestMapping("/cliente")
	public class ClienteController {

		@Autowired
		private ClienteServices clienteServices;
		@Autowired
		private ReservaRepository reservaRepository;
		
		@GetMapping
		public String areaCliente() {			
			return "areaCliente";
			}

		@GetMapping("/cadastro")
		public String cadastroClienteform(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cadastroCliente";
		}
			

		@PostMapping("/cadastrar")		
		public String cadastrarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServices.salvarCliente(cliente);
		return "SucessoCadastroCliente";
		}			
		

		@GetMapping("/listarCliente")
		public String areaCliente (Model model) {
		List<Cliente> listarClientes =  clienteServices.buscarClientes();		
		model.addAttribute("clientes", listarClientes);
		return "listarCliente";
		}
		
		@GetMapping("/detalharCliente/{id}")
		public String detalharCliente (@PathVariable (value= "id") Long id, Model model) {
		Cliente clienteLocalizado =  clienteServices.buscarClienteporId(id);		
		model.addAttribute("cliente", clienteLocalizado);
		
		List<Reserva> reservas = reservaRepository.findByClienteId(id);	
		model.addAttribute("reservas", reservas);
		
		return "detalhesClientes";
		}

		@GetMapping("/editarCliente/{id}")
		public String formEditarCliente(@PathVariable Long id, Model model) {
			Cliente cliente = clienteServices.buscarClienteporId(id);
			model.addAttribute("cliente", cliente);
			return "editarCliente";
		}
		
		@PostMapping("/editarCliente/{id}")
		public String editarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {		
			clienteServices.atualizarCliente(id, cliente);			
			return "detalhesClientes";
		}
		

		@GetMapping("/deletarCliente/{id}")
		public String deletarCliente(@PathVariable Long id) {
			clienteServices.deletarCliente(id);
			return "deletadoCliente";
		}
	
	

}
