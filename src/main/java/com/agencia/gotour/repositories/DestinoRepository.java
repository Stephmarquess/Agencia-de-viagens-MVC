package com.agencia.gotour.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gotour.model.Destino;
import com.agencia.gotour.model.Reserva;


@Repository
public interface DestinoRepository extends JpaRepository <Destino, Long> {

	List<Reserva> findByReservaId(Long idReserva);
	
}
