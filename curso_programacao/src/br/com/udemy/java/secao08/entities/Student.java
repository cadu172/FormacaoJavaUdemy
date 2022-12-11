package br.com.udemy.java.secao08.entities;

public class Student {
	
	public double notaA;
	public double notaB;
	public double notaC;
	public String nome;
	public double notaFinal;
		
	private void calcularNota() {
		this.notaFinal += (notaA + notaB + notaC);
	}
	
	public String resultadoAvaliacao() {
		
		this.calcularNota();
		
		if ( this.notaFinal < 60 ) {
			return "FINAL GRADE: " + String.format("%.2f", this.notaFinal) + 
					"\nFAILED\nMISSING " + String.format("%.2f", 60-this.notaFinal);
		}
		else {
			return "FINAL GRADE: " + String.format("%.2f", this.notaFinal) + "\nPASS";
		}
		
	}

}
