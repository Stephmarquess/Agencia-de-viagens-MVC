package com.agencia.gotour.services;

import java.util.List;

import com.agencia.gotour.model.Cliente;

public interface ClienteServices {

	List<Cliente> buscarClientes();
	
	
	Cliente buscarClienteporId(Long id);
	
	Cliente salvarCliente(Cliente cliente);
	
	List<Cliente> findClientebyName(String nomeCliente);
	
	Cliente atualizarCliente(Long id, Cliente clienteAtualizado);
	
	void deletarCliente(Long id);

	
	
}
