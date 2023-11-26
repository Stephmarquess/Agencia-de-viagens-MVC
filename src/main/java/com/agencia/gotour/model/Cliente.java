package com.agencia.gotour.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "Cliente")
	
	public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false, length = 255)
		private String nomeCliente;

		@Column(nullable = false, length = 14, unique = true)
		private String cpf;
		
		@Column(nullable = false, length = 80, unique = true)
	    private String email;
		
		@Column(nullable = false, length = 80, unique = true)
	    private String telefone;
		
		@Column(nullable = false, length = 255, unique = true)
	    private String endereco;
		
		@Column(nullable = false, length = 50)
		private String senha;
		

		public Cliente(Long id, String nomeCliente, String cpf, String email, String telefone, String endereco,
				String senha) {
		
			this.id = id;
			this.nomeCliente = nomeCliente;
			this.cpf = cpf;
			this.email = email;
			this.telefone = telefone;
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

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
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
				
		

	}

