package br.com.udemy.java.secao13.entities;

import java.util.ArrayList;
import java.util.Calendar;

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
	
	public void addContract(HourContract hourContract) {
		this.hourContract.add(hourContract);
	}

	public void removeContract(HourContract hourContract) {
		this.hourContract.remove(hourContract);
	}
	
	public Double income(int year, int month) {
		
		Double sum = this.baseSalary;
		
		Calendar cal = Calendar.getInstance();
		
		for (HourContract item : hourContract) {
			
			cal.setTime(item.getDate());
			
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == c_year && month == c_month) {
				sum += item.totalValue();
			}
		}
		
		return sum;
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


}
