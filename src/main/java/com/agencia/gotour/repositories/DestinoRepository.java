package com.agencia.gotour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gotour.model.Destino;


@Repository
public interface DestinoRepository extends JpaRepository <Destino, Long> {

}
