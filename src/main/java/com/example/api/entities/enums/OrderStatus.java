package com.example.api.entities.enums;


public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	CANCELED(3);

	private int code;
	
	//Constructor
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//Método get
	public int getCode() {
		return code;
	}
	
	//Captar o código e transformar nos valores
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
}
