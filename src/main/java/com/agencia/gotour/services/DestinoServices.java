package com.agencia.gotour.services;

import java.util.List;

import com.agencia.gotour.model.Destino;

public interface DestinoServices {

	List<Destino> buscarDestinos();
	
	Destino buscarDestinoporId(Long id);
	
	Destino salvarDestino(Destino destino);
	
	Destino atualizarDestino(Long id, Destino destinoAtualizado);
	
	void deletarDestino(Long id);
	
}
