package br.com.udemy.java.secao18.model.entities;

public abstract class Device {
	
	private String serialNumber;
	
	
	public Device(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public abstract void processDoc(String doc);

	public String getSerialNumber() {
		return serialNumber;
	}


}
