package br.com.udemy.java.secao10.entities;

public class Pessoa {

	private String nome;
	private int idade;
	private float altura;
	private String email;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa(String nome, int idade, float altura) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
	}
	
	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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
	
    public String toString() {
    	return this.getNome() + ", " + this.getEmail();
    }

}
