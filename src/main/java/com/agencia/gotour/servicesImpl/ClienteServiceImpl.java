package com.agencia.gotour.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.gotour.model.Cliente;
import com.agencia.gotour.repositories.ClienteRepository;
import com.agencia.gotour.services.ClienteServices;

import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> buscarClientes() {
		return clienteRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Cliente buscarClienteporId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		if (clienteExistente != null) {
			clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
			clienteExistente.setEmail(clienteAtualizado.getEmail());
			clienteExistente.setCpf(clienteAtualizado.getCpf());
			clienteExistente.setTelefone(clienteAtualizado.getTelefone());
			clienteExistente.setEndereco(clienteAtualizado.getEndereco());
			return clienteRepository.save(clienteExistente);
		} else {
			throw new RuntimeException("Usuario com o ID " + id + "não encontrado.");
		}
	}

	@Override
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	
	
}
