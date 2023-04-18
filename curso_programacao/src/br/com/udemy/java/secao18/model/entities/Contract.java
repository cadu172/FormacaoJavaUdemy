package br.com.udemy.java.secao18.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<Installment>();
	
	public Contract(Integer number, LocalDate date, Double totalValue) {		
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	public void add(Installment installment) {
		this.installments.add(installment);
	}
	
	@Override
	public String toString() {
		
		StringBuilder returnString = new StringBuilder();	
		
		returnString.append("\n");
		returnString.append("Parcelas:");
		returnString.append("\n");
		
		for ( Installment item : installments ) {
			returnString.append(item + "\n" );
		}
		
		return returnString.toString();
	}
	

}
