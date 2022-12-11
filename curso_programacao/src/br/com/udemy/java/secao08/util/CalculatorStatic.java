package br.com.udemy.java.secao08.util;

public class CalculatorStatic {
	
	public static final double PI = 3.14;
	
	public static double circumference(double p_Radius) {
		return 2.0 * PI * p_Radius;
	}
	
	public static double volume(double p_Radius) {
		return 4.0 * PI * p_Radius * p_Radius * p_Radius / 3.0;
	}

	
}
