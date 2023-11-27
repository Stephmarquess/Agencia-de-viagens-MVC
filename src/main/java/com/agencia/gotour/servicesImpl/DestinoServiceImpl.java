package com.agencia.gotour.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.gotour.model.Destino;
import com.agencia.gotour.repositories.DestinoRepository;
import com.agencia.gotour.services.DestinoServices;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DestinoServiceImpl implements DestinoServices {

	@Autowired
	private DestinoRepository destinoRepository;
	
	@Override
	public List<Destino> buscarDestinos() {
		return destinoRepository.findAll();
	}

	
	@Override	
	@Transactional(readOnly = true)
	public Destino buscarDestinoporId(Long destinoId) {
		return destinoRepository.findById(destinoId).orElse(null);
	}

	@Override
	@Transactional
	public Destino salvarDestino(Destino destino) {
		return destinoRepository.save(destino);
	}

	@Override
	public Destino atualizarDestino(Long id, Destino destinoAtualizado) {
		Destino destinoExistente = destinoRepository.findById(id).orElse(null);
		if (destinoExistente != null) {
			destinoExistente.setNomeDestino(destinoAtualizado.getNomeDestino());
			destinoExistente.setDescricaoDestino(destinoAtualizado.getDescricaoDestino());			
			
			return destinoRepository.save(destinoExistente);
		} else {
			throw new RuntimeException("Destino com o ID " + id + "não encontrado!");
		}
	}

	@Override
	public void deletarDestino(Long id) {
		destinoRepository.deleteById(id);
	}

	
}
