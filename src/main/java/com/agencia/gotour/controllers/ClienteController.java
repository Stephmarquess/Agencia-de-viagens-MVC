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
import com.agencia.gotour.services.ClienteServices;

	@Controller
	@RequestMapping("/cliente")
	public class ClienteController {

		@Autowired
		private ClienteServices clienteServices;
		

		@GetMapping("/areaCliente")
		public String areaCliente (@PathVariable Long id, Model model) {
		List<Cliente> listarClientes =  clienteServices.buscarClientes();		
		model.addAttribute("clientes", listarClientes);
		return "areaCliente";
		}
							

		@GetMapping("/cadastro")
		public String cadastroCliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cadastroCliente";
		}
			

		@PostMapping("/cadastrar")
		public String cadastrarCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteServices.salvarCliente(cliente);
							
		return "areaCliente";
		}
			

		@GetMapping("/editar/{id}")
		public String editarClienteform(@PathVariable Long id, Model model) {
			Cliente cliente = clienteServices.buscarClienteporId(id);
			model.addAttribute("cliente", cliente);
			return "editarCliente";
		}
		
		@PostMapping("/editarCliente/{id}")
		public String editarUsuario(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {		
			clienteServices.atualizarCliente(id, cliente);
			return "areaCliente";
		}
		

		@GetMapping("/deletar/{id}")
		public String deletarCliente(@PathVariable Long id) {
			clienteServices.deletarCliente(id);
			return "areaCliente";
		}
	
	

}
