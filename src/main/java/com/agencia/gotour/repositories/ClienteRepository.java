package com.agencia.gotour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.gotour.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
