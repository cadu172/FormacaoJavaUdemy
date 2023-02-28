package br.com.udemy.java.secao13.entities;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.udemy.java.secao13.entities.enums.StatusPedido;


public class Pedido {
	
	private LocalDateTime dataHoraPedido;	
	private StatusPedido status;
	private ArrayList<PedidoItem> items = new ArrayList<PedidoItem>();
	private Cliente cliente;
	
	public Pedido(StatusPedido status, Cliente cliente) {		
		this.dataHoraPedido = LocalDateTime.now();
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

	@Override
	public String toString() {
		
		
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		sb.append("\n------------------------------------------\n");
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + getDataHoraPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: "+getCliente().getNome()+" ("+sdf.format(getCliente().getDataNascimento())+") - "+getCliente().getEmail() + "\n");
		sb.append("Order items:\n");

		for (PedidoItem pedidoItem : items) {
			sb.append(
					pedidoItem.getProduto().getNome() + "," + 
					String.format("%.2f", pedidoItem.getPreco())  + "," + 	
					"Quantity:" + pedidoItem.getQuantidade() + "," +
					"Subtotal:" + String.format("%.2f", pedidoItem.subTotal()) + "\n");
		}
		
		sb.append("Total price: " + String.format("%.2f", this.total()) + "\n");

		return sb.toString();		
		
	}
	
	
	
	


}
