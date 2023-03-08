package br.com.udemy.java.secao14.entities;

public class Employee {
	
	private String nome;
	private int hours;
	private Double valuePerHour;
	
	public Employee(String nome, int hours, Double valuePerHour) {		
		this.nome = nome;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}
	
	public Double payment() {
		return this.valuePerHour*this.hours;
	}

	public String getNome() {
		return nome;
	}

}
