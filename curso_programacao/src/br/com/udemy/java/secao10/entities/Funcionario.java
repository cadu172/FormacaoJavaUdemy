package br.com.udemy.java.secao10.entities;

public class Funcionario extends Pessoa {
	
	private int id;
	private float salary;
	
	public Funcionario(int p_id, float p_Salario, String p_Nome) {
		super(p_Nome, "");		
		this.id = p_id;
		this.salary = p_Salario;		
	}
	
	public void setAumentoSalario(Float p_PercAumento) {
		this.salary = this.salary*(1+p_PercAumento/100);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return this.getId() + ", " + this.getNome() + ", " + String.format("%.2f",this.getSalary());
	}

}
