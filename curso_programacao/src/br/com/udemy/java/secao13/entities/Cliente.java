package br.com.udemy.java.secao13.entities;

import java.util.Date;

public class Cliente {
	
	private String nome;
	private String email;
	private Date dataNascimento;	
	
	public Cliente(String nome, String email, Date dataNascimento) {		
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	

}
