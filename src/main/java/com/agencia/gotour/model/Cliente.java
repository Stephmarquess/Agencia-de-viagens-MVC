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
@Table(name = "Cliente")
	
	public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 255)
		private String nomeCliente;

		@Column(nullable = false, length = 14)
		private String cpf;
		
		@Column(nullable = false, length = 80)
	    private String email;

		
		@Column(nullable = false, length = 255)
	    private String endereco;
		
		@Column(nullable = false, length = 50)
		private String senha;
		
		
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idCliente")
	    private List<Reserva> reservas;
		
	    
	    		

		public Cliente(Long id, String nomeCliente, String cpf, String email, String endereco,
				String senha) {
		
			this.id = id;
			this.nomeCliente = nomeCliente;
			this.cpf = cpf;
			this.email = email;

			this.endereco = endereco;
			this.senha = senha;
		}

		public Cliente() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomeCliente() {
			return nomeCliente;
		}

		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Reserva> getReservas() {
			return reservas;
		}

		public void setReservas(List<Reserva> reservas) {
			this.reservas = reservas;
		}	
				
		

	}

