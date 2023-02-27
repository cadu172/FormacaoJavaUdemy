package br.com.udemy.java.secao13.entities;

import java.util.ArrayList;
import java.time.LocalDateTime;

import br.com.udemy.java.secao13.entities.enums.StatusPedido;


public class Pedido {
	
	private LocalDateTime dataHoraPedido;	
	private StatusPedido status;
	private ArrayList<PedidoItem> items = new ArrayList<PedidoItem>();
	private Cliente cliente;
	
	public Pedido(LocalDateTime dataHoraPedido, StatusPedido status, Cliente cliente) {		
		this.dataHoraPedido = dataHoraPedido;
		this.status = status;
		this.cliente= cliente;
	}

	public void addItem(PedidoItem pedidoItem) {
		items.add(pedidoItem);
	}
	
	public void removeItem(PedidoItem pedidoItem) {
		items.remove(pedidoItem);
	}
	
	public Double total() {
		
		Double soma = 0d;
		
		for (PedidoItem pedidoItem : items) {
			soma += pedidoItem.subTotal();
		}
		
		
		return soma;
	}


	public LocalDateTime getDataHoraPedido() {
		return dataHoraPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}
	


}
