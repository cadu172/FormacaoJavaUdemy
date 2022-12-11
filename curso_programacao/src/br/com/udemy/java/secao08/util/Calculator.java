package br.com.udemy.java.secao08.util;

public class Calculator {
	
	public final double PI = 3.14;
	
	public double circumference(double p_Radius) {
		return 2.0 * this.PI * p_Radius;
	}
	
	public double volume(double p_Radius) {
		return 4.0 * this.PI * p_Radius * p_Radius * p_Radius / 3.0;
	}

	
}
