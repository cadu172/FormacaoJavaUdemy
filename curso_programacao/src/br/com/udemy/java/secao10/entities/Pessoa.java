package br.com.udemy.java.secao10.entities;

public class Pessoa {

	private String nome;
	private int idade;
	private float altura;
	
	public Pessoa(String nome, int idade, float altura) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public float getAltura() {
		return altura;
	}
	
}
