package br.com.udemy.java.secao08.entities;

public class Employee {

	public String name;
	public double grossSalary;
	public double tax;
	
	public double netSalary() { 
		return this.grossSalary - this.tax;
	}
	
	public double increaseSalary(double p_Percentage) {
		
		this.grossSalary = this.grossSalary * (1 + p_Percentage / 100);
		
		return this.grossSalary;
	}
	
	public String toString() {
		return  this.name + ", $ " + String.format("%.2f", this.netSalary());
	}	
	
}
