package br.com.udemy.java.secao13.entities;

import java.util.Date;

import br.com.udemy.java.secao13.entities.enums.OrderStatus;

public class Order {
	private Integer id;
	private Date dataHora;
	private OrderStatus status;
	
	public Order() {		
	}

	public Order(Integer id, Date dataHora, OrderStatus status) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dataHora=" + dataHora + ", status=" + status + "]";
	}
	

}
