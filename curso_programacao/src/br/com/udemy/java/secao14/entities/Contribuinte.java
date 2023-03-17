package br.com.udemy.java.secao14.entities;

public abstract class Contribuinte {
	
	private String nome;
	private double rendaAnual;
	
	public Contribuinte(String nome, double rendaAnual) {		
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}
	
	public abstract double calcularImposto();
	
	public abstract double calcularAliquotaIR();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	

}
