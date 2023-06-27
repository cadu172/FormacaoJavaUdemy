package com.educandoweb.course.entities.enums;

public enum OrderStatus {	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	public int getCode() {
		return code;
	}

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public static OrderStatus valueOf(int code) {
		
		for (OrderStatus item : OrderStatus.values()) {
			if (  item.getCode() == code ) {
				return item;
			}
		}
		throw new IllegalArgumentException("Enum nao encontrado");
	}
}
