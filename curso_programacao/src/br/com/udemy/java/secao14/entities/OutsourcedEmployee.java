package br.com.udemy.java.secao14.entities;

public final class OutsourcedEmployee extends Employee {
	
	private Double additionalCharge;

	public OutsourcedEmployee(String nome, int hours, Double valuePerHour, Double additionalCharge) {
		super(nome, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	@Override
	public final Double payment() {
		// TODO Auto-generated method stub
		return super.payment()+(this.additionalCharge*1.10f);
	}

}
