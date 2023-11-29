package com.agencia.gotour.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Reserva")
	
	public class Reserva {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 255)
		private String descricaoReserva;

		@Column(nullable = false)
		private LocalDate dataIda;
		
		@Column(nullable = false)
		private LocalDate dataVolta;
		
		@Column(nullable = false)
		private Double valor;
		
		@Column(nullable = false)
		private String tipoPagamento;
		
	    @ManyToOne
	    @JoinColumn(name = "idCliente")
	    private Cliente cliente;
	    
	    @ManyToOne
	    @JoinColumn(name = "idDestino")
	    private Destino destino;
			

		public Destino getDestino() {
			return destino;
		}

		public void setDestino(Destino destino) {
			this.destino = destino;
		}

		public Reserva() {
			super();
		}

	
		public Reserva(Long id, String descricaoReserva, LocalDate dataIda, LocalDate dataVolta, Double valor,
				String tipoPagamento, Cliente cliente, Destino destino) {
			super();
			this.id = id;
			this.descricaoReserva = descricaoReserva;
			this.dataIda = dataIda;
			this.dataVolta = dataVolta;
			this.valor = valor;
			this.tipoPagamento = tipoPagamento;
			this.cliente = cliente;
			this.destino = destino;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricaoReserva() {
			return descricaoReserva;
		}

		public void setDescricaoReserva(String descricaoReserva) {
			this.descricaoReserva = descricaoReserva;
		}

		public LocalDate getDataIda() {
			return dataIda;
		}

		public void setDataIda(LocalDate dataIda) {
			this.dataIda = dataIda;
		}

		public LocalDate getDataVolta() {
			return dataVolta;
		}

		public void setDataVolta(LocalDate dataVolta) {
			this.dataVolta = dataVolta;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public String getTipoPagamento() {
			return tipoPagamento;
		}

		public void setTipoPagamento(String tipoPagamento) {
			this.tipoPagamento = tipoPagamento;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
	
		
		
}
