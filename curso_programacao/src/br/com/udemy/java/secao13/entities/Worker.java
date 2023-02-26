package br.com.udemy.java.secao13.entities;

import java.util.ArrayList;

import br.com.udemy.java.secao13.entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private ArrayList<HourContract> hourContract;
	private Departament departament;
	private int year;
	private int month;
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
		
		// inicializar array de contratos
		hourContract = new ArrayList<HourContract>();
		
	}
	
	public void addContract(HourContract hourContract) {
		this.hourContract.add(hourContract);
	}

	public void removeContract(HourContract hourContract) {
		this.hourContract.add(hourContract);
	}
	
	public Double income(int year, int month) {
		this.year = year;
		this.month = month;
		return 458.214d;
	}

	
	public String getName() {
		return name;
	}
	
	public WorkerLevel getLevel() {
		return level;
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public Departament getDepartament() {
		return departament;
	}
	
	public float getTotalContract() {
		
		float sumContract = 0.0f;
		
		for (HourContract hourContract2 : hourContract) {
			sumContract += hourContract2.totalValue();			
		}
		
		return sumContract;
		
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + 
				"\nDepartament: " + this.departament.getName() + 
				"\nIncome for "+this.month+"/"+this.year+": " + String.format("%.2f", this.getTotalContract()) ;
	}
	

}
