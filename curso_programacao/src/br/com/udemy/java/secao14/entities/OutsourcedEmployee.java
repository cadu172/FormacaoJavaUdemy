package br.com.udemy.java.secao14.entities;

public final class OutsourcedEmployee extends Employee {
	
	private float additionalCharge;

	public OutsourcedEmployee(String nome, int hours, float valuePerHour, float additionalCharge) {
		super(nome, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	@Override
	public final float payment() {
		// TODO Auto-generated method stub
		return super.payment()+this.additionalCharge;
	}	

}
