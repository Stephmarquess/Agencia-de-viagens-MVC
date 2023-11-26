package com.agencia.gotour.services;

import java.util.List;

import com.agencia.gotour.model.Reserva;

public interface ReservaServices {

	List<Reserva> buscarReservas();
	
	Reserva buscarReservaporId(Long id);
	
	Reserva salvarReserva(Reserva reserva);
	
	Reserva atualizarReserva(Long id, Reserva reservaAtualizada);
	
	void deletarReserva(Long id);
	
}
