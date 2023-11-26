package com.agencia.gotour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gotour.model.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
