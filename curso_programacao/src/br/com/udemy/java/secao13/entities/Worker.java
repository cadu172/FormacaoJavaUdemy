package br.com.udemy.java.secao13.entities;

import java.util.ArrayList;

import br.com.udemy.java.secao13.entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private ArrayList<HourContract> hourContract;
	private Departament departament;
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
		
		// inicializar array de contratos
		hourContract = new ArrayList<HourContract>();
		
	}
	
	public void addHourContract(HourContract hourContract) {
		this.hourContract.add(hourContract);
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
	
	public ArrayList<HourContract> getHourContract() {
		return hourContract;
	}
	
	public Departament getDepartament() {
		return departament;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", hourContract="
				+ hourContract + ", departament=" + departament + "]";
	}
	

}
