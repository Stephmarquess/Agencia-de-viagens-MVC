package com.agencia.gotour.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.gotour.model.Reserva;
import com.agencia.gotour.repositories.ReservaRepository;
import com.agencia.gotour.services.ReservaServices;

import org.springframework.transaction.annotation.Transactional;

	@Service
	public class ReservaServiceImpl implements ReservaServices {

		@Autowired
		private ReservaRepository reservaRepository;
		
		@Override
		public List<Reserva> buscarReservas() {
			return reservaRepository.findAll();
		}

		@Override
		@Transactional(readOnly = true)
		public Reserva buscarReservaporId(Long id) {
			return reservaRepository.findById(id).orElse(null);
		}

		@Override
		@Transactional
		public Reserva salvarReserva(Reserva reserva) {
			return reservaRepository.save(reserva);
		}

		@Override
		public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
			Reserva reservaExistente = reservaRepository.findById(id).orElse(null);
			if (reservaExistente != null) {
				reservaExistente.setDescricaoReserva(reservaAtualizada.getDescricaoReserva());
				reservaExistente.setCliente(reservaAtualizada.getCliente());
				reservaExistente.setDestino(reservaAtualizada.getDestino());				
				reservaExistente.setDataIda(reservaAtualizada.getDataIda());
				reservaExistente.setDataVolta(reservaAtualizada.getDataVolta());
				reservaExistente.setValor(reservaAtualizada.getValor());
				reservaExistente.setTipoPagamento(reservaAtualizada.getTipoPagamento());
				return reservaRepository.save(reservaExistente);
			} else {
				throw new RuntimeException("Reserva com o ID " + id + "não encontrado.");
			}
		}
		
		@Override
		public void deletarReserva(Long id) {
			reservaRepository.deleteById(id);
		}
	
}
	
