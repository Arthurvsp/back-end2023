package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	private String sobre;
	
	
	
	public Usuario() {
		
	}
	
	
	public Long getUsuario_id() {
		return id;
	}
	
	public void setUsuario_id(Long usuario_id) {
		this.id = usuario_id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSobre() {
		return sobre;
	}
	
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	
	
	
	
}
