package com.agencia.gotour.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Destino")
	
	public class Destino {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 255)
		private String nomeDestino;

		@Column(nullable = false, length = 255)
		private String descricaoDestino;
		
		@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)		 
	    @JoinColumn(name = "idDestino")
	    private List<Reserva> reserva;
		
		
		public Destino() {
			super();

		}

		public Destino(Long id, String nomeDestino, String descricaoDestino) {
			super();
			this.id = id;
			this.nomeDestino = nomeDestino;
			this.descricaoDestino = descricaoDestino;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomeDestino() {
			return nomeDestino;
		}

		public void setNomeDestino(String nomeDestino) {
			this.nomeDestino = nomeDestino;
		}

		public String getDescricaoDestino() {
			return descricaoDestino;
		}

		public void setDescricaoDestino(String descricaoDestino) {
			this.descricaoDestino = descricaoDestino;
		}

		public List<Reserva> getReserva() {
			return reserva;
		}

		public void setReserva(List<Reserva> reserva) {
			this.reserva = reserva;
		}

		
		
}
